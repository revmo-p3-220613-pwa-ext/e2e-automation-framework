package com.revmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PendingTransactionPage {

    private WebDriver driver;
    private WebDriverWait wdw;


    public PendingTransactionPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        UserPage userPage = new UserPage(driver);
        userPage.clickPendingTransactionsButton();
        wdw.until(ExpectedConditions.urlContains("pending-transactions.html"));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/button[1]")
    private WebElement approveFirstRequestButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/button[2]")
    private WebElement denyFirstRequestButton;

    @FindBy(id = "my-account")
    private WebElement userPageButton;

    @FindBy(id = "logut-btn")
    private WebElement logoutButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    private WebElement statusAndBalanceOfFirstAccount;

    public void clickFirstApproveButton(){
        approveFirstRequestButton.click();
    }

    public void clickDenyFirstRequestButton(){
        denyFirstRequestButton.click();
    }

    public void clickUserPageButton(){
        userPageButton.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public String getStatusAndBalanceofFirstAccount(){
        return statusAndBalanceOfFirstAccount.getText();
    }


}
