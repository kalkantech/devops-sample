#!/usr/bin/env groovy

import org.apache.commons.lang.StringUtils;

def call() {
    announce("Checkout projet git repository")

    sh "mkdir -p ${GITOPS_DIR}"
    dir("${GITOPS_DIR}") {
        def scmVars = checkout([$class: 'GitSCM',
        branches: [[name: "*/${GITOPS_REPO_BRANCH}"]],
        userRemoteConfigs: [[credentialsId: 'github-cred',url: "${GITOPS_REPO}"]]])

        env.GITOPS_BRANCH = scmVars.GIT_BRANCH
        env.GITOPS_COMMIT = scmVars.GIT_COMMIT
        env.GITOPS_PREVIOUS_COMMIT = scmVars.GIT_PREVIOUS_COMMIT
        env.GITOPS_PREVIOUS_SUCCESSFUL_COMMIT = scmVars.GIT_PREVIOUS_SUCCESSFUL_COMMIT
        env.GITOPS_URL = scmVars.GIT_URL
        env.GITOPS_COMMITTER_EMAIL = scmVars.GIT_COMMITTER_EMAIL
        env.GITOPS_AUTHOR_EMAIL = scmVars.GIT_AUTHOR_EMAIL
        env.GITOPS_COMMITTER_NAME = scmVars.GIT_COMMITTER_NAME
        env.GITOPS_AUTHOR_NAME = scmVars.GIT_AUTHOR_NAME
        env.GITOPS_REPO_NAME = StringUtils.substringBetween(scmVars.GIT_URL, "/", ".git")
        env.GITOPS_REPO_NAME = scmVars.GIT_URL.substring(scmVars.GIT_URL.lastIndexOf('/') + 1, scmVars.GIT_URL.lastIndexOf('.git'))
        sh 'git fetch origin'
        sh 'git checkout $GITOPS_REPO_BRANCH'
    }
}