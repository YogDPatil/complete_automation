package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.constants.Env;
import com.github.javafaker.Faker;

public class TestUtils {

	public TestUtils(WebDriver driver) {
//		this.driver = driver;
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

	public static Map<String, String> getFakeData() {
		Faker faker = new Faker();

		Map<String, String> createJobDetails = new HashMap<>();
		createJobDetails.put("fName", faker.name().firstName());
		createJobDetails.put("lName", faker.name().lastName());
		createJobDetails.put("number", faker.numerify("9#########"));
		createJobDetails.put("imei", faker.numerify("###############"));
		createJobDetails.put("email", faker.internet().emailAddress());
		createJobDetails.put("flatNumber", faker.address().buildingNumber());
		createJobDetails.put("apptName", "Abc");
		createJobDetails.put("landmark", "Xyz");
		createJobDetails.put("streetName", faker.address().streetName());
		createJobDetails.put("area", "Goga");
		createJobDetails.put("state", "Maharashtra");
		createJobDetails.put("pincode", faker.address().zipCode());
		return createJobDetails;

	}

}
