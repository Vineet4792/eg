package com.egic.features;

import org.openqa.selenium.WebDriver;

import com.egic.steps.FollowerPolicySteps;
import com.egic.steps.LeaderPolicySteps;

import io.qameta.allure.Story;

public class GHIFollowerPolicyFeatures 
{
	FollowerPolicySteps fps;
	public GHIFollowerPolicyFeatures  (WebDriver driver)
	{
		fps = new FollowerPolicySteps(driver);
	}
	
	@Story("Creating A Follower Policy Without Members on GHI Product")
	public void followerPolicy() throws Exception
	{
		
		
		
	}
}
	
	
	

