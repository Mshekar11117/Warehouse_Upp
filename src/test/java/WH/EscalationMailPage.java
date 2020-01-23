package WH;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.SuperTestNG;
import pages.Escalationdays;
import pages.Homepage;
import pages.Landingpage;

public class EscalationMailPage extends SuperTestNG{
	Landingpage L = new Landingpage();
	Homepage H = new Homepage();
	Escalationdays E = new Escalationdays();
	
	@Test
	public void VerifyEscalaionDaywideCount() throws Exception {
		test = extent.createTest("Escalation Email order count over 3, 4 and 5 days scenario");
		
		L.SuperAdminlogin();
		childTest = test.createNode("Super Admin login");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Login with valid super Admin credentials", ExtentColor.BLUE));
		
		H.verifycopyright();
		childTest = test.createNode("Verify copyright");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify copy right message", ExtentColor.BLUE));
						
		H.getprofileusername();
		childTest = test.createNode("Verify profile username");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the username between Nav bar riht side and user profile", ExtentColor.BLUE));
		
		E.ChangethreeDayAndStatus();
		childTest = test.createNode("Change the date to 3 days");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Change the date to get 3 days and change the status of first 2 orders", ExtentColor.BLUE));
		
		E.ChangefourDayAndStatus();
		childTest = test.createNode("Change the date of 4 days");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Change the date to get 4 days and change the status of 3rd and 4th orders", ExtentColor.BLUE));
		
		E.EscalationDaysCount();
		childTest = test.createNode("Get the days difference");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Compare the days count and verify with Esclation URL", ExtentColor.BLUE));
		
	}

}
