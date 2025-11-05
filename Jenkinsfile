pipeline {
    agent any

    environment {
        // ensure AWS SDK uses the bucket region
        AWS_REGION = 'us-east-1'
        AWS_DEFAULT_REGION = 'us-east-1'
    }

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
                    // upload all files inside the WT_project directory (preserves structure)
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


    post {
        success {
            echo '✅ Build and upload completed successfully!'
        }
        failure {
            echo '❌ Build failed. Check the console logs for details.'
        }
    }
}
