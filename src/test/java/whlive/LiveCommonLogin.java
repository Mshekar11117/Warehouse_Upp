package whlive;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.SuperTestNG;
import pages.Landingpage;

public class LiveCommonLogin extends SuperTestNG{
	
	Landingpage lp = new Landingpage();
	
	@Test
	public void prodcommonflow() throws Exception {
		test = extent.createTest("Live Common flow");
		
		lp.invalidMultiplecredentials();
		childTest = test.createNode("invalidMultiplecredentials");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Try to Login with invalid users mentioned in Excel and verify", ExtentColor.BLUE));
	}

}
