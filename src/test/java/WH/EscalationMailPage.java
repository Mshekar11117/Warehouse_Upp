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
		
		E.EscalationDaysCount();
		childTest = test.createNode("Verify profile username");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the username between Nav bar riht side and user profile", ExtentColor.BLUE));
		
	}

}
