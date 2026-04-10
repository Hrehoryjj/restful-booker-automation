# Test Plan: Restful Booker Automation Project

## 1. Introduction
This test plan outlines the strategy for automated testing of the **Restful Booker** application. The goal is to ensure the stability of hotel booking management via both UI and API layers.

## 2. Scope of Testing
### In Scope
- **API Testing:** Authentication (Token generation), CRUD operations (Create, Get, Update, Delete) for bookings.
- **UI Testing:** Booking form validation, homepage elements, and visual confirmations.
- **E2E Testing:** Integration scenarios (e.g., creating a booking via API and verifying it on the UI).

### Out of Scope
- Performance and Load Testing.
- Security/Penetration testing.
- Mobile browser compatibility.

## 3. Technology Stack

| Component | Tool |
| :--- |:----:|
| **Language** | Java 17 |
| **Testing Framework** | TestNG |
| **UI Automation** | Selenium WebDriver |
| **API Automation** | RestAssured |
| **Design Pattern** | Page Object Model (POM) |
| **Reporting** | Allure Reports |

## 4. Test Strategy
- **Maintenance:** Using Page Object Model to separate page logic from test scripts.
- **Data Driven:** Test data will be managed using POJO classes and JSON serialization.
- **Automation Approach:** Tests will be executed in a clean browser state (using `@BeforeMethod` and `@AfterMethod`).

## 5. Environment Details
- **Target URL:** https://automationintesting.online/
- **Browser:** Google Chrome (Managed by WebDriverManager)
- **Environment:** Production-like sandbox.

## 6. Acceptance Criteria
- 100% pass rate for critical booking flows.
- Detailed Allure reports are generated after each execution.
- Code follows clean code principles and is pushed to GitHub.
