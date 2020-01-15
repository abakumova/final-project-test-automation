package com.automation.driver.strategy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FireFoxStrategy implements IDriverStrategy {

    @Override
    public WebDriver getDriverInstance() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("dom.webnotifications.enabled", false);
        firefoxOptions.setProfile(profile);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public void setUpDriverConfig(String driverVersion) {
        WebDriverManager.firefoxdriver().version(driverVersion);
        WebDriverManager.firefoxdriver().setup();
    }
}