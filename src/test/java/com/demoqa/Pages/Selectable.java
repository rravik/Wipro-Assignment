package com.demoqa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;
import com.assignment.BaseClass.CommonPageActions;

public class Selectable extends BaseClass {

	@FindBy(xpath = "//ol[@id='selectable']/li")
	List<WebElement> SelectableList;
	
	@FindBy(xpath = "//li[@data-cy='menu_Flights']")
	WebElement flightsMenu;
	
	@FindBy(xpath = "//li[@data-cy='menu_Hotels']")
	WebElement hotelsMenu;

	public Selectable() {

		PageFactory.initElements(driver, this);
	}

	public void selectAndPrintEachItem() {

		//Size of List items
		int sizeOfList = SelectableList.size();
		
		//Iterate to click each item and printing each item text
		for (int i = 0; i < sizeOfList; i++) {

			SelectableList.get(i).click();
			System.out.println(SelectableList.get(i).getText());
		}
	}
	
public void clickFlightMenu() {
		
		flightsMenu.click();
	}
	
	public void clickHotelsMenu() {
		
		hotelsMenu.click();
	}
	
	public void waitforelement() {
		
		CommonPageActions.waitUntilElementPresent(hotelsMenu, 60);
		CommonPageActions.highlightElement(flightsMenu);
		CommonPageActions.highlightElement(hotelsMenu);
	}

}
