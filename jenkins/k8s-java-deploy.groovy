#!/usr/bin/env groovy

@Library('jenkins-library')_


pipeline {
    agent any

    // tools {
    // }

    stages {
        stage('Prepare & Checkout') {
            steps {
                // script {
                //     env.JENKINS_OPERATION="pipeline-java-image-deploy-ocp-prod"
                // }
                stagePrepareArgo()
            }
            post {
                success {
                    script {
                        announce("Stage success")
                        parametersLogging()
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
