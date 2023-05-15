package tests.selenium;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.pageobjects.HomePage;

public class HomePageTest extends TestController {

    private HomePage homePage;

    @BeforeClass
    public void init() {
        homePage = new HomePage(driver);
    }

    @Test
    public void homePage() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Employee CRUD");
        Assertions.assertThat(homePage.getHomePageHeaderText())
                .isEqualTo("Welcome, Sample App");
    }

}
