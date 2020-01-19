package com.makemytrip.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.makemytrip.qa.base.TestBase;

public class Flights_Page extends TestBase{
   
	@FindBy(id = "fromCity")
	WebElement txtFromCity;
	
	@FindBy(id = "toCity")
	WebElement txtToCity;
	
	@FindBy(xpath = "//*[text()='Search']")
	WebElement btnSearchFilght;
	
	
	public Flights_Page() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchFlight(String fromCity,String toCity) throws InterruptedException
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(txtFromCity).click().build().perform();

		Thread.sleep(3000);

		action.sendKeys(fromCity).build().perform();
		Thread.sleep(3000);
		
		
		action.moveToElement(txtToCity).click().build().perform();

		Thread.sleep(3000);

		action.sendKeys(toCity).build().perform();
		Thread.sleep(3000);
		
		
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		
		btnSearchFilght.click();
		
	}
}
