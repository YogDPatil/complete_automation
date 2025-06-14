package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BrowserUtils {

	private WebDriver driver;
	private WebDriverWait wait;
	private static WebDriver staticWebDriver;

	public BrowserUtils(WebDriver driver) {
		this.driver = driver;
		staticWebDriver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void enterText(By locator, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
	}

	public void clickOn(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement findWebElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public String getCurrentPageUrl(String endpoint) {
		wait.until(ExpectedConditions.urlContains(endpoint));
		return driver.getCurrentUrl();
	}

	public static void takeScreenshot(String testName) {
		String formattedDate = (new SimpleDateFormat("yyyy-MMM-dd hh:mm")).format(new Date());
		File srcFile = ((TakesScreenshot) staticWebDriver).getScreenshotAs(OutputType.FILE);
		String dirPath = System.getProperty("user.dir") + "/screenshots/";
		File dir = new File(dirPath);
		File destFile = new File(dirPath + testName + "_" + formattedDate + ".png");

		try {
			if (!dir.exists()) {
				FileUtils.forceMkdir(dir);
			}else {
				FileUtils.forceDelete(dir);
				FileUtils.forceMkdir(dir);
			}
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
