package com.Hooks;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.BaseClass.Libary;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class hooks extends Libary {
	
	public static Scenario scenario;
	public SeleniumReusable se;
	
//	@Before
	public void beforeScenario(Scenario Cucumberscenario) throws FileNotFoundException, IOException {
		
		scenario = Cucumberscenario;
		launchApplication();
	}
	
	@After
	public void cleanUp(Scenario Cucumberscenario) throws IOException {
		se = new SeleniumReusable(driver);
		se.attachScreenshot(Cucumberscenario);
		
		tearDown();
		
	}
}
