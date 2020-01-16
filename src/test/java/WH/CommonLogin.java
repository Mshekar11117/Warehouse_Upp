package WH;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.SuperTestNG;
import pages.Landingpage;

public class CommonLogin extends SuperTestNG{
	
	Landingpage lp = new Landingpage();
	
	@Test
	public void commonflow() throws Exception {
		test = extent.createTest("Commonflow");
		
		lp.validMultiplecredentials();
		childTest = test.createNode("Valid Multiple Credentials");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Login and Logout with All valid users mentioned in Excel and verify", ExtentColor.BLUE));
		
		lp.invalidMultiplecredentials();
		childTest = test.createNode("invalidMultiplecredentials");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Try to Login with invalid users mentioned in Excel and verify", ExtentColor.BLUE));
	}

}
