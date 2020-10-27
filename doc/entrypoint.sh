#!/bin/bash
set -e
port=8888
java -jar /workspace/app.jar --server.port=${port} --spring.profiles.active=prod
