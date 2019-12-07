package com.citibank.qa.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {


	@FindBy(id = "citi-autocomplete-content-searchbox-livesearch")
	WebElement searchText;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchResult;

	@FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/div[2]/h2[1]")
	WebElement creditMessageAlert;

	@FindBy(id = "lendingLi")
	WebElement lending;
	@FindBy(id="personalLoanCredLine_Link")
	WebElement personalLoan;
	@FindBy(id = "mortgageId_Link")
	WebElement mortgaged;
	@FindBy(id="homeEquity_Link")
	WebElement homeEquity;



	public boolean creditMessageDisplayed() {
		return creditMessageAlert.isDisplayed();
	}

	public void lendingClick() {
		lending.click();
	}
	
	public PersonalLoan personalLoan() {
		Actions action = new Actions(driver);
		action.moveToElement(lending).build().perform();
		personalLoan.click();
		return new PersonalLoan();
	}

	public Mortgagehome1 mortgageLink() {
		Actions act = new Actions(driver);
		act.moveToElement(lending).build().perform();

		mortgaged.click();
		return new Mortgagehome1();
	}
	public HomeEquity homeEquity() {
		Actions action = new Actions(driver);
		action.moveToElement(lending).build().perform();
		homeEquity.click();
	return	new HomeEquity();
	}
}
