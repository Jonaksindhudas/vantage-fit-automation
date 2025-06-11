package org.vantagefit.pageObjects.android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vantagefit.testUtils.AndroidBaseTest;
import java.time.Duration;

public class AddHealthManuallyPages extends AndroidBaseTest {

    AndroidDriver driver;
    private WebDriverWait wait;

    public AddHealthManuallyPages(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Element for the Birthday Dropdown
    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/dobDateTextView")
    private WebElement birthdayDropdown;

    // Element for the Date Picker 'Okay' button
    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/confirm_button")
    private WebElement datePickerOkayButton;
    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/dobDateTextView")
    private WebElement dobDateTextView;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/confirm_button")
    private WebElement confirmButton;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/month_navigation_previous")
    private WebElement previousMonthButton;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/month_navigation_next")
    private WebElement nextMonthButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='January 1996']")
    private WebElement january1996;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2']")
    private WebElement day2;

    // Elements for the Gender Selection
    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/cardMale")
    private WebElement maleGenderCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/cardFemale")
    private WebElement femaleGenderCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/cardOthers")
    private WebElement othersGenderCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/cardNotSpecified")
    private WebElement notSpecifiedGenderCard;

    // Select Weight Elements
    @AndroidFindBy(xpath = "//*[@resource-id='com.bargaintechnologies.vantagefit.v_fit:id/weightValue']")
    private WebElement weightField;

    @AndroidFindBy(xpath = "//*[@resource-id='com.bargaintechnologies.vantagefit.v_fit:id/weightSlider']")
    private WebElement weightSlider;

    // Select Height Elements
    @AndroidFindBy(xpath = "//*[@resource-id='com.bargaintechnologies.vantagefit.v_fit:id/heightValue']")
    private WebElement heightField;

    @AndroidFindBy(xpath = "//*[@resource-id='com.bargaintechnologies.vantagefit.v_fit:id/heightSlider']")
    private WebElement heightSlider;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/dobDateTextView")
    private WebElement birthdayField;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/next")
    private WebElement nextButton;

    @AndroidFindBy(xpath = "//*[@text='Select Height']")
    private WebElement heightPageTitle;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_height_cm_unit")
    private WebElement heightUnitInch;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_height_ft")
    private WebElement heightUnitFeet;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_height_cm")
    private WebElement heightInput;

    @AndroidFindBy(xpath = "//*[@text='Select Weight']")
    private WebElement weightPageTitle;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_weight_cm_unit")
    private WebElement weightUnitLbs;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_weight_lbs")
    private WebElement weightUnitKg;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_weight_kg")
    private WebElement weightInput;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_bmiScore")
    private WebElement bmiScreen;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/currentWeightText")
    private WebElement currentWeightText;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_bmiScore")
    private WebElement bmiScore;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/tv_bmi_status")
    private WebElement bmiStatus;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/idealWeightRange")
    private WebElement idealWeightRange;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/seekbarId")
    private WebElement seekbar;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/loseWeightCard")
    private WebElement loseWeightCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/reduceFatCard")
    private WebElement reduceBellyFatCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/gainMuscleCard")
    private WebElement gainMuscleCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/beFitterCard")
    private WebElement beFitterCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/title")
    private WebElement chooseObjectivePageTitle;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/checkedCard1")
    private WebElement notVeryActiveCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/checkedCard2")
    private WebElement slightlyActiveCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/checkedCard3")
    private WebElement moderatelyActiveCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/checkedCard4")
    private WebElement veryActiveCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"How active are you?\"]")
    private WebElement howActivePageTitle;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/start")
    private WebElement letsStartbutton;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/calorieTragetId")
    private WebElement dailyCalorieTargetTitle;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/idealCalorieAmountId")
    private WebElement calorieAmount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='calories']")
    private WebElement caloriesUnit;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/continueButton")
    private WebElement continueButton;

    // Methods to interact with the elements
    public void setBirthday(String date) {
        birthdayField.click();
        // Add logic to select date from date picker if necessary
    }

    // Methods for interactions
    public void clickBirthdayDropdown() {
        waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/dobDateTextView")).click();
    }

    public boolean isDatePickerDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/confirm_button"));
    }

    public void selectDateFromDatePicker() {
        waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/confirm_button")).click();
    }

    public void selectMaleGender() {
        waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/cardMale")).click();
    }

    public void selectFemaleGender() {
        waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/cardFemale")).click();
    }

    public void selectOthersGender() {
        waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/cardOthers")).click();
    }

    public void selectNotSpecifiedGender() {
        waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/cardNotSpecified")).click();
    }

    // Method to verify if elements are displayed
    public boolean isBirthdayDropdownDisplayed() {
        return birthdayDropdown.isDisplayed();
    }

    public boolean isMaleGenderSelected() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/cardMale"));
    }

    public boolean isFemaleGenderSelected() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/cardFemale"));
    }

    public boolean isOthersGenderSelected() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/cardOthers"));
    }

    public boolean isNotSpecifiedGenderSelected() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/cardNotSpecified"));
    }
    public void setWeight(int weight) {
        // Add logic to interact with weight slider
        weightField.sendKeys(String.valueOf(weight));
    }

    public void setHeight(int height) {
        // Add logic to interact with height slider
        heightField.sendKeys(String.valueOf(height));
    }

    // Methods to verify elements are displayed
    public boolean isBirthdayFieldDisplayed() {
        return birthdayField.isDisplayed();
    }

    public boolean isWeightFieldDisplayed() {
        return weightField.isDisplayed();
    }

    public boolean isHeightFieldDisplayed() {
        return heightField.isDisplayed();
    }


    public boolean isSelectBirthdayDisplayed() {
        return dobDateTextView.isDisplayed();
    }
    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    public boolean isHeightPageDisplayed() {
        return waitForElementToBeVisible(By.xpath("//*[@text='Select Height']"));
    }

    public boolean isHeightUnitInchDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/tv_height_cm_unit"));
    }

    public boolean isHeightUnitFeetDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/tv_height_ft"));
    }

    public void setHeight(double height) {
        heightInput.clear();
        heightInput.sendKeys(String.valueOf(height));
    }

    public double getHeight() {
        return Double.parseDouble(heightInput.getText());
    }

    public boolean isWeightPageDisplayed() {
        return waitForElementToBeVisible(By.xpath("//*[@text='Select Weight']"));
    }

    public boolean isWeightUnitLbsDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/tv_weight_cm_unit"));
    }

    public boolean isWeightUnitKgDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/tv_weight_lbs"));
    }

    public boolean isBMIScreenDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/tv_bmiScore"));
    }

    public String getDisplayedWeightOnBMIScreen() {
        return waitForElement(By.id("com.bargaintechnologies.vantagefit.v_fit:id/currentWeightText")).getText();
    }

    public String getBMIScore() {
        return waitForElement(By.id("com.bargaintechnologies.vantagefit.v_fit:id/tv_bmiScore")).getText();
    }

    public String getBMIStatus() {
        return waitForElement(By.id("com.bargaintechnologies.vantagefit.v_fit:id/tv_bmi_status")).getText();
    }

    public boolean isIdealWeightRangeDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/idealWeightRange"));
    }

    public boolean isSeekbarDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/seekbarId"));
    }

    public boolean isChooseObjectivePageDisplayed() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/title"));
    }

    public boolean isLoseWeightCardEnabled() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/loseWeightCard"));
    }

    public boolean isReduceBellyFatCardEnabled() {
        return reduceBellyFatCard.isEnabled();
    }

    public boolean isGainMuscleCardEnabled() {
        return gainMuscleCard.isEnabled();
    }

    public boolean isBeFitterCardEnabled() {
        return beFitterCard.isEnabled();
    }

    public void clickLoseWeightCard() {
        waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/loseWeightCard")).click();
    }

    public boolean isLoseWeightCardSelected() {
        return waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/loseWeightCard"));
    }

    public void clickReduceBellyFatCard() {
        reduceBellyFatCard.click();
    }

    public boolean isReduceBellyFatCardSelected() {
        return reduceBellyFatCard.getAttribute("checked").equals("true");
    }

    public void clickGainMuscleCard() {
        gainMuscleCard.click();
    }

    public boolean isGainMuscleCardSelected() {
        return gainMuscleCard.getAttribute("checked").equals("true");
    }

    public void clickBeFitterCard() {
        beFitterCard.click();
    }

    public boolean isBeFitterCardSelected() {
        return beFitterCard.getAttribute("checked").equals("true");
    }

    public boolean isHowActivePageDisplayed() {
        return howActivePageTitle.isDisplayed();
    }

    public boolean isNotVeryActiveCardEnabled() {
        return notVeryActiveCard.isEnabled();
    }

    public boolean isSlightlyActiveCardEnabled() {
        return slightlyActiveCard.isEnabled();
    }

    public boolean isModeratelyActiveCardEnabled() {
        return moderatelyActiveCard.isEnabled();
    }

    public boolean isVeryActiveCardEnabled() {
        return veryActiveCard.isEnabled();
    }

    public void clickNotVeryActiveCard() {
        notVeryActiveCard.click();
    }

    public boolean isNotVeryActiveCardSelected() {
        return notVeryActiveCard.getAttribute("checked").equals("true");
    }

    public void clickSlightlyActiveCard() {
        slightlyActiveCard.click();
    }

    public boolean isSlightlyActiveCardSelected() {
        return slightlyActiveCard.getAttribute("checked").equals("true");
    }

    public void clickModeratelyActiveCard() {
        moderatelyActiveCard.click();
    }

    public boolean isModeratelyActiveCardSelected() {
        return moderatelyActiveCard.getAttribute("checked").equals("true");
    }

    public void clickVeryActiveCard() {
        veryActiveCard.click();
    }

    public boolean isVeryActiveCardSelected() {
        return veryActiveCard.getAttribute("checked").equals("true");
    }

    public void clickLetsStartButton() {
        letsStartbutton.click();
    }

    public boolean isDailyCalorieTargetPageDisplayed() {
        return dailyCalorieTargetTitle.isDisplayed();
    }

    public boolean isDailyCalorieTargetTitleDisplayed() {
        return dailyCalorieTargetTitle.isDisplayed();
    }

    public boolean isCaloriesUnitDisplayed() {
        return caloriesUnit.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public ConnectGoogleFitPage navigateToConnectGoogleFitPage() {
        waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/continueButton")).click();
        return new ConnectGoogleFitPage(driver);
    }


}
