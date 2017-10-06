#!/bin/bash
#author Khayam Anjam kanjam@g.clemson.edu
#Easy script to start controller. Run it on your controller node (Vagrant VM)
#Note! it will start the controller inside the screen

cd  /home/ubuntu/sos-for-floodlight
java -jar target/floodlight.jar
