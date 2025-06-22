package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;

public final class DashboardPage extends BrowserUtils {

	private static final By CREATE_JOB_PAGE_LINK_LOCATOT = By
			.xpath("//span[contains(text(),'Create Job')]/ancestor::a");
	private static final By ASSIGN_JOB_PAGE_LINK_LOCATOR = By.xpath("//a[contains(@href, '/job-assignment')]");
	private static final By REPAIR_JOB_PAGE_LINK_LOCATOR = By.xpath("//a[contains(@href, '/repair-job')]");

	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getDashboardPageUrl() {
		return getCurrentPageUrl("dashboard");
	}

	public CreateJobPage goToCreateJobPage() {
		clickOn(CREATE_JOB_PAGE_LINK_LOCATOT);
		return new CreateJobPage(driver);
	}

	public AssignJobPage goToAssignJobPage() {
		clickOn(ASSIGN_JOB_PAGE_LINK_LOCATOR);
		return new AssignJobPage(driver);
	}

	public RepairJobPage goToRepairJobPage() {
		clickOn(REPAIR_JOB_PAGE_LINK_LOCATOR);
		return new RepairJobPage(driver);
	}

}
