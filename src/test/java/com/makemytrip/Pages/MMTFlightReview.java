package com.makemytrip.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;

public class MMTFlightReview extends BaseClass {
	
	@FindBy(xpath="//div[@class='make_flex alC']/h4")
	WebElement titleReviewForBooking;
	
	
	
	public MMTFlightReview() {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validateTitle() {
		
		boolean flag = false;
		
		if(titleReviewForBooking.isDisplayed()) {
			
			flag = true;
		}
		
		return flag;
	}
	
	public String getTitle() {
		
		String title = titleReviewForBooking.getText();
		System.out.println(title);
		return title;
	}
}
