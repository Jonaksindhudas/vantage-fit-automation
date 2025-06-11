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
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkEmailPasswordPage extends AndroidActions {

    AndroidDriver driver;
    private static final int MAX_RETRIES = 3;
    private static final Duration RETRY_DELAY = Duration.ofSeconds(2);

    public WorkEmailPasswordPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/txtPassword")
    private WebElement PasswordField;

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/btn_nextPassword")
    private WebElement PasswordConfirmLoginButton;

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/tv_forgotPassword")
    private WebElement ForgotPasswordButton;

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/btn_otp")
    private WebElement LogInWithOTPButton;

    @AndroidFindBy(id="android:id/message")
    private WebElement PasswordWrongMessage;

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/tv_welcome")
    private WebElement WelcomeHeader;

    @AndroidFindBy(id="android:id/button1")
    private WebElement ErrorOKButton;

    // Alternative locators for next button
    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/btn_next")
    private WebElement NextButtonAlt;

    @AndroidFindBy(xpath="//android.widget.Button[@text='Next']")
    private WebElement NextButtonByText;

    @AndroidFindBy(xpath="//android.widget.Button[contains(@text, 'Next')]")
    private WebElement NextButtonByTextContains;

    public void enterPassword(String password) {
        int retryCount = 0;
        while (retryCount < MAX_RETRIES) {
            try {
                waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/txtPassword"));
                PasswordField.clear();
                PasswordField.sendKeys(password);
                return;
            } catch (Exception e) {
                retryCount++;
                if (retryCount == MAX_RETRIES) {
                    throw new RuntimeException("Failed to enter password after " + MAX_RETRIES + " attempts", e);
                }
                try {
                    Thread.sleep(RETRY_DELAY.toMillis());
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void clickSignIn() {
        int retryCount = 0;
        while (retryCount < MAX_RETRIES) {
            try {
                // First try the primary button
                if (PasswordConfirmLoginButton.isDisplayed()) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    wait.until(ExpectedConditions.elementToBeClickable(PasswordConfirmLoginButton));
                    PasswordConfirmLoginButton.click();
                    return;
                }

                // If primary button not found, try alternative buttons
                List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
                for (WebElement button : buttons) {
                    String buttonText = button.getText();
                    if (buttonText != null && buttonText.contains("Next")) {
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                        wait.until(ExpectedConditions.elementToBeClickable(button));
                        button.click();
                        return;
                    }
                }

                // If no button found, try the alternative locators
                if (NextButtonAlt.isDisplayed()) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    wait.until(ExpectedConditions.elementToBeClickable(NextButtonAlt));
                    NextButtonAlt.click();
                    return;
                }

                throw new RuntimeException("Could not find next button");
            } catch (Exception e) {
                retryCount++;
                if (retryCount == MAX_RETRIES) {
                    throw new RuntimeException("Failed to click sign in after " + MAX_RETRIES + " attempts", e);
                }
                try {
                    Thread.sleep(RETRY_DELAY.toMillis());
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void verifyWorkEmailPasswordElements() {
        try {
            waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/txtPassword"));
            System.out.println("Password field found");
            
            // Try to find next button using different locators
            List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
            System.out.println("Found " + buttons.size() + " buttons on the page");
            for (WebElement button : buttons) {
                System.out.println("Button text: " + button.getText());
                System.out.println("Button resource-id: " + button.getAttribute("resource-id"));
            }

            // Try different locators for next button
            try {
                waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_nextPassword"));
                System.out.println("Found next button with id btn_nextPassword");
            } catch (Exception e) {
                System.out.println("Button with id btn_nextPassword not found");
            }

            try {
                waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_next"));
                System.out.println("Found next button with id btn_next");
            } catch (Exception e) {
                System.out.println("Button with id btn_next not found");
            }

            try {
                waitForElementToBeVisible(By.xpath("//android.widget.Button[@text='Next']"));
                System.out.println("Found next button with text 'Next'");
            } catch (Exception e) {
                System.out.println("Button with text 'Next' not found");
            }

            Assert.assertTrue(PasswordField.isDisplayed(), "Password field is not displayed");
        } catch (Exception e) {
            System.out.println("Error verifying password elements: " + e.getMessage());
            throw e;
        }
    }

    public String getPasswordWrongMessageText() {
        try {
            waitForElementToBeVisible(By.id("android:id/message"));
            return PasswordWrongMessage.getText();
        } catch (Exception e) {
            System.out.println("Error getting password error message: " + e.getMessage());
            return "";
        }
    }

    public String getWelcomeMessage() {
        String headertext = WelcomeHeader.getText();
        return headertext;
    }

    public AgreementPage passDriverToAgreementPage() {
        int retryCount = 0;
        while (retryCount < MAX_RETRIES) {
            try {
                clickSignIn();
                
                // Wait for either agreement page or error message
                try {
                    waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_agree"));
                    return new AgreementPage(driver);
                } catch (Exception e) {
                    // Check if error message is present
                    if (PasswordWrongMessage.isDisplayed()) {
                        String errorText = PasswordWrongMessage.getText();
                        if (errorText.contains("Something went wrong")) {
                            // Handle server error
                            ErrorOKButton.click();
                            retryCount++;
                            if (retryCount == MAX_RETRIES) {
                                throw new RuntimeException("Server error persisted after " + MAX_RETRIES + " attempts");
                            }
                            continue;
                        }
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
        return new AgreementPage(driver);
    }

    public String getSignInButtonText() {
        return PasswordConfirmLoginButton.getText();
    }
}
