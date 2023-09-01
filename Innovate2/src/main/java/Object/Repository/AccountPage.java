package Object.Repository;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class AccountPage {

		public AccountPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="(//*[@class=\"icon account-active svg-account-active-dims \"])[2]")
		private WebElement MyAccountIcon;

		@FindBy(xpath="(//a[@title=\"Login\"])[2]")
		private WebElement LoginLink;


		@FindBy(xpath="(//a[@title=\"Go to: Logout\"])[2]")
		private WebElement Logout;

		@FindBy(xpath="//*[@class=\"icon shopping-bag svg-shopping-bag-dims header-icons\"]")
		private WebElement Cart;

		public WebElement getLogout() {
			return Logout;
		}

		public WebElement getMyAccountIcon() {
			return MyAccountIcon;
		}


		public WebElement getLoginLink() {
			return LoginLink;
		}
		public void AccountIcon()
		{
			MyAccountIcon.click();
			LoginLink.click();
		}


}
