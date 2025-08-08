package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.Utilities.threadLocal;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Libary {
    private static final AtomicInteger windowSlotCounter = new AtomicInteger(0);
	
	public void launchApplication() throws FileNotFoundException, IOException {
        // Load configuration from classpath for reliability in parallel runs
        Properties props = new Properties();
        try (InputStream isCtx = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("Properties/config.Property");
             InputStream isCls = isCtx == null ? Libary.class.getClassLoader()
                     .getResourceAsStream("Properties/config.Property") : null) {
            InputStream is = isCtx != null ? isCtx : isCls;
            if (is == null) {
                // Fallback to relative path if running from IDE without test classpath
                try (FileInputStream fis = new FileInputStream(
                        "src\\test\\resources\\Properties\\config.Property")) {
                    props.load(fis);
                }
            } else {
                props.load(is);
            }
        }

        try{
            String browser = props.getProperty("browser");
            String url = props.getProperty("url");
            if (browser == null || browser.isBlank()) {
                throw new IllegalStateException("Missing 'browser' property in config.Property");
            }
            if (url == null || url.isBlank()) {
                throw new IllegalStateException("Missing 'url' property in config.Property");
            }

            WebDriver driverLocal = null;
            switch(browser.toLowerCase()) {
				case "chrome":
					// Code to initialize Chrome driver
                    System.out.println("Launching Chrome browser and navigating to " + url);
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    options.setAcceptInsecureCerts(true);
                    driverLocal = new ChromeDriver();
					break;
				case "edge":
					// Code to initialize Firefox driver
					System.out.println("Launching Firefox browser and navigating to " + url);
					WebDriverManager.edgedriver().setup();
                    driverLocal = new EdgeDriver();
					break;
				default:
					System.out.println("Browser not supported");
			}
            if (driverLocal == null) {
                throw new IllegalStateException("Failed to create WebDriver instance for browser: " + browser);
            }
            threadLocal.setDriver(driverLocal);
            WebDriver driver = threadLocal.getDriver();
            if (driver == null) {
                throw new IllegalStateException("Driver was not initialized correctly");
            }
            // Position and size window to avoid overlap for up to 4 parallel sessions (2x2 tiling)
            try {
                int slot = Math.floorMod(windowSlotCounter.getAndIncrement(), 4);
                java.awt.Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                int tileWidth = Math.max(800, screen.width / 2);
                int tileHeight = Math.max(600, screen.height / 2);
                int col = (slot % 2);
                int row = (slot / 2);
                int posX = col * tileWidth;
                int posY = row * tileHeight;
                driver.manage().window().setSize(new org.openqa.selenium.Dimension(tileWidth, tileHeight));
                driver.manage().window().setPosition(new org.openqa.selenium.Point(posX, posY));
            } catch (Throwable t) {
                System.out.println("Window tiling not applied: " + t.getMessage());
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
            // Best-effort maximize without failing the test in case of CDP/version mismatch
            try {
                // driver.manage().window().maximize();
            } catch (Exception ignore) {
                System.out.println("Window maximize not supported by driver; continuing.");
            }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error launching application: " + e.getMessage());
		}

	}

	public void tearDown() {
		// Code to close the browser
        threadLocal.quitDriver();
	}	
}
