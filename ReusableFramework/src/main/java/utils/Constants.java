package utils;

public class Constants {
	
	private Constants(){
	}

	/*  --------------------------------------------------------------------------------------------------------------------------------------- 
	 *  															FRAMEWORK CONSTANTS
	 *  --------------------------------------------------------------------------------------------------------------------------------------- 
	 */
	public static final String ROOT_DIR="user.dir";
	public static final String AUTHOR="harip";
	public static final String REGRESSION_CATEGORY="Regression";
	public static final String SMOKE_CATEGORY="Smoke";
	public static final String ACCEPTANCE_CATEGORY="Acceptance";
	
	
	/*  --------------------------------------------------------------------------------------------------------------------------------------- 
	 *  							    								ENVIRONMENTAL CONSTANTS
	 *  --------------------------------------------------------------------------------------------------------------------------------------- 
	 */
	public static final String EXECUTION_ENV="executionEnvironment";
	public static final String BROWSER="browser";
	public static final String PLATFORM="platform";
	public static final String VERSION="version";
	public static final String OS_VERSION="os_version";
	public static final String BROWSERSTACK_LOCAL = "browserstack.local";
	public static final String BROWSERSTACK_LOCAL_VALUE_FALSE="false";
	public static final String BROWSERSTACK_LOCAL_VALUE_TRUE="true";
	public static final String BROWSERSTACK_DEBUG="browserstack.debug";
	public static final String BROWSERSTACK_DEBUG_VALUE_TRUE="true";
	public static final String BROWSERSTACK_DEBUG_VALUE_FALSE="false";
	public static final String FIREFOX="FIREFOX";
	public static final String CHROME ="CHROME";
	public static final String IE = "IE";
	public static final String siteURL = "http://www.qatest.com";
	public static final String loginUser="testone";
	public static final String loginPwd="welcome@123";

	/*  --------------------------------------------------------------------------------------------------------------------------------------- 
	 *  															REPORTING CONSTANTS
	 *  --------------------------------------------------------------------------------------------------------------------------------------- 
	 */
	public static final String OR_ACTUAL_TITLE="Actual Title: ";
	public static final String OR_START_FONT_TAG="<font color=";
	public static final String OR_END_FONT_TAG="</font>";
	

	/*  --------------------------------------------------------------------------------------------------------------------------------------- 
	 *  															CLOUD RELATED CONSTANTS
	 *  --------------------------------------------------------------------------------------------------------------------------------------- 
	 */
	
	
	public static final String BROWSERSTACK_USERNAME = "qatestuser";
	public static final String BROWSERSTACK_ACCESS_KEY = "hjfkjdhlkjhdkf";
	public static final String BROWSERSTACK_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static final String BROWSERSTACK_TAGS = "BrowserStackTest";
	public static final String BROWSERSTACK_OS = "Windows";
	public static final String BROWSERSTACK_OS_VERSION = "10";
	public static final String BROWSERSTACK_IE_VERSION = "17.0";

	
	public static final String CHROME_PLATFORM = "Windows 10";
	public static final String CHROME_VERSION = "67.0";
	public static final String FIREFOX_PLATFORM = "Windows 8";
	public static final String FIREFOX_VERSION = "57.0";
	public static final String IE_PLATFORM = "Windows 7";

	/*  --------------------------------------------------------------------------------------------------------------------------------------- 
	 *  																LOCATORS
	 *  --------------------------------------------------------------------------------------------------------------------------------------- 
	 */
	
	/* Base Page */
	public static final int DRIVER_TIME_OUT = 30;
	
}
