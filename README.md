# SMALL COMPARISON BETWEEN DOCKERIZED KAFKA, DOCKERIZED LOCALSTACK AND DOCKERIZED ACTIVE MQ

## Methodology:

Create 2 seperated java services for each technology. Have one of them send current time every 1 second (producer) and
have second one consuming (consumer) this message, compare it to current time and calculate delay.

## Prerequisite:

* Docker with docker-compose
* Configured aws cli

## Running:

* Kafka `./run-kafka.sh`
* Localstack `./run-localstack.sh` -> helpful script for stopping all containers `./stop-localstack.sh`
* ActiveMQ `./run-activemq.sh`

## Example output:

Kafka 

    consumer_1   | 2021-04-04 19:32:33.002  INFO 1 --- [ntainer#0-0-C-1] pl.producer.integration.kafka.Consumer   : Received message on topic test: 19:32:33, delay is 2 milliseconds
    consumer_1   | 2021-04-04 19:32:34.003  INFO 1 --- [ntainer#0-0-C-1] pl.producer.integration.kafka.Consumer   : Received message on topic test: 19:32:34, delay is 3 milliseconds

Localstack

    2021-04-04 19:33:49.050  INFO 1 --- [ntContainer#0-2] p.c.i.jms.JmsMessageListener             : Received message 19:33:49.000288, delay is 50 milliseconds
    2021-04-04 19:33:50.048  INFO 1 --- [ntContainer#0-2] p.c.i.jms.JmsMessageListener             : Received message 19:33:50.000360, delay is 48 milliseconds

ActiveMQ

    consumer_1  | 2021-10-12 19:27:26.004  INFO 1 --- [enerContainer-1] p.p.integration.activemq.Consumer        : Received message on topic test: 19:27:26, delay is 4 milliseconds
    consumer_1  | 2021-10-12 19:27:27.005  INFO 1 --- [enerContainer-1] p.p.integration.activemq.Consumer        : Received message on topic test: 19:27:27.001, delay is 4 milliseconds

## References:

* Kafka
  [Dockerhub](https://hub.docker.com/r/bitnami/kafka/)
  [Github](https://github.com/bitnami/bitnami-docker-kafka)

* Localstack
  [Dockerhub](https://hub.docker.com/r/localstack/localstack)
  [Github](https://github.com/localstack/localstack)

* Activemq
  [Dockerhub](https://hub.docker.com/r/rmohr/activemq)
  [Github](https://github.com/apache/activemq)

* Docker-compose
  [Docs doker](https://docs.docker.com/compose/) 
  
* AWS CLI
  [AWS Amazon](https://aws.amazon.com/cli/)
