package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {

	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle=\"dropdown\" ]")
	private WebElement adminDropDownLink;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutOption;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinButtonOnLogInPage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")
	private WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//a[@href=\'https://groceryapp.uniqassosiates.com/admin/list-news\' and text()=\'More info \']")
	private WebElement manageNewsMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and text()='More info ']")
	private WebElement manageCategoryMoreInfo;

	public HomePage clickOnadmindropdownLink() {
		adminDropDownLink.click();
		return this;
	}

	public SigninPage clickOnLogoutOption() {
		logoutOption.click();
		return new SigninPage(driver);
	}

	public boolean signinPageDisplayed() {
		return pageUtility.isElementDisplayed(signinButtonOnLogInPage);
	}

	public AdminUsersPage clickOnAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickOnManageNewsTileMoreInfo() {
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}

	public ManagecategoriesPage clickMoreInfoInManageCategories() {
		manageCategoryMoreInfo.click();
		return new ManagecategoriesPage(driver);
	}

}
