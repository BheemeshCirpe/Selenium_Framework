package com.makemytrip.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.makemytrip.qa.base.TestBase;

public class Flights_Page extends TestBase {

	@FindBy(id = "fromCity")
	WebElement txtFromCity;

	@FindBy(id = "toCity")
	WebElement txtToCity;

	@FindBy(xpath = "//*[text()='Search']")
	WebElement btnSearchFilght;

	@FindBy(xpath = "//*[@for='fromCity']//following::li[@role=\"option\"]")
	List<WebElement> suggestions_1;
	@FindBy(xpath = "//*[@for='toCity']//following::li[@role=\"option\"]")
	List<WebElement> suggestions_2;

	public Flights_Page() {
		PageFactory.initElements(driver, this);
	}

	public void searchFlight(String fromCity, String toCity) throws InterruptedException {
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

	public void searchFlight_2(String fromCity, String toCity) throws InterruptedException {

		txtFromCity.sendKeys(fromCity);

			for (WebElement suggest_1 : suggestions_1) 
				{
					String str = suggest_1.getText();
					
						if (str.contains(fromCity))

							{
								suggest_1.click();
								break;
							}
				}

		
		txtToCity.sendKeys(toCity);

		
		  for (WebElement suggest_2 : suggestions_2) { String str2 =
		  suggest_2.getText();
		  
		  if (str2.contains(toCity))
		  
		  { suggest_2.click(); break; } }
		 
		}

	}

