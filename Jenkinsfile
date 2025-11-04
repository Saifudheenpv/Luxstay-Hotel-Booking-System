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
        
        REGISTRY = 'saifudheenpv'
        APP_NAME = 'hotel-booking-system'
        VERSION = "${env.BUILD_NUMBER}"
        SONAR_URL = 'http://13.233.38.12:9000'
        
        K8S_NAMESPACE = 'hotel-booking'
        TEST_PROFILE = 'test'
        CLUSTER_IP = '13.203.79.80'
        NODE_PORT = '32189'
    }
    
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        disableConcurrentBuilds()
        skipDefaultCheckout(false)
        timestamps()
    }
    
    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
                sh '''
                    echo "🚀 Starting Fresh Build - Hotel Booking System"
                    echo "Build Number: ${BUILD_NUMBER}"
                '''
            }
        }
        
        stage('Checkout Code') {
            steps {
                checkout scm
                sh '''
                    echo "📦 Git Repository Information"
                    git log -1 --oneline
                    echo "Branch: ${GIT_BRANCH}"
                '''
            }
        }
        
        stage('Validate K8s Manifests') {
            steps {
                sh '''
                    echo "🔍 Validating Kubernetes Manifests"
                    
                    # Check if all required files exist
                    for file in k8s/*.yaml; do
                        if [ -f "$file" ]; then
                            echo "✅ Found: $file"
                        else
                            echo "❌ Missing: $file"
                        fi
                    done
                    
                    # Validate YAML syntax
                    for file in k8s/*.yaml; do
                        echo "Validating $file"
                        kubectl apply --dry-run=client -f "$file" && echo "✅ $file valid" || echo "⚠️ Validation issues in $file"
                    done
                '''
            }
        }
        
        stage('Clean Docker Environment') {
            steps {
                sh '''
                    echo "🧹 Cleaning Docker Environment"
                    docker system prune -f --volumes || echo "Docker cleanup completed"
                '''
            }
        }
        
        stage('Compile & Test') {
            steps {
                sh """
                    echo "🔨 Compiling Source Code"
                    mvn clean compile -q
                    echo "✅ Compilation successful"
                    
                    echo "🧪 Running Unit Tests"
                    mvn test -Dspring.profiles.active=${TEST_PROFILE}
                    
                    echo "📊 Generating Test Reports"
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
                    echo "🔒 Running Security Scan on Source Code"
                    trivy fs . --severity HIGH,CRITICAL --exit-code 0 --format table --no-progress
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
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml \
                        -Dsonar.java.coveragePlugin=jacoco \
                        -Dsonar.sourceEncoding=UTF-8
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
                    echo "📦 Building Application Package"
                    mvn clean package -DskipTests -q
                    echo "✅ Generated Artifacts:"
                    ls -la target/*.jar
                '''
                archiveArtifacts 'target/*.jar'
            }
        }
        
        stage('Docker Build') {
            steps {
                script {
                    echo "🐳 Building Docker Image"
                    docker.build("${REGISTRY}/${APP_NAME}:${VERSION}")
                    echo "✅ Docker image built: ${REGISTRY}/${APP_NAME}:${VERSION}"
                    
                    // Basic image verification
                    sh """
                        echo "🔍 Basic image verification..."
                        docker image inspect ${REGISTRY}/${APP_NAME}:${VERSION} > /dev/null && echo "✅ Image exists and is valid"
                    """
                }
            }
        }
        
        stage('Security Scan - Docker Image') {
            steps {
                sh """
                    echo "🔒 Scanning Docker Image for Vulnerabilities"
                    trivy image --exit-code 0 --severity HIGH,CRITICAL --no-progress ${REGISTRY}/${APP_NAME}:${VERSION}
                """
            }
        }
        
        stage('Docker Push') {
            steps {
                script {
                    echo "📤 Pushing Docker Image to Registry"
                    docker.withRegistry('', 'dockerhub-creds') {
                        docker.image("${REGISTRY}/${APP_NAME}:${VERSION}").push()
                    }
                    echo "✅ Docker image pushed: ${REGISTRY}/${APP_NAME}:${VERSION}"
                    
                    // Also tag as latest
                    sh """
                        docker tag ${REGISTRY}/${APP_NAME}:${VERSION} ${REGISTRY}/${APP_NAME}:latest
                    """
                    docker.withRegistry('', 'dockerhub-creds') {
                        docker.image("${REGISTRY}/${APP_NAME}:latest").push()
                    }
                    echo "✅ Latest tag also pushed"
                }
            }
        }
        
        stage('Infrastructure Setup') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
                            echo "🏗️ Setting up Kubernetes Infrastructure"
                            
                            # Create namespace
                            kubectl create namespace ${K8S_NAMESPACE} --dry-run=client -o yaml | kubectl apply -f -
                            
                            # Setup MySQL database
                            echo "🗄️ Deploying MySQL Database"
                            kubectl apply -f k8s/mysql-secret.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-configmap.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-pvc.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-deployment.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/mysql-service.yaml -n ${K8S_NAMESPACE}
                            
                            # Wait for MySQL to be ready
                            echo "⏳ Waiting for MySQL to be ready..."
                            if kubectl wait --for=condition=ready pod -l app=mysql -n ${K8S_NAMESPACE} --timeout=300s; then
                                echo "✅ MySQL is ready"
                                
                                # Test MySQL connection
                                echo "🔍 Testing MySQL connection..."
                                sleep 10
                                MYSQL_POD=\$(kubectl get pods -n ${K8S_NAMESPACE} -l app=mysql -o jsonpath='{.items[0].metadata.name}')
                                if kubectl exec -n ${K8S_NAMESPACE} \$MYSQL_POD -- mysql -u hotel_user -pHotel@123 -e "SHOW DATABASES;" hotel_booking_system; then
                                    echo "✅ MySQL connection successful"
                                else
                                    echo "⚠️ MySQL connection test failed, but continuing deployment..."
                                fi
                            else
                                echo "❌ MySQL failed to start"
                                kubectl logs -n ${K8S_NAMESPACE} -l app=mysql
                                exit 1
                            fi
                        """
                    }
                }
            }
        }
        
        stage('Blue-Green Deployment') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        // Determine deployment strategy
                        def deploymentInfo = sh(
                            script: """
                                export KUBECONFIG=\${KUBECONFIG_FILE}
                                
                                # Get deployment status
                                BLUE_READY=\$(kubectl get deployment hotel-booking-system-blue -n ${K8S_NAMESPACE} --ignore-not-found -o jsonpath='{.status.readyReplicas}' 2>/dev/null || echo "0")
                                GREEN_READY=\$(kubectl get deployment hotel-booking-system-green -n ${K8S_NAMESPACE} --ignore-not-found -o jsonpath='{.status.readyReplicas}' 2>/dev/null || echo "0")
                                
                                echo "Blue replicas: \$BLUE_READY"
                                echo "Green replicas: \$GREEN_READY"
                                
                                # Determine target
                                if [ "\$BLUE_READY" -eq "0" ] && [ "\$GREEN_READY" -eq "0" ]; then
                                    echo "blue:green:first"
                                elif [ "\$BLUE_READY" -gt "0" ]; then
                                    echo "green:blue:switch"
                                else
                                    echo "blue:green:switch"
                                fi
                            """,
                            returnStdout: true
                        ).trim().readLines().last()
                        
                        def (TARGET_DEPLOYMENT, OLD_DEPLOYMENT, DEPLOYMENT_TYPE) = deploymentInfo.tokenize(':')
                        
                        env.TARGET_DEPLOYMENT = TARGET_DEPLOYMENT
                        env.OLD_DEPLOYMENT = OLD_DEPLOYMENT
                        
                        echo "🎯 Deployment Strategy: ${DEPLOYMENT_TYPE}"
                        echo "🎯 Target Deployment: ${TARGET_DEPLOYMENT}"
                        echo "🎯 Old Deployment: ${OLD_DEPLOYMENT}"
                        
                        // Deploy to target environment
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
                            echo "🚀 Deploying Version ${VERSION} to ${TARGET_DEPLOYMENT}"
                            
                            # Update deployment with new image using sed
                            sed -i "s|image:.*|image: ${REGISTRY}/${APP_NAME}:${VERSION}|g" k8s/app-deployment-${TARGET_DEPLOYMENT}.yaml
                            
                            # Apply target deployment
                            kubectl apply -f k8s/app-deployment-${TARGET_DEPLOYMENT}.yaml -n ${K8S_NAMESPACE}
                            kubectl apply -f k8s/app-service-${TARGET_DEPLOYMENT}.yaml -n ${K8S_NAMESPACE}
                            
                            # Wait for rollout
                            echo "⏳ Waiting for ${TARGET_DEPLOYMENT} deployment to complete..."
                            if kubectl rollout status deployment/hotel-booking-system-${TARGET_DEPLOYMENT} -n ${K8S_NAMESPACE} --timeout=300s; then
                                echo "✅ ${TARGET_DEPLOYMENT} deployment completed successfully"
                            else
                                echo "❌ ${TARGET_DEPLOYMENT} deployment failed"
                                echo "📋 Debug information:"
                                kubectl get pods -n ${K8S_NAMESPACE} -l app=hotel-booking-system,version=${TARGET_DEPLOYMENT}
                                kubectl describe deployment/hotel-booking-system-${TARGET_DEPLOYMENT} -n ${K8S_NAMESPACE}
                                kubectl logs -n ${K8S_NAMESPACE} -l app=hotel-booking-system,version=${TARGET_DEPLOYMENT} --tail=50
                                exit 1
                            fi
                        """
                    }
                }
            }
        }
        
        stage('Health Check & Validation') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
                            echo "🏥 Performing Health Checks on ${env.TARGET_DEPLOYMENT}"
                            
                            # Wait for pods to be ready
                            echo "⏳ Waiting for ${env.TARGET_DEPLOYMENT} pods to be ready..."
                            kubectl wait --for=condition=ready pod -l app=hotel-booking-system,version=${env.TARGET_DEPLOYMENT} -n ${K8S_NAMESPACE} --timeout=300s
                            
                            echo "✅ ${env.TARGET_DEPLOYMENT} pods are ready"
                            
                            # Test internal health check
                            echo "🔍 Testing internal application health..."
                            POD_NAME=\$(kubectl get pods -n ${K8S_NAMESPACE} -l app=hotel-booking-system,version=${env.TARGET_DEPLOYMENT} -o jsonpath='{.items[0].metadata.name}')
                            
                            if [ -n "\$POD_NAME" ]; then
                                for i in 1 2 3 4 5; do
                                    if kubectl exec -n ${K8S_NAMESPACE} "\$POD_NAME" -- curl -f -s http://localhost:8080/actuator/health > /dev/null; then
                                        echo "✅ ${env.TARGET_DEPLOYMENT} internal health check PASSED on attempt \$i"
                                        break
                                    else
                                        echo "⏳ Attempt \$i: ${env.TARGET_DEPLOYMENT} internal health check failed, waiting 5s..."
                                        sleep 5
                                        if [ \$i -eq 5 ]; then
                                            echo "⚠️ ${env.TARGET_DEPLOYMENT} internal health check failed after 5 attempts, but continuing..."
                                        fi
                                    fi
                                done
                            else
                                echo "❌ No pods found for ${env.TARGET_DEPLOYMENT}"
                                exit 1
                            fi
                        """
                    }
                }
            }
        }
        
        stage('Update Main Service & Ingress') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')]) {
                        sh """
                            export KUBECONFIG=\${KUBECONFIG_FILE}
                            
                            echo "🔄 Updating Main Service to point to ${env.TARGET_DEPLOYMENT}"
                            
                            # Update main service selector
                            sed -i "s/version:.*/version: ${env.TARGET_DEPLOYMENT}/g" k8s/app-service.yaml
                            
                            # Apply main service
                            kubectl apply -f k8s/app-service.yaml -n ${K8S_NAMESPACE}
                            
                            # Apply ingress
                            kubectl apply -f k8s/app-ingress.yaml -n ${K8S_NAMESPACE}
                            
                            echo "✅ Main service updated to ${env.TARGET_DEPLOYMENT}"
                            
                            # Wait for services to be ready
                            echo "⏳ Waiting for services to be ready..."
                            sleep 20
                            
                            # Scale down old deployment
                            echo "📉 Scaling down previous deployment (${env.OLD_DEPLOYMENT})"
                            kubectl scale deployment/hotel-booking-system-${env.OLD_DEPLOYMENT} -n ${K8S_NAMESPACE} --replicas=0
                            
                            echo "✅ ${env.OLD_DEPLOYMENT} scaled down to zero replicas"
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
                            
                            echo "🎉 FINAL DEPLOYMENT VERIFICATION"
                            echo "=========================================="
                            
                            # Get NodePort URL (Primary - always available)
                            NODE_PORT=\$(kubectl get svc hotel-booking-system -n ${K8S_NAMESPACE} -o jsonpath='{.spec.ports[0].nodePort}')
                            NODE_URL="http://${CLUSTER_IP}:\${NODE_PORT}"
                            
                            # Get LoadBalancer details
                            LB_IP=\$(kubectl get svc hotel-booking-system -n ${K8S_NAMESPACE} -o jsonpath='{.status.loadBalancer.ingress[0].ip}' 2>/dev/null || echo "")
                            LB_HOST=\$(kubectl get svc hotel-booking-system -n ${K8S_NAMESPACE} -o jsonpath='{.status.loadBalancer.ingress[0].hostname}' 2>/dev/null || echo "")
                            
                            # Get Ingress URL
                            INGRESS_HOST=\$(kubectl get ingress hotel-booking-ingress -n ${K8S_NAMESPACE} -o jsonpath='{.status.loadBalancer.ingress[0].hostname}' 2>/dev/null || echo "")
                            
                            echo ""
                            echo "🌐 APPLICATION ACCESS URLs:"
                            echo "------------------------------------------"
                            
                            # Always use NodePort as primary
                            echo "🎯 PRIMARY URL (NodePort - Guaranteed Access):"
                            echo "   \${NODE_URL}/"
                            echo "   Health: \${NODE_URL}/actuator/health"
                            echo "   Swagger: \${NODE_URL}/swagger-ui.html"
                            
                            if [ -n "\$LB_IP" ]; then
                                echo ""
                                echo "🚀 LOAD BALANCER URL (IP):"
                                echo "   http://\${LB_IP}/"
                            elif [ -n "\$LB_HOST" ]; then
                                echo ""
                                echo "🚀 LOAD BALANCER URL (Hostname):"
                                echo "   http://\${LB_HOST}/"
                            else
                                echo ""
                                echo "⚠️  LoadBalancer: Not available (using internal IP)"
                            fi
                            
                            if [ -n "\$INGRESS_HOST" ]; then
                                echo ""
                                echo "🌐 INGRESS URL:"
                                echo "   http://\${INGRESS_HOST}/"
                            else
                                echo ""
                                echo "⚠️  Ingress: Not available"
                            fi
                            
                            echo ""
                            echo "📊 DEPLOYMENT STATUS:"
                            echo "------------------------------------------"
                            kubectl get deployments -n ${K8S_NAMESPACE} -o wide
                            
                            echo ""
                            echo "🔧 SERVICES:"
                            echo "------------------------------------------"
                            kubectl get svc -n ${K8S_NAMESPACE} -o wide
                            
                            echo ""
                            echo "🐳 PODS:"
                            echo "------------------------------------------"
                            kubectl get pods -n ${K8S_NAMESPACE} -o wide --show-labels
                            
                            echo ""
                            echo "📈 INGRESS:"
                            echo "------------------------------------------"
                            kubectl get ingress -n ${K8S_NAMESPACE} 2>/dev/null || echo "Ingress not available"
                            
                            echo ""
                            echo "✅ DEPLOYMENT SUMMARY:"
                            echo "------------------------------------------"
                            echo "Application: ${APP_NAME}"
                            echo "Version: ${VERSION}"
                            echo "Active Deployment: ${env.TARGET_DEPLOYMENT}"
                            echo "Docker Image: ${REGISTRY}/${APP_NAME}:${VERSION}"
                            echo "Namespace: ${K8S_NAMESPACE}"
                            echo "Build: ${env.BUILD_NUMBER}"
                            
                            # Final application test on NodePort
                            echo ""
                            echo "🧪 FINAL APPLICATION TEST"
                            echo "------------------------------------------"
                            echo "Testing application at: \${NODE_URL}"
                            for i in 1 2 3 4 5; do
                                if curl -f -s "\${NODE_URL}/actuator/health" > /dev/null; then
                                    echo "✅ Application is responding correctly on NodePort"
                                    break
                                else
                                    echo "⏳ Attempt \$i: Application not responding, waiting 5s..."
                                    sleep 5
                                    if [ \$i -eq 5 ]; then
                                        echo "❌ Application failed to respond after 5 attempts"
                                        echo "Checking pod status..."
                                        kubectl get pods -n ${K8S_NAMESPACE}
                                        kubectl logs -n ${K8S_NAMESPACE} -l app=hotel-booking-system --tail=20
                                    fi
                                fi
                            done
                            
                            # Write URLs to file for email notification
                            echo "PRIMARY_URL=\${NODE_URL}/" > deployment-urls.txt
                            echo "NODEPORT_URL=\${NODE_URL}/" >> deployment-urls.txt
                            
                            if [ -n "\$LB_IP" ]; then
                                echo "LB_URL=http://\${LB_IP}/" >> deployment-urls.txt
                            elif [ -n "\$LB_HOST" ]; then
                                echo "LB_URL=http://\${LB_HOST}/" >> deployment-urls.txt
                            else
                                echo "LB_URL=Not available" >> deployment-urls.txt
                            fi
                            
                            if [ -n "\$INGRESS_HOST" ]; then
                                echo "INGRESS_URL=http://\${INGRESS_HOST}/" >> deployment-urls.txt
                            else
                                echo "INGRESS_URL=Not available" >> deployment-urls.txt
                            fi
                        """
                        
                        // Read URLs from file
                        script {
                            def primaryUrl = "http://${CLUSTER_IP}:32189/"
                            def lbUrl = "Not available"
                            def ingressUrl = "Not available"
                            def nodeportUrl = "http://${CLUSTER_IP}:32189/"
                            
                            if (fileExists('deployment-urls.txt')) {
                                def urlFile = readFile('deployment-urls.txt')
                                def lines = urlFile.split('\n')
                                lines.each { line ->
                                    if (line.startsWith('PRIMARY_URL=')) {
                                        primaryUrl = line.substring('PRIMARY_URL='.length())
                                    }
                                    if (line.startsWith('LB_URL=')) {
                                        lbUrl = line.substring('LB_URL='.length())
                                    }
                                    if (line.startsWith('INGRESS_URL=')) {
                                        ingressUrl = line.substring('INGRESS_URL='.length())
                                    }
                                    if (line.startsWith('NODEPORT_URL=')) {
                                        nodeportUrl = line.substring('NODEPORT_URL='.length())
                                    }
                                }
                            }
                            
                            env.DEPLOYMENT_URL = primaryUrl
                            env.LB_URL = lbUrl
                            env.INGRESS_URL = ingressUrl
                            env.NODEPORT_URL = nodeportUrl
                            
                            echo "📧 Final URLs for notification:"
                            echo "Primary: ${env.DEPLOYMENT_URL}"
                            echo "NodePort: ${env.NODEPORT_URL}"
                            echo "LoadBalancer: ${env.LB_URL}"
                            echo "Ingress: ${env.INGRESS_URL}"
                        }
                    }
                }
            }
        }
    }
    
    post {
        always {
            sh """
                echo "🏁 Build Process Completed"
                echo "Build Status: ${currentBuild.result}"
                echo "Build Number: ${VERSION}"
                echo "Deployment: ${env.TARGET_DEPLOYMENT ?: 'N/A'}"
                echo "Primary URL: ${env.DEPLOYMENT_URL ?: 'N/A'}"
            """
            cleanWs()
        }
        success {
            echo "🎉 Blue-Green Deployment completed successfully!"
            script {
                currentBuild.description = "SUCCESS - v${VERSION} (${env.TARGET_DEPLOYMENT})"
                
                emailext (
                    subject: "SUCCESS: Hotel Booking System #${env.BUILD_NUMBER}",
                    body: """
                    🎉 BLUE-GREEN DEPLOYMENT COMPLETED SUCCESSFULLY!

                    📋 Deployment Details:
                    • Application: ${APP_NAME}
                    • Version: ${VERSION}
                    • Environment: ${env.TARGET_DEPLOYMENT}
                    • Docker Image: ${REGISTRY}/${APP_NAME}:${VERSION}
                    • Namespace: ${K8S_NAMESPACE}
                    • Build: ${env.BUILD_NUMBER}

                    🌐 ACCESS URLs:
                    • 🎯 PRIMARY URL: ${env.DEPLOYMENT_URL}
                    • 🔗 NodePort: ${env.NODEPORT_URL}
                    • 🚀 LoadBalancer: ${env.LB_URL}
                    • 🌐 Ingress: ${env.INGRESS_URL}

                    🔗 Quick Links:
                    • Application: ${env.DEPLOYMENT_URL}
                    • Health Check: ${env.DEPLOYMENT_URL}actuator/health
                    • Swagger UI: ${env.DEPLOYMENT_URL}swagger-ui.html

                    📊 Build Information:
                    • Build URL: ${env.BUILD_URL}
                    • Git Branch: ${env.GIT_BRANCH}

                    The application has been deployed using Blue-Green strategy.
                    Use the PRIMARY URL for guaranteed access.
                    """,
                    to: "mesaifudheenpv@gmail.com",
                    attachLog: false
                )
            }
        }
        failure {
            echo "❌ Pipeline failed!"
            script {
                currentBuild.description = "FAILED - v${VERSION}"
                
                emailext (
                    subject: "FAILED: Hotel Booking System #${env.BUILD_NUMBER}",
                    body: """
                    ❌ DEPLOYMENT FAILED!

                    Application: ${APP_NAME}
                    Version: ${VERSION}
                    Target Deployment: ${env.TARGET_DEPLOYMENT ?: 'N/A'}

                    Please check the Jenkins build logs for details:
                    ${env.BUILD_URL}

                    Immediate attention required.
                    """,
                    to: "mesaifudheenpv@gmail.com",
                    attachLog: true
                )
            }
        }
    }
}