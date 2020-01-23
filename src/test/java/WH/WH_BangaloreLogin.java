package WH;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.SuperTestNG;
import pages.Changepasswordpage;
import pages.Commonpage;
import pages.CompareExportedExcel;
import pages.CreateOrder;
import pages.CreateOrderEditFlow;
import pages.ExportExcel;
import pages.Homepage;
import pages.ImportOrderPage;
import pages.Landingpage;
import pages.Searchfunctionality;

public class WH_BangaloreLogin extends SuperTestNG {
	
	Landingpage L = new Landingpage();
	Homepage H = new Homepage();
	Commonpage C = new Commonpage();
	Changepasswordpage ch = new Changepasswordpage();
	Searchfunctionality S = new Searchfunctionality();
	CreateOrder CR = new CreateOrder();
	CreateOrderEditFlow CD = new CreateOrderEditFlow();
	ImportOrderPage I = new ImportOrderPage();
	ExportExcel E = new ExportExcel();
	CompareExportedExcel cm = new CompareExportedExcel();

	@Test
	public void BangaloreWarehouseflow() throws Exception {
	test = extent.createTest("Bangalore Warehouse Flow");
	
	L.Bangaloreuser();
	childTest = test.createNode("Wh login");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Login as a Agmedabad user", ExtentColor.BLUE));
	
	H.verifycopyright();
	childTest = test.createNode("Verify copyright");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify copy right message", ExtentColor.BLUE));
					
	H.getprofileusername();
	childTest = test.createNode("Verify profile username");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the username between Nav bar riht side and user profile", ExtentColor.BLUE));
	
	H.WHwarehouseAccess();
	childTest = test.createNode("Warehouse access Permission as per the user");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Check the warehouse access limit", ExtentColor.BLUE));
	
	H.gettexts();
	childTest = test.createNode("gettexts");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verif the text `Welcome` and `Warehouse access`", ExtentColor.BLUE));
			
	H.verifywarehouseOrderstext();
	childTest = test.createNode("Verify Warehouse Orders text");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify Warehouse order text in Hompage", ExtentColor.BLUE));
	
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
	childTest = test.createNode("cancel update password");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Click on cancel button in changepassword and verify the redirect URL", ExtentColor.BLUE));
			
	I.AccessingImportOrder();
	childTest = test.createNode("Accessing Import Order");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing SMS Template page and verifying page text and URL", ExtentColor.BLUE));
			
	I.validatetitles();
	childTest = test.createNode("validate titles");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Validating field and page tiles in the import page", ExtentColor.BLUE));
		
	I.importoptionvalidations();
	childTest = test.createNode("import option validations");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify all the error messages in the import page", ExtentColor.BLUE));
	
	I.backtowarehousefrommImport();
	childTest = test.createNode("backtowarehousefrommImport");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Click back to Warehouse order menu", ExtentColor.BLUE));
	
	S.verifySearchTitles();
	childTest = test.createNode("verifySearchTitles");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the title of all search fields and buttons in search module", ExtentColor.BLUE));
	test.info("Verify the title of all search fields and buttons in search module");
	
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
			
	S.Deleteorder();
	childTest = test.createNode("Deleteorder");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Select order randomly to delete order and verify the message", ExtentColor.BLUE));
	
	CR.AccessingCreateOrder();
	childTest = test.createNode("AccessingCreateOrder");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing Create order page", ExtentColor.BLUE));
	test.info("Accessing Create order page");
	
	CR.verifytextsinCreateOrder();
	childTest = test.createNode("verifytextsinCreateOrder");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the label texts in Create order page", ExtentColor.BLUE));
			
	CR.NumberofMandatoryFields();
	childTest = test.createNode("NumberofMandatoryFields");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the number of Mandatory fields in Create page", ExtentColor.BLUE));
			
	CR.SaleTypeoption();
	childTest = test.createNode("SaleTypeoption");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verifying the optoin Sale Type in Create Order page", ExtentColor.BLUE));
			
	CR.VerifyOrdernofielderrormessage();
	childTest = test.createNode("VerifyOrdernofielderrormessage");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Order Number field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.Validordernofiled();
	childTest = test.createNode("Validordernofiled");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid order number and verifying application should not display error message", ExtentColor.BLUE));
			
	CR.InvalidInvoiceNo();
	childTest = test.createNode("InvalidInvoiceNo");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Invoice field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.ValidInvoicenofiled();
	childTest = test.createNode("ValidInvoicenofiled");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Invoice number and verifying application should not display error message", ExtentColor.BLUE));
			
	CR.InvalidInvoiceDate();
	childTest = test.createNode("InvalidInvoiceDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Invoice Date field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.ValidInvoicedate();
	childTest = test.createNode("ValidInvoicedate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid invoice date and verify application should not display error", ExtentColor.BLUE));
			
	CR.InvalidWHReceiptsDate();
	childTest = test.createNode("InvalidWHReceiptsDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the WH Receipts Date field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.ValidInvWHReceiptDate();
	childTest = test.createNode("ValidInvWHReceiptDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid invoice WH Reciept date and verify application should not display error", ExtentColor.BLUE));
			
	CR.OrderReceiptTime();
	childTest = test.createNode("OrderReceiptTime");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the values like HRS, AM and PM in Order Reciept time field", ExtentColor.BLUE));
			
	CR.InvalidInvoiceQty();
	childTest = test.createNode("InvalidInvoiceQty");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Invoice Quantity field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validInvoiceQty();
	childTest = test.createNode("validInvoiceQty");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid invoice Quantity values and verify application should not display error", ExtentColor.BLUE));
			
	CR.InvalidInvoiceValue();
	childTest = test.createNode("InvalidInvoiceValue");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Invoice Value field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validInvoiceValue();
	childTest = test.createNode("validInvoiceValue");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid invoice Value field values and verify application should not display error", ExtentColor.BLUE));
			
	CR.InvalidNumberOfBoxes();
	childTest = test.createNode("InvalidNumberOfBoxes");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Number of Boxes field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validNumberofBoxes();
	childTest = test.createNode("validNumberofBoxes");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Value in to Number of Boxes field and verify application should not display error", ExtentColor.BLUE));
			
	CR.InvalidWeights();
	childTest = test.createNode("InvalidWeights");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Weights field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validWeights();
	childTest = test.createNode("validWeights");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Value in to Weights field and verify application should not display error", ExtentColor.BLUE));
			
	CR.InvalidDistributorName();
	childTest = test.createNode("InvalidDistributorName");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Distributor Name field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validDistributorNameField();
	childTest = test.createNode("validDistributorNameField");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Value in to Distributor Name field and verify application should not display error", ExtentColor.BLUE));
			
	CR.InvalidDistributorID();
	childTest = test.createNode("InvalidDistributorID");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Distributor ID field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validDistributorID();
	childTest = test.createNode("validDistributorID");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Value in to Distributor ID field and verify application should not display error", ExtentColor.BLUE));
			
	CR.InvalidDistributorPhoneNumber();
	childTest = test.createNode("InvalidDistributorPhoneNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Distributor Phone number field Error messages for the invalid values", ExtentColor.BLUE));
	
	CR.validDistributorPhoneNumber();
	childTest = test.createNode("validDistributorPhoneNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Value in to Distributor phone number field and verify application should not display error", ExtentColor.BLUE));
	
	CR.InvalidLocation();
	childTest = test.createNode("InvalidLocation");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Location field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validLocation();
	childTest = test.createNode("validLocation");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Value in to Location field and verify application should not display error", ExtentColor.BLUE));
			
	CR.InvalidAreaPinCode();
	childTest = test.createNode("InvalidAreaPinCode");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Area Pin Code field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validAreaPinCode();
	childTest = test.createNode("validAreaPinCode");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Value in to Area Pin code field and verify application should not display error", ExtentColor.BLUE));
			
	CR.Statedropddown();
	childTest = test.createNode("Statedropddown");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the state drop down", ExtentColor.BLUE));
			
	CR.RegionalZone();
	childTest = test.createNode("RegionalZone");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Regional Zone name drop down", ExtentColor.BLUE));
	
	CR.VerifyRegionalZone();
	childTest = test.createNode("VerifyRegionalZone");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Regional Zone Drop down values", ExtentColor.BLUE));
			
	CR.InvalidDispatchDTfromWH();
	childTest = test.createNode("InvalidDispatchDTfromWH");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Dispatch DT WH from WH Date field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.ValidDispatchDTfromWH();
	childTest = test.createNode("ValidDispatchDTfromWH");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Passing valid Value in to Dispatch Date from WH", ExtentColor.BLUE));
			
	CR.InvalidTransporterName();
	childTest = test.createNode("InvalidTransporterName");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Transport name field Error messages for the invalid values", ExtentColor.BLUE));
			
	CR.validDTransporterName();
	childTest = test.createNode("validDTransporterName");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Enter the valid Transport Name", ExtentColor.BLUE));
			
	CR.InvalidDocketNumber();
	childTest = test.createNode("InvalidDocketNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the DocketNumber field Error messages for the invalid values", ExtentColor.BLUE));
	
	CR.validDocketNumber();
	childTest = test.createNode("validDocketNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Enter the valid value in to Docket Number field", ExtentColor.BLUE));
	
	CR.VerifyModeofTransport();
	childTest = test.createNode("VerifyModeofTransport");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Mode of Transport Drop down lists from Excel", ExtentColor.BLUE));
	
	CR.ModeofTransport();
	childTest = test.createNode("ModeofTransport");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Mode of Transport Drop down selection", ExtentColor.BLUE));
	
	CR.StandardTransitDays();
	childTest = test.createNode("StandardTransitDays");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify standard Transit days value is 3 or not", ExtentColor.BLUE));
	
	CR.InvalidExpectedDateofDelivery();
	childTest = test.createNode("InvalidExpectedDateofDelivery");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Expected Date of Delivery field Error messages for the invalid values", ExtentColor.BLUE));
	
	CR.ExpectedDateofDelivery();
	childTest = test.createNode("ExpectedDateofDelivery");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid Expected Date in Expected Date of Delivery field and verify the vaue", ExtentColor.BLUE));
			
	CR.InvalidActualDeliveryDate();
	childTest = test.createNode("InvalidActualDeliveryDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Actual Delivery Date field Error messages for the invalid values", ExtentColor.BLUE));
	
	CR.validActualDeliveryDate();
	childTest = test.createNode("validActualDeliveryDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid Actual Delivery Date and verify the field with valid data", ExtentColor.BLUE));
	
	CR.InvalidReceivedBy();
	childTest = test.createNode("InvalidReceivedBy");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Recieved by field Error messages for the invalid values", ExtentColor.BLUE));
	
	CR.validReceivedBy();
	childTest = test.createNode("validReceivedBy");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid data Recieved by and verify the field", ExtentColor.BLUE));
	
	CR.VerifyStatus();
	childTest = test.createNode("Status");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Status drop down selection from Excel values", ExtentColor.BLUE));
			
	CR.Status();
	childTest = test.createNode("Status");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Status drop down selection", ExtentColor.BLUE));
	
	CR.Remarks();
	childTest = test.createNode("Remarks");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Enter a text in Remarks", ExtentColor.BLUE));
	
	CR.invalidUpload();
	childTest = test.createNode("invalidUpload");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Upload xlsx file and verify the Error Message", ExtentColor.BLUE));
	
	CR.validUpload();
	childTest = test.createNode("validUpload");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Upload .png file and verify", ExtentColor.BLUE));
	
	CR.WarehouseOptionSelect();
	childTest = test.createNode("WarehouseOptionSelect");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Select Warehouse options from Drop down", ExtentColor.BLUE));
	
	CR.CopyValuesandVerify();
	childTest = test.createNode("CopyValuesandVerify");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Copy Entered or Selected values from Create page and verify in Home page", ExtentColor.BLUE));
	
	CR.CaluclateAllTAT();
	childTest = test.createNode("CaluclateAllTAT");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Calculate all the field TAT", ExtentColor.BLUE));
	
	CD.AccessingCreateOrderEditflow();
	childTest = test.createNode("AccessingCreateOrderEditflow");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Accessing Create order Edit page", ExtentColor.BLUE));
	
	CD.verifyttitlesinCreateOrderEditflow();
	childTest = test.createNode("verifyttitlesinCreateOrderEditflow");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the lables texts in Create order Edit page", ExtentColor.BLUE));
	
	CD.clearallfields();
	childTest = test.createNode("clearallfields");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Clearing all the fields to update the data", ExtentColor.BLUE));
	
	CD.MandatoryFieldsEditflow();
	childTest = test.createNode("MandatoryFieldsEditflow");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the number of Mandatory fields in Create Order Edit flow", ExtentColor.BLUE));
	
	CD.EditflowVerifyOrdernofielderrormessage();
	childTest = test.createNode("EditflowVerifyOrdernofielderrormessage");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Order Number field Error messages for the invalid values in Edit flow", ExtentColor.BLUE));

	CD.EditflowValidordernofiled();
	childTest = test.createNode("EditflowValidordernofiled");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid order number and verifying application should not display error message in Edit flow", ExtentColor.BLUE));
			
	CD.EditflowSaleTypeoption();
	childTest = test.createNode("EditflowSaleTypeoption");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verifying the optoin Sale Type in Create Order Edit flow", ExtentColor.BLUE));
	
	CD.EditflowInvalidInvoiceNo();
	childTest = test.createNode("EditflowInvalidInvoiceNo");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Invoice field Error messages for the invalid values", ExtentColor.BLUE));
	
	CD.EditflowValidInvoicenofiled();
	childTest = test.createNode("EditflowValidInvoicenofiled");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Invoice number and verifying application should not display error message", ExtentColor.BLUE));
	
	CD.EditflowInvalidInvoiceDate();
	childTest = test.createNode("EditflowInvalidInvoiceDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Invoice Date field Error messages for the invalid values", ExtentColor.BLUE));
	
	CD.EditflowValidInvoicedate();
	childTest = test.createNode("EditflowValidInvoicedate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid invoice date and verify application should not display error", ExtentColor.BLUE));
	
	CD.EditflowInvalidWHReceiptsDate();
	childTest = test.createNode("EditflowInvalidWHReceiptsDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the WH Receipts Date field Error messages for the invalid values", ExtentColor.BLUE));
	
	CD.EditflowValidInvWHReceiptDate();
	childTest = test.createNode("EditflowValidInvWHReceiptDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid invoice WH Reciept date and verify application should not display error", ExtentColor.BLUE));
	
	CD.EditflowOrderReceiptTime();
	childTest = test.createNode("EditflowOrderReceiptTime");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the values like HRS, AM and PM in Order Reciept time field", ExtentColor.BLUE));
	
	CD.EditflowInvalidInvoiceQty();
	childTest = test.createNode("EditflowInvalidInvoiceQty");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Invoice Quantity field Error messages for the invalid values", ExtentColor.BLUE));
	
	CD.EditflowvalidInvoiceQty();
	childTest = test.createNode("EditflowvalidInvoiceQty");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid invoice Quantity values and verify application should not display error", ExtentColor.BLUE));
	
	CD.EditflowInvalidInvoiceValue();
	childTest = test.createNode("EditflowInvalidInvoiceValue");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Invoice Value field Error messages for the invalid values", ExtentColor.BLUE));
	
	CD.EditflowvalidInvoiceValue();
	childTest = test.createNode("EditflowvalidInvoiceValue");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid invoice Value field values and verify application should not display error", ExtentColor.BLUE));
	
	CD.EditflowInvalidNumberOfBoxes();
	childTest = test.createNode("EditflowInvalidNumberOfBoxes");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Number of Boxes field Error messages for the invalid values", ExtentColor.BLUE));
	
	CD.EditflowvalidNumberofBoxes();
	childTest = test.createNode("EditflowvalidNumberofBoxes");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Value in to Number of Boxes field and verify application should not display error", ExtentColor.BLUE));
			
	CD.EditflowInvalidWeights();
	childTest = test.createNode("EditflowInvalidWeights");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Weights field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidWeights();
	childTest = test.createNode("EditflowvalidWeights");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Value in to Weights field and verify application should not display error", ExtentColor.BLUE));
			
	CD.EditflowInvalidDistributorName();
	childTest = test.createNode("EditflowInvalidDistributorName");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Distributor Name field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidDistributorNameField();
	childTest = test.createNode("EditflowvalidDistributorNameField");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Value in to Distributor Name field and verify application should not display error", ExtentColor.BLUE));
			
	CD.EditflowInvalidDistributorID();
	childTest = test.createNode("EditflowInvalidDistributorID");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Distributor ID field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidDistributorID();
	childTest = test.createNode("EditflowvalidDistributorID");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Value in to Distributor ID field and verify application should not display error", ExtentColor.BLUE));
			
	CD.EditflowInvalidDistributorPhoneNumber();
	childTest = test.createNode("EditflowInvalidDistributorPhoneNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Distributor Phone number field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidDistributorPhoneNumber();
	childTest = test.createNode("EditflowvalidDistributorPhoneNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Value in to Distributor phone number field and verify application should not display error", ExtentColor.BLUE));
			
	CD.EditflowInvalidLocation();
	childTest = test.createNode("EditflowInvalidLocation");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing Countries page and verifying page text and URL", ExtentColor.BLUE));
	test.info("Update flow - Verify the Location field Error messages for the invalid values");
	
	CD.EditflowvalidLocation();
	childTest = test.createNode("EditflowvalidLocation");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Value in to Location field and verify application should not display error", ExtentColor.BLUE));
			
	CD.EditflowInvalidAreaPinCode();
	childTest = test.createNode("EditflowInvalidAreaPinCode");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Area Pin Code field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidAreaPinCode();
	childTest = test.createNode("EditflowvalidAreaPinCode");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Value in to Area Pin code field and verify application should not display error", ExtentColor.BLUE));
			
	CD.EditflowStatedropddown();
	childTest = test.createNode("EditflowStatedropddown");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the state drop down", ExtentColor.BLUE));
			
	CD.EditflowRegionalZone();
	childTest = test.createNode("EditflowRegionalZone");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Regional Zone name drop down", ExtentColor.BLUE));
			
	CD.EditflowVerifyWarehouses();
	childTest = test.createNode("EditflowVerifyWarehouses");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verifying Warehouse drop down options with the value in Warehouse Menu value in Excel", ExtentColor.BLUE));
			
	CD.EditflowInvalidDispatchDTfromWH();
	childTest = test.createNode("EditflowInvalidDispatchDTfromWH");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Dispatch DT WH from WH Date field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowValidDispatchDTfromWH();
	childTest = test.createNode("EditflowValidDispatchDTfromWH");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Passing valid Value in to Dispatch Date from WH", ExtentColor.BLUE));
			
	CD.EditflowInvalidTransporterName();
	childTest = test.createNode("EditflowInvalidTransporterName");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Transport name field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidDTransporterName();
	childTest = test.createNode("EditflowvalidDTransporterName");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Enter the valid Transport Name", ExtentColor.BLUE));
			
	CD.EditflowInvalidDocketNumber();
	childTest = test.createNode("EditflowInvalidDocketNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the DocketNumber field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidDocketNumber();
	childTest = test.createNode("EditflowvalidDocketNumber");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Enter the valid value in to Docket Number field", ExtentColor.BLUE));
			
	CD.EditflowModeofTransport();
	childTest = test.createNode("EditflowModeofTransport");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Mode of Transport Drop down selection", ExtentColor.BLUE));
			
	CD.EditflowStandardTransitDays();
	childTest = test.createNode("EditflowStandardTransitDays");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify standard Transit days value is 3 or not", ExtentColor.BLUE));
			
	CD.EditflowInvalidExpectedDateofDelivery();
	childTest = test.createNode("EditflowInvalidExpectedDateofDelivery");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Expected Date of Delivery field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowExpectedDateofDelivery();
	childTest = test.createNode("EditflowExpectedDateofDelivery");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Enter valid Expected Date in Expected Date of Delivery field and verify the vaue", ExtentColor.BLUE));
			
	CD.EditflowInvalidActualDeliveryDate();
	childTest = test.createNode("EditflowInvalidActualDeliveryDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Actual Delivery Date field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidActualDeliveryDate();
	childTest = test.createNode("EditflowvalidActualDeliveryDate");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Enter valid Actual Delivery Date and verify the field with valid data", ExtentColor.BLUE));
			
	CD.EditflowInvalidReceivedBy();
	childTest = test.createNode("EditflowInvalidReceivedBy");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Recieved by field Error messages for the invalid values", ExtentColor.BLUE));
			
	CD.EditflowvalidReceivedBy();
	childTest = test.createNode("EditflowvalidReceivedBy");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Enter valid data Recieved by and verify the field", ExtentColor.BLUE));
			
	CD.EditflowStatus();
	childTest = test.createNode("EditflowStatus");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Verify the Status drop down selection", ExtentColor.BLUE));
			
	CD.EditflowRemarks();
	childTest = test.createNode("EditflowRemarks");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Enter a text in Remarks", ExtentColor.BLUE));
			
	CD.EditflowinvalidUpload();
	childTest = test.createNode("EditflowinvalidUpload");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Upload xlsx file and verify the Error Message", ExtentColor.BLUE));
			
	CD.EditflowvalidUpload();
	childTest = test.createNode("EditflowvalidUpload");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Upload .png file and verify", ExtentColor.BLUE));
			
	CD.EditflowWarehouseOptionSelect();
	childTest = test.createNode("EditflowWarehouseOptionSelect");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Select Warehouse options from Drop down", ExtentColor.BLUE));
			
	CD.EditflowCopyValuesandVerify();
	childTest = test.createNode("EditflowCopyValuesandVerify");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Copy Entered or Selected values from Create page and verify in Home pageL", ExtentColor.BLUE));
			
	CD.EditflowCaluclateAllTAT();
	childTest = test.createNode("EditflowCaluclateAllTAT");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Update flow - Calculate all the field TAT", ExtentColor.BLUE));
			
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
