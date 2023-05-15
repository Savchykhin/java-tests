package tests.selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.pageobjects.EmployeesCreationPage;
import tests.pageobjects.EmployeesPage;

public class EmployeeSearchTest extends TestController {
    private EmployeesPage employeesPage;
    private EmployeesCreationPage employeesCreationPage;
    private String testName = "Search Test Name";
    private String testPhone = "999-566-9999";
    private String department = "Legal";

    @BeforeClass
    public void init() {
        employeesPage = new EmployeesPage(driver);
        employeesCreationPage = new EmployeesCreationPage(driver);
    }

    @BeforeClass(dependsOnMethods = { "init" })
    public void createEmployee() {
        employeesCreationPage.navigate();
        employeesCreationPage.selectEmployeeDepartment(department);
        employeesCreationPage.enterEmployeeName(testName);
        employeesCreationPage.enterEmployeePhone(testPhone);
        employeesCreationPage.clickSaveButton();
        employeesPage.navigate();
    }

    @Test
    public void searchEmployeeByPhone() {
        employeesPage.typeInSearchField(testPhone);
        employeesPage.validateSearchResults(testPhone);
        employeesPage.validateEntriesCount(1);
    }

    @Test
    public void searchEmployeeByDept() {
        employeesPage.typeInSearchField(department);
        employeesPage.validateSearchResults(department);
        employeesPage.validateEntriesCount(4);
    }

    @Test
    public void searchEmployeeByName() {
        employeesPage.typeInSearchField(testName);
        employeesPage.validateSearchResults(testName);
        employeesPage.validateEntriesCount(1);
    }

    @AfterClass
    public void cleanupEmployees() {
        employeesPage.deleteEmployee(testName);
    }

}
