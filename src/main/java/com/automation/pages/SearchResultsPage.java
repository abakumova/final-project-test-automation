package com.automation.pages;

import com.automation.driver.WebDriverManager;
import com.automation.fragments.SearchResultItem;
import com.automation.waiter.Wait;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Getter
public class SearchResultsPage extends BasePage {

    @Timeout(15)
    @FindBy(className = "product__list--wrapper")
    private HtmlElement catalogSection;

    @FindBy(xpath = "//*[@id='perPageForm']//button")
    private Select quantitySelect;

    @FindBy(xpath = "//span[@class='text'][contains(text(), 24)]")
    private Button quantityButton;

    @FindBy(xpath = "//div[@class='headline']")
    private TextBlock noResultsBlock;

    private List<SearchResultItem> searchResultItemList;

    public SearchResultsPage() {
        super(() -> {
            Wait.scrollPageDownSearch();
            Wait.untilClickable(By.xpath("//div[contains(@class, 'back-to-top')]"), 150);
            WebDriverManager.getDriver().manage().timeouts().setScriptTimeout(55, TimeUnit.SECONDS);
        });
    }

    public List<String> getSearchResultItemsNames() {
        List<String> names = new ArrayList<>();
        searchResultItemList.forEach(item -> names.add(item.getItemName()));
        names.forEach(System.out::println);
        return names;
    }

    public void changeQuantityOfItemsOnPage() {
        quantitySelect.click();
        quantityButton.click();
    }

    public String getNoResultsBlockText() {
        return noResultsBlock.getText();
    }
}