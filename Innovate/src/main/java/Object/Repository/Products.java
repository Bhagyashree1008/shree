package Object.Repository;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.Files.WebUtility;

public class Products {
	WebUtility wUtil=new WebUtility();
	public Products(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="((//a[text()=\"Shop Now\"])[1])")
	private WebElement ShopNow;

	@FindBy(xpath="(//div/p[@class=\"uppercase product-name\"])[1]")
	private WebElement ShopNowProduct1;

	@FindBy(xpath = "dwvar_undefined_size")
	private WebElement DropDown;

	@FindBy(xpath="//button[@title=\"Add to Bag\"]")
	private WebElement AddToCart;

	@FindBy(xpath="//div[@class=\"mini-cart-header\"]")
	private WebElement ShoppingBag;

	@FindBy(xpath="//*[@class=\"icon shopping-bag svg-shopping-bag-dims header-icons\"]")
	private WebElement AddToCartSVGICON;

	public WebElement getAddToCartSVGICON() {
		return AddToCartSVGICON;
	}
	public void ClickAddToCart(WebDriver driver)
	{

		    JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].click();", AddToCart);

	}
	public WebUtility getwUtil() {
		return wUtil;
	}
	public WebElement getShoppingBag() {
		return ShoppingBag;
	}
	public WebElement getAddToCart() {
		return AddToCart;
	}


/*public void mouseHoverOnCart(WebDriver driver)
{
	wUtil.mouseHoverAction(driver, AddToCartSVGICON);
	wUtil.mouseHoverAction(driver, ShoppingBag);
}*/
	public WebElement getDropDown() {
		return DropDown;
	}

	public void  SelectFromDropDown()
	{
		Select sel=new Select(DropDown);
	   sel.selectByIndex(2);
	}

	public WebElement getShopNowProduct1() {
		return ShopNowProduct1;
	}

	public WebElement getShopNow() {
		return ShopNow;
	}
	public void clickShopNowProduct1(WebDriver driver)
	{
		

	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", ShopNow);

		
	}

	public void ShopNowButton( WebDriver driver)
	{
	    ShopNow.click();

	}

}
