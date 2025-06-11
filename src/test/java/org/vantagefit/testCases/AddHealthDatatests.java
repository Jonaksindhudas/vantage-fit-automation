package org.vantagefit.testCases;

import org.vantagefit.pageObjects.android.*;
import org.vantagefit.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddHealthDatatests extends AndroidBaseTest {

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
    }

    @Test(priority = 1, description = "TC AddHealthDatatests- 01 Verify Birthday Dropdown is Clickable and Date Picker Appears")
    public void testBirthdayDropdownAndDatePicker() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        addHealthDataPages.clickBirthdayDropdown();
        Assert.assertTrue(addHealthDataPages.isDatePickerDisplayed(), "Date Picker should be displayed");
        addHealthDataPages.selectDateFromDatePicker();
    }

    @Test(priority = 2, description = "TC AddHealthDatatests- 02 Verify Gender Selection as Male")
    public void testSelectGenderAsMale() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        addHealthDataPages.selectMaleGender();
        Assert.assertTrue(addHealthDataPages.isMaleGenderSelected(), "Male gender should be selected");
    }

    @Test(priority = 3, description = "TC 03 AddHealthDatatests- Verify Gender Selection as Female")
    public void testSelectGenderAsFemale() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        addHealthDataPages.selectFemaleGender();
        Assert.assertTrue(addHealthDataPages.isFemaleGenderSelected(), "Female gender should be selected");
    }

    @Test(priority = 4, description = "TC 04 AddHealthDatatests- Verify Gender Selection as Others")
    public void testSelectGenderAsOthers() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        addHealthDataPages.selectOthersGender();
        Assert.assertTrue(addHealthDataPages.isOthersGenderSelected(), "Others gender should be selected");
    }

    @Test(priority = 5, description = "TC 05 AddHealthDatatests- Verify Gender Selection as Not Specified")
    public void testSelectGenderAsNotSpecified() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        addHealthDataPages.selectNotSpecifiedGender();
        Assert.assertTrue(addHealthDataPages.isNotSpecifiedGenderSelected(), "Not Specified gender should be selected");
    }

    @Test(priority = 6, description = "TC 06 AddHealthDatatests Verify Next Button Navigates to Height Page")
    public void testNextButtonNavigatesToHeightPage() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        addHealthDataPages.clickNextButton();
        Assert.assertTrue(addHealthDataPages.isHeightPageDisplayed(), "Height page should be displayed");
    }

    @Test(priority = 7, description = "TC 07 AddHealthDatatests- Verify Height Unit is Displayed in Inch and Feet")
    public void testHeightUnitDisplayedInInchAndFeet() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        addHealthDataPages.clickNextButton();
        Assert.assertTrue(addHealthDataPages.isHeightUnitInchDisplayed(), "Height unit should be displayed in inches");
        Assert.assertTrue(addHealthDataPages.isHeightUnitFeetDisplayed(), "Height unit should be displayed in feet");
    }

    @Test(priority = 8, description = "TC 08 AddHealthDatatests- Verify User Can Set Height")
    public void testSetHeight() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        addHealthDataPages.clickNextButton();
        //add test to set height
    }

    @Test(priority = 9, description = "TC 09 AddHealthDatatests - Verify Next Button Navigates to Weight Page from Height Page")
    public void testNextButtonNavigatesToWeightPage() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 2; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isWeightPageDisplayed(), "Weight page should be displayed");
    }

    @Test(priority = 10, description = "TC 10 AddHealthDatatests - Verify Weight Unit is Displayed in Lbs and Kg")
    public void testWeightUnitDisplayedInLbsAndKg() {

        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 2; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isWeightUnitLbsDisplayed(), "Weight unit should be displayed in lbs");
        Assert.assertTrue(addHealthDataPages.isWeightUnitKgDisplayed(), "Weight unit should be displayed in kg");
    }


    @Test(priority = 11, description = "TC 11 AddHealthDatatests - Verify Navigation to BMI Screen from Select Weight Screen")
    public void testNavigationToBMIScreen() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 3; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isBMIScreenDisplayed(), "BMI screen should be displayed");
    }

    @Test(priority = 12, description = "TC 12 AddHealthDatatests - Verify Entered Weight Displayed on BMI Screen")
    public void testWeightDisplayedOnBMIScreen() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 3; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertEquals(addHealthDataPages.getDisplayedWeightOnBMIScreen(), "Your current weight is 44  lbs", "Weight should be displayed correctly on BMI screen");
    }

    @Test(priority = 13, description = "TC 13 AddHealthDatatests - Verify BMI Score Display Based on Entered Weight")
    public void testBMIScoreDisplay() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 3; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertEquals(addHealthDataPages.getBMIScore(), "7.44", "BMI score should be displayed correctly based on entered weight");
        Assert.assertEquals(addHealthDataPages.getBMIStatus(), "Underweight", "BMI status should be displayed as Underweight");
    }

    @Test(priority = 14, description = "TC 14 AddHealthDatatests - Verify Ideal Weight Range Display")
    public void testIdealWeightRangeDisplay() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 3; i++) {
            addHealthDataPages.clickNextButton();
        };
        //Assert.assertTrue(addHealthDataPages.isIdealWeightRangeDisplayed(), "Ideal weight range should be displayed correctly");
    }

    @Test(priority = 15, description = "TC 15 AddHealthDatatests - Verify BMI Seekbar Display")
    public void testSeekbarDisplay() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 3; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isSeekbarDisplayed(), "Seekbar should be displayed correctly indicating the user's current weight position within the ideal weight range");
    }

    @Test(priority = 16, description = "TC 16 AddHealthDatatests - Verify navigation to the Choose Objective Page after clicking Next on the BMI Screen")
    public void verifyNavigationToChooseObjectivePage() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isChooseObjectivePageDisplayed(), "User should be navigated to the Choose Objective page after clicking Next on the BMI screen");
    }

    @Test(priority = 17, description = "TC 17 AddHealthDatatests - Verify Lose Weight card is enabled")
    public void verifyLoseWeightCardIsEnabled() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isLoseWeightCardEnabled(), "Lose Weight card should be enabled");
    }

    @Test(priority = 18, description = "TC 18 AddHealthDatatests - Verify Reduce Belly Fat card is enabled")
    public void verifyReduceBellyFatCardIsEnabled() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isReduceBellyFatCardEnabled(), "Reduce Belly Fat card should be enabled");
    }

    @Test(priority = 19, description = "TC 19 AddHealthDatatests - Verify Gain Muscle card is enabled")
    public void verifyGainMuscleCardIsEnabled() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isGainMuscleCardEnabled(), "Gain Muscle card should be enabled");
    }

    @Test(priority = 20, description = "TC 20 AddHealthDatatests - Verify Be Fitter card is enabled")
    public void verifyBeFitterCardIsEnabled() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isBeFitterCardEnabled(), "Be Fitter card should be enabled");
    }

    @Test(priority = 21, description = "TC 21 AddHealthDatatests - Verify Lose Weight card is clicked and selected")
    public void verifyLoseWeightCardIsClickedAndSelected() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickLoseWeightCard();
        Assert.assertTrue(addHealthDataPages.isLoseWeightCardSelected(), "Lose Weight card should be selected after clicking");
    }

    @Test(priority = 22, description = "TC 22 AddHealthDatatests - Verify Reduce Belly Fat card is clicked and selected")
    public void verifyReduceBellyFatCardIsClickedAndSelected() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickReduceBellyFatCard();
        Assert.assertTrue(addHealthDataPages.isReduceBellyFatCardSelected(), "Reduce Belly Fat card should be selected after clicking");
    }

    @Test(priority = 23, description = "TC 23 AddHealthDatatests - Verify Gain Muscle card is clicked and selected")
    public void verifyGainMuscleCardIsClickedAndSelected() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickGainMuscleCard();
        Assert.assertTrue(addHealthDataPages.isGainMuscleCardSelected(), "Gain Muscle card should be selected after clicking");
    }

    @Test(priority = 24, description = "TC 24 AddHealthDatatests - Verify Be Fitter card is clicked and selected")
    public void verifyBeFitterCardIsClickedAndSelected() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 4; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickBeFitterCard();
        Assert.assertTrue(addHealthDataPages.isBeFitterCardSelected(), "Be Fitter card should be selected after clicking");
    }


    @Test(priority = 25, description = "TC 25 AddHealthDatatests - Verify navigation to the How Active Are You Page? after clicking Next on the Choose Objective Page")
    public void verifyNavigationToHowActivePage() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isHowActivePageDisplayed(), "User should be navigated to the How Active Are You page after clicking Next on the Choose Objective page");
    }

    @Test(priority = 26, description = "TC 26 AddHealthDatatests - Verify Not Very Active card is enabled")
    public void verifyNotVeryActiveCardIsEnabled() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isNotVeryActiveCardEnabled(), "Not Very Active card should be enabled");
    }

    @Test(priority = 27, description = "TC 27 AddHealthDatatests - Verify Slightly Active card is enabled")
    public void verifySlightlyActiveCardIsEnabled() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isSlightlyActiveCardEnabled(), "Slightly Active card should be enabled");
    }

    @Test(priority = 28, description = "TC 28 AddHealthDatatests - Verify Moderately Active card is enabled")
    public void verifyModeratelyActiveCardIsEnabled() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isModeratelyActiveCardEnabled(), "Moderately Active card should be enabled");
    }

    @Test(priority = 29, description = "TC 29 AddHealthDatatests - Verify Very Active card is enabled")
    public void verifyVeryActiveCardIsEnabled() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        Assert.assertTrue(addHealthDataPages.isVeryActiveCardEnabled(), "Very Active card should be enabled");
    }

    @Test(priority = 30, description = "TC 30 AddHealthDatatests - Verify Not Very Active card is clicked and selected")
    public void verifyNotVeryActiveCardIsClickedAndSelected() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickNotVeryActiveCard();
        Assert.assertTrue(addHealthDataPages.isNotVeryActiveCardSelected(), "Not Very Active card should be selected after clicking");
    }

    @Test(priority = 31, description = "TC 31 AddHealthDatatests - Verify Slightly Active card is clicked and selected")
    public void verifySlightlyActiveCardIsClickedAndSelected() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickSlightlyActiveCard();
        Assert.assertTrue(addHealthDataPages.isSlightlyActiveCardSelected(), "Slightly Active card should be selected after clicking");
    }

    @Test(priority = 32, description = "TC 32 AddHealthDatatests -  Verify Moderately Active card is clicked and selected")
    public void verifyModeratelyActiveCardIsClickedAndSelected() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickModeratelyActiveCard();
        Assert.assertTrue(addHealthDataPages.isModeratelyActiveCardSelected(), "Moderately Active card should be selected after clicking");
    }

    @Test(priority = 33, description = "TC 33 AddHealthDatatests - Verify Very Active card is clicked and selected")
    public void verifyVeryActiveCardIsClickedAndSelected() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickVeryActiveCard();
        Assert.assertTrue(addHealthDataPages.isVeryActiveCardSelected(), "Very Active card should be selected after clicking");
    }


    @Test(priority = 34, description = "TC34 AddHealthDatatests - Verify navigation to the 'Your Daily Calorie Target' Page after clicking 'Let's Start' on the 'How Active Are You?' Page")
    public void verifyNavigationToDailyCalorieTargetPage() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickLetsStartButton();
        Assert.assertTrue(addHealthDataPages.isDailyCalorieTargetPageDisplayed(), "User should be navigated to the 'Your Daily Calorie Target' page after clicking 'Let's Start' on the 'How Active Are You?' page");
    }

    @Test(priority = 35, description = "TC35 AddHealthDatatests - Verify 'Your Daily Calorie Target' title is present on the Daily Calorie Target Page")
    public void verifyDailyCalorieTargetTitleIsPresent() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickLetsStartButton();
        Assert.assertTrue(addHealthDataPages.isDailyCalorieTargetTitleDisplayed(), "'Your Daily Calorie Target' title should be present on the Daily Calorie Target page");
    }

    @Test(priority = 36, description = "TC36 AddHealthDatatests - Verify the unit 'calories' is displayed on the Daily Calorie Target Page")
    public void verifyCaloriesUnitIsDisplayed() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickLetsStartButton();
        Assert.assertTrue(addHealthDataPages.isCaloriesUnitDisplayed(), "The unit 'calories' should be displayed on the Daily Calorie Target page");
    }

    @Test(priority = 37, description = "TC37 AddHealthDatatests - Verify clicking Continue navigates to Connect Google Fit Page")
    public void verifyNavigationToConnectGoogleFitPage() {
        AddHealthManuallyPages addHealthDataPages = new AddHealthManuallyPages(driver);
        for (int i = 0; i < 5; i++) {
            addHealthDataPages.clickNextButton();
        };
        addHealthDataPages.clickLetsStartButton();
        ConnectGoogleFitPage connectGoogleFitPage = addHealthDataPages.navigateToConnectGoogleFitPage();
        Assert.assertTrue(connectGoogleFitPage.isConnectGoogleFitPageDisplayed(), "User should be navigated to the 'Connect Google Fit' page after clicking 'Continue' on the 'Your Daily Calorie Target' page");
    }


}

