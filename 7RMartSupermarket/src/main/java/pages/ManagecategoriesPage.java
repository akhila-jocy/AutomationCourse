package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constant;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagecategoriesPage {

	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();

	public ManagecategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	private WebElement manageCategoryAddButton;
	@FindBy(id = "category")
	private WebElement categoryField;
	@FindBy(id = "134-selectable")
	private WebElement discount;
	@FindBy(id = "main_img")
	private WebElement imageUpload;
	@FindBy(xpath = "//input[@name='top_menu' and @value='no']")
	private WebElement notShowOnTopMenuRadioButton;
	@FindBy(xpath = "//input[@name='show_home' and @value='no']")
	private WebElement notShowOnLeftMenuRadioButton;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath = "//h1[text()='Add Category']")
	private WebElement addCateory;

	public ManagecategoriesPage clickOnNewButtonToAddNewCategory() {
		manageCategoryAddButton.click();
		return this;
	}

	public ManagecategoriesPage enterCategoryInCategoryField(String category) {
		categoryField.sendKeys(category);
		return this;
	}

	public ManagecategoriesPage clickOnDiscount() {
		discount.click();
		return this;
	}

	public ManagecategoriesPage clickOnFileUploadToUploadImage() {
		imageUpload.sendKeys(Constant.TESTIMAGEFILE);
		return this;
	}

	public ManagecategoriesPage showOnTopMenuRadioButton() {
		waitUtility.waitUntilElementToBeClickable(driver, notShowOnTopMenuRadioButton);
		pageUtility.clickUsingJavaScriptExecutor(notShowOnTopMenuRadioButton, driver);
		pageUtility.scrollDown(driver, 500);
		return this;
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", notShowOnTopMenuRadioButton);
		// js.executeScript("window.scrollBy(0,500)", "");
	}

	public ManagecategoriesPage showOnLeftMenuRadioButton() {
		waitUtility.waitUntilElementToBeClickable(driver, notShowOnLeftMenuRadioButton);
		pageUtility.clickUsingJavaScriptExecutor(notShowOnLeftMenuRadioButton, driver);
		pageUtility.scrollDown(driver, 500);
		return this;
	}

	public ManagecategoriesPage clickOnSaveButtonToSavecategory() {
		pageUtility.clickUsingJavaScriptExecutor(saveButton, driver);
		return this;
	}

	public String addcategoryDisplayed() {
		return addCateory.getText();
	}
}
