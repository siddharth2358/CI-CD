pipeline {
    agent any

    triggers {
        // Trigger builds automatically when GitHub push events occur
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
                // Example: git branch: 'main', url: 'https://github.com/siddharth2358/CI-CD.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                // Example build command: sh 'mvn clean package' or npm run build
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Example: sh 'mvn test' or npm test
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging artifact...'
                // Example: sh 'mkdir -p target && zip -r target/myartifact.zip .'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/myartifact.zip', fingerprint: true
            }
        }

       stage('Upload to S3') {
    steps {
        withAWS(region: 'us-east-1', credentials: 'aws-creds') {
            s3Upload(
                file: 'target/myartifact.zip',
                bucket: 'my-jenkins-artifacts-ci-cd',
                path: 'builds/myartifact.zip'
            )
        }
    }
}


    post {
        success {
            echo '✅ Build and upload completed successfully!'
        }
        failure {
            echo '❌ Build failed. Check the console logs for details.'
        }
    }
}
