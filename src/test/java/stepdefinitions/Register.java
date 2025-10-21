package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.RegisterAccountSuccessPage;
import pageobjects.RegisterPage;
import utils.Utilities;

public class Register {
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	RegisterAccountSuccessPage registerAccountSuccessPage;

	@Given("user navigates to register page")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropDown();
		registerPage = homePage.clickRegisterButtonOnMyAccountDropDown();

	}

	@When("user enters value for the mandatory fields")
	public void user_enters_value_for_the_mandatory_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailId(Utilities.getTimeStamp());
		registerPage.enterInputTelephone(dataMap.get("telephone"));
		registerPage.enterInputPassword(dataMap.get("registerPassword"));
		registerPage.enterConfirmPassword(dataMap.get("registerConfirmPassword"));

	}

	@When("user enters value for the all fields with duplicate email")
	public void user_enters_value_for_the_all_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailId(dataMap.get("email"));
		registerPage.enterInputTelephone(dataMap.get("telephone"));
		registerPage.enterInputPassword(dataMap.get("registerPassword"));
		registerPage.enterConfirmPassword(dataMap.get("registerConfirmPassword"));

	}

	@And("user clicks on the privacy policy")
	public void user_clicks_on_the_privacy_policy() {
		registerPage.clickOnPrivacyPolicy();
	}

	@And("user click on continue button")
	public void user_click_on_continue_button() {
		registerAccountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("user navigates to account created page")
	public void user_navigates_to_account_created_page() {

		Assert.assertTrue(registerAccountSuccessPage.getAccountSuucessMessage());
	}

	@When("user enters value for the all fields")
	public void user_enters_value_for_the_all_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailId(Utilities.getTimeStamp());
		registerPage.enterInputTelephone(dataMap.get("telephone"));
		registerPage.enterInputPassword(dataMap.get("registerPassword"));
		registerPage.enterConfirmPassword(dataMap.get("registerConfirmPassword"));

	}

	@And("user clicks on newsletter policy")
	public void user_clicks_on_newsletter_policy() {
		registerPage.clickOnNewsLetterPolicy();
	}

	@Then("user got duplicate mail warning")
	public void user_got_duplicate_mail_warning() {
		Assert.assertTrue(registerPage.getDuplicateWarningMessage());

	}

	@When("user didnot enters value for the fields")
	public void user_didnot_enters_value_for_the_fields() {

	}

	@Then("user got mandatory fields warning")
	public void user_got_mandatory_fields_warning() {
		Assert.assertTrue(registerPage.getPrivacyPolicyWarningMessage());

		Assert.assertEquals(registerPage.getFirstNameWarningMessage(),
				"First Name must be between 1 and 32 characters!");

		Assert.assertEquals(registerPage.getLastNameWarningMessage(), "Last Name must be between 1 and 32 characters!");

		Assert.assertEquals(registerPage.getEmailWarningMessage(), "E-Mail Address does not appear to be valid!");

		Assert.assertEquals(registerPage.getTelephoneWarningMessage(),
				"Telephone must be between 3 and 32 characters!");

		Assert.assertEquals(registerPage.getInputPasswordWarningMessage(),
				"Password must be between 4 and 20 characters!");

	}
}
