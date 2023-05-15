package tests.pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeesPage {
    WebDriver driver;

    @FindBy(id = "data")
    WebElement employeesTable;

    @FindBy(xpath = "//a[text()='Add New Employee']")
    WebElement newEmployeeBtn;

    @FindBy(xpath = "//a[text()='Delete']")
    WebElement employeeDeleteBtn;

    @FindBy(xpath = "//h1[text()='Employee CRUD Application']")
    WebElement pageHeader;

    @FindBy(css = "input[type=\"search\"]")
    WebElement searchInput;

    public EmployeesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.get("http://localhost:8000/employees.html");
        this.verifyOnEmployeesPage();
    }

    public void deleteEmployee(String testName) {
        this.navigate();
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(testName);
        employeeDeleteBtn.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void verifyOnEmployeesPage() {
        Assertions.assertThat(newEmployeeBtn.isDisplayed())
                .as("Failed to navigate to Employees Page. newEmployeeBtn is not visible.").isTrue();
    }

    public void typeInSearchField(String searchValue) {
        searchInput.clear();
        searchInput.sendKeys(searchValue);
    }

    public void validateSearchResults(String searchValue) {
        WebElement testEmployeeEntry = driver.findElement(By.xpath(String.format("//td[contains(text(),\"%s\")]", searchValue)));
        Assertions.assertThat(testEmployeeEntry.isDisplayed()).isTrue();
    }

    public void validateEntriesCount(int size) {
        int rowCount = employeesTable.findElements(By.tagName("tr")).size();
        Assertions.assertThat(rowCount).isEqualTo(size).as(String.format("Table does not contain %d number of rows.", size));
    }
}
