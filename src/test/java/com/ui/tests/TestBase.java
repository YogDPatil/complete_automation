package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.ui.pages.LoginPage;
import com.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestBase {
	private WebDriver driver;
	protected LoginPage loginPage;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void driverSetup(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println(browser + " is not compatible");
		}
		driver.manage().window().maximize();
		driver.get(TestUtils.getValueFromPropertiesFile("BASE_URL"));
		loginPage = new LoginPage(driver);
	}

	@AfterMethod
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
