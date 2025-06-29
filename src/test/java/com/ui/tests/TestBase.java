package com.ui.tests;

import org.testng.annotations.AfterMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

	@Parameters({ "browser", "env" })
	@BeforeMethod(alwaysRun = true)
	public void driverSetup(@Optional("chrome") String browser, @Optional("qa") String env) {
		environment = Env.valueOf(env.toUpperCase());
		boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			if (headless) {
				opt.addArguments("--headless");
			}
			opt.addArguments("user-data-dir=/tmp/selenium-profile");
			driver = new ChromeDriver(opt);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			if (headless) {
				options.addArguments("--headless");
			}
			driver = new FirefoxDriver(options);
		} else {
			System.out.println(browser + " is not compatible");
		}

		driver.manage().window().maximize();
		driver.get(TestUtils.getValueFromPropertiesFile(environment, ConfigConst.BASE_URL));
		loginPage = new LoginPage(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			driver.quit();
		}
	}

}
