package com.egic.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 

	{
		public static WebDriver launchBrowser(String browserName, String headless, String platformName)
		{
			WebDriver driver = null;
			if (platformName.equalsIgnoreCase("Windows")|| platformName.contains("windows")) 
			{
				if (browserName.equalsIgnoreCase("Chrome")) 
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
				}
				else if (browserName.equalsIgnoreCase("firefox")) 
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
				}
			}
			if (platformName.equalsIgnoreCase("Linux")|| platformName.contains("Ubuntu")) 
			{
				if (browserName.equalsIgnoreCase("Chrome")) 
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
				}
				else if (browserName.equalsIgnoreCase("firefox")) 
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
				}
			}
			if (platformName.equalsIgnoreCase("mac")|| platformName.contains("mac")) 
			{
				if (browserName.equalsIgnoreCase("Chrome")) 
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
				}
				else if (browserName.equalsIgnoreCase("firefox")) 
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
				}
			}
			return driver;
		}
	}

	
	

