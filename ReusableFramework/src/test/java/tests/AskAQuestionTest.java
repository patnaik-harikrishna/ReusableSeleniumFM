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

import pages.actions.AskAQuestionsActions;
import pages.actions.LoginLinkChk;
import setup.TestSetUp;
import utils.Constants;
import utils.DriverFactory;
import utils.DriverManager;
import utils.TestUtils;

public class AskAQuestionTest extends TestSetUp{
	
	
	@Test()
	public void testAskQuestionMenu(){
		
		navigateToBaseURL();
		AskAQuestionsActions askQuestion = new AskAQuestionsActions().open();
		askQuestion.mouseOverElement(askQuestion.askQuestionElement);
		appLogs.info("Hover Ask a Question Link");
		String askQuestLink = askQuestion.getTxtScheduleConsultationElement();
		appLogs.info("Ask Question Text " +askQuestLink);
		//Assert.assertTrue(homePage.getHomePageTitle().equals(data.get("expected title")));
	}
}