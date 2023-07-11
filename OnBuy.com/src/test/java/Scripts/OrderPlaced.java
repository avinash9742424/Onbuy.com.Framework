package Scripts;

import org.bouncycastle.crypto.tls.AlertDescription;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class OrderPlaced
{
  public static void main(String[] args) throws InterruptedException
  {
	  System.setProperty("webdriver.gecko.driver", "./Softwares/geckodriver.exe");
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
	  driver.findElement(By.name("Password")).sendKeys("Test@123");
	  Thread.sleep(2000);
	  
	  //click on login button
	  driver.findElement(By.xpath("button[.='Login']")).click();
	  
	  //pass the data into search text field
	  driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("Redmi Note 4");
	  
	  //click on search button
	  driver.findElement(By.xpath("//button[@name='search']")).click();
	  //click on add to cart button
	  driver.findElement(By.xpath("//button[.='Add to cart']")).click();
	  Alert a = driver.switchTo().alert();	
	  a.accept();
	  driver.findElement(By.xpath("//div[@class='clearfix cart-total']/a")).click();
	  driver.findElement(By.xpath("//div[@class='cart-checkout-btn pull-right']/button")).click();
	  //driver.findElement(By.xpath("//form[@name='payment']/input[@checked='checked']")).click();
	  //driver.findElement(By.xpath("//input[@name='submit']")).click();
	  driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
	  driver.findElement(By.xpath("//a[.='Payment Pending Order']")).click();
	  driver.findElement(By.xpath("//a[.='PROCCED To Payment']")).click();
	  driver.findElement(By.xpath("//input[@name='paymethod' and @value='COD']")).click();
	  driver.findElement(By.xpath("//input[@value='submit']")).click();
	  
	  
}
	
}
