# Breaking Up The Monolithic PetClinic

## What this is about

The purpose of this fork is to be a monolithic mess so you can practice breaking it up and extract microservices from it.
The PetClinic is continuously deployed after each commit and follows a zero downtime policy.
This means you are supposed to make small changes and preserve the behaviour after each.
The tasks involve refactoring, tdd, branch by abstraction and introducing an event bus.

## Understanding the Spring Petclinic application with a few diagrams

<a href="https://speakerdeck.com/michaelisvy/spring-petclinic-sample-application">See the presentation here</a>

## Running the monolith locally

Petclinic is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/).
You can run it with the spring boot maven plugin like this:
```
cd monolith
../mvnw spring-boot:run
```
Or you can run it from your IDE.
You can then access the petclinic monolith here: http://localhost:8080/

## Database configuration
In its default configuration, Petclinic uses an in-memory database (HSQLDB) which gets populated at startup with data.

## Working with the Monolithic Petclinic in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 8 or newer.
* git

### Steps:

1) On the command line
```
git clone https://github.com/gregorriegler/monolithic-petclinic.git
```
2) Inside Eclipse or STS
```
File -> Import -> Maven -> Existing Maven project
```

Then either build on the command line `./mvnw generate-resources` or using the Eclipse launcher (right click on project and `Run As -> Maven install`) to generate the css. Run the application main method by right clicking on it and choosing `Run As -> Java Application`.

3) Inside IntelliJ IDEA

In the main menu, choose `File -> Open` and select the Petclinic [pom.xml](pom.xml). Click on the `Open` button.

A run configuration named `PetClinicApplication` should have been created for you if you're using a recent Ultimate
version. Otherwise, run the application by right clicking on the `PetClinicApplication` main class and choosing
`Run 'PetClinicApplication'`.

4) Navigate to Petclinic

Visit [http://localhost:8080](http://localhost:8080) in your browser.


# License

The Spring PetClinic sample application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).
