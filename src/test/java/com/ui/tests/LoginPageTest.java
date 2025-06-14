package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public final class LoginPageTest extends TestBase {

	@Test
	public void validateLoginByUi() {
		Assert.assertEquals(loginPage.doLogin(environment).getDashboardPageUrl(),
				"http://phoenix.techwithjatin.com/frontdesk/dashboard", "User is not redirected to dashboard page.");
		// connected to jenkins.
	}

}
