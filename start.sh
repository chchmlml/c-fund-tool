#!/bin/bash
set -e

nohup java -jar target/bin/app.jar --server.port=18001 --spring.profiles.active=prod >system.log &

