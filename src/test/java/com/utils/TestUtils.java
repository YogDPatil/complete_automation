package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {

	public static String getValueFromPropertiesFile(String keyValue) {
		FileInputStream fis;
		Properties properties;
		try {
			fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "/src/test/resources/config/qa_config.properties"));
			properties = new Properties();
			properties.load(fis);
			return properties.getProperty(keyValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
