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
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
        SONAR_TOKEN = credentials('sonar-token')
        NEXUS_CREDENTIALS = credentials('nexus-creds')
        
        REGISTRY = 'saifudheenpv'
        APP_NAME = 'hotel-booking-system'
        VERSION = "${env.BUILD_NUMBER}"
        SONAR_URL = 'http://13.233.38.12:9000'
        
        K8S_NAMESPACE = 'hotel-booking'
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
                    pwd
                '''
            }
        }
        
        stage('Checkout Code') {
            steps {
                checkout scm
                sh '''
                    echo "=== Git Information ==="
                    git log -1 --oneline
                '''
            }
        }
        
        stage('Clean Docker Environment') {
            steps {
                sh '''
                    echo "=== Cleaning Docker Environment ==="
                    docker rm -f $(docker ps -aq) 2>/dev/null || echo "No containers to remove"
                    docker image prune -f
                    echo "Docker environment cleaned"
                '''
            }
        }
        
        stage('Compile & Test') {
            steps {
                sh """
                    echo "=== Compiling Source Code ==="
                    mvn clean compile -q
                    echo "Compilation successful"
                    
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
                    echo 'All tests passed'
                }
            }
        }
        
        stage('Code Quality') {
            parallel {
                stage('Security Scan') {
                    steps {
                        sh '''
                            echo "=== Running Security Scan ==="
                            trivy fs . --severity HIGH,CRITICAL --exit-code 0 --format table || echo "Security scan completed"
                        '''
                    }
                }
                
                stage('SonarQube Analysis') {
                    steps {
                        withSonarQubeEnv('Sonar-Server') {
                            sh """
                                mvn sonar:sonar \
                                -Dsonar.projectKey=hotel-booking-system \
                                -Dsonar.projectName='Hotel Booking System' \
                                -Dsonar.host.url=${SONAR_URL} \
                                -Dsonar.login=${SONAR_TOKEN} \
                                -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
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
        
        stage('Docker Build & Push') {
            steps {
                script {
                    echo "=== Building Docker Image ==="
                    docker.build("${REGISTRY}/${APP_NAME}:${VERSION}")
                    
                    echo "=== Scanning Docker Image ==="
                    sh """
                        trivy image --exit-code 0 --severity HIGH,CRITICAL ${REGISTRY}/${APP_NAME}:${VERSION} || echo "Docker scan completed"
                    """
                    
                    echo "=== Pushing to Docker Hub ==="
                    docker.withRegistry('', 'dockerhub-creds') {
                        docker.image("${REGISTRY}/${APP_NAME}:${VERSION}").push()
                    }
                    echo "Docker image pushed successfully"
                }
            }
        }
        
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
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
                            kubectl apply -f k8s/app-ingress.yaml -n ${K8S_NAMESPACE}
                            
                            # Wait for application
                            kubectl rollout status deployment/hotel-booking-system-blue -n ${K8S_NAMESPACE} --timeout=300s
                            
                            echo "Deployment completed successfully"
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
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
                            echo "=== Performing Health Check ==="
                            
                            # Get pod name
                            POD_NAME=\$(kubectl get pods -n ${K8S_NAMESPACE} -l app=hotel-booking-system -o jsonpath='{.items[0].metadata.name}')
                            
                            if [ -n "\$POD_NAME" ]; then
                                echo "Testing pod: \$POD_NAME"
                                
                                # Health check with retry
                                for i in 1 2 3 4 5 6 7 8 9 10; do
                                    if kubectl exec -n ${K8S_NAMESPACE} "\$POD_NAME" -- curl -f -s http://localhost:8080/actuator/health > /dev/null; then
                                        echo "Health check PASSED"
                                        break
                                    else
                                        echo "Attempt \$i: Application not ready yet"
                                        sleep 10
                                    fi
                                done
                            else
                                echo "No pods found for health check"
                                exit 1
                            fi
                            
                            # Show final status
                            echo "=== Final Deployment Status ==="
                            kubectl get all -n ${K8S_NAMESPACE}
                            kubectl get ingress -n ${K8S_NAMESPACE}
                        """
                    }
                }
            }
        }
        
        stage('Final Verification') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
                            echo "=== Final Verification ==="
                            
                            # Get service information
                            kubectl get svc hotel-booking-system -n ${K8S_NAMESPACE}
                            
                            # Get LoadBalancer IP if available
                            LB_IP=\$(kubectl get svc hotel-booking-system -n ${K8S_NAMESPACE} -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
                            
                            if [ -n "\$LB_IP" ]; then
                                echo "Application URL: http://\$LB_IP"
                                echo "Health Check URL: http://\$LB_IP/actuator/health"
                            else
                                echo "LoadBalancer IP not yet assigned"
                            fi
                            
                            echo "=== All Components Status ==="
                            kubectl get pods -n ${K8S_NAMESPACE}
                        """
                    }
                }
            }
        }
    }
    
    post {
        always {
            sh '''
                echo "Build process completed"
            '''
            cleanWs()
        }
        success {
            echo "Pipeline executed successfully!"
            script {
                currentBuild.description = "SUCCESS - Build ${VERSION}"
            }
        }
        failure {
            echo "Pipeline execution failed!"
            script {
                currentBuild.description = "FAILED - Build ${VERSION}"
            }
        }
    }
}