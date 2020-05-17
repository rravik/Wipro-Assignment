package com.assignment.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.assignment.BaseClass.BaseClass;



public class ElementVisibility extends BaseClass {

	//validates if element is present in DOM or not, if the element is not present in DOM and is not displayed, it will return false
	public static boolean isVisble(WebElement element)
	{
		boolean flag=false;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return flag;
		
	}
	
}
