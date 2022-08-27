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

    @FindBy(id="email-input")
    private WebElement emailInput;

    @FindBy(id="phone-input")
    private WebElement phoneInput;

    @FindBy(id="submit")
    private WebElement submitButton;

    @FindBy(id="error-msgs")
    private WebElement errorMessages;

    public EditUserInfoPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void inputNewEmail(String email) throws InterruptedException {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void inputNewPhone(String phone) throws InterruptedException {
        Thread.sleep(2000);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getErrorMessages() {
        return errorMessages.getText();
    }

    public void getUrl() {
        wdw.until(ExpectedConditions.urlContains("edit-user-info"));
    }

}
