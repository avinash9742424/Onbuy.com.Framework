package Scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Placeorder {
	public static void main(String[] args) throws InterruptedException, IOException
	  {
		  
		  FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
	        Properties ps=new Properties();
	        ps.load(fis);
	        String KEY = ps.getProperty("geckokey");
	        String VALUE = ps.getProperty("geckovalue");
	        String URL = ps.getProperty("url");
	        String USERNAME = ps.getProperty("usn");
	        String PASSWORD = ps.getProperty("pwd");
	        
	        System.setProperty(KEY,VALUE);
	        WebDriver driver = new FirefoxDriver();
	        driver.get(URL);
	        driver.findElement(By.xpath("//a[@href='login.php']")).click();
			  //enter the user name
			  driver.findElement(By.name("email")).sendKeys(USERNAME);
	
			  //enter the password
			  driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
			  //click on login button
			  driver.findElement(By.xpath("//button[.='Login']")).click();
			//pass the data into search text field
			  driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("Redmi Note 4");
			  
			  //click on search button
			  driver.findElement(By.xpath("//button[@class='search-button']")).click();
			  //click on add to cart button
			  driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			  Alert a = driver.switchTo().alert();	
			  a.accept();
			  driver.findElement(By.xpath("//a[@href='my-cart.php']")).click();
			  driver.findElement(By.xpath("button[.='PROCCED TO CHEKOUT']']")).click();
			  driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
			  driver.findElement(By.xpath("//a[.='Payment Pending Order']']")).click();
			  driver.findElement(By.xpath("//a[.='PROCCED To Payment']']")).click();
			  driver.findElement(By.xpath("//input[@name='paymethod' and @value='COD']")).click();
			  driver.findElement(By.xpath("//input[@value='submit']")).click();
			  
			  
		  //enter the url
		  driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		  Thread.sleep(2000);
		  //Click on login link
		 // driver.findElement(By.xpath("//a[@name='username']")).click();
		  //enter the user name
		  driver.findElement(By.name("username")).sendKeys("admin");
		  
		  //enter the password
		  driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		 
		  //click on login button
		  driver.findElement(By.xpath("//button[.='Login']")).click();
		  //pass the data into search text field
		  driver.findElement(By.xpath("//a[@href='#togglePages']")).click();
		  driver.findElement(By.xpath("//a[@href='todays-orders.php']")).click();
		  //click on search button
		  driver.findElement(By.xpath("//i[@class='icon-edit']")).click();
		  WebElement ele = driver.findElement(By.xpath("//select[@name='status']"));
		  Select s = new Select(ele);
		  s.selectByIndex(2);
		  
		  driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Order to be delivered soon");
		  
		  driver.findElement(By.xpath("//input[@name='submit2']")).click();
		  Alert a1 = driver.switchTo().alert();
		  a1.dismiss();
		  
		  WebElement ele1 = driver.findElement(By.xpath("//b[@class='caret']"));
		  Select s1 = new Select(ele1);
		  s1.selectByIndex(1);
		  
		  
		  
		  
		  
		  
		 
		  
		  /*//click on add to cart button
		 
		  
		  
		  driver.findElement(By.xpath("//b[@class='caret']")).click();
		  driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
		  driver.findElement(By.xpath("//a[.='Payment Pending Order']']")).click();
		  driver.findElement(By.xpath("//a[.='PROCCED To Payment']']")).click();
		  driver.findElement(By.xpath("//input[@name='paymethod' and @value='COD']")).click();
		  driver.findElement(By.xpath("//input[@value='submit']")).click();*/
		  
	  }  
}

