package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.TestSetUp;

public class SeleniumDriver extends TestSetUp {

	private static SeleniumDriver seleniumDriver;

	// init Webdriver
	public static String chromeExeFilePath=System.getProperty(Constants.ROOT_DIR)+"\\drivers\\chromedriver.exe";
	public static String ieExeFilePath = System.getProperty(Constants.ROOT_DIR)+"\\drivers\\IEDriverServer.exe";
	public static String firefoxExeFilePath = System.getProperty(Constants.ROOT_DIR)+"\\drivers\\geckodriver.exe";
	private static WebDriver driver;
	private static WebDriverWait waitDriver;
	public final static int TIMEOUT = 60;
	public final static int PAGE_LOAD_TIMEOUT = 60;
	

	private SeleniumDriver() {
		
		
		System.setProperty("webdriver.chrome.driver", chromeExeFilePath);
		String Brow = configProperty.getProperty("browser");
		System.out.println(Brow);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		waitDriver = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	
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

	public static void openPage(String url) {
		driver.get(url);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() {
		if (seleniumDriver == null) {
			seleniumDriver = new SeleniumDriver();
		}
	}

	public static void tearDown() {
		if (driver != null) {
			//driver.close();
			driver.quit();
		}
		seleniumDriver = null;
	}

}
