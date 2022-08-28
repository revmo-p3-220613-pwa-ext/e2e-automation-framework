package com.revmo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revmo.testrunner.TestRunner.driver;

public class EmployeePage {

    private WebDriver driver;

    public WebDriverWait wdw;

    public EmployeePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("jd800@a.ca");
        loginPage.typePassword("Password123!");
        loginPage.clickLogin();
        wdw.until(ExpectedConditions.urlContains("employee.html"));
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
    private WebElement emailInput;

    @FindBy(id = "search-email-btn")
    private WebElement emailSubmitButton;

    @FindBy(xpath = "//body/div[2]/div[1]/form[1]/div[2]/div[1]/label[1]")
    private WebElement checkingRadioBtn;

    @FindBy(xpath = "//body/div[2]/div[1]/form[1]/div[2]/div[1]/label[2]")
    private WebElement savingRadioBtn;

    @FindBy(id = "submit-btn")
    private WebElement addAccountButton;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement firstAccount;

    @FindBy(id = "back-btn")
    private WebElement trxBackButton;

    @FindBy(id = "transfer-sending-id")
    private WebElement transferSendingIdDropdown;

    @FindBy(id = "transfer-receiving-id")
    private WebElement transferReceivingIdDropdown;

    @FindBy(id = "transfer-amount-dollars")
    private WebElement transferAmount;

    @FindBy(id = "submit-transfer-btn")
    private WebElement transferAmountButton;

    @FindBy(id = "link-account-id")
    private WebElement linkAccountInput;

    @FindBy(id = "link-btn")
    private WebElement linkButton;

    @FindBy(id = "unlink-account-id")
    private WebElement unlinkAccountDropdown;

    @FindBy(id = "unlink-btn")
    private WebElement unlinkButton;

    @FindBy(xpath = "/html[1]/body[1]/nav[1]/div[2]/div[2]/div[1]/a[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/h2[1]")
    private WebElement accountTitle;

    public void typeEmail(String email){

        emailInput.sendKeys(email);
    }

    public void clickEmailSearch(){
        wdw.until(ExpectedConditions.elementToBeClickable(emailSubmitButton));
        emailSubmitButton.click();
    }

    public void clickCheckingButton(){
        wdw.until(ExpectedConditions.elementToBeClickable(checkingRadioBtn));
        checkingRadioBtn.click();
    }

    public void clickSavingsButton(){
        wdw.until(ExpectedConditions.elementToBeClickable(savingRadioBtn));
        savingRadioBtn.click();
    }

    public void clickAddAccountButton(){
        wdw.until(ExpectedConditions.elementToBeClickable(addAccountButton));
        addAccountButton.click();
    }

    public void clickFirstAccount(){
        wdw.until(ExpectedConditions.elementToBeClickable(firstAccount));
        firstAccount.click();
    }
    public void clickBackOnTrx(){
        wdw.until(ExpectedConditions.elementToBeClickable(trxBackButton));
        trxBackButton.click();
    }
//    public void selectSendingId(){
//        transferSendingIdDropdown.click();
//    }
//    public void selectRecevingId(){
//        transferReceivingIdDropdown.click();
//    }
    public void typeAmountForTransfer(String amount){
        wdw.until(ExpectedConditions.visibilityOf(transferAmount));
        transferAmount.sendKeys(amount);
    }
    public void clickTransferButton(){
        wdw.until(ExpectedConditions.elementToBeClickable(transferAmountButton));
        transferAmountButton.click();
    }
    public void typeLinkAccount(String linkAccountId){
        wdw.until(ExpectedConditions.visibilityOf(linkAccountInput));
        linkAccountInput.sendKeys(linkAccountId);
    }
    public void clickLinkAccountButton(){
        wdw.until(ExpectedConditions.elementToBeClickable(linkButton));
        linkButton.click();
    }
    public void selectUnlinkAccount(int id) throws InterruptedException {
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        wdw.until(ExpectedConditions.elementToBeClickable(unlinkAccountDropdown));
        unlinkAccountDropdown.click();
        Thread.sleep(200);
        Select se = new Select(unlinkAccountDropdown);
//        wdw.until(ExpectedConditions.elementToBeSelected(unlinkAccountDropdown.isSelected()));
        se.selectByIndex(id);
    }
    public void clickUnlinkAccount(){
        wdw.until(ExpectedConditions.elementToBeClickable(unlinkButton));
        unlinkButton.click();
    }
    public void clickLogoutButton() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(500);
        wdw.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }
    public String getAccountTitle(){
        wdw.until(ExpectedConditions.visibilityOf(accountTitle));
        return accountTitle.getText();
    }

}
