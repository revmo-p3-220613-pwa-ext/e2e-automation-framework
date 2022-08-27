package com.revmo.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(glue="com.revmo.steps", features={"src/test/resources/login.feature", "src/test/resources/employee.feature"})
//        plugin ={"pretty", "html: results/html", "json:results/json/results.json", "junit:results/junit/cucumber.xml"} )
public class TestRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;



    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("−−incognito");
//        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");

//        driver = new ChromeDriver(options);
    driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
