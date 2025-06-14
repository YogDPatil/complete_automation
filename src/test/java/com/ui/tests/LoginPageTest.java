package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.UiListeners.class)
public final class LoginPageTest extends TestBase {

	@Test
	public void validateLoginByUi() {
		Assert.assertEquals(loginPage.doLogin(environment).getDashboardPageUrl(),
				"http://phoenix.techwithjatin.com/frontdesk/dashboard1", "User is not redirected to dashboard page.");
	}

}
