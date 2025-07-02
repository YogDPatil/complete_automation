package com.ui.stepDefinations;

import org.testng.Assert;

import com.constants.ConfigConst;
import com.ui.pages.DashboardPage;
import com.utils.TestUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public final class LoginPageStepDef extends StepDefTestBase {
	private DashboardPage dashboardPage;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver.get(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BASE_URL));
	}

	@And("user enters login cred and sign in")
	public void user_enters_login_cred_and_sign_in() {
		dashboardPage = getLoginPage().doLogin(env, ConfigConst.FD_USER);
	}

	@Then("user is on dashboard page")
	public void user_is_on_dashboard_page() {
		Assert.assertEquals(dashboardPage.getDashboardPageUrl(),
				"http://phoenix.techwithjatin.com/frontdesk/dashboard", "User is not redirected to the dashboard page");
	}

}
