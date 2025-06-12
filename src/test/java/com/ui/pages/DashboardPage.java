package com.ui.pages;

import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;

public final class DashboardPage extends BrowserUtils {
	
	

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public String getDashboardPageUrl() {
		return getCurrentPageUrl("dashboard");
	}

}
