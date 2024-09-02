package com.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		   //path of feature file
		   features = "D:\\Selenium\\SwagLab\\Features\\login.feature",
		   //path of step definition file
		   glue = {"com.StepDefination"},
		   plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
					"junit:target/cucumber-reports/Cucumber.xml",
					"html:target/cucumber-reports/Cucumber.html"},
		   monochrome = true
			
		   )
public class TestRunner extends AbstractTestNGCucumberTests {

}
