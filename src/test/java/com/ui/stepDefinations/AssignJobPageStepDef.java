package com.ui.stepDefinations;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.constants.ConfigConst;
import com.ui.pages.AssignJobPage;
import com.ui.pages.DashboardPage;
import com.utils.TestUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Listeners(com.ui.listeners.UiListeners.class)
public final class AssignJobPageStepDef extends StepDefTestBase {

    private String jobId;
    private DashboardPage dashboardPage;
    private AssignJobPage assignJobPage;
    private String successMsg;

    @Given("fd logged in and create the job")
    public void fd_logged_in_and_create_the_job() {
        driver.get(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BASE_URL));
        jobId = getLoginPage().doLogin(env, ConfigConst.FD_USER).goToCreateJobPage().enterJobDetailsAndCreateJob(
                "apple",
                "iphone", "iphone 11", "3/23/2025", "In Warrenty");
    }

    @Given("sup login to the app and redirects to the dashboard page")
    public void sup_login_to_the_app_and_redirects_to_the_dashboard_page() {
        driver.get(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BASE_URL));
        dashboardPage = getLoginPage().doLogin(env, ConfigConst.SUP_USER);
    }

    @And("user clicks on job assignmant tab and redirects to that page")
    public void user_clicks_on_job_assignment_tab_and_redirects_to_page() {
        assignJobPage = dashboardPage.goToAssignJobPage();
    }

    @When("user select the eng and assign the job")
    public void user_selects_engineer_and_assigns_job() {
        successMsg = assignJobPage.assignJob(jobId);
    }

    @Then("job should assign with success message")
    public void job_should_be_assigned_with_success_message() {
        Assert.assertTrue(successMsg.equals("Job assigned successfully"));
    }
}