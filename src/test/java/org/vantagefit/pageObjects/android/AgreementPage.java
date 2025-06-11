package org.vantagefit.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vantagefit.utils.AndroidActions;
import org.testng.Assert;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;

public class AgreementPage extends AndroidActions {

    AndroidDriver driver;
    private WebDriverWait wait;

    public AgreementPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/programNameText")
    private WebElement programNameHeader;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/btn_confirm")
    private WebElement agreeButton;

    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/btn_disagree")
    private WebElement disagreeButton;

    // Alternative locators for agree button
    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/btn_agree")
    private WebElement agreeButtonAlt;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Agree']")
    private WebElement agreeButtonByText;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'Agree')]")
    private WebElement agreeButtonByTextContains;

    public void verifyAgreementElements() {
        try {
            waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/programNameText"));
            System.out.println("Program name header found");
            
            // Try to find agree button using different locators
            List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
            System.out.println("Found " + buttons.size() + " buttons on the page");
            for (WebElement button : buttons) {
                System.out.println("Button text: " + button.getText());
                System.out.println("Button resource-id: " + button.getAttribute("resource-id"));
            }

            // Try different locators for agree button
            try {
                waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_confirm"));
                System.out.println("Found agree button with id btn_confirm");
            } catch (Exception e) {
                System.out.println("Button with id btn_confirm not found");
            }

            try {
                waitForElementToBeVisible(By.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_agree"));
                System.out.println("Found agree button with id btn_agree");
            } catch (Exception e) {
                System.out.println("Button with id btn_agree not found");
            }

            try {
                waitForElementToBeVisible(By.xpath("//android.widget.Button[@text='Agree']"));
                System.out.println("Found agree button with text 'Agree'");
            } catch (Exception e) {
                System.out.println("Button with text 'Agree' not found");
            }

            Assert.assertTrue(programNameHeader.isDisplayed(), "Program name header is not displayed");
        } catch (Exception e) {
            System.out.println("Error verifying agreement elements: " + e.getMessage());
            throw e;
        }
    }

    public void acceptAgreement() {
        try {
            // Try different methods to find and click the agree button
            if (agreeButton.isDisplayed()) {
                waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_confirm"));
                agreeButton.click();
                System.out.println("Clicked agree button using btn_confirm");
            } else if (agreeButtonAlt.isDisplayed()) {
                waitForElementToBeClickable(By.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_agree"));
                agreeButtonAlt.click();
                System.out.println("Clicked agree button using btn_agree");
            } else if (agreeButtonByText.isDisplayed()) {
                waitForElementToBeClickable(By.xpath("//android.widget.Button[@text='Agree']"));
                agreeButtonByText.click();
                System.out.println("Clicked agree button using text locator");
            } else if (agreeButtonByTextContains.isDisplayed()) {
                waitForElementToBeClickable(By.xpath("//android.widget.Button[contains(@text, 'Agree')]"));
                agreeButtonByTextContains.click();
                System.out.println("Clicked agree button using contains text locator");
            } else {
                // Try to find any button with "Agree" text
                List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
                for (WebElement button : buttons) {
                    String buttonText = button.getText();
                    if (buttonText != null && buttonText.contains("Agree")) {
                        button.click();
                        System.out.println("Clicked agree button found by iterating through buttons");
                        return;
                    }
                }
                throw new RuntimeException("Could not find agree button using any method");
            }
        } catch (Exception e) {
            System.out.println("Error clicking agree button: " + e.getMessage());
            throw e;
        }
    }

    public String getProgramName() {
        wait.until(ExpectedConditions.visibilityOf(programNameHeader));
        return programNameHeader.getText();
    }

    public void clickDisagree() {
        wait.until(ExpectedConditions.elementToBeClickable(disagreeButton));
        disagreeButton.click();
    }

    public boolean isAgreeButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(agreeButton));
            return agreeButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisagreeButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(disagreeButton));
            return disagreeButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(programNameHeader));
            return programNameHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public HealthRecordPage navigateToHealthRecordPage() {
        acceptAgreement();
        return new HealthRecordPage(driver);
    }

    public String getAgreeButtonText() {
        try {
            if (agreeButton.isDisplayed()) {
                return agreeButton.getText();
            } else if (agreeButtonAlt.isDisplayed()) {
                return agreeButtonAlt.getText();
            } else if (agreeButtonByText.isDisplayed()) {
                return agreeButtonByText.getText();
            } else if (agreeButtonByTextContains.isDisplayed()) {
                return agreeButtonByTextContains.getText();
            }
        } catch (Exception e) {
            // Try to find any button with "Agree" text
            List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
            for (WebElement button : buttons) {
                String buttonText = button.getText();
                if (buttonText != null && buttonText.contains("Agree")) {
                    return buttonText;
                }
            }
        }
        return "";
    }

    public String getDisagreeButtonText() {
        return disagreeButton.getText();
    }
}
