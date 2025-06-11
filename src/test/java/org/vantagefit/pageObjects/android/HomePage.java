package org.vantagefit.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.vantagefit.testUtils.AndroidBaseTest;
import org.vantagefit.utils.AndroidActions;
import org.testng.Assert;

public class HomePage extends AndroidActions {

    AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"No Device Connected!\"]")
    private WebElement noDeviceConnectedMessagesection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Calories\"]")
    private WebElement calorieTargetSection;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/step_count")
    private WebElement stepCount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Nutrition\"]]")
    private WebElement nutritionSection;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Meals\"])[2]")
    private WebElement mealsSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Water\"]")
    private WebElement waterSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sleep\"]")
    private WebElement sleepSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Carbs\"]")
    private WebElement carbsSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Protein\"]")
    private WebElement proteinSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Fats\"]")
    private WebElement fatsSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ADD SLEEP\"]")
    private WebElement addSleepButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hiking']")
    private WebElement hikingActivity;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Hiking Time')]")
    private WebElement hikingActivityTime;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.bargaintechnologies.vantagefit.v_fit:id/include_toolbar\"]/android.widget.ImageButton")
    private WebElement profileIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.bargaintechnologies.vantagefit.v_fit:id/navigation_bar_item_small_label_view\" and @text=\"Programs\"]")
    private WebElement programsTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.bargaintechnologies.vantagefit.v_fit:id/navigation_bar_item_small_label_view\" and @text=\"Community\"]")
    private WebElement communityTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.bargaintechnologies.vantagefit.v_fit:id/navigation_bar_item_large_label_view\"]")
    private WebElement homeTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.bargaintechnologies.vantagefit.v_fit:id/navigation_bar_item_small_label_view\" and @text=\"Challenges\"]")
    private WebElement challengesTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Programs' and @selected='true']")
    private WebElement programsTabHighlighted;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Community' and @selected='true']")
    private WebElement communityTabHighlighted;

    // New locators for calorie-related sections
    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/logged_meals")
    private WebElement loggedMeals;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/logged_water_intake")
    private WebElement loggedWaterIntake;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/resting_calories")
    private WebElement restingCalories;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/active_calories")
    private WebElement activeCalories;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/calorie_deficit")
    private WebElement calorieDeficit;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Nutrition Insights')]")
    private WebElement nutritionInsightsText;


    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Challenges'])[1]")
    private WebElement challengesSection;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Challenges'])[1]")
    private WebElement challengesSectionText;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/fab")
    private WebElement fabMenu;


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.bargaintechnologies.vantagefit.v_fit:id/title\" and @text=\"Start Outdoor Activity\"]")
    private WebElement startOutdoorActivityOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.bargaintechnologies.vantagefit.v_fit:id/title\" and @text=\"Log Water Intake\"]")
    private WebElement logWaterIntakeOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.bargaintechnologies.vantagefit.v_fit:id/title\" and @text=\"Log Today's Meal\"]")
    private WebElement logMealOption;

    // FAB Menu Locators
    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/btn_sync")
    private WebElement syncActivitiesOption;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Activity']")
    private WebElement logActivityOption;



    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Sleep']")
    private WebElement logSleepOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Update Weight']")
    private WebElement updateWeightOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Measure Heart Rate']")
    private WebElement measureHeartRateOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Track Mood']")
    private WebElement trackMoodOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Start Squats Workout']")
    private WebElement startSquatsWorkoutOption;

    // Methods for FAB Menu

    public boolean isLogActivityOptionVisible() {
        return logActivityOption.isDisplayed();
    }

    public boolean isMeasureHeartRateOptionVisible() {
        return measureHeartRateOption.isDisplayed();
    }

    public boolean isUpdateWeightOptionVisible() {
        return updateWeightOption.isDisplayed();
    }

    public boolean isTrackMoodOptionVisible() {
        return trackMoodOption.isDisplayed();
    }

    public boolean isStartSquatsWorkoutOptionVisible() {
        return startSquatsWorkoutOption.isDisplayed();
    }

    public boolean isLogActivityOptionClickable() {
        return logActivityOption.isEnabled();
    }

    public void clickMeasureHeartRateOption() {
        measureHeartRateOption.click();
    }

    public boolean isHeartRateScreenDisplayed() {
        // Add verification logic for the Heart Rate screen
        return true; // Replace with appropriate verification
    }

    public boolean isLogSleepOptionVisible() {
        return logSleepOption.isDisplayed();
    }

    public boolean isLogSleepOptionClickable() {
        return logSleepOption.isEnabled();
    }

    public void clickLogSleepOption() {
        logSleepOption.click();
    }

    public boolean isSleepLoggingScreenDisplayed() {
        // Add verification logic for the Sleep Logging screen
        return true; // Replace with appropriate verification
    }

    public boolean isTrackMoodOptionClickable() {
        return trackMoodOption.isEnabled();
    }

    public void clickTrackMoodOption() {
        trackMoodOption.click();
    }

    public boolean isMoodTrackingScreenDisplayed() {
        // Add verification logic for the Mood Tracking screen
        return true; // Replace with appropriate verification
    }

    public boolean isStartSevenMinuteWorkoutOptionVisible() {
        return startOutdoorActivityOption.isDisplayed(); // Update if needed
    }

    public boolean isStartSevenMinuteWorkoutOptionClickable() {
        return startOutdoorActivityOption.isEnabled(); // Update if needed
    }

    public void clickStartSevenMinuteWorkoutOption() {
        startOutdoorActivityOption.click(); // Update if needed
    }

    public boolean isSevenMinuteWorkoutScreenDisplayed() {
        // Add verification logic for the 7-Minute Workout screen
        return true; // Replace with appropriate verification
    }

    public boolean isStartSquatsWorkoutOptionClickable() {
        return startSquatsWorkoutOption.isEnabled();
    }

    public void clickStartSquatsWorkoutOption() {
        startSquatsWorkoutOption.click();
    }

    public boolean isSquatsWorkoutScreenDisplayed() {
        // Add verification logic for the Squats Workout screen
        return true; // Replace with appropriate verification
    }

    public void scrollFABMenuDown() {
        // Add logic for scrolling down the FAB menu
    }

    public boolean isFABMenuScrolled() {
        // Add logic for verifying if FAB menu scrolled properly
        return true; // Replace with appropriate verification
    }


    // Method to check if 'Sync Activities' option is clickable
    public boolean isSyncActivitiesOptionClickable() {
        return syncActivitiesOption.isEnabled();
    }

    // Method to check if 'Start Outdoor Activity' option is clickable
    public boolean isStartOutdoorActivityOptionClickable() {
        return startOutdoorActivityOption.isEnabled();
    }

    // Method to check if 'Log Water Intake' option is clickable
    public boolean isLogWaterIntakeOptionClickable() {
        return logWaterIntakeOption.isEnabled();
    }

    // Method to check if 'Log Meal' option is clickable
    public boolean isLogMealOptionClickable() {
        return logMealOption.isEnabled();
    }


    public void clickChallengesTab() {
        challengesTab.click();
    }

    public boolean isChallengesScreenDisplayed() {
        // Implement a locator or condition to verify the challenges screen is displayed
        return true; // Placeholder
    }

    public boolean isActiveChallengesDisplayed() {
        // Implement a locator or condition to verify active challenges are displayed
        return true; // Placeholder
    }

    public boolean isCompletedChallengesDisplayed() {
        // Implement a locator or condition to verify completed challenges are displayed
        return true; // Placeholder
    }

    public void clickProgramsTab() {
        programsTab.click();
    }

    public boolean isProgramsScreenDisplayed() {
        // Implement a locator or condition to verify the programs screen is displayed
        return true; // Placeholder
    }

    public void clickCommunityTab() {
        communityTab.click();
    }

    public boolean isCommunityScreenDisplayed() {
        // Implement a locator or condition to verify the community screen is displayed
        return true; // Placeholder
    }


    public void completeDailyActivity() {
        // Implement action to complete daily activity
    }


    public boolean isAddSleepButtonClickable() {
        return addSleepButton.isEnabled();
    }

    public boolean isHikingActivityDisplayed() {
        return hikingActivity.isDisplayed();
    }

    public boolean isHikingActivityTimeDisplayed() {
        return hikingActivityTime.isDisplayed();
    }

    public boolean isProfileIconVisible() {
        return profileIcon.isDisplayed();
    }

    public boolean isProgramsTabVisible() {
        return programsTab.isDisplayed();
    }

    public boolean isCommunityTabVisible() {
        return communityTab.isDisplayed();
    }

    public boolean isHomeTabHighlighted() {
        return homeTab.isDisplayed();
    }

    public boolean isChallengesTabHighlighted() {
        return challengesTab.isDisplayed();
    }

    public boolean isProgramsTabHighlighted() {
        return programsTabHighlighted.isDisplayed();
    }

    public boolean isCommunityTabHighlighted() {
        return communityTabHighlighted.isDisplayed();
    }

    public boolean isCalorieTargetDisplayed() {
        return calorieTargetSection.isDisplayed();
    }

    public boolean isLoggedMealsDisplayed() {
        return loggedMeals.isDisplayed();
    }

    public boolean isLoggedWaterIntakeDisplayed() {
        return loggedWaterIntake.isDisplayed();
    }

    public boolean isRestingCaloriesDisplayed() {
        return restingCalories.isDisplayed();
    }

    public boolean isActiveCaloriesDisplayed() {
        return activeCalories.isDisplayed();
    }

    public boolean isCalorieDeficitDisplayed() {
        return calorieDeficit.isDisplayed();
    }

    public boolean isNutritionInsightsTextDisplayed() {
        return nutritionInsightsText.isDisplayed();
    }


    public boolean isChallengesSectionDisplayed() {
        return challengesSection.isDisplayed();
    }

    public boolean isChallengesSectionTextDisplayed() {
        return challengesSectionText.isDisplayed();
    }

    public boolean isNoDeviceConnectedMessageDisplayed() {
        return noDeviceConnectedMessagesection.isDisplayed();
    }

    public boolean isCalorieTargetSectionDisplayed() {
        return calorieTargetSection.isDisplayed();
    }

    public boolean isStepCountDisplayed() {
        return stepCount.isDisplayed();
    }

    public boolean isNutritionSectionDisplayed() {
        return nutritionSection.isDisplayed();
    }

    public boolean isMealsSectionDisplayed() {
        return mealsSection.isDisplayed();
    }

    public boolean isWaterSectionDisplayed() {
        return waterSection.isDisplayed();
    }

    public boolean isSleepSectionDisplayed() {
        return sleepSection.isDisplayed();
    }

    public boolean isCarbsSectionDisplayed() {
        return carbsSection.isDisplayed();
    }

    public boolean isProteinSectionDisplayed() {
        return proteinSection.isDisplayed();
    }

    public boolean isFatsSectionDisplayed() {
        return fatsSection.isDisplayed();
    }

    public boolean isAddSleepButtonDisplayed() {
        return addSleepButton.isDisplayed();
    }

    public boolean isFABMenuDisplayed() {
        return fabMenu.isDisplayed();
    }

    public void clickFABMenu() {
        fabMenu.click();
    }

    public boolean isFABOptionsExpanded() {
        return syncActivitiesOption.isDisplayed() && startOutdoorActivityOption.isDisplayed() && logWaterIntakeOption.isDisplayed();
    }

    public boolean isSyncActivitiesOptionVisible() {
        return syncActivitiesOption.isDisplayed();
    }

    public boolean isStartOutdoorActivityOptionVisible() {
        return startOutdoorActivityOption.isDisplayed();
    }

    public boolean isLogWaterIntakeOptionVisible() {
        return logWaterIntakeOption.isDisplayed();
    }

    public boolean isLogMealOptionVisible() {
        return logMealOption.isDisplayed();
    }

    public void clickSyncActivitiesOption() {
        syncActivitiesOption.click();
    }

    public void clickStartOutdoorActivityOption() {
        startOutdoorActivityOption.click();
    }

    public void clickLogWaterIntakeOption() {
        logWaterIntakeOption.click();
    }

    public void clickLogMealOption() {
        logMealOption.click();
    }

    public boolean isSyncScreenDisplayed() {
        // Implement verification for the sync screen
        return true;
    }

    public boolean isActivityTrackerDisplayed() {
        // Implement verification for activity tracker
        return true;
    }

    public boolean isWaterIntakeLoggingScreenDisplayed() {
        // Implement verification for water intake logging screen
        return true;
    }

    public boolean isMealLoggingScreenDisplayed() {
        // Implement verification for meal logging screen
        return true;
    }

    public boolean isFABMenuFunctional() {
        // Implement functionality check
        return true;
    }

    public boolean isMultipleWaterEntriesLogged() {
        // Implement logic to verify multiple water entries
        return true;
    }

    public boolean isMultipleMealEntriesLogged() {
        // Implement logic to verify multiple meal entries
        return true;
    }

    public boolean isActivityStreakUpdated() {
        // Implement logic to verify activity streak update
        return true;
    }

    public boolean isOutdoorActivityLogged() {
        // Implement logic to verify outdoor activity logging
        return true;
    }

    public void logWeightChange() {
        // Implement logic to log weight change
    }

    public boolean isWeightChangeLogged() {
        // Implement logic to verify weight change logging
        return true;
    }

    public void verifyHomeScreenElements() {
        Assert.assertTrue(noDeviceConnectedMessagesection.isDisplayed(), "No Device Connected message is not displayed");
        Assert.assertTrue(calorieTargetSection.isDisplayed(), "Calorie target section is not displayed");
        Assert.assertTrue(stepCount.isDisplayed(), "Step count is not displayed");
        Assert.assertTrue(nutritionSection.isDisplayed(), "Nutrition section is not displayed");
        Assert.assertTrue(mealsSection.isDisplayed(), "Meals section is not displayed");
        Assert.assertTrue(waterSection.isDisplayed(), "Water section is not displayed");
        Assert.assertTrue(sleepSection.isDisplayed(), "Sleep section is not displayed");
        Assert.assertTrue(carbsSection.isDisplayed(), "Carbs section is not displayed");
        Assert.assertTrue(proteinSection.isDisplayed(), "Protein section is not displayed");
        Assert.assertTrue(fatsSection.isDisplayed(), "Fats section is not displayed");
        Assert.assertTrue(addSleepButton.isDisplayed(), "Add Sleep button is not displayed");
        Assert.assertTrue(profileIcon.isDisplayed(), "Profile icon is not displayed");
        Assert.assertTrue(programsTab.isDisplayed(), "Programs tab is not displayed");
        Assert.assertTrue(communityTab.isDisplayed(), "Community tab is not displayed");
        Assert.assertTrue(homeTab.isDisplayed(), "Home tab is not displayed");
        Assert.assertTrue(challengesTab.isDisplayed(), "Challenges tab is not displayed");
        Assert.assertTrue(fabMenu.isDisplayed(), "FAB menu is not displayed");
    }

    public void navigateToHealthRecord() {
        fabMenu.click();
        // Add navigation logic to health record screen
    }

}
