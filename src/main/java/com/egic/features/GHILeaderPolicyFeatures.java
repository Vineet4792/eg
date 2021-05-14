package com.egic.features;

import org.openqa.selenium.WebDriver;

import com.egic.steps.LeaderPolicySteps;

import io.qameta.allure.Story;

public class GHILeaderPolicyFeatures 
{
	
	LeaderPolicySteps lps;
	public GHILeaderPolicyFeatures (WebDriver driver)
	{
		lps = new LeaderPolicySteps(driver);
	}
	
	@Story("Creating A Leader Policy With Members on GHI Product")
	public void leaderPolicy() throws Exception
	{
		lps.clickOnInwardLink();
		lps.clickonInwardBucket();
		lps.viewmanageinwardlink();
		lps.addnewBtn();
		lps.transactionType();
		lps.selectClient();
		lps.selectingLOB();
		lps.selectingProduct();
		lps.policyVariant();
		lps.buisnessSource();
		lps.policyTenure_ProposalAmt();
		lps.submitBtnDCN();
		lps.firstQC();
		lps.dmsNO();
		lps.processedStatus();
		lps.updateBtn();
		lps.proposalCreation();
		lps.proceedforProposal();
		lps.buisnessshare();
		lps.saveandnextclickbtn();
		lps.memberdataandpacoverselect();
		lps.insuredrelation();
		lps.netPremium();
		lps.groupDefinition();
		lps.selectcovers();
		lps.selectTPA();
		lps.memberUpload();
		lps.redirecttoIP();
		lps.perpersonpremium();
		lps.ratingpage();
		lps.premiumpage();
		lps.reinsurance();
		lps.ps();
		lps.uw();
		lps.collectionTagging();
		lps.createdPolicy();
	}
	
	
}

