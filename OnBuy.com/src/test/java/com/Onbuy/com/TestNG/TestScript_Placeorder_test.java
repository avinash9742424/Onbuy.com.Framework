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
import com.Onbuy.com_Utilityclasses.Web_action_utility;

import pom.Home_page;
import pom.Login_page;
import pom.My_cart_page;
import pom.Myaccount_Pay_pending;
@Listeners(com.Onbuy.com_Utilityclasses.ListnerClass_implementation.class)
public class TestScript_Placeorder_test extends Base_class {
    
	@Test(groups = {"reg test"})
	public void update_bill_add() throws Throwable,IOException{		
		
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
}

