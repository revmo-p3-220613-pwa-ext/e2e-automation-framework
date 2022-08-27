package com.revmo.pages;

import io.cucumber.java.bs.I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {

    private WebDriver driver;
    private WebDriverWait wdw;

    @FindBy(id="name")
    private WebElement name;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="phone")
    private WebElement phoneNumber;

    @FindBy(id="edit-user-info-btn")
    private WebElement editUserInfoButton;

    @FindBy(id="hello")
    private WebElement hello;

    @FindBy(id="1")
    private WebElement account1;

    @FindBy(id = "my-income")
    private WebElement allIncomeButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/p[5]/a[1]/button[1]")
    private WebElement pendingTransactionsButton;

    @FindBy(id = "sending-sending-id")
    private WebElement sendingIdDropdown;

    @FindBy(id = "sending-receiving-id")
    private WebElement sendMoneyEmailInput;

    @FindBy(id = "sending-amount-dollars")
    private WebElement sendMoneyAmountInput;

    @FindBy(id = "sending-transfer-btn")
    private WebElement sendMoneySubmitButton;

    @FindBy(id = "request-sending-id")
    private WebElement requestMoneyEmailInput;

    @FindBy(id = "request-receiving-id")
    private WebElement requestAccountDropdown;

    @FindBy(id = "request-amount-dollars")
    private WebElement requestAmountInput;

    @FindBy(id = "request-transfer-btn")
    private WebElement requestTransferSubmitButton;

    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    @FindBy(id = "my-account")
    private WebElement myAccountsButton;


    public UserPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("jd80@a.ca");
        loginPage.typePassword("Password123!");
        loginPage.clickLogin();
        PageFactory.initElements(driver, this);
    }

    public void getHello() {
        wdw.until(ExpectedConditions.urlContains("user-page"));
        hello.getText();
    }

    public void clickEditUserInfoButton() {
        wdw.until(ExpectedConditions.elementToBeClickable(editUserInfoButton));
        editUserInfoButton.click();
    }

    public void clickAccount1() {
        account1.click();
    }

    public void clickAllIncomeButton() {
     allIncomeButton.click();
    }

    public void clickPendingTransactionsButton(){
        pendingTransactionsButton.click();
    }
//    public void selectSendingDropdown(){
//        sendingIdDropdown.click();
//    }
    public void typeSendMoneyEmailInput(String email){
        sendMoneyEmailInput.sendKeys(email);
    }

    public void typeSendMoneyAmountInput(String amount){
        sendMoneyAmountInput.sendKeys(amount);
    }

    public void clickSendMoneySubmitButton(){
        sendMoneySubmitButton.click();
    }

    public void typeRequestEmailInput(String email){
        requestMoneyEmailInput.sendKeys(email);
    }

    public void selectRequestAmountDropdown(){
        requestAccountDropdown.click();
    }

    public void typeRequestAmountInput(String amount){
        requestAmountInput.sendKeys(amount);
    }

    public void clickRequestTransferSubmitButton(){
        requestTransferSubmitButton.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public void clickMyAccountsButton(){
        myAccountsButton.click();
    }

}
