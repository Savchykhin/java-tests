package tests.selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class HomePageTest extends TestController {

    @Test
    public void homePage() {
        //Optional, setup firefox driver
        //System.setProperty("webdriver.gecko.driver","/path/to/webdriver");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8000");

        Assertions.assertThat(driver.getTitle()).isEqualTo("Employee CRUD");
        Assertions.assertThat(driver.findElement(By.cssSelector(".navbar-header > h1")).getText())
                .isEqualTo("Welcome, Sample App");

    }

}
