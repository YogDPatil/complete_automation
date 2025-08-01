package com.ui.tests;

import org.testng.annotations.Test;

import com.constants.ConfigConst;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.UiListeners.class)
public final class LoginPageTest extends TestBase {

    @Test(description = "To validate login from ui", groups = {"smoke", "sanity", "regression"})
    public void validateLoginByUi() {
        Assert.assertEquals(loginPage.doLogin(environment, ConfigConst.FD_USER).getDashboardPageUrl(), "http://phoenix.techwithjatin.com/frontdesk/dashboard", "User is not redirected to dashboard page.");
    }

}
