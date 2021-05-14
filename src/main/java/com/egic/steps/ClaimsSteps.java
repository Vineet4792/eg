package com.egic.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.egic.pageobjects.ClaimsPage;

import io.qameta.allure.Step;

public class ClaimsSteps 
{
	WebDriver driver;
	ClaimsPage cp;
	
	public ClaimsSteps(WebDriver driver)
	{
		this.driver=driver;
		cp=new ClaimsPage();
	}
	
	@Step("Click on Claims link")
	public void clickonClaimsLink()
	{
		driver.findElement(By.xpath(cp.claimslink)).click();
	}
	
	@Step("Click on TPA Claim Upload")
	public void clickonTPAClaimupload()
	{
		driver.findElement(By.xpath(cp.tpaclaimupload)).click();
	}
	
	@Step("Click on Individual Radio Button")
	public void clickonIndividualRadioBtn()
	{
		driver.findElement(By.xpath(cp.individualradiobtn)).click();
	}
	
	@Step("Selecting Claim Claim Uploader File and uploading it")
	public void selectclaimuploadfile()
	{
		driver.findElement(By.xpath(cp.choosefilebtn)).sendKeys(".testdata\\IH_ClaimUpload_3_GHI.xlsx");
		//driver.findElement(By.xpath(cp.selectclaimuploadfile)).sendKeys("");;
		driver.findElement(By.xpath(cp.uploadclaimfiles)).click();
	}
	@Step("Clicking on Run Job Button")
	public void runJobBTnClick()
	{
		driver.findElement(By.xpath(cp.runJobBtn)).click();
	}
	
	
}
