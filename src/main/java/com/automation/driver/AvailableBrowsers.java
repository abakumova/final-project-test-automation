package com.automation.driver;

import com.automation.driver.strategy.ChromeStrategy;
import com.automation.driver.strategy.FireFoxStrategy;
import com.automation.driver.strategy.IDriverStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AvailableBrowsers {

    CHROME("Chrome", "79.0", "79.0") {
        public IDriverStrategy getStrategy() {
            return new ChromeStrategy();
        }
    },
    FIREFOX("FireFox", "0.25.0", "70.0.1") {
        public IDriverStrategy getStrategy() {
            return new FireFoxStrategy();
        }
    };

    private final String name;
    private final String driverVersion;
    private final String browserVersion;

    public String toString() {
        return getName() + " " + getBrowserVersion() + " " + getDriverVersion();
    }

    public IDriverStrategy getStrategy() {
        return null;
    }
}
