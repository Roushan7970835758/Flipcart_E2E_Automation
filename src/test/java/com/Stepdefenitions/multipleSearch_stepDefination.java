package com.Stepdefenitions;

import java.io.IOException;

import com.BaseClass.Libary;
import com.Pages.multipleSearch;
import com.ReusableFunctions.SeleniumReusable;
import com.Utilities.threadLocal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class multipleSearch_stepDefination extends Libary {

	multipleSearch ms;
	SeleniumReusable sr;

@Given("Enter the {string} in the search field")
public void enter_the_in_the_search_field(String string) {
    // Write code here that turns the phrase above into concrete actions
   ms = new multipleSearch(threadLocal.getDriver());
   ms.enterSearch(string);
}

@When("click the search button")
public void click_the_search_button() {
    // Write code here that turns the phrase above into concrete actions
   ms.clickSearch();
}

@Then("It should navigate to the next page and display the corresponding pa")
public void it_should_navigate_to_the_next_page_and_display_the_corresponding_pa() throws IOException {
    // Write code here that turns the phrase above into concrete actions
    sr = new SeleniumReusable(threadLocal.getDriver());
    sr.gettitle();
    sr.screenshot("src\\test\\resources\\Screenshots\\multipleSearch.png");
}


}
