package org.vantagefit.pageObjects.android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.vantagefit.utils.AndroidActions;

public class ConnectGoogleFitPage extends AndroidActions {

    AndroidDriver driver;

    public ConnectGoogleFitPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/title")
    private WebElement connectGoogleFitTitle;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/continue_btn")
    private WebElement continueButton;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/desc")
    private WebElement googleFitDescription;

    // Permissions elements
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowActivityButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement denyActivityButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement allowWhileUsingAppButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private WebElement allowOnlyThisTimeButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement denyLocationButton;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/skip_btn")
    private WebElement skipButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Allow Vantage Fit to send you notifications?')]")
    private WebElement notificationPermissionPopup;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowNotificationButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement denyNotificationButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Calories\"]")
    private WebElement homeScreencalorieword;



    public boolean isConnectGoogleFitPageDisplayed() {
        return connectGoogleFitTitle.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isConnectGoogleFitTitleDisplayed() {
        return connectGoogleFitTitle.isDisplayed();
    }

    public boolean isGoogleFitDescriptionDisplayed() {
        return googleFitDescription.isDisplayed();
    }

    public void clickAllowActivityButton() {
        allowActivityButton.click();
    }

    public boolean isAllowActivityButtonDisplayed() {
        return allowActivityButton.isDisplayed();
    }

    public boolean isDenyActivityButtonDisplayed() {
        return denyActivityButton.isDisplayed();
    }

    public void clickAllowWhileUsingAppButton() {
        allowWhileUsingAppButton.click();
    }

    public boolean isAllowWhileUsingAppButtonDisplayed() {
        return allowWhileUsingAppButton.isDisplayed();
    }

    public boolean isAllowOnlyThisTimeButtonDisplayed() {
        return allowOnlyThisTimeButton.isDisplayed();
    }

    public boolean isDenyLocationButtonDisplayed() {
        return denyLocationButton.isDisplayed();
    }

    public void navigateThroughPermissions() {
        clickAllowActivityButton();
        clickAllowWhileUsingAppButton();
    }

    public boolean isNotificationPermissionPopupVisible() {
        return notificationPermissionPopup.isDisplayed();

    }

    public boolean isAllowNotificationButtonVisible() {
        return allowNotificationButton.isDisplayed();
    }

    public boolean isDenyNotificationButtonVisible() {
        return denyNotificationButton.isDisplayed();
    }

    public void clickSkipButton() {
        skipButton.click();
    }

    public HomePage allowNotificationPermission() {
        allowNotificationButton.click();
        return new HomePage(driver);
    }

    public boolean isHomeScreenVisible() {
        return homeScreencalorieword.isDisplayed();
    }

    public boolean isSkipButtonVisible() {
        return skipButton.isDisplayed();

    }



}



