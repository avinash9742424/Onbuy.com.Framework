package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Admin_logout_page {
       
	@FindBy(xpath ="//i[@class='menu-icon icon-signout']" )
	private WebElement logout_btn;
	/*WebElement ele1 = driver.findElement(By.xpath("//b[@class='caret']"));
	  Select s1 = new Select(ele1);
	  s1.selectByIndex(1);*/
	/**
	 * initialization of webelements
	 */
	//Initialization
	public Admin_logout_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	//utilization
	public WebElement getLogout_btn() {
		return logout_btn;
	}
	
	//Business libraries
	
	public void logout()
	{
		logout_btn.click();
	}
	
}
