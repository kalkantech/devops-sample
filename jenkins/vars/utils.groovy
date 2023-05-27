#!/usr/bin/env groovy

def call() {
}

def shsilent(cmd) {
    sh('#!/bin/sh -e\n' + cmd )
}
