package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    private WebDriver driver;
    private WebDriverWait wait;
    private FluentWait<WebDriver> fluentWait;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(500)).ignoring(StaleElementReferenceException.class);
        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(500));
    }

    public void enterText(By locator, String text) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ele.clear();
        ele.click();
    }

    public void clickOn(By locator) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement findWebElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findWebElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void selectOptionFromList(By locator, String option) {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
//        for (WebElement ele : elements) {
//            if (ele.getText().equalsIgnoreCase(option)) {
//                ele.click();
//                break;
//            }
//        }
        elements.stream().filter(ele -> ele.getText().equalsIgnoreCase(option)).findFirst().ifPresent(ele -> ele.click());
    }

    public WebElement getRequredELementFromListOfElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement getRandomELementFromListOfElements(By locator) {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size()));
    }

    public String getElementText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public String getCurrentPageUrl(String endpoint) {
//        wait.until(ExpectedConditions.urlContains(endpoint));
//        return driver.getCurrentUrl();
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.urlContains(endpoint));
        return driver.getCurrentUrl();
    }

    public void scrollUptoTheElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

}
