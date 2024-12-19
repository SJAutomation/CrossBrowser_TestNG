package TestNG_CrossBrowserTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cross_browser {
	
	public static WebDriver driver;
	
	
	

	 
	ChromeOptions options = new ChromeOptions();
	
	//opt.addArguments("--remote-allow-origins=*");
		
		
	@Test()
	public void login() throws Exception
	{
		
		//WebDriver driver;
		
		
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		      // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
			 
			
				
			 
//			 WebElement uname= driver.findElement(By.xpath("//input[@placeholder='Username']"));
//			 uname.sendKeys("Admin");
//			 
//			 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//			 wait.until(ExpectedConditions.visibilityOf(uname));
//			  
//			// Thread.sleep(3000);
//			 
//			 
//				
//				 WebElement pwd=  driver.findElement(By.xpath("//input[@name='password']"));
//				pwd.sendKeys("admin123");
//				 // Thread.sleep(3000);
//				
//				  WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
//					wait1.until(ExpectedConditions.visibilityOf(pwd));
//					
//					 driver.findElement(By.xpath("//button[@type='submit']")).click();
			  
			 
			  if( driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/"))
			  {
				  System.out.println("Login Successful! ");
			  }
			  else
			  {
				  System.out.println("Login is failed...");
			  }
			
		}
		
		
		
	
		
		 /* 
		  if(driver.getPageSource().contains("PIM"))
		  {
			  System.out.println("Login is successfull...");
			  
		  }
		  else
		  {
			  System.out.println("Login is failed...");
		  }
		 
		  
		  if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"))
		  {
			  System.out.println("Login is failed...");
		  }
		  else
		  {
			  System.out.println("Login is successfull...");
		  }
		*/
		 // driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		/*  boolean status=driver.getPageSource().equalsIgnoreCase("Invalid credentials");
		  
		  if(status==true)
		  {
			  System.out.println("Login is failed....");
		  }
		  else
		  {
			  System.out.println("Login is successfull....");
		  }
		  */
		 
	

	
	@BeforeTest
	@Parameters("browser")
	public void browser_testing(String browser) throws Exception
	{
			try
			{
				options.addArguments("--remote-allow-origins=*");
				
				
				
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
			//Check if parameter passed as 'chrome'
		  if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
			 // WebDriverManager.chromedriver().setup();
			   System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver(options);
			}

		  else if(browser.equalsIgnoreCase("Edge")){
				//create firefox instance
				//System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			  WebDriverManager.edgedriver().setup();	
			  driver = new EdgeDriver();
		  }
		 

		  else if(browser.equalsIgnoreCase("Firefox")){
				//create firefox instance
					System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		 
			
			}
			catch(Exception e)
			{
				System.out.println("Exception is handled....");
			}
			
			
	
	}
	
/*	
	@AfterTest()
	public void afterTest() {
		

		driver.quit();
	}
	*/	
	

}

