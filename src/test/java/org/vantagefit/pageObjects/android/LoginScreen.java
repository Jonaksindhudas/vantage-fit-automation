package org.vantagefit.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.vantagefit.utils.AndroidActions;
import org.testng.Assert;

public class LoginScreen extends AndroidActions {

    AndroidDriver driver;
    public LoginScreen(AndroidDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/btn_workEmail")
    private WebElement LogInworkEmailButton;

    @AndroidFindBy(id ="com.bargaintechnologies.vantagefit.v_fit:id/google_login") // Replace with actual ID
    private WebElement someElementOnLoginScreen;


    public WorkEmailLoginPage selectWorkEmailLogin()
    {
        LogInworkEmailButton.click();
        return new WorkEmailLoginPage(driver);
    }

    public void clickWorkEmailLogin() {
        LogInworkEmailButton.click();
    }

    public void verifyLoginScreenElements() {
        Assert.assertTrue(LogInworkEmailButton.isDisplayed(), "Work Email Login button is not displayed");
        Assert.assertTrue(someElementOnLoginScreen.isDisplayed(), "Google Login button is not displayed");
    }

    public String getWorkEmailLoginfieldText()
    {
        String text = LogInworkEmailButton.getText();
        return text;
    }

    public boolean isDisplayed() {
        return someElementOnLoginScreen.isDisplayed();
    }




}
