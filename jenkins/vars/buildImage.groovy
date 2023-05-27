#!/usr/bin/env groovy

def call() {
    utils.shsilent("""
        
        # If dockerfile does not exist, create it?
        if [ ! -f ${JENKINS_APP_DIR}/Dockerfile ]; then
            #change docker file variables
            cat ${DOCKER_FILE_PATH} | envsubst | tee ${JENKINS_APP_DIR}/Dockerfile &> /dev/null
        fi

        ## Docker login
        sudo docker login -u ${DOCKER_USER} -p ${DOCKER_USER_PASSWORD}
        ## Docker build
        sudo docker build -t ${DOCKER_REPO_NAME}/${JENKINS_APP_NAME}:${APP_VERSION} ./${JENKINS_APP_DIR}

        ## Docjer Push
        #sudo docker push ${DOCKER_REPO_NAME}/${JENKINS_APP_NAME}:${APP_VERSION}
    """)

    utils.shsilent("""
        echo Image : ${DOCKER_REPO_NAME}/${JENKINS_APP_NAME}:${APP_VERSION}
    """)
}
