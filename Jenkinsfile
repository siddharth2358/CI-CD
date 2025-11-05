pipeline {
    agent any

    environment {
        // Ensure AWS SDK uses the correct region
        AWS_REGION = 'us-east-1'
        AWS_DEFAULT_REGION = 'us-east-1'
    }

    triggers {
        // Trigger build automatically when GitHub push events occur
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
                // Example:
                // git branch: 'main', url: 'https://github.com/siddharth2358/CI-CD.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                // Example:
                // sh 'mvn clean package'
                // or sh 'npm run build'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Example:
                // sh 'mvn test'
                // or sh 'npm test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging artifact...'
                // Example:
                // sh 'mkdir -p target && zip -r target/myartifact.zip .'
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
                    echo 'Uploading artifacts to S3...'

                    // Upload all files inside the WT_project directory
                    s3Upload(
                        bucket: 'my-jenkins-artifacts-ci-cd',
                        workingDir: 'WT_project',
                        path: 'WT_project/',
                        includePathPattern: '**/*',
                        excludePathPattern: '.git/**',
                        acl: 'Private'
                    )
                }
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
