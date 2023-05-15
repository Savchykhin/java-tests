package tests.cucumber.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:cucumber/features/" }, glue = { "classpath:tests.cucumber.stepsdefinition" })
public class CucumberFeaturesRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
