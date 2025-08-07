package com.Stepdefenitions;

import com.BaseClass.Libary;
import com.Pages.filterPage;
import com.ReusableFunctions.SeleniumReusable;
import com.Utilities.threadLocal;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class filter_stepDefination extends Libary {
    filterPage fp;
    SeleniumReusable sr;
    
    

	@And("Select Minimum and Maximum Amount")
	public void select_minimum_and_maximum_amount() throws InterruptedException {
        fp = new filterPage(threadLocal.getDriver());
        sr = new SeleniumReusable(threadLocal.getDriver());
	
	    fp.selectMinAmount("10000");
	    sr.waits();
	    fp.selectMaxAmount("Max");
	    sr.waits();
	}

	@And("Select the Brand")
	public void select_the_brand() throws InterruptedException {
	    // TODO: Implement step
		
		fp.selectBrand();
		 sr.waits();
	}

	@And("Select the Ram")
	public void select_the_ram() throws InterruptedException {
	    // TODO: Implement step
		fp.selectRam();
		sr.waits();
		
	}

	@And("Select the Battery Capacity")
	public void select_the_battery_capacity() throws InterruptedException {
	    // TODO: Implement step
		fp.selectBatteryCapacity();
		sr.waits();
	}

	@When("It should display the Relevant result")
	public void it_should_display_the_relevant_result() {
	    fp.searchPageVarify();
	}
}
