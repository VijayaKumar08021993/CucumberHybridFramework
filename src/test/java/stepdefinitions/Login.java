package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.Utilities;

public class Login {
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;

	@Given("user navigates to the login page")
	public void user_navigates_to_the_login_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropDown();
		loginPage = homePage.clickLoginButtonOnMyAccountDropDown();

	}

//	@When("user enters valid emailId {string}")
//	public void user_enters_valid_email_id(String loginEmailIdText) {
//		loginPage.enterEmailAddress(loginEmailIdText);
//	}
//
//	@And("user enters validPassword {string}")
//	public void user_enters_validPassword(String loginPasswordext) {
//		loginPage.enterPassword(loginPasswordext);
//	}
	
	@When("^user enters valid emailId (.+)$")
	public void user_enters_valid_email_id(String loginEmailIdText) {
		loginPage.enterEmailAddress(loginEmailIdText);
	}

	@And("^user enters validPassword (.+)$")
	public void user_enters_validPassword(String loginPasswordext) {
		loginPage.enterPassword(loginPasswordext);
	}

	@And("user click on the login button")
	public void user_click_on_the_login_button() {
		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("user navigates to account page")
	public void user_navigates_to_account_page() {
		accountPage.verifyEditYourAccountInformation();

	}

	@When("user enters inValid emailId")
	public void user_enters_in_valid_email_id() {
		loginPage.enterEmailAddress(Utilities.getTimeStamp());

	}

	@And("user enters inValid password {string}")
	public void user_enters_in_valid_password(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);

	}

	@Then("user seen warning message about invalid emailId and password")
	public void user_seen_warning_message_about_invalid_email_id_and_password() {
		
		org.junit.Assert.assertTrue(loginPage.getInvalidEmailIdAndPasswordWarningMessage()
				.contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("user didnot enters any value in emailId field")
	public void user_didnot_enters_any_value_in_email_id_field() {

	}

	@And("user didnot enters any value in password field")
	public void user_didnot_enters_any_value_in_password_field() {

	}

}
