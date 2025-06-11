package org.vantagefit.testCases;

import org.vantagefit.pageObjects.android.*;
import org.vantagefit.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FABMenuTests extends AndroidBaseTest {

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
        }
        addHealthDataPages.clickLetsStartButton();
        ConnectGoogleFitPage connectGoogleFitPage = addHealthDataPages.navigateToConnectGoogleFitPage();
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
    }

    @Test(priority = 1, description = "TC 01 FABMenuTest - Verify FAB icon is displayed")
    public void testNoDeviceConnectedMessageDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isFABMenuDisplayed(), "FAB icon is not displayed");
    }

    @Test(priority = 2, description = "TC 02 FABMenuTest - Verify clicking FAB icon expands menu")
    public void testFABMenuExpands() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isFABOptionsExpanded(), "FAB menu options are not expanded");
    }

    @Test(priority = 3, description = "TC 03 FABMenuTest - Verify Sync Activities option is displayed")
    public void testSyncActivitiesOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isSyncActivitiesOptionVisible(), "Sync Activities option is not displayed");
    }

    @Test(priority = 4, description = "TC 04 FABMenuTest - Verify Start Outdoor Activity option is displayed")
    public void testStartOutdoorActivityOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isStartOutdoorActivityOptionVisible(), "Start Outdoor Activity option is not displayed");
    }

    @Test(priority = 5, description = "TC 05 FABMenuTest - Verify Log Activity option is displayed")
    public void testLogActivityOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogActivityOptionVisible(), "Log Activity option is not displayed");
    }

    @Test(priority = 6, description = "TC 06 FABMenuTest - Verify Log Water Intake option is displayed")
    public void testLogWaterIntakeOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogWaterIntakeOptionVisible(), "Log Water Intake option is not displayed");
    }

    @Test(priority = 7, description = "TC 07 FABMenuTest - Verify Log Today's Meal option is displayed")
    public void testLogTodaysMealOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogMealOptionVisible(), "Log Today's Meal option is not displayed");
    }

    @Test(priority = 8, description = "TC 08 FABMenuTest - Verify Measure Heart Rate option is displayed")
    public void testMeasureHeartRateOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isMeasureHeartRateOptionVisible(), "Measure Heart Rate option is not displayed");
    }

    @Test(priority = 9, description = "TC 09 FABMenuTest - Verify Update Weight option is displayed")
    public void testUpdateWeightOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isUpdateWeightOptionVisible(), "Update Weight option is not displayed");
    }

    @Test(priority = 10, description = "TC 10 FABMenuTest - Verify Track Mood option is displayed")
    public void testTrackMoodOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isTrackMoodOptionVisible(), "Track Mood option is not displayed");
    }

    @Test(priority = 11, description = "TC 11 FABMenuTest - Verify Start Squats Workout option is displayed")
    public void testStartSquatsWorkoutOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isStartSquatsWorkoutOptionVisible(), "Start Squats Workout option is not displayed");
    }

    @Test(priority = 12, description = "TC 12 FABMenuTest - Verify Log Activity option is clickable")
    public void testLogActivityOptionClickable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogActivityOptionClickable(), "Log Activity option is not clickable");
    }

    @Test(priority = 13, description = "TC 13 FABMenuTest - Verify Sync Activities option is clickable")
    public void testSyncActivitiesOptionClickable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isSyncActivitiesOptionClickable(), "Sync Activities option is not clickable");
    }

    @Test(priority = 14, description = "TC 14 FABMenuTest - Verify navigation to Sync Activities screen")
    public void testNavigationToSyncActivitiesScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickSyncActivitiesOption();
        Assert.assertTrue(homePage.isSyncScreenDisplayed(), "Navigation to Sync Activities screen failed");
    }

    @Test(priority = 15, description = "TC 15 FABMenuTest - Verify navigation to Log Water Intake screen")
    public void testNavigationToLogWaterIntakeScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickLogWaterIntakeOption();
        Assert.assertTrue(homePage.isWaterIntakeLoggingScreenDisplayed(), "Navigation to Log Water Intake screen failed");
    }

    @Test(priority = 16, description = "TC 16 FABMenuTest - Verify navigation to Log Meal screen")
    public void testNavigationToLogMealScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickLogMealOption();
        Assert.assertTrue(homePage.isMealLoggingScreenDisplayed(), "Navigation to Log Meal screen failed");
    }

    @Test(priority = 17, description = "TC 17 FABMenuTest - Verify navigation to Measure Heart Rate screen")
    public void testNavigationToMeasureHeartRateScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickMeasureHeartRateOption();
        Assert.assertTrue(homePage.isHeartRateScreenDisplayed(), "Navigation to Measure Heart Rate screen failed");
    }

    @Test(priority = 18, description = "TC 18 FABMenuTest - Verify FAB menu closes after clicking an option")
    public void testFABMenuClosesAfterClick() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickLogWaterIntakeOption();
        Assert.assertFalse(homePage.isFABOptionsExpanded(), "FAB menu did not close after clicking an option");
    }


    @Test(priority = 19, description = "TC 19 FABMenuTest - Verify Log Sleep option is displayed")
    public void testLogSleepOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogSleepOptionVisible(), "Log Sleep option is not displayed");
    }

    @Test(priority = 20, description = "TC 20 FABMenuTest - Verify Log Sleep option is clickable")
    public void testLogSleepOptionClickable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogSleepOptionClickable(), "Log Sleep option is not clickable");
    }

    @Test(priority = 21, description = "TC 21 FABMenuTest - Verify navigation to Log Sleep screen")
    public void testNavigationToLogSleepScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickLogSleepOption();
        Assert.assertTrue(homePage.isSleepLoggingScreenDisplayed(), "Navigation to Log Sleep screen failed");
    }

    @Test(priority = 22, description = "TC 22 FABMenuTest - Verify Track Mood option is clickable")
    public void testTrackMoodOptionClickable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isTrackMoodOptionClickable(), "Track Mood option is not clickable");
    }

    @Test(priority = 23, description = "TC 23 FABMenuTest - Verify navigation to Track Mood screen")
    public void testNavigationToTrackMoodScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickTrackMoodOption();
        Assert.assertTrue(homePage.isMoodTrackingScreenDisplayed(), "Navigation to Track Mood screen failed");
    }

    @Test(priority = 24, description = "TC 24 FABMenuTest - Verify Start 7-Minute Workout option is displayed")
    public void testStartSevenMinuteWorkoutOptionDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isStartSevenMinuteWorkoutOptionVisible(), "Start 7-Minute Workout option is not displayed");
    }

    @Test(priority = 25, description = "TC 25 FABMenuTest - Verify Start 7-Minute Workout option is clickable")
    public void testStartSevenMinuteWorkoutOptionClickable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isStartSevenMinuteWorkoutOptionClickable(), "Start 7-Minute Workout option is not clickable");
    }

    @Test(priority = 26, description = "TC 26 FABMenuTest - Verify navigation to 7-Minute Workout screen")
    public void testNavigationToSevenMinuteWorkoutScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickStartSevenMinuteWorkoutOption();
        Assert.assertTrue(homePage.isSevenMinuteWorkoutScreenDisplayed(), "Navigation to 7-Minute Workout screen failed");
    }

    @Test(priority = 27, description = "TC 27 FABMenuTest - Verify Start Squats Workout option is clickable")
    public void testStartSquatsWorkoutOptionClickable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isStartSquatsWorkoutOptionClickable(), "Start Squats Workout option is not clickable");
    }

    @Test(priority = 28, description = "TC 28 FABMenuTest - Verify navigation to Squats Workout screen")
    public void testNavigationToSquatsWorkoutScreen() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickStartSquatsWorkoutOption();
        Assert.assertTrue(homePage.isSquatsWorkoutScreenDisplayed(), "Navigation to Squats Workout screen failed");
    }

    @Test(priority = 29, description = "TC 29 FABMenuTest - Verify FAB menu scroll functionality")
    public void testFABMenuScroll() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.scrollFABMenuDown();
        Assert.assertTrue(homePage.isFABMenuScrolled(), "FAB menu did not scroll properly");
    }

    @Test(priority = 30, description = "TC 30 FABMenuTest - Verify FAB menu remains functional after multiple operations")
    public void testFABMenuFunctionalityAfterMultipleOperations() {
        HomePage homePage = new HomePage(driver);
        for (int i = 0; i < 5; i++) {
            homePage.clickFABMenu();
            homePage.clickLogWaterIntakeOption();
            homePage.clickFABMenu();
        }
        Assert.assertTrue(homePage.isFABMenuFunctional(), "FAB menu did not remain functional after multiple operations");
    }

}
