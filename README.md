# SMALL PROJECT USING DOCKERIZED KAFKA BROKER WITH SPRINGBOOT CONSUMER AND PRODUCER

About project:
    Project meant to create dockerized full flow of Kafka system.
    Producer sends message to topic every second with current time.
    Consumer reads messages and compares them with his current time.
    Calculated delay and prints it out.
    Example result:
   
        Sent message on topic test: 18:44:57.001
        Received message on topic test: 18:44:57.001, delay is 4 milliseconds
        Sent message on topic test: 18:44:58
        Received message on topic test: 18:44:58, delay is 3 milliseconds
    
Prerequisite:
    - Docker with docker-compose
    - Gradle in version >=4.10
    - Java 8
    
How to get it running:
    
    
    Clone repository
    Build both projects using `gradle build`
    Build docker images from both project and tag them `producer` / `consumer`
    Run docker compose
    
Using bitnami kafka images:

[Dockerhub](https://hub.docker.com/r/bitnami/kafka/)

[Github](https://github.com/bitnami/bitnami-docker-kafka)
