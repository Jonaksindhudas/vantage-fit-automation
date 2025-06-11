package org.vantagefit.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.vantagefit.utils.AndroidActions;

public class SupportChatPage extends AndroidActions {

    AndroidDriver driver;

    public SupportChatPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/freshchat_text")
    private WebElement SalutationSupportMessage;


    public  String GetSalutationSupportMessage()
    {
        String message = SalutationSupportMessage.getAttribute("text");
        return message;
    }

    public String getSalutationSupportMessage() {
        return GetSalutationSupportMessage();
    }

}
