package com.Stepdefenitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.BaseClass.Libary;
import com.Pages.searchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchMobile_TC extends Libary {
	searchPage sp;
	String searchTxt = "Apple";
	@Given("Launch the Flipkart Application")
	public void launch_the_flipkart_application() throws FileNotFoundException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		launchApplication();
	}

	@When("Close the popup")
	public void close_the_popup() {
	    // Write code here that turns the phrase above into concrete actions
		sp = new searchPage(driver);
		sp.handlePopUp();
	}

	@Then("It should Navigate to the Home page")
	public void it_should_navigate_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	 
	    sp.homeScreen();
	}

	@Given("User enter the Text in the Search field")
	public void user_enter_the_text_in_the_search_field() {
	    // Write code here that turns the phrase above into concrete actions
	   sp.clickSearch();
	   sp.search(searchTxt);
	}

	@When("Click the search button")
	public void click_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	   sp.result();
	   sp.clickSearch();
	}

	@Then("It should navigate to the search result page and display the relevent details")
	public void it_should_navigate_to_the_search_result_page_and_display_the_relevent_details() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Then("Extract the Results and print in console")
	public void extract_the_results_and_print_in_console() {
	    // Write code here that turns the phrase above into concrete actions
	    sp.result();
	}

	@Then("Print the Third result and keep it in the console")
	public void print_the_third_result_and_keep_it_in_the_console() {
	    // Write code here that turns the phrase above into concrete actions
	   sp.getThirdResult();
	}
	

	
	

}
