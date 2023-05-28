#!/usr/bin/env groovy

def call() {
    parametersStatic()
    checkoutApp()
    checkoutGitops()
    parametersDynamic()
}