# Spring Boot admin server
This project contains an example Spring Boot app, that starts Admin Server. Admin server is a simple monitoring and observing tool, that provides health information about all registered Spring apps. Note, it is necessary to activate admin client depedency. It is only then, that apps will register to admin server. 

For more details on admin server see here: https://github.com/codecentric/spring-boot-admin

## Topics
* Monitor Spring Applications
* Show case capabilities of the Java virtual machine
* Introduce JMX as a core functionality of JVM
* refer to Java Mission Control

## How to run

    mvn clean package
    java -jar target/admin-server-0.0.1-SNAPSHOT.jar 
