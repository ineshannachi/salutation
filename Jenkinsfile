pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "hannachi400/spring-boot-salutation"
        DOCKER_TAG = "latest"
        DOCKER_REGISTRY_CREDENTIALS = 'dockerhub_credentials_id'
    }
    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/ineshannachi/salutation.git'
            }
        }
        stage('Build Project') {
            steps {
                // Make mvnw executable
                sh 'chmod +x ./mvnw'
                sh './mvnw clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }
        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: "${DOCKER_REGISTRY_CREDENTIALS}", url: ""]) {
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }
    }
}
