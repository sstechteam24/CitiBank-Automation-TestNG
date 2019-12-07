package com.citibank.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.citibank.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();	
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src"
					+ "\\main\\java\\com\\citibank\\qa\\config\\config.properties");
			prop.load(fi);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().version("77.0").setup();
			driver = new ChromeDriver();

		} else if (browser.equals("ff")) {
			System.setProperty("webdriver.gecho.driver", "user.shakel.gechodriver");
		}

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);// in class variable
																									// static then have
																									// to use class dot
																									// variabel name
		driver.manage().timeouts().implicitlyWait(TestUtil.implicity_wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	/*
	 * public void faillur() {
	 * 
	 * File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * try { FileUtils.copyFile(scrFile, new
	 * File("C:\\SSTechWorkSpace\\CitiBank-Automation-TestNG\\ScreenShot")); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

}
