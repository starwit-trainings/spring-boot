---
marp: true
paginate: hide
theme: default 
header: ![h:50](../imgs/starwit.png)
footer: 'Starwit Technologies GmbH | Spring Boot Examples | JDBC Demo'
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
  text-align: center;
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
# JDBC Example
This project shows how to use JPA in Spring Boot. 

---
## Topics
* Sample using H2
* Repositories
* Generated repository methods
* Simple example to connect REST controller and repositories
* How JDBC abstracts from actual database

---
## How to Run

    mvn clean package
    java -jar target/jdbcexample-0.0.1-SNAPSHOT.jar 

    # list all users
    curl localhost:8080/users
    # add user
    curl -X POST -d '{"name":"the dude", "email":"dude@dudemail.com"}' -H "Content-Type: application/json" localhost:8080/users

---
## Exercises
* Change data source to PostgreSQL
* Implement repository functions with
    * method names
    * JPA queries
    * example filter by name
* extend entity to use given name / last name