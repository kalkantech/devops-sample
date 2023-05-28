#!/usr/bin/env groovy

def call() {
    announce("OpenShift prod environment deployment using helm chart")

    //Prepare helm package
    utils.shsilent("""

            yq eval -i .image.repository=\\"${DOCKER_REPO_NAME}/${JAVA_JAR_NAME}\\" ${GITOPS_DIR}/values/${JENKINS_APP_GIT_REPO_NAME}/values.yml
            yq eval -i .image.tag=\\"${APP_VERSION}\\" ${GITOPS_DIR}/values/${JENKINS_APP_GIT_REPO_NAME}/values.yml
            
    """)
    // dir("${GITOPS_DIR}") {
    //     sh("""
    //             git add values/*; git commit -m "New release for ${JENKINS_APP_GIT_REPO_NAME}"; git push origin ${GITOPS_REPO_BRANCH} --force;
    //     """)
    // }
}