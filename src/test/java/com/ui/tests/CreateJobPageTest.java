package com.ui.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.UiListeners.class)
public final class CreateJobPageTest extends TestBase {

	@Test(description = "Validate create job from ui", groups = { "smoke", "regression" })
	public void validateCreateJobByUi() {
		loginPage.doLogin(environment).goToCreateJobPage().enterJobDetails();
		;
	}

}
