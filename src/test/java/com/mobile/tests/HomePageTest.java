package com.mobile.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public final class HomePageTest extends MobileTestBase {

    @Test
    public void testHomePage() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
    }
}
