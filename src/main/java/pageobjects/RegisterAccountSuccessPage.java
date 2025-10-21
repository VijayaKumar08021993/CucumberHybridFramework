package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class RegisterAccountSuccessPage {
	WebDriver driver;
	CommonUtils commonUtils;

	public RegisterAccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement accountSuccessMessage;

	public boolean getAccountSuucessMessage() {
		return commonUtils.displayStatusOfAnElement(accountSuccessMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		// return accountSuccessMessage.isDisplayed();

	}

}
