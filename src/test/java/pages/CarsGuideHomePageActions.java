package pages;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import hooks.SeleniumDriver;
import org.testng.Assert;
import pagesLocators.CarsGuideHomePageLocators;
import utilities.CommonActions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
