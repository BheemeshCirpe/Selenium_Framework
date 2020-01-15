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

	@Test(priority=0)
	@Parameters({"User_Name_1","Password_1"})


	public void loginCheck_ValidUserDetails(String User_Name_1, String Password_1) throws InterruptedException {
			
		Assert.assertNotNull(homepage.navloginPage().loginMakeMyTrip(User_Name_1, Password_1));
	}

	@Test(priority=1,enabled=false)
	@Parameters({"User_Name_2","Password_2"})
	public void loginCheck_InvalidUserName(String User_Name_2, String Password_2) throws InterruptedException {
		

		try {
			homepage.navloginPage().loginMakeMyTrip(User_Name_2, Password_2);
		} catch (Exception e) {

			String bodyText = driver.findElement(By.xpath("//*[text()='Please enter a valid Email Id or Mobile Number.']")).getText();
			Assert.assertEquals(bodyText, "Please enter a valid Email Id or Mobile Number.");
		}
		
		

	}

	@Test(priority=2,enabled=false)
	@Parameters({"User_Name_3","Password_3"})
	public void loginCheck_InvalidPassword(String User_Name_3, String Password_3) throws InterruptedException {
		
		
		try {
			homepage.navloginPage().loginMakeMyTrip(User_Name_3, Password_3);
			
			Actions obj=new Actions(driver);
			obj.sendKeys(Keys.ENTER).build().perform();
			
		} catch (Exception e) {
			
			String bodyText = driver.findElement(By.xpath("//*[text()='Password cannot be less than 6 characters.']")).getText();
			Assert.assertEquals(bodyText, "Password cannot be less than 6 characters.");
		}
		
		

		
	}


	
	@Test(priority=3,enabled=false)
	@Parameters({"User_Name_4","Password_4"})
	public void loginCheck_BlankUserName(String User_Name_4, String Password_4) throws InterruptedException {
		
		
		try {
			homepage.navloginPage().loginMakeMyTrip(User_Name_4, Password_4);
			Actions obj=new Actions(driver);
			obj.sendKeys(Keys.ENTER).build().perform();
			
		} catch (Exception e) {
			
			String bodyText = driver.findElement(By.xpath("Please enter a valid Email Id or Mobile Number.")).getText();
			Assert.assertEquals(bodyText, "Please enter a valid Email Id or Mobile Number.");
		}
		
		
	}
	
	@Test(priority=4,enabled=false)
	@Parameters({"User_Name_5","Password_5"})
	public void loginCheck_BlankPassword(String User_Name_5, String Password_5) throws InterruptedException {
		
		
		try {
			homepage.navloginPage().loginMakeMyTrip(User_Name_5, Password_5);
			Actions obj=new Actions(driver);
			obj.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			String bodyText = driver.findElement(By.xpath("//*[text()='Please enter password.']")).getText();
			Assert.assertEquals(bodyText, "Please enter password.");
		}
		
		
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
