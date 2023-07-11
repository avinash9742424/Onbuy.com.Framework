package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.math3.fraction.ProperFractionFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BillingAddTest {
    @Test
	public void billingadd()throws IOException, Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
        Properties ps=new Properties();
        ps.load(fis);
        String KEY =System.getProperty("geckokey", ps.getProperty("geckokey"));
        String VALUE =System.getProperty("geckovalue", ps.getProperty("geckovalue"));
        String URL =System.getProperty("url", ps.getProperty("url"));
        String USERNAME =System.getProperty("usn", ps.getProperty("usn"));
        String PASSWORD =System.getProperty("pwd", ps.getProperty("pwd"));
        
        System.setProperty(KEY,VALUE);
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
        driver.findElement(By.xpath("//a[@href='login.php']")).click();
		  //enter the user name
		  driver.findElement(By.name("email")).sendKeys(USERNAME);
		  
		  //enter the password
		  driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
		 
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