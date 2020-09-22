package com.linkedin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage {
	WebDriver driver;

	@FindBy(css = "#session_key")
	WebElement emailInput;

	@FindBy(css = "#session_password")
	WebElement passwordInput;

	@FindBy(className = "sign-in-form__submit-button")
	WebElement loginButton;

	public LinkedinLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToAccount(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickOnLoginButton();
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

}
