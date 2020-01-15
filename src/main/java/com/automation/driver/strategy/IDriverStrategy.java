package com.automation.driver.strategy;

import org.openqa.selenium.WebDriver;

public interface IDriverStrategy {

    WebDriver getDriverInstance();

    void setUpDriverConfig(String driverVersion);
}