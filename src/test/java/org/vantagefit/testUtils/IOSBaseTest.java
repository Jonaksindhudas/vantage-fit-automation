package org.vantagefit.testUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.vantagefit.utils.AppiumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class IOSBaseTest extends AppiumUtils {

    public IOSDriver driver;

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException, InterruptedException {
        Properties prop= new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/data.properties");
        String ipAddress=System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress"):prop.getProperty("ipAddress");
        prop.load(fis);
        String port=prop.getProperty("port");

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(prop.getProperty("IOSDeviceName"));
        options.setApp("//Users//raktimkakati//Documents//APPIUMLEARNING//AppiumProject//untitled//src//test//resources//Apps//UIKitCatalog.app");
        options.setPlatformVersion("17.2");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new java.net.URL("http://127.0.0.1:" + port + "/wd/hub"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @AfterClass
    public void tearDown()
    {
        if (driver != null) {
            driver.quit();
        }
    }
}
