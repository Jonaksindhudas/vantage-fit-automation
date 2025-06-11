# VantageFit App Automation

## Overview
This repository contains automated test scripts for the VantageFit mobile application. The automation framework is built using Appium and supports both Android and iOS platforms.

## Features
- Cross-platform testing (Android & iOS)
- Comprehensive test coverage for:
  - Login functionality
  - Health data management
  - Localization testing
  - SSO integration
  - Google Fit integration
  - UI element validation
  - Navigation flows
- Extent Reports integration for detailed test reporting
- Support for multiple languages and locales

## Tech Stack
- Java
- Appium
- TestNG
- Maven
- Extent Reports
- Android SDK
- iOS SDK

## Project Structure
```
src/
├── test/
│   ├── java/
│   │   └── org/vantagefit/
│   │       ├── pageObjects/
│   │       │   ├── android/
│   │       │   └── ios/
│   │       ├── testCases/
│   │       ├── testData/
│   │       ├── testUtils/
│   │       └── utils/
│   └── resources/
│       ├── Apps/
│       ├── data.properties
│       └── testng/
```

## Prerequisites
- Java JDK 8 or higher
- Maven
- Appium Server
- Android SDK (for Android testing)
- Xcode (for iOS testing)
- Node.js and npm

## Setup Instructions
1. Clone the repository
```bash
git clone https://github.com/Jonaksindhudas/vantage-fit-automation.git
```

2. Install dependencies
```bash
mvn clean install
```

3. Configure test environment
- Update `data.properties` with your test environment details
- Set up Android/iOS device or emulator
- Start Appium server

4. Run tests
```bash
mvn test
```

## Test Reports
Test reports are generated in the `target/surefire-reports` directory after test execution. The reports include:
- Test execution summary
- Pass/fail status
- Screenshots for failed tests
- Detailed test steps and logs

## Contributing
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request 