package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

	public WebDriver driver;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;

	public SigninPage enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public SigninPage enterPasswordOnpasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public HomePage clickOnSigninButton() {
		signinButton.click();
		return new HomePage(driver);
	}

	public String dashboardDisplayed() {
		return dashboard.getText();
	}
}
