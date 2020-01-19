package com.automation.pages;

import com.automation.fragments.SearchForm;
import com.automation.waiter.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Register')][1]")
    private Button signInRegisterButton;

    @FindBy(xpath = ".//div[@class='ui-front']/button")
    private Button searchButton;

    @FindBy(xpath = "//div[@class='nav-cart'][1]")
    private Button cartButton;

    @FindBy(xpath = "//*[@id='mini-cart-dialog']/div/div/a")
    private Button viewShoppingBag;

    @FindBy(xpath = "//ul[(contains(@class, 'account'))]//a[contains(text(),'Account')]")
    private Button myAccountButton;

    private SearchForm searchForm;

    public HomePage() {
        super(() -> Wait.untilAppear(By.xpath(".//div[@class='ui-front']/button"), 20));
    }

    public void search(String text) {
        searchForm.inputTextToSearchField(text);
        searchForm.clickSearchButton();
    }

    public LogInPage openLogInPage() {
        signInRegisterButton.click();
        return new LogInPage();
    }

    public SignUpPage openSignUpPage() {
        signInRegisterButton.click();
        return new SignUpPage();
    }

    public CartPage openCartPage() {
        cartButton.click();
        viewShoppingBag.click();
        return new CartPage();
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