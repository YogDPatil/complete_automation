package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.constants.Browser;
import com.constants.Componant;
import com.constants.Env;
import com.constants.TestType;

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
		if (browser.equalsIgnoreCase(String.valueOf(Browser.CHROME).toLowerCase())
				|| browser.equalsIgnoreCase(String.valueOf(Browser.FIREFOX).toLowerCase())
				|| browser.equalsIgnoreCase("edge")) {
			return true;
		} else
			return false;
	}

	public static boolean verifyEnvironment(String env) {
		if (env.equalsIgnoreCase(String.valueOf(Env.QA).toLowerCase())
				|| env.equalsIgnoreCase(String.valueOf(Env.DEV).toLowerCase())
				|| env.equalsIgnoreCase(String.valueOf(Env.UAT).toLowerCase())) {
			return true;
		} else
			return false;
	}

	public static boolean verifyComponant(String component) {
		if (component.equalsIgnoreCase(String.valueOf(Componant.UI).toLowerCase())
				|| component.equalsIgnoreCase(String.valueOf(Componant.MOBILE).toLowerCase())
				|| component.equalsIgnoreCase(String.valueOf(Componant.API).toLowerCase())) {
			return true;
		} else
			return false;
	}

	public static boolean verifyTestType(String type) {
		if (type.equalsIgnoreCase(String.valueOf(TestType.SANITY).toLowerCase())
				|| type.equalsIgnoreCase(String.valueOf(TestType.SMOKE).toLowerCase())
				|| type.equalsIgnoreCase(String.valueOf(TestType.REGRESSION).toLowerCase())) {
			return true;
		} else
			return false;
	}

}
