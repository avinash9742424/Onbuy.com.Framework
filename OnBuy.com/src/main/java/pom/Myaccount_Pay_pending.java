package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myaccount_Pay_pending {
    /**
	   * this is for declaring the web elements in the Payment pending order page
	   */
  	//Declaration
		@FindBy(xpath = "//a[@href='my-account.php']") 
		private WebElement Myaccount_link;
		
		@FindBy(xpath = "//a[.='Payment Pending Order']") 
		private WebElement Payment_Pending_Order_link;
		
		@FindBy(xpath = "//a[.='PROCCED To Payment']") 
		private WebElement Proceed_pay_btn;
		
		@FindBy(xpath = "//form[@name='payment']/input[@checked='checked']") 
		private WebElement Select_Payment;
		
		@FindBy(xpath = "//input[@name='submit']") 
		private WebElement Submit_btn;
		
		
		/**
		 * initialization of webelements
		 */
		public Myaccount_Pay_pending(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		/**
		 * utilize the webelements
		 */

		public WebElement getMyaccount_link() {
			return Myaccount_link;
		}


		public WebElement getPayment_Pending_Order_link() {
			return Payment_Pending_Order_link;
		}


		public WebElement getProceed_pay_btn() {
			return Proceed_pay_btn;
		}


		public WebElement getSelect_Payment() {
			return Select_Payment;
		}


		public WebElement getSubmit_btn() {
			return Submit_btn;
		}
		
		/**
		 * Business libraries
		 * @return 
		 */
		
		public void Pyment_order()
		{
			Myaccount_link.click();
			Payment_Pending_Order_link.click();
			Proceed_pay_btn.click();
			Select_Payment.click();
			Submit_btn.click();
		}
		
		
		
		
}
