package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;

public final class LoginPage extends BrowserUtils {

	private static final By USERNAME_FIELD_LOCATOR = By.id("username");
	private static final By PASSWORD_FIELD_LOCATOR = By.id("password");
	private static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Sign in')]/ancestor::button");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void doLogin() {
		enterText(USERNAME_FIELD_LOCATOR, "iamfd");
		enterText(PASSWORD_FIELD_LOCATOR, "password");
		clickOn(SIGN_IN_BUTTON_LOCATOR);
	}

}
