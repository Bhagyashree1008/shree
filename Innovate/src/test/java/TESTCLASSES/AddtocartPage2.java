package TESTCLASSES;

	import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
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

	public class AddtocartPage2  extends BaseClass  {
		public WebUtility wUtil = new WebUtility();
		public PropertyUtility pUtil = new PropertyUtility();
	
		@Test
		public void sample1 () throws Throwable
		{
			Products pro=new Products(driver) ;
		   System.out.println("productpage successfully details");
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


