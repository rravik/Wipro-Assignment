package com.demoqa.Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.assignment.BaseClass.BaseClass;
import com.assignment.BaseClass.CommonPageActions;

public class DatePicker extends BaseClass {

	
	@FindBy(xpath = "//input[@id='datepicker']")
	WebElement dateBox;

	public DatePicker() {

		PageFactory.initElements(driver, this);
	}
	
	public void enterDate() {
		
		LocalDate randomDOB = CommonPageActions.randomDateOfBirth();
		String date = String.valueOf(randomDOB.getDayOfMonth()) ;
		String  month = String.valueOf(randomDOB.getMonthValue()) ;
		String year = String.valueOf(randomDOB.getYear());
		
		String fullDate = month+"/"+date+"/"+year;
		
		if(validateJavaDate(fullDate)) {
			dateBox.sendKeys(fullDate, Keys.ENTER);
		} else {
			Assert.assertTrue(false, fullDate+ " is Invalid Date Format");
		}
		
		
	}
	
	
	 public static boolean validateJavaDate(String strDate)
	   {
		/* Check if date is 'null' */
		if (strDate.trim().equals(""))
		{
		    return true;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try
		    {
		        Date javaDate = sdfrmt.parse(strDate); 
		        System.out.println(strDate+" is valid date format");
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        System.out.println(strDate+" is Invalid Date format");
		        return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
	   }
}
