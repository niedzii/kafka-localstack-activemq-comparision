#!/bin/bash
cd aws-localstack

( cd consumer && ./gradlew clean build && docker build . -t aws-consumer)
( cd producer && ./gradlew clean build && docker build . -t aws-producer)

docker-compose up -d

echo "Waiting for localstack full startup"
for i in {30..1..1}
  do
     echo "$i"
     sleep 1s
 done

./create_queue.sh

docker logs aws-localstack_consumer_1 -f -n 5