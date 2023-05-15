package tests.pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EmployeesCreationPage {

    WebDriver driver;
    private HomePage homePage;
    private EmployeesPage employeesPage;

    public EmployeesCreationPage(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        employeesPage = new EmployeesPage(driver);
    }

    public By newEmployeeForm = By.id("emp");
    public By departmentSelect = By.id("sel-dept");
    public By nameInput = By.id("name");
    public By phoneInput = By.id("phone");
    public By marketingOption = By.xpath("//option[text()='Marketing']");
    public By saveButton = By.id("save");

    public void navigate() {
        driver.findElement(homePage.employeesNavButton).click();
        Assertions.assertThat(driver.findElement(employeesPage.pageHeader).isDisplayed())
                .as("employeesPage.pageHeader is not visible.").isTrue();
        driver.findElement(employeesPage.newEmployeeBtn).click();
        Assertions.assertThat(driver.findElement(this.newEmployeeForm).isDisplayed())
                .as("employeesPage.newEmployeeForm is not visible.").isTrue();
    }

    public void selectEmployeeDepartment(String department) {
        WebElement departmentSelectEl = driver.findElement(this.departmentSelect);
        Select departmentSelect = new Select(departmentSelectEl);
        departmentSelect.selectByVisibleText(department);
    }

    public void enterEmployeeName(String testName) {
        driver.findElement(this.nameInput).sendKeys(testName);
    }

    public void enterEmployeePhone(String testPhone) {
        driver.findElement(this.phoneInput).sendKeys(testPhone);
    }

    public void clickSaveButton() {
        driver.findElement(this.saveButton).click();
    }
}
