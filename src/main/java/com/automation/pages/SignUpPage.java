package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//*[@id='register.firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id='register.lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='register.email']")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='register.checkPwd']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[@id='registerFormBtn']")
    private WebElement registerButton;

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
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

    public ProfilePage signUp(String firstName, String lastName, String email, String password, String confirmPassword) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        registerButton.click();
        return new ProfilePage(webDriver);
    }
}