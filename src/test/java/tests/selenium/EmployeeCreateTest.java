package tests.selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.pageobjects.EmployeesCreationPage;
import tests.pageobjects.EmployeesPage;

public class EmployeeCreateTest extends TestController {
    private EmployeesPage employeesPage;
    private EmployeesCreationPage employeesCreationPage;
    private String testName = "Employee Test Name Selenium";
    private String testPhone = "987654321";

    @BeforeClass
    public void init() {
        employeesPage = new EmployeesPage(driver);
        employeesCreationPage = new EmployeesCreationPage(driver);
    }

    @Test
    public void createEmployee() {
        employeesCreationPage.navigate();
        employeesCreationPage.selectEmployeeDepartment("Marketing");
        employeesCreationPage.enterEmployeeName(testName);
        employeesCreationPage.enterEmployeePhone(testPhone);
        employeesCreationPage.clickSaveButton();
        employeesPage.verifyOnEmployeesPage();
        employeesPage.typeInSearchField(testName);
        employeesPage.validateSearchResults(testName);
        employeesPage.validateEntriesCount(1);
    }

    @AfterClass
    public void cleanupEmployees() {
        employeesPage.deleteEmployee(testName);
    }
}
