package com.makemytrip.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.pages.Home_Page;
import com.makemytrip.qa.pages.Login_Page;
import com.makemytrip.qa.util.TestUtil;

public class Login_Page_Test extends TestBase {

	Login_Page loginpage;
	Home_Page homepage;

	String sheetName = "Login_Page";

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();

		homepage = new Home_Page();
		loginpage = new Login_Page();

	}

	@DataProvider()
	public Object[][] getMakemyTripTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	
	  @Test(dataProvider="getMakemyTripTestData")
	  
	  public void loginTest(String Username,String Password) throws
	  InterruptedException {
	  //homepage.navloginPage().loginMakeMyTrip(prop.getProperty("username"),prop.getProperty("password"));
	  
	  
		  try
		  {
			  Assert.assertNotNull(homepage.navloginPage().loginMakeMyTrip(Username, Password));
		  } 
		  catch (Exception e) 
		  {
		  		 		
		  }
	  
		  
	  
	  }
	 

	

	
	
	
	@Test
	public void loginCheck_ValidUserDetails(String Username, String Password) {
			
		Assert.assertNotNull(homepage.navloginPage().loginMakeMyTrip(Username, Password));
	}

	@Test
	public void loginCheck_InvalidUserName(String Username, String Password) {
		homepage.navloginPage().loginMakeMyTrip(Username, Password);

		String bodyText = driver.findElement(By.xpath("//*[text()='Please enter a valid Email Id or Mobile Number.']")).getText();
		Assert.assertEquals(bodyText, "Please enter a valid Email Id or Mobile Number.");

	}

	@Test
	public void loginCheck_InvalidPassword(String Username, String Password) {
		homepage.navloginPage().loginMakeMyTrip(Username, Password);

		String bodyText = driver.findElement(By.xpath("//*[text()='Password cannot be less than 6 characters.']")).getText();
		Assert.assertEquals(bodyText, "Password cannot be less than 6 characters.");
	}

	@Test
	public void loginCheck_BlankUserName(String Username, String Password) {
		homepage.navloginPage().loginMakeMyTrip(Username, Password);
		
		String bodyText = driver.findElement(By.xpath("//*[text()='Please enter password.']")).getText();
		Assert.assertEquals(bodyText, "'Please enter password.");
	}
	
	
	
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
