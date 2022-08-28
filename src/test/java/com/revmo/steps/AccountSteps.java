package com.revmo.steps;

import com.revmo.pages.AccountPage;
import com.revmo.pages.EmployeePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class AccountSteps {

    public AccountPage accountPage;

    public WebDriverWait wdw;

    @And("I am on the first accounts, accounts page")
    public void onAccountPage() throws InterruptedException {
        driver.get(url+"/login.html");

        accountPage = new AccountPage(driver);
    }

    @And("I select the {int} account in transfer between accounts")
    public void iSelectTheFirstAccountInTransferBetweenAccounts(int account) throws InterruptedException {
        accountPage.selectTransferIdDropdown(account);
    }

    @And("I type in a valid amount of {string} into the transfer amount")
    public void iTypeInAValidAmountOfIntoTheTransferAmount(String amount) {
        accountPage.typeAmountInput(amount);
    }

    @Then("{string} amount should be taken from my account")
    public void thatAmountShouldBeTakenFromMyAccount(String amount) {
        //work in progress
    }

    @And("I click on the user page button on the accounts page")
    public void iClickOnTheUserPageButtonOnTheAccountsPage() throws InterruptedException {
    accountPage.clickUserPageButton();
    }

    @And("I click on the logout button on the accounts page")
    public void iClickOnTheLogoutButtonOnTheAccountsPage() throws InterruptedException {

    accountPage.clickLogoutButton();
    }

    @And("I click the submit transfer button")
    public void iClickTheSubmitTransferButton() {
        accountPage.clickSubmitTransferButton();
    }
}