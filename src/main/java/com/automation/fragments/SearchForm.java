package com.automation.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//div[@class='modal-body']/div[1]")
public class SearchForm extends HtmlElement {

    @FindBy(id = "js-site-search-input")
    private TextInput searchField;

    @FindBy(xpath = "//*[@id='siteSearch']//button[2]")
    private Button searchButton;

    public void inputTextToSearchField(String text) {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
        searchButton.sendKeys("something");
    }
}