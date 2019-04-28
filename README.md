# Spring Boot / Java Backend for Nebular 

Nebular is the most popular Angular front-end framework ( a set of modules I would rather say ) that enables you to quickly develop a production ready application without going through the pain of creating various modules like authentication, authorization, themes etc. For more details about Nebular
<a href="https://akveo.github.io/nebular/docs/getting-started/what-is-nebular#what-is-nebular">see here</a>. Nebular UI can be easily setup by going through the  <a href="https://akveo.github.io/nebular/docs/guides/install-based-on-starter-kit#install-based-on-starter-kit">Nebular documentation</a>
.If you want to have a look at how a Nebular application looks like , see the <a href="http://akveo.com/ngx-admin/?utm_source=nebular_documentation&utm_medium=demo_button">Demo here</a>

<img width="1042" alt="petclinic-screenshot" src="https://github.com/prasadprabha/nebular-spring-boot/blob/master/NebularUI.png">

## Technologies Used

* Java 8
* Spring Boot 2.1.3.RELEASE
* Hibernate 5
* MySQL as the database

## Understanding the Spring Boot Backend

This application is written to support the UI application built with Nebular. Once the Nebular application is setup as per the Nebular documentation, this backend
application can serve both login and log out requests. The authentication and authorization part is implemented with Spring security and JWT Tokens. After successful authentication a JWT token is created with the basic user details and keep sending back and forth for subsequent requests. User credentials are stored in MYSQL database encoded with BCryptPasswordEncoder (An encoder provided by Spring). Hibernate is used for database persistence. You can easily start building your own application on top of this as this will provide you the basic infrastructure.


## Running the application locally

Start MySQL server and execute the <a href="https://github.com/prasadprabha/nebular-spring-boot/blob/master/dbscripts/createdb.sql">sql scripts</a>


nebular-spring-boot is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/prasadprabha/nebular-spring-boot.git
cd nebular-spring-boot
mvn clean install
java -jar target/nebular-spring-boot.jar
```

You can then access the application from Nebular UI with this URL: http://localhost:8888/nebular/auth/login

## In case you find a bug/suggested improvement for this application
issue tracker is available here: https://github.com/prasadprabha/nebular-spring-boot/issues


## Database configuration

In its default configuration, the application uses MYSQL Database. The table structure can be created by executing the db script provided along the application.
You must start MySql locally with whatever installer works for your OS, or with docker. 


### Prerequisites
The following items should be installed in your system:
* Java 8 or newer.
* A GIT client to clone the project from Github.
* Your prefered IDE 
  I prefer [Spring Tools Suite](https://spring.io/tools) (STS)
* MySQL 5.7 or higher.


### Steps:

1) On the command line
```
git clone https://github.com/prasadprabha/nebular-spring-boot.git
```
2) Inside Eclipse or STS
```
File -> Import -> Maven -> Existing Maven project
```

Then either build on the command line `./mvnw generate-resources` or using the Eclipse launcher (right click on project and `Run As -> Maven install`) to generate the css. Run the application main method by right clicking on it and choosing `Run As -> Java Application`.


# Contributing

The [issue tracker](https://github.com/prasadprabha/nebular-spring-boot/issues) is the preferred channel for bug reports, features requests and submitting pull requests.


# License 

This application is released under the [MIT License](https://opensource.org/licenses/MIT).
