package com.revmo.steps;

import com.revmo.pages.HomePage;
import com.revmo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class HomeSteps {
    public HomePage homePage;
    public WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(3));

    @Given("I am at the home page")
    public void i_am_at_home_page() throws InterruptedException {
        driver.get(url + "/index.html");
        homePage = new HomePage(driver);
    }

    @When("I type in a username {string} on the home page")
    public void iTypeInAUsernameOnTheHomePage(String email) {
        homePage.typeEmail(email);
    }

    @And("I type in a password {string} on the home page")
    public void iTypeInAPasswordOnTheHomePage(String password) {
    homePage.typePassword(password);
    }

    @And("I click on the login button on home page")
    public void iClickOnTheLoginButtonOnHomePage() {
    homePage.clickLogin();
    }
}
