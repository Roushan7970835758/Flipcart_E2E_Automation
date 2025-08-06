package com.Pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Libary;
import com.ReusableFunctions.SeleniumReusable;
import com.Utilities.ExcelUtility;

public class searchExcelPage extends Libary {
	ExcelUtility ExUtils;
	SeleniumReusable re;
	public searchExcelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchText;
	
	@FindBy(xpath="//html[contains(@class,'en-fonts-loaded')]")
	WebElement homePage;
	
	public void searchWithExcel() throws IOException, InterruptedException {
		 ExUtils = new ExcelUtility(driver);
		
		for(int i=1;i<7;i++) {
			re.EnterValue(searchText, ExUtils.readExcelcolumn("Data",i,0));
			searchText.sendKeys(Keys.ENTER);
			re.waits();
			if(homePage.isDisplayed()) {
				ExUtils.writeExcelcolumn("Data", i, 1, "Pass");
			}else {
				ExUtils.writeExcelcolumn("Data", i, 1, "Fail");
			}
			re.navigeteBack();
		}
	}
}
