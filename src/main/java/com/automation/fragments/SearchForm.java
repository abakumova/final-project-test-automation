package com.automation.fragments;

import com.automation.pages.BasePage;
import com.automation.waiter.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SearchForm extends BasePage {

    @FindBy(xpath = "//*[@id='js-site-search-input']")
    private TextInput searchField;

    public SearchForm() {
        super(() -> Wait.untilAppear(By.xpath("//*[@id='js-site-search-input']"), 10));
    }

    public void inputTextToSearchField(String text) {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.ENTER);
    }
}