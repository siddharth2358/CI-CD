Set-Content -Path .\Jenkinsfile @"
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/siddharth2358/CI-CD.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building project..."
            }
        }
    }
}

