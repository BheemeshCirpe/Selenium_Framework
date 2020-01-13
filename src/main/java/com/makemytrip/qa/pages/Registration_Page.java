package com.makemytrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.makemytrip.qa.base.TestBase;

public class Registration_Page extends TestBase{
	
	
	@FindBy(id = "emailOrPhone")
	WebElement txtUserName;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "(//span[text()='Create Account'])[1]")
	WebElement btnCreatAccount;
	
	
	public Home_Page crateAccount(String UserName,String Password) {
		
		txtUserName.sendKeys(UserName);
		txtPassword.sendKeys(Password);
		btnCreatAccount.click();	
		return new Home_Page();
		
	}
	
	
	

}
