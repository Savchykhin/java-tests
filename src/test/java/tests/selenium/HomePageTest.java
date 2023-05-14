package tests.selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageTest extends TestController {

    @Test
    public void homePage() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Employee CRUD");
        Assertions.assertThat(driver.findElement(By.cssSelector(".navbar-header > h1")).getText())
                .isEqualTo("Welcome, Sample App");
    }

}
