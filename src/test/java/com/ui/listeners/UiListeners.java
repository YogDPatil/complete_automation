package com.ui.listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.BrowserUtils;

public class UiListeners implements ITestListener {
	private ExtentReports extentReports;
	private ExtentSparkReporter extentSparkReporter;
	private ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.addScreenCaptureFromPath(BrowserUtils.takeScreenshot(result.getMethod().getMethodName()));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		extentReports = new ExtentReports();
		String formatedDate = (new SimpleDateFormat("yyyy-MMM-dd hh:mm")).format(new Date());
		File repoFile = new File(System.getProperty("user.dir") + "/reports");
		try {
			if (repoFile.exists()) {

				FileUtils.forceDelete(repoFile);
				FileUtils.forceMkdir(repoFile);
			} else {
				FileUtils.forceMkdir(repoFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentSparkReporter = new ExtentSparkReporter(repoFile + "/report-" + formatedDate);
		extentReports.attachReporter(extentSparkReporter);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		extentReports.flush();

	}

}
