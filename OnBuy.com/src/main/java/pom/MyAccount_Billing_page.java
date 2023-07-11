package pom;

import static org.junit.Assert.assertArrayEquals;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_Billing_page {
   
	
    /**
	   * this is for declaring the web elements in the Billing address page
	   */
  	//Declaration
		@FindBy(xpath = "//a[@href='my-account.php']") 
		private WebElement Myaccount_link;
		
		@FindBy(xpath =  "//a[.='Shipping / Billing Address']") 
		private WebElement Billing_Address_link;
		
		@FindBy(xpath = "//textarea[@name='billingaddress']") 
		private WebElement Billing_address;
		
		@FindBy(id="bilingstate")
		private WebElement Billing_State;
		
		@FindBy(id =  "billingcity") 
		private WebElement Billing_City;
		
		@FindBy(id = "billingpincode") 
		private WebElement Billing_pincode;
		
		@FindAll({@FindBy(xpath = "//button[.='Update']"), @FindBy(xpath = "//button[@name='update']")}) 
		private WebElement updatebtn;
		
		@FindBy(xpath =  "//textarea[@name='billingaddress']") 
		private WebElement Actual_bill_add;
		@FindBy(id = "bilingstate") 
		private WebElement Actual_bill_state;
		@FindBy(id = "billingcity") 
		private WebElement Actual_bill_city;
		@FindBy(id = "billingpincode") 
		private WebElement Actual_bill_pincode;
		
		
		/**
		 * initialization of webelements
		 */
		//Initialization
		public MyAccount_Billing_page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			
		}

		//utilization
		

		public WebElement getMyaccount_link() {
			return Myaccount_link;
		}

		public WebElement getBilling_Address_link() {
			return Billing_Address_link;
		}

		public WebElement getBilling_address() {
			return Billing_address;
		}

		public WebElement getBilling_State() {
			return Billing_State;
		}

		public WebElement getBilling_City() {
			return Billing_City;
		}

		public WebElement getBilling_pincode() {
			return Billing_pincode;
		}

		public WebElement getLoginbtn() {
			return updatebtn;
		}
		
		
		public WebElement getActual_bill_add() {
			return Actual_bill_add;
		}

		public WebElement getActual_bill_state() {
			return Actual_bill_state;
		}

		public WebElement getActual_bill_city() {
			return Actual_bill_city;
		}

		public WebElement getActual_bill_pincode() {
			return Actual_bill_pincode;
		}

		
		
		//Business libraries
				public void update_billing(String Bill_address,String Bill_state,String Bill_city,String Bill_pincode)
				{
					Myaccount_link.click();
					Billing_Address_link.click();
					Billing_address.sendKeys(Bill_address);
					Billing_State.sendKeys(Bill_state);
					Billing_City.sendKeys(Bill_city);
					Billing_pincode.sendKeys(Bill_pincode);
					updatebtn.click();
					/*Actual_bill_add.sendKeys(Actual_add);
					Actual_bill_state.sendKeys(Actual_state);
					Actual_bill_city.sendKeys(Actual_city);
					Actual_bill_pincode.sendKeys(Actual_pincode);*/
				}
}
