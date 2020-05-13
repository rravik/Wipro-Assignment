package com.assignment.Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.assignment.BaseClass.BaseClass;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.olay.Pages.UK_Registration;

public class Json_Reader {
	
	

	//Reading Data from Json
	
	@DataProvider(name="dp")
	public String[] readRegistrationDataFromJson() throws IOException, ParseException {
		
		//create the object for JsonParser
		JSONParser jsonParser = new JSONParser();
		
		//Reading the json file using File Reader
		FileReader reader = new  FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\olay\\testdata\\registration.json");
		
		//Add the file in jsonparser object
		Object obj = jsonParser.parse(reader);
		
		//creating the jsonObject and casting the object
		JSONObject userRegistrationJsonObj = (JSONObject) obj;
	
		//call the array data from json	
		JSONArray userRegistrationArray = (JSONArray) userRegistrationJsonObj.get("Employees");
		
		//All the array data store it in Java String Array
		String arr[] = new String[userRegistrationArray.size()];
		
		//Fetch the data from json file and store it in String array using forloop
		for(int i=0; i<userRegistrationArray.size(); i++) {
			
		JSONObject registrationData = (JSONObject) userRegistrationArray.get(i);
		String emailAddress = (String) registrationData.get("email");
		String password = (String) registrationData.get("password");
		String confirmPassword = (String) registrationData.get("confirmPassword");
		String date = (String) registrationData.get("date");
		
		arr[i] = emailAddress+","+password+","+confirmPassword+","+date;
		
		}
		
		return arr;
	}
	
	/*
	
	@Test(dataProvider = "dp")
	public void fetchData(String data) {
		
		
		
		String register[] = data.split(",");
		String emailAddress = register[0];
		String password = register[1];
		String confirmPassword = register[2];
		String date = register[3];
		
		System.out.println(emailAddress);
		System.out.println(password);
		System.out.println(confirmPassword);
		System.out.println(date);
		

		
		//ukRegister.enterRegistrationFormUsingJsonFile(emailAddress, password, confirmPassword, date);
		
		
	}
*/
}
