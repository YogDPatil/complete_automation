package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.ConfigConst;

@Listeners(com.ui.listeners.UiListeners.class)
public final class AssignJobPageTest extends TestBase {

	@Test(dependsOnMethods = "com.ui.tests.CreateJobPageTest.validateCreateJobByUi", description = "Validate assign job to eng from ui.", groups = {
			"smoke", "regression" })
	public void validateAssignJobFromUi() {
		Assert.assertEquals(loginPage.doLogin(environment, ConfigConst.SUP_USER).goToAssignJobPage()
				.assignJob(CreateJobPageTest.jobId), "Job assigned successfully");
		System.out.println("Created Job **** " + CreateJobPageTest.jobId);
	}
}
