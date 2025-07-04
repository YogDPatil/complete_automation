package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.constants.ConfigConst;
import com.constants.Env;
import com.utils.BrowserUtils;
import static com.utils.TestUtils.*;

public final class LoginPage extends BrowserUtils {

	private WebDriver driver;

	private static final By USERNAME_FIELD_LOCATOR = By.id("username");
	private static final By PASSWORD_FIELD_LOCATOR = By.id("password");
	private static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Sign in')]/ancestor::button");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public DashboardPage doLogin(Env env, ConfigConst user) {
		enterText(USERNAME_FIELD_LOCATOR, getValueFromPropertiesFile(env, user));
		enterText(PASSWORD_FIELD_LOCATOR, getValueFromPropertiesFile(env, ConfigConst.PASSWORD));
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		return new DashboardPage(driver);
	}

}
