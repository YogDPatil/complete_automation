package com.ui.stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks {

	protected WebDriver driver;

	@Before()
	public void initialiseBrowser() {
		
		String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : "chrome";

		Boolean headless = Boolean.valueOf(System.getProperty("headless"));

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
			FirefoxOptions opt = new FirefoxOptions();
			if (headless) {
				opt.addArguments("--headless");
			}
			driver = new FirefoxDriver();
		}
	}

	@After
	public void tearDown() {
		if (driver != null) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit();
		}
	}
}
