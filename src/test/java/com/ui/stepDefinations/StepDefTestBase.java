package com.ui.stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;
import com.constants.Env;
import com.ui.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class StepDefTestBase {

    protected static WebDriver driver;
    protected static Env env;

    public void initialiseDriver() {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : String.valueOf(Browser.CHROME).toLowerCase();
        boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "false"));
        env = Env.valueOf(System.getProperty("environment") != null ? System.getProperty("environment") : String.valueOf(Env.QA));
        Boolean headless = Boolean.valueOf(System.getProperty("headless"));

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opt = new ChromeOptions();
            if (headless) {
                opt.addArguments("--headless");
            }
            // opt.addArguments("user-data-dir=/tmp/selenium-profile");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions opt = new FirefoxOptions();
            if (headless) {
                opt.addArguments("--headless");
            }
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

}
