package com.automation.pages;

import com.automation.waiter.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//*[@id='j_username']")
    private TextInput emailAddressInput;

    @FindBy(xpath = "//*[@id='j_password']")
    private TextInput passwordInput;

    @FindBy(xpath = "//*[@id='loginFormBtn']")
    private Button signInButton;

    @FindBy(xpath = "//p[contains(@class, 'alert-plain-message')]")
    private TextBlock errorMessage;

    public LogInPage() {
        super(() -> Wait.untilAppear(By.xpath("//*[@id='loginFormBtn']"), 20));
    }

    public void enterEmailAddress(String email) {
        emailAddressInput.clear();
        emailAddressInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public HomePage signIn(String login, String password) {
        enterEmailAddress(login);
        enterPassword(password);
        signInButton.click();
        return new HomePage();
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}