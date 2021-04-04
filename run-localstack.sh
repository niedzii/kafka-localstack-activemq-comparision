#!/bin/bash
cd aws-localstack

( cd consumer && ./gradlew clean build && docker build . -t aws-consumer)
( cd producer && ./gradlew clean build && docker build . -t aws-producer)

docker-compose up -d

echo "Waiting for localstack full startup"
# Waiting for localstack to fully start before creating queue
sleep 15s

./create_queue.sh

docker logs aws-localstack_consumer_1 -f -n 5