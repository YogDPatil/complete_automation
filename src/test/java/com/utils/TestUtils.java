package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.constants.Env;

public class TestUtils {

	static WebDriver driver;

	public TestUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static String getValueFromPropertiesFile(Env env, String keyValue) {
		FileInputStream fis;
		Properties properties;
		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/config/"
					+ String.valueOf(env).toLowerCase() + "_config.properties"));
			properties = new Properties();
			properties.load(fis);
			return properties.getProperty(keyValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void takeScreenshot() {
		String formattedDate = (new SimpleDateFormat("yyyy-MMM-dd hh:mm")).format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dirPath = System.getProperty("user.dir") + "/screenshots/";
		File file = new File(dirPath);
		File destFile;
		if (file.exists()) {
			destFile = new File(dirPath + formattedDate + ".png");
		}else {
			try {
				FileUtils.forceMkdir(file);
				destFile = new File(dirPath + formattedDate + ".png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
