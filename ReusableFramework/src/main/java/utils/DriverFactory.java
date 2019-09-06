/**
 ******************************************************************************
 * 							  REUSABLE FRAMEWORK
 *  							CONFIDENTIAL
 *							COPYRIGHTS TO CLOUDTERN
 *							
 * *****************************************************************************
 */

package utils;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.Parameters;

import java.net.URL;

import setup.TestSetUp;

public class DriverFactory {
	private static WebDriver driver;
	
	private DriverFactory(){
	}

	public static String chromeExeFilePath = System.getProperty(Constants.ROOT_DIR)+"\\drivers\\chromedriver.exe";
	public static String ieExeFilePath = System.getProperty(Constants.ROOT_DIR)+"\\drivers\\IEDriverServer.exe";
	public static String firefoxExeFilePath = System.getProperty(Constants.ROOT_DIR)+"\\drivers\\geckodriver.exe";

	  
	/**
	 * This method is a getter for chromedriver.exe file path.
	 */
	public static String getChromeExeFilePath() {
		return chromeExeFilePath;
	}

	/**
	 * This method is a setter for chromedriver.exe file path.
	 * @param chromeExeFilePath
	 */
	public static void setChromeExeFilePath(String chromeExeFilePath) {
		DriverFactory.chromeExeFilePath = chromeExeFilePath;
	}

	/**
	 * This method is a getter for IEDriverServer.exe file path.
	 */
	public static String getIeExeFilePath() {
		return ieExeFilePath;
	}

	/**
	 * This method is a setter for IEDriverServer.exe file path.
	 * @param ieExeFilePath
	 */
	public static void setIeExeFilePath(String ieExeFilePath) {
		DriverFactory.ieExeFilePath = ieExeFilePath;
	}

	/**
	 * This method is a getter for gekeodriver.exe file path.
	 */
	public static String getFirefoxExeFilePath() {
		return firefoxExeFilePath;
	}

	/**
	 * This method is a setter for gekodriver.exe file path.
	 * @param firefoxExeFilePath
	 */
	public static void setFirefoxExeFilePath(String firefoxExeFilePath) {
		DriverFactory.firefoxExeFilePath = firefoxExeFilePath;
	}
	
	/**
	 * This method is to create a driver instance for what is configured in configuration file.
	 * @param browserName
	 * @throws MalformedURLException 
	 */
	//@Parameters(value={"browser","version","platform","platformversion","appURL"})
	public static WebDriver createDriverInstance(String browserName) throws MalformedURLException
	{
		//WebDriver driver =null;
		System.out.println("checking the device status..." +TestSetUp.deviceCheck);
		if(TestSetUp.configProperty.getProperty(Constants.EXECUTION_ENV).contains("Windows")){
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", DriverFactory.getFirefoxExeFilePath());
			driver=new FirefoxDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(driver);
			DriverManager.setImplicitWait(driver);
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeExeFilePath());
			driver=new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(driver);
			DriverManager.setImplicitWait(driver);
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", DriverFactory.getIeExeFilePath());
			driver=new InternetExplorerDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(driver);
			DriverManager.setImplicitWait(driver);
		}
		
	}
		
		else if(TestSetUp.configProperty.getProperty(Constants.EXECUTION_ENV).contains("Browserstack"))
		{
			DesiredCapabilities caps = null;
			
			String browserStackEnv = TestSetUp.configProperty.getProperty(Constants.BROWSER).toUpperCase();
			switch (browserStackEnv) {
			case Constants.CHROME:
				caps = DesiredCapabilities.chrome();
			    caps.setCapability("os", Constants.BROWSERSTACK_OS);
			    caps.setCapability(Constants.OS_VERSION, Constants.BROWSERSTACK_OS_VERSION);
			    caps.setCapability(Constants.VERSION, Constants.CHROME_VERSION);
			    caps.setCapability(Constants.BROWSERSTACK_LOCAL, Constants.BROWSERSTACK_LOCAL_VALUE_FALSE);
			    caps.setCapability(Constants.BROWSERSTACK_DEBUG, Constants.BROWSERSTACK_DEBUG_VALUE_TRUE);
				break;
			case Constants.FIREFOX:
				caps = DesiredCapabilities.firefox();
				caps.setCapability("os", Constants.BROWSERSTACK_OS);
			    caps.setCapability(Constants.OS_VERSION, Constants.BROWSERSTACK_OS_VERSION);
			    caps.setCapability(Constants.VERSION, Constants.FIREFOX_VERSION);
			    caps.setCapability(Constants.BROWSERSTACK_LOCAL, Constants.BROWSERSTACK_LOCAL_VALUE_FALSE);
			    caps.setCapability(Constants.BROWSERSTACK_DEBUG, Constants.BROWSERSTACK_DEBUG_VALUE_TRUE);
				break;
			case Constants.IE:
				caps = DesiredCapabilities.edge();
				caps.setCapability("os", Constants.BROWSERSTACK_OS);
			    caps.setCapability(Constants.OS_VERSION, Constants.BROWSERSTACK_OS_VERSION);
			    caps.setCapability(Constants.VERSION, Constants.BROWSERSTACK_IE_VERSION);
			    caps.setCapability(Constants.BROWSERSTACK_LOCAL, Constants.BROWSERSTACK_LOCAL_VALUE_FALSE);
			    caps.setCapability(Constants.BROWSERSTACK_DEBUG, Constants.BROWSERSTACK_DEBUG_VALUE_TRUE);
				break;
			default:
				break;
			}
			driver = new RemoteWebDriver(new URL(Constants.BROWSERSTACK_URL), caps);
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(driver);
			DriverManager.setImplicitWait(driver);
		}
		/**
		 * Additional execution environments can be added here.
		 */
		return DriverManager.getDriver();			
	}

	
	/**
	 * This method is to kill the driver.
	 */
	public static void destroyDriver()
	{
		if(DriverManager.getDriver()!=null)
		DriverManager.getDriver().quit();
	}
	
	/**
	 * This method is to kill the driver.
	 */
	public static void closeDriver()
	{
		if(DriverManager.getDriver()!=null)
		DriverManager.getDriver().close();
	}
}
