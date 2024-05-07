---
marp: true
paginate: hide
theme: default 
header: !![h:50](../imgs/starwit.png)
footer: 'Starwit Technologies GmbH | Spring Boot Examples | Admin Server'
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
# Spring Boot Admin Server
This project contains an example Spring Boot app that starts Admin Server. Admin server is a simple monitoring and observing tool, that provides health information about all registered Spring apps. Note, it is necessary to activate admin client depedency. It is only then that apps will register to admin server. 

For more details on admin server see here: https://github.com/codecentric/spring-boot-admin

---
## Topics
* Monitor Spring Applications
* Showcase capabilities of the Java virtual machine
* Introduce JMX as a core functionality of JVM
* Refer to Java Mission Control

---
## How to Run

    mvn clean package
    java -jar target/admin-server-0.0.1-SNAPSHOT.jar 