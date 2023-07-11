package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
     
	  
	  /**
	   * this is for declaring the web elements for product search page
	   */
	//Declaration
		@FindBy(xpath = "//input[@class='search-field']") 
		private WebElement Search_text;
		
		@FindBy(xpath = "//button[@name='search']") 
		private WebElement Search_btn;
		
		@FindBy(xpath = "//button[.='Add to cart']") 
		private WebElement Add_to_cart_btn;
		
		@FindBy(xpath = "//a[@href='logout.php']") 
		private WebElement Logout_btn;
		
		
		/**
		 * initialization of webelements
		 */
		//Initialization
		public Home_page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			
		}

		/**
		 * for utilization
		 */

		public WebElement getSearch_text() {
			return Search_text;
		}


		public WebElement getSearch_btn() {
			return Search_btn;
		}


		public WebElement getAdd_to_cart_btn() {
			return Add_to_cart_btn;
		}
		
		public WebElement getLogout_btn() {
			return Logout_btn;
		}

		/**
		 * Business libraries//
		 * @param Product
		 */
		public void searching_product(String Product)
		{
			Search_text.sendKeys(Product);
			Search_btn.click();
			Add_to_cart_btn.click();

			
		}
		public void logoutUser()
		{
			Logout_btn.click();
		}
}
