package com.egic.webutils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.egic.generic.Driver;
import com.egic.generic.GenericLib;
import com.google.common.io.Files;


public class EgicListeners implements ITestListener, WebDriverEventListener

	{
		public static int executionCount, passCount, failCount, skipCount = 0;
		public static Logger log;
		long startTime;

		public void onStart(ITestContext context)
		{
			startTime=System.currentTimeMillis();
			System.setProperty("logpath", GenericLib.dir+"/reports/logfiles");
			System.setProperty("htmlpath", GenericLib.dir+"/reports/htmlreports");
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			System.setProperty("timestamp", sdf.format(new Date()));
			PropertyConfigurator.configure("log4j.properties");
			PropertyConfigurator.configure("environment.properties");
			log=Logger.getLogger(EgicListeners.class);
			log.info("Suite Execution Starts");
			String platformName = System.getProperty("platform");
			String browserName = System.getProperty("browser");
			String headless = System.getProperty("headless");
			WebDriver driver = BrowserFactory.launchBrowser(browserName, headless, platformName);
			log.info(browserName+" launched in "+platformName+" platform and headless "+headless);
			Driver.setDriver(driver);
		}
		
		public void onFinish(ITestContext context) 
		{
			long stopTime = System.currentTimeMillis();
			double totalTime = (stopTime-startTime)/1000;                 //widening
			log.info("Total suite execution time: "+totalTime+"seconds");
			log.info("Suite Execution Ends");
			Driver.getDriver().close();
			log.info("Browser closed");
			log.info("Total Scripts executed: "+executionCount);
			log.info("Total Scripts passed: "+passCount);
			log.info("Total Scripts skipped: "+skipCount);
			log.info("Total Scripts failed: "+failCount);
		}
		
		public void onTestSuccess(ITestResult result) 
		{
			passCount++;
			log.info(result.getName()+" Script execution pass");
		}
		
		public void onTestFailure(ITestResult result) 
		{
			failCount++;
			log.info(result.getName()+" script Execution failed");
			TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();
			File srcFile= ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(GenericLib.dir+"/screenshots/"+result.getName()+".png");
			
			try 
			{
				Files.copy(srcFile, destFile);
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			log.info("ScreenShot has been taken");
		}
		
		public void onTestSkipped(ITestResult result) 
		{
			skipCount++;
			log.info(result.getName()+" Script execution skipped");
		}
		
		public void onTestStart(ITestResult result) 
		{
			executionCount++;
			log.info(result.getName()+" script execution starts");
		}
		
		public void beforeFindBy(By by, WebElement element, WebDriver driver) 
	    {
			log.info("Finding Element with locator: "+by);
		}
	    
	    public void onException(Throwable t, WebDriver driver) 
	    {
			log.fatal(t.getMessage());
		}
		
		
		public void afterAlertAccept(WebDriver arg0) 
		{
		}
		public void afterAlertDismiss(WebDriver arg0) 
		{
		}
		public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) 
		{
		}
		public void afterClickOn(WebElement arg0, WebDriver arg1) 
		{
		}
		public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) 
		{
		}
		public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) 
		{
		}
		public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) 
		{
		}
		public void afterNavigateBack(WebDriver arg0) 
		{
		}
		public void afterNavigateForward(WebDriver arg0) 
		{
		}
		public void afterNavigateRefresh(WebDriver arg0) 
		{
		}
		public void afterNavigateTo(String arg0, WebDriver arg1) 
		{
		}
		public void afterScript(String arg0, WebDriver arg1) 
		{
		}
		public void afterSwitchToWindow(String arg0, WebDriver arg1) 
		{
		}
		public void beforeAlertAccept(WebDriver arg0) 
		{
		}
		public void beforeAlertDismiss(WebDriver arg0) 
		{
		}
		public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) 
		{
		}
		public void beforeClickOn(WebElement arg0, WebDriver arg1) 
		{
		}
		public <X> void beforeGetScreenshotAs(OutputType<X> arg0) 
		{
		}
		public void beforeGetText(WebElement arg0, WebDriver arg1) 
		{
		}
		public void beforeNavigateBack(WebDriver arg0) 
		{
		}
		public void beforeNavigateForward(WebDriver arg0) 
		{
		}
		public void beforeNavigateRefresh(WebDriver arg0) 
		{
		}
		public void beforeNavigateTo(String arg0, WebDriver arg1) 
		{
		}
		public void beforeScript(String arg0, WebDriver arg1) 
		{
		}
		public void beforeSwitchToWindow(String arg0, WebDriver arg1) 
		{
		}
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
		{
		}
		public void onTestFailedWithTimeout(ITestResult result) 
		{
		}
		
	}

	
