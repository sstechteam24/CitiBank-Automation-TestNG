package com.citibank.qa.homepage;

import org.openqa.selenium.support.PageFactory;

import com.citibank.qa.base.TestBase;

public class PageBase extends TestBase {
	
	
	
	public PageBase() {
		PageFactory.initElements(driver, this);
		
		
	}

}
