package com.makemytrip.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.pages.Home_Page;

public class Bus_Page_Test extends TestBase {

	Home_Page homepage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homepage = new Home_Page();
	}

	@Test(priority = 0)
	public void bookBus() throws InterruptedException, IOException {
		
		homepage.navBusesPage().searchBus("Hyderabad", "Chennai", "28", "2", "2", "2");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
