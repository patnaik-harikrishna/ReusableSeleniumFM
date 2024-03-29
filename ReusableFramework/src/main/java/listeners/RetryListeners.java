/**
 ******************************************************************************
 * 							  REUSABLE FRAMEWORK
 *  							CONFIDENTIAL
 *							COPYRIGHTS TO CloudTern
 *							
 * *****************************************************************************
 */

package listeners;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import setup.TestSetUp;

public class RetryListeners implements IRetryAnalyzer {

	private int count = 0;
	private int maxCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Throwable ex = result.getThrowable();
			if (ex != null & ex.getClass() == UnreachableBrowserException.class) {
				TestSetUp.appLogs.error("UnreachableBrowserException");
			}
			if (count < maxCount) {
				count++;
				result.setStatus(ITestResult.SUCCESS_PERCENTAGE_FAILURE);
				String message = Thread.currentThread().getName() + " Error in "
						+ result.getName() + " with status "
						+ result.getStatus() + " Retry attempt # " + count;
				TestSetUp.appLogs.info(message);
				return true;
			}

		}
		return false;
	}	
}