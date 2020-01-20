package com.automation.tests.ui;

import com.automation.driver.WebDriverManager;
import com.automation.pages.HomePage;
import com.automation.pages.SearchResultsPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestClass {

    @BeforeEach
    void openSitePage() {
        WebDriverManager.setUpDriverConfig();
        WebDriverManager.getDriver().get("https://www.neweracap.com/");
    }

    @Test
    public void checkSearchItemsTitle() {
        WebDriverManager.getDriver().navigate().refresh();
        SearchResultsPage searchResultsPage = new HomePage().search("Knit");
        searchResultsPage.getSearchResultItemsNames()
                .forEach(itemName ->
                        Assert.assertTrue(itemName.contains("KNIT")));
    }

    @Test
    public void checkQuantityItemsOnPage() {
        WebDriverManager.getDriver().navigate().refresh();
        SearchResultsPage searchResultsPage = new HomePage().search("Knit");
        Assert.assertEquals(12, searchResultsPage.getSearchResultItemsNames().size());
    }

    @AfterEach
    void closeBrowser() {
        WebDriverManager.quit();
    }
}
