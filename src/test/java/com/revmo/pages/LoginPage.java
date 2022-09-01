package com.revmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;


    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[1]/p[1]/input[1]")
    private WebElement emailInput;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[3]/div[1]/p[1]/input[1]")
    private WebElement passwordInput;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/form[1]/div[4]/div[1]/button[1]")
    private WebElement loginButton;

    @FindBy(id="login-btn")
    private WebElement loginRedirectButton;

    @FindBy(id="create-account")
    private WebElement createAccountButton;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/form[1]/div[1]")
    private WebElement errorMessage;

    public void typeUsername(String username){
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(2));

        wdw.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(username);
    }
    public void typePassword(String password){
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(2));

        wdw.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }
    public void clickLogin() throws InterruptedException {
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(2));

        wdw.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        Thread.sleep(500);
    }
    public void clickLoginRedirectButton(){
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(2));

        wdw.until(ExpectedConditions.elementToBeClickable(loginRedirectButton));
        loginRedirectButton.click();
    }
    public String getErrorMessages() throws InterruptedException {
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(2));

        wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-messages")));
        return errorMessage.getText();
    }

}
