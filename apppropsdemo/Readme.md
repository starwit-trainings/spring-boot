# Demo Project Application Properties and Profiles

In this example you will find example code, that shows how properties can handed to Spring Boot. It also contains examples, how to use profiles.

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