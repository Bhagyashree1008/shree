package Object.Repository;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id=\"dwfrm_login_username\"]")
	private WebElement UserName;


	@FindBy(xpath="//input[@id=\"dwfrm_login_password\"]")
	private WebElement Password;

	@FindBy(className = "large")
	private WebElement LoginButton;

	@FindBy(xpath = "(//a[@class=\"nav-topcat-link menu-item-toggle  \"])[2]")
	private WebElement ShopWomen;


	@FindBy(xpath = "(//a[@href=\"https://www.rogaine.com/products/womens-hair-regrowth-solutions-2\"])[2]")
	private WebElement ShopWomen1;

	
	public WebElement getShopWomen() {
		return ShopWomen;
	}

	public WebElement getShopWomen1() {
		return ShopWomen1;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}


	public WebElement getUserName() {
		return UserName;
	}



	public WebElement getPassword() {
		return Password;
	}
	public void clickShopWomen(WebDriver driver) {
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].click();", ShopWomen);

	//	ShopWomen.click();
	}

	public void emailPwdLogin(String mail, String pwd) throws Throwable
	{
		UserName.sendKeys(mail,Keys.TAB);
		Password.sendKeys(pwd,Keys.TAB);

	}

}
