package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;

public final class RepairJobPage extends BrowserUtils {

	private WebDriver driver;

	private static final By SELECT_PROBLEM_DROPDOWN_LOCATOR = By
			.cssSelector("mat-select[placeholder='Select Problem']");
	private static final By PROBLEMS_LIST_IN_DROPDOWN_LOCATOR = By.cssSelector("mat-option[role='option']");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Submit')]/..");
	private static final By SUCCESS_TOAST_MESSAGE_LOCATOR = By
			.cssSelector("span[class='mat-simple-snack-bar-content']");

	public RepairJobPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String repairJob(String jobId) {
		findWebElement(By.xpath("//mat-cell[contains(text(),'" + jobId
				+ "')]/following-sibling::mat-cell[contains(@class,'repairbutton')]")).click();
		clickOn(SELECT_PROBLEM_DROPDOWN_LOCATOR);
		getRandomELementFromListOfElements(PROBLEMS_LIST_IN_DROPDOWN_LOCATOR).click();
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return getElementText(SUCCESS_TOAST_MESSAGE_LOCATOR);
	}

}
