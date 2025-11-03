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
                    echo "Starting Fresh Build"
                    pwd
                '''
            }
        }
        
        stage('Checkout Code') {
            steps {
                checkout scm
                sh '''
                    echo "Git Information"
                    git log -1 --oneline
                '''
            }
        }
        
        stage('Clean Docker Environment') {
            steps {
                sh '''
                    echo "Cleaning Docker Environment"
                    docker rm -f $(docker ps -aq) 2>/dev/null || echo "No containers to remove"
                    docker image prune -f
                    echo "Docker environment cleaned"
                '''
            }
        }
        
        stage('Compile & Test') {
            steps {
                sh """
                    echo "Compiling Source Code"
                    mvn clean compile -q
                    echo "Compilation successful"
                    
                    echo "Running Unit Tests"
                    mvn test -Dspring.profiles.active=${TEST_PROFILE}
                    
                    echo "Generating Reports"
                    mvn jacoco:report
                """
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                    archiveArtifacts 'target/site/jacoco/jacoco.xml'
                }
            }
        }
        
        stage('Security Scan - Code') {
            steps {
                sh '''
                    echo "Running Security Scan"
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
                    echo "Building Application"
                    mvn clean package -DskipTests
                    echo "Generated Artifacts"
                    ls -la target/*.jar
                '''
                archiveArtifacts 'target/*.jar'
            }
        }
        
        stage('Docker Build') {
            steps {
                script {
                    echo "Building Docker Image"
                    docker.build("${REGISTRY}/${APP_NAME}:${VERSION}")
                    echo "Docker image built: ${REGISTRY}/${APP_NAME}:${VERSION}"
                }
            }
        }
        
        stage('Security Scan - Docker Image') {
            steps {
                sh """
                    trivy image --exit-code 0 --severity HIGH,CRITICAL ${REGISTRY}/${APP_NAME}:${VERSION} || echo "Docker security scan completed"
                """
            }
        }
        
        stage('Docker Push') {
            steps {
                script {
                    echo "Pushing Docker Image"
                    docker.withRegistry('', 'dockerhub-creds') {
                        docker.image("${REGISTRY}/${APP_NAME}:${VERSION}").push()
                    }
                    echo "Docker image pushed: ${REGISTRY}/${APP_NAME}:${VERSION}"
                }
            }
        }
        
        stage('Blue-Green Deployment') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
                            echo "Starting Blue-Green Deployment"
                            
                            # Create namespace if not exists
                            kubectl create namespace ${K8S_NAMESPACE} --dry-run=client -o yaml | kubectl apply -f -
                            
                            # Deploy MySQL infrastructure
                            echo "Setting up MySQL Database"
                            kubectl apply -f k8s/mysql-secret.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-configmap.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-pvc.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-deployment.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-service.yaml -n ${K8S_NAMESPACE}
                            
                            # Wait for MySQL
                            kubectl wait --for=condition=ready pod -l app=mysql -n ${K8S_NAMESPACE} --timeout=300s
                            
                            # Determine current active deployment
                            echo "Analyzing Current Deployment State"
                            BLUE_READY=\$(kubectl get deployment hotel-booking-system-blue -n ${K8S_NAMESPACE} --ignore-not-found -o jsonpath='{.status.readyReplicas}' 2>/dev/null || echo "0")
                            GREEN_READY=\$(kubectl get deployment hotel-booking-system-green -n ${K8S_NAMESPACE} --ignore-not-found -o jsonpath='{.status.readyReplicas}' 2>/dev/null || echo "0")
                            
                            echo "Blue ready replicas: \$BLUE_READY"
                            echo "Green ready replicas: \$GREEN_READY"
                            
                            if [ "\$BLUE_READY" -eq "0" ] && [ "\$GREEN_READY" -eq "0" ]; then
                                TARGET_DEPLOYMENT="blue"
                                OLD_DEPLOYMENT="green"
                                echo "First deployment - using BLUE"
                            elif [ "\$BLUE_READY" -gt "0" ]; then
                                TARGET_DEPLOYMENT="green"
                                OLD_DEPLOYMENT="blue"
                                echo "Blue is active - deploying to GREEN"
                            else
                                TARGET_DEPLOYMENT="blue"
                                OLD_DEPLOYMENT="green"
                                echo "Green is active - deploying to BLUE"
                            fi
                            
                            echo "TARGET_DEPLOYMENT=\$TARGET_DEPLOYMENT" > deployment.env
                            echo "OLD_DEPLOYMENT=\$OLD_DEPLOYMENT" >> deployment.env
                            echo "Deployment target determined: \$TARGET_DEPLOYMENT"
                        """
                        
                        load 'deployment.env'
                        
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            source deployment.env
                            
                            echo "Deploying Version ${VERSION} to \${TARGET_DEPLOYMENT}"
                            
                            # Update deployment with new image
                            sed -i "s|image:.*|image: ${REGISTRY}/${APP_NAME}:${VERSION}|g" k8s/app-deployment-\${TARGET_DEPLOYMENT}.yaml
                            
                            # Apply target deployment and service
                            kubectl apply -f k8s/app-deployment-\${TARGET_DEPLOYMENT}.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/app-service-\${TARGET_DEPLOYMENT}.yaml -n ${K8S_NAMESPACE}
                            
                            # Wait for target deployment
                            echo "Waiting for \${TARGET_DEPLOYMENT} rollout"
                            kubectl rollout status deployment/hotel-booking-system-\${TARGET_DEPLOYMENT} -n ${K8S_NAMESPACE} --timeout=300s
                            
                            echo "\${TARGET_DEPLOYMENT} deployment completed"
                        """
                    }
                }
            }
        }
        
        stage('Health Check New Deployment') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        load 'deployment.env'
                        
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            source deployment.env
                            
                            echo "Health Checking \${TARGET_DEPLOYMENT} Deployment"
                            
                            POD_NAME=\$(kubectl get pods -n ${K8S_NAMESPACE} -l app=hotel-booking-system,version=\${TARGET_DEPLOYMENT} -o jsonpath='{.items[0].metadata.name}')
                            
                            if [ -n "\$POD_NAME" ]; then
                                echo "Testing pod: \$POD_NAME"
                                
                                for i in 1 2 3 4 5 6 7 8 9 10; do
                                    if kubectl exec -n ${K8S_NAMESPACE} "\$POD_NAME" -- wget -q -O - http://localhost:8080/actuator/health > /dev/null; then
                                        echo "\${TARGET_DEPLOYMENT} health check PASSED"
                                        break
                                    else
                                        echo "Attempt \$i: \${TARGET_DEPLOYMENT} not ready yet"
                                        sleep 10
                                    fi
                                done
                            else
                                echo "No pods found for \${TARGET_DEPLOYMENT}"
                                exit 1
                            fi
                        """
                    }
                }
            }
        }
        
        stage('Switch Traffic') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        load 'deployment.env'
                        
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            source deployment.env
                            
                            echo "Switching Traffic to \${TARGET_DEPLOYMENT}"
                            
                            # Update main service
                            kubectl apply -f k8s/app-service.yaml -n ${K8S_NAMESPACE}
                            
                            # Apply ingress
                            kubectl apply -f k8s/app-ingress.yaml -n ${K8S_NAMESPACE}
                            
                            echo "Traffic switched to \${TARGET_DEPLOYMENT}"
                            
                            # Scale down old deployment
                            echo "Scaling down \${OLD_DEPLOYMENT}"
                            kubectl scale deployment/hotel-booking-system-\${OLD_DEPLOYMENT} -n ${K8S_NAMESPACE} --replicas=0
                            
                            echo "\${OLD_DEPLOYMENT} scaled down"
                        """
                    }
                }
            }
        }
        
        stage('Final Verification & URLs') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
                            echo "Generating Deployment URLs"
                            
                            # Get NodePort
                            NODE_PORT=\$(kubectl get svc hotel-booking-system -n ${K8S_NAMESPACE} -o jsonpath='{.spec.ports[0].nodePort}')
                            
                            # Use known public IP
                            NODE_IP="13.203.79.80"
                            
                            echo ""
                            echo "DEPLOYMENT URLs - ACCESS YOUR APPLICATION"
                            echo ""
                            
                            if [ -n "\$NODE_PORT" ]; then
                                echo "PRIMARY URL (NodePort):"
                                echo "http://\${NODE_IP}:\${NODE_PORT}/"
                                echo "Health: http://\${NODE_IP}:\${NODE_PORT}/actuator/health"
                                echo "DEPLOYMENT_URL=http://\${NODE_IP}:\${NODE_PORT}/" > deployment-url.env
                            fi
                            
                            echo ""
                            echo "Deployment Status:"
                            kubectl get deployments -n ${K8S_NAMESPACE}
                            kubectl get pods -n ${K8S_NAMESPACE}
                        """
                        
                        if (fileExists('deployment-url.env')) {
                            load 'deployment-url.env'
                            echo "Application successfully deployed!"
                            echo "Access URL: ${DEPLOYMENT_URL}"
                        }
                    }
                }
            }
        }
    }
    
    post {
        always {
            sh 'echo "Build Process Completed"'
            cleanWs()
        }
        success {
            echo "Blue-Green Deployment completed successfully!"
            script {
                currentBuild.description = "SUCCESS - Build ${VERSION}"
                
                def deploymentUrl = "Check Jenkins console for URLs"
                if (fileExists('deployment-url.env')) {
                    load 'deployment-url.env'
                    deploymentUrl = DEPLOYMENT_URL
                }
                
                emailext (
                    subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
                    Blue-Green Deployment Completed Successfully!
                    
                    Application: ${APP_NAME}
                    Version: ${VERSION}
                    
                    DEPLOYMENT URL: ${deploymentUrl}
                    
                    Build URL: ${env.BUILD_URL}
                    """,
                    to: "mesaifudheenpv@gmail.com"
                )
            }
        }
        failure {
            echo "Pipeline failed!"
            script {
                currentBuild.description = "FAILED - Build ${VERSION}"
            }
        }
    }
}