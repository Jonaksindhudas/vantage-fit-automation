package org.vantagefit.testCases;

import org.vantagefit.pageObjects.android.*;
import org.vantagefit.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HealthRecordPageTests extends AndroidBaseTest {


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
    }

    @Test(priority = 1, description = "TC 01 HealthRecordPageTests- Verify Health Record Page Title")
    public void testHealthRecordPageTitle() {
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        String title = healthRecordPage.getHealthRecordTitle();
        Assert.assertEquals(title, "Health Records", "Health Record Title should match");
    }

    @Test(priority = 2, description = "TC 02 HealthRecordPageTests- Verify Health Record Details Text")
    public void testHealthRecordDetailsText() {
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        String details = healthRecordPage.getHealthRecordDetails();
        Assert.assertEquals(details, "We have the following records of your health data in our servers", "Health Record Details should match");
    }

    @Test(priority = 3, description = "TC 03 HealthRecordPageTests- Verify Continue button on Health Record Page should guides us to BMI Screen")
    public void testContinueButton() {
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        healthRecordPage.clickContinue();
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        Assert.assertTrue(addHealthDataPages.isBMIScreenDisplayed(), "BMI screen should be displayed");

    }


    @Test(priority = 4, description = "TC 04 HealthRecordPageTests- Verify Basic Info and Body cards are not clickable")
    public void testBasicInfoAndBodyCardsNotClickable() {
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        Assert.assertTrue(healthRecordPage.isAgeCardViewClickable(), "Age Card should not be clickable");
        Assert.assertTrue(healthRecordPage.isGenderCardViewClickable(), "Gender Card should not be clickable");
        Assert.assertTrue(healthRecordPage.isHeightCardViewClickable(), "Height Card should not be clickable");
        Assert.assertTrue(healthRecordPage.isWeightCardViewClickable(), "Weight Card should not be clickable");
    }

    @Test(priority = 5, description = "TC 05 HealthRecordPageTests- Verify Import from Google Fit and Add Data Manually are clickable")
    public void testImportAndManualDataCardsClickable() {
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        Assert.assertTrue(healthRecordPage.isImportCardViewClickable(), "Import from Google Fit should be clickable");
        Assert.assertTrue(healthRecordPage.isManualCardViewClickable(), "Add Data Manually should be clickable");
    }


    @Test(priority = 6, description = "TC 06 HealthRecordPageTests- Verify importing data from Google Fit")
    public void testImportDataFromGoogleFit() {
        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        healthRecordPage.clickImportFromGoogleFit();
        healthRecordPage.allowPhysicalActivityAccess();
        healthRecordPage.allowLocationAccess();
        healthRecordPage.isSignInTextDisplayed();

    }

    @Test(priority = 7, description = "TC 07 HealthRecordPageTests - Verify navigating to Add Manually page displays Select Birthday page")
    public void testNavigateToAddManuallyPage() {

        HealthRecordPage healthRecordPage = new HealthRecordPage(driver);
        AddHealthManuallyPages addManuallyPage = healthRecordPage.clickAddDataManually();
        Assert.assertTrue(addManuallyPage.isSelectBirthdayDisplayed(), "Select Birthday page should be displayed after clicking Add Data Manually");
    }






}







