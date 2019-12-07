package com.citibank.qa.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends PageBase {
	
	@FindBy(id = "personetics-citi-menu")
	WebElement search;
	@FindBy(id = "citi-autocomplete-content-searchbox-livesearch")
	WebElement searchText;
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchResult;
	@FindBy(xpath = "//div[contains(@class,'brandingLogo')]")
	WebElement citiLogoDisplayed;
	@FindBy(id = "rememberUidLabel")
	WebElement rememberUidLabel;
	@FindBy(id = "signInBtn")
	WebElement signInBtn;
	@FindBy(xpath = "//a[contains(@class,'btn btn-primary small')]")
	WebElement learnMore;
	@FindBy(xpath = "//a[contains(text(),'ATM / Branch')]")
	WebElement atmLocation;
	
	
	
	public boolean searchDisplayed() {
		return search.isDisplayed();
	}
	public String validationTitle() {
		return driver.getTitle();
	}
	public Home searchOption() {
		search.click();
		searchText.sendKeys("loan");
		searchResult.click();
		return new Home();
	}
	
	public boolean citiLogoDisplayed() {
		return citiLogoDisplayed.isDisplayed();

	}

	public boolean rememberMeTextValidation() {
		return rememberUidLabel.isDisplayed();
	}
	public boolean signBtn() {
		return signInBtn.isDisplayed();
	}
	public CreditCardHomePage creditOptionLink() {

		learnMore.click();

		return new CreditCardHomePage();

	}
	public boolean atmBranchText() {
		return atmLocation.isEnabled();
	}

}
