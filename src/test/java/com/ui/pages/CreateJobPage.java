package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtils;
import com.utils.TestUtils;

public final class CreateJobPage extends BrowserUtils {

	private static final By OEM_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select OEM']");
	private static final By OEM_OPTIONS_LOCATOR = By.cssSelector("mat-option[role='option']");
	private static final By PRODUCT_NAME_DROPDOWN_LOCATOR = By
			.xpath("//mat-select[@placeholder='Select Product name']");
	private static final By MODEL_NAME_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Model name']");
	private static final By IMEI_FIELD_LOCATOR = By.cssSelector("input[placeholder='0123456789']");
	private static final By DATE_FIELD_LOCATOR = By.cssSelector("input[placeholder='dd/mm/yyyy']");
	private static final By WARRANTY_STATUS_DROPDOWN_LOCATOR = By
			.cssSelector("mat-select[placeholder='Select Warranty Status']");
	private static final By SELECT_PROBLE_DROPDOWN_LOCATOR = By.cssSelector("mat-select[placeholder='Select Problem']");
	private static final By REMARK_FIELD_LOCATOR = By.cssSelector("input[placeholder='Remarks']");
	private static final By FNAME_FIELD_LOCATOR = By.cssSelector("input[placeholder='First Name']");
	private static final By LNAME_FIELD_LOCATOR = By.cssSelector("input[placeholder='Last Name']");

	private static final By CONTACT_NUMBER_FIELD_LOCATOR = By.cssSelector("input[placeholder='Contact No.']");
	private static final By EMAIL_FIELD_LOCATOR = By.cssSelector("input[placeholder='Email Id.']");
	private static final By FLAT_NUM_FIELD_LOCATOR = By.cssSelector("input[placeholder='Flat/Society No.']");
	private static final By APPT_NAME_FIELD_LOCATOR = By.cssSelector("input[placeholder='Apartment Name']");
	private static final By LANDMARK_FIELD_LOCATOR = By.cssSelector("input[placeholder='Choose a Landmark']");
	private static final By STREET_NAME_FIELD_LOCATOR = By.cssSelector("input[placeholder='Street Name.']");
	private static final By AREA_FIELD_LOCATOR = By.cssSelector("input[placeholder='Area']");
	private static final By STATE_FIELD_LOCATOR = By.cssSelector("input[placeholder='Select State']");
	private static final By PINCODE_FIELD_LOCATOR = By.cssSelector("input[placeholder='Pincode']");
	private static final By SUBMIT_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");

	public CreateJobPage(WebDriver driver) {
		super(driver);
	}

	public void enterJobDetails() {
//		clickOn(OEM_DROPDOWN_LOCATOR);
		findWebElement(OEM_DROPDOWN_LOCATOR).click();
		selectOptionFromList(OEM_OPTIONS_LOCATOR, "apple");
		enterText(IMEI_FIELD_LOCATOR, TestUtils.getFakeData().get("imei"));
	}

}
