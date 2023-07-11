package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_login_page {
     
	/**
	   * this is for declaring the web elements in the Admin login page
	   */
	//Declaration
		@FindBy(name = "username") 
		private WebElement Username;
		
				
		@FindBy(id =  "inputPassword") 
		private WebElement Password;
		
		@FindBy(xpath =  "//button[.='Login']") 
		private WebElement Login_btn;
		
		/**
		 * initialization of webelements
		 */
		//Initialization
		public Admin_login_page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			
		}
       
		//utilization
		
		public WebElement getUsername() {
			return Username;
		}

		public WebElement getPassword() {
			return Password;
		}

		public WebElement getLogin_btn() {
			return Login_btn;
		}
		
	//Business libraries
		
		public void loginToApp(String username,String password)
		{
			
			Username.sendKeys(username);
			Password.sendKeys(password);
			Login_btn.click();
		}
		
}
