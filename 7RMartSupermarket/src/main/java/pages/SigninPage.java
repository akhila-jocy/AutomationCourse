package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

	
	public WebDriver driver;
	
	public SigninPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='username']") private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement signinButton;
	@FindBy(xpath="//p[text()='Dashboard']") private WebElement dashboard;
	
	
	public void enterUsernameOnUsernameField(String username)
	{
		usernameField.sendKeys(username);
	}
	public void enterPasswordOnpasswordField(String password)
	{
		passwordField.sendKeys(password);
	}
	public void clickOnSigninButton()
	{
		signinButton.click();
	}
	
	public String dashboardDisplayed()
	{
		return dashboard.getText();
	}
}
