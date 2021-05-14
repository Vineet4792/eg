package com.egic.features;

import org.openqa.selenium.WebDriver;

import com.egic.steps.ClaimsSteps;

import io.qameta.allure.Story;

public class GHIClaimsFeatures 
{
			ClaimsSteps cs;
			
			public GHIClaimsFeatures (WebDriver driver)
			{
				cs= new ClaimsSteps(driver);
			}
			
			@Story("Performing Claim on GHI Policy")
			public void claims() throws Exception
			{
				cs.clickonClaimsLink();
				cs.clickonTPAClaimupload();
				cs.clickonIndividualRadioBtn();
				cs.selectclaimuploadfile();
				cs.runJobBTnClick();
			}
	
	
}
