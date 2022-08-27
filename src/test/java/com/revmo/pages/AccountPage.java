package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wdw;

    @FindBy(id="request-transfer")
    private WebElement requestTransferButton;

    @FindBy(id="send-money")
    private WebElement sendMoneyButton;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void sendMoney() {
        sendMoneyButton.click();
    }

    public void requestMoney() {
        requestTransferButton.click();
    }
}
