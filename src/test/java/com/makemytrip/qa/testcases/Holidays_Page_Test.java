package com.makemytrip.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.pages.Flights_Page;
import com.makemytrip.qa.pages.Holidays_Page;
import com.makemytrip.qa.pages.Home_Page;
import com.makemytrip.qa.pages.Hotels_Page;

public class Holidays_Page_Test extends TestBase {

	Home_Page homepage;
	Holidays_Page holidays;
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homepage = new Home_Page();
		holidays= new Holidays_Page();
	}

	@Test(priority=0)
	public void navHolidaysPage() {
		
		homepage.navHolidaysPage();
		
		Assert.assertEquals(homepage.verifyPageTitle(), "Holiday Packages, Indian Holidays, Honeymoon Packages, India Tourism, Holidays India, Vacation Package : MakeMyTrip");
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
