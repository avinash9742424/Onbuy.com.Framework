package com.Onbuy.com.TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Onbuy.com_Utilityclasses.Base_class;
import com.Onbuy.com_Utilityclasses.Excel_utility;
import com.Onbuy.com_Utilityclasses.File_utility;
import com.Onbuy.com_Utilityclasses.Java_utility;
import com.Onbuy.com_Utilityclasses.ListnerClass_implementation;
import com.Onbuy.com_Utilityclasses.Web_action_utility;

import pom.Admin_login_page;
import pom.Admin_logout_page;
import pom.Home_page;
import pom.Login_page;
import pom.My_cart_page;
import pom.Myaccount_Pay_pending;
import pom.Order_Status_page;
import pom.Todays_order_page;
import pom.Update_order_page;


//@Listeners(com.Onbuy.com_Utilityclasses.ListnerClass_implementation.class)
public class TestScript_Placeorder_Ckeck_test extends Base_class {
    

	@Test(groups = {"smoke test"})
	public void place_order() throws Throwable,IOException{		
			
		/*test script data*/
		int randomNum = jlib.getRandomNumber();
		
		  String TEST_SCRIPT_EXCEL_FILE_PATH =    flib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		  String URL = flib.getDataFromProperties(ENV_FILE_PATH, "urluser");
		  String USERNAME = flib.getDataFromProperties(ENV_FILE_PATH, "usernameUser");
		   String PASSWORd = flib.getDataFromProperties(ENV_FILE_PATH, "passwordUser");
		   
		String  Products= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_03"
				
				, "Products");
		  driver.get(URL);
		   
		   Login_page login=new Login_page(driver);
		   login.loginToApp(USERNAME, PASSWORd);
		/**
		 * search the products
		 */
		
		Home_page home=new Home_page(driver);
		home.searching_product(Products);
		try {
		wlib.closealert(driver);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		/**
		 *this class is for my cart page
		 */
		
		My_cart_page mycart=new My_cart_page(driver);
		mycart.mycart();
		
		/**
		 * proceed the pending payment
		 */
		
		Myaccount_Pay_pending pay=new Myaccount_Pay_pending(driver);
		pay.Pyment_order();
		 Home_page home1=new Home_page(driver);
		   home1.logoutUser();
	}
            
     @Test(dependsOnMethods ="place_order", groups = {"smoke test"})//retryAnalyzer = com.Onbuy.com_Utilityclasses.Retry_Implementation.class)
     public void Change_order_status() throws IOException, Throwable
     {
		
			   String AdURL = flib.getDataFromProperties(ENV_FILE_PATH, "urladmin");
			 String USERNAME1 = flib.getDataFromProperties(ENV_FILE_PATH, "usernameAdmin");
			   String PASSWORd1 = flib.getDataFromProperties(ENV_FILE_PATH, "passwordAdmin");
			   
			   driver.get(AdURL);
			  
			/**
			 * login as admin
			 */
			   Admin_login_page adlog=new Admin_login_page(driver);
			   adlog.loginToApp(USERNAME1, PASSWORd1);
			   
			   String TEST_SCRIPT_EXCEL_FILE_PATH =    flib.getFilePathFromPropertiesFile("testScriptdatafilePath");
			   String  PartialWindowTitle= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_03"
						, "partialWindowTitle");
	           String  remarks= elib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_03"
						, "Remarks");
		
			
			Todays_order_page order = new Todays_order_page(driver);
			order.todaysorder(driver, PartialWindowTitle);
			
			Order_Status_page orderstatus=new Order_Status_page(driver);
			orderstatus.updateTheOrder(driver, remarks,"Admin| Pending Orders");
			
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			 
			  Update_order_page uporder=new Update_order_page(driver);
			  uporder.validateOrderID();
			  
			  
			Admin_logout_page adlogout=new Admin_logout_page(driver);
			  adlogout.logout();
			
     }
}
