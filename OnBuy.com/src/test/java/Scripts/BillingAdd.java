package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BillingAdd {
	 public static void main(String[] args) throws InterruptedException
	  {
		 System.setProperty("webdriver.gecko.driver", "./target/geckodriver.exe");
		  WebDriver driver=new FirefoxDriver();
		  //enter the url
		  driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		  Thread.sleep(2000);
		  //Click on login link
		  driver.findElement(By.xpath("//a[@href='login.php']")).click();
		  //enter the user name
		  driver.findElement(By.name("email")).sendKeys("anuj.lpu1@gmail.com");
		  Thread.sleep(2000);
		  //enter the password
		  driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test@123");
		  Thread.sleep(2000);
		  //click on login button
		  driver.findElement(By.xpath("//button[.='Login']")).click();
		  //click on my account link
		  driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
		  
		  //click on Shipping and billing address link
		  driver.findElement(By.xpath("//a[.='Shipping / Billing Address']")).click();
		  driver.findElement(By.xpath("//textarea[.='New Delhi']")).sendKeys("New Delhi");
		  driver.findElement(By.id("bilingstate")).sendKeys("New Delhi");
		  driver.findElement(By.id("billingcity")).sendKeys("Delhi");
		  driver.findElement(By.id("billingpincode")).sendKeys("110092");
		  driver.findElement(By.xpath("//button[.='Update' and @name='update']")).click();
		  driver.switchTo().alert().accept();
}
}