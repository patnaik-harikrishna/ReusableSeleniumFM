/**
 ******************************************************************************
 * 							  REUSABLE FRAMEWORK
 *  							CONFIDENTIAL
 *							COPYRIGHTS TO TECHASPECT
 *							
 * *****************************************************************************
 */

package pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BasePage;
import utils.Constants;
import utils.DriverManager;

public class LoginLinkChk extends BasePage {

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginLnk);
	}

	@FindBy(linkText = "LOG IN")
	public WebElement loginLnk;

	public LoginLinkChk open() {
		return (LoginLinkChk) openPage(LoginLinkChk.class);
	}


	public LoginLinkChk clickLoginLnk() {
		click(loginLnk, "Log In Link");
		return this;
	}

	public String getLandingPageTitle() {
		appLogs.info("Executing getLandingPageTitle");
		return DriverManager.getDriver().getTitle();
	}

}
