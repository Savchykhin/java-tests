package tests.cucumber.stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tests.cucumber.common.BaseClass;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class HomePageDefinitions extends BaseClass {

    @Before
    public void setup() {
       super.setup();
    }

    @Given("Home-page: open")
    public void home_page() {
        driver.get("http://localhost:8000");
    }

    @Then("Home-page: verify")
    public void verify_home_page() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Employee CRUD");
        Assertions.assertThat(driver.findElement(By.cssSelector(".navbar-header > h1")).getText())
                .isEqualTo("Welcome, Sample App");
    }

    @After
    public void teardown() {
       super.teardown();
    }

}
