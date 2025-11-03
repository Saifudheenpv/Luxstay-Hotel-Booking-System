pipeline {
    agent any
    
    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }
    
    triggers {
        pollSCM('H/5 * * * *')
    }
    
    environment {
        // Credentials
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
        SONAR_TOKEN = credentials('sonar-token')
        NEXUS_CREDENTIALS = credentials('nexus-creds')
        
        // Application Configuration
        REGISTRY = 'saifudheenpv'
        APP_NAME = 'hotel-booking-system'
        VERSION = "${env.BUILD_NUMBER}"
        NEXUS_URL = '13.201.212.39:8081'
        SONAR_URL = 'http://13.233.38.12:9000'
        
        // Kubernetes Configuration
        K8S_NAMESPACE = 'hotel-booking'
        
        // Test Configuration
        TEST_PROFILE = 'test'
    }
    
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        disableConcurrentBuilds()
        skipDefaultCheckout(false)
    }
    
    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
                sh '''
                    echo "=== Starting Fresh Build ==="
                    echo "Build Number: ${BUILD_NUMBER}"
                    echo "Workspace: ${WORKSPACE}"
                    pwd
                    ls -la
                '''
            }
        }
        
        stage('Checkout Code') {
            steps {
                checkout scm
                sh '''
                    echo "=== Git Information ==="
                    git log -1 --oneline
                    echo "Branch: ${GIT_BRANCH}"
                    echo "=== Project Structure ==="
                    find . -name "*.java" | head -10
                    echo "..."
                '''
            }
        }
        
        stage('Clean Docker Environment') {
            steps {
                sh '''
                    echo "=== Cleaning Docker Environment ==="
                    # Remove stopped containers
                    docker rm -f $(docker ps -aq) 2>/dev/null || echo "No containers to remove"
                    
                    # Remove unused images
                    docker image prune -f
                    
                    # Remove specific app images
                    docker rmi saifudheenpv/hotel-booking-system:latest 2>/dev/null || echo "Latest image not found"
                    docker rmi saifudheenpv/hotel-booking-system:${BUILD_NUMBER} 2>/dev/null || echo "Build image not found"
                    
                    echo "✅ Docker environment cleaned"
                '''
            }
        }
        
        stage('Compile & Test') {
            steps {
                sh """
                    echo "=== Compiling Source Code ==="
                    mvn clean compile -q
                    echo "✅ Compilation successful"
                    
                    echo "=== Running Unit Tests ==="
                    mvn test -Dspring.profiles.active=${TEST_PROFILE}
                    
                    echo "=== Generating Reports ==="
                    mvn jacoco:report
                """
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                    archiveArtifacts 'target/site/jacoco/jacoco.xml'
                }
                success {
                    echo '✅ All tests passed'
                    sh 'cat target/surefire-reports/*.txt | grep "Tests run:" | head -1'
                }
                failure {
                    echo '❌ Tests failed'
                }
            }
        }
        
        stage('Code Quality') {
            parallel {
                stage('Security Scan') {
                    steps {
                        sh '''
                            echo "=== Running Security Scan ==="
                            trivy fs . --severity HIGH,CRITICAL --exit-code 0 --format table || echo "Scan completed"
                            echo "✅ Security scan finished"
                        '''
                    }
                }
                
                stage('SonarQube Analysis') {
                    steps {
                        withSonarQubeEnv('Sonar-Server') {
                            sh """
                                echo "=== Running SonarQube Analysis ==="
                                mvn sonar:sonar \
                                -Dsonar.projectKey=hotel-booking-system \
                                -Dsonar.projectName='Hotel Booking System' \
                                -Dsonar.host.url=${SONAR_URL} \
                                -Dsonar.login=${SONAR_TOKEN} \
                                -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml \
                                -Dsonar.java.coveragePlugin=jacoco
                            """
                        }
                    }
                }
            }
        }
        
        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        
        stage('Build & Package') {
            steps {
                sh '''
                    echo "=== Building Application ==="
                    mvn clean package -DskipTests
                    echo "=== Generated Artifacts ==="
                    ls -la target/*.jar
                '''
                archiveArtifacts 'target/*.jar'
            }
        }
        
        stage('Publish to Nexus') {
            steps {
                script {
                    def jarFile = findFiles(glob: 'target/*.jar')[0]
                    if (jarFile) {
                        echo "Publishing: ${jarFile.name}"
                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: "${NEXUS_URL}",
                            groupId: 'com.hotel',
                            version: "${VERSION}",
                            repository: 'maven-releases',
                            credentialsId: 'nexus-creds',
                            artifacts: [
                                [artifactId: 'hotel-booking-system',
                                 classifier: '',
                                 file: jarFile.path,
                                 type: 'jar']
                            ]
                        )
                        echo '✅ Published to Nexus'
                    } else {
                        echo '⚠️ No JAR file found'
                    }
                }
            }
        }
        
        stage('Docker Build & Push') {
            steps {
                script {
                    echo "=== Building Docker Image ==="
                    docker.build("${REGISTRY}/${APP_NAME}:${VERSION}")
                    
                    echo "=== Scanning Docker Image ==="
                    sh """
                        trivy image --exit-code 0 \
                        --severity HIGH,CRITICAL \
                        ${REGISTRY}/${APP_NAME}:${VERSION} || echo "Scan completed"
                    """
                    
                    echo "=== Pushing to Docker Hub ==="
                    docker.withRegistry('', 'dockerhub-creds') {
                        docker.image("${REGISTRY}/${APP_NAME}:${VERSION}").push()
                    }
                    echo "✅ Docker image pushed"
                }
            }
        }
        
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=${KUBECONFIG_FILE}
                            
                            echo "=== Setting up Kubernetes ==="
                            
                            # Create namespace
                            kubectl apply -f k8s/namespace.yaml
                            
                            # Deploy MySQL
                            echo "=== Deploying MySQL ==="
                            kubectl apply -f k8s/mysql-secret.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-configmap.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-pvc.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-deployment.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-service.yaml -n ${K8S_NAMESPACE}
                            
                            # Wait for MySQL
                            kubectl wait --for=condition=ready pod -l app=mysql -n ${K8S_NAMESPACE} --timeout=300s
                            
                            # Deploy Application (Blue)
                            echo "=== Deploying Application ==="
                            sed -i "s|image:.*|image: ${REGISTRY}/${APP_NAME}:${VERSION}|g" k8s/app-deployment-blue.yaml
                            kubectl apply -f k8s/app-deployment-blue.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/app-service-blue.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/app-service.yaml -n ${K8S_NAMESPACE}
                            
                            # Wait for application
                            kubectl rollout status deployment/hotel-booking-system-blue -n ${K8S_NAMESPACE} --timeout=300s
                            
                            echo "✅ Deployment completed"
                        """
                    }
                }
            }
        }
        
        stage('Health Check') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=${KUBECONFIG_FILE}
                            
                            echo "=== Performing Health Check ==="
                            
                            # Get pod name
                            POD_NAME=\$(kubectl get pods -n ${K8S_NAMESPACE} -l app=hotel-booking-system -o jsonpath='{.items[0].metadata.name}')
                            
                            if [ -n "\$POD_NAME" ]; then
                                echo "Testing pod: \$POD_NAME"
                                
                                # Health check with retry
                                for i in {1..10}; do
                                    if kubectl exec -n ${K8S_NAMESPACE} \$POD_NAME -- curl -f -s http://localhost:8080/actuator/health > /dev/null; then
                                        echo "✅ Health check PASSED"
                                        kubectl exec -n ${K8S_NAMESPACE} \$POD_NAME -- curl -s http://localhost:8080/actuator/health
                                        break
                                    else
                                        echo "Attempt \$i/10: Not ready..."
                                        sleep 10
                                    fi
                                done
                            else
                                echo "❌ No pods found"
                                exit 1
                            fi
                            
                            # Show final status
                            echo "=== Final Status ==="
                            kubectl get all -n ${K8S_NAMESPACE}
                        """
                    }
                }
            }
        }
    }
    
    post {
        always {
            sh '''
                echo "=== Build Completed ==="
                echo "Result: ${currentBuild.result}"
                echo "Build: ${BUILD_NUMBER}"
            '''
            cleanWs()
        }
        success {
            script {
                currentBuild.description = "✅ SUCCESS - Build ${VERSION}"
                echo "🎉 Pipeline executed successfully!"
                
                // Send success email
                emailext (
                    subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
                    Pipeline executed successfully!
                    
                    Application: ${APP_NAME}
                    Version: ${VERSION}
                    Docker Image: ${REGISTRY}/${APP_NAME}:${VERSION}
                    
                    Build URL: ${env.BUILD_URL}
                    """,
                    to: "mesaifudheenpv@gmail.com"
                )
            }
        }
        failure {
            script {
                currentBuild.description = "❌ FAILED - Build ${VERSION}"
                echo "❌ Pipeline failed!"
                
                // Send failure email
                emailext (
                    subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
                    Pipeline execution failed!
                    
                    Application: ${APP_NAME}
                    Version: ${VERSION}
                    
                    Build URL: ${env.BUILD_URL}
                    Please check Jenkins logs for details.
                    """,
                    to: "mesaifudheenpv@gmail.com",
                    attachLog: true
                )
            }
        }
    }
}