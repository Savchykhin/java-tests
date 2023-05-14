package tests.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestController {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
         //Optional, setup firefox driver
         System.setProperty("webdriver.gecko.driver","/Users/alex/Downloads/employee-crud/bin/geckodriver");
         driver = new FirefoxDriver();
         driver.get("http://localhost:8000");
    }


    @AfterTest
    public void closeDriver() {
        driver.close();
    }

}

