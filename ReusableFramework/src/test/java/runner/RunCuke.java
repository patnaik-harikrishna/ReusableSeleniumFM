package runner;

import java.io.File;


//import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import setup.TestSetUp;
import utils.Constants;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:target/json/output.json"},
		features = {"src/test/resources/features/DegreesProgramsTitleVerify.feature"}, 
		glue = {"steps"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome=true
		//tags = "@Used-Search-Cars_Positive"
		)


public class RunCuke extends AbstractTestNGCucumberTests{
	
	@BeforeClass
	@Parameters({ "mobiledevice" })
	public void devicePreCheck(String device) {
		System.out.println("Device status is :" +device);
		System.out.println("Device status before updating..." +TestSetUp.deviceCheck);
		TestSetUp.deviceCheck=device;
	}
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows-8");
        Reporter.setTestRunnerOutput("Sample test runner output message");
		//Reporter.loadXMLConfig(new File("D:\\AutomationProjects\\CucumberPageObjects\\src\\test\\resources\\extent-config.xml"));
	}
}
