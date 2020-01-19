package com.makemytrip.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.qa.base.TestBase;

public class Hotels_Page extends TestBase {

	

	@FindBy(id = "city")
	WebElement txtCityHotel;
	
	@FindBy(xpath = "//*[text()='Search']")
	WebElement btnSearchHotel;
	
	
	public Hotels_Page() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchHotel(String cityHotel) throws InterruptedException
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(txtCityHotel).click().build().perform();

		Thread.sleep(3000);

		action.sendKeys(cityHotel).build().perform();
		Thread.sleep(3000);
		
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		
		btnSearchHotel.click();
		
	}
	
	
	

	
	
}
