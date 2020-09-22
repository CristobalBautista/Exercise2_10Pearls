package com.linkedin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage {
	WebDriver driver;

	@FindBy(xpath = "//header[@id='global-nav']")
	WebElement mainNavigationBar;

	public LinkedinHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean homePageIsDisplayedOnScreen() {
		return mainNavigationBar.isDisplayed();
	}

}
