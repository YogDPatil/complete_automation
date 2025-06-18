package com.ui.tests;

import org.testng.annotations.Test;

public final class CreateJobPageTest extends TestBase {

	@Test(description = "Validate create job from ui", groups = { "smoke", "regression" })
	public void validateCreateJobByUi() {
		loginPage.doLogin(environment).goToCreateJobPage().enterJobDetails();
		;
	}

}
