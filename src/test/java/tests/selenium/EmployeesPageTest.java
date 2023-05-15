package tests.selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.pageobjects.EmployeesCreationPage;
import tests.pageobjects.EmployeesPage;

public class EmployeesPageTest extends TestController {
    private EmployeesPage employeesPage;
    private EmployeesCreationPage employeesCreationPage;

    @BeforeClass
    public void init() {
        employeesPage = new EmployeesPage(driver);
        employeesCreationPage = new EmployeesCreationPage(driver);
    }

    @Test
    public void createEmployee() {
        employeesCreationPage.navigate();
        employeesCreationPage.selectEmployeeDepartment("Marketing");
        employeesCreationPage.enterEmployeeName(employeesPage.testName);
        employeesCreationPage.enterEmployeePhone(employeesPage.testPhone);
        employeesCreationPage.clickSaveButton();
        employeesPage.verifyOnEmployeesPage();
        employeesPage.searchByEmployeesName(employeesPage.testName);
    }

    @AfterClass
    public void cleanupEmployees() {
        employeesPage.deleteEmployee();
    }
}
