# Java API

### Getting started

https://start.spring.io/

Chose Web, JPA, PostgreSQL, DevTools

Edit src/main/resources/application.properties to have

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:postgresql://localhost:5432/java-api
    spring.datasource.username=dan
    spring.datasource.password=
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

### Instructions to run app from terminal

    ./gradlew bootRun

visit localhost:8080 in a browser

### Helpful Links

- https://spring.io/guides
- https://spring.io/guides/gs/serving-web-content/
- https://start.spring.io/
- https://www.baeldung.com/spring-autowire
