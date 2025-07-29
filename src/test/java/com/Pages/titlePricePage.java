package com.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Libary;
import com.ReusableFunctions.SeleniumReusable;

public class titlePricePage extends Libary {
	
	public titlePricePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SeleniumReusable sr;
	
	@FindBy(xpath= "//input[@name='q']")
	WebElement searchText;
	
	@FindBy(className = "WKTcLC")
	List<WebElement> searchResult;
	
	@FindBy(className = "Nx9bqj")
	List<WebElement> priceText;
	
	public void enterSearch(String search) {
		sr = new SeleniumReusable(driver);
		sr.EnterValue(searchText, search);
		
	}
	
	public void clickSearch() {
		searchText.sendKeys(Keys.ENTER);
	}
	
	public void printSearchDetails() {
		
		for(int i=0;i<searchResult.size();i++) {
			System.out.println("*****************************");
			System.out.println("Title: " + searchResult.get(i).getText());
			System.out.println("Price: " + priceText.get(i).getText());
		}
		
	}
	
	
	
	
	
	
}
