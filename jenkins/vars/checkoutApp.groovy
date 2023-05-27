#!/usr/bin/env groovy

import org.apache.commons.lang.StringUtils;

def call() {
    announce("Checkout projet git repository")

    sh "mkdir -p ${JENKINS_APP_DIR}"
    dir("${JENKINS_APP_DIR}") {
        def scmVars = checkout([$class: 'GitSCM',
        branches: [[name: "*/${REPO_BRANCH}"]],
        userRemoteConfigs: [[url: "${REPO_URL}"]]])

        env.JENKINS_APP_GIT_BRANCH = scmVars.GIT_BRANCH
        env.JENKINS_APP_GIT_COMMIT = scmVars.GIT_COMMIT
        env.JENKINS_APP_GIT_PREVIOUS_COMMIT = scmVars.GIT_PREVIOUS_COMMIT
        env.JENKINS_APP_GIT_PREVIOUS_SUCCESSFUL_COMMIT = scmVars.GIT_PREVIOUS_SUCCESSFUL_COMMIT
        env.JENKINS_APP_GIT_URL = scmVars.GIT_URL
        env.JENKINS_APP_GIT_COMMITTER_EMAIL = scmVars.GIT_COMMITTER_EMAIL
        env.JENKINS_APP_GIT_AUTHOR_EMAIL = scmVars.GIT_AUTHOR_EMAIL
        env.JENKINS_APP_GIT_COMMITTER_NAME = scmVars.GIT_COMMITTER_NAME
        env.JENKINS_APP_GIT_AUTHOR_NAME = scmVars.GIT_AUTHOR_NAME
        env.JENKINS_APP_GIT_REPO_NAME = StringUtils.substringBetween(scmVars.GIT_URL, "/", ".git")
        env.JENKINS_APP_GIT_REPO_NAME = scmVars.GIT_URL.substring(scmVars.GIT_URL.lastIndexOf('/') + 1, scmVars.GIT_URL.lastIndexOf('.git'))
    }
}