package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BrowserUtils;

public final class AssignJobPage {

    private WebDriver driver;
    private BrowserUtils broserUtil;

    private static final By JOB_NUMBER_LOCATOR = By.xpath("//mat-cell[contains(@class,'jobnumber')]");
    private static final By ENG_LIST_LOCATOR = By.xpath("//div[contains(@id,'-panel')]");
    private static final By SUCCESS_MESSAGE_LOCATOR = By.xpath("//span[@class='mat-simple-snack-bar-content']");

    public AssignJobPage(WebDriver driver) {
        broserUtil = new BrowserUtils(driver);
        this.driver = driver;
    }

    public String assignJob(String jobId) {
        // scrollUptoTheElement(By.xpath("//mat-cell[contains(text(),'" + jobId +
        // "')]"));
        broserUtil.findWebElement(By.xpath("//mat-cell[contains(text(),'" + jobId + "')]/following-sibling::mat-cell[contains(@class,'engineerlist')]")).click();
        broserUtil.getRandomELementFromListOfElements(ENG_LIST_LOCATOR).click();
        broserUtil.findWebElement(By.xpath("//mat-cell[contains(text(),'" + jobId + "')]/following-sibling::mat-cell/button")).click();
        return broserUtil.getElementText(SUCCESS_MESSAGE_LOCATOR);
    }

}
