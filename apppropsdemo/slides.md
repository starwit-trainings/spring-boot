---
marp: true
paginate: hide
theme: default 
header: ![h:50](../imgs/starwit.png)
footer: 'Starwit Technologies GmbH | Spring Boot Examples | Application Properties and Profiles'
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
# Demo Project Application Properties and Profiles

In this example you will find example code that shows how properties can handed to Spring Boot. It also contains examples on how to use profiles.

---
## Topics
* General idea of setting application properties
* Precendence and examples of setting props
* General idea of profiles
* Profile specific props
* Create profile specific beans

---
## How to run

    mvn clean package
    java -jar target/apppropsdemo-0.0.1-SNAPSHOT.jar

---
## Working with the various props sources

* packaged app.properties
* shipped app.properties
* env vars: 

        source env.sh
* CLI params: 
    
        java -jar target/apppropsdemo-0.0.1-SNAPSHOT.jar --avalue=test

---
# Background

On the order of where parameters are taken from:
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config 