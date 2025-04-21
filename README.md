# Spring Boot Security Demo – SQL Injection & XSS

This project demonstrates common web vulnerabilities like **SQL Injection** and **Cross-Site Scripting (XSS)** using Spring Boot, and how to prevent them with secure coding practices.

##Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- REST APIs

##  How to Run

1. Clone the repository.
2. Open the project in your IDE.
3. Run `Attackdemo.java`.


##  SQL Injection Demo

### Vulnerable Endpoint


GET /vulnerable-sql?name=' OR '1'='1 

### Secure Endpoint

GET /secure-sql?name=' OR '1'='1


## XSS Injection Demo

### Vulnerable Endpoint

GET /vulnerable-sql?input =<script>alert('XSS attack')</script>

### Secure Endpoint

GET /secure-sql?input =<script>alert('XSS attack')</script>

