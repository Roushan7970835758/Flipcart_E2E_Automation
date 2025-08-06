package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Libary;
import com.ReusableFunctions.SeleniumReusable;

public class uptoAddCartPage extends Libary {
	
	public uptoAddCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	SeleniumReusable re;

	@FindBy(xpath="//a[@title='Login']")
	WebElement loginLink;
	
	@FindBy(xpath="//a[@title='Flipkart Plus Zone']")
	WebElement flipkartPlusZone;
	
	@FindBy(xpath = "//span[contains(text(),'Home & Furniture')]")
	WebElement homeFurnitureLink;
	
	@FindBy(xpath = "//a[@title='Wall Lamp']")
	WebElement wallLampLink;
	
	@FindBy(className = "slAVV4")
	WebElement clickOneLamp;
	
	@FindBy(id = "pincodeInputId")
	WebElement pincodeInput;
	
	@FindBy(xpath = "//input[@id='pincodeInputId']//following::span")
	WebElement checkPincodeLink;
	
	public void hoverLoginLink() {
		re = new SeleniumReusable(driver);
		re.mouseHover(loginLink);
	}
	
	public void clickFlipkartPlusZone() {
		
		re.moveToElement(flipkartPlusZone);
	}
	
	public void hoverHomeFurnitureLink() {
		re.mouseHover(homeFurnitureLink);
	}
	
	public void clickWallLampLink() {
		re.moveToElement(wallLampLink);
	}
	
	public void clickOneResult() {
		re.click(clickOneLamp);
	}
	
	public void enterPincode(String pincode) throws InterruptedException {
		
		re.switchWindow(clickOneLamp);
		re.waits();
		pincodeInput.sendKeys(pincode);
	}
	
	public void clickCheckPincode() {
		re.click(checkPincodeLink);
	}
}
















