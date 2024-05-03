---
marp: true
paginate: hide
theme: default 
header: ![h:50](../imgs/starwit.png)
footer: 'Starwit Technologies GmbH | Spring Boot Examples | OAuth2 Resource Server'
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
# Spring Boot Security - Resource Server

---
## Topics

### How-To Run
- Start local Keycloak
- Create realm "training" by importing `training_realm.json`
- Adapt Keycloak URI in `src/main/resources/application.properties` if necessary
- (If you're interested, comment in the Spring Security logging config property) 
- Run Java app with `./mvnw spring-boot:run`
- Send a request to public endpoint without auth under `http://host:port/public-endpoint`
- Send a request to protected endpoint under `http://host:port/protected-endpoint`
- Get a valid token as described below for successful authentication
- Retry `/protected-endpoint`
- Send a request to `/admin-endpoint`
- Assign role `admin` to test user
- Get new token
- Retry `/admin-endpoint`
- Retry `/protected-endpoint` and see changed list of roles the user has

---
### How-To Authenticate
- Get token from Keycloak\
    ```sh
    curl --request POST \
    --url http://localhost:8081/realms/training/protocol/openid-connect/token \
    --header 'Content-Type: application/x-www-form-urlencoded' \
    --data grant_type=password \
    --data client_id=spring-example-app \
    --data username=test \
    --data password=test
    ```
- Set token as bearer in app request\
    ```sh
    curl --request GET \
    --url http://localhost:8080/protected-endpoint \
    --header 'Authorization: Bearer <access_token>'

---
## Exercises