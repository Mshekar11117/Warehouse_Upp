package WH;

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
import pages.Userspage;
import pages.WarehousesPage;

public class CustomerCareLogin extends SuperTestNG{
	
	Landingpage L = new Landingpage();
	Homepage H = new Homepage();
	Commonpage C = new Commonpage();
	Changepasswordpage ch = new Changepasswordpage();
	Searchfunctionality S = new Searchfunctionality();
	SendSMS SM = new SendSMS();
	Userspage U = new Userspage();
	Permissionpage P =  new Permissionpage();
	Rolespage R = new Rolespage();
	WarehousesPage W = new WarehousesPage();
	Countries Co = new Countries();
	SMSTemplatePage SMS = new SMSTemplatePage();
	CreateOrder CR = new CreateOrder();
	CreateOrderEditFlow CD = new CreateOrderEditFlow();
	ImportOrderPage I = new ImportOrderPage();
	ExportExcel E = new ExportExcel();
	CompareExportedExcel cm = new CompareExportedExcel();
	
	@Test
	public void customercare() throws Exception {
	test = extent.createTest("Customer Care Flow");
	
	L.custcareLogin();
	childTest = test.createNode("Customer Care");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Login with valid Admin credentials", ExtentColor.BLUE));
	
	H.verifycopyright();
	childTest = test.createNode("Verify copyright");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify copy right message", ExtentColor.BLUE));
					
	H.getprofileusername();
	childTest = test.createNode("Verify profile username");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the username between Nav bar riht side and user profile", ExtentColor.BLUE));
	
	H.custcarewarehouseAccess();
	childTest = test.createNode("Verify WH access");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify Warehouse access permissions and limits", ExtentColor.BLUE));
	
	H.gettexts();
	childTest = test.createNode("gettexts");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verif the text `Welcome` and `Warehouse access`", ExtentColor.BLUE));
	
	H.verifywarehouseOrderstext();
	childTest = test.createNode("Verify Warehouse Orders text");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify The page title Warehouse order text in Hompage", ExtentColor.BLUE));
	
	H.verifyleftmenus();
	childTest = test.createNode("Verify left menus");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verif the menus present left hand side", ExtentColor.BLUE));
	
	C.printlinksinexcel();
	childTest = test.createNode("Print links in Excel");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Print the links present in the page to Excel sheet", ExtentColor.BLUE));
	
//	Commenting this one for now, as it takes lot of time to run
//	C.FindLinksAndVerifyBrokenlinks();
//	childTest = test.createNode("Find Links And Verify Broken links");
//	childTest.log(Status.PASS, MarkupHelper.createLabel("Find all the links in the page and Verif the links and images are broken or not", ExtentColor.BLUE));
	
	H.getKyc();
	childTest = test.createNode("Check KYC Menu");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Click on KYC menu and verify the URL", ExtentColor.BLUE));
	
	H.getsmstemplate();
	childTest = test.createNode("Check SMS Template Menu");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Click on SMS template menu and verify the URL", ExtentColor.BLUE));
			
	H.getwarehouseorder();
	childTest = test.createNode("Check Warehouse Orders");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Warehouse Order menu and verify the URL", ExtentColor.BLUE));
			
	H.Verifyactions();
	childTest = test.createNode("Verifyactions");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Check what all actions available as per the permissions", ExtentColor.BLUE));
	
	H.verifyhumbergerlink();
	childTest = test.createNode("Verify Humberger Link");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the profile pic when we click on Humberger link and when we don't click on Humberger link", ExtentColor.BLUE));
	
	H.verifychangepasswordlink();
	childTest = test.createNode("Verify Change Password link");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Clicking on Change password link and verify the URL", ExtentColor.BLUE));
	
	ch.verifychangepasswordtitles();
	childTest = test.createNode("verify changepassword titles");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verifying the titles in changepassword the page", ExtentColor.BLUE));
			
	ch.changevalipassword();
	childTest = test.createNode("change valid password");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Entered same new password and confirmation password and verified the success message", ExtentColor.BLUE));
			
	ch.changeinvalidpassword();
	childTest = test.createNode("change Invalid password");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Enter different newpassword and changepassword and verifying the failure message", ExtentColor.BLUE));
			
	ch.canelupdatepassword();
	childTest = test.createNode("canel update password");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Click on cancel button in changepassword and verify the redirect URL", ExtentColor.BLUE));
			
	S.verifySearchTitles();
	childTest = test.createNode("verifySearchTitles");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the title of all search fields and buttons in search module", ExtentColor.BLUE));
		
	S.Verifyoptions();
	childTest = test.createNode("Verifyoptions");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the present options in customer care flow", ExtentColor.BLUE));
		
	S.VerifyTitles();
	childTest = test.createNode("VerifyTitles");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the title name between Excel sheet and the application tables", ExtentColor.BLUE));
			
	S.exportexcel();
	childTest = test.createNode("Export Excel");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Exporting excel sheet and verifying the count", ExtentColor.BLUE));
			
	S.exportPDF();
	childTest = test.createNode("Export PDF");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Exporting PDF file", ExtentColor.BLUE));
			
	S.verifypagination();
	childTest = test.createNode("verifypagination");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Check pagination button and verify the last order number in last page", ExtentColor.BLUE));
			
	S.SelectRandompage();
	childTest = test.createNode("SelectRandompage");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Select the page randomly by clicking on Pagination", ExtentColor.BLUE));
			
	S.OrderNumberfield();
	childTest = test.createNode("OrderNumberfield");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Searching Order ID randomly and clearing the field", ExtentColor.BLUE));
			
	S.InvalidOrderNumber();
	childTest = test.createNode("InvalidOrderNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Enter invalid order number and verify the result", ExtentColor.BLUE));
			
	S.Distributoridfield();
	childTest = test.createNode("Distributor ID field");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Searching Dist ID randomly and clearing the field", ExtentColor.BLUE));
			
	S.Distributornamefield();
	childTest = test.createNode("Distributor Name field");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Searching Dist name randomly and clearing the field", ExtentColor.BLUE));
			
	S.Distributorphonefield();
	childTest = test.createNode("Distributor Phone field");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Searching dist phone randomly by copying phone from Action views orders", ExtentColor.BLUE));
			
	S.SelectWarehouse();
	childTest = test.createNode("Select Warehouse");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Searching by selecting warehouse name from the drop down", ExtentColor.BLUE));
			
	S.Resultdatacount();
	childTest = test.createNode("Result data count");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the count between the displayed value and the tables total row count", ExtentColor.BLUE));
			
	S.SelectSaletype();
	childTest = test.createNode("Select Sale type");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Searching by select Sale Type from the drop down", ExtentColor.BLUE));
			
	S.searcherror();
	childTest = test.createNode("searcherror");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Click on search button without data and verify the error displayed or not", ExtentColor.BLUE));
			
	S.Datefiled();
	childTest = test.createNode("Datefiled");
	childTest.log(Status.PASS, MarkupHelper.createLabel("select Date type from drop down to search using dates", ExtentColor.BLUE));
			
	S.usedatepicker();	
	childTest = test.createNode("usedatepicker");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Select date using Datepicker in From and To date and click on search", ExtentColor.BLUE));
			
	S.SendDateformat();
	childTest = test.createNode("SendDateformat");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Type from date and TO date randomly and click on search", ExtentColor.BLUE));
				
	S.Checkallorders();
	childTest = test.createNode("Checkallorders");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Click on Checkall checkbox and verify the count again uncheck and verify the count", ExtentColor.BLUE));
	
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
	
	SMS.VerifyTableActions();
	childTest = test.createNode("Verify SMS TableActions");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify Actions like Create, Update and Delete should not be there", ExtentColor.BLUE));
			
	E.Exportexcel();
	childTest = test.createNode("Exportexcel");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Exported Excel sheet and Considered the latest file also Verify Numbe of Entries between Applicaiton and ExcelL", ExtentColor.BLUE)); 
	
	E.WriteExcel();
	childTest = test.createNode("WriteExcel");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Write HTML table values in to Excel to compare the values between Application and Exported Excel sheet", ExtentColor.BLUE));
			
	cm.CompareExcel();
	childTest = test.createNode("CompareExcel");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Compare between Excel Exported and Excel pushed Applicaiton value", ExtentColor.BLUE));
				
	L.logout();
	childTest = test.createNode("Logout function");
	childTest.info("Closing the session by Logout");
			
	}
}
