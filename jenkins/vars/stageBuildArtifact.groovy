#!/usr/bin/env groovy

def call() {
    script {
        announce("Build artifact")
        buildMaven()
    }
}