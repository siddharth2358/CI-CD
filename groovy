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
        stage('Upload to S3') { // New stage for S3 upload
            steps {
                s3Upload(
                    file: 'your-build-artifact.zip', // Replace with the path to your file
                    bucket: 'your-s3-bucket-name',   // Replace with your bucket name
                    credentialsId: 'aws-s3-upload-creds' // Replace with your credentials ID
                )
            }
        }
    }
}