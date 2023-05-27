#!/usr/bin/env groovy

@Library('jenkins-library')_


pipeline {
    agent any

    // tools {
    // }

    stages {
        stage('Prepare & Checkout') {
            steps {
                stagePrepareArgo()
                sh '''
                    whoami
                '''
            }
            post {
                success {
                    script {
                        announce("Stage success")
                    }
                }
                failure {
                    script {
                        announce("Pipeline failure")
                        parametersLogging()
                    }
                }
            }
        }
        stage('Build Artifact') {
            steps {
                stageBuildArtifact()
            }
            post {
                success {
                    script {
                        announce("Stage success")
                    }
                }
                failure {
                    script {
                        announce("Pipeline failure")
                        parametersLogging()
                    }
                }
            }
        }
    }
}
