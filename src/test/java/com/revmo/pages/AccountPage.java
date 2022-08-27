package com.revmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wdw;

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

    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    @FindBy(id = "my-account")
    private WebElement userPageButton;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
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

    public String getAccountBalance(){
        return accountBalance.getText();
    }

//    public void selectTransferIdDropdown(){
//        transferIdDropdown.click();
//    }

    public void typeAmountInput(String amount){
        transferAmountInput.sendKeys(amount);
    }

    public void clickSubmitTransferButton(){
        submitTransferButton.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public void clickUserPageButton(){
        userPageButton.click();
    }

}
