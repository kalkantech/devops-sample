#!/usr/bin/env groovy

def call() {
    
    StringBuilder result = new StringBuilder();
    try { result.append("JENKINS_URL: ${JENKINS_URL} | Jenkins build URL").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("BUILD_ID: ${BUILD_ID} | Jenkins build ID").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_PIPELINE_ENVIRONMENT_NAME: ${JENKINS_PIPELINE_ENVIRONMENT_NAME} | pipeline environment").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_NAME: ${JENKINS_APP_NAME} | application name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_VERSION: ${JENKINS_APP_VERSION} | application version").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_VERSION_OLD: ${JENKINS_APP_VERSION_OLD} | application- old version").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_LANGUAGE: ${JENKINS_APP_LANGUAGE} | Project language").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_DEPARTMENT: ${JENKINS_APP_DEPARTMENT} | application owner department").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_BITBUCKET_PROJECT: ${JENKINS_APP_BITBUCKET_PROJECT} | Git repo project").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_URL: ${JENKINS_APP_GIT_URL} | Git repo URL").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_REPO_NAME: ${JENKINS_APP_GIT_REPO_NAME} | Git repo name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_BRANCH: ${JENKINS_APP_GIT_BRANCH} | Git repo branch name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_COMMIT: ${JENKINS_APP_GIT_COMMIT} | Git commit ID").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_PREVIOUS_COMMIT: ${JENKINS_APP_GIT_PREVIOUS_COMMIT} ").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_PREVIOUS_SUCCESSFUL_COMMIT: ${JENKINS_APP_GIT_PREVIOUS_SUCCESSFUL_COMMIT} ").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_NGINX_GIT_URL: ${JENKINS_APP_NGINX_GIT_URL} | NGINX Git repo URL").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_NGINX_GIT_REPO_NAME: ${JENKINS_APP_NGINX_GIT_REPO_NAME} | NGINX Git repo name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_NGINX_GIT_BRANCH: ${JENKINS_APP_NGINX_GIT_BRANCH} | NGINX Git repo branch name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_NGINX_GIT_COMMIT: ${JENKINS_APP_NGINX_GIT_COMMIT} | NGINX Git commit ID").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_NGINX_GIT_PREVIOUS_COMMIT: ${JENKINS_APP_NGINX_GIT_PREVIOUS_COMMIT} ").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_NGINX_GIT_PREVIOUS_SUCCESSFUL_COMMIT: ${JENKINS_APP_NGINX_GIT_PREVIOUS_SUCCESSFUL_COMMIT} ").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_JFROG_ARTIFACT_REGISTRY_REPO_NAME: ${JENKINS_JFROG_ARTIFACT_REGISTRY_REPO_NAME} | application artifact repo name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME: ${JENKINS_JFROG_IMAGE_REGISTRY_REPO_NAME} | application image repo name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_JFROG_IMAGE_REGISTRY_BASE_IMAGE: ${JENKINS_JFROG_IMAGE_REGISTRY_BASE_IMAGE} | application base image").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_JFROG_IMAGE_REGISTRY_BASE_IMAGE2: ${JENKINS_JFROG_IMAGE_REGISTRY_BASE_IMAGE2} | application second base image").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_OCP_DEV_NAMESPACE_NAME: ${JENKINS_APP_HELM_NAMESPACE} | OpenShift DEV namespace name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_HELM_LOCATION_PATH: ${JENKINS_HELM_LOCATION_PATH} | Jenkins helm location path").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_DOCKER_FILE_PATH: ${JENKINS_DOCKER_FILE_PATH} | Jenkins docker file location path").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_AWS_ACCESS_DOMAIN: ${JENKINS_AWS_ACCESS_DOMAIN} | AWS domain name").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_AWS_ARTIFACT_REGISTRY_REPO_NAME: ${JENKINS_AWS_ARTIFACT_REGISTRY_REPO_NAME} | AWS registry repo").append(System.getProperty("line.separator"));  } catch(Exception ex) { }    
    try { result.append("JENKINS_APP_STG_VER: ${JENKINS_APP_STG_VER} | Application STG Version").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_COMMITTER_EMAIL: ${JENKINS_APP_GIT_COMMITTER_EMAIL} ").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_COMMITTER_NAME: ${JENKINS_APP_GIT_COMMITTER_NAME} ").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_AUTHOR_EMAIL: ${JENKINS_APP_GIT_AUTHOR_EMAIL} ").append(System.getProperty("line.separator"));  } catch(Exception ex) { }
    try { result.append("JENKINS_APP_GIT_AUTHOR_NAME: ${JENKINS_APP_GIT_AUTHOR_NAME} ").append(System.getProperty("line.separator"));  } catch(Exception ex) { }    

    echo result.toString()

}