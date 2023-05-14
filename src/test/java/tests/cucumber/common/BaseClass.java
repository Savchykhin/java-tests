package tests.cucumber.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    protected WebDriver driver;

    protected void setup() {
        System.out.println("Open browser");
        System.setProperty("webdriver.gecko.driver","/Users/alex/Downloads/employee-crud/bin/geckodriver");
        driver = new FirefoxDriver();
    }

	protected void teardown() {
		System.out.println("Close browser");
		driver.quit();
	}
}
