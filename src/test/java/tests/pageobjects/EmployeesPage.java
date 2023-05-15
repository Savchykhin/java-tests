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

    public String testName = "Employee Test Name";
    public String testPhone = "123456789";

    public By pageHeader = By.xpath("//h1[text()='Employee CRUD Application']");
    public By newEmployeeBtn = By.xpath("//a[text()='Add New Employee']");
    public By employeeDeleteBtn = By.xpath("//a[text()='Delete']");
    public By searchInput = By.cssSelector("input[type=\"search\"]");
    public By testEmployeeEntry = By.xpath(String.format("//td[contains(text(),\"%s\")]", testName));
    public By employeesTable = By.id("data");
    public By employeesTableRow = By.tagName("tr");

    public void deleteEmployee() {
        driver.get("http://localhost:8000/employees.html");
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        WebElement searchInput = wait
                .until(ExpectedConditions.visibilityOfElementLocated(this.searchInput));
        searchInput.sendKeys(this.testName);
        driver.findElement(this.employeeDeleteBtn).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void verifyOnEmployeesPage() {
        Assertions.assertThat(driver.findElement(this.pageHeader).isDisplayed())
                .as("employeesPage.pageHeader is not visible.").isTrue();
    }

    public void searchByEmployeesName(String testName) {
        driver.findElement(this.searchInput).sendKeys(testName);
        Assertions.assertThat(driver.findElement(this.testEmployeeEntry).isDisplayed()).isTrue();
        WebElement tableElement = driver.findElement(this.employeesTable);
        int rowCount = tableElement.findElements(this.employeesTableRow).size();
        Assertions.assertThat(rowCount).isEqualTo(1).as("Table does not contain one row.");
    }


    
}
