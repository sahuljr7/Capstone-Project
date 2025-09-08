// Define the package for the test runner class
package runners;

// Import necessary classes from the Cucumber and TestNG libraries
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// CucumberOptions annotation is used to configure test execution
@CucumberOptions(
    // Path to the feature files
    features = "src/test/resources/features",
    
    // Package containing step definition classes
    glue = {"stepDefinitions"},
    
    // Plugins for reporting; here it generates pretty output and an HTML report
    plugin = {"pretty", "html:reports/cucumber-html-report.html"},
    
    // If set to true, it makes the console output more readable
    monochrome = true
)

// TestRunner class extends AbstractTestNGCucumberTests to integrate Cucumber with TestNG
public class TestRunner extends AbstractTestNGCucumberTests { }
