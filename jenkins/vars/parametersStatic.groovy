#!/usr/bin/env groovy
import org.apache.commons.lang.StringUtils;

def call() {
    announce("Preparing static parameters")
    
    env.JENKINS_APP_DIR=REPO_URL.substring(REPO_URL.lastIndexOf('/') + 1, REPO_URL.lastIndexOf('.git'))
    // withCredentials([usernamePassword(credentialsId: "bitbucket-git-credential-sa-with-app-password", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
    //     env.JENKINS_BITBUCKET_SA_USER="${USERNAME}"
    //     env.JENKINS_BITBUCKET_SA_USER_PASSWORD="${PASSWORD}"
    // }
}