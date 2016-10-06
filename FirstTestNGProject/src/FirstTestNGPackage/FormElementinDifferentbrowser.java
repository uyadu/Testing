package FirstTestNGPackage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebElement;


import org.testng.annotations.Parameters;
import org.testng.annotations.*;

public class FormElementinDifferentbrowser {

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
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
 
  @Test
  public void testParameterWithXML() throws InterruptedException{
	  
		
		driver.get("https://www.facebook.com");
		
		// Accessing Radio Button
		try
		{driver.findElement(By.cssSelector("input[id='u_0_e'][value='1']")).click();
		}
		catch (NoSuchElementException nsee)
		{System.out.println("Exception caught1");
		}
		for (int i =0;i<2;i++)
		{System.out.println(i);
			try
			{if (driver.findElement(By.cssSelector("input[id='u_0_e'][value='1']")).isSelected())
				{System.out.println("Female is selected ,make to male and check in next loop");
				 driver.findElement(By.cssSelector("input[id='u_0_f'][value='2']")).click();
				}
			else if (driver.findElement(By.cssSelector("input[id='u_0_f'][value='2']")).isSelected())
				{System.out.println("Male is selected");
				}
			}
			catch (NoSuchElementException nsee)
			{System.out.println("Exception caught");
			}
		}
		
		//Accessing LinkText
		
		System.out.println(driver.findElement(By.linkText("Having trouble?")).isDisplayed());
		driver.findElement(By.linkText("Having trouble?")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.cssSelector(".uiButtonText")).isDisplayed());
		driver.findElement(By.cssSelector(".uiButtonText")).click();
		
		//navigator usage
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
		
		//Accessing drop down values
		Select birthday=new Select(driver.findElement(By.id("day")));
		birthday.selectByValue("4");
		Select month =new Select(driver.findElement(By.id("month")));
		month.selectByValue("12");
		Select year=new Select(driver.findElement(By.id("year")));
		year.selectByValue("1987");
		
		//Accessing Password
		driver.findElement(By.cssSelector("#pass")).submit();
		
		//Accessing All Links in a page
		List<WebElement> linkElements= driver.findElements(By.tagName("a"));
		String linkTexts[]= new String[linkElements.size()];
		int i=0;
		for (WebElement e :linkElements)
		{
			linkTexts[i]=e.getText();
			System.out.println(linkTexts[i]);
			i++;
		}
		
		//Accessing Image Link
		
		driver.findElement(By.cssSelector(".fb_logo.img.sp_IIuy94UEXRV.sx_6bf598")).click();
		//driver.quit();
		//System.exit(0);
  }
}
