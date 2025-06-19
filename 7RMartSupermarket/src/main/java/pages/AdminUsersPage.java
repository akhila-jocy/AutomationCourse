package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();

	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") private WebElement newButtonToAddNewUsers;
	@FindBy(id="username") private WebElement usernameField;
	@FindBy(id="password") private WebElement passwordField;
	@FindBy(id="user_type") private WebElement userTypeField;
	@FindBy(xpath="//button[@name='Create']") private WebElement saveButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchButton;
	@FindBy(id="un") private WebElement usernameFieldSearchField;
	@FindBy(id="ut") private WebElement selectUserTypeToSearch;
	@FindBy(xpath="//button[@name='Search']") private WebElement searchButtonToSubmit;
	
	
	
	public AdminUsersPage clickOnNewButtonInAdminUsersPage()
	{
		newButtonToAddNewUsers.click();
		return this;
	}
	public AdminUsersPage enterUsernameonUsernameField(String adminUsername)
	{
		usernameField.sendKeys(adminUsername);
		return this;
	}
	public AdminUsersPage enterPasswordonPasswordField(String adminPassword)
	{
		passwordField.sendKeys(adminPassword);
		return this;
	}
	public AdminUsersPage selectUserTypefromUserTypeDropDown()
	{
		pageUtility.selectDropdownByIndex(userTypeField, 2);
		return this;
		//Select select = new Select(userTypeField);
		//select.selectByIndex(2);
		
	}
	public AdminUsersPage clickOnSaveButton()
	{
		waitUtility.waitUntilElementToBeClickable(driver, saveButton);
		saveButton.click();
		return this;
	}
	public AdminUsersPage clickOnSearchButtonInAdminUsersPage()
	{
		searchButton.click();
		return this;
	}
	public AdminUsersPage enterUsernameToSearchAdminUser(String adminUsername)
	{
		usernameFieldSearchField.sendKeys(adminUsername);
		return this;
	}
	public AdminUsersPage selectUserTypeFromDropdownToSearch()
	{
		pageUtility.selectDropdownByIndex(selectUserTypeToSearch, 2);
		return this;
	}
	public AdminUsersPage clickOnSearchButtonToSearchAdminUsers()
	{
		searchButtonToSubmit.click();
		return this;
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
