package com.egic.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.egic.pageobjects.FollowerPolicyPage;

import io.qameta.allure.Step;

public class FollowerPolicySteps 
{
	WebDriver driver;
	FollowerPolicyPage fpp;
	
	public FollowerPolicySteps (WebDriver driver)
	{
		this.driver=driver;
		fpp= new FollowerPolicyPage();
	}
	
	@Step("Click on Inward link")
	public void clickOnInwardLink()
	{
		driver.findElement(By.linkText(fpp.inwardlink)).click();
	}
	
	@Step("Click on Inward link From option Bucket")
	public void clickonInwardBucket()
	{
		driver.findElement(By.linkText(fpp.inwardbucket)).click();
	}
	
	@Step("Click on View/Manage inward Link")
	public void viewmanageinwardlink()
	{
		driver.findElement(By.linkText(fpp.viewmanageinward)).click();
	}
	
	@Step("Clicking on Add New Button")
	public void addnewBtn()
	{
		driver.findElement(By.linkText(fpp.addNewBtn)).click();
	}
	
	@Step("Selecting Transaction Type As *POLICY*")
	public void transactionType() 
	{
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlTransactionType")));
		sel.selectByVisibleText("Policy");
	}
	
	@Step("Selecting Client From the previously Made Client")
	public void selectClient() throws InterruptedException
	{
		driver.findElement(By.xpath(fpp.clientsearchBtn)).click();
		driver.switchTo().frame(driver.findElement(By.id("ctl00_PageBodyControls_Iframe2")));
		driver.findElement(By.xpath("//input[@id='TxtSearchFor']")).sendKeys("a");
		driver.findElement(By.xpath("(//img[@alt='Select '])[8]")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}
	
	@Step("Selecting LOB as *Health*")
	public void selectingLOB() throws InterruptedException
	{
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlLOBCode")));
		sel.selectByVisibleText("Health");
		Thread.sleep(3000);
	}
	
	@Step("Selecting Product based on Name as Group Health Insurance(4211)")
	public void selectingProduct() throws InterruptedException
	{
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlProductNameCode")));
		sel.selectByVisibleText("Group Health Insurance(4211)");
		Thread.sleep(3000);
	}
	
	@Step("Selecting Policy variant as individual")
	public void policyVariant() throws InterruptedException
	{
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlPolicyVariant")));
		sel.selectByVisibleText("Individual");
		Thread.sleep(3000);
	}
	
	@Step("Selecting buisness source information")
	public void buisnessSource() throws InterruptedException
	{
		driver.findElement(By.xpath("//img[@id='Img2']")).click();
		driver.switchTo().frame(driver.findElement(By.id("ctl00_PageBodyControls_Iframe2")));
		driver.findElement(By.id("TxtSearchFor")).sendKeys("a");
		driver.findElement(By.id("BtnSearch")).click();
		driver.findElement(By.xpath("(//img[@alt='Select Office'])[1]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlBusinessSourceName")));
		sel.selectByVisibleText("Call Centre");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//img[@id='Img6']")).click();
		driver.switchTo().frame(driver.findElement(By.id("ctl00_PageBodyControls_Iframe2")));
		driver.findElement(By.id("TxtSearchFor")).sendKeys("a");
		driver.findElement(By.id("BtnSearch")).click();
		driver.findElement(By.xpath("(//img[@alt='Select Intermediary'])[1]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	@Step("Selecting Policy Tenure as 1 year and entering Proposal amount")
	public void policyTenure_ProposalAmt() throws InterruptedException
	{
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlPolicyTenure")));
		sel.selectByVisibleText("1 Year");
		Thread.sleep(1500);
		driver.findElement(By.id("ctl00_PageBodyControls_txtProposalamount")).sendKeys("500000");
	}
	
	@Step("Clicking on submit Button to generate A Document control Number")
	public void submitBtnDCN()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_btnSave")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
	}
	
	
	
}
