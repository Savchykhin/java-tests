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

public class CreateEmployeeDef extends BaseClass {

    private EmployeesPage employeesPage;
    private EmployeesCreationPage employeesCreationPage;
    private String testName = "Employee Test Name";
    private String testPhone = "123-456-7891";

    @Before(value = "@createEmployeeScenario")
    public void setup() {
        super.setupDriver();
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
        employeesCreationPage.enterEmployeeName(testName);
    }

    @And("I enter the employee phone")
    public void enterEmployeePhone() {
        employeesCreationPage.enterEmployeePhone(testPhone);
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
        employeesPage.typeInSearchField(testName);
        employeesPage.validateSearchResults(testName);
        employeesPage.validateEntriesCount(1);
    }

    @After(value = "@createEmployeeScenario")
    public void cleanupEmployees() {
        employeesPage.deleteEmployee(testName);
        super.teardown();
    }
}
