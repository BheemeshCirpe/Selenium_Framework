package com.makemytrip.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Argument;



public class Login_Page extends TestBase {

	
	@FindBy(id= "username")
	WebElement txtUsername;
	
	@FindBy(id= "password")
	WebElement txtPassword;
	
	@FindBy(xpath= "//span[text()='Continue']" )
	WebElement btnContinue;
	
	
	@FindBy(xpath= "//span[text()='Login']")
	WebElement btnLogin;
	
	
	@FindBy(xpath = "//a[text()=' Create New Account ']")
	WebElement btnNewCreatAccount;
	
	
	
	
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public Home_Page loginMakeMyTrip(String username,String password) throws InterruptedException  {
		txtUsername.sendKeys(username);
			
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnContinue);
		js.executeScript("arguments[0].click();", btnContinue);
		
		txtPassword.sendKeys(password);
		btnLogin.click();
		
		return new Home_Page();	
	}
	
	
	public Registration_Page navigateRegistrationPage() throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.elementToBeClickable(btnNewCreatAccount));
		Thread.sleep(5000);
		
		//btnNewCreatAccount.click();
		btnNewCreatAccount.click();
		
		return new Registration_Page();
	}
}
