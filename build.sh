#!/bin/bash
set -e
# SOURCE_ROOT=$(dirname $(pwd))
SOURCE_ROOT=$(cd "$(dirname "$0")";pwd)
MAVEN_FLAGS="-U -Dmaven.test.skip -am"
MAVEN_GOALS="clean package"
MAVEN_POM_FILE="${SOURCE_ROOT}/pom.xml"
MAVEN_SETTINGS_FILE="${SOURCE_ROOT}/doc/settings.xml"
TARGET_NAME="target"
BIN_NAME="bin"
DOCKER_COMPOSE_FILE="docker-compose.yml"
RUN_SHELL="entrypoint.sh"
TARGET_JAR=""
TARGET_PATH="${SOURCE_ROOT}/${TARGET_NAME}"
TARGET_BIN_PATH="${SOURCE_ROOT}/${TARGET_NAME}/${BIN_NAME}"
TARGET_DOCKER_COMPOSE_FILE="${TARGET_BIN_PATH}/${DOCKER_COMPOSE_FILE}"
TARGET_VERSION="*"
IS_WEB_SERVICE=1

TARGET_JAR="${TARGET_BIN_PATH}/app.jar"
BUILD_PATH="${SOURCE_ROOT}"
BUILD_DOCKER_COMPOSE_FILE="${BUILD_PATH}/doc/${DOCKER_COMPOSE_FILE}"
BUILD_TARGET_PATH="${BUILD_PATH}/${TARGET_NAME}"
BUILD_TARGET_JAR="${BUILD_TARGET_PATH}/${TARGET_VERSION}.jar"

echo ">>> Start build ..."
echo ">>> mvn -f ${MAVEN_POM_FILE} ${MAVEN_FLAGS}  ${MAVEN_GOALS} -s ${MAVEN_SETTINGS_FILE}"

mvn -f ${MAVEN_POM_FILE} ${MAVEN_FLAGS}  ${MAVEN_GOALS}
#mvn -f ${MAVEN_POM_FILE} ${MAVEN_FLAGS}  ${MAVEN_GOALS} -s ${MAVEN_SETTINGS_FILE}

echo ">>> Build completed."

if [[ ${IS_WEB_SERVICE} == 1 ]]; then
    if [[ ! -d ${TARGET_BIN_PATH} ]]; then
        echo ">>> Start create target directory..."
        echo ">>> mkdir -p ${TARGET_BIN_PATH}"
        mkdir -p ${TARGET_BIN_PATH}
    fi

    echo ">>> Move target files..."
#    echo ">>> cp ${BUILD_PATH}/deploy/${RUN_SHELL} ${TARGET_BIN_PATH}/${RUN_SHELL}"
#    cp "${BUILD_PATH}/deploy/${RUN_SHELL}" ${TARGET_BIN_PATH}/${RUN_SHELL}
    echo ">>> cp ${BUILD_TARGET_JAR} ${TARGET_JAR}"
    cp ${BUILD_TARGET_JAR} ${TARGET_JAR}
#    echo ">>> cp ${BUILD_DOCKER_COMPOSE_FILE} ${TARGET_DOCKER_COMPOSE_FILE}"
#    cp ${BUILD_DOCKER_COMPOSE_FILE} ${TARGET_DOCKER_COMPOSE_FILE}
fi