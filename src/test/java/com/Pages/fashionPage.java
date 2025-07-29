package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Libary;
import com.ReusableFunctions.SeleniumReusable;

public class fashionPage extends Libary {
	public fashionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	SeleniumReusable sr;
	
	@FindBy(xpath="//span[text()='Fashion']")
	WebElement fashionTab;
	
	@FindBy(xpath="//span[@class='_3Pzn-c']//parent::a[text()='Kids']")
	WebElement kidsLink;
	
	@FindBy(xpath="//a[@class='_3490ry' and text()='Girls Dresses']")
	WebElement girlsDressesLink;
	
	@FindBy(xpath="//div[text()='Price -- Low to High']")
	WebElement priceLowToHigh;
	
	
	public void moveFashioLink() {
		sr = new SeleniumReusable(driver);
		sr.mouseHover(fashionTab);
	}
	
	public void moveKidsLink() {
		
		sr.mouseHover(kidsLink);
	}
	
	public void clickGirlsDressesLink() {
		sr.moveToElement(girlsDressesLink);
	}
	
	public void clickPriceLowToHigh() {
		sr.click(priceLowToHigh);
	}
	
}
