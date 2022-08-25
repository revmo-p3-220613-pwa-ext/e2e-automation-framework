package com.revature.pages;

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
        HomePage homePage = new HomePage(driver);
        homePage.clickBurger();
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail("jd80@a.ca");
        loginPage.typePassword("Password123!");
        loginPage.clickLoginButton();
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

}
