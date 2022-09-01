package com.revmo.steps;

import com.revmo.pages.LoginPage;
import com.revmo.pages.PendingTransactionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class PendingTransactionsSteps {
    public PendingTransactionPage pendingTransactionPage;
    public WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(3));


    @Given("that I am on the pending transactions page")
    public void thatIAmOnThePendingTransactionsPage() throws InterruptedException {
        driver.get(url+"/login.html");

        pendingTransactionPage = new PendingTransactionPage((driver));
    }

    @And("I click on the deny transaction button")
    public void iClickOnTheDenyTransactionButton() throws InterruptedException {
        pendingTransactionPage.clickDenyFirstRequestButton();
    }

    @Then("the amount in my account should remain the same")
    public void theAmountInMyAccountShouldRemainTheSame() throws InterruptedException {
        Thread.sleep(600);
        String start = pendingTransactionPage.getOriginalBalance();
        String stop = pendingTransactionPage.getBalance();
        Assert.assertEquals(start, stop);

    }

    @And("I click on the approve transaction button")
    public void iClickOnTheApproveTransactionButton() throws InterruptedException {
        pendingTransactionPage.clickFirstApproveButton();
    }
    @Then("the amount in my account should not remain the same")
    public void theAmountInMyAccountShouldNotRemainTheSame() throws InterruptedException {
        Thread.sleep(600);
        String start = pendingTransactionPage.getOriginalBalance();
        String stop = pendingTransactionPage.getBalance();
        Assert.assertNotEquals(start, stop);

    }
}
