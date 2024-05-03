# Demo Project Application Properties and Profiles

In this example you will find example code that shows how properties can handed to Spring Boot. It also contains examples on how to use profiles.

## Topics
* General idea of setting application properties
* Precendence and examples of setting props
* General idea of profiles
* Profile specific props
* Create profile specific beans

## How to run

    mvn clean package
    java -jar target/apppropsdemo-0.0.1-SNAPSHOT.jar

## Working with the various props sources

* packaged app.properties
* shipped app.properties
* env vars: 

        source env.sh
* CLI params: 
    
        java -jar target/apppropsdemo-0.0.1-SNAPSHOT.jar --avalue=test

# Background

On the order of where parameters are taken from:
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config 