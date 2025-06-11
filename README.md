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
- Gradle
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
- Gradle
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
./gradlew clean build
```

3. Configure test environment
- Update `data.properties` with your test environment details
- Set up Android/iOS device or emulator
- Start Appium server

4. Run tests
```bash
./gradlew test
```

## Writing New Test Cases

### Framework Architecture
The framework follows the Page Object Model (POM) design pattern with the following components:

1. **Page Objects** (`src/test/java/org/vantagefit/pageObjects/`)
   - Contains locators and methods for each page/screen
   - Separate implementations for Android and iOS
   - Example: `LoginScreen.java`, `HomePage.java`

2. **Test Cases** (`src/test/java/org/vantagefit/testCases/`)
   - Contains actual test methods
   - Uses TestNG annotations
   - Extends `AndroidBaseTest.java` or `IOSBaseTest.java`

3. **Test Data** (`src/test/java/org/vantagefit/testData/`)
   - JSON files for test data
   - Organized by feature/test type
   - Example: `LoginWithWorkEMailTestsData/`

4. **Utilities** (`src/test/java/org/vantagefit/utils/`)
   - Common utility methods
   - Platform-specific actions
   - Example: `AndroidActions.java`, `IOSActions.java`

### Steps to Add New Test Cases

1. **Create Page Object**
```java
public class NewFeaturePage extends AndroidActions {
    public NewFeaturePage(AndroidDriver driver) {
        super(driver);
    }
    
    // Add locators
    private By elementLocator = By.id("element_id");
    
    // Add methods
    public void performAction() {
        click(elementLocator);
    }
}
```

2. **Add Test Data**
```json
// src/test/java/org/vantagefit/testData/NewFeatureTests/testData.json
{
    "testCase1": {
        "input": "value",
        "expected": "result"
    }
}
```

3. **Write Test Case**
```java
public class NewFeatureTests extends AndroidBaseTest {
    private NewFeaturePage newFeaturePage;
    
    @BeforeMethod
    public void setup() {
        newFeaturePage = new NewFeaturePage(driver);
    }
    
    @Test(dataProvider = "getTestData")
    public void testNewFeature(TestData testData) {
        // Test steps
        newFeaturePage.performAction();
        // Assertions
    }
}
```

4. **Add to TestNG XML**
```xml
<!-- src/test/resources/testng/testng.xml -->
<test name="New Feature Tests">
    <classes>
        <class name="org.vantagefit.testCases.NewFeatureTests"/>
    </classes>
</test>
```

### Best Practices
1. Use meaningful names for test methods and variables
2. Add proper comments and documentation
3. Follow the existing naming conventions
4. Use data providers for multiple test scenarios
5. Add appropriate assertions
6. Handle exceptions properly
7. Use the utility methods from `AndroidActions` or `IOSActions`

### Running Specific Tests
```bash
# Run specific test class
./gradlew test --tests "org.vantagefit.testCases.NewFeatureTests"

# Run specific test method
./gradlew test --tests "org.vantagefit.testCases.NewFeatureTests.testNewFeature"
```

## Test Reports
Test reports are generated in the `build/reports/tests` directory after test execution. The reports include:
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