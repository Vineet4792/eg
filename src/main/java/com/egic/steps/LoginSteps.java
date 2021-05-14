package com.egic.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.egic.pageobjects.LoginPage;
import io.qameta.allure.Step;

public class LoginSteps 
{
	
		WebDriver driver;
		LoginPage lp;
		
		public LoginSteps(WebDriver driver)
		{
			this.driver=driver;
			lp=new LoginPage();
		}
		
		@Step("Enter username: {0}")
		public void enterUsername(String username)
		{
			driver.findElement(By.xpath(lp.unTxtBx)).sendKeys(username);
		}
		
		@Step("Enter password: {0}")
		public void enterPassword(String password)
		{
			driver.findElement(By.xpath(lp.pwdTxtBx)).sendKeys(password);
		}
		
		@Step("Enter Captcha")
		public void enterCaptcha() throws Exception
		{
			driver.findElement(By.xpath(lp.captcha)).click();
//			WebDriverWait wait = new WebDriverWait(driver,30);
//			wait.withTimeout(50, TimeUnit.SECONDS);
			Thread.sleep(50000);
		}
		
		@Step("click loginbutton")
		public void clickLoginBtn()
		{
			driver.findElement(By.xpath(lp.loginBtn)).click();
		}
	}

	
	
