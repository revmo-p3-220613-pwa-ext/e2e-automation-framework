package com.revmo.steps;

import com.revmo.pages.UserPage;
import com.revmo.testrunner.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ViewAccountSteps {

    public UserPage userPage;


    @And("I have an active account")
    public void iHaveAnActiveAccount() {
    }

    @And("I click on the view account button")
    public void iClickOnTheViewAccountButton() {
    }

    @Then("I should be redirected to the page for that account.")
    public void iShouldBeRedirectedToThePageForThatAccount() {
    }

    @Given("I am at the user page")
    public void iAmAtTheUserPage() throws InterruptedException {
        UserPage userPage = new UserPage(TestRunner.driver);

    }
}
