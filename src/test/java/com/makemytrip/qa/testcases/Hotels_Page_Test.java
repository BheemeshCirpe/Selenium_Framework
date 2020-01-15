package com.makemytrip.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.qa.base.TestBase;

import com.makemytrip.qa.pages.Home_Page;
import com.makemytrip.qa.pages.Hotels_Page;

public class Hotels_Page_Test extends TestBase{
	
	Home_Page homepage;
	Hotels_Page hotels;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homepage = new Home_Page();
		hotels= new Hotels_Page();
	}

	@Test(priority=0)
	public void navHotelsPage() {
		
		homepage.navHotelPage();
		
		Assert.assertEquals(homepage.verifyPageTitle(), "MakeMyTrip.com: Save upto 60% on Hotel Booking 4,442,00+ Hotels Worldwide");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
