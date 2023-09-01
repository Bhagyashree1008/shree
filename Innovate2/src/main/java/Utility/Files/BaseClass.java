package Utility.Files;

	import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNGException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Object.Repository.AccountPage;
import Object.Repository.LoginPage;
import Object.Repository.Products;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public WebUtility wUtil = new WebUtility();
		public PropertyUtility pUtil = new PropertyUtility();

		public WebDriver driver = null;
		public static WebDriver sDriver;

		@BeforeSuite
		public void bscConfig() throws IOException,InterruptedException,TestNGException
	{
			System.out.println("database");
	}
	
	

		//@Parameters("BROWSER")
		@BeforeTest
			public void bcConfig() throws IOException,InterruptedException,TestNGException
		{
			String BROWSER = pUtil.readDatafromPropertyFile("Browser");
			String URL = pUtil.readDatafromPropertyFile("Url");

			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(BROWSER+" --- Browser launch successful ---");
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println(BROWSER+" --- Browser launch successful ---");
			}
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println(BROWSER+" --- Browser launch successful ---");
			}
			else
			{
				System.out.println("invalid browser name in property file");
			}

			sDriver=driver; // take screen shot
			wUtil.maximizeWindow(driver);
			wUtil.waitForPageLoad(driver);

			driver.get(URL);
			Thread.sleep(3000);
			driver.navigate().refresh();
		}

		@BeforeClass
		public void bmConfig() throws Throwable
		{

			AccountPage account= new AccountPage(driver);
	account.AccountIcon();


    String EMAIL = pUtil.readDatafromPropertyFile("Email");
    String PASSWORD = pUtil.readDatafromPropertyFile("Password");
    LoginPage lp = new LoginPage(driver);
    lp.emailPwdLogin(EMAIL, PASSWORD);
    driver.switchTo().activeElement().click();
    	Thread.sleep(5000);
  		lp.getLoginButton().click();
  		System.out.println(" --- Login is Successful ---");
		   
		//   Products pro=new Products(driver) ;
		   
	//	   pro.clickShopNowProduct1(driver);
  		
		}
		@BeforeMethod
		public void bcmConfig() throws Throwable
		{
			Thread.sleep(500);

			LoginPage lp = new LoginPage(driver);
			//lp.getShopWomen().click();
			//lp.getShopWomen1().click();
			 lp.clickShopWomen(driver);

			   Products pro=new Products(driver) ;
	 

	pro.clickShopNowProduct1(driver);

//pro.ShopNowButton(driver);
		

		}


		@AfterMethod(alwaysRun=false)
		public void amConfig() throws Throwable
		{

			Thread.sleep(2000);
			AccountPage account= new AccountPage(driver);
			account.getLogout().click();
			System.out.println(" --- Logout is Successful ---");

		}

		@AfterClass(alwaysRun=false)
		public void aConfig() throws Throwable
		{
System.out.println("");
			
		}

		@AfterTest(alwaysRun=false)
		
		public void acConfig()
		{
			//driver.quit();
			System.out.println(" --- browser closed Successfully ---");
		}

		@AfterSuite(alwaysRun=false)
		public void asConfig() 
	{
			System.out.println("database close");
	}
	
	}

