package org.vantagefit.testCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.vantagefit.pageObjects.android.*;
import org.vantagefit.testUtils.AndroidBaseTest;
import org.vantagefit.utils.LocaleConfigProvider;
import org.vantagefit.utils.LocalizationValidator;
import org.vantagefit.utils.TextCaptureHelper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalizationTests extends AndroidBaseTest {
    private static final Logger LOGGER = Logger.getLogger(LocalizationTests.class.getName());
    private TextCaptureHelper textCaptureHelper;
    private LocalizationValidator localizationValidator;
    private LoginScreen loginScreen;
    private WorkEmailLoginPage workEmailLoginPage;
    private WorkEmailPasswordPage workEmailPasswordPage;
    private AgreementPage agreementPage;
    private HomePage homePage;
    private HealthRecordPage healthRecordPage;
    private static final String CORRECT_EMAIL = "johnmclane@jsdemo.com";
    private static final String CORRECT_PASSWORD = "welcome";

    @BeforeMethod(alwaysRun = true)
    public void setup() throws Exception {
        // Initialize helpers
        textCaptureHelper = new TextCaptureHelper(driver);
        localizationValidator = new LocalizationValidator();
        
        // Initialize page objects
        loginScreen = new LoginScreen(driver);
        workEmailLoginPage = new WorkEmailLoginPage(driver);
        workEmailPasswordPage = new WorkEmailPasswordPage(driver);
        agreementPage = new AgreementPage(driver);
        homePage = new HomePage(driver);
        healthRecordPage = new HealthRecordPage(driver);
    }

    private void setupLanguageAndLocale(String language, String country) {
        try {
            driver.terminateApp("com.bargaintechnologies.vantagefit.v_fit");
            driver.activateApp("com.bargaintechnologies.vantagefit.v_fit");
            driver.setSetting("locale", language + "_" + country);
            Thread.sleep(5000);
            LOGGER.info("Set locale to: " + language + "_" + country);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error setting locale", e);
        }
    }

    @DataProvider(name = "localizationData")
    public Object[][] getLocalizationData() {
        // For now, only test Italian
        return new Object[][] {
            {"it", "IT", "Italian"}
        };
    }

    @Test(dataProvider = "localizationData")
    public void testLoginScreenLocalization(String language, String country, String languageName) {
        LOGGER.info("Testing Login Screen localization for: " + languageName);
        
        // Set device locale
        setupLanguageAndLocale(language, country);
        
        // Verify login screen elements
        loginScreen.verifyLoginScreenElements();
        
        // Capture and validate text
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        
        // Log issues
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on Login Screen for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        
        // Save captured text to file
        textCaptureHelper.saveTextToFile(texts, "login_screen_" + language + "_" + country + ".txt");
        
        // Assert no issues found
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on Login Screen for " + languageName);
    }

    @Test(dataProvider = "localizationData")
    public void testWorkEmailLoginLocalization(String language, String country, String languageName) {
        LOGGER.info("Testing Work Email Login localization for: " + languageName);
        
        // Set device locale
        setupLanguageAndLocale(language, country);
        
        // Navigate to work email login
        loginScreen.clickWorkEmailLogin();
        
        // Verify work email login elements
        workEmailLoginPage.verifyWorkEmailLoginElements();
        
        // Capture and validate text
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        
        // Log issues
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on Work Email Login for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        
        // Save captured text to file
        textCaptureHelper.saveTextToFile(texts, "work_email_login_" + language + "_" + country + ".txt");
        
        // Assert no issues found
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on Work Email Login for " + languageName);
    }

    @Test(dataProvider = "localizationData")
    public void testWorkEmailPasswordLocalization(String language, String country, String languageName) {
        LOGGER.info("Testing Work Email Password localization for: " + languageName);
        
        // Set device locale
        setupLanguageAndLocale(language, country);
        
        // Navigate to work email password screen
        loginScreen.clickWorkEmailLogin();
        workEmailLoginPage.enterEmail(CORRECT_EMAIL);
        workEmailLoginPage.clickContinue();
        
        // Verify work email password elements
        workEmailPasswordPage.verifyWorkEmailPasswordElements();
        
        // Capture and validate text
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        
        // Log issues
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on Work Email Password for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        
        // Save captured text to file
        textCaptureHelper.saveTextToFile(texts, "work_email_password_" + language + "_" + country + ".txt");
        
        // Assert no issues found
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on Work Email Password for " + languageName);
    }

    @Test(dataProvider = "localizationData")
    public void testAgreementLocalization(String language, String country, String languageName) {
        LOGGER.info("Testing Agreement Screen localization for: " + languageName);
        
        // Set device locale
        setupLanguageAndLocale(language, country);
        
        // Navigate to agreement screen
        loginScreen.clickWorkEmailLogin();
        workEmailLoginPage.enterEmail(CORRECT_EMAIL);
        workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword(CORRECT_PASSWORD);
        workEmailPasswordPage.clickSignIn();
        
        // Verify agreement elements
        agreementPage.verifyAgreementElements();
        
        // Capture and validate text
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        
        // Log issues
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on Agreement Screen for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        
        // Save captured text to file
        textCaptureHelper.saveTextToFile(texts, "agreement_" + language + "_" + country + ".txt");
        
        // Assert no issues found
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on Agreement Screen for " + languageName);
    }

    private void navigateToHomePage() throws InterruptedException {
        driver.terminateApp("com.bargaintechnologies.vantagefit.v_fit");
        driver.activateApp("com.bargaintechnologies.vantagefit.v_fit");
        LoginScreen loginScreen = new LoginScreen(driver);
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(CORRECT_EMAIL);
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword(CORRECT_PASSWORD);
        AgreementPage agreementPage = workEmailPasswordPage.passDriverToAgreementPage();
        agreementPage.acceptAgreement();
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        healthRecordPage.clickAddDataManually();
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            addHealthDataPages.clickNextButton();
        }
        Thread.sleep(1000);
        addHealthDataPages.clickLetsStartButton();
        ConnectGoogleFitPage connectGoogleFitPage = addHealthDataPages.navigateToConnectGoogleFitPage();
        Thread.sleep(1000);
        connectGoogleFitPage.clickSkipButton();
        Thread.sleep(1000);
        connectGoogleFitPage.allowNotificationPermission();
        Thread.sleep(2000); // Wait for HomePage to load
    }

    @Test(dataProvider = "localizationData")
    public void testHomeScreenLocalization(String language, String country, String languageName) throws InterruptedException {
        LOGGER.info("Testing Home Screen localization for: " + languageName);
        setupLanguageAndLocale(language, country);
        navigateToHomePage();
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomeScreenElements();
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on Home Screen for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        textCaptureHelper.saveTextToFile(texts, "home_screen_" + language + "_" + country + ".txt");
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on Home Screen for " + languageName);
    }

    @Test(dataProvider = "localizationData")
    public void testHealthRecordLocalization(String language, String country, String languageName) throws InterruptedException {
        LOGGER.info("Testing Health Record Screen localization for: " + languageName);
        setupLanguageAndLocale(language, country);
        navigateToHomePage();
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        healthRecordPage.verifyHealthRecordElements();
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on Health Record Screen for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        textCaptureHelper.saveTextToFile(texts, "health_record_" + language + "_" + country + ".txt");
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on Health Record Screen for " + languageName);
    }

    @Test(dataProvider = "localizationData")
    public void testFABMenuLocalization(String language, String country, String languageName) throws InterruptedException {
        LOGGER.info("Testing FAB Menu localization for: " + languageName);
        setupLanguageAndLocale(language, country);
        navigateToHomePage();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isFABOptionsExpanded(), "FAB Menu is not expanded");
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on FAB Menu for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        textCaptureHelper.saveTextToFile(texts, "fab_menu_" + language + "_" + country + ".txt");
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on FAB Menu for " + languageName);
    }

    @Test(dataProvider = "localizationData")
    public void testAddHealthDataLocalization(String language, String country, String languageName) throws InterruptedException {
        LOGGER.info("Testing Add Health Data Screen localization for: " + languageName);
        setupLanguageAndLocale(language, country);
        navigateToHomePage();
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        healthRecordPage.clickAddDataManually();
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on Add Health Data Screen for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        textCaptureHelper.saveTextToFile(texts, "health_data_" + language + "_" + country + ".txt");
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on Add Health Data Screen for " + languageName);
    }

    @Test(dataProvider = "localizationData")
    public void testConnectGoogleFitLocalization(String language, String country, String languageName) throws InterruptedException {
        LOGGER.info("Testing Connect Google Fit Screen localization for: " + languageName);
        setupLanguageAndLocale(language, country);
        navigateToHomePage();
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        healthRecordPage.clickImportFromGoogleFit();
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on Connect Google Fit Screen for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        textCaptureHelper.saveTextToFile(texts, "connect_google_fit_" + language + "_" + country + ".txt");
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on Connect Google Fit Screen for " + languageName);
    }

    @Test(dataProvider = "localizationData")
    public void testSSOLocalization(String language, String country, String languageName) {
        LOGGER.info("Testing SSO Screen localization for: " + languageName);
        
        // Set device locale
        setupLanguageAndLocale(language, country);
        
        // Navigate to SSO screen
        loginScreen.clickWorkEmailLogin();
        workEmailLoginPage.selectSSOLogin();
        
        // Capture and validate text
        List<String> texts = textCaptureHelper.getAllVisibleText();
        List<String> issues = localizationValidator.validateTexts(texts, language);
        
        // Log issues
        if (!issues.isEmpty()) {
            LOGGER.warning("Localization issues found on SSO Screen for " + languageName + ":");
            for (String issue : issues) {
                LOGGER.warning(issue);
            }
        }
        
        // Save captured text to file
        textCaptureHelper.saveTextToFile(texts, "sso_" + language + "_" + country + ".txt");
        
        // Assert no issues found
        Assert.assertTrue(issues.isEmpty(), "Found localization issues on SSO Screen for " + languageName);
    }
} 