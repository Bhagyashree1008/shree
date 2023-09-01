package TESTCLASSES;

	import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Object.Repository.AccountPage;
import Object.Repository.LoginPage;
import Object.Repository.Products;
import Utility.Files.BaseClass;

import Utility.Files.PropertyUtility;
import Utility.Files.WebUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class AddtocartPage  {
		public WebUtility wUtil = new WebUtility();
		public PropertyUtility pUtil = new PropertyUtility();
		public WebDriver driver = null;
		public static WebDriver sDriver;

		@Test
		public void sample () throws Throwable
		{
			WebUtility web=new WebUtility();
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
			AccountPage account= new AccountPage(driver);
			account.AccountIcon();


		    String EMAIL = pUtil.readDatafromPropertyFile("Email");
		    String PASSWORD = pUtil.readDatafromPropertyFile("Password");
		    LoginPage lp = new LoginPage(driver);
		    lp.emailPwdLogin(EMAIL, PASSWORD);
		    driver.switchTo().activeElement().click();
		  Thread.sleep(4000);
		lp.getLoginButton().click();
		System.out.println(" --- Login is Successful ---");
		Thread.sleep(500);

		lp.getShopWomen().click();
		   Products pro=new Products(driver) ;
		    System.out.println("productpage successfully details");
		   pro.clickShopNowProduct1(driver);

		   String exp="Women's ROGAINE® Foam, 5% Minoxidil Hair Regrowth Treatment | ROGAINE®";
		   String act=driver.getTitle();
		   Assert.assertEquals(act, exp);
		   System.out.println("yesrproduct details  page dispalyed ");
		   Thread.sleep(1000);
		  pro.ClickAddToCart(driver);
		  pro.getAddToCartSVGICON().click();
		  String exp1="Shopping Cart | ROGAINE®";
		   String act1=driver.getTitle();
		   Assert.assertEquals(act1, exp1);
		   System.out.println("yesrproduct added tocart ");

		}

	}


