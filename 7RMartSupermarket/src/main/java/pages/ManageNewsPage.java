package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href=\'https://groceryapp.uniqassosiates.com/admin/news/add\']")
	private WebElement manageNewsAddButton;
	@FindBy(id = "news")
	private WebElement newsTextArea;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[text()=' Search']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement newsTitleInputField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButtonToSubmitNews;

	public ManageNewsPage clickOnManageNewsAddButton() {
		manageNewsAddButton.click();
		return this;
	}

	public ManageNewsPage enterNewsOnNewsField(String news) {
		newsTextArea.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSaveButtonToSaveNews() {
		saveButton.click();
		return this;
	}

	public ManageNewsPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public ManageNewsPage enterNewsTitleToSearch(String searchNews) {
		newsTitleInputField.sendKeys(searchNews);
		return this;
	}

	public ManageNewsPage clickOnSearchButtonToSearchNews() {
		searchButtonToSubmitNews.click();
		return this;
	}
}
