package FirstTestNGPackage;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestParameterswithXmlFile {
	@Test
	@Parameters({"author","searchkey"})
	public void ParameterswithTestXml(@Optional("Guru99")String author,String searchkey) throws InterruptedException
	{
		System.out.println("first line");
	WebDriver driver=new FirefoxDriver();
	driver.get("https://google.com");
	
	//wait for the google to launch properly
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	System.out.println("second line");
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.clear();
	searchbox.sendKeys(searchkey);
	
	System.out.println("Welcome ->"+ author +" Your search key is->" +searchkey);
	System.out.println("Thread will sleep now");
    Thread.sleep(3000);

    System.out.println("Value in Google Search Box = "+searchbox.getAttribute("value") +" ::: Value given by input = "+searchkey);
    
    Assert.assertTrue(searchbox.getAttribute("value").equalsIgnoreCase(searchkey));
    driver.close();
    }
}
