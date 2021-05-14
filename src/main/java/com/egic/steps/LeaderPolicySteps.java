package com.egic.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.egic.pageobjects.LeaderPolicyPage;

import io.qameta.allure.Step;


/**
 * 
 * @author Vineet
 * created on 17/April/2021 at 11:55 AM
 *
 */

public class LeaderPolicySteps 
{
	WebDriver driver;
	LeaderPolicyPage lpp;
	
	public LeaderPolicySteps(WebDriver driver)
	{
		this.driver=driver;
		lpp= new LeaderPolicyPage();
	}
	
	@Step("Click on Inward link")
	public void clickOnInwardLink()
	{
		driver.findElement(By.linkText(lpp.inwardlink)).click();
	}
	
	@Step("Click on Inward link From option Bucket")
	public void clickonInwardBucket()
	{
		driver.findElement(By.linkText(lpp.inwardbucket)).click();
	}
	
	@Step("Click on View/Manage inward Link")
	public void viewmanageinwardlink()
	{
		driver.findElement(By.linkText(lpp.viewmanageinward)).click();
	}
	
	@Step("Clicking on Add New Button")
	public void addnewBtn()
	{
		driver.findElement(By.linkText(lpp.addNewBtn)).click();
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
		driver.findElement(By.xpath(lpp.clientsearchBtn)).click();
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
	
	@Step("Proceeding from Inward to perform First QC process")
	public void firstQC()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_txtDCNNumber")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
		driver.findElement(By.xpath("//img[@alt='Proceed For QC']")).click();
	}
	
	@Step("Selecting DMS as NO")
	public void dmsNO()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_rdbDMS_1")).click();
	}
	
	@Step("Selecting Processed status and entering Remarks for QC")
	public void processedStatus() throws InterruptedException
	{
		Select sel= new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlQCStatus")));
		sel.selectByVisibleText("QC");
		Thread.sleep(1500);
		driver.findElement(By.id("ctl00_PageBodyControls_txtQCRemarks")).sendKeys("OK");
	}
	
	@Step("Clicking On update button")
	public void updateBtn()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_btnSave")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
	}
	
	@Step("Clicking on Proposal Creation bucket --->  View/Manage Inward Process ---> search by DCN")
	public void proposalCreation()
	{
		driver.findElement(By.xpath("//p[text()='Proposal Creation']")).click();
		driver.findElement(By.xpath("//a[text()='View / Manage Inward Process']")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_txtDCNNumber")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
		driver.findElement(By.id("ctl00_PageBodyControls_btnSearch")).click();
	}
	
	@Step("Proceeding For Proposal")
	public void proceedforProposal() throws InterruptedException
	{
		 driver.findElement(By.xpath("//img[@alt='Proceed For Proposal']")).click();
		 Thread.sleep(2000);
	}
	
	@Step("Adding share as 100% in buisness information")
	public void buisnessshare()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_txtShare")).clear();
        driver.findElement(By.id("ctl00_PageBodyControls_txtShare")).sendKeys("100");
        driver.findElement(By.id("ctl00_PageBodyControls_btnAddIntermediary")).click();
	}
	
	@Step("Clicking on Save Button and then on next button for proceeding the case")
	public void saveandnextclickbtn() throws InterruptedException
	{
		driver.findElement(By.id("ctl00_PageBodyControls_btnSave")).click();
		Thread.sleep(1500);
        driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
	}
	
	@Step("On Risk Details Page selecting member data as YES and Selecting PA cover as not required and selecting proposal Basis as NAMED")
	public void memberdataandpacoverselect()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_rdbMemberdataAvail_0")).click();
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlProposalBasis")));
		sel.selectByVisibleText("Named");
		driver.findElement(By.id("ctl00_PageBodyControls_rdbPACovered_1")).click();
	}
	
	@Step("Selecting Insured person Relationship")
	public void insuredrelation()
	{
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlInsuredPersonRelation")));
		sel.selectByVisibleText("Employee-employer relationship");
	}
	
	@Step("Entering Net Premium")
	public void netPremium()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_txtActualPremium")).sendKeys("5000");
	}
	
	@Step("Creating Group Definition and clicking On ADD button to add Group Definition For 2 Members")
	public void groupDefinition()
	{
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlGroup")));
		sel.selectByVisibleText("Group1");
		driver.findElement(By.id("ctl00_PageBodyControls_txtNoPrimaryMember")).sendKeys("2");
		driver.findElement(By.id("ctl00_PageBodyControls_txtNoOfDependents")).sendKeys("0");
		Select sel2= new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlRiskCategory")));
		sel2.selectByVisibleText("CLASS-I");
		driver.findElement(By.id("ctl00_PageBodyControls_txtSumInsuredPerMember")).sendKeys("300000");
		driver.findElement(By.id("ctl00_PageBodyControls_txtDefination")).sendKeys("Group1");
		driver.findElement(By.id("ctl00_PageBodyControls_btnSave")).click();
	}
	
	@Step("Selecting Covers For Policy")
	public void selectcovers() throws InterruptedException
	{
		driver.findElement(By.xpath("//img[@alt='Add Coverage']")).click();
		driver.switchTo().frame(driver.findElement(By.id("ctl00_PageBodyControls_Iframe2")));
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@id='grdAddOnCoverage_ctl02_chkAddonSelect']")).click();
//		driver.findElement(By.id("grdAddOnCoverage_ctl02_ddlAddOnSIandLimit"))
		driver.findElement(By.id("grdBasicCoverage_ctl02_txtBasicDescription")).sendKeys("OK");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
		driver.switchTo().defaultContent();
	}
	
	@Step("Selecting TPA from the List")
	public void selectTPA()
	{
		driver.findElement(By.id("Img4")).click();
		driver.switchTo().frame(driver.findElement(By.id("ctl00_PageBodyControls_Iframe2")));
		driver.findElement(By.id("TxtSearchFor")).sendKeys("a");
		driver.findElement(By.id("BtnSearch")).click();
		driver.findElement(By.xpath("(//img[@alt='Select TPA'])[2]")).click();
		driver.switchTo().defaultContent();
	}
	
	@Step("Uploading Member Data through EXCEL SHEET")
	public void memberUpload() throws InterruptedException
	{
		driver.findElement(By.id("ctl00_PageBodyControls_UploadFile")).sendKeys("./testdata/MemberDataFormat_GHI.xlsx");
		driver.findElement(By.id("ctl00_PageBodyControls_cmdSubmit")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
		Thread.sleep(61000);
	}
	
	@Step("Redirect to IP Status and fill per person premium and Click On Consecutive next buttons Till Premium Page")
	public void redirecttoIP()
	{
		driver.findElement(By.xpath("//p[text()='Proposal Management']")).click();
		driver.findElement(By.xpath("//a[text()='View / Manage Proposal IP']")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_txtDCNNumber")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
		driver.findElement(By.id("ctl00_PageBodyControls_btnSearch")).click();
		driver.findElement(By.xpath("//img[@alt='Edit']")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
	}
	
	@Step("Clicking on edit demography button to enter the mandatory per person Premium fields against each age band and clicking on freeze button")
	public void perpersonpremium() throws InterruptedException
	{
		driver.findElement(By.id("ctl00_PageBodyControls_grdDemography_ctl02_btnEditDemo")).click();
		//For ageband 1
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson1")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson1")).sendKeys("5000");
		//For ageband 2
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson2")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson2")).sendKeys("5000");
		//For ageband 3
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson3")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson3")).sendKeys("5000");
		//For ageband 4
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson4")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson4")).sendKeys("5000");
		//For ageband 5
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson5")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson5")).sendKeys("5000");
		//for ageband 6
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson6")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson6")).sendKeys("5000");
		//for Ageband 7
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson7")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson7")).sendKeys("5000");
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson3")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson3")).sendKeys("5000");
		//For ageband 8
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson8")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson8")).sendKeys("5000");
		//For ageband 9
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson9")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson9")).sendKeys("5000");
		//for ageband 10
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson10")).clear();
		driver.findElement(By.id("ctl00_PageBodyControls_txtPerPerson10")).sendKeys("5000");
		driver.findElement(By.id("ctl00_PageBodyControls_btnDemo")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_PageBodyControls_btnFreeze")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
	}
	
	@Step("Selecting fresh rating on rating page and clicking submit button after entering remarks")
	public void ratingpage()
	{
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlPremiumToBeCharged")));
		sel.selectByVisibleText("Fresh Rating");
		driver.findElement(By.id("ctl00_PageBodyControls_txtDescription")).sendKeys("OK");
		driver.findElement(By.id("ctl00_PageBodyControls_btnSave")).click();
	}
	
	@Step("On Premium page Saving the proposal")
	public void premiumpage()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_btnAdd")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
	}
	
	@Step("On Reinsurance page clicking on save and submit button")
	public void reinsurance()
	{
		driver.findElement(By.id("ctl00_PageBodyControls_btnAdd")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
	}
	
	@Step("Proceeding QC2 from Ops and sending proposal for UW Approval")
	public void ps() throws InterruptedException
	{
		driver.findElement(By.xpath("(//img[@alt='Proceed For Next'])[1]")).click();
		Thread.sleep(1000);
		Select sel = new Select(driver.findElement(By.id("ctl00_PageBodyControls_ddlStatus")));
		sel.selectByVisibleText("QC");
		driver.findElement(By.id("ctl00_PageBodyControls_txtQCRemarks")).sendKeys("OK");
		driver.findElement(By.id("ctl00_PageBodyControls_btnSave")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
	}
	
	@Step("Proceeding case from UW For Final Approval before collection Tagging")
	public void uw()
	{
		driver.findElement(By.xpath("(//img[@alt='Proceed For Next'])[1]")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnNext")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnSave")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnAdd")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnAdd")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
		Select sel = new Select(driver.findElement(By.id("ctl00$PageBodyControls$ddlStatus")));
		sel.selectByVisibleText("Approved");
		driver.findElement(By.id("ctl00_PageBodyControls_txtQCRemarks")).sendKeys("OK");
		driver.findElement(By.id("ctl00_PageBodyControls_btnSave")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_imgOK")).click();
	}
	
	@Step("Proceeding for collection Tagging")
	public void collectionTagging()
	{
		driver.findElement(By.xpath("(//img[@alt='Collection Tagging'])[1]")).click();
		driver.findElement(By.xpath("(//a[@href='#'])[3]")).click();
		driver.switchTo().frame(driver.findElement(By.id("ctl00_PageBodyControls_Iframe2")));
		driver.findElement(By.xpath("(//img[@alt='Select Receipt'])[13]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("ctl00_PageBodyControls_grdCollectionInfo_ctl02_ChkSelect")).click();
		driver.findElement(By.id("ctl00_PageBodyControls_btnSubmit")).click();
	}
	
	@Step("GHI Policy created")
	public void createdPolicy() throws EncryptedDocumentException, IOException
	{
		String dta = driver.findElement(By.xpath("//div[@class='PopUpAlertMessage']")).getText();
		File file = new File("./testdata/generatedPolicy.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.createSheet("Policy Data");
		Row rw = sh.createRow(0);
		Cell cl = rw.createCell(0);
		cl.setCellValue("Policy Number");
		System.out.println(dta);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		System.out.println("Done");
		Reporter.log("Framework Execution Complete...... :)");
	}
	
}




