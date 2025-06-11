package org.vantagefit.testCases;

import org.vantagefit.pageObjects.android.*;
import org.vantagefit.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ConnectGoogleFitTests extends AndroidBaseTest {

    @BeforeMethod(alwaysRun = true)
    public void presetup() {
        driver.terminateApp("com.bargaintechnologies.vantagefit.v_fit");
        driver.activateApp("com.bargaintechnologies.vantagefit.v_fit");
        LoginScreen loginScreen = new LoginScreen(driver);
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail("johnmclane@jsdemo.com");
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword("welcome");
        AgreementPage agreementPage = workEmailPasswordPage.passDriverToAgreementPage();
        agreementPage.acceptAgreement();
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        healthRecordPage.clickAddDataManually();
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickLetsStartButton();
        ConnectGoogleFitPage connectGoogleFitPage = addHealthDataPages.navigateToConnectGoogleFitPage();

    }

    @Test(priority = 1, description = "TC 01 ConnectGoogleFitTests - Verify Connect Google Fit title is displayed")
    public void testConnectGoogleFitTitleDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        Assert.assertTrue(connectGoogleFitPage.isConnectGoogleFitTitleDisplayed(), "Connect Google Fit title should be displayed");
    }

    @Test(priority = 2, description = "TC 02 ConnectGoogleFitTests - Verify Google Fit description is displayed")
    public void testGoogleFitDescriptionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        Assert.assertTrue(connectGoogleFitPage.isGoogleFitDescriptionDisplayed(), "Google Fit description should be displayed");
    }

    @Test(priority = 3, description = "TC 03 ConnectGoogleFitTests - Verify clicking Continue navigates to Permission Activity page")
    public void testNavigateToPermissionActivityPage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickContinueButton();
        Assert.assertTrue(connectGoogleFitPage.isAllowActivityButtonDisplayed(), "Allow button should be displayed on Permission Activity page");
    }

    @Test(priority = 4, description = "TC 04 ConnectGoogleFitTests - Verify clicking Allow on Permission Activity page navigates to Permission Location page")
    public void testNavigateToPermissionLocationPage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickContinueButton();
        connectGoogleFitPage.clickAllowActivityButton();
        Assert.assertTrue(connectGoogleFitPage.isAllowWhileUsingAppButtonDisplayed(), "Allow While Using App button should be displayed on Permission Location page");
    }

    @Test(priority = 5, description = "TC 05 ConnectGoogleFitTests - Verify navigating through all permissions leads to Google Sign In Page")
    public void testNavigateThroughPermissions() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickContinueButton();
        connectGoogleFitPage.navigateThroughPermissions();
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        healthRecordPage.isSignInTextDisplayed();


    }

    @Test(priority = 6, description = "TC 06 ConnectGoogleFitTests -  Verify visibility of Allow button in physical activity permission")
    public void testVisibilityOfAllowInPhysicalPermission() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickContinueButton();
        Assert.assertTrue(connectGoogleFitPage.isAllowActivityButtonDisplayed(), "Allow button should be visible in physical activity permission");
    }

    @Test(priority = 7, description = "TC 07 ConnectGoogleFitTests -  Verify visibility of Deny button in physical activity permission")
    public void testVisibilityOfDenyInPhysicalPermission() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickContinueButton();
        Assert.assertTrue(connectGoogleFitPage.isDenyActivityButtonDisplayed(), "Deny button should be visible in physical activity permission");
    }

    @Test(priority = 8, description = "TC 08 ConnectGoogleFitTests -  Verify visibility of Allow While Using App button in location permission")
    public void testVisibilityOfAllowWhileUsingAppInLocationPermission() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickContinueButton();
        connectGoogleFitPage.clickAllowActivityButton();
        Assert.assertTrue(connectGoogleFitPage.isAllowWhileUsingAppButtonDisplayed(), "Allow While Using App button should be visible in location permission");
    }

    @Test(priority = 9, description = "TC 09 ConnectGoogleFitTests -  Verify visibility of Allow Only This Time button in location permission")
    public void testVisibilityOfAllowOnlyThisTimeInLocationPermission() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickContinueButton();
        connectGoogleFitPage.clickAllowActivityButton();
        Assert.assertTrue(connectGoogleFitPage.isAllowOnlyThisTimeButtonDisplayed(), "Allow Only This Time button should be visible in location permission");
    }

    @Test(priority = 10, description = "TC 10 ConnectGoogleFitTests -  Verify visibility of Deny button in location permission")
    public void testVisibilityOfDenyInLocationPermission() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickContinueButton();
        connectGoogleFitPage.clickAllowActivityButton();
        Assert.assertTrue(connectGoogleFitPage.isDenyLocationButtonDisplayed(), "Deny button should be visible in location permission");
    }


    @Test(priority = 8, description = "TC 11 ConnectGoogleFitTests - Verify that clicking Skip on the Connect Google Fit page takes us to  notification permission")
    public void testClickSkipNavigatesToHomeWithNotificationPermission() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        Assert.assertTrue(connectGoogleFitPage.isNotificationPermissionPopupVisible(), "Notification permission popup should be visible");
    }

    @Test(priority = 8, description = "TC 12 ConnectGoogleFitTests - Verify visibility of Allow button in Notification permission")
    public void testAllowNotificationButtonVisibility() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        Assert.assertTrue(connectGoogleFitPage.isNotificationPermissionPopupVisible(), "Notification permission popup should be visible");
        Assert.assertTrue(connectGoogleFitPage.isAllowNotificationButtonVisible(), "Allow Notification button should be visible");
    }

    @Test(priority = 9, description = "TC 13 ConnectGoogleFitTests - Verify visibility of Deny button in Notification permission")
    public void testDenyNotificationButtonVisibility() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        Assert.assertTrue(connectGoogleFitPage.isNotificationPermissionPopupVisible(), "Notification permission popup should be visible");
        Assert.assertTrue(connectGoogleFitPage.isDenyNotificationButtonVisible(), "Deny Notification button should be visible");
    }

    @Test(priority = 11, description = "TC 14 ConnectGoogleFitTests - Verify that clicking Allow in Notification permission lands us on Home page")
    public void testClickAllowNotificationNavigatesToHome() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        Assert.assertTrue(connectGoogleFitPage.isHomeScreenVisible(), "Home screen should be displayed after allowing notifications");
    }

}


