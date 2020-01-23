package whlive;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.SuperTestNG;
import pages.Changepasswordpage;
import pages.Commonpage;
import pages.CompareExportedExcel;
import pages.Countries;
import pages.CreateOrder;
import pages.CreateOrderEditFlow;
import pages.ExportExcel;
import pages.Homepage;
import pages.ImportOrderPage;
import pages.Landingpage;
import pages.Permissionpage;
import pages.Rolespage;
import pages.SMSTemplatePage;
import pages.Searchfunctionality;
import pages.SendSMS;
import pages.UpdateUPPDistributor;
import pages.UppCreateDistributor;
import pages.UppDistributors;
import pages.UppMakePaymentPage;
import pages.UppPayment;
import pages.UppPaymentSearchFunctionalityPage;
import pages.UppPaymentViewpage;
import pages.Userspage;
import pages.ViewUPPDistributorPage;
import pages.WarehousesPage;

public class LiveSuperAdminLogin extends SuperTestNG {

	Landingpage L = new Landingpage();
	Homepage H = new Homepage();
	Commonpage C = new Commonpage();
	Changepasswordpage ch = new Changepasswordpage();
	Searchfunctionality S = new Searchfunctionality();
	SendSMS SM = new SendSMS();
	Userspage U = new Userspage();
	Permissionpage P = new Permissionpage();
	Rolespage R = new Rolespage();
	WarehousesPage W = new WarehousesPage();
	Countries Co = new Countries();
	SMSTemplatePage SMS = new SMSTemplatePage();
	CreateOrder CR = new CreateOrder();
	CreateOrderEditFlow CD = new CreateOrderEditFlow();
	ImportOrderPage I = new ImportOrderPage();
	ExportExcel E = new ExportExcel();
	CompareExportedExcel cm = new CompareExportedExcel();
	UppDistributors Upp = new UppDistributors();
	UppCreateDistributor Uppc = new UppCreateDistributor();
	ViewUPPDistributorPage ViewUpp = new ViewUPPDistributorPage();
	UpdateUPPDistributor UppUpdate = new UpdateUPPDistributor();
	UppPayment UppPayment = new UppPayment();
	UppPaymentSearchFunctionalityPage UppSearch = new UppPaymentSearchFunctionalityPage();
	UppPaymentViewpage UppView = new UppPaymentViewpage();
	UppMakePaymentPage makepayment = new UppMakePaymentPage();

	@Test
	public void LiveSuperAdminflow() throws Exception {
		test = extent.createTest("Super Admin Flow in production");

		L.LIVESuperAdminlogin();
		childTest = test.createNode("Super Admin login - LIVE");
		childTest.log(Status.PASS,
				MarkupHelper.createLabel("Login with valid super Admin credentials", ExtentColor.BLUE));
		
		L.logout();
		childTest = test.createNode("Logout function");
		childTest.info("Closing the session by Logout");

	}

}
