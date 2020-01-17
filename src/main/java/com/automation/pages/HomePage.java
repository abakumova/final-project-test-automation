package com.automation.pages;

import com.automation.fragments.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//ul[@class='nav__links nav__links--account']//a[contains(text(),'Register')]")
    private WebElement signInRegisterButton;

    @FindBy(xpath = ".//div[@class='ui-front']/button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='nav-cart'][1]")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id='mini-cart-dialog']/div/div/a")
    private WebElement viewShoppingBag;

    @FindBy(xpath = "//ul[@class='nav__links nav__links--account']//a[contains(text(),'Account')]")
    private WebElement myAccountButton;

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

    public boolean isMyAccountButton() {
        return myAccountButton.isDisplayed();
    }

    public boolean isSignInRegisterButton() {
        return signInRegisterButton.isDisplayed();
    }

    public WebElement getSignInRegisterButton() {
        return signInRegisterButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getViewShoppingBag() {
        return viewShoppingBag;
    }

    public WebElement getMyAccountButton() {
        return myAccountButton;
    }

    public SearchForm getSearchForm() {
        return searchForm;
    }
}