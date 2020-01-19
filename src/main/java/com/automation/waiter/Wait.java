package com.automation.waiter;

import com.automation.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private static final int DEFAULT_UI_TIMEOUT_MS = 2;

    private Wait() {

    }

    public static void untilAppear(By locator, int timeoutMs) {
        WebDriverWait webDriverWait = getWebDriverWait(timeoutMs);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private static WebDriverWait getWebDriverWait(int timeoutMs) {
        return getWebDriverWait(timeoutMs, DEFAULT_UI_TIMEOUT_MS);
    }

    private static WebDriverWait getWebDriverWait(int timeoutMs, int retryIntervalMs) {
        return new WebDriverWait(WebDriverManager.getDriver(), timeoutMs / 1000, retryIntervalMs);
    }
}