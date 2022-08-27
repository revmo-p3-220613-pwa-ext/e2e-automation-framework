package com.revmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeePage {
    private WebDriver driver;

    private WebDriverWait wdw;

    public EmployeePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("jd800@a.ca");
        loginPage.typePassword("Password123!");
        loginPage.clickLogin();
        PageFactory.initElements(driver, this);
        wdw.until(ExpectedConditions.urlContains("employee.html"));
    }

    @FindBy(id = "email-input")
    private WebElement emailInput;

    @FindBy(id = "search-email-btn")
    private WebElement emailSubmitButton;

    @FindBy(xpath = "//body/div[2]/div[1]/form[1]/div[2]/div[1]/label[1]")
    private WebElement checkingRadioBtn;

    @FindBy(xpath = "//body/div[2]/div[1]/form[1]/div[2]/div[1]/label[2]")
    private WebElement savingRadioBtn;

    @FindBy(id = "submit-btn")
    private WebElement addAccountButton;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement firstAccount;

    @FindBy(id = "back-btn")
    private WebElement trxBackButton;

    @FindBy(id = "transfer-sending-id")
    private WebElement transferSendingIdDropdown;

    @FindBy(id = "transfer-receiving-id")
    private WebElement transferReceivingIdDropdown;

    @FindBy(id = "transfer-amount-dollars")
    private WebElement transferAmount;

    @FindBy(id = "submit-transfer-btn")
    private WebElement transferAmountButton;

    @FindBy(id = "link-account-id")
    private WebElement linkAccountInput;

    @FindBy(id = "link-btn")
    private WebElement linkButton;

    @FindBy(id = "unlink-account-id")
    private WebElement unlinkAccountDropdown;

    @FindBy(id = "unlink-btn")
    private WebElement unlinkButton;

    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    public void typeEmail(String email){

        emailInput.sendKeys();
    }

    public void clickEmailSearch(){
        emailSubmitButton.click();
    }

    public void clickCheckingButton(){
        checkingRadioBtn.click();
    }

    public void clickSavingsButton(){
        savingRadioBtn.click();
    }

    public void clickAddAccountButton(){
        addAccountButton.click();
    }

    public void clickFirstAccount(){
        firstAccount.click();
    }
    public void clickBackOnTrx(){
        trxBackButton.click();
    }
//    public void selectSendingId(){
//        transferSendingIdDropdown.click();
//    }
//    public void selectRecevingId(){
//        transferReceivingIdDropdown.click();
//    }
    public void typeAmountForTransfer(String amount){
        transferAmount.sendKeys(amount);
    }
    public void clickTransferButton(){
        transferAmountButton.click();
    }
    public void typeLinkAccount(String linkAccountId){
        linkAccountInput.sendKeys(linkAccountId);
    }
    public void clickLinkAccountButton(){
        linkButton.click();
    }
//    public void selectUnlinkAccount(){
//        unlinkAccountDropdown.click();
//    }
    public void clickUnlinkAccount(){
        unlinkButton.click();
    }
    public void clickLogoutButton(){
        logoutButton.click();
    }


}
