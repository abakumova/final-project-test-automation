package com.automation.tests.stepdefs;

import com.automation.tests.serenity.StepsForSerenity;
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

    @Then("^user sees Error Message$")
    public void userSeesErrorMessage() {
        stepsForSerenity.userSeesErrorMessage();
    }
}