package org.vantagefit.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HealthRecordPage {

    AndroidDriver driver;

    public HealthRecordPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/healthRecordTitleId")
    private WebElement healthRecordTitle;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/healthRecordDetailsId")
    private WebElement healthRecordDetails;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/ageCardViewId")
    private WebElement ageCardView;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/genderCardViewId")
    private WebElement genderCardView;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/heightCardViewId")
    private WebElement heightCardView;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/weightCardViewId")
    private WebElement weightCardView;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/saveChangesButtonId")
    private WebElement continueButton;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/importCardViewId")
    private WebElement importCardView;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/manualCardViewId")
    private WebElement manualCardView;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/importCardViewId")
    private WebElement importFromGoogleFitCard;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/manualCardViewId")
    private WebElement addDataManuallyCard;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement allowLocationButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowPhysicalActivityButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"headingText\"]")
    private WebElement signInText;

    public void verifyHealthRecordElements() {
        Assert.assertTrue(healthRecordTitle.isDisplayed(), "Health Record title is not displayed");
        Assert.assertTrue(healthRecordDetails.isDisplayed(), "Health Record details are not displayed");
        Assert.assertTrue(ageCardView.isDisplayed(), "Age card view is not displayed");
        Assert.assertTrue(genderCardView.isDisplayed(), "Gender card view is not displayed");
        Assert.assertTrue(heightCardView.isDisplayed(), "Height card view is not displayed");
        Assert.assertTrue(weightCardView.isDisplayed(), "Weight card view is not displayed");
        Assert.assertTrue(continueButton.isDisplayed(), "Continue button is not displayed");
        Assert.assertTrue(importCardView.isDisplayed(), "Import card view is not displayed");
        Assert.assertTrue(manualCardView.isDisplayed(), "Manual card view is not displayed");
    }

    public boolean isDisplayed() {
        return healthRecordTitle.isDisplayed();
    }

    public String getHealthRecordTitle() {
        return healthRecordTitle.getText();
    }

    public String getHealthRecordDetails() {
        return healthRecordDetails.getText();
    }

    public void clickContinue()
    {
        continueButton.click();
    }

    public boolean isAgeCardViewClickable() {
        return ageCardView.getAttribute("clickable").equals("false");
    }

    public boolean isGenderCardViewClickable() {
        return genderCardView.getAttribute("clickable").equals("false");
    }

    public boolean isHeightCardViewClickable() {
        return heightCardView.getAttribute("clickable").equals("false");
    }

    public boolean isWeightCardViewClickable() {
        return weightCardView.getAttribute("clickable").equals("false");
    }

    public boolean isImportCardViewClickable() {
        return importCardView.getAttribute("clickable").equals("true");
    }

    public boolean isManualCardViewClickable() {
        return manualCardView.getAttribute("clickable").equals("true");
    }

    public void clickImportFromGoogleFit() {
        importFromGoogleFitCard.click();
    }

    public AddHealthManuallyPages clickAddDataManually() {
        addDataManuallyCard.click();
        return new AddHealthManuallyPages(driver);
    }

    public void allowLocationAccess() {
        allowLocationButton.click();
    }

    public void allowPhysicalActivityAccess() {
        allowPhysicalActivityButton.click();
    }


    public boolean isSignInTextDisplayed() {
        return signInText.isDisplayed();
    }




}
