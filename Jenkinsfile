pipeline {
    agent any
    
    tools {
        jdk 'jdk17'
        maven 'maven3'
    }
    
    environment {
        // Credentials
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
        SONAR_TOKEN = credentials('sonar-token')
        NEXUS_CREDENTIALS = credentials('nexus-creds')
        GITHUB_CREDENTIALS = credentials('github-credentials')
        
        // Application Configuration
        REGISTRY = 'saifudheenpv'
        APP_NAME = 'hotel-booking-system'
        VERSION = "${env.BUILD_NUMBER}"
        NEXUS_URL = 'http://13.201.212.39:8081'
        SONAR_URL = 'http://13.201.35.176:9000'
        
        // Kubernetes Configuration
        K8S_NAMESPACE = 'hotel-booking'
    }
    
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        disableConcurrentBuilds()
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                sh 'git branch'
            }
        }
        
        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    jacoco(
                        execPattern: 'target/jacoco.exec',
                        classPattern: 'target/classes',
                        sourcePattern: 'src/main/java',
                        exclusionPattern: 'src/test*'
                    )
                }
            }
        }
        
        stage('Trivy Filesystem Scan') {
            steps {
                sh '''
                    echo "=== Running Trivy Filesystem Security Scan ==="
                    trivy fs . --severity HIGH,CRITICAL --exit-code 0 --format table
                '''
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh """
                        mvn sonar:sonar \
                        -Dsonar.projectKey=hotel-booking-system \
                        -Dsonar.projectName='Hotel Booking System' \
                        -Dsonar.host.url=${SONAR_URL} \
                        -Dsonar.login=${SONAR_TOKEN}
                    """
                }
            }
        }
        
        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        
        stage('Build & Package') {
            steps {
                sh 'mvn clean package -DskipTests'
                archiveArtifacts 'target/*.jar'
            }
        }
        
        stage('Publish to Nexus') {
            steps {
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
                         file: 'target/hotel-booking-system-1.0.0.jar',
                         type: 'jar']
                    ]
                )
            }
        }
        
        stage('Docker Build') {
            steps {
                script {
                    docker.build("${REGISTRY}/${APP_NAME}:${VERSION}")
                    docker.build("${REGISTRY}/${APP_NAME}:latest")
                }
            }
        }
        
        stage('Trivy Image Scan') {
            steps {
                sh """
                    echo "=== Scanning Docker Image for Vulnerabilities ==="
                    trivy image --exit-code 1 \
                    --severity HIGH,CRITICAL \
                    --format table \
                    ${REGISTRY}/${APP_NAME}:${VERSION}
                """
            }
        }
        
        stage('Docker Push') {
            steps {
                script {
                    docker.withRegistry('', 'dockerhub-creds') {
                        docker.image("${REGISTRY}/${APP_NAME}:${VERSION}").push()
                        docker.image("${REGISTRY}/${APP_NAME}:latest").push()
                    }
                }
            }
        }
        
        stage('Deploy to Kubernetes - Blue') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=${KUBECONFIG_FILE}
                            
                            echo "=== Creating Namespace ==="
                            kubectl apply -f k8s/namespace.yaml
                            
                            echo "=== Deploying MySQL ==="
                            kubectl apply -f k8s/mysql-secret.yaml
                            kubectl apply -f k8s/mysql-configmap.yaml
                            kubectl apply -f k8s/mysql-pvc.yaml
                            kubectl apply -f k8s/mysql-deployment.yaml
                            kubectl apply -f k8s/mysql-service.yaml
                            
                            echo "=== Waiting for MySQL to be ready ==="
                            kubectl wait --for=condition=ready pod -l app=mysql -n ${K8S_NAMESPACE} --timeout=300s
                            
                            echo "=== Deploying Blue Version ==="
                            # Update image in deployment
                            sed -i 's|image:.*|image: ${REGISTRY}/${APP_NAME}:${VERSION}|g' k8s/app-deployment-blue.yaml
                            kubectl apply -f k8s/app-deployment-blue.yaml
                            
                            echo "=== Waiting for Blue to be ready ==="
                            kubectl wait --for=condition=ready pod -l app=${APP_NAME},version=blue -n ${K8S_NAMESPACE} --timeout=300s
                        """
                    }
                }
            }
        }
        
        stage('Switch Traffic to Blue') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=${KUBECONFIG_FILE}
                            
                            echo "=== Switching Traffic to Blue ==="
                            kubectl apply -f k8s/app-service.yaml
                            
                            echo "=== Scaling down Green ==="
                            kubectl scale deployment hotel-booking-system-green -n ${K8S_NAMESPACE} --replicas=0
                            
                            echo "=== Current Deployment Status ==="
                            kubectl get deployments -n ${K8S_NAMESPACE}
                            kubectl get pods -n ${K8S_NAMESPACE}
                        """
                    }
                }
            }
        }
        
        stage('Verify Deployment') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=${KUBECONFIG_FILE}
                            
                            echo "=== Verifying Deployment ==="
                            
                            # Get service details
                            kubectl get svc -n ${K8S_NAMESPACE}
                            
                            # Wait for LoadBalancer IP
                            echo "Waiting for LoadBalancer IP..."
                            sleep 30
                            
                            # Get the service IP
                            SERVICE_IP=\$(kubectl get svc hotel-booking-system -n ${K8S_NAMESPACE} -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
                            
                            if [ -z "\$SERVICE_IP" ]; then
                                SERVICE_IP=\$(kubectl get svc hotel-booking-system -n ${K8S_NAMESPACE} -o jsonpath='{.spec.clusterIP}')
                            fi
                            
                            echo "Service IP: \$SERVICE_IP"
                            
                            # Health check with retry
                            for i in {1..10}; do
                                if curl -f http://\$SERVICE_IP/actuator/health; then
                                    echo "✅ Application health check PASSED"
                                    break
                                fi
                                echo "Attempt \$i/10: Application not ready yet..."
                                sleep 15
                            done
                        """
                    }
                }
            }
        }
    }
    
    post {
        always {
            // Cleanup workspace
            cleanWs()
            
            // Send notification
            emailext (
                subject: "BUILD ${currentBuild.result}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                body: """
                Pipeline execution completed!
                
                Build Result: ${currentBuild.result}
                Application: ${APP_NAME}
                Version: ${VERSION}
                Docker Image: ${REGISTRY}/${APP_NAME}:${VERSION}
                
                Build URL: ${env.BUILD_URL}
                """,
                to: "mesaifudheenpv@gmail.com",
                attachLog: true
            )
        }
        success {
            echo "🎉 Pipeline executed successfully!"
            script {
                currentBuild.description = "SUCCESS - Build ${VERSION}"
            }
        }
        failure {
            echo "❌ Pipeline failed!"
            script {
                currentBuild.description = "FAILED - Build ${VERSION}"
            }
        }
        unstable {
            echo "⚠️ Pipeline unstable!"
        }
    }
}