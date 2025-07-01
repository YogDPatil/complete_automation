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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BrowserUtils {

    private WebDriver driver;
    private WebDriverWait wait;
    private static WebDriver staticWebDriver;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        staticWebDriver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void enterText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
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
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(option)) {
                ele.click();
                break;
            }
        }
        // STREAM API syntax --> for filter, mapping and picking random things
        // elements.stream().filter(ele ->
        // ele.getText().equalsIgnoreCase(option)).findFirst()
        // .ifPresent(ele -> ele.click());

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
        wait.until(ExpectedConditions.urlContains(endpoint));
        return driver.getCurrentUrl();
    }

    public static String takeScreenshot(String testName) {
        String formattedDate = (new SimpleDateFormat("yyyy-MMM-dd hh:mm")).format(new Date());
        File srcFile = ((TakesScreenshot) staticWebDriver).getScreenshotAs(OutputType.FILE);
        String dirPath = System.getProperty("user.dir") + "/screenshots/";
        File dir = new File(dirPath);
        String destFilePath = dirPath + testName + "_" + formattedDate + ".png";
        File destFile = new File(destFilePath);

        try {
            if (!dir.exists()) {
                FileUtils.forceMkdir(dir);
            }
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFilePath;
    }

    public void scrollUptoTheElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

}
