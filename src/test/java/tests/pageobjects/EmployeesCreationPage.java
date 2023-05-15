package tests.pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;

public class EmployeesCreationPage {

    WebDriver driver;
    private HomePage homePage;
    private EmployeesPage employeesPage;

    @FindBy(id = "emp")
    WebElement newEmployeeForm;

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "sel-dept")
    WebElement departmentSelect;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(id = "save")
    WebElement saveButton;

    @FindBy(xpath = "//option[text()='Marketing']")
    WebElement marketingOption;

    public EmployeesCreationPage(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        employeesPage = new EmployeesPage(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        homePage.employeesNavButton.click();
        Assertions.assertThat(employeesPage.pageHeader.isDisplayed())
                .as("employeesPage.pageHeader is not visible.").isTrue();
        employeesPage.newEmployeeBtn.click();
        Assertions.assertThat(newEmployeeForm.isDisplayed())
                .as("employeesPage.newEmployeeForm is not visible.").isTrue();
    }

    public void selectEmployeeDepartment(String department) {
        WebElement departmentSelectEl = departmentSelect;
        Select departmentSelect = new Select(departmentSelectEl);
        departmentSelect.selectByVisibleText(department);
    }

    public void enterEmployeeName(String testName) {
        nameInput.sendKeys(testName);
    }

    public void enterEmployeePhone(String testPhone) {
        phoneInput.sendKeys(testPhone);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
