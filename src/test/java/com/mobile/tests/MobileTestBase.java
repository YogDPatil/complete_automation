package com.mobile.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

public abstract class MobileTestBase {
    protected AppiumDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpAppiumDriver(Method method) {
        try {
            System.out.println(method.getName());
            boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "true"));
            if (isRemote) {
                MutableCapabilities caps = new MutableCapabilities();
                HashMap<String, Object> bstackOptions = new HashMap<>();
                bstackOptions.put("userName", "yogeshpatil_oxzFPK");
                bstackOptions.put("accessKey", "giDBVufsxM9GFnwcjp37");
//                bstackOptions.put("buildName", method.getName());
                caps.setCapability("platformName", "android");
                caps.setCapability("appium:platformVersion", "12.0");
                caps.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
                caps.setCapability("appium:app", "bs://2fbaf7076692519d794f54bf60dc492a407f09b3");//API demos app
                caps.setCapability("bstack:options", bstackOptions);
                driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);

            } else {
                UiAutomator2Options opt = new UiAutomator2Options();
                opt.setAutomationName("UiAutomator2");
                opt.setPlatformName("android");
                opt.setDeviceName("Pixel 9");
                opt.setApp("/Users/codeclouds-yogesh/Desktop/General-Store.apk");
                driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), opt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
