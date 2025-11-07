pipeline {
    agent any
    
    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }
    
    environment {
        // Infrastructure URLs
        NEXUS_URL = '3.110.226.20'
        SONARQUBE_URL = '13.203.26.99'
        JENKINS_URL = '3.110.149.188'
        
        // Use Docker Hub instead of Nexus Docker registry
        DOCKER_REGISTRY = "docker.io"
        DOCKER_NAMESPACE = "saifudheenpv"  // Replace with your Docker Hub username
        NEXUS_REPO_URL = "${NEXUS_URL}:8081"
        
        // Repository Names
        MAVEN_REPO_NAME = "maven-releases"
        
        // Credentials
        KUBECONFIG = credentials('kubeconfig')
        SONAR_TOKEN = credentials('sonar-token')
        NEXUS_CREDS = credentials('nexus-creds')  // For Maven artifacts only
        DOCKER_CREDS = credentials('docker-token') // Your Docker Hub credentials
        GITHUB_CREDS = credentials('github-token')
        
        // Application Configuration
        APP_NAME = 'hotel-booking-system'
        APP_VERSION = "${env.BUILD_ID}"
        K8S_NAMESPACE = 'hotel-booking'
        
        // Maven Configuration
        MAVEN_OPTS = '-Xmx1024m -XX:MaxPermSize=256m'
    }
    
    stages {
        // STAGE 1: CODE CHECKOUT FROM GITHUB
        stage('GitHub Checkout') {
            steps {
                echo "📦 Checking out code from GitHub repository..."
                git branch: 'main', 
                url: 'https://github.com/saifudheenpv/Hotel-Booking-System.git',
                credentialsId: 'github-token'
                
                sh '''
                    echo "=== CODE CHECKOUT COMPLETED ==="
                    echo "Repository: Hotel-Booking-System"
                    echo "Branch: main"
                    echo "Build ID: ${BUILD_ID}"
                    ls -la
                '''
            }
        }
        
        // STAGE 2: MAVEN COMPILE
        stage('Maven Compile') {
            steps {
                echo "🔨 Compiling source code with Maven..."
                sh 'mvn compile -DskipTests'
                
                sh 'echo "✅ Code compilation completed successfully"'
            }
        }
        
        // STAGE 3: UNIT TESTS EXECUTION
        stage('Unit Tests') {
            steps {
                echo "🧪 Running unit tests with Maven..."
                sh 'mvn test -Dspring.profiles.active=test'
            }
            post {
                always {
                    echo "📊 Publishing test results..."
                    junit 'target/surefire-reports/*.xml'
                    
                    sh '''
                        echo "=== TEST RESULTS ==="
                        find target/surefire-reports -name "*.txt" -exec echo "Test File: {}" \\;
                    '''
                }
                success {
                    echo "✅ All tests passed!"
                }
                failure {
                    echo "❌ Tests failed! Check test reports."
                    error("Unit tests failed - check test reports")
                }
            }
        }
        
        // STAGE 4: SONARQUBE CODE QUALITY
        stage('SonarQube Analysis') {
            steps {
                echo "🔍 Running SonarQube code analysis..."
                withSonarQubeEnv('sonarqube-server') {
                    sh """
                    mvn sonar:sonar \
                      -Dsonar.projectKey=hotel-booking-system \
                      -Dsonar.projectName='Hotel Booking System' \
                      -Dsonar.host.url=http://${SONARQUBE_URL}:9000 \
                      -Dsonar.login=${SONAR_TOKEN} \
                      -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml \
                      -Dsonar.java.binaries=target/classes \
                      -Dsonar.sourceEncoding=UTF-8
                    """
                }
            }
        }
        
        // STAGE 5: QUALITY GATE CHECK
        stage('Quality Gate') {
            steps {
                echo "🚦 Checking SonarQube Quality Gate..."
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
                echo "✅ Quality Gate passed!"
            }
        }
        
        // STAGE 6: DEPENDENCY CHECK (OWASP)
        stage('Dependency Check') {
            steps {
                echo "🔒 Running OWASP Dependency Check..."
                sh '''
                    mvn org.owasp:dependency-check-maven:check \
                    -DskipTests \
                    -Dformat=HTML \
                    -Dformat=XML
                '''
                
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
            post {
                always {
                    echo "📋 OWASP Dependency check completed."
                }
            }
        }
        
        // STAGE 7: MAVEN BUILD PACKAGE
        stage('Maven Build Package') {
            steps {
                echo "📦 Building application package..."
                sh 'mvn clean package -DskipTests'
                
                echo "✅ Application packaged successfully!"
                archiveArtifacts 'target/*.jar'
                
                sh '''
                    echo "=== BUILD ARTIFACTS ==="
                    ls -la target/*.jar
                    echo "JAR File: target/${APP_NAME}-*.jar"
                '''
            }
        }
        
        // STAGE 8: NEXUS ARTIFACT PUBLISH (Maven only)
        stage('Nexus Publish Artifact') {
            steps {
                echo "📤 Publishing Maven artifact to Nexus..."
                script {
                    // Get the actual JAR file name
                    def jarFile = sh(script: 'ls target/*.jar', returnStdout: true).trim()
                    
                    nexusArtifactUploader(
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        nexusUrl: "${NEXUS_REPO_URL}",
                        groupId: 'com.hotel',
                        version: "${APP_VERSION}",
                        repository: "${MAVEN_REPO_NAME}",
                        credentialsId: 'nexus-creds',
                        artifacts: [
                            [artifactId: "${APP_NAME}",
                             classifier: '',
                             file: "${jarFile}",
                             type: 'jar']
                        ]
                    )
                }
                echo "✅ Maven artifact published to Nexus successfully!"
            }
        }
        
        // STAGE 9: DOCKER BUILD AND TAG (Using Docker Hub)
        stage('Docker Build and Tag') {
            steps {
                echo "🐳 Building Docker image for Docker Hub..."
                script {
                    // Login to Docker Hub
                    sh """
                    docker login -u ${DOCKER_CREDS_USR} -p ${DOCKER_CREDS_PSW}
                    """
                    
                    // Build Docker image
                    sh """
                    docker build -t ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} .
                    docker tag ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} ${DOCKER_NAMESPACE}/${APP_NAME}:latest
                    """
                    
                    echo "✅ Docker image built and tagged successfully!"
                    sh "docker images | grep ${APP_NAME}"
                }
            }
        }
        
        // STAGE 10: TRIVY DOCKER IMAGE SCAN
        stage('Trivy Security Scan') {
            steps {
                echo "🔍 Running Trivy security scan on Docker image..."
                script {
                    // Install trivy if not present
                    sh '''
                    if ! command -v trivy &> /dev/null; then
                        echo "Installing Trivy..."
                        wget https://github.com/aquasecurity/trivy/releases/download/v0.45.1/trivy_0.45.1_Linux-64bit.deb
                        sudo dpkg -i trivy_0.45.1_Linux-64bit.deb
                    fi
                    '''
                    
                    // Run security scan
                    sh """
                    # Generate HTML report
                    trivy image --format template --template "@contrib/gitlab.tpl" --output trivy-security-report.html ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}
                    
                    # Fail build on critical vulnerabilities
                    trivy image --exit-code 1 --severity CRITICAL ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}
                    """
                    
                    echo "✅ Security scan completed!"
                }
            }
        }
        
        // STAGE 11: DOCKER PUSH TO DOCKER HUB
        stage('Docker Push') {
            steps {
                echo "📤 Pushing Docker image to Docker Hub..."
                script {
                    sh """
                    docker push ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}
                    docker push ${DOCKER_NAMESPACE}/${APP_NAME}:latest
                    """
                    
                    echo "✅ Docker images pushed to Docker Hub successfully!"
                    sh "echo 'Images available at: https://hub.docker.com/r/${DOCKER_NAMESPACE}/${APP_NAME}'"
                }
            }
        }
        
        // STAGE 12: DEPLOY TO KUBERNETES
        stage('Deploy to Kubernetes') {
            steps {
                echo "🚀 Deploying to Kubernetes cluster..."
                script {
                    // Create namespace
                    sh """
                    kubectl apply -f k8s/namespace.yaml
                    """
                    
                    // Deploy MySQL
                    sh """
                    kubectl apply -f k8s/mysql-deployment.yaml -n ${K8S_NAMESPACE}
                    kubectl apply -f k8s/mysql-service.yaml -n ${K8S_NAMESPACE}
                    """
                    
                    // Wait for MySQL
                    sh """
                    echo "⏳ Waiting for MySQL to be ready..."
                    for i in {1..30}; do
                        if kubectl get pods -n ${K8S_NAMESPACE} -l app=mysql | grep -q Running; then
                            echo "✅ MySQL is ready!"
                            break
                        fi
                        echo "⏱️ Waiting for MySQL... (attempt \$i/30)"
                        sleep 10
                    done
                    """
                    
                    // Update deployment with current image tag
                    sh """
                    sed -i 's|image:.*|image: ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}|g' k8s/app-deployment-blue.yaml
                    """
                    
                    // Deploy application
                    sh """
                    kubectl apply -f k8s/app-deployment-blue.yaml -n ${K8S_NAMESPACE}
                    kubectl apply -f k8s/app-service.yaml -n ${K8S_NAMESPACE}
                    """
                    
                    echo "✅ Application deployed to Kubernetes!"
                }
            }
        }
        
        // STAGE 13: POST-DEPLOYMENT VERIFICATION
        stage('Health Check & Verification') {
            steps {
                echo "🏥 Running health checks..."
                script {
                    // Wait for application
                    sh """
                    echo "⏳ Waiting for application pods to be ready..."
                    for i in {1..30}; do
                        if kubectl get pods -n ${K8S_NAMESPACE} -l app=hotel-booking | grep -q Running; then
                            echo "✅ Application pods are ready!"
                            break
                        fi
                        echo "⏱️ Waiting for application pods... (attempt \$i/30)"
                        sleep 10
                    done
                    
                    sleep 30
                    """
                    
                    // Health check
                    sh """
                    # Get service details
                    echo "=== Kubernetes Deployment Status ==="
                    kubectl get svc -n ${K8S_NAMESPACE}
                    kubectl get pods -n ${K8S_NAMESPACE}
                    
                    # Simple health check using port-forward
                    timeout 60s kubectl port-forward svc/hotel-booking-service 8080:8080 -n ${K8S_NAMESPACE} &
                    sleep 10
                    
                    if curl -f http://localhost:8080/actuator/health; then
                        echo "✅ Health check passed!"
                        pkill -f "kubectl port-forward"
                    else
                        echo "❌ Health check failed!"
                        pkill -f "kubectl port-forward"
                        exit 1
                    fi
                    """
                }
            }
        }
    }
    
    post {
        always {
            echo "📋 Pipeline execution completed!"
            
            // Publish reports
            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: '.',
                reportFiles: 'trivy-security-report.html',
                reportName: 'Trivy Security Report'
            ])
            
            // Cleanup
            sh """
            docker rmi ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} || true
            docker rmi ${DOCKER_NAMESPACE}/${APP_NAME}:latest || true
            """
            cleanWs()
        }
        success {
            echo "🎉 Pipeline executed successfully!"
            
            sh """
            echo "=== DEPLOYMENT SUCCESS ==="
            echo "Application: ${APP_NAME}"
            echo "Version: ${APP_VERSION}"
            echo "Docker Image: ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}"
            echo "Kubernetes Namespace: ${K8S_NAMESPACE}"
            echo "Build URL: ${BUILD_URL}"
            """
            
            emailext (
                subject: "SUCCESS: Pipeline '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                body: """
                🎉 CICD Pipeline Completed Successfully!
                
                Application: Hotel Booking System
                Build Number: ${env.BUILD_NUMBER}
                Version: ${APP_VERSION}
                
                📊 Deployment Information:
                - Docker Image: ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}
                - Kubernetes Namespace: ${K8S_NAMESPACE}
                - Build URL: ${env.BUILD_URL}
                
                🔗 Useful Links:
                - Jenkins: http://${JENKINS_URL}:8080
                - SonarQube: http://${SONARQUBE_URL}:9000
                - Nexus: http://${NEXUS_URL}:8081
                - Docker Hub: https://hub.docker.com/r/${DOCKER_NAMESPACE}/${APP_NAME}
                
                Next: Perform smoke tests and monitor application metrics.
                """,
                to: "mesaifudheenpv@gmail.com"
            )
        }
        failure {
            echo "❌ Pipeline failed!"
            
            emailext (
                subject: "FAILED: Pipeline '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                body: """
                ❌ CICD Pipeline Failed!
                
                Application: Hotel Booking System
                Build Number: ${env.BUILD_NUMBER}
                
                Please check the Jenkins console output for details:
                ${env.BUILD_URL}
                
                Common issues:
                - Unit test failures
                - SonarQube quality gate failure
                - Docker build issues
                - Kubernetes deployment errors
                """,
                to: "mesaifudheenpv@gmail.com"
            )
        }
    }
}