#!/usr/bin/env groovy

def call() {

    utils.shsilent("""
    mvn -f ${JENKINS_APP_DIR}/ -q clean package \
        -Dmaven.test.skip=true \
        -DskipTests

    """)
}