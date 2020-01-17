package com.automation.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static final AvailableBrowsers AVAILABLE_BROWSER = AvailableBrowsers.valueOf("CHROME");

    private static final ThreadLocal<WebDriver> DriverInstances = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DriverInstances.get();
    }

    public static void setUpDriverConfig() {
        String driverVersion = AVAILABLE_BROWSER.getDriverVersion();
        AVAILABLE_BROWSER.getStrategy().setUpDriverConfig(driverVersion);
        DriverInstances.set(AVAILABLE_BROWSER.getStrategy().getDriverInstance());
    }

    public static void quit() {
        try {
            getDriver().close();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}
