---
marp: true
paginate: hide
theme: default 
header: ![h:50](../imgs/starwit.png)
footer: 'Starwit Technologies GmbH | Spring Boot Examples | REST Exception Handling'
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
# REST Exception Handling Example
This project demonstrates how to handle exceptions with REST services in Spring Boot.

---
## Topics
* Concept of exceptions
* Validation & exceptions
* Examples how parameters lead to many combinations that needs to be handled with exceptions

---
## How to Run

    mvn clean package
    java -jar target/rest-exception-handling-0.0.1-SNAPSHOT.jar 

- Send a GET request to endpoint `/add-ints`, it needs to hold two query parameters containing ints that will be added, e.g. `/add-ints?a=1&b=2`. You can use your browser for that (remember quoting if you use curl).
- Play around with the parameters and see what happens 

---
## Exercises
* Implement additional REST service
* Extend number of parameters
* Build services with complex parameters