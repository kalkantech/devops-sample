#!/usr/bin/env groovy
import org.apache.commons.lang.StringUtils;

def call() {
    announce("Preparing static parameters")
    
    env.JENKINS_APP_DIR=REPO_URL.substring(REPO_URL.lastIndexOf('/') + 1, REPO_URL.lastIndexOf('.git'))
    env.JAVA_BASE_IMAGE='openjdk:18'
    env.JAVA_JAR_NAME="demo"
    env.DOCKER_FILE_PATH="Docker/Dockerfile"
    env.DOCKER_REPO_NAME="shield07"
    env.GITOPS_REPO="https://github.com/kalkantech/gitops-sample.git"
    env.GITOPS_REPO_BRANCH="main"
    GIT_CREDS = credentials("github-cred")
    env.GITOPS_DIR=GITOPS_REPO.substring(GITOPS_REPO.lastIndexOf('/') + 1, GITOPS_REPO.lastIndexOf('.git'))
    withCredentials([usernamePassword(credentialsId: "docker", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
        env.DOCKER_USER="${USERNAME}"
        env.DOCKER_USER_PASSWORD="${PASSWORD}"
    }
}