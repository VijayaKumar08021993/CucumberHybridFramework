package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class AccountPage {
	WebDriver driver;
	CommonUtils commonUtils;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformation;

	public boolean verifyEditYourAccountInformation() {
		return commonUtils.displayStatusOfAnElement(editYourAccountInformation, CommonUtils.IMPLICIT_WAIT_TIME);
		//return editYourAccountInformation.isDisplayed();
	}

}
