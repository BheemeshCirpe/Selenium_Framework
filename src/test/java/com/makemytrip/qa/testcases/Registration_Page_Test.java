package com.makemytrip.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.pages.Home_Page;
import com.makemytrip.qa.pages.Login_Page;
import com.makemytrip.qa.pages.Registration_Page;
import com.makemytrip.qa.util.TestUtil;

public class Registration_Page_Test extends TestBase {

	Registration_Page registrationpage;
	Home_Page homepage;

	String sheetName = "Login_Page";

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		homepage = new Home_Page();
		registrationpage = new Registration_Page();

	}

	@DataProvider()
	public Object[][] getMakemyTripTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=0,dataProvider="getMakemyTripTestData")
	
	public void registerAccount(String UserName,String Password) throws InterruptedException {
		
		homepage.navloginPage().navigateRegistrationPage().crateAccount(UserName, Password);
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
