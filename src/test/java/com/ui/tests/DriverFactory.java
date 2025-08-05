package com.ui.tests;

import com.constants.ConfigConst;
import com.constants.Env;
import com.utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> thrdlclDriver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return thrdlclDriver.get();
    }

    public static void setDriver(String browser, boolean headless, boolean isRemote, String browserVersion, Env env, Method method) throws Exception {
        if (isRemote) {
            MutableCapabilities caps = new MutableCapabilities();
            Map<String, Object> bstackOptions = new HashMap<>();
            caps.setCapability("browserName", browser);
            caps.setCapability("browserVersion", browserVersion);
            bstackOptions.put("os", "Windows");
            bstackOptions.put("osVersion", "10");
            bstackOptions.put("userName", TestUtils.getValueFromPropertiesFile(env, ConfigConst.BS_USERNAME));
            bstackOptions.put("accessKey", TestUtils.getValueFromPropertiesFile(env, ConfigConst.BS_ACCESS_KEY));
            bstackOptions.put("sessionName", method.getName());
            caps.setCapability("bstack:options", bstackOptions);
            thrdlclDriver.set(new RemoteWebDriver(new URI(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BS_URL)).toURL(), caps));

        } else {
            if (getDriver() == null) {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions cOpt = new ChromeOptions();
                        if (headless) {
                            cOpt.addArguments("--headless");
                        }
                        thrdlclDriver.set(new ChromeDriver(cOpt));
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions ffOpt = new FirefoxOptions();
                        if (headless) {
                            ffOpt.addArguments("--headless");
                        }
                        thrdlclDriver.set(new FirefoxDriver(ffOpt));
                        break;
                    case "safari":
                        WebDriverManager.safaridriver().setup();
                        thrdlclDriver.set(new SafariDriver());
                        break;
                    default:
                        throw new Exception("Error: " + browser + " is not compatible");
                }
            }
        }
    }

    public static void setRemoteWebDriver(RemoteWebDriver remoteWebDriver) {
        thrdlclDriver.set(remoteWebDriver);
    }

    public static void quitDriver() {
        if (thrdlclDriver != null) {
            getDriver().quit();
            thrdlclDriver.remove();  // important to avoid memory leaks
        }
    }
}
