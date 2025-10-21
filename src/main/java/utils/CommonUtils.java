package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	WebDriver driver;
	WebDriverWait wait;
	WebElement webelement;
	Alert alert;
	Actions actions;
	JavascriptExecutor javascriptExecutor;

	public static final int IMPLICIT_WAIT_TIME = 15;
	public static final int PAGE_LOAD_TIME = 10;
	public static final int EXPLICIT_WAIT_TIME = 30;

	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationOfSeconds) {
		webelement = waitForElement(element, durationOfSeconds);
		webelement.click();
	}

	public void typeTextInToElement(WebElement element, long durationOfSeconds, String typeElementText) {
		webelement = waitForElement(element, durationOfSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(typeElementText);
	}

	public WebElement waitForElement(WebElement element, long durationOfSeconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
			webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.getMessage();
		}
		return webelement;
	}

	public void selectOptionDropDown(WebElement element, long durationOfSeconds, String dropDownText) {
		webelement = waitForElement(element, durationOfSeconds);
		Select select = new Select(element);
		select.selectByVisibleText(dropDownText);

	}

	public Alert waitForAlert(WebElement element, long durationOfSeconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void acceptAlert(WebElement element, long durationOfSeconds) {
		alert = waitForAlert(element, durationOfSeconds);
		alert.accept();
	}

	public void dismissAlert(WebElement element, long durationOfSeconds) {
		alert = waitForAlert(element, durationOfSeconds);
		alert.dismiss();
	}

	public WebElement visiblilityOfElements(WebElement element, long durationOfSeconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
			webelement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}

	public void mouseHoverAndClick(WebElement element, long durationOfSeconds) {
		webelement = visiblilityOfElements(element, durationOfSeconds);
		actions = new Actions(driver);
		actions.moveToElement(webelement).click().build().perform();
	}

	public void javaScriptClick(WebElement element, long durationOfSeconds) {
		webelement = visiblilityOfElements(element, durationOfSeconds);
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click;", "webelement");
	}

	public void javaScriptTypeText(WebElement element, long durationOfSeconds, String jsTpyeText) {
		webelement = visiblilityOfElements(element, durationOfSeconds);
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeAsyncScript("arguments[0].value='" + jsTpyeText + "'", "webelement");

	}

	public String getTextFromElement(WebElement element, long durationOfSeconds) {
		webelement = waitForElement(element, durationOfSeconds);
		return webelement.getText();
	}

	public boolean displayStatusOfAnElement(WebElement element, long durationOfSeconds) {
		try {
			webelement = visiblilityOfElements(element, durationOfSeconds);
			return webelement.isDisplayed();
		} catch (Throwable e) {
			return false;
		}

	}
}
