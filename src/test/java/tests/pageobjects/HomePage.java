package tests.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//div[text()='Employees']")
    WebElement employeesNavButton;

    @FindBy(css = ".navbar-header > h1")
    WebElement homePageHeader;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageHeaderText() {
        return homePageHeader.getText();
    }

}
