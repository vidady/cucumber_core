package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/functionalTests",
 glue = {"stepDefinitions"},
 plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
 dryRun=false
 )
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("D:\\Personal\\cucumber\\cucumber_core\\configs\\extent-config.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "AJ");
	Reporter.setSystemInfo("Application Name", "Test App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
}

