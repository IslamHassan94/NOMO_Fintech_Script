
# Mobile Test Automation with Appium, TestNG, and Cucumber

This project contains automated mobile test cases for an Android app using Appium, TestNG, and Cucumber. The test configuration, including all emulator properties, is stored in the `emulator.properties` file.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What you need to install the software and how to install them:

- Java Development Kit (JDK)
- Maven
- Android SDK
- Appium Server
- Any IDE that supports Java (e.g., IntelliJ IDEA, Eclipse)

### Setup

A step-by-step guide to getting the development environment running:

1. **Clone the Repository**  
   Clone the repository to your local machine using the following command:
   ```bash
   git clone https://github.com/IslamHassan94/NOMO_Fintech_Script.git
   ```

2. **Open the Project in Your IDE**  
   Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. **Configure Emulator Properties**  
   Ensure that the `emulator.properties` file contains the correct settings for your emulator. Example:
   ```properties
   platformName=Android
   deviceName=IslamHassanEmulator_Device
   platformVersion=9.0
   automationName=uiautomator2
   app=Android-MyDemoAppRN.1.3.0.build-244.apk
   ```

4. **Install Dependencies**  
   Run the following command to install the project dependencies:
   ```bash
   mvn install
   ```

5. **Start the Appium Server**  
   Start the Appium server on port 4725 using the following command:
   ```bash
   appium -p 4725
   ```

6. **Run the Emulator (if needed)**  
   Ensure that the Android emulator is running before executing the tests. You can either start it manually or use the command line to launch an emulator.

## Running the tests


- To run all the tests, use the command:
   ```bash
   mvn clean test
   ```
- To run individual tests, use your IDE's test runner and select the desired test case or scenario.

The test scenarios are written using Cucumber, with Gherkin syntax for Behavior-Driven Development (BDD). The tests are organized following the Page Object Model (POM) design pattern to enhance code maintainability and readability.

## Test Reports

The Cucumber reports will be generated after running the tests. You can find the reports in the following location:

```bash
target/cucumber-reports.html
```

This folder contains detailed reports of the test results in different formats, such as HTML.

## Emulator Properties

The `emulator.properties` file stores emulator settings that define how the tests are run on the Android emulator. The properties included in this project are as follows:

```properties
platformName=Android
deviceName=IslamHassanEmulator_Device
platformVersion=9.0
automationName=uiautomator2
app=Android-MyDemoAppRN.1.3.0.build-244.apk
```

You can modify this file to update emulator-specific settings without making changes to the test code itself.

## Author

- Islam Hassan
