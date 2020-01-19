package com.automation.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@FindBy(className = "product-item--visible")
public class SearchResultItem extends HtmlElement {

    @FindBy(className = "product-item__name")
    private TextBlock itemName;

    public String getItemName() {
        return itemName.getText();
    }
}