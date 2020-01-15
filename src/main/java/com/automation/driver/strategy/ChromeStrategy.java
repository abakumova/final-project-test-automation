package com.automation.driver.strategy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeStrategy implements IDriverStrategy {

    @Override
    public WebDriver getDriverInstance() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--no-sandbox", "--start-maximized");
        return new ChromeDriver(options);
    }

    @Override
    public void setUpDriverConfig(String driverVersion) {
        WebDriverManager.chromedriver().version(driverVersion);
        WebDriverManager.chromedriver().setup();
    }
}