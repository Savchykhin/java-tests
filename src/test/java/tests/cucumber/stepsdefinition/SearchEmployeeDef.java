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

public class SearchEmployeeDef extends BaseClass {

    private EmployeesPage employeesPage;
    private EmployeesCreationPage employeesCreationPage;
    private String testName = "Search Test Name";
    private String testPhone = "999-566-9999";
    private String department = "Legal";

    @Before(value = "@searchEmployeeScenario")
    public void setup() {
        super.setupDriver();
        employeesPage = new EmployeesPage(driver);
        employeesCreationPage = new EmployeesCreationPage(driver);
    }

    @Given("A new employee is created")
    public void createEmployee() {
        employeesCreationPage.navigate();
        employeesCreationPage.selectEmployeeDepartment(department);
        employeesCreationPage.enterEmployeeName(testName);
        employeesCreationPage.enterEmployeePhone(testPhone);
        employeesCreationPage.clickSaveButton();
    }

    @And("I am on the employees page")
    public void goToEmployeesPage() {
        employeesPage.navigate();
    }

    @When("I type new employee's phone in the search field")
    public void searchByEmployeesPhone() {
        employeesPage.typeInSearchField(testPhone);
    }

    @Then("Table results are filtered by searched employee's phone")
    public void validatePhoneSearchResults() {
        employeesPage.validateSearchResults(testPhone);
        employeesPage.validateEntriesCount(1);
    }

    @When("I type new employee's department in the search field")
    public void searchByEmployeesDepartment() {
        employeesPage.typeInSearchField(department);
    }

    @Then("Table results are filtered by searched employee's department")
    public void validateDeptSearchResults() {
        employeesPage.validateSearchResults(department);
        employeesPage.validateEntriesCount(4);
    }

    @When("I type new employee's name in the search field")
    public void searchByEmployeesName() {
        employeesPage.typeInSearchField(testName);
    }

    @Then("Table results are filtered by searched employee's name")
    public void validateNameSearchResults() {
        employeesPage.validateSearchResults(testName);
        employeesPage.validateEntriesCount(1);
    }

    @After(value = "@searchEmployeeScenario")
    public void teardown() {
        employeesPage.deleteEmployee(testName);
        super.teardown();
     }
}
