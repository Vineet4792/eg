package com.egic.scripts;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class GHIClaimsTest extends BaseAbstractTest
{
	@Test
	  @Severity(SeverityLevel.BLOCKER)
	  @Description("Performing Claims On GHI Policy")
	  public void ghiClaim() throws Exception
	  {
		 cf.claims();
	  }
	
}
