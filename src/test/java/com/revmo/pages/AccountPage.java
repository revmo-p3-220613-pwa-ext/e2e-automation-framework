package com.revmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revmo.testrunner.TestRunner.driver;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wdw;

    private String originalBalance;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/p[2]")
    private WebElement userFirstAndLastName;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/p[2]")
    private WebElement userAccountNumber;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/span[1]")
    private WebElement accountType;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/span[1]")
    private WebElement accountBalance;

    @FindBy(id = "transfer-receiving-id")
    private WebElement transferIdDropdown;

    @FindBy(id = "transfer-amount-dollars")
    private WebElement transferAmountInput;

    @FindBy(id = "submit-transfer-btn")
    private WebElement submitTransferButton;

    @FindBy(xpath = "/html[1]/body[1]/nav[1]/div[2]/div[2]/div[1]/a[2]")
    private WebElement logoutButton;

    @FindBy(id = "my-account")
    private WebElement userPageButton;

    public AccountPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        UserPage userPage = new UserPage(driver);
        userPage.clickAccount1();
        PageFactory.initElements(driver, this);
        this.originalBalance = getAccountBalance();
    }

    public String getUserFirstAndLastName(){
        return userFirstAndLastName.getText();
    }

    public String getUserAccountNumber(){
        return userAccountNumber.getText();
    }

    public String getAccountType(){
        return accountType.getText();
    }

    public String getAccountBalance() throws InterruptedException {
        wdw.until(ExpectedConditions.visibilityOf(accountBalance));
        Thread.sleep(500);
        return accountBalance.getText();
    }

    public String getOriginalBalance(){
        return originalBalance;
    }
    public void selectTransferIdDropdown(int account) throws InterruptedException {
        transferIdDropdown.click();
        Thread.sleep(200);
        Select se = new Select(transferIdDropdown);
        se.selectByIndex(account);
    }

    public void typeAmountInput(String amount){
        transferAmountInput.sendKeys(amount);
    }

    public void clickSubmitTransferButton(){
        submitTransferButton.click();
    }

    public void clickLogoutButton() throws InterruptedException {
        driver.manage().window().maximize();
        wdw.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();

    }

    public void clickUserPageButton() throws InterruptedException {
        driver.manage().window().maximize();
        wdw.until(ExpectedConditions.visibilityOf(userPageButton));
        userPageButton.click();
    }

}
