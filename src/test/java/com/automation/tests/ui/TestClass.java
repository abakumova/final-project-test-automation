package com.automation.tests.ui;

import com.automation.driver.WebDriverManager;
import com.automation.pages.HomePage;
import com.automation.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

    @BeforeMethod
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

    @Test
    public void checkQuantityItemsOnPageAfterChanging() {
        WebDriverManager.getDriver().navigate().refresh();
        SearchResultsPage searchResultsPage = new HomePage().search("Knit");
        searchResultsPage.changeQuantityOfItemsOnPage();
        Assert.assertEquals(24, searchResultsPage.getSearchResultItemsNames().size());
    }

    @Test
    public void checkNoResultSearch() {
        WebDriverManager.getDriver().navigate().refresh();
        SearchResultsPage searchResultsPage = new HomePage().search("ZZZZZ");
        Assert.assertTrue(searchResultsPage.getNoResultsBlockText().contains("NO RESULTS FOR"));
    }

    @Test
    public void checkMyAccountButtonVisibility() {
        HomePage homePage = new HomePage()
                .openLogInPage()
                .signIn("finaltestuser@final.com", "finaltestuser");
        Assert.assertTrue(homePage.getMyAccountButton().isDisplayed());
    }

    @Test
    public void checkSignOut() {
        HomePage homePage = new HomePage()
                .openLogInPage()
                .signIn("finaltestuser@final.com", "finaltestuser")
                .clickMyProfileButton()
                .clickSignOutButton();
        Assert.assertTrue(homePage.isSignInRegisterButtonDisplayed());
    }

    @AfterMethod
    void closeBrowser() {
        WebDriverManager.quit();
    }
}