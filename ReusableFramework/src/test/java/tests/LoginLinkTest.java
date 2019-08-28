package tests;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.actions.LoginLinkChk;
import setup.TestSetUp;
import utils.Constants;
import utils.DriverFactory;
import utils.DriverManager;
import utils.TestUtils;

public class LoginLinkTest extends TestSetUp{
	
	//LoginLinkChk loginLnk;
	@Test()
	public void testLoginLnkChk(){
		
		navigateToBaseURL();
		LoginLinkChk loginLnk = new LoginLinkChk().open();
		loginLnk.clickLoginLnk();
		appLogs.info("Click Login Link");
		//Assert.assertTrue(homePage.getHomePageTitle().equals(data.get("expected title")));
	}
}