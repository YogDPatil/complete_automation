package com.mobile.tests;

import com.constants.Env;
import com.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
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
    protected Env env;

    @BeforeMethod(alwaysRun = true)
    public void setUpAppiumDriver(Method method) {
        try {
            env = Env.valueOf(Boolean.parseBoolean(System.getProperty("env")) ? System.getProperty("env") : Env.QA.toString());
            boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "false"));
            if (isRemote) {
                MutableCapabilities caps = new MutableCapabilities();
                HashMap<String, Object> bstackOptions = new HashMap<>();
                bstackOptions.put("userName", "yogeshpatil_oxzFPK");
                bstackOptions.put("accessKey", "giDBVufsxM9GFnwcjp37");
//                bstackOptions.put("buildName", method.getName());
                caps.setCapability("platformName", "ios");
                caps.setCapability("appium:platformVersion", "16");
                caps.setCapability("appium:deviceName", "iPhone 14 Pro Max");
                caps.setCapability("appium:app", "bs://2fbaf7076692519d794f54bf60dc492a407f09b3");//API demos app
                caps.setCapability("bstack:options", bstackOptions);
                driver = new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);

            } else {
                UiAutomator2Options opt = new UiAutomator2Options();
                opt.setAutomationName("UiAutomator2");
                opt.setPlatformName("android");
                opt.setDeviceName("Pixel 9");
                opt.setApp(System.getProperty("user.dir")+"/src/test/resources/testingApps/apiDemos.apk");
                driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), opt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
