package com.automation.tests.ui;

import com.automation.driver.WebDriverManager;
import com.automation.pages.HomePage;
import com.automation.pages.SearchResultsPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;


public class TestClass {

    static {
        WebDriverManager.setUpDriverConfig();
        WebDriverManager.getDriver()
                .get("https://www.neweracap.com/");
    }

    @Test
    public void checkSearchItemsTitle() {
        WebDriverManager.getDriver().navigate().refresh();

        SearchResultsPage searchResultsPage = new HomePage().search("Knit");

        searchResultsPage.getSearchResultItemsNames()
                .forEach(itemName ->
                        Assert.assertTrue(itemName.contains("KNIT")));
    }

    @AfterClass
    public static void closeBrowser() {
        WebDriverManager.quit();
    }
}
