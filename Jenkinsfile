pipeline {
    agent any

    stages {
        stage('Build-JAR') {
            steps {
                script {
                    if (isUnix()) {
                        sh "gradle clean dockerResources"
                    } else {
                        bat "gradle clean dockerResources"
                    }
                }
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Docker-Cred',
                                                 usernameVariable: 'DOCKER_USER',
                                                 passwordVariable: 'DOCKER_PASS')]) {
                    script {
                        if (isUnix()) {
                            sh """
                                echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                                docker build -t $DOCKER_USER/selenium-docker:latest .
                                docker tag $DOCKER_USER/selenium-docker:latest $DOCKER_USER/selenium-docker:${env.BUILD_NUMBER}
                                docker push $DOCKER_USER/selenium-docker:${env.BUILD_NUMBER}
                            """
                        } else {
                            bat """
                                echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
                                docker build -t %DOCKER_USER%/selenium-docker:latest .
                                docker tag %DOCKER_USER%/selenium-docker:latest %DOCKER_USER%/selenium-docker:%BUILD_NUMBER%
                                docker push %DOCKER_USER%/selenium-docker:%BUILD_NUMBER%
                            """
                        }
                    }
                }
            }
        }
    }

    post {
        always {
            script {
                if (isUnix()) {
                    sh "docker logout"
                } else {
                    bat "docker logout"
                }
            }
        }
    }
}