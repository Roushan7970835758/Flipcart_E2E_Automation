package com.TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features" , glue = {"com.Stepdefenitions","com.Hooks"},
monochrome= true, plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },tags="@Regression")
public class Runner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
	    return super.scenarios();
	}
	
	// This class is used to run the Cucumber tests with JUnit
	// The @CucumberOptions annotation specifies the features and glue code
	// monochrome=true makes the console output more readable
	// plugin specifies the reporting format, in this case, ExtentReports
	// tags can be used to filter which scenarios to run based on tags defined in the feature files
	
	

}
