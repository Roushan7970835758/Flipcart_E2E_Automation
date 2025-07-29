package com.ReusableFunctions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.BaseClass.Libary;

import io.cucumber.java.Scenario;

public class SeleniumReusable extends Libary {

    protected WebDriver driver;
    Actions action;
    public SeleniumReusable(WebDriver driver) {
        // Constructor to initialize the parent class
        this.driver = driver;
    }

    public void EnterValue(WebElement element, String text) {
      
            element.sendKeys(text);
        
    }

    public void click(WebElement element) {
       
            element.click();
        
    }

    public void gettitle() {
            System.out.println(driver.getTitle());
       
    }


   
    public void multipleGetText(List<WebElement> elements) {
		for (WebElement element : elements) {
			
				System.out.println(element.getText());
			
		}
    }
    
    public void getValue(WebElement element) {
		try {
			System.out.println(element.getText());
		} catch (Exception e) {
			System.out.println("Could not get value from element: " + e.getMessage());
		}
	}
    
    public void dorpdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value); 
		
	}
    
    public void scrollDown(WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);",element);
    	js.executeScript("window.scrollBy(0,-100);"); // Scroll down by 100 pixels
    }
    
    public void waits() throws InterruptedException {
    	Thread.sleep(2000);
    }
    
    public void mouseHover(WebElement element) {
    	 action = new Actions(driver);
    	action.moveToElement(element).build().perform();
    }
    
    public void moveToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
    
    public void screenshot(String path) throws IOException{
        TakesScreenshot ts = ((TakesScreenshot) driver);
        File source = ts.getScreenshotAs(OutputType.FILE);

        
            FileUtils.copyFile(source, new File(path));
            System.out.println("Screenshot taken and saved at " + path);
        
    }
    
    public void switchWindow(WebElement element) {
		
    	String parentWindow = driver.getWindowHandle();
//    	element.click();
    	
    	Set<String> allWindows = driver.getWindowHandles();
    	
    	for(String window: allWindows) {
    		driver.switchTo().window(window);
    		System.out.println(window);
    	}
    	
	}
    
    
    public void attachScreenshot(Scenario CucumberScenario) {
    	
    	final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    	
    	CucumberScenario.attach(screenshot, "image/png", "flipkartAutomation");
    	
    }

	
}



















