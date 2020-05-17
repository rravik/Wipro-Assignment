package com.makemytrip.Pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.SkipException;

import com.assignment.BaseClass.BaseClass;
import com.assignment.BaseClass.CommonPageActions;
import com.assignment.Utils.MMT_Util;

public class MMTHome extends BaseClass {

	@FindBy(xpath = "//li[@data-cy='menu_Flights']")
	WebElement flightsMenu;

	@FindBy(xpath = "//li[@data-cy='oneWayTrip']")
	WebElement OneWayTrip;

	@FindBy(xpath = "//li[@data-cy='roundTrip']")
	WebElement RoundTrip;

	@FindBy(xpath = "//li[@data-cy='mulitiCityTrip']")
	WebElement MutiCity;

	@FindBy(xpath = "//label[@for='fromCity']")
	WebElement FromCity;

	@FindBy(xpath = "//label[@for='toCity']")
	WebElement ToCity;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement txtFromCity;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement txtToCity;

	@FindBy(xpath = "//*[@id='react-autowhatever-1']/div[1]/div/p[text()='SUGGESTIONS ']")
	WebElement CitySuggestion;

	@FindBy(xpath = "//div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']/ul/li")
	List<WebElement> Suggestion = new ArrayList<>();
	
	@FindBy(xpath = "//label[@for='departure']")
	WebElement Cal;
	
	@FindBy(xpath="//p[@data-cy='submit']//a")
	WebElement search;

	public MMTHome() {

		PageFactory.initElements(driver, this);
	}

	public void clickFlightMenu() {

		flightsMenu.click();
	}

	public void clickOneWayTrip() {

		OneWayTrip.click();
	}

//Method to Click on type of Trip
	public void TripWay(String way) {
		if (way.equalsIgnoreCase("two") || way.equalsIgnoreCase("round")) {
			RoundTrip.click();

		} else if (way.equalsIgnoreCase("one")) {
			OneWayTrip.click();

		} else if (way.equalsIgnoreCase("mult")) {
			MutiCity.click();

		}
	}

	public boolean EnterFromCity(String FromCityName) throws InterruptedException {

		boolean flag = false;

		//txtFromCity.sendKeys(FromCityName, Keys.ENTER);
		txtFromCity.sendKeys(FromCityName);
		Thread.sleep(5000);

		MMT_Util.Explicitwait(10, CitySuggestion);

		for (WebElement e : Suggestion) {

			if (e.getText().toUpperCase().contains(FromCityName.toUpperCase())) {
				e.click();

				flag = true;
				break;
			}
		}

		return flag;

	}
	
	public boolean EnterToCity(String ToCityName) throws InterruptedException {

		boolean flag = false;
		
		//txtToCity.sendKeys(Keys.TAB);
		txtToCity.sendKeys(ToCityName);
		//txtToCity.sendKeys(ToCityName, Keys.ENTER);
//		Reporter.log("Enter Arrival City "+ ToCityName);
	//	test.get().info("Enter Arrival City "+ ToCityName);
		
		MMT_Util.Explicitwait(10, CitySuggestion);
		//Reporter.log("waiting to populate Auto Suggestion after entering City..");
		//test.get().info("waiting to populate Auto Suggestion after entering City..");

		
		for (WebElement e : Suggestion) {

			if (e.getText().toUpperCase().contains(ToCityName.toUpperCase())) {
				e.click();
			//	Reporter.log("selected city...");
				//test.get().info("selected city...");
				flag = true;
				break;
			}
		}

		return flag;

	}

	public void waitforelement() {

		CommonPageActions.waitUntilElementPresent(flightsMenu, 60);
		CommonPageActions.highlightElement(flightsMenu);

	}

	public void clickFromCity() {
		// TODO Auto-generated method stub
		FromCity.click();
	}
	
	
	public boolean DatePicker(Date DepartureDate, Date ArrivateDate) {


		if (DepartureDate.compareTo(ArrivateDate) > 0 || daysBetween(DepartureDate, ArrivateDate) > 7) {
			throw new SkipException(
					"This Method is restericated to accept 7 days difference between departure and Arrival date. Please check Given Date again. !!Contact Git Admin for more info");

		}

		boolean StatusFlag = false;

		SimpleDateFormat formatNowDay = new SimpleDateFormat("dd");
		SimpleDateFormat formatNowMonth = new SimpleDateFormat("MMMM");
		SimpleDateFormat formatNowYear = new SimpleDateFormat("YYYY");

		// Clicking on DepartureDate
		String Day1 = formatNowDay.format(DepartureDate);
		String Month1 = formatNowMonth.format(DepartureDate);
		String Year1 = formatNowYear.format(DepartureDate);
		if (Day1.startsWith("0")) {
			Day1 = Day1.substring(1);
		}
		try {
			String DepartureDateXpath = "//*[@class='DayPicker-Months']/div[*]/div/div[text()='" + Month1
					+ "']/span[text()='" + Year1 + "']//../../following-sibling::div[@class='DayPicker-Body']"
					+ "/div/div/div/p[text()='" + Day1 + "']/../..";

			//WebElement DepDate1 = driver.findElement(By.xpath(DepartureDateXpath));
			System.out.println("Departure Date:"+DepartureDateXpath);
			//CommonPageActions.highlightElement(DepDate1);
			
			//Cal.click();

			Reporter.log("Clicking on date " + Day1+"/"+Month1+"/"+Year1);
			WebElement DepDate = driver.findElement(By.xpath(DepartureDateXpath));
			if (DepDate.isDisplayed()) {
				MMT_Util.JavaScriptClick(DepDate);
			}

			// Clicking on ArrivalDate
			String Day2 = formatNowDay.format(ArrivateDate);
			String Month2 = formatNowMonth.format(ArrivateDate);
			String Year2 = formatNowYear.format(ArrivateDate);

			if (Day2.startsWith("0")) {
				Day2 = Day2.substring(1);
			}

			String ArrivalDateXpath = "//*[@class='DayPicker-Months']/div[*]/div/div[text()='" + Month2
					+ "']/span[text()='" + Year2 + "']//../../following-sibling::div[@class='DayPicker-Body']"
					+ "/div/div/div/p[text()='" + Day2 + "']/../..";

			
			
			Reporter.log("Clicking on date " + Day2+"/"+Month2+"/"+Year2);
			WebElement ArrivalDate = driver.findElement(By.xpath(ArrivalDateXpath));
			
			if (ArrivalDate.isDisplayed()) {
				MMT_Util.JavaScriptClick(ArrivalDate);
			}
			StatusFlag = true;

		} catch (Exception e) {
			Reporter.log(e.getMessage());
			e.printStackTrace();

		}

		return StatusFlag;

	}
	
	private static long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}

	public void clickSearchButton() {
		search.click();
	}

}
