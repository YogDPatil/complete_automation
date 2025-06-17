package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;

public final class CreateJobPage extends BrowserUtils {

	private static final By OEM_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select OEM']");
	private static final By PRODUCT_NAME_DROPDOWN_LOCATOR = By
			.xpath("//mat-select[@placeholder='Select Product name']");
	private static final By MODEL_NAME_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Model name']");
	private static final By IMEI_FIELD_LOCATOR = By.cssSelector("input[placeholder='0123456789']");

	public CreateJobPage(WebDriver driver) {
		super(driver);
	}

}
