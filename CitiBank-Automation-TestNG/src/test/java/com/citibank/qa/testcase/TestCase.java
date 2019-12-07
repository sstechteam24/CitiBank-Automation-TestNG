package com.citibank.qa.testcase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.citibank.qa.base.TestBase;
import com.citibank.qa.homepage.Home;
import com.citibank.qa.homepage.HomePage;

public class TestCase extends TestBase {

	HomePage homePage;
	Home home;

	public TestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		home= new Home();
	}
	
	@Test(priority = 0)
	public void searchingText() {
		home.searchOption();
	

	}

	@Test(priority = 1)
	public void titleValidation() {
		String actual = home.validationTitle();
		Assert.assertEquals(actual, "Online Banking, Mortgages, Personal Loans, Investing | Citi.com");
	}

	@Test(priority = 2)
	public void validationSearchText() {
		boolean searchText = home.searchDisplayed();
		Assert.assertTrue(searchText);

	}
	@Test(priority = 3)
	public void citiLogoValidation() {
		boolean citiLogo = home.citiLogoDisplayed();
		Assert.assertTrue(citiLogo, "Citi logo validated ");

	}

	@Test(priority = 4)
	public void rememberUidLabel() {
		boolean textValidatioin = home.rememberMeTextValidation();
		Assert.assertTrue(textValidatioin, "Test fail ");
	}

	@Test(priority = 5)
	public void signInBtnDisplayed() {
		boolean signBtn = home.signBtn();
		Assert.assertTrue(signBtn, "Sign Button displayed");

	}

	@Test(priority = 6)
	public void creditCardMessageValidated() {
		boolean creditMessage = homePage.creditMessageDisplayed();
		Assert.assertTrue(creditMessage, "Message showing");
	}

	@Test(priority = 7)
	public void creditCardLink() {
		home.creditOptionLink();
	}

	@Test(priority = 8)
	public void atmBranch() {
		boolean atmText = home.atmBranchText();
		Assert.assertTrue(atmText, "Enable");
	}

	@Test(priority = 9)
	public void lendingLink() {
		homePage.lendingClick();
	}

	@Test(priority = 10)
	public void personalLoan() {
		homePage.personalLoan();
	}

	@Test(priority = 11)
	public void mortgageLink() {
		homePage.mortgageLink();
	}

	@Test(priority = 12)
	public void homeEquity() {
		homePage.homeEquity();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
