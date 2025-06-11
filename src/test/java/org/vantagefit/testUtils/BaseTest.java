package org.vantagefit.testUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.vantagefit.pageObjects.android.LoginScreen;
import org.vantagefit.pageObjects.android.WorkEmailLoginPage;
import org.vantagefit.pageObjects.android.WorkEmailPasswordPage;
import org.vantagefit.pageObjects.android.AgreementPage;
import org.vantagefit.pageObjects.android.HomePage;
import org.vantagefit.pageObjects.android.HealthRecordPage;
import org.vantagefit.utils.AppiumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest extends AppiumUtils {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class.getName());
    public AndroidDriver driver;
    public LoginScreen loginScreen;
    public WorkEmailLoginPage workEmailLoginPage;
    public WorkEmailPasswordPage workEmailPasswordPage;
    public AgreementPage agreementPage;
    public HomePage homePage;
    public HealthRecordPage healthRecordPage;

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//data.properties");
            prop.load(fis);
            
            String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
            String port = prop.getProperty("port");
            String deviceName = prop.getProperty("AndroidDeviceName");
            String appPath = System.getProperty("user.dir") + "//src//test//resources//Apps//app-v_fit-debug3.9.5.apk";
            String chromeDriverPath = System.getProperty("user.dir") + "//src//test//resources//chromedriver_mac_arm64//chromedriver";

            LOGGER.info("Initializing Appium driver with the following configuration:");
            LOGGER.info("IP Address: " + ipAddress);
            LOGGER.info("Port: " + port);
            LOGGER.info("Device Name: " + deviceName);
            LOGGER.info("App Path: " + appPath);
            LOGGER.info("ChromeDriver Path: " + chromeDriverPath);

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(deviceName);
            options.setChromedriverExecutable(chromeDriverPath);
            options.setApp(appPath);
            options.setNewCommandTimeout(Duration.ofSeconds(300));
            options.setAutoGrantPermissions(true);
            options.setNoReset(true);
            options.setFullReset(false);
            options.setSkipDeviceInitialization(true);
            options.setSkipServerInstallation(true);
            options.setDisableWindowAnimation(true);
            options.setAndroidInstallTimeout(Duration.ofSeconds(90));
            options.setAdbExecTimeout(Duration.ofSeconds(60));
            options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(60));
            options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(60));

            driver = new AndroidDriver(new URL("http://" + ipAddress + ":" + port + "/wd/hub"), options);
            setDriver(driver);

            // Initialize page objects
            loginScreen = new LoginScreen(driver);
            workEmailLoginPage = new WorkEmailLoginPage(driver);
            workEmailPasswordPage = new WorkEmailPasswordPage(driver);
            agreementPage = new AgreementPage(driver);
            homePage = new HomePage(driver);
            healthRecordPage = new HealthRecordPage(driver);

            LOGGER.info("Appium driver initialized successfully");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to initialize Appium driver", e);
            throw e;
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                LOGGER.info("Appium driver closed successfully");
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error closing Appium driver", e);
            }
        }
    }
} 