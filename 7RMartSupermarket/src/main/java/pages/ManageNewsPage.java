package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//a[@href=\'https://groceryapp.uniqassosiates.com/admin/list-news\' and text()=\'More info \']") private WebElement manageNewsMoreInfo;
@FindBy(xpath="//a[@href=\'https://groceryapp.uniqassosiates.com/admin/news/add\']") private WebElement manageNewsAddButton;
@FindBy(id="news") private WebElement newsTextArea;
@FindBy(xpath="//button[@type='submit']") private WebElement saveButton;
@FindBy(xpath="//a[text()=' Search']") private WebElement searchButton;
@FindBy(xpath="//input[@class='form-control']") private WebElement newsTitleInputField;
@FindBy(xpath="//button[@type='submit']") private WebElement searchButtonToSubmitNews;

	public void clickOnManageNewsTileMoreInfo()
	{
		manageNewsMoreInfo.click();
	}
	public void clickOnManageNewsAddButton()
	{
		manageNewsAddButton.click();
	}
	public void enterNewsOnNewsField(String news)
	{
		newsTextArea.sendKeys(news);
	}
	public void clickSaveButtonToSaveNews()
	{
		saveButton.click();
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	public void enterNewsTitleToSearch(String searchNews)
	{
		newsTitleInputField.sendKeys(searchNews);
	}
	public void clickOnSearchButtonToSearchNews()
	{
		searchButtonToSubmitNews.click();
	}
}
