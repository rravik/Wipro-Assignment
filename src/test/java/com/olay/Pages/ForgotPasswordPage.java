package com.olay.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;

public class ForgotPasswordPage extends BaseClass  {

	@FindBy(id = "phdesktopbody_0_username")
	WebElement email;
	
	@FindBy(name = "phdesktopbody_0$NEXT")
	WebElement nextBtn;
	
	@FindBy(id = "phdesktopbody_0_afterSubmit")
	WebElement msg;
	
	
	public String forgotMessage = "We have sent an email to your email address, please click on the link in the email to reset your password.";
	
	public ForgotPasswordPage() {

		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public void setEmailAddress(String email) {
		
		this.email.sendKeys(email);
		
	}
	
	public void clickNextButton() {
		
		nextBtn.click();
	}
	
	public boolean validateMessageForForgotPassword() {
		boolean flag = false;
		
		if(msg.isDisplayed()) {
			
			flag = true;
		} else {
			
			flag = false;
		}
			
		return flag;
		
	}
	
public String getForgotPasswordValidationMessage() {
		
		String msg = this.msg.getText();
		
		return msg;
	}
	
	
	
	
}
