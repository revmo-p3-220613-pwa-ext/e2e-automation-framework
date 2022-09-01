package com.revmo.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class RedirectedSteps {


    public WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(3));


    @Then("I should be redirected to the employee.html")
    public void iShouldBeRedirectedToPageEmployee() throws InterruptedException {

        wdw.until(ExpectedConditions.urlContains("employee.html"));
//        Thread.sleep(500);

        String actual = driver.getCurrentUrl();
        String expected = url + "/employee.html";
        Assert.assertEquals(actual, expected);
    }
    @Then("I should be redirected to the index.html")
    public void iShouldBeRedirectedToTheIndexHtml() throws InterruptedException {
        Thread.sleep(1000);
    wdw.until(ExpectedConditions.urlContains("index.html"));
        String actual = driver.getCurrentUrl();
        String expected = url + "/index.html";
        Assert.assertEquals(actual, expected);
    }

    @Then("I should be redirected to the user-page.html")
    public void iShouldBeRedirectedToPageUser() throws InterruptedException {
//        Thread.sleep(400);
        wdw.until(ExpectedConditions.urlContains("user-page.html"));
        String actual = driver.getCurrentUrl();
        String expected = url + "/user-page.html";
        Assert.assertEquals(actual, expected);
    }

    @Then("I should be redirected to the pending-transactions.html")
    public void iShouldBeRedirectedToThePendingTransactionsHtml() throws InterruptedException {
        wdw.until(ExpectedConditions.urlContains("pending-transactions.html"));
//        Thread.sleep(400);
        String actual = driver.getCurrentUrl();
        String expected = url + "/pending-transactions.html";
        Assert.assertEquals(actual, expected);
    }
    @Then("I should be redirected to the income.html")
    public void iShouldBeRedirectedToTheIncomeHtml() throws InterruptedException {
        wdw.until(ExpectedConditions.urlContains("income.html"));
        String actual = driver.getCurrentUrl();
        String expected = url + "/income.html";
        Assert.assertEquals(actual, expected);
    }
    @Then("I should be redirected to the login.html")
    public void iShouldBeRedirectedToTheLoginHtml() throws InterruptedException {
//        wdw.until(ExpectedConditions.urlContains("login.html"));
        Thread.sleep(500);
        String actual = driver.getCurrentUrl();
        String expected = url + "/login.html";
        Assert.assertEquals(actual, expected);
    }
    @Then("I should be redirected to the edit-user-info.html")
    public void iShouldBeRedirectedToTheEditUserInfoHtml() throws InterruptedException {
        wdw.until(ExpectedConditions.urlContains("edit-user-info.html"));
//        Thread.sleep(400);
        String actual = driver.getCurrentUrl();
        String expected = url + "/edit-user-info.html";
        Assert.assertEquals(actual, expected);
    }
    @Then("I should be redirected to the account.html")
    public void iShouldBeRedirectedToTheAccountHtml() throws InterruptedException {
        wdw.until(ExpectedConditions.urlContains("account.html"));
//        Thread.sleep(400);
        String actual = driver.getCurrentUrl();
        String expected = url + "/account.html";
        Assert.assertEquals(actual, expected);
    }
}
