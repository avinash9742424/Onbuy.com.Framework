package com.Onbuy.com_test_scripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Onbuy.com_Utilityclasses.Excel_utility;
import com.Onbuy.com_Utilityclasses.File_utility;
import com.Onbuy.com_Utilityclasses.Java_utility;
import com.Onbuy.com_Utilityclasses.Web_action_utility;

import pom.Login_page;
import pom.MyAccount_Billing_page;
import pom.Myaccount_shipping_page;

public class Test_Script_Update_Shipping_add extends Web_action_utility {
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
			
			
			String  Shippingaddress= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_02"
					, "Shipping Address");
			String  Shippingstate= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_02"
					, "Shipping State");
			String  Shippingcity= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_02"
					, "Shipping City");
			String  Shippingpicode= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_02"
					, "Shipping pincode");
			
		
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
			Myaccount_shipping_page myaccount_links = new Myaccount_shipping_page(driver);
			myaccount_links.update_Shipping(Shippingaddress, Shippingstate, Shippingcity, Shippingpicode);
	
	        
			wLib.closealert(driver);
	}
}
