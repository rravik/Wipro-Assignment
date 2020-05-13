package com.olay.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ukRegistrationAndSignin {

	public static WebDriver driver;
	
	
	public static String passwordText = "Test1234";
	public static String emailID = generateRandomEmail() ;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
	driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.olay.co.uk/en-gb");
	
		WebElement register = driver.findElement(By.linkText("Register"));
		//Click Register Button
		register.click();
		
		//Click Register Button
		//register.click();
		
/*
		Random rand = new Random();
		int random = rand.nextInt(999);
		
	//REGISTRATION
		String emailID = "testolayuk"+random+"@gmail.com";
		String passwordTxt = "Test1234";
		email.sendKeys(emailID);
		password.sendKeys(passwordTxt);
		confirmPassword.sendKeys(passwordTxt);
		selectDay.selectByVisibleText("16");
		selectMonth.selectByVisibleText("9");
		selectYear.selectByVisibleText("2000");
		
		*/
		
		registerRandomize();
		
		WebElement logout = driver.findElement(By.xpath("//a[@class='logoutbtn']"));
		System.out.println(logout.isDisplayed());
		logout.click();
		System.out.println("clicked successfully");
		
		WebElement logOutPopup = driver.findElement(By.xpath("//a[@title='Logout']"));
		System.out.println(driver.findElement(By.xpath("//a[@title='Logout']")).isDisplayed());
		waitUntilElementPresent(driver.findElement(By.xpath("//a[@title='Logout']")), 30);
		System.out.println(driver.findElement(By.xpath("//a[@title='Logout']")).isDisplayed());
		System.out.println(driver.findElements(By.xpath("//a[@title='Logout']")).size());
		
		//Instantiate Action Class        
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Music' to perform mouse hover 
   
     //Mouse hover menuOption 'Music'
     actions.moveToElement(logOutPopup).perform();
     System.out.println("Done Mouse hover on 'Music' from Menu");
		logOutPopup.click();
		//driver.findElement(By.xpath("//a[@title='Logout']")).click();
		
		driver.findElement(By.linkText("Sign In")).click();
		
		WebElement signInEmail = driver.findElement(By.xpath("//input[@data-key='signInEmailAddress']"));
		WebElement currentPassword = driver.findElement(By.xpath("//input[@data-key='currentPassword']"));
		signInEmail.sendKeys(emailID);
		currentPassword.sendKeys(passwordText);
		driver.findElement(By.xpath("//input[@value='SIGN IN']")).click();
		
		
		
		
	}
	
	
	public static void registerRandomize() {
		
		WebElement email = driver.findElement(By.xpath("//input[@data-key='emailAddress']"));
		WebElement password = driver.findElement(By.xpath("//input[@data-key='newPassword']"));
		WebElement confirmPassword = driver.findElement(By.xpath("//input[@data-key='newPassword']/following::input[1]"));
		WebElement day = driver.findElement(By.xpath("//*[contains(@name,'day')]"));
		WebElement month = driver.findElement(By.xpath("//*[contains(@name,'month')]"));
		WebElement year = driver.findElement(By.xpath("//*[contains(@name,'year')]"));
		WebElement submit = driver.findElement(By.xpath("//*[contains(@name,'submit')]"));
		Select selectDay = new Select(day);
		Select selectMonth = new Select(month);
		Select selectYear = new Select(year);
		
		
		//REGISTRATION
		email.sendKeys(emailID);
		password.sendKeys(passwordText);
		confirmPassword.sendKeys(passwordText);
		selectDay.selectByVisibleText("16");
		selectMonth.selectByVisibleText("9");
		selectYear.selectByVisibleText("2000");
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();	
		
		
		
		
		
	}
	
	public static String generateRandomEmail() {
		
		Random rand = new Random();
		int random = rand.nextInt(20202020);
		
		String emailID = "username"+random+"@gmail.com";
		return emailID;
	}
	
	public static void waitUntilElementPresent(WebElement ele, int maxTimeOut) {
		
		try {
			new WebDriverWait(driver, maxTimeOut).until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("WaitUntilElementPresent Exception");
		}
	}


	

}
