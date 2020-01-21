package com.automation.tests.bdd.serenity;

import com.automation.driver.WebDriverManager;
import com.automation.pages.HomePage;
import com.automation.pages.LogInPage;
import com.automation.pages.SignUpPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class StepsForSerenity {

    private HomePage homePage;
    private LogInPage logInPage;
    private SignUpPage signUpPage;

    @Step("Given the user visits main page and clicks on Sign in button")
    public void userOpensLoginPage() {
        WebDriverManager.setUpDriverConfig();
        WebDriverManager.getDriver()
                .get("https://www.neweracap.com/");
        logInPage = new HomePage().openLogInPage();
    }

    @Step("When the user enters valid credentials (-?\\d+) email (-?\\d+) password")
    public void userEnterValidCredentials(String email, String password) {
        homePage = logInPage.signIn(email, password);
    }

    @Step("When the user enters invalid credentials (-?\\d+) email (-?\\d+) password")
    public void userEnterInvalidCredentials(String email, String password) {
        logInPage.signIn(email, password);
    }

    @Step("Then the user appears on the Main page with My Account button")
    public void userSeesMainPage() {
        Assert.assertTrue("MyAccount button is not visible", homePage.isMyAccountButtonDisplayed());
        WebDriverManager.quit();
    }

    @Step("Then user sees 'Your username or password was incorrect.' message")
    public void userSeesErrorMessageLogin() {
        Assert.assertTrue("Error message is not displayed", logInPage.isErrorMessageDisplayed());
        WebDriverManager.quit();
    }

    @Step("Given the user visits main page and clicks on Sign Up button")
    public void userOpensSignupPage() {
        WebDriverManager.setUpDriverConfig();
        WebDriverManager.getDriver()
                .get("https://www.neweracap.com/");
        signUpPage = new HomePage().openSignUpPage();
    }

    @Step("When the user enters invalid credentials (-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)")
    public void userEnterSignUpCredentials(String firstName, String lastName, String email, String password, String confirmPassword) {
        signUpPage.signUp(firstName, lastName, email, password, confirmPassword);
    }

    @Step("Then user sees 'Please correct the errors below.' message")
    public void userSeesErrorMessageSignUp() {
        Assert.assertTrue("Error message is not displayed", signUpPage.isErrorMessageDisplayed());
        WebDriverManager.quit();
    }
}
