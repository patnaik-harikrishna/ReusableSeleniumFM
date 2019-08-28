package pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.BasePage;
import utils.DriverManager;

public class AskAQuestionsActions extends BasePage {
	
	public AskAQuestionsActions open() {
		return (AskAQuestionsActions) openPage(AskAQuestionsActions.class);
	}
	
	//========================================
		//ASK A QUESTION
	//========================================
					
	@FindBy(linkText="ASK A QUESTION")	
	public WebElement askQuestionElement;
	//========================================
	//Schedule Consultation
	//========================================
				
	@FindBy(linkText="Schedule Consultation")	
	public WebElement ScheduleConsultationElement;

	//========================================
	//Email Us
	//========================================	
				
	@FindBy(linkText="Email Us")	
	public WebElement EmailUsElement;
				

	//========================================
	//Request Information
	//========================================	
				
	@FindBy(linkText="Request Information")	
	public WebElement RequestInformationElement;


	//========================================
	//Chat
	//========================================	
				
	@FindBy(linkText="Chat")	
	public WebElement ChatElement;

	
public void moveToMenu(WebElement ele)	{
	Actions action = new Actions(DriverManager.getDriver());
	action.moveToElement(ele).perform();
}

	
	//========================================
	//Schedule Consultation
	//========================================
	public String getTxtScheduleConsultationElement() {
		waitForElementToVisible(ScheduleConsultationElement,2);
		moveToMenu(ScheduleConsultationElement);
		return ScheduleConsultationElement.getText();		
	}	
		
	//========================================
	//Email Us
	//========================================	
	public String getTxtEmailUsElement() {	
		waitForElementToVisible(EmailUsElement,2);
		moveToMenu(EmailUsElement);
		return EmailUsElement.getText();	
		
	}
	
	//========================================
	//Request Information
	//========================================	
	public String getTextRequestInformationElement() {	
		waitForElementToVisible(RequestInformationElement,2);
		moveToMenu(RequestInformationElement);
		return RequestInformationElement.getText();
		
	}


	//========================================
	//Chat
	//========================================	
		
	
	public String getTxtChatElement() {
		
		waitForElementToVisible(ChatElement,2);
		moveToMenu(ChatElement);
		return ChatElement.getText();
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(askQuestionElement);
	}	
		
}