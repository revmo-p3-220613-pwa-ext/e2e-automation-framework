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
public class LoginSteps {
    public LoginPage loginPage;
    public WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(3));

    @Given("I am at the login page")
    public void i_am_at_login_page() throws InterruptedException {
        driver.get("http://127.0.0.1:5501/login.html");
        loginPage = new LoginPage(driver);
        wdw.until(ExpectedConditions.urlContains("login.html"));

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
    public void iClickOnTheLoginButtonInLogin() {
    loginPage.clickLogin();
    }

    @Then("I should be redirected to the user-page.html")
    public void iShouldBeRedirectedToPageUser() {

        wdw.until(ExpectedConditions.urlContains("user-page.html"));

        String actual = driver.getCurrentUrl();
        String expected = "http://127.0.0.1:5501/user-page.html";
        Assert.assertEquals(actual, expected);
    }
    @Then("I should be redirected to the employee.html")
    public void iShouldBeRedirectedToPageEmployee() {

        wdw.until(ExpectedConditions.urlContains("employee.html"));

        String actual = driver.getCurrentUrl();
        String expected = "http://127.0.0.1:5501/employee.html";
        Assert.assertEquals(actual, expected);
    }

    @Then("I should receive the error on the login page {string}")
    public void iShouldReceiveTheErrorOnTheLoginPage(String error) throws InterruptedException {
//        Thread.sleep(5000);
        String actual = (loginPage.getErrorMessages());
        Assert.assertEquals(actual, error);
    }
}
