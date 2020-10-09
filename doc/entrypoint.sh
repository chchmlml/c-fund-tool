#!/bin/bash
set -e
port=10801
app_name="superfans-configcenter"
local_ip=$(ip a show dev eth0|grep -w inet|awk '{print $2}'|awk -F '/' '{print $1}')
if [[ -z "$local_ip" ]]; then
    local_ip=$(ip a show dev eth2|grep -w inet|awk '{print $2}'|awk -F '/' '{print $1}')
fi
agent_id="sfcc_${local_ip}"
java -jar -javaagent:/opt/app/pinpoint/pinpoint-bootstrap-1.8.3.jar \
     -Dpinpoint.agentId="${agent_id}" -Dpinpoint.applicationName=${app_name} \
     /workspace/app.jar --server.port=${port} --spring.profiles.active=prod
