package com.makemytrip.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.pages.Flights_Page;
import com.makemytrip.qa.pages.Home_Page;
import com.makemytrip.qa.util.TestUtil;

public class Flights_Page_Test extends TestBase {

	Home_Page homepage;
	String sheetName = "Search_Flight";
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homepage = new Home_Page();

	}
	
	
	@DataProvider()
	public Object[][] getMakemyTripTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=0)
	public void navFilightsPage() {
		homepage.navFlightPage();
		Assert.assertEquals(homepage.verifyPageTitle(),
				"Flight Booking, Flight Tickets Booking at Lowest Airfare | MakeMyTrip");
	}

	@Test(priority=1,enabled = false)
	public void searchSpecificFlight() throws InterruptedException {
		homepage.navFlightPage().searchFlight("Delhi", "Mumbai");

		String str = homepage.verifyPageTitle();

		Assert.assertNotNull(str);
	}
	
	
	@Test(priority=2,dataProvider ="getMakemyTripTestData" )
	public void searchSpecificFlight_2(String fromCity,String ToCity) throws InterruptedException {
		homepage.navFlightPage().searchFlight_2(fromCity, ToCity);
	}
	
	
	
	 @AfterMethod public void tearDown() { driver.quit(); } 
	 

}
