package com.revature.steps;

import com.revature.pages.UserPage;
import com.revature.runner.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ViewAccount {

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
    public void iAmAtTheUserPage() {
        UserPage userPage = new UserPage(TestRunner.driver);

    }
}
