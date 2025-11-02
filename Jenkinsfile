pipeline {
    agent any
    
    tools {
        maven 'M3'
        jdk 'JDK11'
    }
    
    environment {
        APP_NAME = 'hotel-booking-system'
        VERSION = '1.0.0'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-username/hotel-booking-system.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Docker Build') {
            steps {
                script {
                    docker.build("${APP_NAME}:${VERSION}")
                }
            }
        }
        
        stage('Deploy to Staging') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploying to staging environment...'
                // Add your deployment steps here
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline completed. Cleaning up...'
        }
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
