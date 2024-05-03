# Messaging with RabbitMQ Example
This project demonstrates how to use AMQP messaging with Spring Boot and RabbitMQ. It connects to an existing instance of RabbitMQ with coordinates provided in application properties.

A local RabbitMQ instance can be run using Docker/Podman

## Topics
* Messaging with AMQP
* Sending/Receiving
* De/Serialize JSON messages
* Receiving from multiple queues
* RabbitMQ admin interface

## How to Run

    mvn clean package
    java -jar target/rabbit-mq-0.0.1-SNAPSHOT.jar

## Exercises
* Save received users to database
* Send JSON messages via RabbitMQ admin interface