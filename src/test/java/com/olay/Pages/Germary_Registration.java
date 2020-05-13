package com.olay.Pages;

import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.BaseClass.BaseClass;
import com.assignment.BaseClass.CommonPageActions;

public class Germary_Registration extends BaseClass {

	//username7150391@gmail.com
	public static String emailID = generateRandomEmail();
	public static String passwordText = "Test1234";

	HomePage home;

	@FindBy(xpath = "//img[@id='phdesktopbody_0_imgmale']")
	WebElement genderMale;
	
	@FindBy(xpath = "//img[@id='phdesktopbody_0_imgfemale']")
	WebElement genderFemale;
	
	@FindBy(xpath = "//*[@id='phdesktopbody_0_grs_consumer[firstname]']")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id='phdesktopbody_0_grs_consumer[lastname]']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@data-key='emailAddress']")
	WebElement email;

	@FindBy(xpath = "//input[@data-key='newPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@data-key='newPassword']/following::input[1]")
	WebElement confirmPassword;

	@FindBy(xpath = "//*[contains(@name,'day')]")
	WebElement day;

	@FindBy(xpath = "//*[contains(@name,'month')]")
	WebElement month;

	@FindBy(xpath = "//*[contains(@name,'year')]")
	WebElement year;
	
	@FindBy(xpath = "//*[@id='phdesktopbody_0_labelgrs_account[addresses][0][country]']")
	WebElement country;
	
	@FindBy(xpath = "//input[@data-key='addressStreet1']")
	WebElement address1;
	
	@FindBy(xpath = "//input[@data-key='addressPostalCode']")
	WebElement postalcode;
	
	@FindBy(xpath = "//input[@data-key='addressCity']")
	WebElement city;

	@FindBy(xpath = "//*[contains(@name,'submit')]")
	WebElement submit;

	@FindBy(xpath = "//a[@class='logoutbtn']")
	WebElement logout;

	@FindBy(xpath = "//*[@id='phdesktopheader_0_phdesktopheadertop_2_anchrContinue']")
	WebElement logOutPopup;


	public Germary_Registration() {

		PageFactory.initElements(driver, this);
		home = new HomePage();
	}

	
	public   void selectGender(String gender) {
		
		if(gender.equalsIgnoreCase("Male")) {
			
			genderMale.click();
		} else if(gender.equalsIgnoreCase("female")) {
			
			genderFemale.click();
		}
	}
	
	// GENERATE RANDOM EMAIL
	public static String generateRandomEmail() {

		Random rand = new Random();
		int random = rand.nextInt(20202020);

		String emailID = "username" + random + "@gmail.com";
		return emailID;
	}

	public void enterRegistrationForm(String firstName, String lastName, String gender, String address, String city, String zipcode, String country) {

		LocalDate randomDOB = CommonPageActions.randomDateOfBirth();
		String date = String.valueOf(randomDOB.getDayOfMonth());
		String month = String.valueOf(randomDOB.getMonthValue());
		String year = String.valueOf(randomDOB.getYear());

		System.out.println("Registration Page: " + emailID);
		
		home.clickRegistration_Germary();
		//Select Gender
		CommonPageActions.waitUntilElementPresent(submit, 10);
		selectGender(gender);
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);

		// REGISTRATION
		email.sendKeys(emailID);
		password.sendKeys(passwordText);
		confirmPassword.sendKeys(passwordText);
		CommonPageActions.selectByVisibleText(day, date);
		CommonPageActions.selectByVisibleText(this.month, month);
		CommonPageActions.selectByVisibleText(this.year, year);
		CommonPageActions.selectByVisibleText(this.country, country);
		address1.sendKeys(address);
		postalcode.sendKeys(zipcode);
		this.city.sendKeys(city);
		CommonPageActions.scrollToElement(submit);
		submit.click();

	}
	
		public void signOut() throws Exception {

		logout.click();
		CommonPageActions.highlightElement(logOutPopup);
		CommonPageActions.clickUsingJavascript(logOutPopup);

		if (logout.isDisplayed()) {
			logout.click();
			CommonPageActions.highlightElement(logOutPopup);
			CommonPageActions.clickUsingJavascript(logOutPopup);
		}
	}

	
	public boolean verifySignOutButton() {
		boolean flag = false;
		
		if(logout.isDisplayed()) {
			
			flag = true;
		} else {
			
			flag = false;
		}
		
		return flag;
	}
	
public void enterRegistrationFormUsingTestDataFile(String firstName, String lastName, String gender, String emailID, String password, String confirmPassword, String date, String address, String city, String zipcode, String country) {
		
		//Date Field should be "m/d/yyyy" format
		String[] dateSplit = date.split("/");
		String month = dateSplit[0];
		String day = dateSplit[1];
		String year = dateSplit[2];
		
		
		home.clickRegistration_Germary();
		//Select Gender
		CommonPageActions.waitUntilElementPresent(submit, 30);
		CommonPageActions.waitUntilElementPresent(postalcode, 30);
		selectGender(gender);
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);

		// REGISTRATION
		email.sendKeys(emailID);
		this.password.sendKeys(password);
		this.confirmPassword.sendKeys(confirmPassword);
		CommonPageActions.selectByVisibleText(this.day, day);
		CommonPageActions.selectByVisibleText(this.month, month);
		CommonPageActions.selectByVisibleText(this.year, year);
		CommonPageActions.selectByVisibleText(this.country, country);
		address1.sendKeys(address);
		postalcode.sendKeys(zipcode);
		this.city.sendKeys(city);
		CommonPageActions.scrollToElement(submit);
		submit.click();
		
		/*
		home.register.click();

		// REGISTRATION
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		confirmPassword.sendKeys(confirmPassowrd);
		CommonPageActions.selectByVisibleText(this.day, day);
		CommonPageActions.selectByVisibleText(this.month, month);
		CommonPageActions.selectByVisibleText(this.year, year);
		CommonPageActions.scrollToElement(submit);
		submit.click(); */

		
	}
}
