package com.facebook.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookCreateAccountPage {
	WebDriver driver;

	@FindBy(css = "#day")
	WebElement birthdayDay;

	@FindBy(css = "#month")
	WebElement birthdayMonth;

	@FindBy(css = "#year")
	WebElement birthdayYear;

	@FindBy(css = "#u_0_2")
	WebElement createAccountButton;

	@FindBy(xpath = "//div[@class='_8fgl']")
	WebElement createAccountForm;

	public FacebookCreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createAccount() {
		createAccountButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(visibilityOf(createAccountForm));
	}

	public void selectDropdownValues() {
		selectDayByIndex();
		selectMonthByValue();
		selectYearByVisibleText();
	}

	public void selectDayByIndex() {
		Select birthdayMonths = new Select(birthdayDay);
		birthdayMonths.selectByIndex(15);
	}

	public void selectMonthByValue() {
		Select birthdayMonths = new Select(birthdayMonth);
		birthdayMonths.selectByValue("5");
	}

	public void selectYearByVisibleText() {
		Select birthdayMonths = new Select(birthdayYear);
		birthdayMonths.selectByVisibleText("2015");
	}
}
