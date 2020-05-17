package com.assignment.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.SkipException;

import com.assignment.BaseClass.BaseClass;



public class DatePicker extends BaseClass {
	
	@FindBy(xpath = "//label[@for='departure']")
	WebElement depature;
	
	public DatePicker() {
		PageFactory.initElements(driver, this);
	}
	
	private String departureDate=null;
	private String returnDate=null;
	
	public String getDepartureDate() {
		return departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	//Picks up current system for Departure DAte and +7 days for Return date Returns in format tue 13 Apr 2019
	public static DatePicker getDates(String NoOfdays)
	{
		DatePicker date=new DatePicker();
		Calendar cal=Calendar.getInstance();
		
		String[] rawDate=cal.getTime().toString().split(" ");
		date.departureDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		cal.add(Calendar.DATE, Integer.parseInt(NoOfdays));
		rawDate=cal.getTime().toString().split(" ");
		date.returnDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		return date;
	}

	private static long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}
	
	public boolean DatePickerHomePage(Date DepartureDate, Date ArrivateDate) {


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

			
			depature.click();

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
}
