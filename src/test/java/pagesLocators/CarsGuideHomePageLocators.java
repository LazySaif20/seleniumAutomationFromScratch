package pagesLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarsGuideHomePageLocators {
	
	@FindBy(how = How.XPATH, using="(//a[@title='carsguide'])[1]")
	public WebElement carsGuideHomePageLogo;
	
	@FindBy(how = How.XPATH, using ="//*[@id='cgsearch']")
	public WebElement searchFeild;
	
	@FindBy(how = How.XPATH, using ="//button[@class='uhf-button-purple-border']")
	public WebElement sellMyCarButton;
	
	@FindBy(how = How.XPATH, using ="//a[@role='button']//span[contains(text(),'My Shortlist')]")
	public WebElement myShortlistButton;
	
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Sign up')]")
	public WebElement signUpButton;
	
	@FindBy(how = How.XPATH, using ="(//a[contains(text(),'reviews')])[1]")
	public WebElement menu_reviews;
	
	@FindBy(how = How.XPATH, using ="(//a[contains(text(),'news')])[1]")
	public WebElement menu_news;
	
	@FindBy(how = How.XPATH, using ="(//a[contains(text(),'advice')])[1]")
	public WebElement menu_advice;

	@FindBy(how = How.XPATH, using ="//*[@id=\"content\"]/table[2]")
	public WebElement table;

	
}
