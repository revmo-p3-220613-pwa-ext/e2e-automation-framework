package com.revature.steps;

import com.revature.pages.EditUserInfoPage;
import com.revature.pages.UserPage;
import com.revature.runner.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

import java.sql.Time;

public class EditUserInfo {

    public UserPage userPage;

    public EditUserInfoPage editUserInfoPage;

    @And("I am on my user page")
    public void iAmOnMyUserPage() throws InterruptedException {
        userPage = new UserPage(TestRunner.driver);
        userPage.getHello();
    }

    @And("I click the edit user info button")
    public void iClickTheEditUserInfoButton() {
        userPage.clickEditUserInfoButton();
    }

    @Then("I should be redirected to the edit user info page")
    public void iShouldBeRedirectedToTheEditUserInfoPage() throws InterruptedException {
        editUserInfoPage = new EditUserInfoPage(TestRunner.driver);
        editUserInfoPage.getUrl();
    }


    @And("I input a new email of {string}")
    public void iInputANewEmailOf(String arg0) throws InterruptedException {
        editUserInfoPage.inputNewEmail(arg0);
    }

    @And("I input a new phone number of {string}")
    public void iInputANewPhoneNumberOf(String arg0) throws InterruptedException {
        editUserInfoPage.inputNewPhone(arg0);
    }

    @And("I click the submit button")
    public void iClickTheSubmitButton() {
        editUserInfoPage.clickSubmit();
    }

    @Then("I am redirected to my user page with new information")
    public void iAmRedirectedToMyUserPageWithNewInformation() {
        userPage.getHello();
    }

    @Given("I am at the edit user info page")
    public void iAmAtTheEditUserInfoPage() throws InterruptedException {
        userPage = new UserPage(TestRunner.driver);
        userPage.clickEditUserInfoButton();
        editUserInfoPage = new EditUserInfoPage(TestRunner.driver);
    }
}
