package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class HomePage {
	WebDriver driver;
	CommonUtils commonUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropDown;

	public void clickOnMyAccountDropDown() {
		commonUtils.clickOnElement(myAccountDropDown, CommonUtils.IMPLICIT_WAIT_TIME);
		// myAccountDropDown.click();
	}

	@FindBy(linkText = "Login")
	private WebElement loginButtonOnMyAccountDropDown;

	public LoginPage clickLoginButtonOnMyAccountDropDown() {

		commonUtils.clickOnElement(loginButtonOnMyAccountDropDown, CommonUtils.IMPLICIT_WAIT_TIME);
		// loginButtonOnMyAccountDropDown.click();
		return new LoginPage(driver);
	}

	@FindBy(linkText = "Register")
	private WebElement registerButtonOnMyAccountDropDown;

	public RegisterPage clickRegisterButtonOnMyAccountDropDown() {
		commonUtils.clickOnElement(registerButtonOnMyAccountDropDown, CommonUtils.IMPLICIT_WAIT_TIME);
		// registerButtonOnMyAccountDropDown.click();
		return new RegisterPage(driver);
	}

	@FindBy(name = "search")
	private WebElement searchBox;

	public void enterProductNameOnSearchBox(String productNameText) {
		commonUtils.typeTextInToElement(searchBox, CommonUtils.IMPLICIT_WAIT_TIME, productNameText);
		// searchBox.sendKeys(productNameText);

	}

	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;

	public SearchPage clickOnSearchButton() {
		commonUtils.clickOnElement(searchButton, CommonUtils.IMPLICIT_WAIT_TIME);
		// searchButton.click();
		return new SearchPage(driver);
	}
}
