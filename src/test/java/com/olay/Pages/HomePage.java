package com.olay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(linkText = "Sign IN")
	WebElement singIn;
	
	@FindBy(linkText = "Register")
	WebElement register;

	
	@FindBy(linkText = "Anmelden")
	WebElement ger_SingIn;
	
	@FindBy(linkText = "Registrieren")
	WebElement ger_register;
	
	
	public HomePage() {

		PageFactory.initElements(driver, this);
	}
	
	public void clickSingIn() {
		
		singIn.click();
	}
	
public void clickSingIn_Germary() {
		
	ger_SingIn.click();
	
	}

public void clickRegistration_Germary() {
	
	ger_register.click();
	
	}

}
