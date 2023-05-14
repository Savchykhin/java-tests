package tests.cucumber.stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyStepdefs {

    WebDriver driver;

    @Given("Home-page: open")
    public void home_page() {
        //Optional, setup firefox driver
        //System.setProperty("webdriver.gecko.driver","/path/to/webdriver");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8000");
    }

    @Then("Home-page: verify")
    public void verify_home_page() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Employee CRUD");
        Assertions.assertThat(driver.findElement(By.cssSelector(".navbar-header > h1")).getText())
                .isEqualTo("Welcome, Sample App");
    }

    @Then("Home-page: close")
    public void close_home_page() {
        driver.close();
    }

}
