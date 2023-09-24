# Unit test example
Unit tests are a very important tool to write high quality software. Spring Boot supports unit testin and this project shows how to build tests and run them. Note, that most other projects in this repo are also using unit testing and show to run Spring Boot test containers. When working with this project, there is this way a great opportunity to repeat lessons in other projects.

## Topics
* Concept unit test
* Introduction to JUnit
* Unit test support in IDEs
* Spring test container support
* Concept mocking

## How to run

    mvn clean package
    java -jar target/testexample-0.0.1-SNAPSHOT.jar 

## Exercises
* write test for JPA repository functions
* extend REST service with a bulk import and write test
* examine Surefire reports