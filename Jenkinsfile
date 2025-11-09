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
                echo "📦 Checking out code..."
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo "🧪 Running tests..."
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-token', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
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
                        echo "🔐 Setting up and authenticating to EKS..."
                        sh '''
                        mkdir -p $WORKSPACE/.kube
                        cp $KUBECONFIG_FILE $WORKSPACE/.kube/config
                        chmod 600 $WORKSPACE/.kube/config
                        export KUBECONFIG=$WORKSPACE/.kube/config

                        aws eks get-token --cluster-name ${CLUSTER_NAME} --region ${REGION} > /tmp/token.json
                        TOKEN=$(jq -r .status.token /tmp/token.json)
                        kubectl config set-credentials arn:aws:eks:${REGION}:724663512594:cluster/${CLUSTER_NAME} --token="$TOKEN"

                        echo "🎯 Deploying resources..."
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
                    echo "🔁 Switching traffic to GREEN version..."
                    withCredentials([
                        [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                        file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                    ]) {
                        sh '''
                        export KUBECONFIG=$WORKSPACE/.kube/config
                        aws eks get-token --cluster-name ${CLUSTER_NAME} --region ${REGION} > /tmp/token.json
                        TOKEN=$(jq -r .status.token /tmp/token.json)
                        kubectl config set-credentials arn:aws:eks:${REGION}:724663512594:cluster/${CLUSTER_NAME} --token="$TOKEN"

                        kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} -p '{"spec":{"selector":{"app":"hotel-booking","version":"green"}}}'
                        echo "✅ Switched to GREEN version."
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
                        aws eks get-token --cluster-name ${CLUSTER_NAME} --region ${REGION} > /tmp/token.json
                        TOKEN=$(jq -r .status.token /tmp/token.json)
                        kubectl config set-credentials arn:aws:eks:${REGION}:724663512594:cluster/${CLUSTER_NAME} --token="$TOKEN"

                        echo "✅ Nodes:"
                        kubectl get nodes

                        echo "✅ Pods:"
                        kubectl get pods -n ${K8S_NAMESPACE}

                        echo "✅ Services:"
                        kubectl get svc -n ${K8S_NAMESPACE}
                        '''
                    }
                }
            }
        }
    }

    post {
        success {
            echo "🎉 SUCCESS: Build and deployment completed successfully!"
        }
        failure {
            script {
                echo "❌ Deployment failed! Rolling back..."
                withCredentials([
                    [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
                    file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
                ]) {
                    sh '''
                    export KUBECONFIG=$WORKSPACE/.kube/config
                    aws eks get-token --cluster-name ${CLUSTER_NAME} --region ${REGION} > /tmp/token.json
                    TOKEN=$(jq -r .status.token /tmp/token.json)
                    kubectl config set-credentials arn:aws:eks:${REGION}:724663512594:cluster/${CLUSTER_NAME} --token="$TOKEN"

                    kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} -p '{"spec":{"selector":{"app":"hotel-booking","version":"blue"}}}' || true
                    echo "🔄 Rolled back to BLUE version."
                    '''
                }
            }
        }
        always {
            cleanWs()
        }
    }
}
