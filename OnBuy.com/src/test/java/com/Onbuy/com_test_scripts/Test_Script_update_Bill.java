package com.Onbuy.com_test_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Onbuy.com_Utilityclasses.Excel_utility;
import com.Onbuy.com_Utilityclasses.File_utility;
import com.Onbuy.com_Utilityclasses.Java_utility;
import com.Onbuy.com_Utilityclasses.Web_action_utility;
import java.io.IOException;
import pom.Login_page;
import pom.MyAccount_Billing_page;

public class Test_Script_update_Bill extends Web_action_utility {

	@Test
	public void update_bill_add() throws Throwable,IOException{		
		/*create Object for utility */
		File_utility fLib = new File_utility();
		Excel_utility eLib = new Excel_utility();
		Java_utility jLib = new Java_utility();
		Web_action_utility wLib = new Web_action_utility();
		
		/*get the FILE PATH*/
	       String ENV_FILE_PATH =    fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
	       String TEST_SCRIPT_EXCEL_FILE_PATH =    fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
	       
	       /*Read the common data*/
		   String BROWSER = fLib.getDataFromProperties(ENV_FILE_PATH, "browser");
		   String geckokey = fLib.getDataFromProperties(ENV_FILE_PATH, "geckokey");
		   String geckovalue = fLib.getDataFromProperties(ENV_FILE_PATH, "geckovalue");
		   String URL = fLib.getDataFromProperties(ENV_FILE_PATH, "urluser");
		   String USERNAME = fLib.getDataFromProperties(ENV_FILE_PATH, "usernameUser");
		   String PASSWORd = fLib.getDataFromProperties(ENV_FILE_PATH, "passwordUser");
	       
			/*test script data*/
			int randomNum = jLib.getRandomNumber();
			
			
			String  Billingaddress= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_01"
					, "Billing Address");
			String  Billingstate= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_01"
					, "Billing State");
			String  Billingcity= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_01"
					, "Billing City");
			String  Billingpicode= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_01"
					, "Billing pincode");
			
		
			WebDriver driver = null;
			 System.setProperty(geckokey, geckovalue);
			/*step 1 : login to app*/
			if(BROWSER.equalsIgnoreCase("chrome")) {		
			    driver = new ChromeDriver();
			}else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else if(BROWSER.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}else {
			    driver = new ChromeDriver();
			}
			wLib.waitForElementInDOM(driver);
			driver.get(URL);
			
			//LoginToApplication
			Login_page loginPage = new Login_page(driver);
			loginPage.loginToApp(USERNAME, PASSWORd);
			
			/*step 2 : navigate to myaccount page*/		
			MyAccount_Billing_page myaccount_link = new MyAccount_Billing_page(driver);
			myaccount_link.update_billing(Billingaddress,Billingstate,Billingcity,Billingpicode);
			
			wLib.closealert(driver);
			
			/*verify expected result*/
			//MyAccount_Billing_page verifybillingPage = new MyAccount_Billing_page(driver);
			//String actual_data = verifybillingPage.update_billing(Billingaddress, Billingstate, Billingcity, Billingpicode);
	         //if(actual_data.contains(Billingaddress)) {
	        	// System.out.println(Billingaddress+ "is verified PASS");
	     //    }else {
	       // 	 System.out.println(Billingaddress+ "is not verified FAIL");
	         }
	        
			
}



