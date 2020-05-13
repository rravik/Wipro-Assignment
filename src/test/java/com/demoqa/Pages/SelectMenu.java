package com.demoqa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;

public class SelectMenu extends BaseClass {

	@FindBy(xpath = "//span[@id='speed-button']")
	WebElement speedDropdown;

	@FindBy(xpath = "//ul[@id='speed-menu']/li[@class='ui-menu-item']")
	List<WebElement> speedMenuItems;

	@FindBy(xpath = "//span[@id='speed-button']/span[@class='ui-selectmenu-text'][1]")
	WebElement selectedSpeed;

	@FindBy(xpath = "//span[@id='files-button']")
	WebElement fileDropdown;

	@FindBy(xpath = "//ul[@id='files-menu']/li[@class='ui-menu-item']")
	List<WebElement> fileMenuItems;

	@FindBy(xpath = "//span[@id='files-button']/span[@class='ui-selectmenu-text'][1]")
	WebElement selectedFile;

	@FindBy(xpath = "//span[@id='number-button']")
	WebElement numberDropdown;

	@FindBy(xpath = "//ul[@id='number-menu']/li[@class='ui-menu-item']")
	List<WebElement> numberMenuItems;

	@FindBy(xpath = "//span[@id='number-button']/span[@class='ui-selectmenu-text'][1]")
	WebElement selectedNumber;

	@FindBy(xpath = "//span[@id='salutation-button']")
	WebElement titleDropdown;

	@FindBy(xpath = "//ul[@id='salutation-menu']/li[@class='ui-menu-item']")
	List<WebElement> titleMenuItems;

	@FindBy(xpath = "//span[@id='salutation-button']/span[@class='ui-selectmenu-text'][1]")
	WebElement selectedTitle;

	public SelectMenu() {

		PageFactory.initElements(driver, this);
	}

	public void select_Speed_Menu_And_Print_Speed_Items() {

		speedDropdown.click();

		for (int i = 0; i < speedMenuItems.size(); i++) {
			// clicking each menu items
			speedMenuItems.get(i).click();
			System.out.println("Speed dropdown Menu items: " + selectedSpeed.getText());
			speedDropdown.click();
		}
		speedDropdown.sendKeys(Keys.ENTER);
		System.out.println("****************************************************");
	}

	public void select_File_Menu_And_Print_File_Items() {

		fileDropdown.click();
		for (int i = 0; i < fileMenuItems.size(); i++) {
			// clicking each menu items
			fileMenuItems.get(i).click();
			System.out.println("File Dropdown menu items: " + selectedFile.getText());
			fileDropdown.click();
		}

		fileDropdown.sendKeys(Keys.ENTER);
		System.out.println("****************************************************");

	}

	public void select_Number_Menu_And_Print_Number_Items() {

		numberDropdown.click();
		for (int i = 0; i < numberMenuItems.size(); i++) {

			if (i == 0) {

				// clicking each number menu items
				numberMenuItems.get(i).click();
				System.out.println("Number Dropdown menu items: " + selectedNumber.getText());
				numberDropdown.click();

			} else {

				numberDropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ESCAPE);
				System.out.println("Number Dropdown menu items: " + selectedNumber.getText());
				numberDropdown.click();
			}

		}
		numberDropdown.sendKeys(Keys.ENTER);
		System.out.println("****************************************************");

	}

	public void select_Title_Menu_And_Print_Title_Items() {

		titleDropdown.click();
		for (int i = 0; i < titleMenuItems.size(); i++) {
			// clicking each menu items
			titleMenuItems.get(i).click();
			// print selected menu items
			System.out.println("Title Dropdown menu items: " + selectedTitle.getText());
			titleDropdown.click();
		}

		titleDropdown.sendKeys(Keys.ENTER);
		System.out.println("****************************************************");
	}
}
