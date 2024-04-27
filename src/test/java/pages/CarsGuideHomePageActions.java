package pages;

import org.openqa.selenium.support.PageFactory;

import hooks.SeleniumDriver;
import pagesLocators.CarsGuideHomePageLocators;

public class CarsGuideHomePageActions {
	
	CarsGuideHomePageLocators carsGuideHomePageLocators = null;
	
	public CarsGuideHomePageActions() {
		this.carsGuideHomePageLocators = new CarsGuideHomePageLocators();
		PageFactory.initElements(SeleniumDriver.getWebDriver(), carsGuideHomePageLocators);
	}
	
	public void verifyTheLogoIsPresent() {
		carsGuideHomePageLocators.carsGuideHomePageLogo.isDisplayed();
	}
	
	public void verifySeachFieldIsPresent() {
		carsGuideHomePageLocators.searchFeild.isDisplayed();
	}
	
	public void verifySellMyCarButton() {
		carsGuideHomePageLocators.sellMyCarButton.isDisplayed();
	}
	
	public void verifyShortListButtonIsPresent() {
		carsGuideHomePageLocators.myShortlistButton.isDisplayed();
	}
	
	public void verifySignUpButtonIsPresent() {
		carsGuideHomePageLocators.signUpButton.isDisplayed();
	}

}
