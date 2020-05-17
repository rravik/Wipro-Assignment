package com.assignment.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.assignment.BaseClass.BaseClass;



public class PageScroll extends  BaseClass{

	//Scrolls till the bottom of page
	public static void toBottomOfPage()
	{
		try {
		    long Height =Long.parseLong(((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight").toString());

		    while (true) {
		        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        Thread.sleep(500);

		        long newHeight = Long.parseLong(((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight").toString());
		        if (newHeight == Height) {
		            break;
		        }
		        Height = newHeight;
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	//Scrolls to top of page
	public static void toUP()
	{
		    
		     ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");
	
	}
	//Scrolls till element view
	public static void toElement(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
