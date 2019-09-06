/**
 ******************************************************************************
 * 							  REUSABLE FRAMEWORK
 *  							CONFIDENTIAL
 *							COPYRIGHTS TO CLOUDTERN
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

public class LoginPage extends BasePage {

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(email);
	}
	
	@FindBy(id = "Email")
	public WebElement email;

	@FindBy(id = "Password")
	public WebElement password;

	@FindBy(css = ".btn-default")
	public WebElement loginButton;

	public LoginPage open() {
		return (LoginPage) openPage(LoginPage.class);
	}


	public LoginPage enterEmail(String emailTxt) {
		
		type(email, emailTxt, "Enter Email");
		return this;
	}
	
	public LoginPage enterPwd(String pwdTxt) {
		
		type(password, pwdTxt, "Enter Password");
		return this;
	}

	public LoginPage clickLoginBtn() {
		click(loginButton, "Log In Button");
		return this;
	}
	
}
