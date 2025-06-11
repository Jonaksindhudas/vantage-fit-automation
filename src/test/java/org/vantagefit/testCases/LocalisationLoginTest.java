package org.vantagefit.testCases;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.vantagefit.pageObjects.android.WorkEmailLoginPage;
import org.vantagefit.pageObjects.android.WorkEmailPasswordPage;
import org.vantagefit.pageObjects.android.AgreementPage;
import org.vantagefit.testUtils.AndroidBaseTest;
import org.vantagefit.utils.AndroidActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class LocalisationLoginTest extends AndroidBaseTest {
    private AndroidDriver driver;
    private String email;
    private String password;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // Set language and locale capabilities
        Map<String, String> languageCapabilities = new HashMap<>();
        languageCapabilities.put("language", "es");
        languageCapabilities.put("locale", "ES");
        
        // Initialize driver with Spanish language
        driver = ConfigureAppium(languageCapabilities);
        
        // Load test data
        loadTestData();
    }

    private void loadTestData() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/test/java/org/vantagefit/testData/LoginWithWorkEMailTestsData/CorrectCredentialsEmailAndPassword.json"));
            JSONObject testData = (JSONObject) jsonArray.get(0);
            
            email = (String) testData.get("emailid");
            password = (String) testData.get("password");
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }

    @Test
    public void testSpanishLoginFlow() {
        try {
            // Initialize page objects
            WorkEmailLoginPage workEmailLoginPage = new WorkEmailLoginPage(driver);
            WorkEmailPasswordPage workEmailPasswordPage = new WorkEmailPasswordPage(driver);
            AgreementPage agreementPage = new AgreementPage(driver);

            // Step 1: Enter email and continue
            workEmailLoginPage.enterEmail(email);
            workEmailLoginPage.clickContinue();
            
            // Step 2: Enter password and continue
            workEmailPasswordPage.enterPassword(password);
            workEmailPasswordPage.clickSignIn();
            
            // Step 3: Verify agreement page elements
            agreementPage.verifyAgreementElements();
            
            // Log all text elements for verification
            System.out.println("=== Spanish Text Elements ===");
            System.out.println("Program Name: " + agreementPage.getProgramName());
            System.out.println("Agree Button Displayed: " + agreementPage.isAgreeButtonDisplayed());
            System.out.println("Disagree Button Displayed: " + agreementPage.isDisagreeButtonDisplayed());
            
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e;
        }
    }
} 