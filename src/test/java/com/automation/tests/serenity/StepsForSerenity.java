package com.automation.tests.serenity;

import com.automation.driver.WebDriverManager;
import com.automation.pages.HomePage;
import com.automation.pages.LogInPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class StepsForSerenity {

    private HomePage homePage;
    private LogInPage logInPage;

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
        Assert.assertTrue("MyAccount button is not visible", homePage.isMyAccountButton());
        WebDriverManager.quit();
    }

    @Step("Then user sees Your username or password was incorrect. message")
    public void userSeesErrorMessage() {
        Assert.assertTrue("Error message is not displayed", logInPage.isErrorMessageDisplayed());
        WebDriverManager.quit();
    }
}
