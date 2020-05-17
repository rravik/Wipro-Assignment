package com.olay.Test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.BaseClass.BaseClass;
import com.assignment.Utils.Json_Reader;
import com.assignment.Utils.Xls_Reader;
import com.olay.Pages.ForgotPasswordPage;
import com.olay.Pages.HomePage;
import com.olay.Pages.LoginPage;
import com.olay.Pages.UK_Registration;

public class ukRegistrationTest extends BaseClass {

	UK_Registration ukRegister;
	LoginPage loginPage;
	HomePage home;
	ForgotPasswordPage forgotPwdPage;
	Json_Reader ddt = new Json_Reader();

	public String username = "username7150391@gmail.com";

	@BeforeMethod
	public void setUp() throws Exception {

		launchBrowser();
		ukRegister = new UK_Registration();
		loginPage = new LoginPage();
		forgotPwdPage = new ForgotPasswordPage();

		openURL("https://www.olay.co.uk/en-gb");

	}

	// @Test
	public void registrationAndLoginTest() throws Exception {

		// OPEN URL

		// NEW REGISTRATION
		ukRegister.enterRegistrationForm();

		// SINGOUT FOR AFTER REGISTRATION
		ukRegister.signOut();

		// LOGIN FOR SIGNIN
		loginPage.login();

		// verify the signout button of login
		boolean signoutIsdisplayed = ukRegister.verifySignOutButton();
		Assert.assertTrue(signoutIsdisplayed, "Sign Out link is not displayed");

	}

	// @Test
	public void validateInvalidEmailAndPassword() {

		loginPage.clicksingInLink();
		loginPage.setEmailAddress(username);
		loginPage.setPassword("invalidPassword");
		loginPage.clickSingInBtn();
		boolean errorMSG = loginPage.errorMsgForInvalid_UN_And_PWD();

		String msg = loginPage.getErrorValidationMessage();

		System.out.println(msg);

		// Verify the validation error message
		if (errorMSG) {

			Assert.assertEquals(msg, loginPage.errorMSG);
		}

	}

	public void validateForgotPassword() {

		loginPage.clicksingInLink();
		loginPage.clickForgotPassword();
		forgotPwdPage.setEmailAddress(username);
		forgotPwdPage.clickNextButton();
		boolean forgotMSG = forgotPwdPage.validateMessageForForgotPassword();

		String msg = forgotPwdPage.getForgotPasswordValidationMessage();

		// Verify the validation forgot message
		if (forgotMSG) {

			if (msg.contains(forgotPwdPage.forgotMessage)) {

				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

	}

	//@Test(dataProvider = "dp")
	public void UK_RegistrationUsingJSON(String data) {

		String register[] = data.split(",");
		String emailAddress = register[0];
		String password = register[1];
		String confirmPassword = register[2];
		String date = register[3];

		System.out.println(emailAddress);
		System.out.println(password);
		System.out.println(confirmPassword);
		System.out.println(date);

		ukRegister.enterRegistrationFormUsingTestDataFile(emailAddress, password, confirmPassword, date);
		Assert.assertTrue(ukRegister.verifySignOutButton(), "Registration is not successfull");

	}

	@Test
	public void UK_RegistrationUsingExcel() throws Exception {
		
		String excelPath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\olay\\testdata\\Registration.xlsx";
		String sheetName = "Registration_Data";

		Xls_Reader reader = new Xls_Reader(excelPath);

		//Getting Row count
		int rowCount = reader.getRowCount(sheetName);
		
			
			for(int rowNum=2; rowNum<=rowCount; rowNum++){
				String emailAddress = reader.getCellData(sheetName, "Email", rowNum);
				String password = reader.getCellData(sheetName, "Password", rowNum);
				String confirmPassword = reader.getCellData(sheetName, "Confirm Password", rowNum);
				String date = reader.getCellData(sheetName, "Date", rowNum);
				String status = reader.getCellData(sheetName, "Status", rowNum);

				//System.out.println(emailAddress + " : " + password+ " : " + confirmPassword+ " : " +date +" : "+status);
				
				if(status.isEmpty()) {
					System.out.println("It is  empty");
					ukRegister.enterRegistrationFormUsingTestDataFile(emailAddress, password, confirmPassword, date);
					
					Assert.assertTrue(ukRegister.verifySignOutButton(), "Already Registered OR Registration is not successfull");
					reader.setCellData(sheetName, "Status", rowNum, "Registered");
					// SINGOUT FOR AFTER REGISTRATION
					ukRegister.signOut();
					
					break;
				}
				
			}	
			
			
			
			
		

	}

}
