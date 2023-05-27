#!/usr/bin/env groovy
import org.apache.commons.lang.StringUtils;

def call() {
    announce("Preparing dynamic parameters")
    
    pom = readMavenPom file: "${JENKINS_APP_DIR}/pom.xml"
    env.PROJECT_VERSION=pom.version
}