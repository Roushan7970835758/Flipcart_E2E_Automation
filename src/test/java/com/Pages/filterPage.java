package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseClass.Libary;
import com.ReusableFunctions.SeleniumReusable;

public class filterPage extends Libary{
	
	public filterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public SeleniumReusable sr;
	
	@FindBy(className="Gn+jFg")
	WebElement minAmount;
	
	@FindBy(xpath="(//select[@class='Gn+jFg'])[2]")
	WebElement maxAmount;
	
	@FindBy(xpath="//div[@class='_6i1qKy' and contains(text(),'Apple')]")
	WebElement brand;
	
	@FindBy(xpath="//div[contains(@class,'fxf7w6') and contains(text(),'RAM')]//ancestor::section//div[@class='_6i1qKy' and contains(text(),'1GB and Below')]")
	WebElement ram;
	
	@FindBy(xpath="//div[contains(@class,'fxf7w6 rgHxCQ') and text()='Battery Capacity' ]")
	WebElement batteryArrow;
	
	@FindBy(xpath="//input[@type='checkbox']//following-sibling::div[text()='4000 - 4999 mAh']")
	WebElement batteryCapacity;
	
	@FindBy(xpath="//div[@class='KzDlHZ' and contains(text(),'Apple')]")
	WebElement firstProduct;
	
	public void selectMinAmount(String amount) {
		sr = new SeleniumReusable(driver);
		sr.dorpdown(minAmount,amount);
	}
	
	public void selectMaxAmount(String amount) {
		sr.dorpdown(maxAmount,amount);
	}
	
	public void selectBrand() {
		sr.click(brand);
	}
	
	public void selectRam() throws InterruptedException {
		sr.scrollDown(ram);
		sr.click(ram);
	
	}
	
	public void selectBatteryCapacity() throws InterruptedException {
		sr.scrollDown(batteryArrow);
		
		sr.click(batteryArrow);
		sr.click(batteryCapacity);
		sr.scrollDown(batteryArrow);
	}
	
	public void searchPageVarify() {
	  Assert.assertEquals(firstProduct.isDisplayed(), true);
	}
	

}




















