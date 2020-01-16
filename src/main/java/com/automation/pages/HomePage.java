package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'nav__links nav__links--account')]")
    private WebElement signInRegisterButton;

    @FindBy(xpath = ".//div[@class='ui-front']/button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='nav-cart'][1]")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id='mini-cart-dialog']/div/div/a")
    private WebElement viewShoppingBag;

    private SearchForm searchForm;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void search(String text) {
        searchForm.inputTextToSearchField(text);
        searchForm.clickSearchButton();
    }

    public LogInPage openLogInPage() {
        signInRegisterButton.click();
        return new LogInPage(webDriver);
    }

    public SignUpPage openSignUpPage() {
        signInRegisterButton.click();
        return new SignUpPage(webDriver);
    }

    public CartPage openCartPage() {
        cartButton.click();
        viewShoppingBag.click();
        return new CartPage(webDriver);
    }
}