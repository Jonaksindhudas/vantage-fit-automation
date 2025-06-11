package org.vantagefit.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;

public class ExtentReporterNG {

    static ExtentReports extent;
    public static  ExtentReports getReporterObject()
    {

        String path = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Vantage Fit Test Cases Results");
        reporter.config().setDocumentTitle("Vantage Fit Test Results");
        try {
            reporter.loadXMLConfig(System.getProperty("user.dir") + "//reports//extentConfig.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Jonak");

        return extent;

    }
}
