pipeline {
    agent any
    triggers {
        githubPush()
    }

    environment {
        AWS_REGION = 'us-east-1'   // ✅ Match your S3 bucket's region
        S3_BUCKET = 'my-jenkins-artifacts-ci-cd'
        ARTIFACT_NAME = 'myartifact.zip'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                // Simulate a build step (e.g., npm build, mvn package, etc.)
                sh 'mkdir -p target'
                sh 'echo "This is a sample artifact" > target/build_output.txt'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging artifact...'
                sh 'cd target && zip -r myartifact.zip build_output.txt'
            }
        }

        stage('Upload to S3') {
            steps {
                withAWS(credentials: 'aws-creds', region: "${AWS_REGION}") {
                    echo "Uploading ${ARTIFACT_NAME} to S3..."
                    s3Upload(
                        file: "target/${ARTIFACT_NAME}",
                        bucket: "${S3_BUCKET}",
                        path: "builds/${ARTIFACT_NAME}",
                        acl: 'Private'
                    )
                }
            }
        }
    }

    post {
        success {
            echo "✅ Build and upload successful!"
        }
        failure {
            echo "❌ Build failed. Check the console logs for details."
        }
    }
}
