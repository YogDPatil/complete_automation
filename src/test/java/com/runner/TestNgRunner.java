package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNgRunner {

	private static String browser, env, componant, testType;

	public static void main(String[] args) {

		if (verifyBrowser(args[0]) && verifyEnvironment(args[1]) && verifyComponant(args[2])
				&& verifyTestType(args[3])) {
			browser = args[0];
			env = args[1];
			componant = args[2];
			testType = args[3];

			TestNG testNg = new TestNG();

			XmlSuite xmlSuit = new XmlSuite();
			xmlSuit.setName("My " + env + " phoenix app " + componant + " suit");

			XmlTest xmlTest = new XmlTest(xmlSuit);
			xmlTest.setName(componant + " " + testType + " automation Test");
			xmlTest.addParameter("browser", browser);
			xmlTest.addParameter("env", env);
			xmlTest.addIncludedGroup(testType);

			XmlPackage xmlPackage = new XmlPackage("com." + componant + ".tests");
			List<XmlPackage> packageList = new ArrayList<>();

			packageList.add(xmlPackage);
			xmlTest.setPackages(packageList);

			List<XmlTest> testList = new ArrayList<>();
			testList.add(xmlTest);
			xmlSuit.setTests(testList);

			List<XmlSuite> suiteList = new ArrayList<>();
			suiteList.add(xmlSuit);

			testNg.setXmlSuites(suiteList);
			testNg.setVerbose(3); 
			testNg.run();
		} else
			System.out.println("Configuration is not correct");

	}

	public static boolean verifyBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("firefox")
				|| browser.equalsIgnoreCase("edge")) {
			return true;
		} else
			return false;
	}

	public static boolean verifyEnvironment(String env) {
		if (env.equalsIgnoreCase("qa") || env.equalsIgnoreCase("dev") || env.equalsIgnoreCase("uat")) {
			return true;
		} else
			return false;
	}

	public static boolean verifyComponant(String component) {
		if (component.equalsIgnoreCase("ui") || component.equalsIgnoreCase("mobile")
				|| component.equalsIgnoreCase("api")) {
			return true;
		} else
			return false;
	}

	public static boolean verifyTestType(String type) {
		if (type.equalsIgnoreCase("sanity") || type.equalsIgnoreCase("smoke") || type.equalsIgnoreCase("regression")) {
			return true;
		} else
			return false;
	}

}
