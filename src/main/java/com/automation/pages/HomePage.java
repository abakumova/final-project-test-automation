package com.automation.pages;

import com.automation.fragments.SearchForm;
import com.automation.waiter.Wait;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

@Getter
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Register')][1]")
    private Button signInRegisterButton;

    @FindBy(xpath = "//div[@class='ui-front']")
    private Button searchButton;

    @FindBy(xpath = "//ul[(contains(@class, 'account'))]//a[contains(text(),'Account')]")
    private Button myAccountButton;

    private SearchForm searchForm;

    public HomePage() {
        super(() -> Wait.untilAppear(By.xpath(".//div[@class='ui-front']/button"), 20));
    }

    public SearchResultsPage search(String text) {
        searchForm = openSearchForm();
        searchForm.inputTextToSearchField(text);
        searchForm.pressEnter();
        return new SearchResultsPage();
    }

    public SearchForm openSearchForm(){
        searchButton.click();
        return new SearchForm();
    }

    public LogInPage openLogInPage() {
        signInRegisterButton.click();
        return new LogInPage();
    }

    public SignUpPage openSignUpPage() {
        signInRegisterButton.click();
        return new SignUpPage();
    }

    public boolean isMyAccountButton() {
        return myAccountButton.isDisplayed();
    }

    public boolean isSignInRegisterButton() {
        return signInRegisterButton.isDisplayed();
    }
}