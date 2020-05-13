package com.olay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;

public class LoginPage extends BaseClass {

	UK_Registration ukRegister;
	
	@FindBy(xpath = "//a[@class='event_profile_login']")
	WebElement signIN;
	
	@FindBy(xpath = "//input[@data-key='signInEmailAddress']")
	WebElement signInEmail;
	
	@FindBy(xpath = "//input[@data-key='currentPassword']")
	WebElement currentPassword;
	
	@FindBy(xpath = "//input[@value='SIGN IN']")
	WebElement btnSignIN;
	
	@FindBy(id = "phdesktopbody_0_Message")
	WebElement validationMessage;
	
	@FindBy(id = "phdesktopbody_0_forgotpassword")
	WebElement forgotPassword;
	
	public static String errorMSG = "The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.";

	
	public LoginPage() {

		PageFactory.initElements(driver, this);
		ukRegister = new UK_Registration();	
		
	}
	
	public void login() {
		
		
		signIN.click();
		setEmailAddress(ukRegister.emailID);
		setPassword(ukRegister.passwordText);
		clickSingInBtn();
		
		
	}
	
	public void setEmailAddress(String email) {
		
		signInEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		
		currentPassword.sendKeys(password);
	}
	
	public void clickSingInBtn() {
		btnSignIN.click();
	}
	
	public boolean errorMsgForInvalid_UN_And_PWD() {
		boolean flag = false;
		
		if(validationMessage.isDisplayed()) {
			
			flag = true;
		} else {
			
			flag = false;
		}
			
		return flag;
		
	}
	
	public String getErrorValidationMessage() {
		
		String msg = validationMessage.getText();
		
		return msg;
	}
	
	public void clicksingInLink() {
		
		signIN.click();
	}
	
	
	public void clickForgotPassword() {
		
		forgotPassword.click();
	}
	
	
}
