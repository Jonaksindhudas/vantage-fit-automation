package org.vantagefit.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidActions extends AppiumUtils {

    AndroidDriver driver;
    WebDriverWait wait;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
        setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitForElementToBeVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public  void longPressAction(WebElement ele)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
    }

    public void scrollToEndAction(){

        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean)((JavascriptExecutor) driver).executeScript(
                "mobile: scrollGesture",
                ImmutableMap.<String, Object>builder()
                    .put("left", 100)
                    .put("top", 100)
                    .put("width", 200)
                    .put("height", 200)
                    .put("direction", "down")
                    .put("percent", 3.0)
                    .build()
            );
        }
        while(canScrollMore);
    }

    public  void swipeAction(WebElement ele, String direction)
    {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "direction",direction,"percent",0.75));

    }

    public void scrollDownALittle() {
        try {
            // Get the dimensions of the device screen
            Dimension size = driver.manage().window().getSize();
            int width = size.width;
            int height = size.height;

            // Calculate start and end points for the scroll
            int startX = width / 2;
            int startY = (int) (height * 0.7); // Slightly above the bottom
            int endY = (int) (height * 0.4);  // Slightly below the center

            // Perform the swipe action
            System.out.println("Attempting to scroll...");
            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // Add a short pause
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();
            System.out.println("Scroll action performed.");
        } catch (Exception e) {
            System.out.println("Error during manual scroll: " + e.getMessage());
        }
    }

    public void scrollToEnd() {
        try {
            // Using UiScrollable to scroll to the end
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"
            ));
            System.out.println("Scrolled to the end successfully.");
        } catch (Exception e) {
            System.out.println("Scroll to end failed: " + e.getMessage());
        }
    }

    public void scrollToText(String text) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                            ".setAsVerticalList().scrollIntoView(new UiSelector().text(\"" + text + "\"))"
            ));
        } catch (NoSuchElementException e) {
            System.out.println("Element with text " + text + " not found.");
        }
    }

    public void swipeUp() {
        Dimension dimension = driver.manage().window().getSize();
        int startX = (int) (dimension.width * 0.5);
        int startY = (int) (dimension.height * 0.8);
        int endY = (int) (dimension.height * 0.2);
        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

}
