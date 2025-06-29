package com.ui.stepDefinations;

import com.constants.ConfigConst;
import com.ui.pages.DashboardPage;
import com.utils.TestUtils;

import io.cucumber.java.en.Given;

public final class AssignJob extends StepDefTestBase {

	private DashboardPage dashboardPage;
	private String jobId;

	@Given("fd logged in and create the job")
	public void fd_logged_in_and_create_job() {
		driver.get(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BASE_URL));
		jobId = getLoginPage().doLogin(env, ConfigConst.FD_USER).goToCreateJobPage()
				.enterJobDetailsAndCreateJob("apple", "iphone", "iphone 11", "3/23/2025", "In Warrenty");
	}

	@Given("sup login to the app and redirects to the dashboard page")
	public void sup_login_to_the_app_and_redirects_to_the_dashboard_page() {
		driver.get(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BASE_URL));
		dashboardPage = getLoginPage().doLogin(env, ConfigConst.SUP_USER);
	}

}
