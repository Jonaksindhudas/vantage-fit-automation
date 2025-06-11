package org.vantagefit.testCases;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.vantagefit.pageObjects.android.AgreementPage;
import org.vantagefit.pageObjects.android.HealthRecordPage;
import org.vantagefit.pageObjects.android.LoginScreen;
import org.vantagefit.pageObjects.android.WorkEmailLoginPage;
import org.vantagefit.pageObjects.android.WorkEmailPasswordPage;
import org.vantagefit.testUtils.AndroidBaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AgreementPageTests extends AndroidBaseTest {

    WorkEmailPasswordPage workEmailPasswordPage;

    @BeforeMethod(alwaysRun = true )
    public void presetup() {
        driver.terminateApp("com.bargaintechnologies.vantagefit.v_fit");
        driver.activateApp("com.bargaintechnologies.vantagefit.v_fit");
        LoginScreen loginScreen = new LoginScreen(driver);
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail("johnmclane@jsdemo.com");
        workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword("welcome");
        AgreementPage agreementPage = workEmailPasswordPage.passDriverToAgreementPage();
        agreementPage.acceptAgreement();
    }

    @Test(priority = 1, description = "TC 01 AgreementPage - Verify Disagree button goes back to Login Screen")
    public void testDisagreeButton() {
        AgreementPage agreementPage = workEmailPasswordPage.passDriverToAgreementPage();
        agreementPage.clickDisagree();

        // Verify that the app navigates back to the login screen
        LoginScreen loginScreen = new LoginScreen(driver);
        Assert.assertTrue(loginScreen.isDisplayed(), "Login Screen should be displayed");
    }

    @Test(priority = 2, description = "TC 02 AgreementPage - Verify Agree button goes to Health Record Screen")
    public void testAgreeButton() {
        AgreementPage agreementPage = workEmailPasswordPage.passDriverToAgreementPage();
        agreementPage.acceptAgreement();

        // Verify that the app navigates to the Health Record Screen
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        Assert.assertTrue(healthRecordPage.isDisplayed(), "Health Record Screen should be displayed");
    }

    @Test(priority = 3, description = "TC 03 AgreementPage - Verify Program Name on Agreement Page")
    public void testProgramName() {
        AgreementPage agreementPage = workEmailPasswordPage.passDriverToAgreementPage();
        String programName = agreementPage.getProgramName();
        Assert.assertEquals(programName, "JSDDEMO Employee Advantage", "Program Name should match");

    }

    @Test(priority = 4, description = "TC 04 AgreementPage - Verify visibility of Agree and Disagree buttons on Agreement Page")
    public void testVisibilityOfAgreeAndDisagreeButtons() {

        AgreementPage agreementPage = workEmailPasswordPage.passDriverToAgreementPage();
        Assert.assertTrue(agreementPage.isAgreeButtonDisplayed(), "Agree Button should be displayed");
        Assert.assertTrue(agreementPage.isDisagreeButtonDisplayed(), "Disagree Button should be displayed");
    }




}
