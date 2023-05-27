#!/usr/bin/env groovy

def call(String announceStr = 'This is announce') {


    def announceStrUpper = sh(returnStdout: true, script: '#!/bin/sh -e\n' + "echo ${announceStr} | tr '[:lower:]' '[:upper:]'").trim()

    utils.shsilent("""
    echo "************************************************************************************************************
                                        $announceStrUpper
************************************************************************************************************"
    """)
}