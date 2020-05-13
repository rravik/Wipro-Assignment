package com.assignment.BaseClass;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPageActions extends BaseClass {

	//HIGHLIGHT ELEMENT
	public static void highlightElement(WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);

	}

	//OPEN THE LINK IN NEW TAB
	public static void openLinkWithNewTab(WebElement elementCTRLClick) {

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		elementCTRLClick.sendKeys(selectLinkOpeninNewTab);
	}

	//WAIT FOR ELEMENT VISIBLE
	public static void waitUntilElementPresent(WebElement ele, int maxTimeOut) {

		try {
			new WebDriverWait(driver, maxTimeOut).until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("WaitUntilElementPresent Exception");
		}
	}

	//DROPDOWN SELECT BY TEXT
	public static void selectByVisibleText(WebElement ele, String enterTxt) {
		
		Select select = new Select(ele);
		select.selectByVisibleText(enterTxt);
		
	}
	
	//GET RANDOM DATE OF BIRTH
	public static LocalDate randomDateOfBirth() {
	   // final int maxAge = 100 * 12 * 31;
	    //return LocalDate.now().minusDays(new Random().nextInt(maxAge));
		
		LocalDate startDate = LocalDate.of(1900, 1, 1); //start date
	    long start = startDate.toEpochDay();
	    System.out.println(start);

	    LocalDate endDate = LocalDate.of(2006, 12, 31); //end date
	    long end = endDate.toEpochDay();
	    System.out.println(start);

	    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
	    return LocalDate.ofEpochDay(randomEpochDay); 
	}
	
	//SCROLL TO PARTICULAR WEBELEMENT
	public static void scrollToElement(WebElement ele) {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	//CLICK METHOD USING JAVASCRIPT EXECUTOR
	public static void clickUsingJavascript(WebElement ele) {
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) driver).executeScript(js, ele);
		ele.click();
	}
	
	
	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	
	
}
