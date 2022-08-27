package com.revmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IncomePage {
    private WebDriver driver;
    private WebDriverWait wdw;

    public IncomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        UserPage userPage = new UserPage(driver);
        userPage.clickAllIncomeButton();
        wdw.until(ExpectedConditions.urlContains("income.html"));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "months-to-display")
    private WebElement monthsToDisplayInput;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(xpath = "//body/div[1]/div[2]/h2[1]/span[1]")
    private WebElement firstAccountDisplayed;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/p[1]")
    private WebElement firstAccountDisplayedYear;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")
    private WebElement firstAccountDisplayedMonth;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]")
    private WebElement firstAccountDisplayedIncomeAmount;

    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    @FindBy(id = "my-account")
    private WebElement userPageButton;


    public void typeMonthToDisplay(String months){
        monthsToDisplayInput.sendKeys(months);
    }

    public void clickRefreshButton(){
        refreshButton.click();
    }

    public String getFirstAccountNumber(){
        return firstAccountDisplayed.getText();
    }

    public String getFirstAccountDisplayedYear(){
        return firstAccountDisplayedYear.getText();
    }

    public String getFirstAccountDisplayedMonth(){
       return firstAccountDisplayedMonth.getText();
    }

    public String getFirstAccountDisplayedIncomeAmount(){
        return firstAccountDisplayedIncomeAmount.getText();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public void clickUserPageButton(){
        userPageButton.click();
    }

}
