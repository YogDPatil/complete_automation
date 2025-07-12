package com.mobile.pages;

import com.utils.BrowserUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;

public final class PreferenceList extends BrowserUtils {

    private AppiumDriver driver;

    private static final By PREFERENCE_LIST_LOCATOR = AppiumBy.xpath("//android.widget.ListView/android.widget.TextView");

    public PreferenceList(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void handlePopup() {
        driver.findElements(PREFERENCE_LIST_LOCATOR).stream().filter(element -> element.getText().contains("Preference dependencies")).findFirst().ifPresent(ele -> ele.click());
    }
}
