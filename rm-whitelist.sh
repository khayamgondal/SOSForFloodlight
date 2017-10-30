#!/usr/bin/env bash

CONTROLLER_IP=localhost
CONTROLLER_REST_PORT=8080

curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/whitelist/remove/json
