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

        if (verifyBrowser(args[0]) && verifyEnvironment(args[1]) && verifyComponant(args[2]) && verifyTestType(args[3])) {
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
        } else System.out.println("Configuration is not correct");

    }

    public static boolean verifyBrowser(String browser) {
        return browser.equalsIgnoreCase(Browser.CHROME.toString()) || browser.equalsIgnoreCase(Browser.FIREFOX.toString()) || browser.equalsIgnoreCase("edge");
    }

    public static boolean verifyEnvironment(String env) {
        return env.equalsIgnoreCase(Env.QA.toString()) || env.equalsIgnoreCase(Env.DEV.toString()) || env.equalsIgnoreCase(Env.UAT.toString());
    }

    public static boolean verifyComponant(String component) {
        return component.equalsIgnoreCase(String.valueOf(Componant.UI).toLowerCase()) || component.equalsIgnoreCase(String.valueOf(Componant.MOBILE).toLowerCase()) || component.equalsIgnoreCase(String.valueOf(Componant.API).toLowerCase());
    }

    public static boolean verifyTestType(String type) {
        return type.equalsIgnoreCase(TestType.SANITY.toString()) || type.equalsIgnoreCase(TestType.SMOKE.toString()) || type.equalsIgnoreCase(TestType.REGRESSION.toString());
    }

}
