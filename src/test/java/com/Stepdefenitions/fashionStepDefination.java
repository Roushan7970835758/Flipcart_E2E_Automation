package com.Stepdefenitions;

import com.BaseClass.Libary;
import com.Pages.fashionPage;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class fashionStepDefination extends Libary {
	
	fashionPage fp;
	SeleniumReusable sr;
	
	
	@Given("User to move the Fashion link")
	public void user_to_move_the_fashion_link() {
	    // Write code here that turns the phrase above into concrete actions
	    sr = new SeleniumReusable(driver);
	    System.out.println("before clicking fashion link");
	    sr.gettitle();
	    fp = new fashionPage(driver);
	    fp.moveFashioLink();
	    
	    
	}

	@When("Cursor to move to the Kids link")
	public void cursor_to_move_to_the_kids_link() {
	    // Write code here that turns the phrase above into concrete actions
	    fp.moveKidsLink();
	}

	@When("Move to girls dress and click")
	public void move_to_girls_dress_and_click() {
	    // Write code here that turns the phrase above into concrete actions
	    fp.clickGirlsDressesLink();
	}

	@When("Click the price high to low link")
	public void click_the_price_high_to_low_link() {
	    // Write code here that turns the phrase above into concrete actions
	   fp.clickPriceLowToHigh();
	}

	@Then("It should dispay the relevent details and get the title")
	public void it_should_dispay_the_relevent_details_and_get_the_title() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("after clicking fashion link");
	    sr.gettitle();
	}
}
