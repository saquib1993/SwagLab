package com.StepDefination;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExtentReportManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    public static WebDriver driver;
    private static ExtentReports extent = ExtentReportManager.getInstance();
    public static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
    	 if (scenario.isFailed()) {
             test.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
             File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + scenario.getName() + ".png";
             try {
                 FileHandler.copy(srcFile, new File(screenshotPath));
                 Hooks.test.addScreenCaptureFromPath(screenshotPath, "Failed Step Screenshot");
             } catch (IOException e) {
                 e.printStackTrace();
         } }
    	 else {
             test.log(Status.PASS, "Scenario Passed: " + scenario.getName());
         }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (extent != null) {
            extent.flush();
        }
    }
}
