package com.ui.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.constants.ConfigConst;
import com.constants.Env;
import com.ui.pages.LoginPage;
import com.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestBase {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected Env environment;
    private MutableCapabilities caps;

    @Parameters({"browser", "env", "os", "os_version", "browser_version"})
    @BeforeMethod(alwaysRun = true)
    public void driverSetup(@Optional("firefox") String browser, @Optional("qa") String env, @Optional("Windows") String os, @Optional("10") String osVersion, @Optional("120.0") String browserVersion, Method method, ITestContext context) {
        environment = Env.valueOf(env.toUpperCase());
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "false"));
        try {
            if (isRemote) {
                MutableCapabilities caps = new MutableCapabilities();
                caps.setCapability("browserName", browser);
                caps.setCapability("browserVersion", browserVersion);

                Map<String, Object> bstackOptions = new HashMap<>();
                bstackOptions.put("os", os);
                bstackOptions.put("osVersion", osVersion);
                bstackOptions.put("browserVersion", browserVersion);
                bstackOptions.put("userName", TestUtils.getValueFromPropertiesFile(environment, ConfigConst.BS_USERNAME));
                bstackOptions.put("accessKey", TestUtils.getValueFromPropertiesFile(environment, ConfigConst.BS_ACCESS_KEY));
                bstackOptions.put("sessionName", method.getName());
                caps.setCapability("bstack:options", bstackOptions);
                RemoteWebDriver RemoteDriver = new RemoteWebDriver(new URI("https://hub.browserstack.com/wd/hub").toURL(), caps);
                DriverFactory.setRemoteWebDriver(RemoteDriver);
            } else DriverFactory.setDriver(browser, headless);

        } catch (

                Exception e) {
            e.printStackTrace();
        }
        driver = DriverFactory.getDriver();
        context.setAttribute("webDriver", driver);
        driver.manage().window().maximize();
        driver.get(TestUtils.getValueFromPropertiesFile(environment, ConfigConst.BASE_URL));
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (DriverFactory.getDriver() != null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            DriverFactory.quitDriver();
        }
    }
}
