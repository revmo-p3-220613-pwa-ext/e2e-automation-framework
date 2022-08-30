package com.revmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditUserInfoPage {

    private WebDriver driver;
    private WebDriverWait wdw;

    @FindBy(id="first-name-input")
    private WebElement firstNameInput;

    @FindBy(id = "last-name-input")
    private WebElement lastNameInput;

    @FindBy(id="phone-input")
    private WebElement phoneInput;

    @FindBy(id="submit")
    private WebElement submitButton;

    @FindBy(id="error-msgs")
    private WebElement errorMessages;

    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    @FindBy(id = "my-account")
    private WebElement userPageButton;

    public EditUserInfoPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        wdw.until(ExpectedConditions.urlContains("edit-user-info.html"));
        PageFactory.initElements(driver, this);
    }

    public void typeFirstNameInput(String firstName) throws InterruptedException {
        Thread.sleep(200);

        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        Thread.sleep(200);
    }

    public void typeLastNameInput(String lastName) throws InterruptedException {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        Thread.sleep(200);
    }

    public void typePhoneInput(String phoneNumber) throws InterruptedException {
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
        Thread.sleep(200);

    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getErrorMessages(){
        return errorMessages.getText();
    }
    public void clickLogoutButton(){
        driver.manage().window().maximize();
        wdw.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }

    public void clickUserPageButton(){
        driver.manage().window().maximize();
        wdw.until(ExpectedConditions.visibilityOf(userPageButton));
        userPageButton.click();
    }
    public void getUrl() {
        wdw.until(ExpectedConditions.urlContains("edit-user-info"));
    }

}
