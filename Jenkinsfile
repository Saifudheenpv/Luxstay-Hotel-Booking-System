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
    }

    triggers { githubPush() }

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
                echo "📦 Checking out code..."
                checkout scm
            }
        }

        stage('Build, Test & Security Scan') {
            steps {
                withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
                    echo "🧪 Building, testing, and scanning dependencies..."
                    sh 'mvn clean verify -Dnvd.api.key=$NVD_API_KEY'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('Sonar-Server') {
                    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_AUTH_TOKEN')]) {
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
        }

        stage('Docker Build & Push') {
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
                        echo "🚀 Deploying to EKS..."
                        sh '''
                        mkdir -p $WORKSPACE/.kube
                        cp $KUBECONFIG_FILE $WORKSPACE/.kube/config
                        chmod 600 $WORKSPACE/.kube/config
                        export KUBECONFIG=$WORKSPACE/.kube/config

                        aws eks update-kubeconfig --name ${CLUSTER_NAME} --region ${REGION}

                        kubectl create namespace ${K8S_NAMESPACE} --dry-run=client -o yaml | kubectl apply -f -
                        kubectl apply -f k8s/mysql-deployment.yaml -n ${K8S_NAMESPACE}
                        kubectl apply -f k8s/mysql-service.yaml -n ${K8S_NAMESPACE}
                        kubectl apply -f k8s/app-deployment-blue.yaml -n ${K8S_NAMESPACE}
                        kubectl apply -f k8s/app-service.yaml -n ${K8S_NAMESPACE}
                        '''
                    }
                }
            }
        }

        stage('Blue-Green Switch') {
            when { expression { params.DEPLOYMENT_STRATEGY == 'blue-green' && params.AUTO_SWITCH } }
            steps {
                withCredentials([
                    [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                    file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                ]) {
                    script {
                        echo "🔁 Switching traffic to GREEN..."
                        sh '''
                        export KUBECONFIG=$WORKSPACE/.kube/config
                        aws eks update-kubeconfig --name ${CLUSTER_NAME} --region ${REGION}
                        kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} -p '{"spec":{"selector":{"app":"hotel-booking","version":"green"}}}'
                        '''
                    }
                }
            }
        }

        stage('Post-Deployment Validation') {
            steps {
                withCredentials([
                    [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                    file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                ]) {
                    script {
                        echo "🔍 Validating deployment..."
                        sh '''
                        export KUBECONFIG=$WORKSPACE/.kube/config
                        aws eks update-kubeconfig --name ${CLUSTER_NAME} --region ${REGION}
                        kubectl get pods -n ${K8S_NAMESPACE}
                        kubectl get svc -n ${K8S_NAMESPACE}
                        '''
                    }
                }
            }
        }
    }

    post {
        success {
            echo "🎉 SUCCESS: Deployed successfully!"
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
                    aws eks update-kubeconfig --name ${CLUSTER_NAME} --region ${REGION}
                    kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} -p '{"spec":{"selector":{"app":"hotel-booking","version":"blue"}}}' || true
                    '''
                }
            }
        }
        always {
            cleanWs()
        }
    }
}
