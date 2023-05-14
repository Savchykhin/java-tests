package tests.selenium;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import tests.pageobjects.HomePage;

public class HomePageTest extends TestController {
    HomePage homePage = new HomePage();

    @Test
    public void homePage() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Employee CRUD");
        Assertions.assertThat(driver.findElement(homePage.homePageHeader).getText())
                .isEqualTo("Welcome, Sample App");
    }

}
