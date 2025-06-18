package com.ui.tests;

import org.testng.annotations.Test;

public final class CreateJobPageTest extends TestBase {

	@Test
	public void validateCreateJobByUi() {
		loginPage.doLogin(environment).goToCreateJobPage().enterJobDetails();;
	}

}
