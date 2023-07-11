package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class Login_page {
    
	
      /**
	   * this is for declaring the web elements in the Login page
	   */
    	//Declaration
		@FindBy(xpath = "//a[@href='login.php']") 
		private WebElement Login_link;
		
		@FindBy(name = "email") 
		private WebElement Email_Address;
		
		@FindBy(id = "exampleInputPassword1") 
		private WebElement Password;
		
		@FindBy(xpath = "//button[.='Login']") 
		private WebElement Login_btn;
		
		/**
		 * initialization of webelements
		 */
		//Initialization
		public Login_page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			
		}

		//utilization
		
		public WebElement getLogin_link() {
			return Login_link;
		}

		public WebElement getEmail_Address() {
			return Email_Address;
		}

		public WebElement getPassword() {
			return Password;
		}

		public WebElement getLogin_btn() {
			return Login_btn;
		}
		
		//Business libraries
		
		public void loginToApp(String USERNAME,String PASSWORd)
		{
			Login_link.click();
			Email_Address.sendKeys(USERNAME);
			Password.sendKeys(PASSWORd);
			Login_btn.click();
		}
		
		

}
