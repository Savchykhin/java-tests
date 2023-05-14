package tests.pageobjects;

import org.openqa.selenium.By;

public class EmployeesCreationForm {
    public By newEmployeeForm = By.id("emp");
    public By departmentSelect = By.id("sel-dept");
    public By nameInput = By.id("name");
    public By phoneInput = By.id("phone");
    public By marketingOption = By.xpath("//option[text()='Marketing']");
    public By saveButton = By.id("save");
}
