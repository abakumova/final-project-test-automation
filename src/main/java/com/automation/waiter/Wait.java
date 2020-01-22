package com.automation.waiter;

import com.automation.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }

    public static void scrollPageDown() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,250)");
    }

    public static void scrollPageDownSearch() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,550)");
        new WebDriverWait(getDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        new WebDriverWait(WebDriverManager.getDriver(), 2000).until((ExpectedCondition<Boolean>) driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (Boolean) js.executeScript("return jQuery.active == 0");
        });
    }

    private static WebDriverWait getWebDriverWait(int timeoutMs) {
        return getWebDriverWait(timeoutMs, DEFAULT_UI_TIMEOUT_MS);
    }

    private static WebDriverWait getWebDriverWait(int timeoutMs, int retryIntervalMs) {
        return new WebDriverWait(getDriver(), timeoutMs / 1000, retryIntervalMs);
    }
}