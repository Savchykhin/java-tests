package tests.cucumber.stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import tests.cucumber.common.BaseClass;
import tests.pageobjects.EmployeesCreationForm;
import tests.pageobjects.EmployeesPage;
import tests.pageobjects.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EmployeesPageDefinitions extends BaseClass {

    EmployeesPage employeesPage = new EmployeesPage();
    EmployeesCreationForm employeesCreationForm = new EmployeesCreationForm();
    HomePage homePage = new HomePage();

    @Before
    public void setup() {
        super.setup();
    }

    @Given("I am on the employee creation page")
    public void navigateToEmployeeCreationPage() {
        driver.findElement(homePage.employeesNavButton).click();
        Assertions.assertThat(driver.findElement(employeesPage.pageHeader).isDisplayed())
                .as("employeesPage.pageHeader is not visible.").isTrue();
        driver.findElement(employeesPage.newEmployeeBtn).click();
        Assertions.assertThat(driver.findElement(employeesCreationForm.newEmployeeForm).isDisplayed())
                .as("employeesPage.newEmployeeForm is not visible.").isTrue();
    }

    @When("I select employee department")
    public void selectEmployeeDepartment() {
        WebElement departmentSelectEl = driver.findElement(employeesCreationForm.departmentSelect);
        Select departmentSelect = new Select(departmentSelectEl);
        departmentSelect.selectByVisibleText("Marketing");
        String selectedOption = departmentSelectEl.getAttribute("value");
        assert selectedOption.equals("4") : "Option 'Marketing' is not selected.";
    }

    @And("I enter the employee name")
    public void enterEmployeeName() {
        driver.findElement(employeesCreationForm.nameInput).sendKeys(employeesPage.testName);
    }

    @And("I enter the employee phone")
    public void enterEmployeePhone() {
        driver.findElement(employeesCreationForm.phoneInput).sendKeys(employeesPage.testPhone);
    }

    @And("I click on the save button")
    public void clickSaveButton() {
        driver.findElement(employeesCreationForm.saveButton).click();
    }

    @Then("I am redirected to Employees page")
    public void verifyRedirectionToEmployeesPage() {
        Assertions.assertThat(driver.findElement(employeesPage.pageHeader).isDisplayed())
                .as("employeesPage.pageHeader is not visible.").isTrue();
    }

    @And("I am able to search by new employee's name in the table")
    public void verifyEmployeeDetailsDisplayed() {
        driver.findElement(employeesPage.searchInput).sendKeys(employeesPage.testName);
        Assertions.assertThat(driver.findElement(employeesPage.testEmployeeEntry).isDisplayed()).isTrue();
        WebElement tableElement = driver.findElement(employeesPage.employeesTable);
        int rowCount = tableElement.findElements(employeesPage.employeesTableRow).size();
        Assertions.assertThat(rowCount).isEqualTo(1).as("Table does not contain one row.");
    }

    @After(value = "@createEmployee", order = 1)
    public void cleanupEmployees(Scenario scenario) {
        driver.get("http://localhost:8000/employees.html");
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        WebElement searchInput = wait
                .until(ExpectedConditions.visibilityOfElementLocated(employeesPage.searchInput));
        searchInput.sendKeys(employeesPage.testName);
        driver.findElement(employeesPage.employeeDeleteBtn).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    @After(order = 0)
    public void teardown() {
        super.teardown();
    }
}
