package com.Hooks;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.BaseClass.Libary;
import com.ReusableFunctions.SeleniumReusable;
import com.Utilities.threadLocal;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks extends Libary {
	
	public static Scenario scenario;
	public SeleniumReusable se;
	
	@Before
	public void beforeScenario(Scenario Cucumberscenario) throws FileNotFoundException, IOException {
		
		scenario = Cucumberscenario;
		launchApplication();
	}
	
	@After
	public void cleanUp(Scenario Cucumberscenario) throws IOException {
		se = new SeleniumReusable(threadLocal.getDriver());
		se.attachScreenshot(Cucumberscenario);
		
		tearDown();
		
	}
}
