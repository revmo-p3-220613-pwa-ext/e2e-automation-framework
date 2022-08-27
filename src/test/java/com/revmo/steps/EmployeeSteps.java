package com.revmo.steps;

import com.revmo.pages.EmployeePage;
import com.revmo.pages.LoginPage;
import com.revmo.pages.UserPage;
import com.revmo.testrunner.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.revmo.testrunner.TestRunner.driver;

public class EmployeeSteps {
    public EmployeePage employeePage;

    public WebDriverWait wdw;

    @Given("that I login as an employee")
    public void loginAsEmployee() throws InterruptedException {
        driver.get("http://127.0.0.1:5501/login.html");
//        wdw.until(ExpectedConditions.urlContains("login.html"));
        employeePage = new EmployeePage(driver);
    }

    @When("I type in a valid email of {string} into set active user")
    public void iTypeInAValidEmailOf(String email) throws InterruptedException {
        employeePage.typeEmail(email);
    }

    @And("I click on the search button in the form set active user")
    public void iClickOnTheSearchButtonInTheFormSetActiveUser() throws InterruptedException {
        employeePage.clickEmailSearch();
    }

    @Then("A table should generate with accounts for {string}")
    public void aTableShouldGenerateWithAccountsForThatEmail(String email) {
        String actual = employeePage.getAccountTitle();
        String expected = "Accounts for "+ email;
        Assert.assertEquals(expected, actual);
    }

    @And("I click on the savings radio button")
    public void iClickOnSavingsButton() {
        employeePage.clickSavingsButton();
    }

    @And("I click the add account submit button")
    public void iClickTheAddAccountSubmitButton() {
        employeePage.clickAddAccountButton();
    }

    @And("I click on the checking radio button")
    public void iClickOnTheCheckingRadioButton() {
        employeePage.clickCheckingButton();
    }

    @And("I type in an account number of {string}")
    public void iTypeInAnAccountNumberOf(String account) {
        employeePage.typeLinkAccount(account);
    }

    @And("I click on the link account button")
    public void iClickOnTheLinkAccountButton() {
        employeePage.clickLinkAccountButton();
    }

    @And("I select account {int} from unlink dropdown")
    public void iSelectAccountAccountIdFromUnlinkDropdown(int id) throws InterruptedException {

        employeePage.selectUnlinkAccount(id);

    }

    @And("I click on the unlink account button")
    public void iClickOnTheUnlinkAccountButton() {
        employeePage.clickUnlinkAccount();
    }

    @And("I wait a moment")
    public void iWaitAMoment() throws InterruptedException {

//        Thread.sleep(1000);
    }

    @When("I click on logout on employee page")
    public void iClickOnLogoutOnEmployeePage() throws InterruptedException {

        employeePage.clickLogoutButton();
    }

    @Then("I should be redirected to the index.html")
    public void iShouldBeRedirectedToTheIndexHtml() throws InterruptedException {
        Thread.sleep(500);
//    wdw.until(ExpectedConditions.urlContains("index.html"));
    String actual = driver.getCurrentUrl();
    String expected = "http://127.0.0.1:5501/index.html";
    Assert.assertEquals(actual, expected);
    }

    @And("I click on the first account")
    public void iClickOnTheFirstAccount() {
        employeePage.clickFirstAccount();
    }

    @And("I click back")
    public void iClickBack() {
        employeePage.clickBackOnTrx();
    }

    @Then("I should be at the original table on employees")
    public void iShouldBeAtTheOriginalTableOnEmployees() {
        String actual = employeePage.getAccountTitle();
        String expected = "Accounts for jd80@a.ca";
        Assert.assertEquals(expected, actual);
    }
}
