package org.vantagefit.testUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.vantagefit.pageObjects.android.LoginScreen;
import org.vantagefit.utils.AppiumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AndroidBaseTest extends AppiumUtils {
    private static final Logger logger = Logger.getLogger(AndroidBaseTest.class.getName());
    public AndroidDriver driver;
    public LoginScreen loginScreen;
    protected WebDriverWait wait;
    private String deviceName;
    private String appPath;
    private String chromeDriverPath;

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//data.properties");
            prop.load(fis);
            
            String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
            String port = prop.getProperty("port");
            deviceName = prop.getProperty("AndroidDeviceName");
            appPath = System.getProperty("user.dir") + "//src//test//resources//Apps//" + prop.getProperty("AndroidAppName");
            chromeDriverPath = System.getProperty("user.dir") + "//src//test//resources//chromedriver_mac_arm64//chromedriver";

            logger.info("Initializing Appium driver with the following configuration:");
            logger.info("IP Address: " + ipAddress);
            logger.info("Port: " + port);
            logger.info("Device Name: " + deviceName);
            logger.info("App Path: " + appPath);
            logger.info("ChromeDriver Path: " + chromeDriverPath);

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(deviceName);
            options.setChromedriverExecutable(chromeDriverPath);
            options.setApp(appPath);
            options.setNewCommandTimeout(Duration.ofSeconds(300));
            options.setAutoGrantPermissions(true);
            options.setNoReset(false);
            options.setFullReset(true);
            options.setSkipDeviceInitialization(true);
            options.setSkipServerInstallation(true);
            options.setDisableWindowAnimation(true);
            options.setAndroidInstallTimeout(Duration.ofSeconds(90));
            options.setAdbExecTimeout(Duration.ofSeconds(60));
            options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(60));
            options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(60));

            driver = new AndroidDriver(new URL("http://" + ipAddress + ":" + port + "/wd/hub"), options);
            setDriver(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            loginScreen = new LoginScreen(driver);

            logger.info("Appium driver initialized successfully");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to initialize Appium driver", e);
            throw e;
        }
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                logger.info("Appium driver closed successfully");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error closing Appium driver", e);
            }
        }
    }

    public AndroidDriver ConfigureAppium(Map<String, String> additionalCapabilities) throws MalformedURLException {
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//data.properties");
            prop.load(fis);
            
            String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
            String port = prop.getProperty("port");
            deviceName = prop.getProperty("AndroidDeviceName");
            appPath = System.getProperty("user.dir") + "//src//test//resources//Apps//" + prop.getProperty("AndroidAppName");
            chromeDriverPath = System.getProperty("user.dir") + "//src//test//resources//chromedriver_mac_arm64//chromedriver";

            logger.info("Initializing Appium driver with the following configuration:");
            logger.info("IP Address: " + ipAddress);
            logger.info("Port: " + port);
            logger.info("Device Name: " + deviceName);
            logger.info("App Path: " + appPath);
            logger.info("ChromeDriver Path: " + chromeDriverPath);

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(deviceName);
            options.setChromedriverExecutable(chromeDriverPath);
            options.setApp(appPath);
            options.setNewCommandTimeout(Duration.ofSeconds(300));
            options.setAutoGrantPermissions(true);
            options.setNoReset(false);
            options.setFullReset(true);
            options.setSkipDeviceInitialization(true);
            options.setSkipServerInstallation(true);
            options.setDisableWindowAnimation(true);
            options.setAndroidInstallTimeout(Duration.ofSeconds(90));
            options.setAdbExecTimeout(Duration.ofSeconds(60));
            options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(60));
            options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(60));
            
            // Add language and locale capabilities if provided
            if (additionalCapabilities != null) {
                for (Map.Entry<String, String> entry : additionalCapabilities.entrySet()) {
                    options.setCapability(entry.getKey(), entry.getValue());
                }
            }
            
            driver = new AndroidDriver(new URL("http://" + ipAddress + ":" + port + "/wd/hub"), options);
            setDriver(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            loginScreen = new LoginScreen(driver);

            logger.info("Appium driver initialized successfully");
            return driver;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to initialize Appium driver", e);
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }
    }
}
