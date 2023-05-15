package tests.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public By homePageHeader = By.cssSelector(".navbar-header > h1");
    public By employeesNavButton = By.xpath("//div[text()='Employees']");
}
