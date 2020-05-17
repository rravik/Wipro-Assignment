package com.makemytrip.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.BaseClass.BaseClass;
import com.demoqa.Pages.Selectable;
import com.makemytrip.Pages.MMTFlightReview;
import com.makemytrip.Pages.MMTFlightSearch;
import com.makemytrip.Pages.MMTHome;

public class MMTSearchFlightTest extends BaseClass {

	MMTHome home;
	MMTFlightSearch flightSearch;
	
	MMTFlightReview reviewPage;

	 @BeforeMethod
	public void setUp() throws Exception {

		launchBrowser();

		home = new MMTHome();
		flightSearch = new MMTFlightSearch();
		reviewPage = new MMTFlightReview();
		

	}

//Searches flight by providing FROM,TO , DEPARTURE and RETURN details
  @Test
	public void searchFlights() throws InterruptedException {
		openURL("https://www.makemytrip.com/");

		home.waitforelement();
		home.clickFlightMenu();
		home.TripWay("two");
		home.clickFromCity();
		Assert.assertTrue(home.EnterFromCity("Chennai"));

		// home.setToCity("Delhi");
		Assert.assertTrue(home.EnterToCity("Delhi"));
		
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.DATE, 25); // Adding 25 Days in current date. this is arrival date.

		Date departureDate = c.getTime();
		c.setTime(departureDate);
		c.add(Calendar.DATE, 1);
		Date returnDate = c.getTime();
		
		
		Assert.assertTrue(home.DatePicker(departureDate,returnDate));
		home.clickSearchButton();
		
		flightSearch.clickDepartureSort();
		
		
		/*Set<String> allWindowHandles = driver.getWindowHandles();
		 
		for(String handle : allWindowHandles)
		{
		System.out.println("Window handle - > " + handle);
		driver.switchTo().window(handle);
		//System.out.println(reviewPage.getTitle());
		//System.out.println(reviewPage.validateTitle());
		
		
		if(reviewPage.validateTitle()) {
			
			String title = reviewPage.getTitle();
			System.out.println(title);
			//Assert.assertTrue(title.contains("Review your booking"));
		}
	
		} */

	}
	
	

}
