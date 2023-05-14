package tests.cucumber.stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tests.cucumber.common.BaseClass;
import tests.pageobjects.HomePage;

import org.assertj.core.api.Assertions;

public class HomePageDefinitions extends BaseClass {

    HomePage homePage = new HomePage();

    @Before
    public void setup() {
       super.setup();
    }

    @Given("Home-page: open")
    public void home_page() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Employee CRUD");
    }

    @Then("Home-page: verify")
    public void verify_home_page() {
        Assertions.assertThat(driver.findElement(homePage.homePageHeader).getText())
                .isEqualTo("Welcome, Sample App");
                //to do verify nav bar and buttons 
    }

    @After
    public void teardown() {
       super.teardown();
    }

}
