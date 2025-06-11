package org.vantagefit.testCases;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.vantagefit.pageObjects.android.*;
import org.vantagefit.testUtils.AndroidBaseTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

public class LoginWithWorkEMailTests extends AndroidBaseTest {

    @BeforeMethod(alwaysRun = true)
    public void  presetup() {
        driver.terminateApp("com.bargaintechnologies.vantagefit.v_fit");
        driver.activateApp("com.bargaintechnologies.vantagefit.v_fit");
    }

    @Test(priority = 1,dataProvider = "LongEmailMaxCharacterlimt",description ="TC 01 WorkEMailLogin - Verify error message when email exceeds maximum character length limit")
    public void LongEmailMaxCharacterLenghtLimit(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "The Email ID/EmployeeID is too long");

    }

    @Test(priority = 2,dataProvider = "ShortEmailMinCharacterlimt",description ="TC 02 WorkEMailLogin - Verify error message when email does not meet minimum character length limit")
    public void ShortEMailMinCharacterLenghtLimit(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "The Email ID/EmployeeID is too short");

    }

    @Test(priority = 3,description ="TC 03 WorkEMailLogin -Verify behavior when email field is left blank")
    public void EmailBlank() throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail("");
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String welcomeMessage = workEmailLoginPage.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "Welcome!");

    }

    @Test(priority = 4,dataProvider = "EmailSpecialCharacters",description = "TC 04 WorkEMailLogin -Verify error message when email contains special character")
    public void EmailWithSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }

    @Test(priority = 5,dataProvider = "PercentageEmailSpecialCharacters",description = "TC 05 WorkEMailLogin -Verify error message when email contains percentage special character")
    public void EmailWithPercentageSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }

    @Test(priority = 6,dataProvider = "FrontSlashEmailSpecialCharacters",description = "TC 06 WorkEMailLogin -Verify error message when email contains frontslash special character")
    public void EmailWithFrontSlashSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }


    @Test(priority = 7,dataProvider = "BackEmailSpecialCharacters",description = "TC 07 WorkEMailLogin -Verify error message when email contains backslash special character")
    public void EmailWithBackSlashSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }

    @Test(priority = 8,dataProvider = "PipeEmailSpecialCharacters",description = "TC 08 WorkEMailLogin -Verify error message when email contains Pipe | special character")
    public void EmailWithPipeSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }

    @Test(priority = 9,dataProvider = "GraveEmailSpecialCharacters",description = "TC 09 WorkEMailLogin -Verify error message when email contains Grave ` special character")
    public void EmailWithGraveSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }


    @Test(priority = 10,dataProvider = "CapEmailSpecialCharacters",description = "TC 10 WorkEMailLogin -Verify error message when email contains cap ^ special character")
    public void EmailWithCapSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }


    @Test(priority = 11,dataProvider = "OpenCurlyBracesEmailSpecialCharacters",description = "TC 11 WorkEMailLogin -Verify error message when email contains Open Curly Braces { special character")
    public void EmailWithOpenCurlyBracesSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }


    @Test(priority = 12,dataProvider = "ClosedCurlyBracesEmailSpecialCharacters",description = "TC 12 WorkEMailLogin -Verify error message when email contains Closed Curly Braces } special character")
    public void EmailWithClosedCurlyBracesSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }
    @Test(priority = 13, dataProvider = "OpenSquareBracketEmailSpecialCharacters", description = "TC 13 WorkEMailLogin - Verify error message when email contains Open Square Bracket [ special character")
    public void EmailWithOpenSquareBracketSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }

    @Test(priority = 14, dataProvider = "ClosedSquareBracketEmailSpecialCharacters", description = "TC 14 WorkEMailLogin - Verify error message when email contains Closed Square Bracket ] special character")
    public void EmailWithClosedSquareBracketSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }

    @Test(priority = 15, dataProvider = "FullStopEmailSpecialCharacters", description = "TC 15 WorkEMailLogin - Verify error message when email contains Full Stop . special character")
    public void EmailWithFullStopSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }

    @Test(priority = 16, dataProvider = "TagOpenEmailSpecialCharacters", description = "TC 16 WorkEMailLogin - Verify error message when email contains Tag Open < special character")
    public void EmailWithTagOpenSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }

    @Test(priority = 17, dataProvider = "TagCloseEmailSpecialCharacters", description = "TC 17 WorkEMailLogin - Verify error message when email contains Tag Close > special character")
    public void EmailWithTagCloseSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");

    }


    @Test(priority = 18, dataProvider = "TildeEmailSpecialCharacters", description = "TC 18 WorkEMailLogin - Verify error message when email contains ~ tilde character")
    public void EmailWithTildeSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    @Test(priority = 19, dataProvider = "ExclamationEmailSpecialCharacters", description = "TC 19 WorkEMailLogin - Verify error message when email contains ! exclamation character")
    public void EmailWithExclamationSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    @Test(priority = 20, dataProvider = "HashEmailSpecialCharacters", description = "TC 20 WorkEMailLogin - Verify error message when email contains # hash character")
    public void EmailWithHashSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }


    @Test(priority = 21, dataProvider = "DollarEmailSpecialCharacters", description = "TC 21 WorkEMailLogin - Verify error message when email contains $ dollar character")
    public void EmailWithDollarSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    // Ampersand (&) symbol
    @Test(priority = 22, dataProvider = "AmpersandEmailSpecialCharacters", description = "TC 22 WorkEMailLogin - Verify error message when email contains & ampersand character")
    public void EmailWithAmpersandSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    // Asterisk (*) symbol
    @Test(priority = 23, dataProvider = "AsteriskEmailSpecialCharacters", description = "TC 23 WorkEMailLogin - Verify error message when email contains * asterisk character")
    public void EmailWithAsteriskSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    // Open bracket "(" symbol
    @Test(priority = 24, dataProvider = "OpenBracketEmailSpecialCharacters", description = "TC 24 WorkEMailLogin - Verify error message when email contains ( open bracket character")
    public void EmailWithOpenBracketSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    // Close bracket ")" symbol
    @Test(priority = 25, dataProvider = "ClosedBracketEmailSpecialCharacters", description = "TC 25 WorkEMailLogin - Verify error message when email contains ) closed bracket character")
    public void EmailWithCloseBracketSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    // Underscore (_) symbol
    @Test(priority = 26, dataProvider = "UnderscoreEmailSpecialCharacters", description = "TC 26 WorkEMailLogin - Verify error message when email contains _ underscore character")
    public void EmailWithUnderscoreSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    // Hyphen (-) symbol
    @Test(priority = 27, dataProvider = "HyphenEmailSpecialCharacters", description = "TC 27 WorkEMailLogin - Verify error message when email contains - hypen character")
    public void EmailWithHyphenSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    // Equal (=) symbol
    @Test(priority = 28, dataProvider = "EqualEmailSpecialCharacters", description = "TC 28 WorkEMailLogin - Verify error message when email contains = equal character")
    public void EmailWithEqualSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    // Plus (+) symbol
    @Test(priority = 29, dataProvider = "PlusEmailSpecialCharacters", description = "TC 29 WorkEMailLogin - Verify error message when email contains + plus character")
    public void EmailWithPlusSpecialCharacter(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
    }

    @Test(priority = 30,dataProvider = "EmailWithSpace",description = "TC 30 WorkEMailLogin -Verify error message when email contains spaces")
    public void EmailWithSpace(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "The emailid/emloyeeID has spaces.Please re-enter");

    }


    @Test(priority = 31,dataProvider = "UpperCaseEmailandPassword",description = "TC 31 WorkEMailLogin -Verify login with uppercase email")
    public void UpperCaseEmail(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword(input.get("password"));
        AgreementPage termsAndConditionPage =  workEmailPasswordPage.passDriverToAgreementPage();
        String programname = termsAndConditionPage.getProgramName();
        Assert.assertEquals(programname, "Our Vantage Circle Employee Advantage");
    }


    @Test(priority = 32,dataProvider = "LowerCaseEmailandPassword",description = "TC 32 WorkEMailLogin -Verify login with lowercase email")
    public void LowerCaseEmail(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword(input.get("password"));
        AgreementPage termsAndConditionPage =  workEmailPasswordPage.passDriverToAgreementPage();
        String programname = termsAndConditionPage.getProgramName();
        Assert.assertEquals(programname, "Our Vantage Circle Employee Advantage");
    }


    @Test(priority = 33,dataProvider = "EmailInvalidDomain",description = "TC 33 WorkEMailLogin -Verify error message when invalid domain name is provided")
    public void InvalidEmailDomain(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String errormessage=workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(errormessage, "Your domain is not found. Please contact support@vantagecircle.com");
    }

    @Test(priority = 34,dataProvider = "CorrectEmailAndWrongPassword",description = "TC 34 WorkEMailLogin -Verify error message when correct email and incorrect password are entered")
    public void CorrectEMailAndIncorrectPassword(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword(input.get("password"));
        String passwordErrorMessage = workEmailPasswordPage.getPasswordWrongMessageText();
        Assert.assertEquals(passwordErrorMessage, "Error, You have entered an invalid employee-id or password");

    }


    @Test(priority = 35,dataProvider = "CorrectCredentials",description = "TC 35 WorkEMailLogin -Verify behavior when password is left blank")
    public void BlankPassword(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword("");
        String welcomeMessage = workEmailLoginPage.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "Welcome!");

    }

    @Test(priority = 36,dataProvider = "CorrectCredentials",description = "TC 36 WorkEMailLogin -Verify login with correct email and password")
    public void CorrectEMailAndCorrectPassword(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword(input.get("password"));
        driver.findElement(AppiumBy.id("com.bargaintechnologies.vantagefit.v_fit:id/btn_confirm")).click();

        driver.findElement(AppiumBy.id("com.bargaintechnologies.vantagefit.v_fit:id/saveChangesButtonId")).click();

        driver.findElement(AppiumBy.id("com.bargaintechnologies.vantagefit.v_fit:id/next")).click();

        driver.findElement(AppiumBy.id("com.bargaintechnologies.vantagefit.v_fit:id/loseWeightCard")).click();
        driver.findElement(AppiumBy.id("com.bargaintechnologies.vantagefit.v_fit:id/next")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Moderately Active\"]")).click();
        driver.findElement(AppiumBy.id("com.bargaintechnologies.vantagefit.v_fit:id/start")).click();

        driver.findElement(AppiumBy.id("com.bargaintechnologies.vantagefit.v_fit:id/continueButton")).click();

        driver.findElement(AppiumBy.id("com.bargaintechnologies.vantagefit.v_fit:id/skip_btn")).click();

        driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        String Calorie = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Calories\"]")).getText();
        Assert.assertEquals(Calorie, "Calories");

    }


    @Test(priority = 37,dataProvider = "LongPasswordMaxCharacterlimit",description = "TC 37 WorkEMailLogin -Verify error message when password exceeds maximum character length limit")
    public void MaxPasswordlenght(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        workEmailPasswordPage.enterPassword(input.get("password"));
        String errorMessage = workEmailPasswordPage.getPasswordWrongMessageText();
        Assert.assertEquals(errorMessage, "Password too long");

    }


    @Test(priority = 38,dataProvider = "EmailWithSpace",description = "TC 38 WorkEMailLogin -Verify that when OK button is clicked in the Email error message popup, it closes the popup")
    public void InvalidEmailErrorPopUpOKButton(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
        workEmailLoginPage.clickLoginErrorOKButton();
    }

    @Test(priority = 39,dataProvider = "EmailWithSpace",description = "TC 39 WorkEMailLogin -Verify when Need Help? button is clicked in the Email error message pop Up, the app redirects to the Chat Support ")
    public void InvalidEmailErrorPopUpNeedHelpButton(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

        WorkEmailLoginPage workEmailLoginPage = loginScreen.selectWorkEmailLogin();
        workEmailLoginPage.enterEmail(input.get("emailid"));
        WorkEmailPasswordPage workEmailPasswordPage = workEmailLoginPage.clickContinue();
        String emailErrorMessage = workEmailLoginPage.getEmailWrongMessageText();
        Assert.assertEquals(emailErrorMessage, "We could not find this employee id to be registered in our system. Please make sure your Employee ID is correct and registered and login with Employee ID is supported for your organization. If you prefer logging in an alternate way, Please login using Organization name or Email ID.");
        SupportChatPage supportChatPage=workEmailLoginPage.clickLoginErrorNeedHelpButton();
        String salutationSupportMessage = supportChatPage.getSalutationSupportMessage();
        Assert.assertEquals(salutationSupportMessage, "Hello there! Need help? Reach out to us right here, and we'll get back to you as soon as we can!");

    }


    @DataProvider(name = "CorrectCredentials")
    public Object[][] getCorrectCredentials() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//CorrectCredentialsEmailAndPassword.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name ="CorrectEmailAndWrongPassword")
    public Object[][] getCorrectEmailAndWrongPassword() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//CorrectEmailAndWrongPassword.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "EmailInvalidDomain")
    public Object[][] getEmailInvalidDomain() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//EmailInvalidDomain.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }


    @DataProvider(name = "LongEmailMaxCharacterlimt")
    public Object[][] getLongEmailMaxCharacterlimt() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//LongEmailMaxCharacterlimt.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "ShortEmailMinCharacterlimt")
    public Object[][] getShortEmailMinCharacterlimt() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//ShortEmailMinCharacterlimt.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "EmailSpecialCharacters")
    public Object[][] getEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//EmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "PercentageEmailSpecialCharacters")
    public Object[][] getPercentageEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//PercentageEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "FrontSlashEmailSpecialCharacters")
    public Object[][] getFrontSlashEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//FrontSlashEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "BackEmailSpecialCharacters")
    public Object[][] getBackEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//BackEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }


    @DataProvider(name = "PipeEmailSpecialCharacters")
    public Object[][] getPipeEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//PipeEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "CapEmailSpecialCharacters")
    public Object[][] getCapEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//CapEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "OpenSquareBracketEmailSpecialCharacters")
    public Object[][] getOpenSquareBracketEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//OpenSquareBracketEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "ClosedSquareBracketEmailSpecialCharacters")
    public Object[][] getClosedSquareBracketEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//ClosedSquareBracketEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "FullStopEmailSpecialCharacters")
    public Object[][] getFullStopEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//FullStopEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "TagOpenEmailSpecialCharacters")
    public Object[][] getTagOpenEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//TagOpenEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "TagCloseEmailSpecialCharacters")
    public Object[][] getTagCloseEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//TagCloseEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "OpenCurlyBracesEmailSpecialCharacters")
    public Object[][] getOpenCurlyBracesEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//OpenCurlyBracesEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "ClosedCurlyBracesEmailSpecialCharacters")
    public Object[][] getClosedCurlyBracesEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//ClosedCurlyBracesEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }



    @DataProvider(name = "EmailWithSpace")
    public Object[][] getEmailWithSpace() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//EmailWithSpace.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "UpperCaseEmailandPassword")
    public Object[][] getUpperCaseEmailandPassword() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//UpperCaseEmailandPassword.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }


    @DataProvider(name = "LowerCaseEmailandPassword")
    public Object[][] getLowerCaseEmailandPassword() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//LowerCaseEmailandPassword.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "LongPasswordMaxCharacterlimit")
    public Object[][] getLongPasswordMaxCharacterlimit() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//LongPasswordMaxCharacterlimit.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "TildeEmailSpecialCharacters")
    public Object[][] getTildeEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//TildeEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "ExclamationEmailSpecialCharacters")
    public Object[][] getExclamationEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//ExclamationEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "HashEmailSpecialCharacters")
    public Object[][] getHashEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//HashEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "DollarEmailSpecialCharacters")
    public Object[][] getDollarEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//DollarEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "AmpersandEmailSpecialCharacters")
    public Object[][] getAndEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//AmpersandEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "AsteriskEmailSpecialCharacters")
    public Object[][] getStarEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//StarEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "OpenBracketEmailSpecialCharacters")
    public Object[][] getOpenBracketEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//OpenBracketEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "ClosedBracketEmailSpecialCharacters")
    public Object[][] getClosedBracketEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//ClosedBracketEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "UnderscoreEmailSpecialCharacters")
    public Object[][] getUnderscoreEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//UnderscoreEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "HyphenEmailSpecialCharacters")
    public Object[][] getHyphenEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//HyphenEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "EqualEmailSpecialCharacters")
    public Object[][] getEqualEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//EqualEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "GraveEmailSpecialCharacters")
    public Object[][] getGraveEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//GraveEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "PlusEmailSpecialCharacters")
    public Object[][] getPlusEmailSpecialCharacters() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//org//vantagefit//testData//LoginWithWorkEMailTestsData//PlusEmailSpecialCharacters.json");
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }







}



