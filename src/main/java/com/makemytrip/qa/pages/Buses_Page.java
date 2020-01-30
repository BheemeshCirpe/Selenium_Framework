package com.makemytrip.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.util.TestUtil;

public class Buses_Page extends TestBase {

	@FindBy(id = "fromCity")
	WebElement txtFromCity;

	@FindBy(id = "toCity")
	WebElement txtToCity;

	@FindBy(xpath = "//*[@for='fromCity']//following::li[@role=\"option\"]")
	List<WebElement> suggestions_1;
	@FindBy(xpath = "//*[@for='toCity']//following::li[@role=\"option\"]")
	List<WebElement> suggestions_2;

	@FindBy(xpath = "//*[text()='Search']")
	WebElement btnSearchBus;

	
	@FindBy(id = "webklipper-publisher-widget-container-notification-frame")
	WebElement imgNotification;
	
	@FindBy(id = "webklipper-publisher-widget-container-notification-close-div")
	WebElement imgNotificationClose;
	
	
	
	
	@FindBy(xpath = "(//*[text()='Select Seats'])[1]")
	WebElement btnSelectTickets;

	@FindBy(xpath = "//*[text()='BOOK SEATS']")
	WebElement btnBookSeats;

	@FindBy(xpath = "//*[text()='Continue to Book Now']")
	WebElement btnContinueBook;

	@FindBy(id = "fname")
	WebElement txtName;

	@FindBy(xpath = "//input[@id='age']")
	WebElement txtAge;

	@FindBy(xpath = "//div[@class='GenderDropDownContainer']")
	WebElement lstGender;

	@FindBy(xpath = "//li[text()='Male']")
	WebElement lstMale;

	@FindBy(id = "contactEmail")
	WebElement txtEmailId;

	@FindBy(id = "mobileNumber")
	WebElement txtMobileNo;

	@FindBy(css = ".sc-gzOgki.izXzsS")
	WebElement rdoSecureTrip;

	@FindBy(xpath = "(//*[@class='booking_summary_wrap']//following::div)[3]")
	WebElement imgBookingSummary;
	
	public Buses_Page() {
		PageFactory.initElements(driver, this);
	}


	public void searchBus(String fromCity, String toCity, String date, String firstName, String lastName,
			String emailId) throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		
		txtFromCity.click();
		txtFromCity.sendKeys(fromCity);

		Thread.sleep(2000);

		// System.out.println(date);

		for (WebElement suggest_1 : suggestions_1) {
			String str = suggest_1.getText();

			if (str.contains(fromCity))

			{
				suggest_1.click();
				break;
			}
		}

		action.sendKeys(Keys.TAB).build().perform();
		txtToCity.sendKeys(toCity);

		for (WebElement suggest_2 : suggestions_2) {
			String str2 = suggest_2.getText();

			if (str2.contains(toCity))

			{
				suggest_2.click();
				break;
			}
		}

		
		action.sendKeys(Keys.TAB).build().perform();

		Thread.sleep(3000);

		String xpath1 = "(//*[@class='DayPicker-Month'])[1]/div[3]/div[";
		String xpath2 = "]/div[";
		String xpath3 = "]";

		boolean flag = false;

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				String actual_xpath = xpath1 + i + xpath2 + j + xpath3;

				String str = driver.findElement(By.xpath(actual_xpath)).getText();

				// System.out.println(str);

				if (str.contains(date)) {

					driver.findElement(By.xpath(actual_xpath)).click();

					flag = true;
					break;

				}

			}

			if (flag == true)
				break;

		}

		btnSearchBus.click();

		Thread.sleep(3000);
		
		
		  driver.switchTo().frame(imgNotification); 
		  imgNotificationClose.click();
		  driver.switchTo().parentFrame();
		 

		btnSelectTickets.click();
		
		driver.findElement(By.xpath("(//span[@class='sc-ifAKCX jEtqmF'])[1]")).click();
		btnBookSeats.click();
		txtName.sendKeys("Bheemesh");
		txtAge.sendKeys("25");
		
		action.moveToElement(txtAge).moveToElement(lstMale).build().perform();
		txtEmailId.sendKeys("abc@gmail.com");
		txtMobileNo.sendKeys("9700181055");
		rdoSecureTrip.click();
		btnContinueBook.click();
		
		
		 TestUtil.takeScreenshotAtEndOfTest(imgBookingSummary);

	}

}
