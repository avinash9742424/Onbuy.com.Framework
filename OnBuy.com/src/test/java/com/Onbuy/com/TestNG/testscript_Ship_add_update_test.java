package com.Onbuy.com.TestNG;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Onbuy.com_Utilityclasses.Base_class;

import pom.Home_page;
import pom.Login_page;
import pom.Myaccount_shipping_page;
@Listeners(com.Onbuy.com_Utilityclasses.ListnerClass_implementation.class)
public class testscript_Ship_add_update_test extends Base_class {

	@Test(groups = {"reg test"})
	public void update_bill_add() throws IOException, Throwable
	{
		
		 ENV_FILE_PATH =    flib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String TEST_SCRIPT_EXCEL_FILE_PATH =    flib.getFilePathFromPropertiesFile("testScriptdatafilePath");
	String  Shippingaddress= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_02"
			, "Shipping Address");
	String  Shippingstate= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_02"
			, "Shipping State");
	String  Shippingcity= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_02"
			, "Shipping City");
	String  Shippingpicode= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_02"
			, "Shipping pincode");
     
	String URL = flib.getDataFromProperties(ENV_FILE_PATH, "urluser");
	  String USERNAME = flib.getDataFromProperties(ENV_FILE_PATH, "usernameUser");
	   String PASSWORd = flib.getDataFromProperties(ENV_FILE_PATH, "passwordUser");
	   
	   driver.get(URL);
	   
	   Login_page login=new Login_page(driver);
	   login.loginToApp(USERNAME, PASSWORd);

	/*step 2 : navigate to myaccount page*/		
	Myaccount_shipping_page myaccount_links = new Myaccount_shipping_page(driver);
	myaccount_links.update_Shipping(Shippingaddress, Shippingstate, Shippingcity, Shippingpicode);

    
	wlib.closealert(driver);
	 Home_page home1=new Home_page(driver);
	   home1.logoutUser();
}
}

