package com.demoqa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;

public class Selectable extends BaseClass {

	@FindBy(xpath = "//ol[@id='selectable']/li")
	List<WebElement> SelectableList;

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

}
