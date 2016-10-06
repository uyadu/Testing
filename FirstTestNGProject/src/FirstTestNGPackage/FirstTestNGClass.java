package FirstTestNGPackage;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class FirstTestNGClass {
	public String baseUrl ="http://newtours.demoaut.com";
	public WebDriver driver;

	
  @Test(priority=0)
  public void register() {
	  driver.findElement(By.linkText("REGISTER")).click();
	  Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
	
  }
  @Test(priority=1)
  public void support() {
	  driver.findElement(By.linkText("SUPPORT")).click();
	  Assert.assertEquals(driver.getTitle(), "Under Construction: Mercury Tours");
	  
  }
  @AfterTest
  public void close()
  {
	  driver.quit();
  }
  @BeforeTest
  @Parameters("browser")
  public void launch(String browser) throws Exception
  {
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
	  
	 
	  driver.get(baseUrl);
  }
  @BeforeMethod
  public void verifyHomeTitle()
  {
	  Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
  }
  @AfterMethod
  public void goToHomePAge()
  {
	  driver.findElement(By.linkText("Home")).click();
  }
  }
