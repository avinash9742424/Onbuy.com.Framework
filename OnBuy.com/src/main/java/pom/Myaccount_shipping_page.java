package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myaccount_shipping_page {
     
	  /**
	   * this is for declaring the web elements in the Shipping address page
	   */
	//Declaration
		@FindBy(xpath = "//a[@href='my-account.php']") 
		private WebElement Myaccount_link;
		
				
		@FindBy(xpath =  "//a[.='Shipping / Billing Address']") 
		private WebElement Shiiping_billing_Address_link;
		
		@FindBy(xpath =  "//a[@href='#collapseTwo']") 
		private WebElement Shiiping_Address_link;

		
		@FindBy(xpath = "//textarea[@name='shippingaddress']") 
		private WebElement Shipping_address;
		
		@FindBy(id="shippingstate")
		private WebElement Shipping_State;
		
		@FindBy(id =  "shippingcity") 
		private WebElement Shipping_City;
		
		@FindBy(id = "shippingpincode") 
		private WebElement Shipping_pincode;
		
		@FindBy(xpath = "//form[@class='register-form']/button[@name='shipupdate']") 
		private WebElement updatebtn;
		
		
		@FindBy(xpath =  "//textarea[@name='shippingaddress']") 
		private WebElement Actual_ship_add;
		@FindBy(id = "shippingstate") 
		private WebElement Actual_ship_state;
		@FindBy(id = "shippingcity") 
		private WebElement Actual_ship_city;
		@FindBy(id = "shippingpincode") 
		private WebElement Actual_ship_pincode;
		
		
		
		/**
		 * initialization of webelements
		 */
		//Initialization
		public Myaccount_shipping_page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			
		}

		//utilization
		
		public WebElement getMyaccount_link() {
			return Myaccount_link;
		}

		public WebElement getShiiping_billing_Address_link() {
			return Shiiping_billing_Address_link;
		}

		public WebElement getShiiping_Address_link() {
			return Shiiping_Address_link;
		}

		public WebElement getShipping_address() {
			return Shipping_address;
		}

		public WebElement getShipping_State() {
			return Shipping_State;
		}

		public WebElement getShipping_City() {
			return Shipping_City;
		}

		public WebElement getShipping_pincode() {
			return Shipping_pincode;
		}

		public WebElement getLoginbtn() {
			return updatebtn;
		
		}
		
		
				public WebElement getActual_ship_add() {
			return Actual_ship_add;
		}

		public WebElement getActual_ship_state() {
			return Actual_ship_state;
		}

		public WebElement getActual_ship_city() {
			return Actual_ship_city;
		}

		public WebElement getActual_ship_pincode() {
			return Actual_ship_pincode;
		}
		
		//Business libraries

				public void update_Shipping(String Ship_address,String Ship_state,String Ship_city,String Ship_pincode)
				{
					Myaccount_link.click();
					Shiiping_billing_Address_link.click();
					Shiiping_Address_link.click();
					Shipping_address.sendKeys(Ship_address);
					Shipping_State.sendKeys(Ship_state);
					Shipping_City.sendKeys(Ship_city);
					Shipping_pincode.sendKeys(Ship_pincode);
					updatebtn.click();
					/*Actual_ship_add.sendKeys(Actual_address);
					Actual_ship_state.sendKeys(Actual_state);
					Actual_ship_city.sendKeys(Actual_city);
					Actual_ship_pincode.sendKeys(Actual_pincode);*/
				}

			
}
