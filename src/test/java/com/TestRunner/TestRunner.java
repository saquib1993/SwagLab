package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		   //path of feature file
		   features = "D:\\Selenium\\SwagLab\\Features\\login.feature",
		   //path of step definition file
		   glue = {"com.StepDefination"}
		   )
public class TestRunner {

}
