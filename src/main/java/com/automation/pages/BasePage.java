package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
    }
}