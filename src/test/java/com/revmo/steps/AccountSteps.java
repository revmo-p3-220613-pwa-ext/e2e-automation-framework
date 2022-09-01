package com.revmo.steps;

import com.revmo.pages.AccountPage;
import com.revmo.pages.EmployeePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class AccountSteps {

    public AccountPage accountPage;

    public WebDriverWait wdw;

    @And("I am on the first accounts, accounts page")
    public void onAccountPage() throws InterruptedException {
        driver.get(url+"/login.html");

        accountPage = new AccountPage(driver);
        Thread.sleep(500);
    }

    @And("I select the {int} account in transfer between accounts")
    public void iSelectTheFirstAccountInTransferBetweenAccounts(int account) throws InterruptedException {
        accountPage.selectTransferIdDropdown(account);
    }

    @And("I type in a valid amount of {string} into the transfer amount")
    public void iTypeInAValidAmountOfIntoTheTransferAmount(String amount) {
        accountPage.typeAmountInput(amount);
    }

    @Then("money amount should be taken from my account")
    public void thatAmountShouldBeTakenFromMyAccount() throws InterruptedException {
//        double actualBalance = Double.parseDouble(accountPage.getAccountBalance());
//        double originalBalance = Double.parseDouble(accountPage.getOriginalBalance());
//        double subtractAmount = Double.parseDouble(amount);
//        double expectedBalance = originalBalance - subtractAmount;

        String actualBalance = accountPage.getAccountBalance();
        String oldBalance = accountPage.getOriginalBalance();
        Assert.assertNotEquals(actualBalance,oldBalance);
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

    @Then("I should see the account current month income on the account page")
    public void iShouldSeeTheCurrentMonthIncomeOnTheUserPage() throws InterruptedException {
        String retrievedByTest = accountPage.getMonthlyIncome();
        String actualValue = "$506.70";
        Assert.assertEquals(retrievedByTest, actualValue);
    }

    @Then("I should see the all time account income on the account page")
    public void iShouldSeeTheAllTimeIncomeOnTheUserPage() throws InterruptedException {
        String retrievedByTest = accountPage.getAllTimeAccountIncome();
        String actualValue = "$5,083.50";
        Assert.assertEquals(retrievedByTest, actualValue);
    }
}