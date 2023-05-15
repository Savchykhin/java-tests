package tests.pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeesPage {
    WebDriver driver;

    public EmployeesPage(WebDriver driver) {
        this.driver = driver;
    }

    public By pageHeader = By.xpath("//h1[text()='Employee CRUD Application']");
    public By newEmployeeBtn = By.xpath("//a[text()='Add New Employee']");
    public By employeeDeleteBtn = By.xpath("//a[text()='Delete']");
    public By searchInput = By.cssSelector("input[type=\"search\"]");
    public By employeesTable = By.id("data");
    public By employeesTableRow = By.tagName("tr");

    public void navigate() {
        driver.get("http://localhost:8000/employees.html");
        this.verifyOnEmployeesPage();
    }

    public void deleteEmployee(String testName) {
        this.navigate();
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        WebElement searchInput = wait
                .until(ExpectedConditions.visibilityOfElementLocated(this.searchInput));
        searchInput.sendKeys(testName);
        driver.findElement(this.employeeDeleteBtn).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void verifyOnEmployeesPage() {
        Assertions.assertThat(driver.findElement(this.newEmployeeBtn).isDisplayed())
                .as("Failed to navigate to Employees Page. newEmployeeBtn is not visible.").isTrue();
    }

    public void typeInSearchField(String searchValue) {
        WebElement searchInput = driver.findElement(this.searchInput);
        searchInput.clear();
        searchInput.sendKeys(searchValue);
    }

    public void validateSearchResults(String searchValue) {
        WebElement testEmployeeEntry = driver.findElement(By.xpath(String.format("//td[contains(text(),\"%s\")]", searchValue)));
        Assertions.assertThat(testEmployeeEntry.isDisplayed()).isTrue();
    }

    public void validateEntriesCount(int size) {
        WebElement tableElement = driver.findElement(this.employeesTable);
        int rowCount = tableElement.findElements(this.employeesTableRow).size();
        Assertions.assertThat(rowCount).isEqualTo(size).as(String.format("Table does not contain %d number of rows.", size));
    }
}
