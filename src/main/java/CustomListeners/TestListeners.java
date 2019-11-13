package CustomListeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.AlshayaGroup.TestSetup.TestSetup;
import com.AlshayaGroup.TestUtils.TestUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class TestListeners extends TestSetup implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.setProperty("org.uncommons.reportng.escape-output","false");
		
		System.out.println("./src/test/resources/ScreenShots/"+TestUtil.fileName);
		Reporter.log("<a href=\"./src/test/resources/ScreenShots"+TestUtil.fileName+" target=\"_blank\">Screenshot Captured</a>");
		Reporter.log("<br>");
		System.out.println("Screenshot captured line executed.");
		
		Reporter.log("<a href=\"./src/test/resources/ScreenShots/"+TestUtil.fileName+" target=\"_blank\"><img src="+TestUtil.fileName+" height=200 width=200></a>");
		System.out.println("Screenshot image displayed line executed.");
	}

	public void onTestSkipped(ITestResult arg0) {
		testLevelLog.get().skip("This test Case got Skipped");
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("******* On Test Start Execution Started********");
		
	
		
	}

	public void onTestSuccess(ITestResult arg0) {
		String successMessage= "<b>"+"This Test Case is Passed"+"</b>";
		Markup m=MarkupHelper.createLabel(successMessage, ExtentColor.GREEN);
		log.info(m);
		
	}

}
