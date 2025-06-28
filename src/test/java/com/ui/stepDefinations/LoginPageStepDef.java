package com.ui.stepDefinations;

import com.constants.ConfigConst;
import com.utils.TestUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public final class LoginPageStepDef extends StepDefTestBase {

	@Given("user is on login page")
	public void user_is_on_login_page() {
		getDriver().get(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BASE_URL));
	}

	@And("user enters login cred and sign in")
	public void user_enters_login_cred_and_sign_in() {

	}

	@Then("user is on dashboard page")
	public void user_is_on_dashboard_page() {

	}

}
