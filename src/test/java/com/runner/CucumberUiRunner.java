package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.java.it.Data;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/uiFreatureFiles", glue = "com.ui.stepDefinations", monochrome = true, 
tags = "@login", dryRun = false)
public class CucumberUiRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
