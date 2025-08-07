package com.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ReusableFunctions.SeleniumReusable;
import com.Utilities.ExcelUtility;

public class searchPage {
    private final WebDriver driver;
    public SeleniumReusable re;
    public searchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	

	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchText;
	
	@FindBy(xpath="//html[contains(@class,'en-fonts-loaded')]")
	WebElement homePage;
	
	@FindBy(xpath="//div[contains(@class,'JxFEK3 _48O0EI')]")
	WebElement searchResult;
	
	@FindBy(className="_30XB9F")
	WebElement closePopUp;
	
	@FindBy(xpath="//div[contains(@class,'yKfJKb row')]")
	List<WebElement> searchResultsList;
	
	@FindBy(xpath="(//div[contains(@class,'yKfJKb row')])[3]")
	WebElement thirdResult;
	
	
	public void search(String txt) {
		 re= new SeleniumReusable(driver);
		re.EnterValue(searchText, txt);
	}
	
	public void clickSearch() {
		searchText.sendKeys(Keys.ENTER);
	}
	
	public void homeScreen() {
		System.out.println(homePage.isDisplayed());
	}
	
	public void result() {
		System.out.println(searchResult);
		System.out.println(driver.getTitle());
	}
	
	public void handlePopUp() {
		try {
			closePopUp.click();
		} catch (Exception e) {
			System.out.println("Popup is not present");
		}
	}
	
	public void printResults() {
		re.multipleGetText(searchResultsList);
	}
	
	public void getThirdResult() {
		re.getValue(thirdResult);
	}
	
	public void searchWithExcel() throws IOException, InterruptedException {
		ExcelUtility ExUtils = new ExcelUtility(driver);
		re = new SeleniumReusable(driver);
		for(int i=1;i<4;i++) {
			String value = ExUtils.readExcelcolumn("Data",i,0);
			System.out.println("Search value from Excel: " + value);
			re.EnterValue(searchText, value);
			searchText.sendKeys(Keys.ENTER);
			re.waits();
			re.navigeteBack();
			
			if(homePage.isDisplayed()) {
				ExUtils.writeExcelcolumn2("Data", i, 1, "Pass");
			}else {
				ExUtils.writeExcelcolumn2("Data", i, 1, "Fail");
			}
			
		}
	}
	
	
	
	
	
	
	
}
