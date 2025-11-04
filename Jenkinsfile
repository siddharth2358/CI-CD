pipeline {
    agent any
    triggers {
        // trigger builds on GitHub pushes
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
        stage('Test') {
            steps {
                echo 'Running tests...'
                // run tests here, e.g. sh 'npm test' or mvn test
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging artifact...'
                // create target/myartifact.zip here, e.g. sh 'zip -r target/myartifact.zip .'
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/myartifact.zip', fingerprint: true
            }
        }
        stage('Upload to S3') {
    steps {
        withAWS(region: 'ap-south-1', credentials: 'aws-creds') {
            s3Upload(
                file: 'target/myartifact.zip',
                bucket: 'my-jenkins-artifacts-ci-cd',
                path: 'builds/myartifact.zip'
            )
        }
    }
}
