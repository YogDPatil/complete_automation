package com.mobile.pages;

import com.utils.BrowserUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public final class MobileHomePage extends BrowserUtils {

    private AppiumDriver driver;

    private static final By VIEW_TAB_LOCATOR = AppiumBy.accessibilityId("Views");
    private static final By PREFERENCE_TAB_LOCATOR = AppiumBy.accessibilityId("Preference");

    public MobileHomePage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public PreferenceListPage goToPreferenceList() {
        clickOn(PREFERENCE_TAB_LOCATOR);
        return new PreferenceListPage(driver);
    }

}
