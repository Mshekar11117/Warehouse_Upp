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
		
		H.verifycopyright();
		childTest = test.createNode("Verify copyright");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify copy right message", ExtentColor.BLUE));
						
		H.getprofileusername();
		childTest = test.createNode("Verify profile username");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the username between Nav bar riht side and user profile", ExtentColor.BLUE));
		
		H.getwarehouseaccess();
		childTest = test.createNode("Warehouse access Permission as per the user");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Check the warehouse access limit", ExtentColor.BLUE));
		
		H.gettexts();
		childTest = test.createNode("gettexts");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verif the text `Welcome` and `Warehouse access`", ExtentColor.BLUE));
		
		H.verifywarehouseOrderstext();
		childTest = test.createNode("Verify Warehouse Orders text");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the page Title Warehouse order text in Hompage", ExtentColor.BLUE));
				
		H.verifyleftmenus();
		childTest = test.createNode("Verify left menus");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verif the menus present left hand side", ExtentColor.BLUE));
		
		H.getKyc();
		childTest = test.createNode("Check KYC Menu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on KYC menu and verify the URL", ExtentColor.BLUE));
				
		H.getusers();
		childTest = test.createNode("Check Users Menu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Users menu and verify the URL", ExtentColor.BLUE));
				
		H.getroles();
		childTest = test.createNode("Check Roles Menu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Roles menu and verify the URL", ExtentColor.BLUE));
				
		H.getpermissions();
		childTest = test.createNode("Check Permission Menu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Permissions menu and verify the URL", ExtentColor.BLUE));
				
		H.getwarehousenames();
		childTest = test.createNode("Check Warehouse names Menu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Wareshouse `name` menu and verify the URL", ExtentColor.BLUE));
				
		H.getcountries();
		childTest = test.createNode("Check Countries Menu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Countries menu and verify the URL", ExtentColor.BLUE));
				
		H.getsmstemplate();
		childTest = test.createNode("Check SMS Template Menu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on SMS template menu and verify the URL", ExtentColor.BLUE));
		
		H.getUppPayments();
		childTest = test.createNode("Get Upp Payemnt page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on UPP payment menu and verify the URL", ExtentColor.BLUE));
		
		H.getUppDistributors();
		childTest = test.createNode("Get Upp Distributors page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on UPP Distributor menu and verify the URL", ExtentColor.BLUE));
				
		H.getwarehouseorder();
		childTest = test.createNode("Check Warehouse Orders");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Warehouse Order menu and verify the URL", ExtentColor.BLUE));
				
		H.verifyhumbergerlink();
		childTest = test.createNode("Verify Humberger Link");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the profile pic when we click on Humberger link and when we don't click on Humberger link", ExtentColor.BLUE));
		
		I.AccessingImportOrder();
		childTest = test.createNode("Accessing Import Order");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing SMS Template page and verifying page text and URL", ExtentColor.BLUE));
				
		I.validatetitles();
		childTest = test.createNode("validate titles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Validating field and page tiles in the import page", ExtentColor.BLUE));
		
		H.getwarehouseorder();
		childTest = test.createNode("Click on Warehouse Menu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Getting Warehouse Menu again to get search options", ExtentColor.BLUE));
		
		S.Searchoptions();
		childTest = test.createNode("Verify Search options");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify Search options in search section", ExtentColor.BLUE));
		
		S.verifySearchTitles();
		childTest = test.createNode("verifySearchTitles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the title of all search fields and buttons in search module", ExtentColor.BLUE));
		
		S.VerifyTitles();
		childTest = test.createNode("VerifyTitles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the title name between Excel sheet and the application tables", ExtentColor.BLUE));
		
		S.verifypagination();
		childTest = test.createNode("verifypagination");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Check pagination button and verify the last order number in last page", ExtentColor.BLUE));
		
		S.OrderNumberfield();
		childTest = test.createNode("OrderNumberfield");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Searching Order ID randomly and clearing the field", ExtentColor.BLUE));
		
		S.searcherror();
		childTest = test.createNode("searcherror");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on search button without data and verify the error displayed or not", ExtentColor.BLUE));
				
		SM.VerifySMSModal();
		childTest = test.createNode("VerifySMSModal");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click SMS updatebuttonbutton and Verify the Displayed message in Modal", ExtentColor.BLUE));
		
		U.AccessingUsersMenu();
		childTest = test.createNode("AccessingUsersMenu");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on users menu and Verify the Create, Update and Delete buttons", ExtentColor.BLUE));
				
		U.verifyUsertexts();
		childTest = test.createNode("verifyUsertexts");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the texts in Users page", ExtentColor.BLUE));
		
		U.createuservalidations();
		childTest = test.createNode("createuservalidations");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Create new user and verify the fields except the select fields", ExtentColor.BLUE));
				
		U.VerifyDropdownWHValues();
		childTest = test.createNode("VerifyDropdownWHValues");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the values of Warehouse drop down", ExtentColor.BLUE));
		
		U.VerifyDropdownroleValues();
		childTest = test.createNode("VerifyDropdownroleValues");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the values of Roles drop down", ExtentColor.BLUE));
		
		P.AccessingPermissionPage();
		childTest = test.createNode("AccessingPermissionPage");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing permission page and verifying page text and URL", ExtentColor.BLUE));
				
		P.VerifyTableTitles();
		childTest = test.createNode("VerifyTableTitles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the permission table titles", ExtentColor.BLUE));
				
		P.NumberofPermissions();
		childTest = test.createNode("NumberofPermissions");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Check the count of permissions we have", ExtentColor.BLUE));
				
		P.printandverifypermissionnames();
		childTest = test.createNode("printandverifypermissionnames");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print permission names and verify the value against Excel data", ExtentColor.BLUE));
				
		P.printandverifypermissiondescription();
		childTest = test.createNode("printandverifypermissiondescription");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print permission descriptions and verify the value against Excel data", ExtentColor.BLUE));
		
		R.AccessingRolesPage();
		childTest = test.createNode("AccessingRolesPage");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing Roles page and verifying page text and URL", ExtentColor.BLUE));
				
		R.VerifyTableTitles();
		childTest = test.createNode("VerifyTableTitles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the permission table titles", ExtentColor.BLUE));
				
		R.NumberofRoles();
		childTest = test.createNode("NumberofRoles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Check the count of permissions we have", ExtentColor.BLUE));
				
		R.printandverifyRolenames();
		childTest = test.createNode("printandverifyRolenames");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print permission names and verify the value against Excel data", ExtentColor.BLUE));
			
		R.printandverifyRolesdescription();
		childTest = test.createNode("printandverifyRolesdescription");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print Roles descriptions and verify the value against Excel data", ExtentColor.BLUE));
		
		R.VerifyErrorMessages();
		childTest = test.createNode("VerifyErrorMessages");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Error messages in Roles page", ExtentColor.BLUE));
				
		R.verifythePermissionsinRolesPage();
		childTest = test.createNode("verifythePermissionsinRolesPage");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Not assigned permission count and permissions", ExtentColor.BLUE));
		
		W.AccessingWarehousePage();
		childTest = test.createNode("AccessingRolesPage");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing Warehouses page and verifying page text and URL", ExtentColor.BLUE));
				
		W.VerifyTableTitles();
		childTest = test.createNode("VerifyTableTitles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Warehouses table titles", ExtentColor.BLUE));
				
		W.NumberofWarehouses();
		childTest = test.createNode("NumberofWarehouses");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Check the count of Warehouses we have in Warehouses page", ExtentColor.BLUE));
				
		W.printandverifyWHnames();
		childTest = test.createNode("printandverifyWHnames");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print WH names and verify the value against Excel data", ExtentColor.BLUE));
				
		W.printandverifyCountries();
		childTest = test.createNode("printandverifyCountries");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print countries name and verify the value against Excel data", ExtentColor.BLUE));
				
		W.VerifyErrorMessages();
		childTest = test.createNode("VerifyErrorMessages");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Error messages in Warehouses Create page", ExtentColor.BLUE));
				
		W.NumberofWhNames();
		childTest = test.createNode("NumberofWhNames");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verif the number of country displayed in countries drop down", ExtentColor.BLUE));
		
		Co.AccessingCountriesPage();
		childTest = test.createNode("AccessingCountriesPage");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing Countries page and verifying page text and URL", ExtentColor.BLUE));
				
		Co.VerifyTableTitles();
		childTest = test.createNode("VerifyTableTitles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Warehouses table titles", ExtentColor.BLUE));
				
		Co.NumberofCountries();
		childTest = test.createNode("NumberofCountries");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Check the count of Countries we have in Countries page", ExtentColor.BLUE));
				
		Co.printandverifyCountrynames();
		childTest = test.createNode("printandverifyCountrynames");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print Country names and verify the value against Excel data", ExtentColor.BLUE));
				
		Co.printandverifyCountryCode();
		childTest = test.createNode("printandverifyCountryCode");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print Country names and verify the value against Excel data", ExtentColor.BLUE));
		
		SMS.AccessingSMSTemplatePage();
		childTest = test.createNode("AccessingSMSTemplatePage");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing SMS Template page and verifying page text and URL", ExtentColor.BLUE));
				
		SMS.VerifyTableTitles();
		childTest = test.createNode("VerifyTableTitles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the SMS Templates table titles", ExtentColor.BLUE));
				
		SMS.NumberofSMSTemplates();
		childTest = test.createNode("NumberofSMSTemplates");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Check the count of SMS Templates we have in SMS Template page", ExtentColor.BLUE));
				
		SMS.printandverifySMSTemplatesNames();
		childTest = test.createNode("printandverifySMSTemplatesNames");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print SMS templates names and verify the value against Excel data", ExtentColor.BLUE));
				
		SMS.printandverifySMSTemplateDesc();
		childTest = test.createNode("printandverifySMSTemplateDesc");
		childTest.log(Status.PASS, MarkupHelper.createLabel("print SMS templates Descriptions and verify the value against Excel data", ExtentColor.BLUE));
		
		SMS.printandverifySMSTemplateStatus();
		childTest = test.createNode("printandverifySMSTemplateStatus");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the status is Active or inactive of Each SMS", ExtentColor.BLUE));
		
		CR.AccessingCreateOrder();
		childTest = test.createNode("AccessingCreateOrder");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing Create order page", ExtentColor.BLUE));
				
		CR.verifytextsinCreateOrder();
		childTest = test.createNode("verifytextsinCreateOrder");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the label texts in Create order page", ExtentColor.BLUE));
				
		CR.NumberofMandatoryFields();
		childTest = test.createNode("NumberofMandatoryFields");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the number of Mandatory fields in Create page", ExtentColor.BLUE));
			
		L.logout();
		childTest = test.createNode("Logout function");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Closing the session by Logout", ExtentColor.BLUE));

	}

}
