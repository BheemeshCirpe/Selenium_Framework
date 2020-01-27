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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.util.TestUtil;

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

	@FindBy(xpath = "(//*[text()='Book Now'])[1]")
	WebElement btnBookTicket;

	@FindBy(xpath = "//input[@type='radio' and @value='no']")
	WebElement btnSecureTrip;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//*[@placeholder='Mobile No']")
	WebElement txtMobileNo;

	@FindBy(xpath = "//*[@placeholder='Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//*[text()='+ ADD ADULT']")
	WebElement lnkAddAdults;

	@FindBy(xpath = "//*[@placeholder='First Name']")
	WebElement txtFirstName;

	@FindBy(xpath = "//*[@placeholder='Last Name']")
	WebElement txtLastName;

	@FindBy(xpath = "//span[text()='MALE']")
	WebElement btnGender;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement btnContinue_2;

	@FindBy(xpath = "//*[@id='ancillary-continue']")
	WebElement btnContinue_3;

	@FindBy(xpath = "//a[text()='Done']")
	WebElement btnConfirm;
	
	@FindBy(xpath = "(//*[@class='booking_summary_wrap']//following::div)[3]")
	WebElement imgBookingSummary;
	
	

	public Flights_Page() {
		PageFactory.initElements(driver, this);
	}



	public void searchFlight(String fromCity, String toCity, String date ,String firstName,String lastName,String emailId) throws InterruptedException, IOException {

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

		txtToCity.sendKeys(toCity);

		for (WebElement suggest_2 : suggestions_2) {
			String str2 = suggest_2.getText();

			if (str2.contains(toCity))

			{
				suggest_2.click();
				break;
			}
		}

		Actions action = new Actions(driver);
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

					if (driver.findElement(By.xpath(xpath1 + i + xpath2 + j + "]/div/p[1]")).getText().equals(date)) {
						driver.findElement(By.xpath(actual_xpath)).click();

						flag = true;
						break;
					}
				}

			}

			if (flag == true)
				break;

		}

		btnSearchFilght.click();

		Thread.sleep(2000);

		btnBookTicket.click();

		Set<String> s1 = driver.getWindowHandles();

		ArrayList<String> obj = new ArrayList<String>(s1);

		driver.switchTo().window(obj.get(1));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", btnSecureTrip);

		btnSecureTrip.click();
		js.executeScript("arguments[0].scrollIntoView(true);", btnContinue);

		Thread.sleep(3000);

		// btnContinue.click();

		js.executeScript("arguments[0].click()", btnContinue);

		lnkAddAdults.click();

		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);

		js.executeScript("arguments[0].click()", btnGender);

		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", btnConfirm);

		txtMobileNo.sendKeys("9700181055");

		txtEmail.sendKeys(emailId);
		btnContinue_2.click();

		Thread.sleep(4000);
		// btnContinue_3.click();

		js.executeScript("arguments[0].click()", btnContinue_3);
		
		TestUtil.takeScreenshotAtEndOfTest(imgBookingSummary);

	}

}





