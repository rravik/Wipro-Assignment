package com.makemytrip.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;
import com.olay.Pages.HomePage;

public class MMTripHomePage extends BaseClass {
	
	@FindBy(xpath = "//li[@data-cy='oneWayTrip']")
	WebElement oneWayTrip;
	
	@FindBy(xpath = "//label[@for='fromCity']")
	WebElement fromCity;
	
	@FindBy(xpath = "//label[@for='toCity']")
	WebElement toCity;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement fromTextbox;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement toTextbox;
	
	
	@FindBy(xpath = "//li[@data-cy='roundTrip']")
	WebElement roundTrip;
	
	@FindBy(xpath = "//li[@data-cy='mulitiCityTrip']")
	WebElement mulitiCityTrip;
	
	
	
	@FindBy(xpath = "//label[@for='departure']")
	WebElement depature;
	
	@FindBy(xpath = "//label[@for='return']")
	WebElement returnDate;
	
	@FindBy(xpath = "//label[@for='anotherDeparture 0']")
	WebElement mcDepature;
	
	@FindBy(xpath = "//label[@for='travellers 0']")
	WebElement mcTravellers;
	
	@FindBy(xpath = "//label[@for='anotherDeparture 1']")
	WebElement mcDepature1;
	
	

	public MMTripHomePage() {

		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnewayTrip() {
		oneWayTrip.click();
	}

}
