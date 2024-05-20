package pages;

import org.openqa.selenium.support.PageFactory;

import hooks.SeleniumDriver;
import pagesLocators.CarsGuideHomePageLocators;
import utilities.CommonActions;

public class CarsGuideHomePageActions {
	CarsGuideHomePageLocators carsGuideHomePageLocators = null;
	CommonActions commonActions;
	
	public CarsGuideHomePageActions() {
		this.carsGuideHomePageLocators = new CarsGuideHomePageLocators();
		this.commonActions = new CommonActions();
		PageFactory.initElements(SeleniumDriver.getWebDriver(), carsGuideHomePageLocators);
	}
	
	public void verifyTheLogoIsPresent() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.carsGuideHomePageLogo);
	}
	
	public void verifySeachFieldIsPresent() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.searchFeild);
	}
	
	public void verifySellMyCarButton() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.sellMyCarButton);
	}
	
	public void verifyShortListButtonIsPresent() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.myShortlistButton);
	}
	
	public void verifySignUpButtonIsPresent() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.signUpButton);
	}
}
