package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	public WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@data-toggle=\"dropdown\" ]") private WebElement adminDropDownLink;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") private WebElement logoutOption;
	
	
	public void clickOnadmindropdownLink()
	{
		adminDropDownLink.click();
	}
	
	public void clickOnLogoutOption()
	{
		logoutOption.click();
	}
}
