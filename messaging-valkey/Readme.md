# Messaging with ValKey / Redis
High speed communication of data can be done with a number of bus systems. In this example ValKey/Redis is used to read and write to streams. This setup is well suited to send binary data like images.

## Topics
* Messaging with [ValKey/Redis](https://valkey.io/)
* Use Spring Data
* Sending/Receiving
* Spring Boot scheduled tasks

## How to Run
In order to communicate via ValKey a running instance is necessary. Easiest way to run ValKey is via Docker:
```bash
    sudo docker compose -f docker-compose.yaml up
```

Once ValKey is running, you can package and run example like so:
```bash
    mvn clean package
    java -jar target/valkey-demo-0.0.1-SNAPSHOT.jar
```

## Exercises
* Modify content of send messages
* Output your message content via log messages