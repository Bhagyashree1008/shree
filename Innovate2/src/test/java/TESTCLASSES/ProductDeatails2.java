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

public class ProductDeatails2  extends  BaseClass {
	public WebUtility wUtil = new WebUtility();
	public PropertyUtility pUtil = new PropertyUtility();
	@Test
	public void sample () throws Throwable
	{	 
	//	   Products pro=new Products(driver) ;
		   

//pro.ShopNowButton(driver);
		
		System.out.println("productpage successfully details");
	 //   pro.SelectFromDropDown();
	   String exp="Women's ROGAINE® Foam, 5% Minoxidil Hair Regrowth Treatment | ROGAINE®";
	   String act=driver.getTitle();
	   Assert.assertEquals(act, exp);
	   System.out.println("yesrproduct details  page dispalyed ");

	}

}
