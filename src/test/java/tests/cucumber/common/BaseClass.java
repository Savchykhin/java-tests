package tests.cucumber.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    protected WebDriver driver;

    protected void setupDriver() {
        System.out.println("Open browser");
        System.setProperty("webdriver.gecko.driver","/path/to/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8000");
    }

	protected void teardown() {
		System.out.println("Close browser");
		driver.quit();
	}
}
