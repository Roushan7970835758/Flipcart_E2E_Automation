package com.Stepdefenitions;

import java.io.IOException;

import com.BaseClass.Libary;
import com.Pages.searchPage;
import com.ReusableFunctions.SeleniumReusable;
import com.Utilities.threadLocal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchWithExcel_stepDefination extends Libary {
	searchPage sp;
	SeleniumReusable re;
	@Given("Enter Search Text In the Search Field")
	public void enterSearchText() throws IOException, InterruptedException {
         sp = new searchPage(threadLocal.getDriver());
	     sp.searchWithExcel();
	}

	@When("Click search Icon")
	public void clickSearchIcon() throws IOException {
	    // Code to click the search icon
        re = new SeleniumReusable(threadLocal.getDriver());
		re.screenshot("src\\test\\resources\\Screenshots\\searchPage.png");
	}

	@Then("It Should Display The Relevent Result")
	public void verifyRelevantResult() {
	    // Code to verify relevant results are displayed
		re.gettitle();
	}

}
