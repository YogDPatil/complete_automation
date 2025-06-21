package com.ui.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.ConfigConst;

@Listeners(com.ui.listeners.UiListeners.class)
public final class AssignJobPageTest extends TestBase {

	@Test(dependsOnMethods = "com.ui.tests.CreateJobPageTest.validateCreateJobByUi")
	public void validateAssignJobFromUi() {
		loginPage.doLogin(environment, ConfigConst.SUP_USER).goToAssignJobPage();
		System.out.println("Created Job **** " + CreateJobPageTest.jobId);
	}
}
