package com.revmo.steps;

import com.revmo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class UserPageSteps {
    public UserPage userPage;
    public WebDriverWait wdw;
    public PendingTransactionPage pendingTransactionPage;

    @Given("that I login as a user")
    public void loginAsUser() throws InterruptedException {
        driver.get(url+"/login.html");
//        wdw.until(ExpectedConditions.urlContains("login.html"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("jd80@a.ca");
        loginPage.typePassword("Password123!");
        loginPage.clickLogin();
//        wdw.until(ExpectedConditions.urlContains("page.html"));
        Thread.sleep(400);

        userPage = new UserPage(driver);
    }
    @Given("that I login as a different user")
    public void loginAsDifferentUser() throws InterruptedException {


        driver.get(url+"/login.html");
//        wdw.until(ExpectedConditions.urlContains("login.html"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("jd81@a.ca");
        loginPage.typePassword("Password123!");
        loginPage.clickLogin();
//        wdw.until(ExpectedConditions.urlContains("page.html"));
        Thread.sleep(400);
        userPage = new UserPage(driver);

    }
    @When("I click on the first account displayed")
    public void iClickOnTheFirstAccountDisplayed() {

        userPage.clickAccount1();
    }

    @Then("I should see the current month income on the user page")
    public void iShouldSeeTheCurrentMonthIncomeOnTheUserPage() throws InterruptedException {
        String retrievedByTest = userPage.getCurrentMonthIncome();
        String actualValue = "$564.26";
        Assert.assertEquals(retrievedByTest, actualValue);
    }

    @Then("I should see the all time income on the user page")
    public void iShouldSeeTheAllTimeIncomeOnTheUserPage() throws InterruptedException {
        String retrievedByTest = userPage.getAllTimeIncome();
        String actualValue = "$5,141.06";
        Assert.assertEquals(retrievedByTest, actualValue);
    }

    @When("I click on the edit user info button")
    public void iClickOnTheEditUserInfoButton() {
    userPage.clickEditUserInfoButton();
    }


    @When("I click on the all income button")
    public void iClickOnTheAllIncomeButton() {
        userPage.clickAllIncomeButton();
    }


    @When("I click on the pending transactions button")
    public void iClickOnThePendingTransactionsButton() {
        userPage.clickPendingTransactionsButton();
    }


    @When("I scroll down to see send money")
    public void iScrollDownToSeeSendMoney() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(200);
      }

    @And("I select the first account in send money")
    public void iSelectTheFirstAccountInSendMoney() throws InterruptedException {
        userPage.selectSendingDropdown();
    }

    @And("I type in an email of {string} into send email")
    public void iTypeInAnEmailOfIntoSendEmail(String email) {
        userPage.typeSendMoneyEmailInput(email);
    }

    @And("I type in a valid amount of {string} into send money")
    public void iTypeInAValidAmountOfIntoSendMoney(String amount) {
    userPage.typeSendMoneyAmountInput(amount);
    }

    @And("I click on send money submit button")
    public void iClickOnSendMoneySubmitButton() throws InterruptedException {
        userPage.clickSendMoneySubmitButton();
    }

    @When("I scroll down to see request money")
    public void iScrollDownToSeeRequestMoney() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,850)", "");
        Thread.sleep(200);
    }

    @And("I type in a valid email of {string} into request email")
    public void iTypeInAValidEmailOfIntoRequestEmail(String email) {
        userPage.typeRequestEmailInput(email);

    }

    @And("I select the first account in request money")
    public void iSelectTheFirstAccountInRequestMoney() throws InterruptedException {
        userPage.selectRequestAmountDropdown();
    }

    @And("I type in a valid amount of {string} into request money")
    public void iTypeInAValidAmountOfIntoRequestMoney(String amount) {
        userPage.typeRequestAmountInput(amount);
    }

    @And("I click on request money submit button")
    public void iClickOnRequestMoneySubmitButton() {
    userPage.clickRequestTransferSubmitButton();
    }

    @When("I click on the logout button on the user-page")
    public void iClickOnTheLogoutButtonOnTheUserPage() throws InterruptedException {
        userPage.clickLogoutButton();
    }

    @Then("My first account should have less money")
    public void myFirstAccountShouldHaveLessMoney() throws InterruptedException {

//        Thread.sleep(200);
        String original = userPage.getOriginalBalance();
        String updated = userPage.getCurrentBalance();
        Assert.assertNotEquals(original, updated);
    }

    @And("I scroll back up from send money")
    public void iScrollBackUpFromSendMoney() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)", "");
        Thread.sleep(200);
    }



    @And("I click on the navbar login button from the home page")
    public void iClickOnTheNavbarLoginButtonFromTheHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.typeEmail("jd80@a.ca");
        homePage.typePassword("Password123!");
        homePage.clickLogin();
    }



}
