package tests.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:cucumber/features/"},
        glue = {"classpath:tests.cucumber.stepsdefinition"}
        )
public class CucumberFeaturesRunner extends AbstractTestNGCucumberTests {
}
