package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class RegisterPage {
	WebDriver driver;
	CommonUtils commonUtils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	public void enterFirstName(String firstNameText) {
		commonUtils.typeTextInToElement(firstName, CommonUtils.IMPLICIT_WAIT_TIME, firstNameText);
		//firstName.sendKeys(firstNameText);
	}

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	public void enterLastName(String lastNameText) {
		commonUtils.typeTextInToElement(lastName, CommonUtils.IMPLICIT_WAIT_TIME, lastNameText);
		//lastName.sendKeys(lastNameText);
	}

	@FindBy(id = "input-email")
	private WebElement emailId;

	public void enterEmailId(String emailIdText) {
		commonUtils.typeTextInToElement(emailId, CommonUtils.IMPLICIT_WAIT_TIME, emailIdText);
		//emailId.sendKeys(emailIdText);
	}

	@FindBy(id = "input-telephone")
	private WebElement inputTelephone;

	public void enterInputTelephone(String inputTelephoneText) {
		commonUtils.typeTextInToElement(inputTelephone, CommonUtils.IMPLICIT_WAIT_TIME, inputTelephoneText);
		//inputTelephone.sendKeys(inputTelephoneText);
	}

	@FindBy(id = "input-password")
	private WebElement inputPassword;

	public void enterInputPassword(String inputPasswordText) {
		commonUtils.typeTextInToElement(inputPassword, CommonUtils.IMPLICIT_WAIT_TIME, inputPasswordText);
		//inputPassword.sendKeys(inputPasswordText);
	}

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	public void enterConfirmPassword(String confirmPasswordText) {
		commonUtils.typeTextInToElement(confirmPassword, CommonUtils.IMPLICIT_WAIT_TIME, confirmPasswordText);
		//confirmPassword.sendKeys(confirmPasswordText);
	}

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicy;

	public void clickOnPrivacyPolicy() {
		commonUtils.clickOnElement(privacyPolicy, CommonUtils.IMPLICIT_WAIT_TIME);
		//privacyPolicy.click();
	}

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterPolicy;

	public void clickOnNewsLetterPolicy() {
		commonUtils.clickOnElement(newsLetterPolicy, CommonUtils.IMPLICIT_WAIT_TIME);
		//newsLetterPolicy.click();
	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	public RegisterAccountSuccessPage clickOnContinueButton() {
		commonUtils.clickOnElement(continueButton, CommonUtils.IMPLICIT_WAIT_TIME);
		//continueButton.click();
		return new RegisterAccountSuccessPage(driver);
	}

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateWarningMessage;

	public boolean getDuplicateWarningMessage() {
		return commonUtils.displayStatusOfAnElement(duplicateWarningMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return duplicateWarningMessage.isDisplayed();
	}

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;

	public boolean getPrivacyPolicyWarningMessage() {
		return commonUtils.displayStatusOfAnElement(privacyPolicyWarningMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return privacyPolicyWarningMessage.isDisplayed();
	}

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;

	public String getFirstNameWarningMessage() {
		return commonUtils.getTextFromElement(firstNameWarningMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return firstNameWarningMessage.getText();
	}

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;

	public String getLastNameWarningMessage() {
		return commonUtils.getTextFromElement(lastNameWarningMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return lastNameWarningMessage.getText();
	}

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;

	public String getEmailWarningMessage() {
		return commonUtils.getTextFromElement(emailWarningMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return emailWarningMessage.getText();
	}

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;

	public String getTelephoneWarningMessage() {
		return commonUtils.getTextFromElement(telephoneWarningMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return telephoneWarningMessage.getText();
	}

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement inputPasswordWarningMessage;

	public String getInputPasswordWarningMessage() {
		return commonUtils.getTextFromElement(inputPasswordWarningMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return inputPasswordWarningMessage.getText();
	}

}
