package com.automation.tests.bdd;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.automation.tests.bdd.stepdefs",
        features = {"src/test/resources/features/"})
public class CucumberRunner {
}