pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
            }
        }
        stage('Build') {
            steps {
                echo 'Building project...'
            }
        }
        stage('Upload to S3') {
            steps {
                s3Upload(
                    entries: [
                        [
                            bucket: 'your-s3-bucket-name',
                            credentialsId: 'aws-s3-upload-creds',
                            file: 'your-build-artifact.zip',
                            path: 'optional-path-in-bucket'
                        ]
                    ]
                )
            }
        }
    }
}