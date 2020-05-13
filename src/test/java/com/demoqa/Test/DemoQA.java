package com.demoqa.Test;


import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.BaseClass.BaseClass;
import com.assignment.BaseClass.CommonPageActions;
import com.demoqa.Pages.ContactForm;
import com.demoqa.Pages.ControlGroup;
import com.demoqa.Pages.DatePicker;
import com.demoqa.Pages.Droppable;
import com.demoqa.Pages.SelectMenu;
import com.demoqa.Pages.Selectable;


public class DemoQA extends BaseClass {
	
	Selectable select;
	ContactForm form;
	Droppable drop;
	DatePicker datePick;
	SelectMenu selectMenu;
	ControlGroup ctrlGrp;
	

	
	@BeforeMethod
	public void setUp() throws Exception{
		launchBrowser("chrome");
		select = new Selectable();	
		form = new ContactForm();
		drop = new Droppable();
		datePick = new DatePicker();
		selectMenu = new SelectMenu();
		ctrlGrp = new ControlGroup();
		
	}
	
	
	public void TC001_SelectableTest() throws Exception {
		
		openURL("https://demoqa.com/selectable/");
		select.selectAndPrintEachItem();
				
	}
	
	
	
	public void TC002_ContactFormTest() {
		
		openURL("https://demoqa.com/html-contact-form/");
		form.enterContactForm("Ravi", "kumar", "India", "New Subject");
		form.openGoogleLink();
		form.openGoogleLinkIsHere();
		form.clickSubmit();
		
	}
	
	
	public void TC003_DragAndDropTest() {
		
		openURL("https://demoqa.com/droppable/");
		drop.verifyDragAndDrop();
			
	}
	
	@Test
	public void TC004_DatepickerTest() {
		
		openURL("https://demoqa.com/datepicker/");
		datePick.enterDate();

	}
	
	
	public void TC005_SelectMenuTest() {
		
		openURL("https://demoqa.com/selectmenu/");
		selectMenu.select_Speed_Menu_And_Print_Speed_Items();
		selectMenu.select_File_Menu_And_Print_File_Items();
		selectMenu.select_Number_Menu_And_Print_Number_Items();
		selectMenu.select_Title_Menu_And_Print_Title_Items();
		
	}
	
	
	public void TC006_Horizontal_ControlGroupTest() {
	
		openURL("https://demoqa.com/controlgroup/");
		ctrlGrp.selectAnyCarType();
		ctrlGrp.selectStandardORAutomatic("standard");
		ctrlGrp.selectInsurance();
		ctrlGrp.numberOfCars(5);
		ctrlGrp.clickBookNow();
	}
	
	
	public void TC006_001_Vertical_ControlGroupTest() {
	
		openURL("https://demoqa.com/controlgroup/");
		ctrlGrp.selectAnyCarType_V();
		ctrlGrp.selectStandardORAutomatic_V("standard");
		ctrlGrp.selectInsurance_V();
		ctrlGrp.numberOfCars_V(5);
		ctrlGrp.clickBookNow_V();
	}
	
	
	public void test() {
		
		
		
	}

}
