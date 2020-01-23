package com.automation.driver;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;

@UtilityClass
public class WebDriverManager {

    private static final AvailableBrowsers AVAILABLE_BROWSER = AvailableBrowsers.valueOf("CHROME");

    private static final ThreadLocal<WebDriver> DRIVER_INSTANCES = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER_INSTANCES.get();
    }

    public static void setUpDriverConfig() {
        String driverVersion = AVAILABLE_BROWSER.getDriverVersion();
        AVAILABLE_BROWSER.getStrategy().setUpDriverConfig(driverVersion);
        DRIVER_INSTANCES.set(AVAILABLE_BROWSER.getStrategy().getDriverInstance());
    }

    public static void quit() {
        try {
            getDriver().close();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}
