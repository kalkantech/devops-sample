#!/usr/bin/env groovy

def call() {
    announce("Update ArgoCD Repo")

    //Prepare helm package
    utils.shsilent("""

            yq eval -i .image.repository=\\"${DOCKER_REPO_NAME}/${JAVA_JAR_NAME}\\" ${GITOPS_DIR}/values/${JENKINS_APP_GIT_REPO_NAME}/values.yaml
            yq eval -i .image.tag=\\"${APP_VERSION}\\" ${GITOPS_DIR}/values/${JENKINS_APP_GIT_REPO_NAME}/values.yaml
            
    """)
    dir("${GITOPS_DIR}") {
        withCredentials([usernamePassword(credentialsId: 'github-cred',
            usernameVariable: 'username',
            passwordVariable: 'password')]){
                sh '''
                    git add values/*; git commit -m "New release for ${JENKINS_APP_GIT_REPO_NAME}"; git push http://$username:$password@$GITOPS_PUSH_REPO ${GITOPS_REPO_BRANCH};
                '''
        }
        // sh 'git remote set-url --add --push origin https://$GIT_CREDS@$GITOPS_PUSH_REPO'
        // sh("""
        //         git add values/*; git commit -m "New release for ${JENKINS_APP_GIT_REPO_NAME}"; git push origin ${GITOPS_REPO_BRANCH};
        // """)
    }
}