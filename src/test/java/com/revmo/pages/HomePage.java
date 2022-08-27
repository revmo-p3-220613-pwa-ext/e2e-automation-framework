package com.revmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wdw;

    @FindBy(id="burger")
    private WebElement burger;

    @FindBy(id="login-btn")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("http://127.0.0.1:5501/index.html");
        PageFactory.initElements(driver, this);
    }

    public void clickBurger() {
        burger.click();
    }

    public void clickLogin() {
        wdw.until(ExpectedConditions.presenceOfElementLocated(By.id("login-btn")));
        loginButton.click();
    }

}
