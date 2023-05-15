package tests.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import tests.pageobjects.EmployeesCreationPage;
import tests.pageobjects.EmployeesPage;
import tests.pageobjects.HomePage;

public class TestController {
    protected WebDriver driver;
    protected EmployeesPage employeesPage;
    protected EmployeesCreationPage employeesCreationPage;
    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
         System.setProperty("webdriver.gecko.driver","/Users/alex/Downloads/employee-crud/bin/geckodriver");
         driver = new FirefoxDriver();
         driver.get("http://localhost:8000");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.close();
    }
}

