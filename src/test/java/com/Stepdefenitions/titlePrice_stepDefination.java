package com.Stepdefenitions;

import com.BaseClass.Libary;
import com.Pages.titlePricePage;
import com.Utilities.threadLocal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class titlePrice_stepDefination extends Libary {

	titlePricePage tp;
	@Given("Enter the search text in the search field")
	public void enter_the_search_text_in_the_search_field() {
        tp = new titlePricePage(threadLocal.getDriver());
	    tp.enterSearch("Shirt");
	}

	@When("Click the search icon")
	public void click_the_search_icon() {
	    // Code to click the search icon
		tp.clickSearch();
	}

	@Then("It should display the search result and get the title and price")
	public void it_should_display_the_search_result_and_get_the_title_and_price() {
	    // Code to extract and print the title and price from the search results
		
		tp.printSearchDetails();
	}

}
