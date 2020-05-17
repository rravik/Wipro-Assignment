package com.olay.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.BaseClass.BaseClass;
import com.assignment.Utils.Json_Reader;
import com.assignment.Utils.Xls_Reader;

import com.olay.Pages.ForgotPasswordPage;
import com.olay.Pages.Germary_Registration;
import com.olay.Pages.HomePage;
import com.olay.Pages.LoginPage;
import com.olay.Pages.UK_Registration;

public class germanyRegistrationTest extends BaseClass{
	
	Germary_Registration germaryRegister;
	LoginPage loginPage;
	HomePage home;
	ForgotPasswordPage forgotPwdPage;
	Json_Reader ddt = new Json_Reader();
	

	public String username = "username7150391@gmail.com";

	@BeforeMethod
	public void setUp() throws Exception {

		launchBrowser();
		germaryRegister = new Germary_Registration();
		loginPage = new LoginPage();
		home = new HomePage();

		openURL("https://www.olaz.de/de-de");

	}

	//Country should be "Deutschland", AND "Österreich"
	//@Test
	public void registrationAndLoginTest() throws Exception {

		// OPEN URL

		// NEW REGISTRATION
		germaryRegister.enterRegistrationForm("Ravi", "Kumar", "Male", "Address1", "Berlin", "10115", "Deutschland");


		// LOGIN FOR SIGNIN
		//loginPage.login();

		// verify the signout button of login
		boolean signoutIsdisplayed = germaryRegister.verifySignOutButton();
		Assert.assertTrue(signoutIsdisplayed, "Sign Out link is not displayed");

	}
	
	@Test
	public void UK_RegistrationUsingExcel() throws Exception {
		
		String excelPath = "./src\\test\\java\\com\\olay\\testdata\\Registration.xlsx";
		String sheetName = "Germany_Registration_Data";
		

		Xls_Reader reader = new Xls_Reader(excelPath);

		//Getting Row count
		int rowCount = reader.getRowCount(sheetName);
		
			
			for(int rowNum=2; rowNum<=rowCount; rowNum++){
				String fName =  reader.getCellData(sheetName, "FirstName", rowNum);
				String lName =  reader.getCellData(sheetName, "LastName", rowNum);
				String gender =  reader.getCellData(sheetName, "Gender", rowNum);
				String emailAddress = reader.getCellData(sheetName, "Email", rowNum);
				String password = reader.getCellData(sheetName, "Password", rowNum);
				String confirmPassword = reader.getCellData(sheetName, "Confirm Password", rowNum);
				String date = reader.getCellData(sheetName, "Date", rowNum);
				String address = reader.getCellData(sheetName, "Address", rowNum);
				String city = reader.getCellData(sheetName, "City", rowNum);
				String zipcode = reader.getCellData(sheetName, "Postalcode", rowNum);
				String country = reader.getCellData(sheetName, "Country", rowNum);
				
				String status = reader.getCellData(sheetName, "Status", rowNum);

				int zip = (int) Double.parseDouble(zipcode);
				String zipString = String.valueOf(zip);
				System.out.println("Zipcode converting to double:" + zip);
				
				
				if(status.isEmpty()) {
					System.out.println("It is  empty");
				System.out.println(zipcode);
					
					germaryRegister.enterRegistrationFormUsingTestDataFile(fName, lName, gender, emailAddress, password, confirmPassword, date, address, city, zipString, country);
					
					//boolean signoutIsdisplayed = germaryRegister.verifySignOutButton();
					//Assert.assertTrue(signoutIsdisplayed, "Sign Out link is not displayed");
					
					//reader.setCellData(sheetName, "Status", rowNum, "Registered");
					
					
					break;
				}
				
			}	
			
			
			
			
		

	}

}
