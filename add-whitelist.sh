#!/bin/bash
CONTROLLER_IP=localhost
CONTROLLER_REST_PORT=8080

curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/agent/add/json -X POST -d '{"ip-address":"10.0.0.11", "rest-ip-address":"192.168.100.1", "rest-port" : "8002" ,"control-port":"9998", "data-port":"9877", "feedback-port":"9998", "stats-port":"9999"}' | python -m json.tool
curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/agent/add/json -X POST -d '{"ip-address":"10.0.0.21", "rest-ip-address":"192.168.100.2", "rest-port" : "8002", "control-port":"9998", "data-port":"9877", "feedback-port":"9998", "stats-port":"9999"}' | python -m json.tool

curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/whitelist/add/json -X POST -d '{"server-ip-address":"10.0.0.211", "server-tcp-port":"5201", "client-ip-address":"10.0.0.111"}' | python -m json.tool
#curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/whitelist/add/json -X POST -d '{"server-ip-address":"10.0.0.111", "server-tcp-port":"5201", "client-ip-address":"10.0.0.211"}' | python -m json.tool

curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/config/json -X POST -d '{"parallel-connections":"4"}' | python -m json.tool
curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/config/json -X POST -d '{"queue-capacity":"4000"}' | python -m json.tool
curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/config/json -X POST -d '{"buffer-size":"60000"}' | python -m json.tool
curl http://$CONTROLLER_IP:$CONTROLLER_REST_PORT/wm/sos/config/json -X POST -d '{"idle-timeout":"2000"}' | python -m json.tool

exit 0
