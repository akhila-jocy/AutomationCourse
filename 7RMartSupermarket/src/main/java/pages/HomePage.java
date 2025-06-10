package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@data-toggle=\"dropdown\" ]") private WebElement adminDropDownLink;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") private WebElement logoutOption;
	@FindBy(xpath = "//button[@type='submit']") private WebElement signinButtonOnLogInPage;
	
	public void clickOnadmindropdownLink()
	{
		adminDropDownLink.click();
	}
	
	public void clickOnLogoutOption()
	{
		logoutOption.click();
	}
	
	public boolean signinPageDisplayed()
	{
		return signinButtonOnLogInPage.isDisplayed();
	}
}
