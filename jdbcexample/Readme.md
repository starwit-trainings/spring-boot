# JDBC example
This project shows how to use JPA in Spring Boot. 

## Topics
* Sample using H2
* Repositories
* Generated repository methods
* Simple example to connect REST controller and repositories
* How JDBC abstracts from actual database

## How to run

    mvn clean package
    java -jar target/jdbcexample-0.0.1-SNAPSHOT.jar 

    # list all users
    curl localhost:8080/users
    # add user
    curl -X POST -d '{"name":"the dude", "email":"dude@dudemail.com"}' -H "Content-Type: application/json" localhost:8080/users

## Exercises
* Change data source to PostgreSQL
* Implement repository functions with
    * method names
    * JPA queries
    * example filter by name
* extend entity to use given name / last name