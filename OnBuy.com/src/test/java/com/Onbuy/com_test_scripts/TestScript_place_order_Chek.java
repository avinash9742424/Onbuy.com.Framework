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

import pom.Admin_login_page;
import pom.Home_page;
import pom.Login_page;
import pom.My_cart_page;
import pom.Myaccount_Pay_pending;
import pom.Order_Status_page;
import pom.Todays_order_page;
import pom.Update_order_page;

public class TestScript_place_order_Chek {

	
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
		   String USERNAME1 = fLib.getDataFromProperties(ENV_FILE_PATH, "usernameAdmin");
		   String PASSWORd1 = fLib.getDataFromProperties(ENV_FILE_PATH, "passwordAdmin");
		   
		  
			/*test script data*/
			int randomNum = jLib.getRandomNumber();
			
			
			String  Products= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_03"
					, "Products");
			String  PartialWindowTitle= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_03"
					, "partialWindowTitle");
			String  remarks= eLib.getDataFromExcelBasedTestIdString(TEST_SCRIPT_EXCEL_FILE_PATH, "user", "TC_id_03"
					, "Remarks");
			
		
		
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
			
			/**
			 * search the products
			 */
			
			Home_page home=new Home_page(driver);
			home.searching_product(Products);
			try {
			wLib.closealert(driver);
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
			
			home.logoutUser();
            

		  String URL_ADMIN = fLib.getDataFromProperties(ENV_FILE_PATH, "urladmin");
		
			driver.get(URL_ADMIN);
			Admin_login_page adlog=new Admin_login_page(driver);
			adlog.loginToApp(USERNAME1, PASSWORd1);
			
			Todays_order_page order = new Todays_order_page(driver);
			order.todaysorder(driver,PartialWindowTitle);
			
			Order_Status_page orderstatus=new Order_Status_page(driver);
			orderstatus.updateTheOrder(driver, remarks, PartialWindowTitle);
			/*
			Update_order_page updateorder=new Update_order_page(driver);
			updateorder.validateOrderID(PASSWORd1, Products, URL_ADMIN, PartialWindowTitle);
			*/
}
}
