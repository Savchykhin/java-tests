package tests.cucumber.stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.cucumber.common.BaseClass;
import tests.pageobjects.EmployeesCreationPage;
import tests.pageobjects.EmployeesPage;

public class EmployeesPageDefinitions extends BaseClass {

    private EmployeesPage employeesPage;
    private EmployeesCreationPage employeesCreationPage;

    @Before(order = 0)
    public void setup() {
        super.setup();
    }

    @Before(value = "@createEmployeeScenario", order = 1)
    public void init() {
        employeesPage = new EmployeesPage(driver);
        employeesCreationPage = new EmployeesCreationPage(driver);
    }

    @Given("I am on the employee creation page")
    public void navigateToEmployeeCreationPage() {
       employeesCreationPage.navigate();
    }

    @When("I select employee department")
    public void selectEmployeeDepartment() {
        employeesCreationPage.selectEmployeeDepartment("Marketing");
    }

    @And("I enter the employee name")
    public void enterEmployeeName() {
        employeesCreationPage.enterEmployeeName(employeesPage.testName);
    }

    @And("I enter the employee phone")
    public void enterEmployeePhone() {
        employeesCreationPage.enterEmployeePhone(employeesPage.testPhone);
    }

    @And("I click on the save button")
    public void clickSaveButton() {
       employeesCreationPage.clickSaveButton();
    }

    @Then("I am redirected to Employees page")
    public void verifyRedirectionToEmployeesPage() {
        employeesPage.verifyOnEmployeesPage();
    }

    @And("I am able to search by new employee's name in the table")
    public void searchByEmployeesName() {
        employeesPage.searchByEmployeesName(employeesPage.testName);
    }

    @After(value = "@createEmployeeScenario", order = 1)
    public void cleanupEmployees() {
       employeesPage.deleteEmployee();
    }

    @After(order = 0)
    public void teardown() {
        super.teardown();
    }
}
