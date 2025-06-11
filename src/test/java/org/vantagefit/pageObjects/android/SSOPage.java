package org.vantagefit.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.vantagefit.utils.AndroidActions;
public class SSOPage extends AndroidActions {

    AndroidDriver driver;

    public SSOPage(AndroidDriver driver) {
            super(driver);
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.bargaintechnologies.vantagefit.v_fit:id/search_src_text")
    private WebElement SearchSSOOrganisationTextBox;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Single Sign-On (SAML)\"]")
    private WebElement SSOPageHeaderText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Vantage_Circle\"]")
    private WebElement VantageCircleSSO;
    @AndroidFindBy(id = "com.bargaintechnologies.vantagefit.v_fit:id/backToLoginButton")
    private WebElement CancelSSOButton;

    @AndroidFindBy(accessibility = "Clear query")
    private WebElement ClearSearchQuery;



    public  String GetSSOPageHeaderText()
    {
        String header = SSOPageHeaderText.getAttribute("text");
        return header;
    }

    public  void SearchSSOOrganisationName(String ssoorganisationname)
    {
        SearchSSOOrganisationTextBox.sendKeys(ssoorganisationname);
    }

    public  String GetSearchedSOOrganisationName()
    {
        String selectssoorganisation = VantageCircleSSO.getText();
        return selectssoorganisation;
    }

    public void TapOnOrganisation()
    {
        VantageCircleSSO.click();
    }

    public void CancelSSO()
    {
        CancelSSOButton.click();
    }

    public void ClearSearchQuery()
    {
        ClearSearchQuery.click();
    }

    public boolean isSearchTextBoxEmpty() {
        return SearchSSOOrganisationTextBox.getText().contains("Type Organization Name");
    }
}
