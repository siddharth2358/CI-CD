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
        stage(
    // Required parameters from your error log
    profileName: '',
    userMetadata: '',
    dontWaitForConcurrentBuildCompletion: false,
    consoleLogLevel: 'INFO',
    pluginFailureResultConstraint: 'FAILURE',
    dontSetBuildResultOnFailure: false,
    // The rest of your S3 settings
    entries: [
        [
            bucket: 'my-jenkins-artifacts-ci-cd',
            credentialsId: 'aws-s3-upload-creds',
            file: 'your-build-artifact.zip',
            path: 'optional-path-in-bucket'
        ]
    ]
) {
            }
        }
    }
