#!/bin/bash
( cd activemq/consumer ; ./gradlew clean build ; docker build . -t activemq-consumer)
( cd activemq/producer ; ./gradlew clean build ; docker build . -t activemq-producer)
( cd activemq ; docker-compose up)
