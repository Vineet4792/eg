package com.egic.scripts;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LeaderPolicyTest extends BaseAbstractTest
{
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Description("Creating Leader Policy On GHI Product")
	public void leaderPolicy() throws Exception
	{
		lpf.leaderPolicy();
	}
		
}

