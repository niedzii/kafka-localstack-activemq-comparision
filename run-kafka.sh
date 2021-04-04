#!/bin/bash
( cd kafka/consumer ; ./gradlew clean build ; docker build . -t kafka-consumer)
( cd kafka/producer ; ./gradlew clean build ; docker build . -t kafka-producer)
( cd kafka ; docker-compose up)
