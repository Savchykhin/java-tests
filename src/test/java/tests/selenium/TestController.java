package tests.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TestController {

    WebDriver driver;

    @AfterTest
    public void closeDriver() {
        driver.close();
    }

}

