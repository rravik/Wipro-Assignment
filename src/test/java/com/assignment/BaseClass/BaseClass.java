package com.assignment.BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.assignment.Utils.Json_Reader;
import com.demoqa.Pages.Selectable;
import com.olay.Pages.HomePage;
import com.olay.Pages.LoginPage;
import com.olay.Pages.UK_Registration;

public class BaseClass extends Json_Reader {

	public static WebDriver driver;

	
	

	public static void launchBrowser(String BrowserName) throws Exception {

		if (BrowserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} 
		else if (BrowserName.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} 
		else {

			throw new Exception("Invalid Browser Name");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public static void openURL(String url) {
		
		driver.get(url);
	}
	
	
}
