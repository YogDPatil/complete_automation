package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.ConfigConst;

@Listeners(com.ui.listeners.UiListeners.class)
public final class CreateJobPageTest extends TestBase {
	static String jobId;

	@Test(description = "Validate create job from ui", groups = { "smoke", "regression" })
	public void validateCreateJobByUi() throws Exception {
		jobId = loginPage.doLogin(environment, ConfigConst.FD_USER).goToCreateJobPage()
				.enterJobDetailsAndCreateJob("apple", "iphone", "iphone 11", "3/23/2025", "In Warrenty");
		Assert.assertTrue(jobId.contains("JOB_"), "Job creation failed: No valid job ID returned");
	}

}

