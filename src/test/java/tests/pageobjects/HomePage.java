package tests.pageobjects;
import org.openqa.selenium.By;

public class HomePage {
    public By homePageHeader = By.cssSelector(".navbar-header > h1");
    public By employeesNavButton = By.xpath("//div[text()='Employees']");
}
