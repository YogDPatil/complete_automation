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

		browser = args[0];
		env = args[1];
		componant = args[2];
		testType = args[3];

		TestNG testNg = new TestNG();

		XmlSuite xmlSuit = new XmlSuite();
		xmlSuit.setName("My " + env + " phoenix app " + componant + "suit");

		XmlTest xmlTest = new XmlTest(xmlSuit);
		xmlTest.setName(componant + " " + testType + " automation Test");
		xmlTest.addParameter("browser", "firefox");
		xmlTest.addParameter("env", "qa");

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
		testNg.setUseDefaultListeners(true);
		testNg.run();

	}

}
