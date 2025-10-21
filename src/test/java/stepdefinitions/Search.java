package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.SearchPage;

public class Search {
	WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;

	@Given("user already on homePage")
	public void user_already_on_home_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);

	}

	@When("user enters validProductName {string}")
	public void user_enters_valid_product_name(String validProductNameText) {
		homePage.enterProductNameOnSearchBox(validProductNameText);

	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() {
		searchPage = homePage.clickOnSearchButton();
	}

	@Then("user navigates to search page")
	public void user_navigates_to_search_page() {
		org.junit.Assert.assertEquals(searchPage.getSuccessSearchCriteriaMessage(), "Products meeting the search criteria");
		
	}

	@Then("user navigates to search page failure message")
	public void user_navigates_to_search_page_failure_message() {

		org.junit.Assert.assertEquals(searchPage.getFailureSearchCriteriaMessage(),
				"There is no product that matches the search criteria.");
	}

	@When("user enters inValidProductName {string}")
	public void user_enters_in_valid_product_name(String invalidProductNameText) {
		homePage.enterProductNameOnSearchBox(invalidProductNameText);

	}

	@When("user didnot enters anyProductName")
	public void user_didnot_enters_any_product_name() {

	}
}
