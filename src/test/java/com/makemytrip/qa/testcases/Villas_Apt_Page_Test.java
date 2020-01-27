package com.makemytrip.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.pages.Holidays_Page;
import com.makemytrip.qa.pages.Home_Page;
import com.makemytrip.qa.pages.Hotels_Page;
import com.makemytrip.qa.pages.Villas_Apt_Page;

public class Villas_Apt_Page_Test extends TestBase {

	
	Home_Page homepage;
	Villas_Apt_Page villas;
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homepage = new Home_Page();
		villas= new Villas_Apt_Page();
	}

	@Test(priority=0)
	public void navVillasPage() {
		
		homepage.navVillasPage();
		
		Assert.assertEquals(homepage.verifyPageTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");	
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
