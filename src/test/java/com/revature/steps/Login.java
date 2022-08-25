package com.revature.steps;

import com.revature.pages.HomePage;
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
    public HomePage homePage;
    public String homePageUrl = "http://127.0.0.1:5501/index.html";
    public String loginPageUrl = "http://127.0.0.1:5501/login.html";

    @Given("I am at the  login page")
    public void iAmAtTheLoginPage() {
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
    }

    @When("I type in a email of {string}")
    public void iTypeInAEmailOf(String email){
        loginPage.typeEmail(email);
    }

    @And("I type in a password of {string}")
    public void iTypeInAPasswordOf(String password) {
        loginPage.typePassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the user homepage")
    public void iShouldBeRedirectedToTheStudentHomepage() {
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdw.until(ExpectedConditions.urlToBe("http://127.0.0.1:5501/user-page.html"));
        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:5501/user-page.html");
    }

    @Given("I am at the home page")
    public void iAmAtTheHomePage() {
        driver.get(homePageUrl);
        homePage = new HomePage(driver);
    }

    @When("I click on the burger menu")
    public void iClickOnTheBurgerMenu() {
        homePage.clickBurger();
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        homePage.clickLogin();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        driver.get(loginPageUrl);
    }
}
