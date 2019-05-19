#!/bin/bash
mvn clean install

docker build -t in-memory-service:1.0 .
docker run -p 9200:9200 in-memory-service:1.0