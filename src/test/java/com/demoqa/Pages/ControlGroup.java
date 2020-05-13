package com.demoqa.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;

public class ControlGroup extends BaseClass {

	@FindBy(xpath = "//button[contains(@class, 'ui-button ui-corner-right')]")
	WebElement btnBookNow;

	@FindBy(xpath = "//button[contains(@class, 'ui-button ui-corner-bottom')]")
	WebElement V_btnBookNow;
	
	@FindBy(id = "horizontal-spinner")
	WebElement noOfCars;
	
	@FindBy(id = "vertical-spinner")
	WebElement V_noOfCars;

	@FindBy(xpath = "//label[@for='insurance']/span[1]")
	WebElement ins;
	
	@FindBy(xpath = "//label[@for='insurance-v']")
	WebElement V_ins;
	

	@FindBy(xpath = "//label[@for='transmission-standard']")
	WebElement optionStandard;
	
	@FindBy(xpath = "//label[@for='transmission-standard-v']")
	WebElement V_optionStandard;

	@FindBy(xpath = "//label[@for='transmission-automatic']")
	WebElement optionAutomatic;
	
	@FindBy(xpath = "//label[@for='transmission-automatic-v']")
	WebElement V_optionAutomatic;

	@FindBy(xpath = "//span[@id='car-type-button']")
	WebElement btnCarType;
	
	@FindBy(xpath = "//span[@id='ui-id-8-button']")
	WebElement V_btnCarType;

	@FindBy(xpath = "//ul[@id='car-type-menu']/li/div")
	List<WebElement> carMenus;

	@FindBy(xpath = "//ul[@id='ui-id-8-menu']/li/div")
	List<WebElement> V_carMenus;
	
	
	public ControlGroup() {

		PageFactory.initElements(driver, this);
	}

	//SELECT ANY RANDOM HORIZONTAL CAR TYPE
	public void selectAnyCarType() {

		btnCarType.click();
		int sizeOfCarTypes = carMenus.size();

		Random rand = new Random();
		int random = rand.nextInt(sizeOfCarTypes) + 1;

		WebElement carMenu;
		try {
			carMenu = driver.findElement(By.xpath("//ul[@id='car-type-menu']/li["+ random +"]/div"));
			System.out.println(carMenu.getText() +" Menu is selected");
			carMenu.click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e + ": menu is not available");
		}

	}
	
	//SELECT ANY RANDOM VERTICAL CAR TYPE
		public void selectAnyCarType_V() {

			V_btnCarType.click();
			int sizeOfCarTypes = V_carMenus.size();

			Random rand = new Random();
			int random = rand.nextInt(sizeOfCarTypes) + 1;

			WebElement carMenu;
			try {
				carMenu = driver.findElement(By.xpath("//ul[@id='ui-id-8-menu']/li["+ random +"]/div"));
				System.out.println(carMenu.getText() +" Menu is selected");
				carMenu.click();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e + ": menu is not available");
			}

		}
	
	//SELECT HORIZONTAL SPECIFIT CAR TYPE PASSING STRING
	public void selectSpecificCarType(String typeOfCar) {

		btnCarType.click();

		WebElement carMenu;
		try {
			carMenu = driver.findElement(By.xpath("//ul[@id='car-type-menu']/li/div[text()='" + typeOfCar + "']"));
			carMenu.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e + ": Given menu is not available");
		}

	}
	
	//SELECT VERTICAL SPECIFIT CAR TYPE PASSING STRING
		public void selectSpecificCarType_V(String typeOfCar) {

			V_btnCarType.click();

			WebElement carMenu;
			try {
				carMenu = driver.findElement(By.xpath("//ul[@id='car-type-menu']/li/div[text()='" + typeOfCar + "']"));
				carMenu.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e + ": Given menu is not available");
			}

		}
	
	
	//SELECT ANY TRANSMISSION (STANDARD/AUTOMATIC) FOR HORIZONTAL
	public  void selectStandardORAutomatic(String selectTransmission) {

		if (selectTransmission.equalsIgnoreCase("standard")) {

			optionStandard.click();
		} else if (selectTransmission.equalsIgnoreCase("automatic")) {

			optionAutomatic.click();
		} else {
			System.out.println("Given Transmission type is not available");
		}

	}
	
	
	//SELECT ANY TRANSMISSION (STANDARD/AUTOMATIC) FOR VERTICAL
		public  void selectStandardORAutomatic_V(String selectTransmission) {

			if (selectTransmission.equalsIgnoreCase("standard")) {

				V_optionStandard.click();
			} else if (selectTransmission.equalsIgnoreCase("automatic")) {

				V_optionAutomatic.click();
			} else {
				System.out.println("Given Transmission type is not available");
			}

		}
		
	//SELECT INSURANCE CHECKBOX
	public  void selectInsurance() {

		ins.click();
	}
	
	//SELECT INSURANCE CHECKBOX
		public  void selectInsurance_V() {

			V_ins.click();
		}

	//ENTER NUMBER OF CARD for HORIZONTAL
	public  void numberOfCars(int num) {
		String convNum = String.valueOf(num);
		noOfCars.sendKeys(convNum);

	}
	
	//ENTER NUMBER OF CARD for VERTICAL
		public  void numberOfCars_V(int num) {
			String convNum = String.valueOf(num);
			V_noOfCars.sendKeys(convNum);

		}
	

	//CLICK ON BOOK NOW BUTTON FOR HORIZONTAL
	public  void clickBookNow() {

		btnBookNow.click();

	}
	
	//CLICK ON BOOK NOW BUTTON FOR VERTICAL
		public  void clickBookNow_V() {

			V_btnBookNow.click();

		}

}
