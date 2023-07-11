package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Onbuy.com_Utilityclasses.Web_action_utility;

public class Update_order_page extends Web_action_utility{
     
	/**
	   * this is for declaring the web elements in the Update order page
	   */
	//Declaration
		@FindBy(xpath = "//b[.='order Id:']") 
		private WebElement OrderId;
		
		@FindBy(xpath = "//b[.='At Date:']") 
		private WebElement At_date;
		
		@FindBy(xpath = "//b[.='Status:']") 
		private WebElement Status;
		
		@FindBy(xpath = "//b[.='Remark:']") 
		private WebElement Remark;
	
		/**
		 * initialization of webelements
		 */
		public Update_order_page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		public WebElement getOrderId() {
			return OrderId;
		}

		public WebElement getAt_date() {
			return At_date;
		}

		public WebElement getStatus() {
			return Status;
		}

		public WebElement getRemark() {
			return Remark;
		}
		
		//Business libraries
		public void updateorder()
		{
			
			String orderid = OrderId.getText();
			System.out.println(orderid);
			String date = At_date.getText();
			System.out.println(date);
			String status = Status.getText();
			System.out.println(status);
			String remark = Remark.getText();
			System.out.println(remark);
	
		}
		
		
		public void validateOrderID()
		{
			
			
			String actOrderID = OrderId.getText();
			Assert.assertEquals(actOrderID, "contains(orderID)");
			/*if(actOrderID.contains(orderID))
			{
				return actOrderID+ "matched";
			}
			else {
				return "OrderId not matched";
			}*/
			String actdate = At_date.getText();
			Assert.assertEquals(actdate, "contains(date)");
			/*if(actdate.contains(date))
			{
				return actdate+ "matched";
			}
			else {
				return "Order date not matched";
			}*/
		String actOrderStatus= Status.getText();
		Assert.assertEquals(actOrderStatus, "contains(status)");
		/*if(actOrderStatus.contains(status))
		{
			return actOrderStatus+ "matched";
		}
		else {
			return "Order status not matched";
		}*/
			
			String actOrderRemark = Remark.getText();
			Assert.assertEquals(actOrderStatus, "contains(remark)");
			/*if(actOrderRemark.contains(remark))
			{
				return actOrderRemark+ "matched";
			}
			else {
				return "actOrderRemark is not matched";
			}*/
			
			
			
		}

		public void validateOrderID1() {
			// TODO Auto-generated method stub
			
		} }

