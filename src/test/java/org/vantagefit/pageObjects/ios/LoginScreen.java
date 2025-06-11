package org.vantagefit.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.vantagefit.utils.IOSActions;

public class LoginScreen extends IOSActions {

    IOSDriver driver;

    public LoginScreen(IOSDriver driver)
    {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


}
