pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/shobha24gadad/demomaven.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t demomaven:v1 .'
            }
        }

        stage('Remove Old Container') {
            steps {
                bat 'docker rm -f demomaven-app || exit /b 0'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8081:8080 --name demomaven-app demomaven:v1'
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }

        failure {
            echo 'Pipeline failed.'
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}