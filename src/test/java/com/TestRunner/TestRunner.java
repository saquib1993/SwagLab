package com.TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		   //path of feature file
		   features = "Features/login.feature",
		   //path of step definition file
		   glue = {"com.StepDefination"},
		   plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
					"junit:target/cucumber-reports/Cucumber.xml",
					"html:target/cucumber-reports/Cucumber.html"},
		   monochrome = true
			
		   )
public class TestRunner extends AbstractTestNGCucumberTests {

	 @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
