package com.makemytrip.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.qa.base.TestBase;



public class Login_Page extends TestBase {

	
	@FindBy(id= "username")
	WebElement txtUsername;
	
	@FindBy(id= "password")
	WebElement txtPassword;
	
	@FindBy(xpath= "//span[text()='Continue']" )
	WebElement btnContinue;
	
	
	@FindBy(xpath= "//span[text()='Login']")
	WebElement btnLogin;
	
	@FindBy(id= "webklipper-publisher-widget-container-notification-close-div")
	WebElement imgNotification;
	
	
	
	
	
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	public Home_Page loginMakeMyTrip(String username,String password)  {
		txtUsername.sendKeys(username);
		
	
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		imgNotification.click();
		
		wait.until(ExpectedConditions.visibilityOf(btnContinue));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", btnContinue);
		
		//btnContinue.click();
		txtPassword.sendKeys(password);
		
		
		btnLogin.click();
		return new Home_Page();
		
	}
}
