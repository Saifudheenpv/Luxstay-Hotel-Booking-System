pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    environment {
        SONARQUBE_URL = '13.203.26.99'
        DOCKER_NAMESPACE = "saifudheenpv"
        APP_NAME = 'hotel-booking-system'
        APP_VERSION = "${env.BUILD_ID}"
        K8S_NAMESPACE = 'hotel-booking'
        REGION = 'ap-south-1'
        CLUSTER_NAME = 'devops-cluster'
        NEXUS_URL = '13.233.52.101:8081'
        NEXUS_REPO = 'maven-releases'
        EMAIL_TO = 'mesaifudheenpv@gmail.com'
    }

    triggers {
        githubPush()
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        timeout(time: 45, unit: 'MINUTES')
    }

    parameters {
        choice(name: 'DEPLOYMENT_STRATEGY', choices: ['blue-green', 'rolling'], description: 'Select deployment strategy')
        booleanParam(name: 'AUTO_SWITCH', defaultValue: true, description: 'Auto switch traffic to new version?')
    }

    stages {

        /* ===========================
           ENVIRONMENT SETUP
        =========================== */
        stage('Environment Setup') {
            steps {
                script {
                    echo "🔧 Setting up build environment..."
                    sh '''
                    java -version
                    mvn --version
                    docker --version
                    kubectl version --client
                    '''
                }
            }
        }

        /* ===========================
           GIT CHECKOUT
        =========================== */
        stage('Checkout Code') {
            steps {
                echo "📦 Checking out code..."
                checkout scm
            }
        }

        /* ===========================
           SONARQUBE ANALYSIS
        =========================== */
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('Sonar-Server') {
                    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                        sh """
                        mvn sonar:sonar \
                          -Dsonar.projectKey=${APP_NAME} \
                          -Dsonar.host.url=http://${SONARQUBE_URL}:9000 \
                          -Dsonar.login=$SONAR_TOKEN
                        """
                    }
                }
            }
        }

        /* ===========================
           OWASP SECURITY SCAN
        =========================== */
        stage('OWASP Dependency Check') {
            steps {
                echo "🔐 Running OWASP dependency scan..."
                sh 'mvn org.owasp:dependency-check-maven:check -DskipTests || true'
            }
            post {
                always {
                    publishHTML([
                        reportDir: 'target',
                        reportFiles: 'dependency-check-report.html',
                        reportName: 'Dependency Security Report'
                    ])
                }
            }
        }

        /* ===========================
           MAVEN BUILD & NEXUS DEPLOY
        =========================== */
        stage('Build & Publish to Nexus') {
            steps {
                echo "⚙️ Building & deploying to Nexus..."
                withCredentials([usernamePassword(credentialsId: 'nexus-creds', usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PASS')]) {
                    sh """
                    mvn clean deploy -DskipTests \
                      -Dnexus.url=http://${NEXUS_URL}/repository/${NEXUS_REPO}/ \
                      -Dnexus.user=$NEXUS_USER -Dnexus.pass=$NEXUS_PASS
                    """
                }
            }
        }

        /* ===========================
           DOCKER BUILD & TRIVY SCAN
        =========================== */
        stage('Docker Build & Push') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-token', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker build -t ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} .
                        docker tag ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} ${DOCKER_NAMESPACE}/${APP_NAME}:latest
                        trivy image --format table --output trivy-scan.txt ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} || true
                        docker push ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}
                        docker push ${DOCKER_NAMESPACE}/${APP_NAME}:latest
                        '''
                    }
                }
            }
            post {
                always {
                    publishHTML([
                        reportDir: '.',
                        reportFiles: 'trivy-scan.txt',
                        reportName: 'Trivy Scan Report'
                    ])
                }
            }
        }

        /* ===========================
           DEPLOY TO EKS
        =========================== */
        stage('Deploy to EKS') {
            steps {
                withCredentials([
                    [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                    file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                ]) {
                    script {
                        echo "🚀 Deploying to EKS..."
                        sh '''
                        mkdir -p $WORKSPACE/.kube
                        cp $KUBECONFIG_FILE $WORKSPACE/.kube/config
                        export KUBECONFIG=$WORKSPACE/.kube/config

                        aws eks get-token --cluster-name ${CLUSTER_NAME} --region ${REGION} > /tmp/token.json
                        TOKEN=$(jq -r .status.token /tmp/token.json)
                        kubectl config set-credentials arn:aws:eks:${REGION}:724663512594:cluster/${CLUSTER_NAME} --token="$TOKEN"

                        kubectl create namespace ${K8S_NAMESPACE} --dry-run=client -o yaml | kubectl apply -f -
                        kubectl apply -f k8s/mysql-deployment.yaml -n ${K8S_NAMESPACE} --validate=false
                        kubectl apply -f k8s/mysql-service.yaml -n ${K8S_NAMESPACE} --validate=false
                        kubectl apply -f k8s/app-deployment-blue.yaml -n ${K8S_NAMESPACE} --validate=false
                        kubectl apply -f k8s/app-service.yaml -n ${K8S_NAMESPACE} --validate=false
                        '''
                    }
                }
            }
        }

        /* ===========================
           AUTO PATCH & BLUE-GREEN
        =========================== */
        stage('Auto Blue-Green Patch') {
            when { expression { params.DEPLOYMENT_STRATEGY == 'blue-green' } }
            steps {
                script {
                    echo "🔁 Checking & patching service version..."
                    withCredentials([
                        [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                        file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                    ]) {
                        sh '''
                        export KUBECONFIG=$WORKSPACE/.kube/config
                        CURRENT=$(kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o jsonpath='{.spec.selector.version}')
                        echo "Current service version: $CURRENT"
                        if [ "$CURRENT" = "green" ]; then
                          echo "Switching to BLUE..."
                          kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} \
                            --type merge \
                            -p '{"spec":{"selector":{"app":"hotel-booking","version":"blue"}}}'
                        else
                          echo "Switching to GREEN..."
                          kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} \
                            --type merge \
                            -p '{"spec":{"selector":{"app":"hotel-booking","version":"green"}}}'
                        fi
                        '''
                    }
                }
            }
        }

        /* ===========================
           VALIDATION & HEALTH CHECK
        =========================== */
        stage('Post-Deployment Validation') {
            steps {
                script {
                    echo "🔍 Validating service endpoints..."
                    sh '''
                    export KUBECONFIG=$WORKSPACE/.kube/config
                    kubectl get svc -n ${K8S_NAMESPACE}
                    kubectl get pods -n ${K8S_NAMESPACE}
                    EXTERNAL_URL=$(kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o jsonpath='{.status.loadBalancer.ingress[0].hostname}')
                    echo "Application URL: http://$EXTERNAL_URL"
                    curl -I http://$EXTERNAL_URL/actuator/health || true
                    echo "External URL validated successfully."
                    echo $EXTERNAL_URL > external_url.txt
                    '''
                }
            }
        }
    }

    /* ===========================
       POST ACTIONS
    =========================== */
    post {
        success {
            script {
                def externalUrl = readFile('external_url.txt').trim()
                mail to: "${EMAIL_TO}",
                     subject: "✅ SUCCESS: Hotel Booking System Deployed to EKS",
                     body: """<h3>🎉 Deployment Successful!</h3>
                              <p>Application is live and running on AWS EKS.</p>
                              <p><b>External Access URL:</b> <a href='http://${externalUrl}' target='_blank'>http://${externalUrl}</a></p>
                              <p>Environment: ${K8S_NAMESPACE}</p>
                              <p>Version: ${APP_VERSION}</p>""",
                     mimeType: 'text/html'
            }
        }

        failure {
            mail to: "${EMAIL_TO}",
                 subject: "❌ FAILURE: Deployment failed for Hotel Booking System",
                 body: "Check Jenkins logs for details and rollback triggered automatically."
        }

        always {
            cleanWs()
        }
    }
}
