package com.egic.features;

import org.openqa.selenium.WebDriver;

import com.egic.steps.LoginSteps;

import io.qameta.allure.Story;

public class LoginFeatures 
{

		LoginSteps ls;
		
		public LoginFeatures(WebDriver driver)
		{
			ls= new LoginSteps(driver);
		}
		
		@Story("Performing login using credentials {0} and {1}")
		public void login(String username, String password) throws Exception
		{
			ls.enterUsername(username);
			ls.enterPassword(password);
		    ls.enterCaptcha();
			ls.clickLoginBtn();
		}
	
	
}
