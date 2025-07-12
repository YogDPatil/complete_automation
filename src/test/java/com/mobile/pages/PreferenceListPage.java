package com.mobile.pages;

import com.utils.BrowserUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public final class PreferenceListPage extends BrowserUtils {

    private AppiumDriver driver;

    private static final By PREFERENCE_LIST_LOCATOR = AppiumBy.xpath("//android.widget.ListView/android.widget.TextView");
    private static final By WIFI_CHECKBOX_LOCATOR = AppiumBy.id("android:id/checkbox");
    private static final By WIFI_SETTING_LOCATOR = AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']");
    private static final By WIFI_SETTING_POPUP_FIELD_LOCATOR = AppiumBy.id("android:id/edit");
    private static final By POPUP_BUTTONS_LIST_LOCATOR = AppiumBy.className("android.widget.Button");

    public PreferenceListPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void handlePopup() {
        driver.findElements(PREFERENCE_LIST_LOCATOR).stream().filter(element -> element.getText().contains("Preference dependencies")).findFirst().ifPresent(ele -> ele.click());
        clickOn(WIFI_CHECKBOX_LOCATOR);
        clickOn(WIFI_SETTING_LOCATOR);
        enterText(WIFI_SETTING_POPUP_FIELD_LOCATOR, "Yogesh_wifi");
        driver.findElements(POPUP_BUTTONS_LIST_LOCATOR).stream().filter(element -> element.getText().contains("OK")).findFirst().ifPresent(ele -> ele.click());

    }
}
