package WH;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.SuperTestNG;
import pages.Homepage;
import pages.Landingpage;
import pages.UpdateUPPDistributor;
import pages.UppCreateDistributor;
import pages.UppDistributors;
import pages.UppMakePaymentPage;
import pages.UppPayment;
import pages.UppPaymentSearchFunctionalityPage;
import pages.UppPaymentViewpage;
import pages.ViewUPPDistributorPage;

public class UppLogin extends SuperTestNG{
	Landingpage L = new Landingpage();
	Homepage H = new Homepage();
	UppDistributors Upp = new UppDistributors();
	UppCreateDistributor Uppc = new UppCreateDistributor();
	ViewUPPDistributorPage ViewUpp = new ViewUPPDistributorPage();
	UpdateUPPDistributor UppUpdate = new UpdateUPPDistributor();
	UppPayment UppPayment = new UppPayment();
	UppPaymentSearchFunctionalityPage UppSearch = new UppPaymentSearchFunctionalityPage();
	UppPaymentViewpage UppView = new UppPaymentViewpage();	
	UppMakePaymentPage makepayment = new UppMakePaymentPage();
	
	@Test
	public void UPP() throws Exception {
		test = extent.createTest("Upp Distributor payment Flow");
		
		L.UppLogin();
		childTest = test.createNode("Upp user login");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Login with valid super Admin credentials", ExtentColor.BLUE));
		
		H.verifycopyright();
		childTest = test.createNode("Verify copyright");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify copy right message", ExtentColor.BLUE));
						
		H.getprofileusername();
		childTest = test.createNode("Verify profile username");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the username between Nav bar riht side and user profile", ExtentColor.BLUE));
		
		Upp.AccessingUppDistributor();
		childTest = test.createNode("Access UPP Distributor page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessting UPP Distributor page and verifying the URL", ExtentColor.BLUE));
		
		Upp.VerifyUppDistributorpage();
		childTest = test.createNode("Verify UPP page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify Create Distrutor button, view, update and delete button", ExtentColor.BLUE));
		
		Upp.VerifyColumnNames();
		childTest = test.createNode("CheckColumnNames");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verifying UPP Distributor page Table column names", ExtentColor.BLUE));
		
		Uppc.AccessCreateUppDistributor();
		childTest = test.createNode("AccessCreateUppDistributor");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Access upp create distributor page and verify the URL", ExtentColor.BLUE));
		
		Uppc.verifythetitles();
		childTest = test.createNode("verify the titles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the title of the page and the titles of the fields", ExtentColor.BLUE));
		
		Uppc.TotalMandatoryfields();
		childTest = test.createNode("verify Mandatory fields");
		childTest.log(Status.PASS, MarkupHelper.createLabel("verify total number of Mandatory fields in a page", ExtentColor.BLUE));
		
		Uppc.InvalidUppDistName();
		childTest = test.createNode("InvalidUppDistName");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the ErrorMessage of UPP Distributor Name fields", ExtentColor.BLUE));
		
		Uppc.validUPPDistName();
		childTest = test.createNode("Valid Upp Dist Name");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Valid Dist name and verify the error message displayed or not", ExtentColor.BLUE));
		
		Uppc.InvalidUppNumber();
		childTest = test.createNode("Invalid Upp Dist Number");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid UPP Number name and verify the error message", ExtentColor.BLUE));
		
		Uppc.validUPPNumber();
		childTest = test.createNode("Valid Upp Dist Number");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Valid UPP Number name and verify the error count in the page", ExtentColor.BLUE));
		
		Uppc.InvalidDate();
		childTest = test.createNode("InValid A date");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid A date and verify the error Message", ExtentColor.BLUE));
		
		Uppc.ValidADate();
		childTest = test.createNode("Valid A date");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid A date and verify the error counts", ExtentColor.BLUE));
		
		Uppc.InvalidUppName();
		childTest = test.createNode("Invalid Upp Name field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid Data in UPP Name field and verify the error Messages", ExtentColor.BLUE));
		
		Uppc.validUPPName();
		childTest = test.createNode("Valid Upp Name");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid data in UPP Name field and verify the error counts", ExtentColor.BLUE));
		
		Uppc.InvalidDistID();
		childTest = test.createNode("Invalid Dist ID");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter invalid data in Dist ID field and verify the error Messages", ExtentColor.BLUE));
		
		Uppc.validDistID();
		childTest = test.createNode("Valid Dist ID");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid data in Dist ID field and verify the error count", ExtentColor.BLUE));
		
		Uppc.Invalidplace();
		childTest = test.createNode("Invalid place");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid data in place field and verify the error Message", ExtentColor.BLUE));
		
		Uppc.validplace();
		childTest = test.createNode("Valid place");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an valid data in place field and verify the error count", ExtentColor.BLUE));
		
		Uppc.InvalidStateField();
		childTest = test.createNode("Invalid State field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an invalid data in State field and verify the error Messages", ExtentColor.BLUE));
		
		Uppc.validStateField();
		childTest = test.createNode("Valid State field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an valid data in State field and verify the error count", ExtentColor.BLUE));
		
		Uppc.Status();
		childTest = test.createNode("Status Dropdown");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Select the status Randomly", ExtentColor.BLUE));
		
		Uppc.InvalidContactNumber();
		childTest = test.createNode("Invalid Contact Number Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an invalid data in Contact Number field and verify the error Messages", ExtentColor.BLUE));
		
		Uppc.validContactNumber();
		childTest = test.createNode("Valid Contact Number Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an valid data in Contact Number field and verify the error count", ExtentColor.BLUE));
		
		Uppc.InvalidEmailAddress();
		childTest = test.createNode("Invalid Email Address Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an invalid data in Email field and verify the error Message", ExtentColor.BLUE));

//		uncommented by modifying the script, Still developers has to fix the issue
		Uppc.validEmailAddress();
		childTest = test.createNode("valid Email Address Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an valid data in Email field and verify the error count", ExtentColor.BLUE));
		
		ViewUpp.AccessUppViewPage();
		childTest = test.createNode("Accessing view page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing UPP view page and veirfy the title of the page", ExtentColor.BLUE));
		
		ViewUpp.verifyViewtitles();
		childTest = test.createNode("Verify view page Titles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the titles of the fields in View UPP page", ExtentColor.BLUE));
		
		ViewUpp.VerifyTheValues();
		childTest = test.createNode("Verify The values of view page fields");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Compare the Upp distributor table and view page values", ExtentColor.BLUE));
		
		UppUpdate.AccessUpdateUppDistributor();
		childTest = test.createNode("Accessing UPP Update Distributor page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing UPP Update Distributor page", ExtentColor.BLUE));
		
		UppUpdate.clearallfields();
		childTest = test.createNode("Clearing all the fields in Update UPP Distributor page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Clearing all the fields in Update UPP Distributor page and verifying the error count", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateUppDistName();
		childTest = test.createNode("Update-InvalidUppDistName");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the ErrorMessage of UPP Distributor Name fields in Update page", ExtentColor.BLUE));
		
		UppUpdate.validUpdateUPPDistName();
		childTest = test.createNode("Valid Update Upp Dist Name");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Valid Dist name and verify the error message displayed or not", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateUppNumber();
		childTest = test.createNode("Invalid Update Upp Dist Number");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid UPP Number name and verify the error message", ExtentColor.BLUE));
		
		UppUpdate.validUpdateUPPNumber();
		childTest = test.createNode("Valid Update Upp Dist Number");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Valid UPP Number name and verify the error count in the page", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateDate();
		childTest = test.createNode("InValid Update A date");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid A date and verify the error Message", ExtentColor.BLUE));
		
		UppUpdate.ValidUpdateADate();
		childTest = test.createNode("Valid Update A date");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid A date and verify the error counts", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateUppName();
		childTest = test.createNode("Invalid Update Upp Name field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid Data in UPP Name field and verify the error Messages", ExtentColor.BLUE));
		
		UppUpdate.validUpdateUPPName();
		childTest = test.createNode("Valid Update Upp Name");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid data in UPP Name field and verify the error counts", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateDistID();
		childTest = test.createNode("Invalid Update Dist ID");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter invalid data in Dist ID field and verify the error Messages", ExtentColor.BLUE));
		
		UppUpdate.validUpdateDistID();
		childTest = test.createNode("Valid Update Dist ID");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid data in Dist ID field and verify the error count", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateplace();
		childTest = test.createNode("Invalid Update place");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid data in place field and verify the error Message", ExtentColor.BLUE));
		
		UppUpdate.validUpdateplace();
		childTest = test.createNode("Valid Update place");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an valid data in place field and verify the error count", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateStateField();
		childTest = test.createNode("Invalid Update State field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an invalid data in State field and verify the error Messages", ExtentColor.BLUE));
		
		UppUpdate.validUpdateStateField();
		childTest = test.createNode("Valid Update State field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an valid data in State field and verify the error count", ExtentColor.BLUE));
		
		UppUpdate.StatusUpdate();
		childTest = test.createNode("Status Update Dropdown");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Select the status Randomly", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateContactNumber();
		childTest = test.createNode("Invalid Update Contact Number Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an invalid data in Contact Number field and verify the error Messages", ExtentColor.BLUE));
		
		UppUpdate.validUpdateContactNumber();
		childTest = test.createNode("Valid Update Contact Number Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an valid data in Contact Number field and verify the error count", ExtentColor.BLUE));
		
		UppUpdate.InvalidUpdateEmailAddress();
		childTest = test.createNode("Invalid Update Email Address Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an invalid data in Email field and verify the error Message", ExtentColor.BLUE));
		
		UppUpdate.validUpdateEmailAddress();
		childTest = test.createNode("valid Update Email Address Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter an valid data in Email field and verify the error count", ExtentColor.BLUE));
		
		Upp.DeleteUppDistributor();
		childTest = test.createNode("Delete UPP Distributor");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Delete first UPP Distributor and verify the success message", ExtentColor.BLUE));
		
		UppPayment.AccessUppPaymentPage();
		childTest = test.createNode("Accessing UPP Payment page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing UPP Payment page", ExtentColor.BLUE));
		
		UppPayment.VerifyTitles();
		childTest = test.createNode("Verify titles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the page title and fields lables", ExtentColor.BLUE));
		
		UppPayment.UppPaymentExportexcel();
		childTest = test.createNode("Verify titles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the page title and fields lables", ExtentColor.BLUE));
		
		UppPayment.VerifyNoOfTransaction();
		childTest = test.createNode("Verif the Number of Transaction");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the Transaction betweeb Applicaiton and Exported Excel sheet", ExtentColor.BLUE));
		
		UppPayment.printandVerifycolumnnames();
		childTest = test.createNode("Print the column Names");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify Excel column name between Excel and Application", ExtentColor.BLUE));
		
		UppPayment.TableCoulumnCount();
		childTest = test.createNode("VerifyColumnCount");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify The number of Column Titles we have in Applicaiton", ExtentColor.BLUE));
		
		UppPayment.columnnames();
		childTest = test.createNode("Get Column names");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Get Column names and Verify the names against an Array", ExtentColor.BLUE));
		
		UppSearch.SearchFieldlables();
		childTest = test.createNode("Search Field lables");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the search fields labels", ExtentColor.BLUE));
		
		UppSearch.SearchError();
		childTest = test.createNode("Search Error");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Validate an error message when there is not data entered", ExtentColor.BLUE));
		
		UppSearch.DistIDSearchfieldErrorMessage();
		childTest = test.createNode("Distributor ID Search Error");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Validate an error message wof Disttributor ID field", ExtentColor.BLUE));
		
		UppSearch.DistIDSearchfield();
		childTest = test.createNode("Search Distributor ID");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Random value and Verify the count of Dist ID between application and Excel", ExtentColor.BLUE));
		
		UppSearch.UppNumberSearchfieldErrorMessage();
		childTest = test.createNode("UPP NO Search error");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Validate an error message of Upp No.ID field", ExtentColor.BLUE));
		
//		Commenting this issue as there is a open bug in GitHub on this
//		UppSearch.UppNumberSearch();
//		childTest = test.createNode("Search Distributor ID");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Random value and Verify the count of Dist ID between application and Excel", ExtentColor.BLUE));
		
		UppSearch.UppOrderIDErrorMessage();
		childTest = test.createNode("Search Order ID Error Message");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Validate an error message of Upp Order ID field", ExtentColor.BLUE));
			
		UppSearch.UppOrderIDfield();
		childTest = test.createNode("Search Order ID");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Random Order id and search for the same and verify between Applicaiton and Excel", ExtentColor.BLUE));
		
		UppSearch.UppOrderDateErrorMessage();
		childTest = test.createNode("Search Order Date");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Validate an error message of Upp Order Date field", ExtentColor.BLUE));
		
//		Commenting this because we have to remove data of 0000-00-00 00:00:00 format, as we are getting an parsing issue
//		UppSearch.UppOrderDatefield();
//		childTest = test.createNode("Upp Order Date");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Entre the Date choosed randomly and Verify the count", ExtentColor.BLUE));
		
		UppSearch.OrdeSheetUpload();
		childTest = test.createNode("Order sheet upload");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Check the checkbox and verify the uploaded in link in next tab", ExtentColor.BLUE));
		
		UppSearch.UppOrderStatusSuccess();
		childTest = test.createNode("Success Order Status");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Select the Success order status and verify the count comparing to Excel", ExtentColor.BLUE));
		
		UppSearch.UppOrderStatusFailure();
		childTest = test.createNode("Filure Order Status");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Select the Failure order status and verify the count comparing to Excel", ExtentColor.BLUE));
		
		UppSearch.UppOrderStatusAborted();
		childTest = test.createNode("Aborted Order Status");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Select the Aborted order status and verify the count comparing to Excel", ExtentColor.BLUE));
		
		UppSearch.UppOrderStatusInvalid();
		childTest = test.createNode("Invalid Order Status");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Select the Invalid order status and verify the count comparing to Excel", ExtentColor.BLUE));
		
		UppSearch.UppOrderStatusInitiated();
		childTest = test.createNode("Initiated Order Status");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Select the Initiated order status and verify the count comparing to Excel", ExtentColor.BLUE));
		
		UppSearch.UppOrderStatusTimeout();
		childTest = test.createNode("Timeout Order Status");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Select the Timeout order status and verify the count comparing to Excel", ExtentColor.BLUE));
		
		UppSearch.DistidAndStatusSuccessSearch();
		childTest = test.createNode("Dist Id and Success Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records of Dist id who's status is success", ExtentColor.BLUE));
		
		UppSearch.DistIDandFailureStatusSearch();
		childTest = test.createNode("Dist Id and Failure Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records of Dist id who's status is Failure", ExtentColor.BLUE));
		
		UppSearch.DistidAndAbortedStatus();
		childTest = test.createNode("Dist Id and Aborted Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records of Dist id who's status is Aborted", ExtentColor.BLUE));
		
		UppSearch.DistidAndInvalidStatus();
		childTest = test.createNode("Dist Id and Invalid Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records of Dist id who's status is Invalid", ExtentColor.BLUE));
		
		UppSearch.DistidAndInitiatedStatus();
		childTest = test.createNode("Dist Id and Initiated Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records of Dist id who's status is Initiated", ExtentColor.BLUE));
		
		UppSearch.DistidAndTimeOutStatus();
		childTest = test.createNode("Dist Id and Time out Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records of Dist id who's status is Time out", ExtentColor.BLUE));
		
//		Commenting this as we still have UPP Number search issue open in GitHb, wherein Space in UPPnumber Search result in application is not showing
//		UppSearch.UppNumberAndSuccessStatus();
//		childTest = test.createNode("Upp Number and Success status Search");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of UPP Number of Success Status", ExtentColor.BLUE));
		
//		UppSearch.UppNumberAndFailureStatus();;
//		childTest = test.createNode("Upp Number and Failure status Search");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of UPP Number of Failure Status", ExtentColor.BLUE));
		
//		UppSearch.UppNumberAndAbortedStatus();
//		childTest = test.createNode("Upp Number and Aborted status Search");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of UPP Number of Aborted Status", ExtentColor.BLUE));
		
//		UppSearch.UppNumberAndInvalidStatus();
//		childTest = test.createNode("Upp Number and Invalid status Search");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of UPP Number of Invalid Status", ExtentColor.BLUE));
		
//		UppSearch.UppNumberAndInitiatedStatus();
//		childTest = test.createNode("Upp Number and Initiated status Search");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of UPP Number of Initiated Status", ExtentColor.BLUE));
		
//		UppSearch.UppNumberAndTimeoutStatus();
//		childTest = test.createNode("Upp Number and Timeout status Search");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of UPP Number of Timeout Status", ExtentColor.BLUE));
		
		UppSearch.DatewithDistIDCombinationSearch();
		childTest = test.createNode("Dist ID and Date Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of Distributor ID and Order Date", ExtentColor.BLUE));
		
//		UppSearch.UppNumberCombinationwithDate();
//		childTest = test.createNode("Upp Number and Date Search");
//		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of Upp Number and Order Date", ExtentColor.BLUE));
		
		UppSearch.DatewithSuccess();
		childTest = test.createNode("Success status and Date Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of Success drop down and Order Date", ExtentColor.BLUE));
		
		UppSearch.DatewithFailure();
		childTest = test.createNode("Failure status and Date Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of Failure drop down and Order Date", ExtentColor.BLUE));
		
		UppSearch.DatewithAborted();
		childTest = test.createNode("Aborted status and Date Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of Aborted drop down and Order Date", ExtentColor.BLUE));
		
		UppSearch.DatewithInvalid();
		childTest = test.createNode("Invalid status and Date Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of Invalid drop down and Order Date", ExtentColor.BLUE));
		
		UppSearch.DatewithInitiated();
		childTest = test.createNode("Initiated status and Date Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of Initiated drop down and Order Date", ExtentColor.BLUE));
		
		UppSearch.DatewithTimeout();
		childTest = test.createNode("Timeout status and Date Search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Search records with the combination of Timeout drop down and Order Date", ExtentColor.BLUE));
		
		UppView.ViewInitiatedStatus();
		childTest = test.createNode("Verify UPP Modified and Response field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify field Upp Modified date field and Upp Response date field should be empty", ExtentColor.BLUE));
		
		UppView.AccessUppPaymentViewModel();
		childTest = test.createNode("Upp Payment View Model");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Access to UppPayment HTML table view page", ExtentColor.BLUE));
		
		UppView.verifyTitleNames();
		childTest = test.createNode("Verify Titles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the lables of the fields", ExtentColor.BLUE));
		
		UppView.BacktoParenttab();
		childTest = test.createNode("Back to Parent Tab");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Come back to Parent tab using Window Handling", ExtentColor.BLUE));
		
		makepayment.AccessingMakePaymentPage();
		childTest = test.createNode("Make payment page");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Accessing to make Payment page", ExtentColor.BLUE));
		
		makepayment.VeifyTitles();
		childTest = test.createNode("Make payment Veify titles");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify field title names", ExtentColor.BLUE));
		
		makepayment.VerifyFieldTexts();
		childTest = test.createNode("Verify Help texts");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify help texts which come under each fields", ExtentColor.BLUE));
		
		makepayment.UnicityLogoRefresh();
		childTest = test.createNode("Verify Unicity logo");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Refresh the page by clicking on Unicity logo", ExtentColor.BLUE));
		
		makepayment.VerifyAllmenus();
		childTest = test.createNode("Verify Menus");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify left hand side menus", ExtentColor.BLUE));
		
		makepayment.Menuaboutus();
		childTest = test.createNode("Menu About US");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Access Menu About us", ExtentColor.BLUE));
		
		makepayment.MenuContactUS();
		childTest = test.createNode("Menu Contact US");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Access Menu Contact us", ExtentColor.BLUE));
		
		makepayment.MenuTermsnAndConditions();
		childTest = test.createNode("Menu Terms and Conditions");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Access Menu Terms and conditions", ExtentColor.BLUE));
		
		makepayment.MenuPoliciesAndProcedures();
		childTest = test.createNode("Menu Policies and Procedures");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Access Menu Policies and Procedures", ExtentColor.BLUE));
		
		makepayment.MenuUppPayments();
		childTest = test.createNode("Menu Upp payments");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Access Menu Upp Payments", ExtentColor.BLUE));
		
		makepayment.TotalErrorCount();
		childTest = test.createNode("Total Error count");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify Total number of error count in the page", ExtentColor.BLUE));
		
		makepayment.InvalidUppNamefield();
		childTest = test.createNode("Invalid Data UppName Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter invalid data in Upp Name field and verify the error message", ExtentColor.BLUE));
		
		makepayment.CombinationInvalidUppNamefield();
		childTest = test.createNode("Combination Invalid UppName Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter the Invalid combination of Upp Name field", ExtentColor.BLUE));
		
		makepayment.InvalidUppNumberfield();
		childTest = test.createNode("Invalid Data Upp Number Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter invalid data in Upp Number field and verify the error message", ExtentColor.BLUE));
		
		makepayment.CombinationInvalidUppNumberfield();
		childTest = test.createNode("Combination Invalid Upp Number Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter the Invalid combination of UPp Number", ExtentColor.BLUE));
		
		makepayment.InvalidDistIdfield();
		childTest = test.createNode("Invalid Dist ID Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid data in Dist id field and verify the error Message", ExtentColor.BLUE));
		
		makepayment.CombinationInvalidDistIDfield();
		childTest = test.createNode("Combination Invalid Dist ID Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter the Invalid combination Dist ID", ExtentColor.BLUE));
		
		makepayment.InvalidAmountfield();
		childTest = test.createNode("Invalid Amount Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid data in Amount field and verify the error Message", ExtentColor.BLUE));
		
		makepayment.validAmountField();
		childTest = test.createNode("valid Amount Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid data in Amount field and verify the error count", ExtentColor.BLUE));
		
		makepayment.InvalidPhoneNumber();
		childTest = test.createNode("Invalid Contact Number Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid data in Contact number field and verify the error message", ExtentColor.BLUE));
		
		makepayment.Validphonenumber();
		childTest = test.createNode("valid Contact Number Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid data in Contact number field and verify the error count", ExtentColor.BLUE));
		
		makepayment.InvalidEmail();
		childTest = test.createNode("Invalid Email Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter Invalid data in Email field and verify the error message", ExtentColor.BLUE));
		
		makepayment.validemail();
		childTest = test.createNode("valid Email Field");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter valid data in Email field and verify the error count", ExtentColor.BLUE));
		
		makepayment.combinationvalidation();
		childTest = test.createNode("Verify The validation message");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the validation message of UPP No, UPP Name and Dist ID combination", ExtentColor.BLUE));
		
		makepayment.AbortTransaction();
		childTest = test.createNode("Make Abort transaction");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Make Abort transactiona and verify the status by searching", ExtentColor.BLUE));
		
		makepayment.InitiatedOrder();
		childTest = test.createNode("Verify Status Initiated Transaction");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter all valid data and Close the Transaction browser and check for status Initiated in Application", ExtentColor.BLUE));
		
		makepayment.SuccessfullTransaction();
		childTest = test.createNode("Verify Status Succesful Transaction");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Enter all valid data and Close the Transaction browser and check for status success in Application", ExtentColor.BLUE));
		
		makepayment.uploaddocument();
		childTest = test.createNode("Upload Excel for Succesful Transaction");
		childTest.log(Status.PASS, MarkupHelper.createLabel("UPP Payemnt make successful transaction and upload excel as well", ExtentColor.BLUE));
		
		UppSearch.VerifyExportDistidSearch();
		childTest = test.createNode("Search using Dist ID and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.VerifyExportUppNoSearch();
		childTest = test.createNode("Search using Upp No and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.VerifyExportUppOrderIDSearch();
		childTest = test.createNode("Search using OrderID and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.ExportSuccessStatusSearch();
		childTest = test.createNode("Search by Status Success and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.ExportFailureStatusSearch();
		childTest = test.createNode("Search by Status Failure and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.ExportAbortedStatusSearch();
		childTest = test.createNode("Search by Status Aborted and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.ExportInvalidStatusSearch();
		childTest = test.createNode("Search by Status Invalid and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.ExportInitiatedStatusSearch();
		childTest = test.createNode("Search by Status Initiated and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.ExportTimeoutStatusSearch();
		childTest = test.createNode("Search by Status Timeout and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));
		
		UppSearch.EportOrderSheetUpload();
		childTest = test.createNode("Search by Order Upload sheet checkbox and then export the search");
		childTest.log(Status.PASS, MarkupHelper.createLabel("Verify the row count of Exported Excel comparing to HTML rows in Application", ExtentColor.BLUE));

		L.logout();
		childTest = test.createNode("Logout function");
		childTest.info("Closing the session by Logout");
		
	}

}
