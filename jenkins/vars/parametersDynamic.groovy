#!/usr/bin/env groovy
import org.apache.commons.lang.StringUtils;

def call() {
    announce("Preparing dynamic parameters")
    
    // readMavenPom requires Pipeline Utility steps plugin
    pom = readMavenPom file: "${JENKINS_APP_DIR}/pom.xml"
    env.APP_VERSION=pom.version
}