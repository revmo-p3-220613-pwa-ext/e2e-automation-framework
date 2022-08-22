package com.revature.pages;

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

    @FindBy(id="view-account-1")
    private WebElement account1;

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

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void getHello() {
        wdw.until(ExpectedConditions.urlContains("user-page"));
        hello.getText();
    }

    public void clickEditUserInfoButton() {
        editUserInfoButton.click();
    }

}
