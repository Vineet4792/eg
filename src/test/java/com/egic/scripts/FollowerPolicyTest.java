package com.egic.scripts;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class FollowerPolicyTest extends BaseAbstractTest
	 {
	 	@Test
	 	@Severity(SeverityLevel.BLOCKER)
	 	@Description("Creating Follower Policy On GHI Product")
	 	public void followerPolicy() throws Exception
	 	{
	 		fpf.followerPolicy();
	 	}
	
	
	
}
