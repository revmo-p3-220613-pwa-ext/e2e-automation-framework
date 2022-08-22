package com.revature.steps;

import com.revature.pages.LoginPage;
import com.revature.runner.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.revature.runner.TestRunner.driver;

public class Login {

    public LoginPage loginPage;

    @Given("I am at the  login page")
    @Test(groups = "login")
    public void iAmAtTheLoginPage() {
        driver.get("http://127.0.0.1:5501/login.html");
        loginPage = new LoginPage(driver);
    }

    @When("I type in a email of {string}")
    @Test(groups = "login")
    public void iTypeInAEmailOf(String email){
        loginPage.typeEmail(email);
    }

    @And("I type in a password of {string}")
    @Test(groups = "login")
    public void iTypeInAPasswordOf(String password) {
        loginPage.typePassword(password);
    }

    @And("I click the login button")
    @Test(groups = "login")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton2();
    }

    @Then("I should be redirected to the student homepage")
    @Test(groups = "login")
    public void iShouldBeRedirectedToTheStudentHomepage() {
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdw.until(ExpectedConditions.urlToBe("http://127.0.0.1:5501/user-page.html"));
        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:5501/user-page.html");
    }
}
