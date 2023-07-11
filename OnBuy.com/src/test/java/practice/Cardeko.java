package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Onbuy.com_Utilityclasses.Base_class;
import com.Onbuy.com_Utilityclasses.Web_action_utility;

public class Cardeko extends Web_action_utility{
    
	@Test
	public void fetchPrice() throws Throwable
	{
		Web_action_utility wLib = new Web_action_utility();
		 System.setProperty("webdriver.gecko.driver", "./target/geckodriver.exe");
		  WebDriver driver=new FirefoxDriver();
		 wLib.waitForElementInDOM(driver);
		  driver.get("https://www.cardekho.com/");
		  WebElement ele = driver.findElement(By.xpath("//span[@class='used-cars-india']"));
		  Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
	}
}