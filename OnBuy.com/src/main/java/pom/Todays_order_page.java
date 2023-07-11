package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Onbuy.com_Utilityclasses.Web_action_utility;

public class Todays_order_page extends Web_action_utility{

	/**
	   * this is for declaring the web elements in the Today's order page
	   */
	//Declaration
		@FindBy(xpath = "//a[@href='#togglePages']") 
		private WebElement Ordermanagement;
		
				
		@FindBy(xpath = "//a[@href='todays-orders.php']") 
		private WebElement Todays_order;
		
		@FindBy(xpath =  "//div[@class='dataTables_length']/label/select//option[.='50']") 
		private WebElement select_entries;
		
		@FindBy(xpath =  "(//i[@class='icon-edit'])[last()]") 
		private WebElement edit_btn;
		

		/**
		 * initialization of webelements
		 */
		//Initialization
		public Todays_order_page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			
		}

       //utilization

		public WebElement getOrdermanagement() {
			return Ordermanagement;
		}



		public WebElement getTodays_order() {
			return Todays_order;
		}



		public WebElement getSelect_entries() {
			return select_entries;
		}

		public WebElement getEdit_btn() {
			return edit_btn;
		}
		
		//Business libraries
		
				public void todaysorder(WebDriver driver,String partialWindowTitle)
				{
					
					Ordermanagement.click();
					Todays_order.click();
					select_entries.click();
					edit_btn.click();
					this.swithToWindow(driver, partialWindowTitle);
					
					
				}
				

}
