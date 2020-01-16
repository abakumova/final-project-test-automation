package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//*[@id='j_username']")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//*[@id='j_password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='loginFormBtn']")
    private WebElement signInButton;

    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmailAddress(String email) {
        emailAddressInput.clear();
        emailAddressInput.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public ProfilePage signIn(String email, String password) {
        enterEmailAddress(email);
        enterPassword(password);
        signInButton.click();
        return new ProfilePage(webDriver);
    }

    public WebElement getSignInButton() {
        return signInButton;
    }
}