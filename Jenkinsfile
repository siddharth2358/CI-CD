pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Pulls your code from GitHub
                git branch: 'main', url: 'https://github.com/siddharth2358/CI-CD.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building project..."
                // Add build steps here if needed, e.g., npm install, mvn package
            }
        }

        
    }
}
