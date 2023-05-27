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
        sudo docker build -t tagname ./${JENKINS_APP_DIR}

        ## Docjer Push

        #XRAY PRO PRIMARY PODMAN LOGIN
        sudo podman login -u ${JENKINS_JFROG_IMAGE_REGISTRY_JENKINS_USER} -p ${JENKINS_JFROG_IMAGE_REGISTRY_JENKINS_USER_TOKEN} ${JENKINS_JFROG_IMAGE_REGISTRY_DNS}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT} --tls-verify=false
    """)

    sh """
        #XRAY PRO PRIMARY PUSH
        sudo podman build -f ${DOCKER_FILE_PATH}-tmp --tls-verify=false -t ${JENKINS_JFROG_IMAGE_REGISTRY_DNS}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT}/${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME}/${JENKINS_APP_NAME}:${JENKINS_APP_VERSION} ./${JENKINS_APP_DIR}
        sudo podman push ${JENKINS_JFROG_IMAGE_REGISTRY_DNS}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT}/${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME}/${JENKINS_APP_NAME}:${JENKINS_APP_VERSION} --tls-verify=false --remove-signatures
    """

    utils.getirshsilent("""
        #XRAY OSS DRC PODMAN LOGIN
        sudo podman login -u ${JENKINS_JFROG_IMAGE_REGISTRY_JENKINS_USER_DRC} -p ${JENKINS_JFROG_IMAGE_REGISTRY_JENKINS_USER_TOKEN_DRC} ${JENKINS_JFROG_IMAGE_REGISTRY_DNS_DRC}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT_DRC} --tls-verify=false
    """)

    sh """
        #XRAY OSS DRC PUSH
        sudo podman tag ${JENKINS_JFROG_IMAGE_REGISTRY_DNS}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT}/${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME}/${JENKINS_APP_NAME}:${JENKINS_APP_VERSION} ${JENKINS_JFROG_IMAGE_REGISTRY_DNS_DRC}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT_DRC}/${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME}/${JENKINS_APP_NAME}:${JENKINS_APP_VERSION}
        sudo podman push ${JENKINS_JFROG_IMAGE_REGISTRY_DNS_DRC}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT_DRC}/${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME}/${JENKINS_APP_NAME}:${JENKINS_APP_VERSION} --tls-verify=false --remove-signatures


        if ! sudo podman rmi ${JENKINS_JFROG_IMAGE_REGISTRY_DNS}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT}/${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME}/${JENKINS_APP_NAME}:${JENKINS_APP_VERSION} ; then echo "image does not exist"; fi
        if ! sudo podman rmi ${JENKINS_JFROG_IMAGE_REGISTRY_DNS_DRC}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT_DRC}/${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME}/${JENKINS_APP_NAME}:${JENKINS_APP_VERSION} ; then echo "image does not exist"; fi
    """

    utils.getirshsilent("""
        echo Image URL: ${JENKINS_JFROG_IMAGE_REGISTRY_PROTOCOL}://${JENKINS_JFROG_IMAGE_REGISTRY_DNS}:${JENKINS_JFROG_IMAGE_REGISTRY_PORT}/artifactory/${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME}/${JENKINS_APP_NAME}/${JENKINS_APP_VERSION}
    """)
}
