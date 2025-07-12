package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.ConfigConst;

@Listeners(com.ui.listeners.UiListeners.class)
public final class RepairJobPageTest extends TestBase {

    @Test(dependsOnMethods = "com.ui.tests.AssignJobPageTest.validateAssignJobFromUi", groups = {"smoke", "regression"}, description = "Validates the job repair functionality through the UI after a job has been assigned.")
    public void validateJobRepairFromUi() {
        Assert.assertTrue(loginPage.doLogin(environment, ConfigConst.ENG_USER).goToRepairJobPage().repairJob(CreateJobPageTest.jobId).contains("successfully"), "Job of id :" + CreateJobPageTest.jobId + " is not present in list");

    }

}
