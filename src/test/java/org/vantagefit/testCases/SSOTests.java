package org.vantagefit.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.vantagefit.pageObjects.android.SSOPage;
import org.vantagefit.pageObjects.android.WorkEmailLoginPage;
import org.vantagefit.testUtils.AndroidBaseTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

public class SSOTests extends AndroidBaseTest {

    @BeforeMethod(alwaysRun = true)
    public void  presetup() {
        driver.terminateApp("com.bargaintechnologies.vantagefit.v_fit");
        driver.activateApp("com.bargaintechnologies.vantagefit.v_fit");
    }

    @Test(priority = 1,description = "TC 01 SSO -Verify Single Sign-On (SAML) Page is loading")
    public void SelectSSO() throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        SSOPage ssoPage = workEmailLoginPage.selectSSOLogin();
        String sSOPageHeaderText = ssoPage.GetSSOPageHeaderText();
        Assert.assertEquals(sSOPageHeaderText, "Single Sign-On (SAML)");

    }


    @Test(priority = 2, dataProvider = "EmailPasswordSsoCompany", description = "TC 02 SSO -Verify Single Sign-On Organisation Search Functionality")
    public void SearchSSOOrganisation(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        SSOPage ssoPage = workEmailLoginPage.selectSSOLogin();
        ssoPage.SearchSSOOrganisationName(input.get("ssoorganisationname"));
        String searchedorganisationname = ssoPage.GetSearchedSOOrganisationName();
        Assert.assertEquals(searchedorganisationname,input.get("ssoorganisationname"));
    }


    @Test(priority = 3,description = "TC 03 SSO -Verify Single Sign-On (SAML) Page Cancel button")
    public void CancelSSO() throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        SSOPage ssoPage = workEmailLoginPage.selectSSOLogin();
        ssoPage.CancelSSO();
        String workEmailLoginfieldText = loginScreen.getWorkEmailLoginfieldText();
        Assert.assertEquals(workEmailLoginfieldText, "Log in with work email");
    }

    @Test(priority = 4, dataProvider = "EmailPasswordSsoCompany", description = "TC 04 SSO -Verify Single Sign-On Organisation Search remove Functionality by clicking on the cross mark")
    public void SearchSSOOrganisationCloseIcon(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        SSOPage ssoPage = workEmailLoginPage.selectSSOLogin();
        ssoPage.SearchSSOOrganisationName(input.get("ssoorganisationname"));
        ssoPage.ClearSearchQuery();
        Assert.assertTrue(ssoPage.isSearchTextBoxEmpty(), "Search text box is not empty after clearing.");

    }

    @Test(priority = 5, dataProvider = "EmailPasswordSsoCompany", description = "TC 05 SSO -Verify tapping on the Organisation Name redirects to the Company's SSO login Page")
    public void SSOLoginPageRedirection(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        SSOPage ssoPage = workEmailLoginPage.selectSSOLogin();
        ssoPage.SearchSSOOrganisationName(input.get("ssoorganisationname"));
        String searchedorganisationname = ssoPage.GetSearchedSOOrganisationName();
        Assert.assertEquals(searchedorganisationname,input.get("ssoorganisationname"));
        ssoPage.TapOnOrganisation();
    }


    @DataProvider(name="EmailPasswordSsoCompany")
    public Object[][] getSSOTestData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//SSOTests//EmailPasswordSsoCompany.json");
        Object[][] testData = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            testData[i][0] = data.get(i);
        }
        return testData;
    }   


    }



