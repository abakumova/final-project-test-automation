package com.automation.pages;

import com.automation.driver.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    private BasePage() {
        WebDriverManager.getDriver().manage().window().maximize();
        WebDriverManager.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebDriverManager.getDriver().manage().timeouts().setScriptTimeout(35, TimeUnit.SECONDS);
        PageFactory.initElements(new HtmlElementDecorator
                (new HtmlElementLocatorFactory(WebDriverManager.getDriver())), this);
    }

    public BasePage(Runnable runnable) {
        this();
        runnable.run();
    }
}