/**
 ******************************************************************************
 * 							  REUSABLE FRAMEWORK
 *  							CONFIDENTIAL
 *							COPYRIGHTS TO CLOUDTERN
 *							
 * *****************************************************************************
 */
package tests;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.actions.LoginLinkChk;
import pages.actions.LoginPage;
import setup.TestSetUp;
import utils.Constants;
import utils.DriverFactory;
import utils.DriverManager;
import utils.TestUtils;

public class LoginTest extends TestSetUp{
	
	//LoginLinkChk loginLnk;
	@Test(dataProviderClass=TestUtils.class, dataProvider="dpone")
	public void testLoginLnkChk(Hashtable<String, String> data) throws InterruptedException{
		
		testCaseLogger.get().assignAuthor(Constants.AUTHOR);
		testCaseLogger.get().assignCategory(Constants.REGRESSION_CATEGORY);
		if(!data.get("Runmode").equalsIgnoreCase("Y")){
			appLogs.info("RunMode is set to NO for testdata");
			throw new SkipException("RunMode is set to No for test data");
		}
		navigateToBaseURL();
		LoginPage login = new LoginPage().open();
		login.enterEmail(data.get("email"));
		Thread.sleep(1000);
		login.enterPwd(data.get("password"));
		Thread.sleep(1000);
		login.clickLoginBtn();
		appLogs.info("Click Login Link");
		Assert.assertTrue(login.getPageTitle().equals(data.get("expected title")));
	}
}