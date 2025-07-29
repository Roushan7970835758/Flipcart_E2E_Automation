package com.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Libary;
import com.ReusableFunctions.SeleniumReusable;

public class multipleSearch extends Libary {

	public multipleSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	SeleniumReusable sr;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchField;
	
	public void enterSearch(String searchText) {
		sr = new SeleniumReusable(driver);
		sr.EnterValue(searchField, searchText);
		sr.click(searchField); 
	}
	
	public void clickSearch() {
		searchField.sendKeys(Keys.ENTER);
	}

}
