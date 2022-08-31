package com.revmo.steps;

import com.revmo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class LoginSteps {
    public LoginPage loginPage;
    public WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(3));

    @Given("I am at the login page")
    public void i_am_at_login_page() throws InterruptedException {
        driver.get(url + "/login.html");
        loginPage = new LoginPage(driver);

    }


    @When("I type in a username {string}")
    public void iTypeInAValidUsername(String username) throws InterruptedException {
        loginPage.typeUsername(username);

    }

    @And("I type in a password {string}")
    public void iTypeInAValidPassword(String password) throws InterruptedException {
        loginPage.typePassword(password);

    }

    @And("I click on the login button on login page")
    public void iClickOnTheLoginButtonInLogin() throws InterruptedException {
    loginPage.clickLogin();
    }


    @Then("I should receive the error on the login page {string}")
    public void iShouldReceiveTheErrorOnTheLoginPage(String error) throws InterruptedException {
        String actual = (loginPage.getErrorMessages());
        Assert.assertEquals(actual, error);
    }
}
