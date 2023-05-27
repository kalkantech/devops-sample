#!/usr/bin/env groovy

def call() {
    script {
        announce("Build image and deploy image repository")
        buildImage()
    }
}