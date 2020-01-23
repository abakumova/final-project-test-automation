package com.automation.waiter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.automation.driver.WebDriverManager.getDriver;

public class Wait {

    private static final int DEFAULT_UI_TIMEOUT_MS = 2;

    private Wait() {

    }

    public static void untilAppear(By locator, int timeoutMs) {
        WebDriverWait webDriverWait = getWebDriverWait(timeoutMs);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void untilClickable(By locator, int timeoutMs) {
        WebDriverWait webDriverWait = getWebDriverWait(timeoutMs);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void scrollPageDown() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,250)");
    }

    public static void scrollPageDownSearch() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,600)");
        getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 8000);");
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product-item:nth-of-type(12)")));
    }

    private static WebDriverWait getWebDriverWait(int timeoutMs) {
        return getWebDriverWait(timeoutMs, DEFAULT_UI_TIMEOUT_MS);
    }

    private static WebDriverWait getWebDriverWait(int timeoutMs, int retryIntervalMs) {
        return new WebDriverWait(getDriver(), timeoutMs / 1000, retryIntervalMs);
    }
}