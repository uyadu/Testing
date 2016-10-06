package FirstTestNGPackage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebElement;


import org.testng.annotations.Parameters;
import org.testng.annotations.*;

public class CrossBrowserTesting {

    /**
 
     * This function will execute before each Test tag in testng.xml
 
     * @param browser
 
     * @throws Exception
 
     */
	WebDriver driver;
	
  @BeforeTest
  @Parameters("browser")
  public void CheckBrowser(String browser)throws Exception {
	  if(browser.equalsIgnoreCase("firefox")){
		  driver=new FirefoxDriver();
	  }
  else if (browser.equalsIgnoreCase("chrome")){
      System.setProperty("webdriver.chrome.driver","C:\\SeleniumDriversOtherBrowsers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  }
  else if (browser.equalsIgnoreCase("ie")){
	  System.setProperty("webdriver.ie.driver","C:\\SeleniumDriversOtherBrowsers\\IEDriverServer.exe");
	  driver=new InternetExplorerDriver();
  }
  else{
	  //If no browser passed throw exception
	  throw new Exception("Browser is not correct");
  }
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
 
  @Test
  public void testParameterWithXML() throws InterruptedException{
	  
      driver.get("http://demo.guru99.com/V4/");

      //Find user name

      WebElement userName = driver.findElement(By.name("uid"));

      //Fill user name

      userName.sendKeys("guru99");

      //Find password

      WebElement password = driver.findElement(By.name("password"));

      //Fill password

      password.sendKeys("guru99");

  }
}
