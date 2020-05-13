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

public class UK_Registration extends BaseClass {

	//username7150391@gmail.com
	public static String emailID = generateRandomEmail();
	public static String passwordText = "Test1234";

	HomePage home;

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

	@FindBy(xpath = "//*[contains(@name,'submit')]")
	WebElement submit;

	@FindBy(xpath = "//a[@class='logoutbtn']")
	WebElement logout;

	@FindBy(xpath = "//*[@id='phdesktopheader_0_phdesktopheadertop_2_anchrContinue']")
	WebElement logOutPopup;

	@FindBy(id = "phdesktopbody_1_SkipPage")
	WebElement skipThisStep;

	public UK_Registration() {

		PageFactory.initElements(driver, this);
		home = new HomePage();
	}

	// GENERATE RANDOM EMAIL
	public static String generateRandomEmail() {

		Random rand = new Random();
		int random = rand.nextInt(20202020);

		String emailID = "username" + random + "@gmail.com";
		return emailID;
	}

	public void enterRegistrationForm() {

		LocalDate randomDOB = CommonPageActions.randomDateOfBirth();
		String date = String.valueOf(randomDOB.getDayOfMonth());
		String month = String.valueOf(randomDOB.getMonthValue());
		String year = String.valueOf(randomDOB.getYear());

		System.out.println("Registration Page: " + emailID);

		home.register.click();

		// REGISTRATION
		email.sendKeys(emailID);
		password.sendKeys(passwordText);
		confirmPassword.sendKeys(passwordText);
		CommonPageActions.selectByVisibleText(day, date);
		CommonPageActions.selectByVisibleText(this.month, month);
		CommonPageActions.selectByVisibleText(this.year, year);
		CommonPageActions.scrollToElement(submit);
		submit.click();

	}
	
	public void enterRegistrationFormUsingTestDataFile(String email, String password, String confirmPassowrd, String date) {
		
		//Date Field should be "m/d/yyyy" format
		String[] dateSplit = date.split("/");
		String month = dateSplit[0];
		String day = dateSplit[1];
		String year = dateSplit[2];
		
		home.register.click();

		// REGISTRATION
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		confirmPassword.sendKeys(confirmPassowrd);
		CommonPageActions.selectByVisibleText(this.day, day);
		CommonPageActions.selectByVisibleText(this.month, month);
		CommonPageActions.selectByVisibleText(this.year, year);
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
}
