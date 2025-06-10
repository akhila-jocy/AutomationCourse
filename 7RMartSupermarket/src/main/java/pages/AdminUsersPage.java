package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")private WebElement adminUsersMoreInfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") private WebElement newButtonToAddNewUsers;
	@FindBy(id="username") private WebElement usernameField;
	@FindBy(id="password") private WebElement passwordField;
	@FindBy(id="user_type") private WebElement userTypeField;
	@FindBy(xpath="//button[@name='Create']") private WebElement saveButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchButton;
	@FindBy(id="un") private WebElement usernameFieldSearchField;
	@FindBy(id="ut") private WebElement selectUserTypeToSearch;
	@FindBy(xpath="//button[@name='Search']") private WebElement searchButtonToSubmit;
	
	
	public void clickOnAdminUsersMoreInfo()
	{
		adminUsersMoreInfo.click();
	}
	public void clickOnNewButton()
	{
		newButtonToAddNewUsers.click();
	}
	public void enterUsernameonUsernameField(String adminUsername)
	{
		usernameField.sendKeys(adminUsername);
	}
	public void enterPasswordonPasswordField(String adminPassword)
	{
		passwordField.sendKeys(adminPassword);
	}
	public void selectUserTypefromUserTypeDropDown()
	{
		Select select = new Select(userTypeField);
		select.selectByIndex(2);
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	public void clickOnSearchButtonInAdminUsersPage()
	{
		searchButton.click();
	}
	public void enterUsernameToSearchAdminUser(String adminUsername)
	{
		usernameFieldSearchField.sendKeys(adminUsername);
	}
	public void selectUserTypeFromDropdownToSearch()
	{
		Select select = new Select(selectUserTypeToSearch);
		select.selectByIndex(2);
	}
	public void clickOnSearchButtonToSearchAdminUsers()
	{
		searchButtonToSubmit.click();
	}
	
	public boolean addAdminUsersPageDisplayed()
	{
		return usernameField.isDisplayed();
	}
	
	public boolean adminUsersSearchPageDisplayed()
	{
		return usernameFieldSearchField.isDisplayed();
	} 
	
}
