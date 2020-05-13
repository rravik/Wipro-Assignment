package com.demoqa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;
import com.assignment.BaseClass.CommonPageActions;

public class ContactForm extends BaseClass {

	@FindBy(xpath = "//input[@class='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='lname']")
	WebElement lastName;

	@FindBy(name = "country")
	WebElement Country;

	@FindBy(name = "subject")
	WebElement Subject;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	@FindBy(partialLinkText = "Link")
	WebElement googleLink;

	@FindBy(partialLinkText = "is here")
	WebElement googleLinkIsHere;

	public ContactForm() {

		PageFactory.initElements(driver, this);
	}

	public void enterContactForm(String fName, String lName, String country, String subject) {

		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		Country.sendKeys(country);
		Subject.sendKeys(subject);

	}

	public void openGoogleLink() {

		CommonPageActions.highlightElement(googleLink);
		CommonPageActions.openLinkWithNewTab(googleLink);

	}

	public void openGoogleLinkIsHere() {

		CommonPageActions.highlightElement(googleLinkIsHere);
		CommonPageActions.openLinkWithNewTab(googleLinkIsHere);

	}

	public void clickSubmit() {

		submit.click();
	}

}
