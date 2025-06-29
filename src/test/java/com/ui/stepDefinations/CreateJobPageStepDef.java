package com.ui.stepDefinations;

import org.testng.Assert;

import com.constants.ConfigConst;
import com.ui.pages.CreateJobPage;
import com.ui.pages.DashboardPage;
import com.utils.TestUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public final class CreateJobPageStepDef extends StepDefTestBase {

	private DashboardPage dashboardPage;
	private CreateJobPage createJob;
	String jobId;

	@Given("user login to the app and redirects to the dashboard page")
	public void user_login_to_the_app_and_redirects_to_the_dashboard_page() {
		driver.get(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BASE_URL));
		dashboardPage = getLoginPage().doLogin(env, ConfigConst.FD_USER);
	}

	@Given("user is on create job page")
	public void user_is_on_create_job_page() {
		createJob = dashboardPage.goToCreateJobPage();
	}

	@When("user enters job details and submit it")
	public void user_enters_job_details_and_submit_it() {
		jobId = createJob.enterJobDetailsAndCreateJob("apple", "iphone", "iphone 11", "3/23/2025", "In Warrenty");
	}

	@Then("job should be create and id is generated")
	public void job_should_be_creat_and_id_is_generated() {
		Assert.assertTrue(jobId.contains("JOB_"), "Error: Job is not created.");
	}

}
