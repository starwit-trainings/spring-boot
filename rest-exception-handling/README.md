# REST exception handling example
This project demonstrates how to handle exceptions with REST services in Spring Boot.

## Topics
* concept of exceptions
* validation & exceptions
* examples how parameters lead to many combinations that needs to be handled with exceptions

## How to run

    mvn clean package
    java -jar target/rest-exception-handling-0.0.1-SNAPSHOT.jar 

- Send a GET request to endpoint `/add-ints`, it needs to hold two query parameters containing ints that will be added, e.g. `/add-ints?a=1&b=2`. You can use your browser for that (remember quoting if you use curl).
- Play around with the parameters and see what happens 

## Exercises
* implement additional REST service
* extend number of parameters
* build services with complex parameters
