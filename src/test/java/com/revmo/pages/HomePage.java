package com.revmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.revmo.testrunner.TestRunner.url;
import static com.revmo.testrunner.TestRunner.driver;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wdw;

    @FindBy(id="burger")
    private WebElement burger;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/button[1]")
    private WebElement loginButton;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/p[1]/input[1]")
    private WebElement emailInput;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/p[1]/input[1]")
    private WebElement passwordInput;
    @FindBy(xpath = "//strong[contains(text(),'Log in')]")
    private WebElement navbarLoginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get(url+"/index.html");
        PageFactory.initElements(driver, this);
    }

    public void clickBurger() {
        burger.click();
    }

    public void clickLogin() {
//        wdw.until(ExpectedConditions.presenceOfElementLocated(By.id("login-btn")));
        loginButton.click();
    }
    public void clickNavbarLoginButton() throws InterruptedException {
        Thread.sleep(800);
        navbarLoginButton.click();
    }
    public void typeEmail(String email){
        emailInput.sendKeys(email);
    }
    public void typePassword(String password){
        passwordInput.sendKeys(password);
    }

}
