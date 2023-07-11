package com.Onbuy.com_Utilityclasses;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Admin_login_page;
import pom.Admin_logout_page;
import pom.Home_page;
import pom.Login_page;

public class Base_class {
	public static WebDriver tdriver;
	public WebDriver driver=null;
	public Database_utility dlib=new Database_utility();
	public File_utility flib=new File_utility();
	public Excel_utility elib=new Excel_utility();
	public Java_utility jlib=new Java_utility();
	public Web_action_utility wlib=new Web_action_utility();
	public String ENV_FILE_PATH;
	public String TEST_SCRIPT_EXCEL_FILE_PATH;
	
	/**
	 * this is for open the database
	 * @throws SQLException
	 */
	@BeforeSuite(groups = {"reg test","smoke test"})
	public void openDB() throws SQLException
	{
		dlib.connectDB();
	}
	
	/**
	 * This is for open the browser and enter url for user
	 * @throws Throwable
	 */
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"reg test","smoke test"})
	public void opentheBrowser(/*String BROWSER*/) throws Throwable
	{
		 ENV_FILE_PATH =    flib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String BROWSER = flib.getDataFromProperties(ENV_FILE_PATH, "browser");
		//String BROWSER = System.getProperty("browser",flib.getDataFromProperties(ENV_FILE_PATH, "browser"));
		   String geckokey = flib.getDataFromProperties(ENV_FILE_PATH, "geckokey");
		   String geckovalue = flib.getDataFromProperties(ENV_FILE_PATH, "geckovalue");
		  
		   //System.setProperty(geckokey, geckovalue);
			WebDriverManager.firefoxdriver().setup();
			if(BROWSER.equalsIgnoreCase("chrome")) {		
			    driver = new ChromeDriver();
			}else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else if(BROWSER.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}else {
			    driver = new ChromeDriver();
			}
			tdriver=driver;
			 wlib.maximizeTheBrowser(driver);
			wlib.waitForElementInDOM(driver);
			
			
		   System.out.println("browser is launched");
	}
	
	/**
	 * login to the application as user
	 * @throws Throwable
	 */
	@BeforeMethod(groups = {"reg test","smoke test"})
	public void loginToApp() throws Throwable
	{
		
		   
		   System.out.println("successfully logged in");
	}
	
	
	/**
	 * this is for logout as user
	 */
	@AfterMethod(groups = {"reg test","smoke test"})
	public void logoutToApp()
	{
	  
	   
	   System.out.println("successfully loggedout");
	}
	
	/**
	 * close the browser for user
	 */
	@AfterClass(groups = {"reg test","smoke test"})
	public void closeTheBrowser()
	{
	  driver.close();
	}
	
	
	/**
	 * close the database
	 * @throws SQLException
	 */
	@AfterSuite(groups = {"reg test","smoke test"})
	public void closeDB() throws SQLException
	{
		dlib.closeDB();
	}

/*@DataProvider
public Object[][] getdata() throws Exception
{
	 Object[][] obj=new Object[3][3];
	 
	 
	return obj;
	 
	}*/


}




