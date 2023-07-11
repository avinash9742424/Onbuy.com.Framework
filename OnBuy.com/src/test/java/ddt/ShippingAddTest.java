package ddt;


	import java.io.FileInputStream;
	import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

	public class ShippingAddTest {
          @Test
		public void shippingAdd() throws IOException, InterruptedException {
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
			  /*click on billing and shipping adress link
			  */
			  driver.findElement(By.xpath("//a[.='Shipping / Billing Address']")).click();
			  
	          driver.findElement(By.xpath("//a[@href='#collapseTwo']")).click();
			  
			  driver.findElement(By.xpath("//textarea[.='CS New Delhi']")).sendKeys("CS New Delhi");
			  driver.findElement(By.id("shippingstate")).sendKeys("New Delhi");
			  driver.findElement(By.id("shippingcity")).sendKeys("Delhi");
			  driver.findElement(By.id("shippingpincode")).sendKeys("110001");
			  driver.findElement(By.xpath("//button[.='Update' and @name='shipupdate']")).click();
			  driver.switchTo().alert().accept();
		}
	}


