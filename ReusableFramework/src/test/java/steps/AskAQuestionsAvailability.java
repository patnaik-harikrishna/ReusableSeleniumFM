package steps;

import org.openqa.selenium.support.ui.ExpectedCondition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import pages.actions.AskAQuestionsActions;
import pages.actions.MegaMenuActions;
import utils.BasePage;
import utils.ErrorUtil;

public class AskAQuestionsAvailability extends BasePage<Object>{
	
	MegaMenuActions megamenuaction= new MegaMenuActions();
	AskAQuestionsActions askAction= new AskAQuestionsActions();
	
	@Given("^I am on Capella Home Page\\.$")
	public void i_am_Capella_Home_Page() throws Throwable {
		navigateToBaseURL();
	}
	
	@Then("^I am on Ask A Question\\.$")
	public void i_am_on_Ask_A_Question() throws Throwable {
		megamenuaction.clickAskAQuestion();
	}

	@Then("^I can see Schedule Consulation\\.$")
	public void i_can_see_Schedule_Consulation() throws Throwable {
		String actual= askAction.getTxtScheduleConsultationElement();
        String expected=excel1.getCellData("MagaMenuAvailability","ASK A QUESTION", 2);
         		   try {
         	        	Assert.assertEquals("Both are same", expected, actual);
         	        }
         	        catch(Throwable t) {
         	        	ErrorUtil.addVerificationFailure(t);
         	        	throw t;
         	        } 
	}

	@Then("^I can see Email Us$")
	public void i_can_see_Email_Us() throws Throwable {
		String actual= askAction.getTxtEmailUsElement();
        String expected=excel1.getCellData("MagaMenuAvailability","ASK A QUESTION", 3);
         		   try {
         	        	Assert.assertEquals("Both are same", expected, actual);
         	        }
         	        catch(Throwable t) {
         	        	ErrorUtil.addVerificationFailure(t);
         	        	throw t;
         	        } 
	}

	@Then("^I can see Request Information$")
	public void i_can_see_Request_Information() throws Throwable {
		String actual= askAction.getTextRequestInformationElement();
        String expected=excel1.getCellData("MagaMenuAvailability","ASK A QUESTION", 4);
         		   try {
         	        	Assert.assertEquals("Both are same", expected, actual);
         	        }
         	        catch(Throwable t) {
         	        	ErrorUtil.addVerificationFailure(t);
         	        	throw t;
         	        } 
	}

	@Then("^I can see Chat\\.$")
	public void i_can_see_Chat() throws Throwable {
		String actual= askAction.getTxtChatElement();
        String expected=excel1.getCellData("MagaMenuAvailability","ASK A QUESTION", 5);
         		   try {
         	        	Assert.assertEquals("Both are same", expected, actual);
         	        }
         	        catch(Throwable t) {
         	        	ErrorUtil.addVerificationFailure(t);
         	        	throw t;
         	        }  
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
