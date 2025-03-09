# Spring Boot and Web Sockets
Sometimes it is necessary to push new data to a web application. Spring Boot allows you to do that and in this example, we'll learn how to use web sockets.

This example shows how to use simple websockets and the STOMP protocol extension for web sockets. The latter can be used, for publish/subscribe patterns.

## Topics
* Web sockets
* Javascript frontend

## How to Run
```bash
    mvn clean package
    java -jar target/websockets-demo-0.0.1-SNAPSHOT.jar
```
Once Spring Boot app is running, you can access the following examples:
* http://localhost:8080/index.html - simple web socket example
* http://localhost:8080/index_stomp.html - STOMP example, trigger messages via GET http://localhost:8080/trigger

## Exercises
* Modify content of send messages