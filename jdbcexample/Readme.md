# JDBC example
Shows how to use JDBC in Spring Boot.

## Topics
* Sample using H2
* Repositories
* Generated methods
* Simple example to connect REST controller and repositories

## How to run


    mvn clean package
    java -jar target/jdbcexample-0.0.1-SNAPSHOT.jar 

    # list all users
    curl localhost:8080/users
    # add user
    curl -X POST -d '{"name":"the dude", "email":"dude@dudemail.com"}' -H "Content-Type: application/json" localhost:8080/users