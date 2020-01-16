package utilities;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.SuperTestNG;

public class listeners implements ITestListener, ISuiteListener{
	
	SuperTestNG s = new SuperTestNG();
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started "+result.getName());	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Successfully Finished "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
	/*	try {
			s.getscreenshot(result.getName());
		} catch(Exception e){
			e.printStackTrace();
		}*/
		try {
		String screenshotpath = ((TakesScreenshot) SuperTestNG.driver).getScreenshotAs(OutputType.BASE64);
		String screenshotBase64 = "data:image/png;base64," + screenshotpath;
		SuperTestNG.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
				ExtentColor.RED));
		SuperTestNG.test.fail(result.getThrowable());
	
			SuperTestNG.test.fail("Snapshot below: " + SuperTestNG.test.addScreenCaptureFromPath(screenshotBase64));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 System.out.println("Skipped test "+result.getName());	
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed but within success percentage" +result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Starts Test execution "+context.getName());
		System.out.println("This is onStart Method"+context.getOutputDirectory());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finish Test execution "+context.getName());
		/*System.out.println("This is onFinish Method" +context.getPassedTests());
		System.out.println("This is onFinish Method" +context.getFailedTests());*/
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Starting Test Suite "+suite.getName());	
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Ending Test Suite "+suite.getName());
		
	}

}
