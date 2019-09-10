package steps;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Parameters;

import cucumber.api.java.Before;
import setup.TestSetUp;
import utils.DriverFactory;
import utils.SeleniumDriver;

public class BeforeActions extends TestSetUp {

	@Before
	public void setUp() throws IOException {
		//setUpBrowser();
		//DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
		initialize();
		DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
		//SeleniumDriver.setUpDriver();
	}
}