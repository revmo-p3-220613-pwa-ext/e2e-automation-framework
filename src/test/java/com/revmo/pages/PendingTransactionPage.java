package com.revmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static com.revmo.testrunner.TestRunner.driver;

public class PendingTransactionPage {

    private WebDriver driver;
    private WebDriverWait wdw;
    public String originalBalance;


    public PendingTransactionPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("jd80@a.ca");
        loginPage.typePassword("Password123!");
        loginPage.clickLogin();
        UserPage userPage = new UserPage(driver);
        userPage.clickPendingTransactionsButton();
        Thread.sleep(600);
        originalBalance = balance.getText();
    }

    @FindBy(xpath = "//tbody/tr[1]/td[5]/button[1]")
    private WebElement approveFirstRequestButton;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/button[2]")
    private WebElement denyFirstRequestButton;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    private WebElement balance;

    @FindBy(id = "my-account")
    private WebElement userPageButton;

    @FindBy(xpath = "/html[1]/body[1]/nav[1]/div[2]/div[2]/div[1]/a[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    private WebElement statusAndBalanceOfFirstAccount;

    public void clickFirstApproveButton() throws InterruptedException {
        approveFirstRequestButton.click();
        Thread.sleep(400);
    }

    public void clickDenyFirstRequestButton() throws InterruptedException {
        denyFirstRequestButton.click();
        Thread.sleep(400);

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

    public String getOriginalBalance(){
        return originalBalance;
    }
    public String getBalance(){
        return balance.getText();
    }


}
