package com.makemytrip.qa.pages;

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

	public void searchFlight_2(String fromCity, String toCity, String date) throws InterruptedException {

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

		btnContinue.click();

	}

}