package com.makemytrip.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.pages.Flights_Page;
import com.makemytrip.qa.pages.Home_Page;

public class Flights_Page_Test extends TestBase {

	Home_Page homepage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homepage = new Home_Page();

	}

	@Test(priority=0)
	public void navFilightsPage() {
		homepage.navFlightPage();
		Assert.assertEquals(homepage.verifyPageTitle(),
				"Flight Booking, Flight Tickets Booking at Lowest Airfare | MakeMyTrip");
	}

	@Test(priority=1)
	public void searchSpecificFlight() throws InterruptedException {
		homepage.navFlightPage().searchFlight("Delhi", "Mumbai");

		String str = homepage.verifyPageTitle();

		Assert.assertNotNull(str);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
