package com.makemytrip.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;
import com.assignment.BaseClass.CommonPageActions;

public class MMTFlightSearch extends BaseClass {
	
	Logger log = Logger.getLogger("devpinoyLogger");
	
	@FindBy(id = "sorter_btn_onward")
	WebElement departureSort;
	
	@FindBy(xpath="//button[@id='sorter_btn_onward']//following::a[@class='make_flex active'][1]")
	WebElement departureLowToHigh;
	
	@FindBy(xpath="//button[@class='fli_primary_btn text-uppercase ']")
	WebElement bookNow;
	
	@FindBy(xpath="//button[@class='btn fli_primary_btn']")
	WebElement continueBtn;
	
	//a[@class='make_flex active']

	public MMTFlightSearch() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickDepartureSort() {
		
		CommonPageActions.waitUntilElementPresent(departureSort, 30);
		CommonPageActions.highlightElement(departureSort);
		departureSort.click();
		CommonPageActions.waitUntilElementPresent(departureLowToHigh, 30);
		CommonPageActions.highlightElement(departureLowToHigh);
		departureLowToHigh.click();
		bookNow.click();
		CommonPageActions.waitUntilElementPresent(continueBtn, 30);
		continueBtn.click();
		
	}

}
