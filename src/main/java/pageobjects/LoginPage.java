package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class LoginPage {
	WebDriver driver;
	CommonUtils commonUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 commonUtils = new CommonUtils(driver);

	}

	@FindBy(id = "input-email")
	private WebElement emailAddress;

	public void enterEmailAddress(String emailAddressText) {
		commonUtils.typeTextInToElement(emailAddress, CommonUtils.IMPLICIT_WAIT_TIME, emailAddressText);
		//emailAddress.sendKeys(emailAddressText);
	}

	@FindBy(id = "input-password")
	private WebElement password;

	public void enterPassword(String passwordText) {
		commonUtils.typeTextInToElement(password, CommonUtils.IMPLICIT_WAIT_TIME, passwordText);
		//password.sendKeys(passwordText);
	}

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbutton;

	public AccountPage clickOnLoginButton() {
		commonUtils.clickOnElement(loginbutton, CommonUtils.IMPLICIT_WAIT_TIME);
		//loginbutton.click();
		return new AccountPage(driver);
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement invalidEmailIdAndPasswordWarningMessage;
	
	public String getInvalidEmailIdAndPasswordWarningMessage() {
		return commonUtils.getTextFromElement(invalidEmailIdAndPasswordWarningMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return invalidEmailIdAndPasswordWarningMessage.getText();
	}

}
