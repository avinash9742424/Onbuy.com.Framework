package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_cart_page {
	/**
	   * this is for declaring the web elements for My cart page
	   */
	  //Declaration
	//
	@FindBy(xpath = "//div[@class='clearfix cart-total']/a") 
	private WebElement My_cart_link;
	
	@FindBy(xpath = "//button[@name='ordersubmit']") 
	private WebElement Checkout_Payments_btn;
	
	@FindBy(xpath = "//form[@name='payment']/input[@checked='checked']") 
	private WebElement Select_Payment;
	
	@FindBy(xpath = "//input[@name='submit']") 
	private WebElement Submit_btn;
	
	/**
	 * initialization of webelements
	 */
	//Initialization
	public My_cart_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	/**
	 * utilize webelements
	 */
	

	public WebElement getMy_cart_link() {
		return My_cart_link;
	}

	public WebElement getCheckout_Payments_btn() {
		return Checkout_Payments_btn;
	}

	public WebElement getSelect_Payment() {
		return Select_Payment;
	}

	public WebElement getSubmit_btn() {
		return Submit_btn;
	}
	
	/**
	 * Business libraries
	 * @throws InterruptedException 
	 */
	
	public void mycart() throws InterruptedException
	{
		//My_cart_link.click();
		Thread.sleep(2000);
		Checkout_Payments_btn.click();
		//Select_Payment.click();
		//Submit_btn.click();
		
	}

}
