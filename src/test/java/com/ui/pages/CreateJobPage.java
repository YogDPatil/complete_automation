package com.ui.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.BrowserUtils;
import com.utils.TestUtils;

public final class CreateJobPage {

    private WebDriver driver;
    private BrowserUtils browserUtils;

    private static final By OEM_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select OEM']");
    private static final By OEM_OPTIONS_LOCATOR = By.cssSelector("mat-option[role='option']");
    private static final By PRODUCT_NAME_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Product name']");
    private static final By PRODUCT_NAME_OPTIONS_LOCATOR = By.xpath("//div[@id='mat-select-2-panel']/mat-option");
    private static final By MODEL_NAME_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder='Select Model name']");
    private static final By MODEL_NAME_OPTION_LOCATOR = By.xpath("//div[@id='mat-select-4-panel']/mat-option");
    private static final By IMEI_FIELD_LOCATOR = By.cssSelector("input[placeholder='0123456789']");
    private static final By DATE_FIELD_LOCATOR = By.cssSelector("input[placeholder='dd/mm/yyyy']");
    private static final By WARRANTY_STATUS_DROPDOWN_LOCATOR = By.cssSelector("mat-select[placeholder='Select Warranty Status']");
    private static final By WARRANTY_STATUS_OPTIONS_LOCATOR = By.xpath("//div[@id='mat-select-6-panel']/mat-option");
    private static final By SELECT_PROBLE_DROPDOWN_LOCATOR = By.cssSelector("mat-select[placeholder='Select Problem']");
    private static final By SELECT_PROBLE_OPTIONS_LOCATOR = By.xpath("//div[@id='mat-select-8-panel']/mat-option");
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
    private static final By STATE_OPTIONS_LOCATOR = By.xpath("//div[@id='mat-autocomplete-1']/mat-option");
    private static final By PINCODE_FIELD_LOCATOR = By.cssSelector("input[placeholder='Pincode']");
    private static final By SUBMIT_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");
    private static final By JOB_CREATED_TOAST_MASSAGE_LOCATOR = By.xpath("//span[@class='mat-simple-snack-bar-content']");

    public CreateJobPage(WebDriver driver) {
        this.driver = driver;
        browserUtils = new BrowserUtils(driver);
    }

    // public void eleList() {
    // List<String> activeTexts =
    // driver.findElements(By.cssSelector(".status")).stream()
    // .filter(element -> element.isDisplayed()).map(element -> element.getText())
    // .filter(text -> text.contains("Active")).collect(Collectors.toList());
    // }

    public String enterJobDetailsAndCreateJob(String oem, String productName, String modelName, String date, String warrantyStatus) {
        browserUtils.clickOn(OEM_DROPDOWN_LOCATOR);
        browserUtils.selectOptionFromList(OEM_OPTIONS_LOCATOR, oem);
        browserUtils.clickOn(PRODUCT_NAME_DROPDOWN_LOCATOR);
        browserUtils.selectOptionFromList(PRODUCT_NAME_OPTIONS_LOCATOR, productName);
        browserUtils.clickOn(MODEL_NAME_DROPDOWN_LOCATOR);
        browserUtils.selectOptionFromList(MODEL_NAME_OPTION_LOCATOR, modelName);
        browserUtils.enterText(IMEI_FIELD_LOCATOR, TestUtils.getFakeData().get("imei"));
        browserUtils.enterText(DATE_FIELD_LOCATOR, date);
        browserUtils.clickOn(WARRANTY_STATUS_DROPDOWN_LOCATOR);
        browserUtils.selectOptionFromList(WARRANTY_STATUS_OPTIONS_LOCATOR, warrantyStatus);
        browserUtils.clickOn(SELECT_PROBLE_DROPDOWN_LOCATOR);
        browserUtils.selectOptionFromList(SELECT_PROBLE_OPTIONS_LOCATOR, "Poor battery life");
        browserUtils.enterText(REMARK_FIELD_LOCATOR, "Testing");
        browserUtils.enterText(FNAME_FIELD_LOCATOR, TestUtils.getFakeData().get("fName"));
        browserUtils.enterText(LNAME_FIELD_LOCATOR, TestUtils.getFakeData().get("lName"));
        browserUtils.enterText(CONTACT_NUMBER_FIELD_LOCATOR, TestUtils.getFakeData().get("number"));
        browserUtils.enterText(EMAIL_FIELD_LOCATOR, TestUtils.getFakeData().get("email"));
        browserUtils.enterText(FLAT_NUM_FIELD_LOCATOR, TestUtils.getFakeData().get("flatNumber"));
        browserUtils.enterText(APPT_NAME_FIELD_LOCATOR, TestUtils.getFakeData().get("apptName"));
        browserUtils.enterText(LANDMARK_FIELD_LOCATOR, TestUtils.getFakeData().get("landmark"));
        browserUtils.enterText(STREET_NAME_FIELD_LOCATOR, TestUtils.getFakeData().get("streetName"));
        browserUtils.enterText(AREA_FIELD_LOCATOR, TestUtils.getFakeData().get("area"));
        browserUtils.clickOn(STATE_FIELD_LOCATOR);
        browserUtils.selectOptionFromList(STATE_OPTIONS_LOCATOR, "Maharashtra");
        browserUtils.enterText(PINCODE_FIELD_LOCATOR, TestUtils.getFakeData().get("pincode"));
        browserUtils.clickOn(SUBMIT_BUTTON_LOCATOR);
        return (browserUtils.getElementText(JOB_CREATED_TOAST_MASSAGE_LOCATOR).split(" "))[0];
    }

}
