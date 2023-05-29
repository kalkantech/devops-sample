#!/usr/bin/env groovy

def call() {
    utils.shsilent("""
        
        # This below line will be deleted, it's just work with demo purpose
        cat ${DOCKER_FILE_PATH} | envsubst | tee ${JENKINS_APP_DIR}/Dockerfile &> /dev/null
        # # If dockerfile does not exist, create it?
        # if [ ! -f ${JENKINS_APP_DIR}/Dockerfile ]; then
        #     #change docker file variables
        #     cat ${DOCKER_FILE_PATH} | envsubst | tee ${JENKINS_APP_DIR}/Dockerfile &> /dev/null
        # fi

        ## Docker login
        docker login -u ${DOCKER_USER} -p ${DOCKER_USER_PASSWORD}
        ## Docker build
        docker build -t ${DOCKER_REPO_NAME}/${JAVA_JAR_NAME}:${APP_VERSION} ./${JENKINS_APP_DIR}

        ## Docjer Push
        docker push ${DOCKER_REPO_NAME}/${JAVA_JAR_NAME}:${APP_VERSION}
    """)

    utils.shsilent("""
        echo Image : ${DOCKER_REPO_NAME}/${JAVA_JAR_NAME}:${APP_VERSION}
    """)
}
