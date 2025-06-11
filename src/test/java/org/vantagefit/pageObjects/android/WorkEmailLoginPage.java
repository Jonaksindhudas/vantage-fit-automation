package org.vantagefit.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.vantagefit.utils.AndroidActions;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkEmailLoginPage extends AndroidActions {

    AndroidDriver driver;
    private static final int MAX_RETRIES = 3;
    private static final Duration RETRY_DELAY = Duration.ofSeconds(2);

    public WorkEmailLoginPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/txtEmail")
    private WebElement LogInworkEmailfield;

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/btn_next")
    private WebElement WorkEmailNextButton;

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/btn_sso")
    private WebElement SSOButton;

    @AndroidFindBy(id="android:id/message")
    private WebElement ErrorMessagePopUP;

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/tv_welcome")
    private WebElement WelcomeHeader;

    @AndroidFindBy(id="android:id/button1")
    private WebElement LoginErrorOKButton;

    @AndroidFindBy(id="android:id/button3")
    private WebElement LoginErrorNeedHelpButton;

    @AndroidFindBy(id="android:id/button3")
    private WebElement NeedHelp;

    public void enterEmail(String emailId) {
        int retryCount = 0;
        while (retryCount < MAX_RETRIES) {
            try {
                waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/txtEmail"));
                LogInworkEmailfield.clear();
                LogInworkEmailfield.sendKeys(emailId);
                return;
            } catch (Exception e) {
                retryCount++;
                if (retryCount == MAX_RETRIES) {
                    throw new RuntimeException("Failed to enter email after " + MAX_RETRIES + " attempts", e);
                }
                try {
                    Thread.sleep(RETRY_DELAY.toMillis());
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public WorkEmailPasswordPage clickContinue() {
        int retryCount = 0;
        while (retryCount < MAX_RETRIES) {
            try {
                waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_next"));
                WorkEmailNextButton.click();
                
                // Wait for either password field or error message
                try {
                    waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/txtPassword"));
                    return new WorkEmailPasswordPage(driver);
                } catch (Exception e) {
                    // Wait for error message with timeout
                    try {
                        // Use WebDriverWait for custom timeout
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                        wait.until(ExpectedConditions.visibilityOf(ErrorMessagePopUP));
                        if (ErrorMessagePopUP.isDisplayed()) {
                            String errorText = ErrorMessagePopUP.getText();
                            if (errorText.contains("Something went wrong")) {
                                // Handle server error
                                LoginErrorOKButton.click();
                                retryCount++;
                                if (retryCount == MAX_RETRIES) {
                                    throw new RuntimeException("Server error persisted after " + MAX_RETRIES + " attempts");
                                }
                                continue;
                            }
                            // If we have an error message, return null to indicate failure
                            return null;
                        }
                    } catch (Exception timeoutEx) {
                        // If we timeout waiting for error message, it might be a different issue
                        System.out.println("Timeout waiting for error message: " + timeoutEx.getMessage());
                    }
                    throw e;
                }
            } catch (Exception e) {
                retryCount++;
                if (retryCount == MAX_RETRIES) {
                    throw new RuntimeException("Failed to click continue after " + MAX_RETRIES + " attempts", e);
                }
                try {
                    Thread.sleep(RETRY_DELAY.toMillis());
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return new WorkEmailPasswordPage(driver);
    }

    public void verifyWorkEmailLoginElements() {
        Assert.assertTrue(LogInworkEmailfield.isDisplayed(), "Email field is not displayed");
        Assert.assertTrue(WorkEmailNextButton.isDisplayed(), "Next button is not displayed");
        Assert.assertTrue(SSOButton.isDisplayed(), "SSO button is not displayed");
        Assert.assertTrue(WelcomeHeader.isDisplayed(), "Welcome header is not displayed");
    }

    public String getEmailWrongMessageText() {
        try {
            waitForElementToBeVisible(By.id("android:id/message"));
            return ErrorMessagePopUP.getText();
        } catch (Exception e) {
            System.out.println("Error getting email error message: " + e.getMessage());
            return "";
        }
    }

    public String getWelcomeMessage() {
        String headertext = WelcomeHeader.getText();
        return headertext;
    }

    public void clickLoginErrorOKButton() {
        LoginErrorOKButton.click();
    }

    public SupportChatPage clickLoginErrorNeedHelpButton() {
        LoginErrorNeedHelpButton.click();
        return new SupportChatPage(driver);
    }

    public SSOPage selectSSOLogin() {
        SSOButton.click();
        return new SSOPage(driver);
    }

    public String getContinueButtonText() {
        return WorkEmailNextButton.getText();
    }
}




