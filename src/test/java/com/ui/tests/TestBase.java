package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestBase {
	private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void driverSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://phoenix.techwithjatin.com/sign-in");
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
