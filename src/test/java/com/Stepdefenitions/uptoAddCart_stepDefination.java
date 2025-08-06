package com.Stepdefenitions;

import java.io.IOException;

import com.BaseClass.Libary;
import com.Pages.uptoAddCartPage;
import com.ReusableFunctions.SeleniumReusable;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class uptoAddCart_stepDefination extends Libary{

	uptoAddCartPage up;
	SeleniumReusable re;
	@Given("User can move to the login link")
	public void user_can_move_to_the_login_link() {
	    // Code to move to the login link
		up = new uptoAddCartPage(driver);
		up.hoverLoginLink();
	}

	@Then("User can click the flipkart plus zone")
	public void user_can_click_the_flipkart_plus_zone() {
	    // Code to click the Flipkart Plus zone
		up.clickFlipkartPlusZone();
	}

	@And("Mouse move to the Home&Furniture link")
	public void mouse_move_to_the_home_furniture_link() {
	    // Code to move mouse to Home & Furniture link
		up.hoverHomeFurnitureLink();
	}

	@And("Going to click the wall lamp")
	public void going_to_click_the_wall_lamp() {
	    // Code to click the wall lamp
		up.clickWallLampLink();
	}

	@And("Scroll down the page and click one particular result")
	public void scroll_down_the_page_and_click_one_particular_result() {
	    // Code to scroll and click a result
		
		up.clickOneResult();
	}

	@And("Enter delivery pincode and click the check link")
	public void enter_delivery_pincode_and_click_the_check_link() throws InterruptedException {
	    // Code to enter pincode and click check
		up.enterPincode("700156");
	}

	@Then("Pincode should be checked and displayed and verify the titles")
	public void pincode_should_be_checked_and_displayed_and_verify_the_titles() throws IOException {
	    // Code to verify pincode and titles
		up.clickCheckPincode();
		re = new SeleniumReusable(driver);
		re.gettitle();
		
		re.screenshot("src\\test\\resources\\Screenshots\\uptoAddCart.png");
		
	}
}
