pipeline{

	agent any

	environment {
    	browser="chrome"
        executionType="local"
    	hubURL="http://localhost:4444/"
    }

	stages{
		stage('Build-JAR') {
			steps{
				bat "gradle clean dockerResources"
			}
		}

		stage('Build Docker Image') {
			steps{
			    bat "docker build -t selenium-docker ."
			}
		}

		stage('Push Image') {
			steps{
				bat "docker push selenium-docker"
			}
		}
	}
}