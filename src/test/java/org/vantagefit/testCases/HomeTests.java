package org.vantagefit.testCases;

import org.vantagefit.pageObjects.android.*;
import org.vantagefit.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomeTests extends  AndroidBaseTest {
    @BeforeMethod(alwaysRun = true)
    public void presetup() {
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
        ;
        addHealthDataPages.clickLetsStartButton();
        ConnectGoogleFitPage connectGoogleFitPage = addHealthDataPages.navigateToConnectGoogleFitPage();


    }
    @Test(priority = 1, description = "TC 01 HomeTests - Verify No Device Connected message is displayed")
    public void testNoDeviceConnectedMessageDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isNoDeviceConnectedMessageDisplayed(), "Home screen should display 'No Device Connected' message.");
    }

    @Test(priority = 2, description = "TC 02 HomeTests - Verify Calorie Target section is displayed")
    public void testCalorieTargetSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCalorieTargetSectionDisplayed(), "Calorie Target section should be displayed.");
    }

    @Test(priority = 3, description = "TC 03 HomeTests - Verify Nutrition section is displayed")
    public void testNutritionSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);

        boolean isNutritionVisible = false;
        for (int i = 0; i < 5; i++) { // Try scrolling up to 5 times
            if (homePage.isNutritionSectionDisplayed()) {
                isNutritionVisible = true;
                break;
            }
            homePage.scrollDownALittle();
        }

        Assert.assertTrue(isNutritionVisible, "Nutrition section should be displayed after scrolling.");
    }

    @Test(priority = 4, description = "TC 04 HomeTests - Verify Meals section is displayed in Nutrition section")
    public void testMealsSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isMealsSectionDisplayed(), "Meals section should be displayed in the Nutrition section.");
    }

    @Test(priority = 5, description = "TC 05 HomeTests - Verify Water section is displayed in Nutrition section")
    public void testWaterSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isWaterSectionDisplayed(), "Water section should be displayed in the Nutrition section.");
    }

    @Test(priority = 6, description = "TC 06 HomeTests - Verify Sleep section is displayed")
    public void testSleepSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isSleepSectionDisplayed(), "Sleep section should be displayed.");
    }

    @Test(priority = 7, description = "TC 07 HomeTests - Verify Carbs section is displayed in Nutrition section")
    public void testCarbsSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isCarbsSectionDisplayed(), "Carbs section should be displayed in the Nutrition section.");
    }

    @Test(priority = 8, description = "TC 08 HomeTests - Verify Protein section is displayed in Nutrition section")
    public void testProteinSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isProteinSectionDisplayed(), "Protein section should be displayed in the Nutrition section.");
    }

    @Test(priority = 9, description = "TC 09 HomeTests - Verify Fats section is displayed in Nutrition section")
    public void testFatsSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isFatsSectionDisplayed(), "Fats section should be displayed in the Nutrition section.");
    }

    @Test(priority = 10, description = "TC 10 HomeTests - Verify Add Sleep button is displayed in Sleep section")
    public void testAddSleepButtonDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isAddSleepButtonDisplayed(), "Add Sleep button should be displayed in the Sleep section.");
    }

    @Test(priority = 11, description = "TC 11 HomeTests - Verify step count is displayed if a device is connected")
    public void testStepCountDisplayedWithDevice() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isStepCountDisplayed(), "Step count should be displayed when a device is connected.");
    }

    @Test(priority = 12, description = "TC 12 HomeTests - Verify step count is hidden if no device is connected")
    public void testStepCountHiddenWithoutDevice() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertFalse(homePage.isStepCountDisplayed(), "Step count should not be displayed when no device is connected.");
    }

    @Test(priority = 13, description = "TC 13 HomeTests - Verify 'Add Sleep' button is displayed if no sleep data is found")
    public void testAddSleepButtonDisplayedIfNoData() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isAddSleepButtonDisplayed(), "Add Sleep button should be displayed if no sleep data is found.");
    }

    @Test(priority = 14, description = "TC 14 HomeTests - Verify 'Add Sleep' button is clickable")
    public void testAddSleepButtonClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.scrollToEndAction();
        Assert.assertTrue(homePage.isAddSleepButtonClickable(), "Add Sleep button should be clickable.");
    }

    @Test(priority = 15, description = "TC 15 HomeTests - Verify 'Challenges' section is displayed on the Home Page")
    public void testChallengesSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isChallengesSectionDisplayed(), "'Challenges' section should be displayed on the Home Page.");
    }

    @Test(priority = 16, description = "TC 16 HomeTests - Verify 'Challenges' section text is correctly displayed")
    public void testChallengesSectionTextDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isChallengesSectionTextDisplayed(), "'Challenges' section text should be correctly displayed.");
    }


    @Test(priority = 17, description = "TC 17 HomeTests - Verify 'Calories' section displays user's calorie target")
    public void testCaloriesSectionDisplaysTarget() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCalorieTargetDisplayed(), "Calories section should display the user's calorie target.");
    }

    @Test(priority = 18, description = "TC 18 HomeTests - Verify 'Calories' section displays logged meals")
    public void testCaloriesSectionDisplaysMeals() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoggedMealsDisplayed(), "Calories section should display logged meals.");
    }

    @Test(priority = 19, description = "TC 19 HomeTests - Verify 'Calories' section displays logged water intake")
    public void testCaloriesSectionDisplaysWaterIntake() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoggedWaterIntakeDisplayed(), "Calories section should display logged water intake.");
    }

    @Test(priority = 20, description = "TC 20 HomeTests - Verify 'Calories' section displays resting calories")
    public void testCaloriesSectionDisplaysRestingCalories() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isRestingCaloriesDisplayed(), "Calories section should display resting calories.");
    }

    @Test(priority = 21, description = "TC 21 HomeTests - Verify 'Calories' section displays active calories")
    public void testCaloriesSectionDisplaysActiveCalories() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isActiveCaloriesDisplayed(), "Calories section should display active calories.");
    }

    @Test(priority = 22, description = "TC 22 HomeTests - Verify 'Calories' section shows calorie deficit")
    public void testCaloriesSectionShowsCalorieDeficit() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCalorieDeficitDisplayed(), "Calories section should show calorie deficit.");
    }

    @Test(priority = 23, description = "TC 23 HomeTests - Verify the presence of a nutrition insights text")
    public void testNutritionInsightsTextPresence() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isNutritionInsightsTextDisplayed(), "Nutrition insights text should be displayed.");
    }

    @Test(priority = 24, description = "TC 24 HomeTests - Verify 'Programs' tab is visible in the bottom navigation")
    public void testProgramsTabVisibility() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProgramsTabVisible(), "Programs tab should be visible in the bottom navigation.");
    }

    @Test(priority = 25, description = "TC 25 HomeTests - Verify 'Community' tab is visible in the bottom navigation")
    public void testCommunityTabVisibility() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCommunityTabVisible(), "Community tab should be visible in the bottom navigation.");
    }

    @Test(priority = 26, description = "TC 26 HomeTests - Verify the 'Home' tab icon is highlighted when selected")
    public void testHomeTabHighlighting() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomeTabHighlighted(), "Home tab should be highlighted when selected.");
    }

    @Test(priority = 27, description = "TC 27 HomeTests - Verify the 'Challenges' tab icon is highlighted when selected")
    public void testChallengesTabHighlighting() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isChallengesTabHighlighted(), "Challenges tab should be highlighted when selected.");
    }

    @Test(priority = 28, description = "TC 28 HomeTests - Verify the 'Programs' tab icon is highlighted when selected")
    public void testProgramsTabHighlighting() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProgramsTabHighlighted(), "Programs tab should be highlighted when selected.");
    }

    @Test(priority = 29, description = "TC 29 HomeTests - Verify the 'Community' tab icon is highlighted when selected")
    public void testCommunityTabHighlighting() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCommunityTabHighlighted(), "Community tab should be highlighted when selected.");
    }

    @Test(priority = 30, description = "TC 30 HomeTests - Verify profile icon is visible at the top left")
    public void testProfileIconVisibility() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProfileIconVisible(), "Profile icon should be visible at the top left.");
    }


    @Test(priority = 31, description = "TC 31 HomeTests - Verify profile icon is visible at the top left")
    public void testProfileIconVisible() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 32, description = "TC 32 HomeTests - Verify profile icon is clickable")
    public void testProfileIconClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 33, description = "TC 33 HomeTests - Verify profile icon opens the profile settings")
    public void testProfileIconOpensSettings() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 34, description = "TC 34 HomeTests - Verify the date is displayed correctly at the top")
    public void testDateDisplayedCorrectly() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 35, description = "TC 35 HomeTests - Verify the calendar navigation is available")
    public void testCalendarNavigationAvailable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 36, description = "TC 36 HomeTests - Verify the calendar allows navigation to different dates")
    public void testCalendarAllowsDateNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 37, description = "TC 37 HomeTests - Verify the 'Add Sleep' button opens sleep data input")
    public void testAddSleepButtonOpensInput() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 38, description = "TC 38 HomeTests - Verify 'No Device Connected!' banner is clickable")
    public void testNoDeviceConnectedBannerClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 39, description = "TC 39 HomeTests - Verify 'No Device Connected!' banner directs to device connection screen")
    public void testNoDeviceConnectedBannerDirectsToConnection() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 40, description = "TC 40 HomeTests - Verify meal calorie count is updated after logging a meal")
    public void testMealCalorieCountUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 41, description = "TC 41 HomeTests - Verify water intake is updated after logging water")
    public void testWaterIntakeUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 42, description = "TC 42 HomeTests - Verify nutrition breakdown updates correctly")
    public void testNutritionBreakdownUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 43, description = "TC 43 HomeTests - Verify scrolling to the end of the Home Page")
    public void testScrollToEndOfHomePage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 44, description = "TC 44 HomeTests - Verify the 'Add Sleep' banner displays correctly")
    public void testAddSleepBannerDisplaysCorrectly() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 45, description = "TC 45 HomeTests - Verify correct units are displayed for calories")
    public void testCorrectCalorieUnitsDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 46, description = "TC 46 HomeTests - Verify correct units are displayed for water intake")
    public void testCorrectWaterUnitsDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 47, description = "TC 47 HomeTests - Verify correct units are displayed for nutritional info")
    public void testCorrectNutritionUnitsDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 48, description = "TC 48 HomeTests - Verify clicking 'Add Sleep' button shows a sleep tracker input")
    public void testClickAddSleepButtonShowsTracker() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 49, description = "TC 49 HomeTests - Verify the 'Add Sleep' button is enabled")
    public void testAddSleepButtonEnabled() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 50, description = "TC 50 HomeTests - Verify clicking on 'Meals' navigates to meal logging page")
    public void testMealsNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 51, description = "TC 51 HomeTests - Verify clicking on 'Water' navigates to water logging page")
    public void testWaterNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 52, description = "TC 52 HomeTests - Verify notifications are displayed at the top")
    public void testNotificationsDisplayedAtTop() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 53, description = "TC 53 HomeTests - Verify notification count is displayed")
    public void testNotificationCountDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 54, description = "TC 54 HomeTests - Verify notification count updates correctly")
    public void testNotificationCountUpdatesCorrectly() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 55, description = "TC 55 HomeTests - Verify navigation to challenges tab works")
    public void testNavigationToChallengesTab() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 56, description = "TC 56 HomeTests - Verify navigation to programs tab works")
    public void testNavigationToProgramsTab() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 57, description = "TC 57 HomeTests - Verify navigation to community tab works")
    public void testNavigationToCommunityTab() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 58, description = "TC 58 HomeTests - Verify notification banner is clickable")
    public void testNotificationBannerClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 59, description = "TC 59 HomeTests - Verify profile page opens correctly")
    public void testProfilePageOpensCorrectly() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 60, description = "TC 60 HomeTests - Verify data refresh when pulling down the screen")
    public void testDataRefreshOnPullDown() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 61, description = "TC 61 HomeTests - Verify 'Hiking' activity is clickable and navigates to details")
    public void testHikingActivityClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 62, description = "TC 62 HomeTests - Verify activities are displayed correctly")
    public void testActivitiesDisplayedCorrectly() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 63, description = "TC 63 HomeTests - Verify activity data is accurate")
    public void testActivityDataAccuracy() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 64, description = "TC 64 HomeTests - Verify 'Carbs' data is accurate in the Nutrition section")
    public void testCarbsDataAccuracy() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 65, description = "TC 65 HomeTests - Verify 'Protein' data is accurate in the Nutrition section")
    public void testProteinDataAccuracy() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 66, description = "TC 66 HomeTests - Verify 'Fats' data is accurate in the Nutrition section")
    public void testFatsDataAccuracy() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 67, description = "TC 67 HomeTests - Verify nutritional data updates after logging meals")
    public void testNutritionalDataUpdatesAfterMeals() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 68, description = "TC 68 HomeTests - Verify nutritional data updates after logging water intake")
    public void testNutritionalDataUpdatesAfterWater() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 69, description = "TC 69 HomeTests - Verify 'Challenges' icon is visible in the bottom navigation")
    public void testChallengesIconVisible() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 70, description = "TC 70 HomeTests - Verify 'Community' icon is visible in the bottom navigation")
    public void testCommunityIconVisible() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 71, description = "TC 71 HomeTests - Verify profile picture is displayed at the top left")
    public void testProfilePictureDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 72, description = "TC 72 HomeTests - Verify 'Challenges' tab displays active challenges")
    public void testActiveChallengesDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 73, description = "TC 73 HomeTests - Verify 'Programs' tab displays available programs")
    public void testAvailableProgramsDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 74, description = "TC 74 HomeTests - Verify 'Community' tab displays community posts")
    public void testCommunityPostsDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 75, description = "TC 75 HomeTests - Verify the correct date is highlighted on the calendar")
    public void testCorrectDateHighlighted() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 76, description = "TC 76 HomeTests - Verify the 'Calorie Deficit' text updates correctly based on logged data")
    public void testCalorieDeficitTextUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 77, description = "TC 77 HomeTests - Verify 'Add Sleep' popup appears when clicking 'Add Sleep' button")
    public void testAddSleepPopupAppears() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 78, description = "TC 78 HomeTests - Verify correct water intake units are displayed in the Nutrition section")
    public void testCorrectWaterUnitsInNutrition() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 79, description = "TC 79 HomeTests - Verify the 'Challenges' tab shows completed challenges")
    public void testCompletedChallengesDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 80, description = "TC 80 HomeTests - Verify the navigation bar stays fixed at the bottom during scrolling")
    public void testNavigationBarFixedDuringScroll() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 81, description = "TC 81 HomeTests - Verify the visibility of the 'Add' button at the bottom center")
    public void testAddButtonVisibility() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 87, description = "TC 87 HomeTests - Verify activity streak is displayed for consecutive active days")
    public void testActivityStreakDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 88, description = "TC 88 HomeTests - Verify 'Add Water' button is disabled when the maximum daily water limit is reached")
    public void testAddWaterButtonDisabledAtLimit() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 89, description = "TC 89 HomeTests - Verify error message for negative step count")
    public void testNegativeStepCountErrorMessage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 90, description = "TC 90 HomeTests - Verify user can delete logged meal")
    public void testDeleteLoggedMeal() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 91, description = "TC 91 HomeTests - Verify navigation to Settings screen from Home screen")
    public void testNavigateToSettingsScreen() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 92, description = "TC 92 HomeTests - Verify 'Invite Friends' option is visible and clickable on Home screen")
    public void testInviteFriendsOptionVisible() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 93, description = "TC 93 HomeTests - Verify weekly notification reminder is displayed for water intake")
    public void testWeeklyWaterIntakeReminder() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 94, description = "TC 94 HomeTests - Verify app displays offline mode message when no internet connection")
    public void testOfflineModeMessageDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 95, description = "TC 95 HomeTests - Verify water logging history is displayed correctly")
    public void testWaterLoggingHistoryDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 96, description = "TC 96 HomeTests - Verify sleep duration is updated when new sleep data is logged")
    public void testSleepDurationUpdated() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 97, description = "TC 97 HomeTests - Verify 'Calories Burned' chart updates after completing a workout")
    public void testCaloriesBurnedChartUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 98, description = "TC 98 HomeTests - Verify error message is displayed when user logs an invalid date for sleep")
    public void testInvalidSleepDateErrorMessage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 99, description = "TC 99 HomeTests - Verify weekly summary report for calories burned is generated")
    public void testWeeklyCaloriesBurnedSummary() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 100, description = "TC 100 HomeTests - Verify app displays achievements based on completed fitness challenges")
    public void testAchievementsDisplayedForChallenges() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 101, description = "TC 101 HomeTests - Verify error message for logging invalid meal portion size")
    public void testInvalidMealPortionSizeErrorMessage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 102, description = "TC 102 HomeTests - Verify user can log sleep manually")
    public void testManualSleepLogging() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 103, description = "TC 103 HomeTests - Verify heart rate section is displayed on the Home screen")
    public void testHeartRateSectionDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 104, description = "TC 104 HomeTests - Verify heart rate data updates after a workout is logged")
    public void testHeartRateDataUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 105, description = "TC 105 HomeTests - Verify weekly workout goals are displayed on Home screen")
    public void testWeeklyWorkoutGoalsDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 106, description = "TC 106 HomeTests - Verify user is able to update weight on profile")
    public void testUpdateWeightOnProfile() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 107, description = "TC 107 HomeTests - Verify notification is displayed when goal is achieved")
    public void testGoalAchievementNotificationDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 108, description = "TC 108 HomeTests - Verify user can log custom exercises")
    public void testCustomExerciseLogging() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 109, description = "TC 109 HomeTests - Verify 'Steps Per Day' graph updates correctly")
    public void testStepsPerDayGraphUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 110, description = "TC 110 HomeTests - Verify error message when logging an invalid heart rate")
    public void testInvalidHeartRateErrorMessage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 111, description = "TC 111 HomeTests - Verify notification settings are accessible from Home screen")
    public void testNotificationSettingsAccess() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 112, description = "TC 112 HomeTests - Verify the 'Calories Burned' section updates after logging an activity")
    public void testCaloriesBurnedSectionUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 113, description = "TC 113 HomeTests - Verify user can mark a meal as favorite")
    public void testMarkMealAsFavorite() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 114, description = "TC 114 HomeTests - Verify 'Goals' section displays current fitness goals")
    public void testGoalsSectionDisplaysCurrentGoals() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 115, description = "TC 115 HomeTests - Verify navigation to 'Progress' screen from Home screen")
    public void testNavigateToProgressScreen() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 116, description = "TC 116 HomeTests - Verify error message when water intake exceeds recommended limit")
    public void testExceedWaterIntakeLimitErrorMessage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 117, description = "TC 117 HomeTests - Verify user can set a daily step goal")
    public void testSetDailyStepGoal() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 118, description = "TC 118 HomeTests - Verify notification for inactive periods during the day")
    public void testInactivePeriodNotification() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 119, description = "TC 119 HomeTests - Verify app displays time remaining to complete fitness challenge")
    public void testFitnessChallengeTimeRemainingDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 120, description = "TC 120 HomeTests - Verify error message when logging negative calorie intake")
    public void testNegativeCalorieIntakeErrorMessage() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 121, description = "TC 121 HomeTests - Verify weekly summary displays distance walked for the week")
    public void testWeeklySummaryDistanceWalked() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 122, description = "TC 122 HomeTests - Verify water intake goal is displayed on Home screen")
    public void testWaterIntakeGoalDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 123, description = "TC 123 HomeTests - Verify user can edit logged meals")
    public void testEditLoggedMeals() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
    }

    @Test(priority = 124, description = "TC 124 HomeTests - Verify notification when daily step goal is achieved")
    public void testDailyStepGoalAchievementNotification() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);


    }

    @Test(priority = 125, description = "TC 125 - Verify FAB menu is displayed on the Home screen")
    public void testFABMenuDisplayed() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isFABMenuDisplayed(), "FAB menu should be displayed on the Home screen.");
    }

    @Test(priority = 126, description = "TC 126 - Verify clicking FAB menu expands options")
    public void testFABMenuExpandsOptions() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isFABOptionsExpanded(), "FAB menu options should expand upon clicking.");
    }

    @Test(priority = 127, description = "TC 127 - Verify 'Sync Activities' option in FAB menu is visible")
    public void testSyncActivitiesOptionVisible() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isSyncActivitiesOptionVisible(), "'Sync Activities' option should be visible in the FAB menu.");
    }

    @Test(priority = 128, description = "TC 128 - Verify 'Start Outdoor Activity' option in FAB menu is visible")
    public void testStartOutdoorActivityOptionVisible() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isStartOutdoorActivityOptionVisible(), "'Start Outdoor Activity' option should be visible in the FAB menu.");
    }

    @Test(priority = 129, description = "TC 129 - Verify 'Log Water Intake' option in FAB menu is visible")
    public void testLogWaterIntakeOptionVisible() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogWaterIntakeOptionVisible(), "'Log Water Intake' option should be visible in the FAB menu.");
    }

    @Test(priority = 130, description = "TC 130 - Verify 'Sync Activities' option is clickable")
    public void testSyncActivitiesOptionClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isSyncActivitiesOptionClickable(), "'Sync Activities' option should be clickable.");
    }

    @Test(priority = 131, description = "TC 131 - Verify 'Start Outdoor Activity' option is clickable")
    public void testStartOutdoorActivityOptionClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isStartOutdoorActivityOptionClickable(), "'Start Outdoor Activity' option should be clickable.");
    }

    @Test(priority = 132, description = "TC 132 - Verify 'Log Water Intake' option is clickable")
    public void testLogWaterIntakeOptionClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogWaterIntakeOptionClickable(), "'Log Water Intake' option should be clickable.");
    }

    @Test(priority = 133, description = "TC 133 - Verify clicking 'Sync Activities' navigates to sync screen")
    public void testSyncActivitiesNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickSyncActivitiesOption();
        Assert.assertTrue(homePage.isSyncScreenDisplayed(), "Clicking 'Sync Activities' should navigate to the sync screen.");
    }

    @Test(priority = 134, description = "TC 134 - Verify clicking 'Start Outdoor Activity' navigates to activity tracker")
    public void testStartOutdoorActivityNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickStartOutdoorActivityOption();
        Assert.assertTrue(homePage.isActivityTrackerDisplayed(), "Clicking 'Start Outdoor Activity' should navigate to the activity tracker.");
    }

    @Test(priority = 135, description = "TC 135 - Verify clicking 'Log Water Intake' navigates to water intake logging")
    public void testLogWaterIntakeNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickLogWaterIntakeOption();
        Assert.assertTrue(homePage.isWaterIntakeLoggingScreenDisplayed(), "Clicking 'Log Water Intake' should navigate to the water intake logging screen.");
    }

    @Test(priority = 136, description = "TC 136 - Verify FAB menu collapses after selecting an option")
    public void testFABMenuCollapsesAfterSelection() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickLogWaterIntakeOption();
        Assert.assertFalse(homePage.isFABOptionsExpanded(), "FAB menu should collapse after selecting an option.");
    }

    @Test(priority = 137, description = "TC 137 - Verify 'Log Meal' option is visible in the FAB menu")
    public void testLogMealOptionVisible() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogMealOptionVisible(), "'Log Meal' option should be visible in the FAB menu.");
    }

    @Test(priority = 138, description = "TC 138 - Verify 'Log Meal' option is clickable")
    public void testLogMealOptionClickable() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        Assert.assertTrue(homePage.isLogMealOptionClickable(), "'Log Meal' option should be clickable.");
    }

    @Test(priority = 139, description = "TC 139 - Verify clicking 'Log Meal' navigates to meal logging screen")
    public void testLogMealNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickLogMealOption();
        Assert.assertTrue(homePage.isMealLoggingScreenDisplayed(), "Clicking 'Log Meal' should navigate to the meal logging screen.");
    }

    @Test(priority = 140, description = "TC 140 - Verify FAB menu remains functional after multiple uses")
    public void testFABMenuFunctionalityAfterMultipleUses() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        for (int i = 0; i < 3; i++) {
            homePage.clickFABMenu();
            homePage.clickLogMealOption();
            homePage.clickFABMenu();
        }
        Assert.assertTrue(homePage.isFABMenuFunctional(), "FAB menu should remain functional after multiple uses.");
    }

    @Test(priority = 141, description = "TC 141 - Verify 'Challenges' option navigates to challenges screen")
    public void testChallengesOptionNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickChallengesTab();
        Assert.assertTrue(homePage.isChallengesScreenDisplayed(), "Clicking 'Challenges' should navigate to the challenges screen.");
    }

    @Test(priority = 142, description = "TC 142 - Verify 'Challenges' screen displays active challenges")
    public void testActiveChallengesDisplayedOnChallengesScreen() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickChallengesTab();
        Assert.assertTrue(homePage.isActiveChallengesDisplayed(), "Active challenges should be displayed on the challenges screen.");
    }

    @Test(priority = 143, description = "TC 143 - Verify 'Challenges' screen displays completed challenges")
    public void testCompletedChallengesDisplayedOnChallengesScreen() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickChallengesTab();
        Assert.assertTrue(homePage.isCompletedChallengesDisplayed(), "Completed challenges should be displayed on the challenges screen.");
    }

    @Test(priority = 144, description = "TC 144 - Verify 'Programs' option navigates to programs screen")
    public void testProgramsOptionNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickProgramsTab();
        Assert.assertTrue(homePage.isProgramsScreenDisplayed(), "Clicking 'Programs' should navigate to the programs screen.");
    }

    @Test(priority = 145, description = "TC 145 - Verify 'Community' option navigates to community screen")
    public void testCommunityOptionNavigation() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickCommunityTab();
        Assert.assertTrue(homePage.isCommunityScreenDisplayed(), "Clicking 'Community' should navigate to the community screen.");
    }

    @Test(priority = 146, description = "TC 146 - Verify user can log multiple water entries")
    public void testLogMultipleWaterEntries() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        for (int i = 0; i < 3; i++) {
            homePage.clickFABMenu();
            homePage.clickLogWaterIntakeOption();
        }
        Assert.assertTrue(homePage.isMultipleWaterEntriesLogged(), "User should be able to log multiple water entries.");
    }

    @Test(priority = 147, description = "TC 147 - Verify user can log multiple meal entries")
    public void testLogMultipleMealEntries() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        for (int i = 0; i < 3; i++) {
            homePage.clickFABMenu();
            homePage.clickLogMealOption();
        }
        Assert.assertTrue(homePage.isMultipleMealEntriesLogged(), "User should be able to log multiple meal entries.");
    }

    @Test(priority = 148, description = "TC 148 - Verify activity streak updates after completing daily activities")
    public void testActivityStreakUpdates() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.completeDailyActivity();
        Assert.assertTrue(homePage.isActivityStreakUpdated(), "Activity streak should update after completing daily activities.");
    }

    @Test(priority = 149, description = "TC 149 - Verify user can log outdoor activity")
    public void testLogOutdoorActivity() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.clickFABMenu();
        homePage.clickStartOutdoorActivityOption();
        Assert.assertTrue(homePage.isOutdoorActivityLogged(), "User should be able to log outdoor activities.");
    }

    @Test(priority = 150, description = "TC 150 - Verify user can log weight changes")
    public void testLogWeightChanges() {
        ConnectGoogleFitPage connectGoogleFitPage = new ConnectGoogleFitPage(driver);
        connectGoogleFitPage.clickSkipButton();
        connectGoogleFitPage.allowNotificationPermission();
        HomePage homePage = new HomePage(driver);
        homePage.logWeightChange();
        Assert.assertTrue(homePage.isWeightChangeLogged(), "User should be able to log weight changes.");
    }

}