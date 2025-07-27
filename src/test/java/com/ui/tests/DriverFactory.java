package com.ui.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> thrdlclDriver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return thrdlclDriver.get();
    }

    public static void setDriver(String browser, boolean headless) throws Exception {
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
