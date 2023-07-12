package com.Onbuy.com.TestNG;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Onbuy.com_Utilityclasses.Base_class;

import pom.Home_page;
import pom.Login_page;
import pom.MyAccount_Billing_page;
//@Listeners(com.Onbuy.com_Utilityclasses.ListnerClass_implementation.class)
public class TsetScript_bill_add_update_test extends Base_class {
   
	
	@Test(groups = {"reg test"})
	public void Update_billadd_test() throws IOException, Throwable
	{
		String TEST_SCRIPT_EXCEL_FILE_PATH =    flib.getFilePathFromPropertiesFile("testScriptdatafilePath");

	
		String  ENV_FILE_PATH =    flib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String URL = flib.getDataFromProperties(ENV_FILE_PATH, "urluser");
		  String USERNAME = flib.getDataFromProperties(ENV_FILE_PATH, "usernameUser");
		   String PASSWORd = flib.getDataFromProperties(ENV_FILE_PATH, "passwordUser");
		
		 driver.get(URL);
		   
		   Login_page login=new Login_page(driver);
		   login.loginToApp(USERNAME, PASSWORd);
		   
		   ENV_FILE_PATH =    flib.getFilePathFromPropertiesFile("projectConfigDataFilePath");   
	String  Billingaddress= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_01"
			, "Billing Address");
	String  Billingstate= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_01"
			, "Billing State");
	String  Billingcity= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_01"
			, "Billing City");
	String  Billingpicode= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_01"
			, "Billing pincode");
	
	/*step 2 : navigate to myaccount page*/		
	MyAccount_Billing_page myaccount_link = new MyAccount_Billing_page(driver);
	myaccount_link.update_billing(Billingaddress,Billingstate,Billingcity,Billingpicode);
	
	
	wlib.closealert(driver);
	
	
	 Home_page home1=new Home_page(driver);
	   home1.logoutUser();
	
	}
}
