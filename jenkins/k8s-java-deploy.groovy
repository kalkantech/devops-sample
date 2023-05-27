#!/usr/bin/env groovy

@Library('jenkins-library')_


pipeline {
    agent any

    tools {
        maven 'mvn 3.9.2'
    }

    stages {
        stage('Prepare & Checkout') {
            steps {
                stagePrepareArgo()
                echo "${PROJECT_VERSION}"
                sh '''
                    whoami
                    echo ${PROJECT_VERSION}
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
        // stage('Build Image & Deploy') {
        //     steps {
        //         stageBuildImage()
        //     }
        //     post {
        //         success {
        //             script {
        //                 announce("Stage success")
        //             }
        //         }
        //         failure {
        //             script {
        //                 announce("Pipeline failure")
        //                 parametersLogging()
        //             }
        //         }
        //     }
        // }
    }
}
