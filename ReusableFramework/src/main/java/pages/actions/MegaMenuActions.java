package pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
//import pages.locators.MegaMenuLocators;
import utils.BasePage;
import utils.DriverManager;
import utils.SeleniumDriver;

public class MegaMenuActions extends BasePage<Object> {
 
	//MegaMenuLocators megamenuLocators = null;
	
	//MegaMenuLocators MegaMenuLocators = null;
	
		/** This variable is for degNProgLinkElement. */
		@FindBy(linkText="DEGREES + PROGRAMS")
		public WebElement degNProgLinkElement;
		
		/** This variable is for capellaExpMenuElement. */
		@FindBy(linkText="CAPELLA EXPERIENCE")
		public WebElement cplExpLinkElement;
		
		/** This variable is for financingLinkElement. */
		@FindBy(linkText="FINANCING")
		public WebElement financialLinkElement;
		
		/** This variable is for flexPathLinkElement. */
		@FindBy(linkText="APPLY")
		public WebElement applyLinkElement;
		
		/** This variable is for Ask a Question Link. */
		@FindBy(linkText="ASK A QUESTION")
		public WebElement askaQuestionElement;
		
		
		//@FindBy(xpath="//*[@id=\"VcHeader\"]/div/ul[2]/li[5]/a/div/span[1]")
		@FindBy(linkText="LOG IN")
		public WebElement logInElement;
		
		/** This variable is for Schedule Consultation Element. */
		@FindBy(linkText="Schedule Consultation")
		public WebElement scheduleConsultationLinkElement;
		
		
		/** This variable is for Form Element. */
		//@FindBy(css=".form-wrapper")
		@FindBy(xpath="/html/body/div[15]/div/div/div[2]/div")
		public WebElement scheduleConsultationFormElement;
		
		/** This variable is for Degree Element. */
		@FindBy(css=".degreeDropdown")
		public WebElement degreeFormElement;
		
		/** This variable is for AOS Element. */
		@FindBy(css=".aosDropdown")
		public WebElement aosFormElement;
		
		/** This variable is for license question Element. */
		@FindBy(css=".nursing-field")
		public WebElement licenseQuestionFormElement;

	public MegaMenuActions() {
		//this.megamenuLocators = new MegaMenuLocators();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public void moveToMenu(WebElement ele){
		Actions action = new Actions(DriverManager.getDriver());
		action.moveToElement(ele).perform();	
	}

	/**
	 * This method is for clickDegreesNProgram.
	 */
	public void clickDegreesNProgram() {
		//initializeElements(this);
		// wait for the page to load
		waitForElementToVisible(degNProgLinkElement, 2);
		moveToMenu(degNProgLinkElement);
		degNProgLinkElement.click();
	}
	
	/**
	 * This method is for getTxtDegreesNProgram Menu text.
	 */
	public String getTxtDegreesNProgram() {
		//initializeElements(this);
		// wait for the page to load
		waitForElementToVisible(degNProgLinkElement, 2);
		moveToMenu(degNProgLinkElement);
			return degNProgLinkElement.getText();	
	}


/**
 * This method is for clickCapellaExp.
 */
public void clickCapellaExp() {
	//initializeElements(this);
	// wait for the page to load
	waitForElementToVisible(cplExpLinkElement, 2);
	moveToMenu(cplExpLinkElement);
	}

/**
 * This method is for getTxtCapellaExp Menu text.
 */
public String getTxtCapellaExp() {
	//initializeElements(this);
	// wait for the page to load
	waitForElementToVisible(cplExpLinkElement, 2);
	moveToMenu(cplExpLinkElement);
		return cplExpLinkElement.getText();	
}

/**
 * This method is for clickFinancialLink.
 */
public void clickFinancialLinkElement() {
	//initializeElements(this);
	// wait for the page to load
	waitForElementToVisible(financialLinkElement, 2);
	moveToMenu(financialLinkElement);
}

/**
 * This method is for getTxtFinancialLink Menu text.
 */
public String getTxtFinancialLink() {
	//initializeElements(this);
	// wait for the page to load
	waitForElementToVisible(financialLinkElement, 2);
	moveToMenu(financialLinkElement);
		return financialLinkElement.getText();	
}

/**
 * This method is for clickApply.
 */
public void clickApply() {
	//initializeElements(this);
	// wait for the page to load
	waitForElementToVisible(applyLinkElement, 2);
	
	moveToMenu(applyLinkElement);
}

/**
 * This method is for getTxtApplyLink Menu text.
 */
public String getTxtApplyLink() {
	//initializeElements(this);
	// wait for the page to load
	waitForElementToVisible(applyLinkElement, 2);
	moveToMenu(applyLinkElement);
		return applyLinkElement.getText();	
}		
		
		
public void clickAskAQuestion() {
	waitForElementToVisible(askaQuestionElement);
	moveToMenu(askaQuestionElement);
}
		
		
public String getTxtAskAQuestion() {
	waitForElementToVisible(askaQuestionElement,2);
	moveToMenu(askaQuestionElement);
	return askaQuestionElement.getText();
}



public void clickLogIn() {
	waitForElementToVisible(logInElement);
	moveToMenu(logInElement);
	
}

public String getTxtLogIn() {
	waitForElementToVisible(logInElement,2);
	moveToMenu(logInElement);
	return logInElement.getText();
}

@Override
public ExpectedCondition getPageLoadCondition() {
	// TODO Auto-generated method stub
	return null;
}
	
}
