package com.automation.tests.bdd.stepdefs;

import com.automation.tests.bdd.serenity.StepsForSerenity;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {

    @Steps
    StepsForSerenity stepsForSerenity;

    @Given("^user opens the LogIn Page$")
    public void user_opens_the_LogIn_Page() {
        stepsForSerenity.userOpensLoginPage();
    }

    @When("^user enters valid login as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userEntersValidLoginAsLoginAndPasswordAsPassword(String login, String password) {
        stepsForSerenity.userEnterValidCredentials(login, password);
    }

    @When("^user enters invalid login as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userEntersInvalidLoginAsLoginAndPasswordAsPassword(String login, String password) {
        stepsForSerenity.userEnterInvalidCredentials(login, password);
    }

    @Then("^user sees Home Page with MyAccount button$")
    public void userSeesHomePageWithMyAccountButton() {
        stepsForSerenity.userSeesMainPage();
    }

    @Then("^user sees Error Message about login$")
    public void userSeesErrorMessage() {
        stepsForSerenity.userSeesErrorMessageLogin();
    }

    @Given("^user opens the SignUp Page$")
    public void userOpensTheSignUpPage() {
        stepsForSerenity.userOpensSignupPage();
    }

    @When("^user enters invalid sign up data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userEntersInvalidSignUpDataFirstNameLastNameEmailPasswordConfirmPassword(String firstName,
                                                                                         String lastName, String email,
                                                                                         String password,
                                                                                         String confirmPassword) {
        stepsForSerenity.userEnterSignUpCredentials(firstName, lastName, email, password, confirmPassword);
    }

    @Then("^user sees Error Message about signup$")
    public void userSeesErrorMessageAboutSignup() {
        stepsForSerenity.userSeesErrorMessageSignUp();
    }
}