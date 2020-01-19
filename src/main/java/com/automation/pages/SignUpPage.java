package com.automation.pages;

import com.automation.waiter.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//*[@id='register.firstName']")
    private TextInput firstNameInput;

    @FindBy(xpath = "//*[@id='register.lastName']")
    private TextInput lastNameInput;

    @FindBy(xpath = "//*[@id='register.email']")
    private TextInput emailAddressInput;

    @FindBy(xpath = "//*[@id='password']")
    private TextInput passwordInput;

    @FindBy(xpath = "//*[@id='register.checkPwd']")
    private TextInput confirmPasswordInput;

    @FindBy(xpath = "//*[@id='registerFormBtn']")
    private Button registerButton;

    public SignUpPage() {
        super(() -> Wait.untilAppear(By.xpath("//*[@id='registerFormBtn']"), 20));
    }

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailAddressInput.clear();
        emailAddressInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public HomePage signUp(String firstName, String lastName, String email, String password, String confirmPassword) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        registerButton.click();
        return new HomePage();
    }
}