package com.linkedin;

import static com.linkedin.util.Constants.BASE_URL;
import static com.linkedin.util.Constants.DRIVER_PATH;
import static com.linkedin.util.ReadExcel.getLoginData;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.linkedin.pages.HomePage;
import com.linkedin.pages.LoginPage;

public class LoginTest {

	LoginPage loginPage;
	HomePage homePage;
	public WebDriver driver;

	@DataProvider(name = "LoginData")
	public Object[][] getData() {
		return getLoginData();
	}

	@BeforeMethod
	public void setUpBrowser() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		driver.manage().window().maximize();
		driver.get(BASE_URL);

	}

	@Test(dataProvider = "LoginData")
	public void loginToLinkedIn(String email, String password) {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.loginToAccount(email, password);
		assertEquals(homePage.homePageIsDisplayedOnScreen(), true);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
