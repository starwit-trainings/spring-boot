---
marp: true
paginate: hide
theme: default 
header: ![h:35](imgs/starwit.png)
footer: 'Starwit Technologies GmbH | Spring Boot Examples'
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
# Spring Boot Examples

This repository contains a number of examples demonstrating various features of the Spring Boot framework. You can use them to educate yourself or to run a 2-5 days tutorial with students. As this is open source, you are most welcome to propose additional exercises and features. Obviously the same goes for errors and bugs.

Everything in this repo is published under MIT license, so you can do whatever you like with the code, including kickstarting your own software product.

Each of the folders in this repo contains a Spring Boot project and here is an overview, what is available. This is also a proposal for a sequence in which you can run through the examples. Every subfolder contains a readme file explaining in detail concepts and exercises.

---
## Example Projects

1. Bean Demo – [Readme of subproject](beandemo/slides.md)
2. Application Properties & Configuration – [Readme of subproject](apppropsdemo/slides.md)
3. JDBC & JPA – [Readme of subproject](jdbcexample/slides.md)
4. REST Controllers – [Readme of subproject](restdemo/slides.md)
5. Handling exceptions for REST APIs – [Readme of subproject](rest-exception-handling/slides.md)
6. Messaging I - Artemis and JMS – [Readme of subproject](messaging-demo/slides.md)
7. Messaging II - Rabbit MQ and AMQP – [Readme of subproject](rabbit-mq/slides.md)
8. Unit testing in Spring Boot – [Readme of subproject](testexample/slides.md)
9. Spring Security - OAuth2 Resource Server – [Readme of subproject](oauth2-resource-server/slides.md)
10. Spring Security - OAuth2 Login –  [Readme of subproject](security-redirect/slides.md)
11. Spring Batch – [Readme of subproject](batchexample/slides.md)
12. Spring Admin Server – [Readme of subproject](admin-server/slides.md)
13. A larger Spring Boot app example – [Readme of subproject](usermanagement/slides.MD)
14. How to use Gradle instead of Maven – [Readme of subproject](gradledemo/slides.md)

---
## Notes to Students
If you are a beginner in software engineering - first of all, congratulations. You are about to start a wonderful journey into the most interesting job in the world! If you learn your lessons well, you can work in almost any industry at almost any place in the world. 

On aspect that is often misunderstood is the fact that everything you find in this repository can be build and run without administrative privileges. Especially students working in large organizations often have this misconception. So if you have a typical enterprise configured laptop, all the stuff in this repo will work. If you work on Windows, note that the PATH for executables can be configured for your account without admin privileges.

The only important pre-requisite is that the Maven build tool is able to connect to it's central library of libraries. Speaking of, whenever you need a new functionality for your project, have a look here first: https://mvnrepository.com/ 

Java is a vast open source eco-system and it is always worth a search if a library exists for your topic. However, as there is no such thing as a free lunch - always consider contributing to anything you intend to use. Testing, writing bug reports, improving documentation or coding, there is plenty of ways to help open source projects.

---
## Notes to Educators
Provided order of examples is just a proposal and based on a number of tutorials held by the main authors of this repository. So check existing knowledge of your students and choose examples that fit your situation.

As repetition is the mother of all learning, you will find some aspects that will be part of a multitude of exercises. Working with beans, using entities, JPA repositories and REST controllers are just some examples. It is only if students are able to use a concept for the third time in one of the sample projects, you can have some certainty, that those concepts are actually understood.

This repository aims at teaching Spring Boot, however, without proper understanding of required basics like git or build & depedency management that knowledge is of very limited use. So we encourage you that students check their solutions into git and that they have to adapt Maven configuration in as many exercises as possible. 

While setting up a dev environment - which should be part of your training - it is also a good idea to check if students have proper understanding of how operating systems work. Things like privileges, file systems, working with the command line and configuring executable PATH - at many place you can slip in explanations of those concepts and recommend further readings.

---
## Prerequisites and Tooling
In order to run the examples some software needs to be present and configured on your computer. Please note that all those tools are open source. So consider looking at their respective pages on how you can contribute.

As Spring Boot is a framework written in Java, a JDK is obviously required to run examples. Code has been tested with Adoptium JDK version 17 and 20. It is advisable to migrate your code as early as possible to the latest released version of Java. More details you can find at https://adoptium.net/

Standard build tool is Maven which can be found at https://maven.apache.org/ As Spring Boot is making use of Maven quite intensively it is very recommendable to do make yourself familiar with this tool.

For the database examples H2 is being used, however, in order make those exercises actually useful, using PostgreSQL is recommended. Please note that PostgreSQL can also be installed without admin privileges.

To run authentication examples an identity provider is necessary. For our tutorials we use Keycloak https://www.keycloak.org/

For editing source code, we recommend using Visual Studio Code, which can be downloaded at https://code.visualstudio.com 

---
## Tips and Tricks

* debugging
* using `code .`
* VSCode plugins
* PGAdmin4
* Java Mission Control