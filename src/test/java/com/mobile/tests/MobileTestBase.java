package com.mobile.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeMethod;

import java.net.URI;

public abstract class MobileTestBase {
    protected AppiumDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpAppiumDriver() {

        try {
            UiAutomator2Options opt = new UiAutomator2Options();
            opt.setAutomationName("UiAutomator2");
            opt.setPlatformName("Android");
            opt.setDeviceName("Pixel 9");
            opt.setApp("/Users/codeclouds-yogesh/Desktop/General-Store.apk");
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), opt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
