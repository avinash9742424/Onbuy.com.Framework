package onbuy.comUserModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.math3.fraction.ProperFractionFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class BillingAdd {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
        Properties ps=new Properties();
        ps.load(fis);
        String KEY =ps.getProperty("geckokey");
        String VALUE =ps.getProperty("geckovalue");
        String URL =ps.getProperty("url");
        String USERNAME =ps.getProperty("usn");
        String PASSWORD =ps.getProperty("pwd");
        
        System.setProperty(KEY,VALUE);
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);
        driver.findElement(By.xpath("//a[@href='login.php']")).click();
		  //enter the user name
		  driver.findElement(By.name("email")).sendKeys(USERNAME);
		  Thread.sleep(2000);
		  //enter the password
		  driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
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
	


