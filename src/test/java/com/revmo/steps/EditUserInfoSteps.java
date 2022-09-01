package com.revmo.steps;

import com.revmo.pages.EditUserInfoPage;
import com.revmo.pages.LoginPage;
import com.revmo.pages.UserPage;
import com.revmo.testrunner.TestRunner;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class EditUserInfoSteps {

    public UserPage userPage;

    public EditUserInfoPage editUserInfoPage;

    private String name;
    private String phoneNumber;

//    @And("I am on my user page")
//    public void iAmOnMyUserPage() throws InterruptedException {
//        userPage = new UserPage(TestRunner.driver);
//        userPage.getHello();
//    }
//
//    @And("I click the edit user info button")
//    public void iClickTheEditUserInfoButton() {
//        userPage.clickEditUserInfoButton();
//    }
//
//    @Then("I should be redirected to the edit user info page")
//    public void iShouldBeRedirectedToTheEditUserInfoPage() throws InterruptedException {
//        editUserInfoPage = new EditUserInfoPage(TestRunner.driver);
//        editUserInfoPage.getUrl();
//    }
//
////
////    @And("I input a new email of {string}")
////    public void iInputANewEmailOf(String arg0) throws InterruptedException {
////        editUserInfoPage.inputNewEmail(arg0);
////    }
////
////    @And("I input a new phone number of {string}")
////    public void iInputANewPhoneNumberOf(String arg0) throws InterruptedException {
////        editUserInfoPage.inputNewPhone(arg0);
////    }
////
////    @And("I click the submit button")
////    public void iClickTheSubmitButton() {
////        editUserInfoPage.clickSubmit();
////    }

    @Then("I am redirected to my user page with new information")
    public void iAmRedirectedToMyUserPageWithNewInformation() {
        userPage.getHello();
    }

//    @Given("I am at the edit user info page")
//    public void iAmAtTheEditUserInfoPage() throws InterruptedException {
//        userPage = new UserPage(TestRunner.driver);
//        userPage.clickEditUserInfoButton();
//        editUserInfoPage = new EditUserInfoPage(TestRunner.driver);
//    }

    @Given("I am on the edit user info page")
    public void iAmOnTheEditUserInfoPage() throws InterruptedException {
        driver.get(url+"/login.html");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("jd80@a.ca");
        loginPage.typePassword("Password123!");
        loginPage.clickLogin();
        userPage = new UserPage(driver);
        this.name = userPage.getName();
        userPage.clickEditUserInfoButton();

        editUserInfoPage = new EditUserInfoPage(driver);
    }

    @When("I type in a first name of {string}")
    public void iTypeInAFirstNameOf(String firstname) throws InterruptedException {
        editUserInfoPage.typeFirstNameInput(firstname);
    }

    @And("I type in a valid last name of {string}")
    public void iTypeInAValidLastNameOf(String lastname) throws InterruptedException {

        editUserInfoPage.typeLastNameInput(lastname);
    }

    @And("I type a valid phone number of {string}")
    public void iTypeAValidPhoneNumberOf(String phoneNumber) throws InterruptedException {
    editUserInfoPage.typePhoneInput(phoneNumber);
    }

    @And("I click on the submit changes button")
    public void iClickOnTheSubmitChangesButton() {
        editUserInfoPage.clickSubmitButton();
    }

    @But("the name should now match {string}{string}")
    public void theNameShouldNowMatch(String firstname, String lastname) throws InterruptedException {
        Thread.sleep(500);
        String actual = userPage.getName();
        String expected = firstname + " " + lastname;
        Assert.assertEquals(actual, expected);
    }

    @When("I click on the logout button on the edit user info page")
    public void iClickOnTheLogoutButtonOnTheEditUserInfoPage() throws InterruptedException {
        editUserInfoPage.clickLogoutButton();
        Thread.sleep(200);

    }

    @When("I click on the User page button on the edit user info page")
    public void iClickOnTheUserPageButtonOnTheEditUserInfoPage() {
        editUserInfoPage.clickUserPageButton();
    }

    @And("the phone number should match {string}")
    public void thePhoneNumberShouldMatch(String phoneNumber) {
        String actual = userPage.getPhoneNumber();
        Assert.assertEquals(actual, phoneNumber);
    }
}
