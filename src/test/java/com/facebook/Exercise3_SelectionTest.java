package com.facebook;

import static com.facebook.util.Constants.DRIVER_PATH;
import static com.facebook.util.Constants.SELECT_BASE_URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.pages.FacebookCreateAccountPage;

public class Exercise3_SelectionTest {

	FacebookCreateAccountPage facebookCreate;
	public WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		facebookCreate = new FacebookCreateAccountPage(driver);
		driver.manage().window().maximize();
		driver.get(SELECT_BASE_URL);
	}

	@Test
	public void loginToLinkedIn() {
		facebookCreate.createAccount();
		facebookCreate.selectDropdownValues();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
