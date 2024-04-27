package stepdefinitions;


import hooks.SeleniumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CarsGuideHomePageActions;

public class SearchCarStepDefinitions {
	
	CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
	
	@Given("I am on CarsGuide home pages")
	public void i_am_on_cars_guide_home_pages() {
	    SeleniumDriver.openPage("https://www.carsguide.com.au/");
	}

	@Then("check if the site Logo is present")
	public void check_if_the_site_logo_is_present() {
		carsGuideHomePageActions.verifyTheLogoIsPresent();;
	}

	@Then("validate search field is present")
	public void validate_search_field_is_present() {
		carsGuideHomePageActions.verifySeachFieldIsPresent();
	}

	@Then("validate sell my car button is present")
	public void validate_sell_my_car_button_is_present() {
		carsGuideHomePageActions.verifySellMyCarButton();
	}

	@Then("validate we have my shortlist option")
	public void validate_we_have_my_shortlist_option() {
		carsGuideHomePageActions.verifyShortListButtonIsPresent();
	}

	@Then("validate we have Signup option")
	public void validate_we_have_signup_option() {
		carsGuideHomePageActions.verifySignUpButtonIsPresent();
	}

}
