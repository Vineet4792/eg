package com.egic.scripts;

import org.testng.annotations.Test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;

public class LoginTest extends BaseAbstractTest
{
	  @Test
	  @Severity(SeverityLevel.BLOCKER)
	  @Description("Performing Claims On GHI Policy")
	  public void validLogin() throws Exception
	  {
//		lf.login("vineet","India@123");  
		  lf.login("n", "12345");
	  }
	}


