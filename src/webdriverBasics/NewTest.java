package webdriverBasics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.annotations.AfterTest;

public class NewTest 
{
	WebDriver driver;
	String str;
	
  public void test1()
  {
       Actions act=new Actions(driver);
	  
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.name("submit")).click();
	  
	   List<WebElement> lst=driver.findElements(By.tagName("a"));
	   
	   for(int i=0;i<lst.size();i++)
	   {
		   if(lst.get(i).getText().isEmpty())
		   {
			   continue;
		   }
		   else
		   {
			   System.out.println(lst.get(i).getText());
		   }
		   
	   }
  }
	   
  public void test2()
  {
	  driver.navigate().refresh();
	  System.out.println("1");
	  driver.navigate().to(driver.getCurrentUrl());
	  System.out.println("2");
	  driver.get(driver.getCurrentUrl());
	  System.out.println("3");
	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));

  }    
  
  @Test
  public void f()
  {
	  test1();
	 // test2();
  }
  @BeforeTest
  public void beforeTest()
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\Murali_Selenium\\Library\\chromedriver.exe");
	  driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://selenium4testing.com/hms/");
		//driver.get("https://www.spicejet.com");
		
  }

  @AfterTest
  public void afterTest()
  {
	  
  }

}
