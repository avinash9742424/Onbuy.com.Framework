package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Onbuy.com_Utilityclasses.Web_action_utility;

public class Order_Status_page extends Web_action_utility
{
      
	
	
	@FindBy(xpath ="//select[@name='status']")
	private WebElement statusDD;
	
	@FindBy(name="remark")
	private WebElement remarkTxtFld;

	@FindBy(name="submit2")
	private WebElement updateBtn;
	
	/**
	 * initialization of webelements
	 */
	public Order_Status_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getStatusDD() {
		return statusDD;
	}

	public WebElement getRemarkTxtFld() {
		return remarkTxtFld;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	//Business libraries
	
	public void updateTheOrder( WebDriver driver, String remarks, String partialWindowTitle) throws InterruptedException
	{
		
		this.select(statusDD, 2);
		System.out.println("++++++++++++++===================");
		remarkTxtFld.sendKeys(remarks);
		updateBtn.click();
		this.closealert(driver);
		this.swithToWindow(driver, partialWindowTitle);
	
		
	}
	


}
