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
        NEXUS_URL = 'http://13.203.26.99:8081/repository/maven-releases/'
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

        stage('Environment Setup') {
            steps {
                script {
                    echo "🔧 Setting up environment..."
                    sh '''
                    java -version
                    mvn --version
                    docker --version
                    kubectl version --client
                    '''
                }
            }
        }

        stage('Checkout Code') {
            steps {
                echo "📦 Checking out source code..."
                checkout scm
            }
        }

        stage('Build & Unit Test') {
            steps {
                echo "🧪 Building project and running tests..."
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Code Analysis') {
            steps {
                withSonarQubeEnv('Sonar-Server') {
                    echo "🔎 Running SonarQube analysis..."
                    sh '''
                    mvn sonar:sonar \
                        -Dsonar.projectKey=${APP_NAME} \
                        -Dsonar.host.url=http://${SONARQUBE_URL}:9000 \
                        -Dsonar.login=$SONAR_AUTH_TOKEN
                    '''
                }
            }
        }

        stage('Maven Package & Nexus Upload') {
            steps {
                withMaven(maven: 'Maven3') {
                    echo "📦 Packaging and uploading artifact to Nexus..."
                    sh '''
                    mvn clean package -DskipTests
                    mvn deploy -DskipTests -Dnexus.url=${NEXUS_URL}
                    '''
                }
            }
        }

        stage('Docker Build, Scan & Push') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-token', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        echo "🐳 Building Docker image..."
                        sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker build -t ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} .
                        docker tag ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} ${DOCKER_NAMESPACE}/${APP_NAME}:latest
                        docker push ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}
                        docker push ${DOCKER_NAMESPACE}/${APP_NAME}:latest
                        '''
                    }

                    echo "🛡️ Scanning Docker image with Trivy..."
                    sh '''
                    trivy image --severity HIGH,CRITICAL --exit-code 0 --no-progress ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}
                    '''
                }
            }
        }

        stage('Deploy to EKS') {
            steps {
                withCredentials([
                    [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                    file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                ]) {
                    script {
                        echo "🚀 Deploying application to EKS..."
                        sh '''
                        mkdir -p $WORKSPACE/.kube
                        cp $KUBECONFIG_FILE $WORKSPACE/.kube/config
                        chmod 600 $WORKSPACE/.kube/config
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

        stage('Blue-Green Switch') {
            when { expression { params.DEPLOYMENT_STRATEGY == 'blue-green' && params.AUTO_SWITCH == true } }
            steps {
                script {
                    echo "🔁 Switching service traffic to GREEN..."
                    withCredentials([
                        [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                        file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                    ]) {
                        sh '''
                        export KUBECONFIG=$WORKSPACE/.kube/config
                        aws eks get-token --cluster-name ${CLUSTER_NAME} --region ${REGION} > /tmp/token.json
                        TOKEN=$(jq -r .status.token /tmp/token.json)
                        kubectl config set-credentials arn:aws:eks:${REGION}:724663512594:cluster/${CLUSTER_NAME} --token="$TOKEN"

                        kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} \
                          --type merge \
                          -p '{"spec":{"selector":{"app":"hotel-booking","version":"green"}}}'
                        echo "✅ Switched traffic to GREEN version."
                        '''
                    }
                }
            }
        }

        stage('Health Check & Validation') {
            steps {
                script {
                    withCredentials([
                        [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                        file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                    ]) {
                        echo "🔍 Performing health checks..."
                        sh '''
                        export KUBECONFIG=$WORKSPACE/.kube/config
                        kubectl get pods -n ${K8S_NAMESPACE}
                        kubectl get svc -n ${K8S_NAMESPACE}
                        kubectl get endpoints -n ${K8S_NAMESPACE} hotel-booking-service -o wide

                        echo "Waiting for LoadBalancer external IP..."
                        sleep 60

                        EXTERNAL_URL=$(kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o jsonpath='{.status.loadBalancer.ingress[0].hostname}')
                        echo "🌍 Application URL: http://$EXTERNAL_URL"
                        echo "Running health check..."
                        curl -I http://$EXTERNAL_URL/actuator/health || true
                        '''
                    }
                }
            }
        }
    }

    post {
        success {
            script {
                echo "🎉 Deployment completed successfully!"
                emailext(
                    subject: "✅ SUCCESS: ${env.JOB_NAME} Build #${env.BUILD_NUMBER}",
                    body: """
                    Hi Saifudheen,

                    🎉 The Hotel Booking System was successfully deployed to EKS!

                    You can access it here:
                    http://\$(kubectl get svc hotel-booking-service -n hotel-booking -o jsonpath='{.status.loadBalancer.ingress[0].hostname}')

                    Jenkins console:
                    ${env.BUILD_URL}console

                    Regards,
                    Jenkins CI/CD
                    """,
                    to: "mesaifudheenpv@gmail.com"
                )
            }
        }

        failure {
            script {
                echo "❌ Deployment failed! Rolling back to BLUE..."
                withCredentials([
                    [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                    file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                ]) {
                    sh '''
                    export KUBECONFIG=$WORKSPACE/.kube/config
                    kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} \
                      --type merge \
                      -p '{"spec":{"selector":{"app":"hotel-booking","version":"blue"}}}' || true
                    '''
                }
                emailext(
                    subject: "❌ FAILURE: ${env.JOB_NAME} Build #${env.BUILD_NUMBER}",
                    body: """
                    Hi Saifudheen,

                    The deployment failed. The service has been rolled back to BLUE version.

                    Check Jenkins logs for details:
                    ${env.BUILD_URL}console
                    """,
                    to: "mesaifudheenpv@gmail.com"
                )
            }
        }

        always {
            cleanWs()
        }
    }
}
