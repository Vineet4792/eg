package com.egic.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.egic.features.GHIClaimsFeatures;
import com.egic.features.GHIFollowerPolicyFeatures;
import com.egic.features.GHILeaderPolicyFeatures;
import com.egic.features.LoginFeatures;
import com.egic.generic.Driver;
import com.egic.webutils.EgicListeners;

public class BaseAbstractTest 
{
	
		//we are using webdrivereventlistener & we have to register
		
		public static EventFiringWebDriver driver;   
		
		LoginFeatures lf;
		GHIClaimsFeatures cf;
		GHILeaderPolicyFeatures lpf;
		GHIFollowerPolicyFeatures fpf;
		
		//@BeforeSuite //1 time registration for 1 suite file
		
		@BeforeClass
		public void setUp()
		{
			driver=new EventFiringWebDriver(Driver.getDriver());
			driver.register(new EgicListeners());
			driver.manage().window().maximize();
			lf=new LoginFeatures(driver);
			
		}
		
		@BeforeMethod
		public void preCondition()
		{
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(System.getProperty("url"));
		}
		
		@AfterClass
		public void tearDown()
		{
			driver.unregister(new EgicListeners());
			driver.close();
		}

	}

	
	

