package com.revmo.steps;

import com.revmo.pages.LoginPage;
import com.revmo.pages.RegistrationPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revmo.testrunner.TestRunner.driver;
import static com.revmo.testrunner.TestRunner.url;

public class RegisterSteps {
    public RegistrationPage registrationPage;
    public WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(3));

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() throws InterruptedException {
        driver.get(url + "/registration.html");
        registrationPage = new RegistrationPage(driver);

    }

    @And("I type in a valid last name of {string} in registration")
    public void iTypeInAValidLastNameOfInRegistration(String lastName) {
        registrationPage.typeLastName(lastName);

    }


    @When("I type in a valid and unique email of {string}")
    public void iTypeInAValidAndUniqueEmailOf(String email) {
        registrationPage.typeEmail(email);
    }

    @And("I type in a valid password of {string}")
    public void iTypeInAValidPasswordOf(String password) {
        registrationPage.typePassword(password);
    }

    @And("I type in a valid first name of {string} in registration")
    public void iTypeInAValidFirstNameOfInRegistration(String firstName) {
        registrationPage.typeFirstName(firstName);
    }


    @And("I type in a valid phone number of {string}")
    public void iTypeInAValidPhoneNumberOf(String phoneNumber) {
    registrationPage.typePhone(phoneNumber);
    }


    @But("I should be able to login with the new account with the email {string} and password {string}")
    public void iShouldBeAbleToLoginWithTheNewAccount(String email,String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(email);
        loginPage.typePassword(password);
        loginPage.clickLogin();

    }

    @And("I click on the register submit button")
    public void iClickOnTheRegisterSubmitButton() {
        registrationPage.clickRegister();
    }
}
