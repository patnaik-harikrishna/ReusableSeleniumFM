/**
 ******************************************************************************
 * 							  REUSABLE FRAMEWORK
 *  							CONFIDENTIAL
 *							COPYRIGHTS TO CLOUDTERN
 *							
 * *****************************************************************************
 */

package setup;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.Constants;
import utils.DriverFactory;
import utils.DriverManager;
import utils.ExcelReader;
import utils.ExtentManager;

public class TestSetUp {
	
	private WebDriver driver;
	public static Properties configProperty;
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	public static ThreadLocal<ExtentTest> testCaseLogger = new ThreadLocal<>();
	public static Logger appLogs=Logger.getLogger(TestSetUp.class.getName());
	public static boolean isInitialized=false;
	public static String deviceCheck="false";
	
	public static ExcelReader excel = null;
	
	public static ExcelReader excel1 = null;

	@BeforeSuite
	public synchronized void beforeSuite() throws IOException {
		initialize();
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		/* Before Test code comes here. */
		initialize();
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		/* Extent Reporting */
		initialize();
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		parentTest.set(parent);
	}
	
	@BeforeMethod
	public synchronized void beforeMethod(Method method) throws IOException {
		appLogs.info("Starting exection of test case: " + method.getName());
		System.out.println("Starting exection of test case: " + method.getName());
		//WebDriver driver = DriverManager.getDriver();
		if (driver == null) {
			
			DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		extent.flush();
		DriverFactory.destroyDriver();
		}

	@AfterClass
	public void afterClass() {
		/* After Class code comes here. */
	}

	@AfterTest
	public void afterTest() {
		/* After Test code comes here. */
		//DriverFactory.closeDriver();
	}

	@AfterSuite
	public void afterSuite() {
		/* After Suite code comes here. */
	}
	
	public static void initialize() throws IOException{
		//logs
		if(!isInitialized)
		{
			FileInputStream fi=null;
			try {
				fi = new FileInputStream(new File(
						System.getProperty(Constants.ROOT_DIR) + "\\src\\test\\resources\\PropertyFiles\\config.properties"));

				configProperty = new Properties();
					configProperty.load(fi);
				
			} catch (FileNotFoundException e) {
				appLogs.error("config.properties file is not found. "+e);
				
			}
			finally {
			    if (fi!=null) {
			        fi.close();
			        extent = ExtentManager.getExtent();

			    }
			}
			
			excel = new ExcelReader(
					System.getProperty(Constants.ROOT_DIR) + "\\src\\test\\resources\\testData\\simple.xlsx");
			excel1 = new ExcelReader(
					System.getProperty(Constants.ROOT_DIR) + "\\src\\test\\resources\\testData\\simple1.xlsx");
		}
	}
	
	public void assignAuthor(String authorName) {
		testCaseLogger.get().assignAuthor(authorName);
	}
	
	public void assignCategory(String category) {
		testCaseLogger.get().assignCategory(category);
	}
		
	
	  public void navigateToBaseURL(){
	  DriverManager.getDriver().navigate().to(configProperty.getProperty("url")); }
	 
	public void navigateToURL(String url){
		DriverManager.getDriver().navigate().to(url);
	 }
	
	/*
	 * public void setUpBrowser() throws MalformedURLException{
	 * appLogs.info("Checking browser setup "); //driver = null;
	 * 
	 * if (driver == null) { driver =
	 * DriverFactory.createDriverInstance(configProperty.getProperty("browser")); }
	 * }
	 */
}
