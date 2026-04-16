# Restful-Booker Automation Framework

This repository contains a comprehensive test automation framework for API and UI levels of the Restful Booker Platform (https://automationintesting.online).

## Tech Stack

- Java 17 (JDK)
- Maven (Dependency Management)
- RestAssured (API Testing)
- Selenium WebDriver (UI Testing)
- TestNG (Test Runner)
- Allure Report (Reporting Tool)
- WebDriverManager (Automatic driver management)

## Project Structure

- src/main/java — Page Object models (UI) and Base API Client.
- src/test/java — Test suites (API, UI, and Hybrid E2E).
- docs/ — Detailed test cases and documentation.
- testng.xml — Configuration for running test suites.

## Coverage and Features

### API Testing
Full CRUD lifecycle (Create, Get, Update, Delete) for bookings, including negative scenarios with invalid payloads and schema validation.

### UI Testing
Testing complex React components like Datepickers (calendar), contact forms, field validation, and success message verification.

### Hybrid E2E Scenario
A cross-layer test that creates a booking via the UI and immediately verifies its existence in the database via an API request.

### Resilience
Implementation of Explicit Waits and JavaScript executors to handle dynamic web elements.

## Getting Started

### Prerequisites
Ensure you have Java 17 and Maven installed.

### Run All Tests
```bash
mvn clean test
```

## Documentation

Detailed test case descriptions are available here:

- API Test Cases
- UI Test Cases
- E2E and Test Plan

### Author
Hryhorii — QA Automation Engineer