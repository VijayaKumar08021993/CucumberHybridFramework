package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class SearchPage {
	WebDriver driver;
	CommonUtils commonUtils;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 commonUtils = new CommonUtils(driver);
	}

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::h2")
	private WebElement successSearchCriteriaMessage;

	public String getSuccessSearchCriteriaMessage() {
		return	commonUtils.getTextFromElement(successSearchCriteriaMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return successSearchCriteriaMessage.getText();
	}

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement failureSearchCriteriaMessage;

	public String getFailureSearchCriteriaMessage() {
		return	commonUtils.getTextFromElement(failureSearchCriteriaMessage, CommonUtils.IMPLICIT_WAIT_TIME);
		//return failureSearchCriteriaMessage.getText();
	}

}
