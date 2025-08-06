package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Libary {
	public static WebDriver driver;
	public static Properties props;
	
	public void launchApplication() throws FileNotFoundException, IOException {
		// Code to launch the application
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Properties\\config.Property");
		props = new Properties();
		props.load(fis);

		try{
			String browser = props.getProperty("browser");
			String url = props.getProperty("url");

			switch(browser.toLowerCase()) {
				case "chrome":
					// Code to initialize Chrome driver
					System.out.println("Launching Chrome browser and navigating to " + url);
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "edge":
					// Code to initialize Firefox driver
					System.out.println("Launching Firefox browser and navigating to " + url);
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				default:
					System.out.println("Browser not supported");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error launching application: " + e.getMessage());
		}

	}

	public void tearDown() {
		// Code to close the browser
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed successfully.");
		} else {
			System.out.println("No browser instance found to close.");
		}
	}	
}
