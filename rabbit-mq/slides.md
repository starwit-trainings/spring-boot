---
marp: true
paginate: hide
theme: default 
header: ![h:50](../imgs/starwit.png)
footer: 'Starwit Technologies GmbH | Spring Boot Examples | Messaging with RabbitMQ'
---

<style>
header {
  text-align: right;
  font-size: 0.7rem;
  color: #bbb;
  margin: 20px;
  left: 0px;
  right: 0px;
  padding-top: 5px;
}
footer {
  font-size: 0.7rem;
  color: #bbb;
}
section.lead {
  text-align: left;
  margin-bottom: 40px;
}
section {
  font-size: 1.2rem;
}
section.lead h1 {
  text-align: center;
  font-size: 2.5rem;
  font-weight: 600;
}
section.linked footer {
  display: none;
}
section.linked header {
  display: none;
}
section.quote {
  font-size: 1.0rem;
  text-align: center;
  font-style: italic;
  color: #555;
}

h1 {
  font-size: 2.5rem;
  font-weight: 500;
  color: #2B5A6A;
}
h2 {
  font-size: 1.8rem;
  font-weight: 400;
  color: #333;
  margin-top: 30px;
  margin-bottom: 15px;
  text-transform: uppercase;
}
h3 {
    margin-top: 10px;
    margin-bottom: 0px;
}
a {
  color: #3A9FC1;
}
a:hover {
  color: #1E708B; 
  text-decoration: underline; 
}

</style>

<!-- _class: lead -->
# Messaging with RabbitMQ Example
This project demonstrates how to use AMQP messaging with Spring Boot and RabbitMQ. It connects to an existing instance of RabbitMQ with coordinates provided in application properties.

A local RabbitMQ instance can be run using Docker/Podman

---
## Topics
* Messaging with AMQP
* Sending/Receiving
* De/Serialize JSON messages
* Receiving from multiple queues
* RabbitMQ admin interface

---
## How to Run

    mvn clean package
    java -jar target/rabbit-mq-0.0.1-SNAPSHOT.jar

---
## Exercises
* Save received users to database
* Send JSON messages via RabbitMQ admin interface