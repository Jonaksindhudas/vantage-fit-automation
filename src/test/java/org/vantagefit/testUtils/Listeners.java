package org.vantagefit.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.vantagefit.utils.AppiumUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class    Listeners extends AppiumUtils implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReporterObject();
    AppiumDriver driver;
    @Override
    public void onTestStart(ITestResult result)
    {
        test = extent.createTest(result.getMethod().getDescription());
        test.log(Status.INFO,"Lauching Vantage Fit App");
        test.info("Test case: " + result.getMethod().getDescription());
        Object[] parameters = result.getParameters();
        if (parameters != null && parameters.length > 0) {
            for (Object parameter : parameters) {
                if (parameter instanceof HashMap) {
                    // If parameter is a HashMap (from data provider)
                    HashMap<String, String> dataMap = (HashMap<String, String>) parameter;
                    for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                        test.info("Test Data: " + entry.getKey() + " - " + entry.getValue());
                    }
                }
            }
        }



    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        Throwable throwable = result.getThrowable();
        String errorMessage = throwable.getMessage();

        // Check if the failure is due to an assertion error
        if (errorMessage.contains("expected") && errorMessage.contains("but found")) {
            // If it's an assertion error, log expected and actual values
            String expected = errorMessage.split("expected \\[")[1].split("] but found")[0];
            String actual = errorMessage.split("but found \\[")[1].split("]")[0];
            test.fail("Expected: " + expected);
            test.fail("Actual: " + actual);
            test.fail("Test Failed - AssertionError");
        } else {
            // If it's a general error, log the error message
            test.fail("Test Failed - General Error: " + errorMessage);
        }

        try {
            // Add a screenshot if available
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        String skipReason = result.getThrowable() != null ? result.getThrowable().getMessage() : "No reason provided";
        if (test != null) {
            test.log(Status.FAIL, "Test Skipped: " + skipReason);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context)
    {

    }

    @Override
    public void onFinish(ITestContext context)
    {
        if (test != null) {
            test.log(Status.PASS,"Test Completed");
        }
        extent.flush();
    }



}
