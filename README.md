# Java E2E Automation Framework (UI + API)

A robust test automation framework built from scratch to validate end-to-end user workflows and API consistency for the RESTful Booker platform. This project demonstrates a multi-layered automation approach combining comprehensive API testing with robust UI verification using Java and the Selenium ecosystem.

## Features

- End-to-End API and UI test execution
- Page Object Model (POM) architecture
- Explicit API verification using REST Assured
- Structured assertions via TestNG
- Automated project building and dependency management via Maven
- Detailed test execution logs and reporting integration

## Project Structure

```
/src/main/java
/pages          - UI page classes utilizing Selenium WebDriver
/api            - API payload configurations and client setups
/src/test/java
/tests          - Test suites and assertions partitioned by layer
/pom.xml          - Project object model for dependency management
```

## Running Tests

Install dependencies and build the project:  
``` bash
mvn clean install
```

Run all automated test suites:  
``` bash
mvn test
```

## Project Purpose

This project was built as part of my QA Automation path to practice and master:
- Java object-oriented programming (OOP) principles in test engineering
- Multi-layered synchronization (independent API validation & UI flows)
- Component separation and low-maintenance code design via Page Object Model
- Industry-standard build lifecycle management using Maven

## Tech Stack

- Java 17
- Selenium WebDriver 4
- REST Assured
- TestNG
- Maven

## Author

Hryhorii Markevych  
QA Automation Engineer
