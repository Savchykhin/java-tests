package tests.pageobjects;

import org.openqa.selenium.By;

public class EmployeesPage {

    public String testName = "Employee Test Name";
    public String testPhone = "123456789";

    public By pageHeader = By.xpath("//h1[text()='Employee CRUD Application']");
    public By newEmployeeBtn = By.xpath("//a[text()='Add New Employee']");
    public By employeeDeleteBtn = By.xpath("//a[text()='Delete']");
    public By searchInput = By.cssSelector("input[type=\"search\"]");
    public By testEmployeeEntry = By.xpath(String.format("//td[contains(text(),\"%s\")]", testName));
    public By employeesTable = By.id("data");
    public By employeesTableRow = By.tagName("tr");
    
}
