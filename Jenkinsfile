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
        stage('Upload to S3 (plugin)') {
            steps {
                // requires "Pipeline: AWS Steps" / S3 plugin and credential id 'aws-creds'
                s3Upload(bucket: 'my-jenkins-artifacts-ci-cd',
                         path: 'path/',
                         workingDir: 's3://my-jenkins-artifacts-ci-cd/WT_project/target',
                         includePathPattern: 'myartifact.zip',
                         acl: 'Private',
                         credentialsId: 'aws-creds')
            }
        }
    }
}