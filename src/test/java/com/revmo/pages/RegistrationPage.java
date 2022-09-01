package com.revmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wdw;

    public RegistrationPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
//        RegistrationPage registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, this);
       }
       @FindBy(id = "email-regis-input")
    private WebElement emailInput;

    @FindBy(id = "password-regis-input")
    private WebElement passwordInput;

    @FindBy(id = "first-regis-input")
    private WebElement firstNameInput;

    @FindBy(id = "last-regis-input")
    private WebElement lastNameInput;

    @FindBy(id = "phone-regis-input")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[7]/div[1]/button[1]")
    private WebElement registerSubmitButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[7]/div[2]/button[1]/a[1]")
    private WebElement cancelButton;


public void typeEmail(String email){
    emailInput.sendKeys(email);
}
public void typePassword(String password){
    passwordInput.sendKeys(password);
}
public void typeFirstName(String firstName){
    firstNameInput.sendKeys(firstName);
}
    public void typeLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void typePhone(String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
    }
    public void clickRegister(){
    registerSubmitButton.click();
    }
}
