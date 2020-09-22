package com.linkedin;

import static com.linkedin.util.Constants.LOGIN_BASE_URL;
import static com.linkedin.util.Constants.DRIVER_PATH;
import static com.linkedin.util.ReadExcel.getLoginData;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.linkedin.pages.LinkedinHomePage;
import com.linkedin.pages.LinkedinLoginPage;

public class Exercise2_LoginTest {

	LinkedinLoginPage loginPage;
	LinkedinHomePage homePage;
	public WebDriver driver;

	@DataProvider(name = "LoginData")
	public Object[][] getData() {
		return getLoginData();
	}

	@BeforeMethod
	public void setUpBrowser() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		loginPage = new LinkedinLoginPage(driver);
		homePage = new LinkedinHomePage(driver);
		driver.manage().window().maximize();
		driver.get(LOGIN_BASE_URL);

	}

	@Test(dataProvider = "LoginData")
	public void loginToLinkedIn(String email, String password) {
		loginPage = new LinkedinLoginPage(driver);
		homePage = new LinkedinHomePage(driver);
		loginPage.loginToAccount(email, password);
		assertEquals(homePage.homePageIsDisplayedOnScreen(), true);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
