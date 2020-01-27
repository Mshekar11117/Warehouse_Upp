package pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM.CreateOrderPOM;
import POM.HomepagePOM;
import POM.SearchfunctionalityPOM;
import POM.TablesPOM;
import POM.WHTablesPOM;
import base.SuperTestNG;
import utilities.Excel;

public class CreateOrder extends SuperTestNG {

	public void AccessingCreateOrder() {
		HomepagePOM H = new HomepagePOM(driver);
		H.WarehouseOrdermenu().click();
		H.CreateOrder().click();
	}

	public void verifytextsinCreateOrder() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String pagetitle = C.pagetitle().getText();
		Assert.assertEquals(prop.getProperty("CreateOrder"), pagetitle);

		String Saletype = C.LabelSaleType().getText();
		Assert.assertEquals(prop.getProperty("Saletypes"), Saletype);

		String Orderno = C.LabelOrderORSONumber().getText();
		Assert.assertEquals(prop.getProperty("OrderNumber"), Orderno);

		String invoiceno = C.LabelInvoiceORPSNumber().getText();
		Assert.assertEquals(prop.getProperty("InvoiceNumber"), invoiceno);

		String Invoicedate = C.LabelInvoiceDate().getText();
		Assert.assertEquals(prop.getProperty("InvoiceDate"), Invoicedate);

		String InvwhReceiptsDate = C.LabelInvWHReceiptsDate().getText();
		Assert.assertEquals(prop.getProperty("InvWhReceiptsDate"), InvwhReceiptsDate);

		String OrderReceiptTimeInWH = C.LabelOrderReceiptTimeInWH().getText();
		Assert.assertEquals(prop.getProperty("OrderReceiptTime"), OrderReceiptTimeInWH);

		String InvoiceQuantity = C.labelInvoiceQuantity().getText();
		Assert.assertEquals(prop.getProperty("InvoiceQunatity"), InvoiceQuantity);

		String Invoicevalue = C.labelInvoiceValue().getText();
		Assert.assertEquals(prop.getProperty("InvoiceValue"), Invoicevalue);

		String NoofBoxes = C.Labelnumberofboxes().getText();
		Assert.assertEquals(prop.getProperty("NumberOfBoxes"), NoofBoxes);

		String Weight = C.LabelWeights().getText();
		Assert.assertEquals(prop.getProperty("Weights"), Weight);

		String Distributorname = C.LabelDistributorname().getText();
		Assert.assertEquals(prop.getProperty("Distributorname"), Distributorname);

		String DistributorID = C.LabelDistributorIDORUPP().getText();
		Assert.assertEquals(prop.getProperty("DistributorIDORUPP"), DistributorID);

		String Distributorphone = C.LableDistributorphone().getText();
		Assert.assertEquals(prop.getProperty("Distributorphone"), Distributorphone);

		String Location = C.LabelLocation().getText();
		Assert.assertEquals(prop.getProperty("Location"), Location);

		String Areapincode = C.LabelAreapincode().getText();
		Assert.assertEquals(prop.getProperty("Areapincode"), Areapincode);

		String State = C.LabelState().getText();
		Assert.assertEquals(prop.getProperty("State"), State);

		String RegionalZoneName = C.LabelRegionalzonename().getText();
		Assert.assertEquals(prop.getProperty("Regionalzonename"), RegionalZoneName);

		String Warehouse = C.LabelWarehouse().getText();
		Assert.assertEquals(prop.getProperty("Warehouse"), Warehouse);

		String DispatchDTfromWH = C.LabelDispatchDTfromWH().getText();
		Assert.assertEquals(prop.getProperty("DispatchDTfromWH"), DispatchDTfromWH);

		String TransporterName = C.LabelTransporterName().getText();
		Assert.assertEquals(prop.getProperty("TransporterName"), TransporterName);

		String Docketno = C.LabelDocketNo().getText();
		Assert.assertEquals(prop.getProperty("DocketNo"), Docketno);

		String ModeofTransport = C.LabelModeofTransport().getText();
		Assert.assertEquals(prop.getProperty("ModeofTransport"), ModeofTransport);

		String StandardTransitdays = C.LabelStandardTransitdays().getText();
		Assert.assertEquals(prop.getProperty("StandardTransitdays"), StandardTransitdays);

		String ExpectedDateofDelivery = C.LabelExpectedDateOfDelivery().getText();
		Assert.assertEquals(prop.getProperty("ExpectedDateofDelivery"), ExpectedDateofDelivery);

		String ActualDeliveryDate = C.LabelActualDeliveryDate().getText();
		Assert.assertEquals(prop.getProperty("ActualDeliveryDate"), ActualDeliveryDate);

		String ReceivedBy = C.LabelReceivedBy().getText();
		Assert.assertEquals(prop.getProperty("ReceivedBy"), ReceivedBy);

		String Status = C.labelStatus().getText();
		Assert.assertEquals(prop.getProperty("Status"), Status);

		String DSTeamOrderSenttoWH = C.LabelDSTeamOrderSenttoWHTATDays().getText();
		Assert.assertEquals(prop.getProperty("DSTeamOrderSenttoWHTAT"), DSTeamOrderSenttoWH);

		String WHprocessingTATDays = C.LabelWHprocessingTATDays().getText();
		Assert.assertEquals(prop.getProperty("WHprocessingTATDays"), WHprocessingTATDays);

		String CourierTeamTransistTATDays = C.LabelCourierTeamTAT().getText();
		Assert.assertEquals(prop.getProperty("CourierTeamTransistTATDays"), CourierTeamTransistTATDays);

		String ActualOrderDeliveryTAT = C.labelActualOrderDeliveryTAT().getText();
		Assert.assertEquals(prop.getProperty("ActualOrderDeliveryTAT"), ActualOrderDeliveryTAT);

		String Remarks = C.LabelRemarks().getText();
		Assert.assertEquals(prop.getProperty("Remarks"), Remarks);

		String UploadPOD = C.LabelUploadPOD().getText();
		Assert.assertEquals(prop.getProperty("UploadPOD"), UploadPOD);

		String UploadPODText = C.Uploadwarningtext().getText();
		Assert.assertEquals(prop.getProperty("UploadPODText"), UploadPODText);
	}

	public void NumberofMandatoryFields() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Savebutton().click();

		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")), errorcount);

		Assert.assertTrue(C.commonerrormessage().isDisplayed());
	}

	public void SaleTypeoption() throws Exception {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		int count = C.SaleTypedropdownOptions().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Saletypeoption")), count);

		Select select = new Select(C.SaleTypedropdown());
		int random = ThreadLocalRandom.current().nextInt(1, count);
		select.selectByIndex(random);
		C.Savebutton().click();

		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 1, errorcount);

	}

	public void VerifyOrdernofielderrormessage() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		WHTablesPOM W = new WHTablesPOM(driver);
		SoftAssert s = new SoftAssert();

		C.OrderORSONumberfield().clear();
		C.OrderORSONumberfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 2, 0));
		C.Savebutton().click();
		String OrderNo = C.OrderNumberfieldErrorMessage().getText();

		C.OrderORSONumberfield().clear();
		C.OrderORSONumberfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 5, 0));
		C.Savebutton().click();
		String emptryorder = C.OrderNumberfieldErrorMessage().getText();

		C.OrderORSONumberfield().clear();
		C.OrderORSONumberfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 3, 0));
		C.Savebutton().click();
		String order = C.OrderNumberfieldErrorMessage().getText();

		s.assertEquals(Excel.getCellValue(xlPath, sheetname7, 2, 2), OrderNo);
		s.assertEquals(Excel.getCellValue(xlPath, sheetname7, 3, 2), order);
		s.assertEquals(Excel.getCellValue(xlPath, sheetname7, 4, 2), emptryorder);
		s.assertAll();
		C.OrderORSONumberfield().clear();

		H.WarehouseOrdermenu().click();
		String orderno = W.firstdisplayedorderintable().getText();

		H.CreateOrder().click();
		C.OrderORSONumberfield().sendKeys(orderno);
		C.Savebutton().click();
		String duplicate = C.OrderNumberfieldErrorMessage().getText();

		s.assertEquals(Excel.getCellValue(xlPath, sheetname7, 5, 2), duplicate);
		C.OrderORSONumberfield().clear();

	}

	public void Validordernofiled() throws Exception {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		CreateOrder CO = new CreateOrder();

		CO.SaleTypeoption();

		C.OrderORSONumberfield().sendKeys(genData.generateRandomAlphaNumeric(9));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 2, errorcount);

		C.OrderORSONumberfield().clear();
		C.OrderORSONumberfield().sendKeys(genData.generateRandomNumber(9));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 2, errorcount);
	}

	public void InvalidInvoiceNo() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		SoftAssert S = new SoftAssert();

		String emptyvalue = C.InvoiceNumberfieldErrorMessage().getText().trim();

		C.InvoiceORPSNumberfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 9, 0));
		C.Savebutton().click();
		String special = C.InvoiceNumberfieldErrorMessage().getText().trim();

		S.assertEquals(Excel.getCellValue(xlPath, sheetname7, 10, 2).trim(), emptyvalue);
		S.assertEquals(Excel.getCellValue(xlPath, sheetname7, 9, 2).trim(), special);
		S.assertAll();

		C.InvoiceORPSNumberfield().clear();
	}

	public void ValidInvoicenofiled() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.InvoiceORPSNumberfield().sendKeys(genData.generateRandomNumber(5));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 3, errorcount);

		C.InvoiceORPSNumberfield().clear();
		C.InvoiceORPSNumberfield().sendKeys(genData.generateRandomAlphaNumeric(9));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 3, errorcount);
	}

	public void InvalidInvoiceDate() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		String emptyvalue = C.InvoiceDatefieldError().getText().trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 16, 2).trim(), emptyvalue);

		C.Invoicedatefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 14, 0));
		C.Savebutton().click();
		String ddmmyyy = C.InvoiceDatefieldError().getText().trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 14, 2), ddmmyyy);

		C.Invoicedatefield().clear();
		C.Invoicedatefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 15, 0));
		C.Savebutton().click();
		String number = C.InvoiceDatefieldError().getText().trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 14, 2), number);

// 		Getting current Month and year and verifying with the Datepicker		
		LocalDate currentDate = LocalDate.now();
		Month m = currentDate.getMonth();
		int y = currentDate.getYear();
		String monthyear = m + " " + Integer.toString(y);
		C.Invoicedatefield().clear();
		C.Invoicedatefield().click();
		String Datepickertitle = C.DatePickerTitle().getText().toLowerCase();

//		Click on Next in Datepicker and pick the future date		
		C.NextInvoiceUIDatePicker().click();
		int dates = C.CalenderDates().size();
		Random random = new Random();
		int datecount = random.nextInt(dates);
		WebElement date = C.CalenderDates().get(datecount);
		date.click();
		C.Savebutton().click();
		String futuredateerror = C.InvoiceDatefieldError().getText();

		Assert.assertEquals(Datepickertitle, monthyear.toLowerCase());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 15, 2), futuredateerror);

		C.Invoicedatefield().clear();
		C.Invoicedatefield().sendKeys(Keys.TAB);
	}

	public void ValidInvoicedate() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Invoicedatefield().click();
		C.PrevInvoiceUIDatePicker().click();

		int dates = C.CalenderDates().size();
		Random random = new Random();
		int datecount = random.nextInt(dates);
		WebElement date = C.CalenderDates().get(datecount);
		date.click();
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 4, errorcount);
	}

	public void InvalidWHReceiptsDate() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String emptyvalue = C.InvWHReceiptDatefieldErrormessage().getText().trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 22, 2).trim(), emptyvalue);

		C.InvWHReceiptsDatefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 21, 0));
		C.Savebutton().click();
		String ddmmyyy = C.InvWHReceiptDatefieldErrormessage().getText().trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 21, 2).trim(), ddmmyyy);

		C.InvWHReceiptsDatefield().clear();
		C.InvWHReceiptsDatefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 22, 0));
		C.Savebutton().click();
		String number = C.InvWHReceiptDatefieldErrormessage().getText().trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 21, 2).trim(), number);

// 		Getting current Month and year and verifying with the Datepicker		
		LocalDate currentDate = LocalDate.now();
		Month m = currentDate.getMonth();
		int y = currentDate.getYear();
		String monthyear = m + " " + Integer.toString(y);
		C.InvWHReceiptsDatefield().clear();
		C.InvWHReceiptsDatefield().click();
		String Datepickertitle = C.DatePickerTitle().getText().toLowerCase();
		Assert.assertEquals(Datepickertitle, monthyear.toLowerCase());

		C.InvWHReceiptsDatefield().click();
		C.NextInvoiceUIDatePicker().click();
		C.NextInvoiceUIDatePicker().click();

//		Get the size of the dates and then click on one date randomly
		int dates = C.CalenderDates().size();
		Random random = new Random();
		int datecount = random.nextInt(dates);
		WebElement prevdate = C.CalenderDates().get(datecount);
		prevdate.click();
		C.Savebutton().click();
		String futuredate = C.InvWHReceiptDatefieldErrormessage().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 24, 2), futuredate);

		C.InvWHReceiptsDatefield().clear();
		C.InvWHReceiptsDatefield().click();

//		Select a date which is 2 month old from today date
		LocalDate mydate = LocalDate.now();
		mydate = mydate.minusMonths(2);
		String strDate = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(mydate);

		C.InvWHReceiptsDatefield().sendKeys(strDate);
		C.Savebutton().click();
		String datenotequl = C.InvWHReceiptDatefieldErrormessage().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 23, 2), datenotequl);

		C.InvWHReceiptsDatefield().clear();
		C.InvWHReceiptsDatefield().sendKeys(Keys.TAB);

	}

	public void ValidInvWHReceiptDate() throws Exception {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.InvWHReceiptsDatefield().click();

		String oldDate = C.Invoicedatefield().getAttribute("value");
		System.out.println("Old Date---" + oldDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(oldDate));
		cal.add(Calendar.DATE, 1);
		String convertedDate = dateFormat.format(cal.getTime());

		C.InvWHReceiptsDatefield().sendKeys(convertedDate);
		C.Savebutton().click();

		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 5, errorcount);
	}

	public void OrderReceiptTime() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		int hrs = C.HoursOptions().size();
		System.out.println("HRS--------" + hrs);
		Assert.assertEquals(hrs, 14);

		int min = C.MinutesOptions().size();
		Assert.assertEquals(min, 60);

		int meridian = C.AMPMoptions().size();
		Assert.assertEquals(meridian, 2);

		Random R = new Random();
		int hrscount = R.nextInt(hrs);
		WebElement hours = C.HoursOptions().get(hrscount);
		hours.click();

		int mins = R.nextInt(min);
		WebElement minute = C.MinutesOptions().get(mins);
		minute.click();

		int mer = R.nextInt(meridian);
		WebElement AMPM = C.AMPMoptions().get(mer);
		AMPM.click();

		C.Savebutton();
	}

	public void InvalidInvoiceQty() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String empty = C.invoiceQuantityErrorMessage().getText();

		C.invoiceQuantityfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 27, 0));
		C.Savebutton().click();
		String special = C.invoiceQuantityErrorMessage().getText();

		C.invoiceQuantityfield().clear();
		C.invoiceQuantityfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 28, 0));
		C.Savebutton().click();
		String text = C.invoiceQuantityErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 27, 2).trim(), empty.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 28, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 28, 2).trim(), text.trim());

		C.invoiceQuantityfield().clear();
	}

	public void validInvoiceQty() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.invoiceQuantityfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 28, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 6, errorcount);

		C.invoiceQuantityfield().clear();
		C.invoiceQuantityfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 27, 1));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 6, errorcount);
	}

	public void InvalidInvoiceValue() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String empty = C.InvoiceValueFieldErrorMessage().getText();

		C.InvoiceValuefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 33, 0));
		C.Savebutton().click();
		String special = C.InvoiceValueFieldErrorMessage().getText();

		C.InvoiceValuefield().clear();
		C.InvoiceValuefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 34, 0));
		C.Savebutton().click();
		String text = C.InvoiceValueFieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 33, 2).trim(), empty.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 34, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 34, 2).trim(), text.trim());

		C.InvoiceValuefield().clear();
	}

	public void validInvoiceValue() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.InvoiceValuefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 33, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 7, errorcount);

		C.InvoiceValuefield().clear();
		C.InvoiceValuefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 34, 1));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 7, errorcount);
	}

	public void InvalidNumberOfBoxes() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.numberofboxesfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 39, 0));
		C.Savebutton().click();
		String special = C.numberofboxesfieldErrorMessage().getText();

		C.numberofboxesfield().clear();
		C.numberofboxesfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 40, 0));
		C.Savebutton().click();
		String text = C.numberofboxesfieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 39, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 39, 2).trim(), text.trim());

		C.numberofboxesfield().clear();
	}

	public void validNumberofBoxes() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.numberofboxesfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 39, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 7, errorcount);

		C.numberofboxesfield().clear();
		C.numberofboxesfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 40, 1));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 7, errorcount);
	}

	public void InvalidWeights() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Weightsfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 45, 0));
		C.Savebutton().click();
		String special = C.WeightsErrorMessage().getText();

		C.Weightsfield().clear();
		C.Weightsfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 46, 0));
		C.Savebutton().click();
		String text = C.WeightsErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 45, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 45, 2).trim(), text.trim());

		C.Weightsfield().clear();
	}

	public void validWeights() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Weightsfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 45, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 7, errorcount);

		C.Weightsfield().clear();
		C.Weightsfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 46, 1));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 7, errorcount);
	}

	public void InvalidDistributorName() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String empty = C.DistributorNamefieldErrorMessage().getText();

		C.DistributornameField().sendKeys(Excel.getCellValue(xlPath, sheetname7, 51, 0));
		C.Savebutton().click();
		String special = C.DistributorNamefieldErrorMessage().getText();

		C.DistributornameField().clear();
		C.DistributornameField().sendKeys(Excel.getCellValue(xlPath, sheetname7, 52, 0));
		C.Savebutton().click();
		String text = C.DistributorNamefieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 51, 2).trim(), empty.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 52, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 52, 2).trim(), text.trim());

		C.DistributornameField().clear();
	}

	public void validDistributorNameField() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.DistributornameField().sendKeys(Excel.getCellValue(xlPath, sheetname7, 51, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 8, errorcount);

		C.DistributornameField().clear();
		C.DistributornameField().sendKeys(Excel.getCellValue(xlPath, sheetname7, 52, 1));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 8, errorcount);
	}

	public void InvalidDistributorID() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String empty = C.DistributorIDorUPPfieldErrorMessage().getText();

		C.DistributorIDorUPPfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 57, 0));
		C.Savebutton().click();
		String special = C.DistributorIDorUPPfieldErrorMessage().getText();

		C.DistributorIDorUPPfield().clear();
		C.DistributorIDorUPPfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 58, 0));
		C.Savebutton().click();
		String text = C.DistributorIDorUPPfieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 57, 2).trim(), empty.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 58, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 59, 2).trim(), text.trim());

		C.DistributorIDorUPPfield().clear();
	}

	public void validDistributorID() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.DistributorIDorUPPfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 57, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 9, errorcount);

		C.DistributorIDorUPPfield().clear();
		C.DistributorIDorUPPfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 58, 1));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 9, errorcount);
	}

	public void InvalidDistributorPhoneNumber() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Distributorphonefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 64, 0));
		C.Savebutton().click();
		String special = C.DistributorphonefieldErrorMessage().getText();

		C.Distributorphonefield().clear();
		C.Distributorphonefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 65, 0));
		C.Savebutton().click();
		String text = C.DistributorphonefieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 65, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 64, 2).trim(), text.trim());

		C.Distributorphonefield().clear();
	}

	public void validDistributorPhoneNumber() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Distributorphonefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 64, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 9, errorcount);

		C.Distributorphonefield().clear();
		C.Distributorphonefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 65, 1));
		C.Savebutton().click();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 9, errorcount);
	}

	public void InvalidLocation() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Locationfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 70, 0));
		C.Savebutton().click();
		String special = C.LocationFieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 70, 2).trim(), special.trim());

		C.Locationfield().clear();
	}

	public void validLocation() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Locationfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 70, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 9, errorcount);

	}

	public void InvalidAreaPinCode() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Areapincodefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 75, 0));
		C.Savebutton().click();
		String special = C.AreapincodefieldErrorMessage().getText();

		C.Areapincodefield().clear();
		C.Areapincodefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 76, 0));
		C.Savebutton().click();
		String text = C.AreapincodefieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 76, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 75, 2).trim(), text.trim());

		C.Areapincodefield().clear();
	}

	public void validAreaPinCode() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Areapincodefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 75, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 9, errorcount);
	}

	public void Statedropddown() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		int count = C.Stateoptions().size();
		Assert.assertEquals(count, 37);
		Select select = new Select(C.Statedropdown());
		int random = ThreadLocalRandom.current().nextInt(1, count);
		select.selectByIndex(random);
		C.Savebutton().click();
	}

	public void RegionalZone() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		int Regions = C.Regionalzonenameoptions().size();
		Assert.assertEquals(Regions, 6);
		Select select = new Select(C.Regionalzonenamedropdown());
		int random = ThreadLocalRandom.current().nextInt(1, Regions);
		select.selectByIndex(random);
		C.Savebutton().click();
	}

	public void VerifyRegionalZone() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		int Regions = C.Regionalzonenameoptions().size();

		ArrayList<String> Regionnames = new ArrayList<String>();
		for (int i = 0; i < Regions; i++) {
			String rnames = C.Regionalzonenameoptions().get(i).getText();
			Regionnames.add(rnames);
		}

		int rowcount = Excel.getRowCount(xlPath, sheetname4);
		for (int i = 0; i < rowcount; i++) {
			String rz = Excel.getCellValue(xlPath, sheetname4, i, 5);
			if (Regionnames.contains(rz)) {
				Assert.assertTrue(true);
			} else {
				System.out.println("Following Warehouse name is missing---" + rz);
				Assert.assertTrue(false);
			}
		}
	}

	public void VerifyWarehouses() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		int Whcount = C.Warehouseoptions().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < Whcount; i++) {
			String whnames = C.Warehouseoptions().get(i).getText();
			names.add(whnames);
		}

		int rowcount = Excel.getRowCount(xlPath, sheetname4);
		for (int i = 0; i < rowcount; i++) {
			String wh = Excel.getCellValue(xlPath, sheetname4, i, 1);
			if (names.contains(wh)) {
				Assert.assertTrue(true);
			} else {
				System.out.println("Following Warehouse name is missing---" + wh);
				Assert.assertTrue(false);
			}
		}

	}

	public void WarehouseOptionSelect() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		int warehouse = C.Warehouseoptions().size();
		System.out.println("Warehuouse drop down options--"+warehouse);
		int menucont = H.leftsidemenus().size();
		if (menucont == Integer.parseInt(prop.getProperty("Superadminmenucount"))) {
			Assert.assertEquals(warehouse, 7);
			Select select = new Select(C.Warehousedropdown());
			int random = ThreadLocalRandom.current().nextInt(1, warehouse);
			select.selectByIndex(random);
		} else {
			Assert.assertEquals(warehouse, 2);
			Select select = new Select(C.Warehousedropdown());
			select.selectByIndex(1);
		}

	}

	public void InvalidDispatchDTfromWH() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.DispatchDTfromWHfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 80, 0));
		C.Savebutton().click();
		String ddmmyyy = C.DispatchDTfromWHfieldErrorMessage().getText().trim();

		C.DispatchDTfromWHfield().clear();
		C.DispatchDTfromWHfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 81, 0));
		C.Savebutton().click();
		String number = C.DispatchDTfromWHfieldErrorMessage().getText().trim();

// 		Getting current Month and year and verifying with the Datepicker		
		LocalDate currentDate = LocalDate.now();
		Month m = currentDate.getMonth();
		int y = currentDate.getYear();
		String monthyear = m + " " + Integer.toString(y);
		C.DispatchDTfromWHfield().clear();
		C.DispatchDTfromWHfield().click();
		String Datepickertitle = C.DatePickerTitle().getText().toLowerCase();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 80, 2).trim(), ddmmyyy);
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 80, 2).trim(), number);
		Assert.assertEquals(Datepickertitle, monthyear.toLowerCase());

		C.DispatchDTfromWHfield().click();
		String invdate = C.Invoicedatefield().getAttribute("value");
		C.DispatchDTfromWHfield().sendKeys(invdate);
		C.Savebutton().click();
		String datenotequl = C.DispatchDTfromWHfieldErrorMessage().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 81, 2), datenotequl);

		C.DispatchDTfromWHfield().clear();
		C.DispatchDTfromWHfield().sendKeys(Keys.TAB);
	}

	public void ValidDispatchDTfromWH() throws Exception {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String oldDate = C.InvWHReceiptsDatefield().getAttribute("value");
		System.out.println("Old Date---" + oldDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(oldDate));
		cal.add(Calendar.DATE, 1);
		String convertedDate = dateFormat.format(cal.getTime());

		C.DispatchDTfromWHfield().sendKeys(convertedDate);
		C.DispatchDTfromWHfield().sendKeys(Keys.TAB);
	}

	public void InvalidTransporterName() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.TransporterNamefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 85, 0));
		C.Savebutton().click();
		String special = C.TransporterNamefieldErrorMessage().getText();

		C.TransporterNamefield().clear();
		C.TransporterNamefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 86, 0));
		C.Savebutton().click();
		String text = C.TransporterNamefieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 85, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 85, 2).trim(), text.trim());

		C.TransporterNamefield().clear();
	}

	public void validDTransporterName() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.TransporterNamefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 85, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 10, errorcount);
	}

	public void InvalidDocketNumber() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Docketnofield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 91, 0));
		C.Savebutton().click();
		String special = C.DocketnofieldErrorMessage().getText();

		C.Docketnofield().clear();
		C.Docketnofield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 92, 0));
		C.Savebutton().click();
		String text = C.DocketnofieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 91, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 91, 2).trim(), text.trim());

		C.Docketnofield().clear();
	}

	public void validDocketNumber() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Docketnofield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 91, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 10, errorcount);
	}

	public void ModeofTransport() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		int transport = C.ModeofTransportoptions().size();
		Assert.assertEquals(transport, 3);
		Select select = new Select(C.ModeofTransportdropdown());
		int random = ThreadLocalRandom.current().nextInt(1, transport);
		select.selectByIndex(random);
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 10, errorcount);
	}

	public void VerifyModeofTransport() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		int transport = C.ModeofTransportoptions().size();

		ArrayList<String> transportnames = new ArrayList<String>();
		for (int i = 1; i < transport; i++) {
			String rnames = C.ModeofTransportoptions().get(i).getText().trim().toLowerCase();
			transportnames.add(rnames);
		}

		for (int i = 0; i < transport - 1; i++) {
			String Excelvalue = Excel.getCellValue(xlPath, sheetname4, i, 6).trim().toLowerCase();
			if (transportnames.contains(Excelvalue)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false, "Missing Mode of Transport option is---" + Excelvalue);
			}
		}
	}

	public void StandardTransitDays() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String value = C.StandardTransitdaysfield().getAttribute("value");
		Assert.assertEquals(prop.getProperty("StandardTransitDays"), value);
	}

	public void InvalidExpectedDateofDelivery() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.ExpectedDateOfDeliveryfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 97, 0));
		C.Savebutton().click();
		String ddmmyyy = C.ExpectedDateOfDeliverfieldErrorMessage().getText().trim();

		C.ExpectedDateOfDeliveryfield().clear();
		C.ExpectedDateOfDeliveryfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 98, 0));
		C.Savebutton().click();
		String number = C.ExpectedDateOfDeliverfieldErrorMessage().getText().trim();

// 		Getting current Month and year and verifying with the Datepicker		
		LocalDate currentDate = LocalDate.now();
		Month m = currentDate.getMonth();
		int y = currentDate.getYear();
		String monthyear = m + " " + Integer.toString(y);
		C.ExpectedDateOfDeliveryfield().clear();
		C.ExpectedDateOfDeliveryfield().click();
		String Datepickertitle = C.DatePickerTitle().getText().toLowerCase();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 97, 2).trim(), ddmmyyy);
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 97, 2).trim(), number);
		Assert.assertEquals(Datepickertitle, monthyear.toLowerCase());

		C.ExpectedDateOfDeliveryfield().click();
		C.PrevInvoiceUIDatePicker().click();
		C.PrevInvoiceUIDatePicker().click();
		C.PrevInvoiceUIDatePicker().click();

		int dates = C.CalenderDates().size();
		Random random = new Random();
		int datecount = random.nextInt(dates);
		WebElement prevdate = C.CalenderDates().get(datecount);
		prevdate.click();
		C.Savebutton().click();
		String datenotequl = C.ExpectedDateOfDeliverfieldErrorMessage().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 98, 2), datenotequl);

		C.ExpectedDateOfDeliveryfield().clear();
		C.ExpectedDateOfDeliveryfield().sendKeys(Keys.TAB);
	}

	public void ExpectedDateofDelivery() throws Exception {
		CreateOrderPOM C = new CreateOrderPOM(driver);

//		Select a date in a datepicker 2 days from current date
		String oldDate = C.DispatchDTfromWHfield().getAttribute("value");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(oldDate));
		cal.add(Calendar.DATE, 2);
		String convertedDate = dateFormat.format(cal.getTime());

		C.ExpectedDateOfDeliveryfield().sendKeys(convertedDate);
		C.Savebutton().click();
	}

	public void InvalidActualDeliveryDate() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.ActualDeliveryDatefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 103, 0));
		C.Savebutton().click();
		String ddmmyyy = C.ActualDeliveryDateFieldErrorMessage().getText().trim();

		C.ActualDeliveryDatefield().clear();
		C.ActualDeliveryDatefield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 104, 0));
		C.Savebutton().click();
		String number = C.ActualDeliveryDateFieldErrorMessage().getText().trim();

// 		Getting current Month and year and verifying with the Datepicker		
		LocalDate currentDate = LocalDate.now();
		Month m = currentDate.getMonth();
		int y = currentDate.getYear();
		String monthyear = m + " " + Integer.toString(y);
		C.ActualDeliveryDatefield().clear();
		C.ActualDeliveryDatefield().click();
		String Datepickertitle = C.DatePickerTitle().getText().toLowerCase();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 103, 2).trim(), ddmmyyy);
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 103, 2).trim(), number);
		Assert.assertEquals(Datepickertitle, monthyear.toLowerCase());

		C.ActualDeliveryDatefield().click();
		C.PrevInvoiceUIDatePicker().click();
		C.PrevInvoiceUIDatePicker().click();
		C.PrevInvoiceUIDatePicker().click();

		int dates = C.CalenderDates().size();
		Random random = new Random();
		int datecount = random.nextInt(dates);
		WebElement prevdate = C.CalenderDates().get(datecount);
		prevdate.click();
		C.Savebutton().click();
		String datenotequl = C.ActualDeliveryDateFieldErrorMessage().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 104, 2), datenotequl);

		C.ActualDeliveryDatefield().clear();
		C.ActualDeliveryDatefield().sendKeys(Keys.TAB);
	}

	public void validActualDeliveryDate() throws Exception {

		CreateOrderPOM C = new CreateOrderPOM(driver);

//		Select a date in a datepicker 2 days from current date
		String oldDate = C.ExpectedDateOfDeliveryfield().getAttribute("value");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(oldDate));
		cal.add(Calendar.DATE, 2);
		String convertedDate = dateFormat.format(cal.getTime());

		C.ActualDeliveryDatefield().sendKeys(convertedDate);
		C.Savebutton().click();
	}

	public void InvalidReceivedBy() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.ReceivedByfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 109, 0));
		C.Savebutton().click();
		String special = C.ReceivedByfieldErrorMessage().getText();

		C.ReceivedByfield().clear();
		C.ReceivedByfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 110, 0));
		C.Savebutton().click();
		String text = C.ReceivedByfieldErrorMessage().getText();

		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 109, 2).trim(), special.trim());
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname7, 109, 2).trim(), text.trim());

		C.ReceivedByfield().clear();
	}

	public void validReceivedBy() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.ReceivedByfield().sendKeys(Excel.getCellValue(xlPath, sheetname7, 109, 1));
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 10, errorcount);
	}

	public void Status() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		int Status = C.Statusoptions().size();
		Assert.assertEquals(Status, 4);
		Select select = new Select(C.Statusfielddropdown());
		int random = ThreadLocalRandom.current().nextInt(1, Status);
		select.selectByIndex(random);
		C.Savebutton().click();
		int errorcount = C.Errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Mandatoryfields")) - 10, errorcount);
	}

	public void VerifyStatus() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		int Status = C.Statusoptions().size();

		ArrayList<String> statusnames = new ArrayList<String>();
		for (int i = 1; i < Status; i++) {
			String rnames = C.Statusoptions().get(i).getText();
			statusnames.add(rnames);
		}

		for (int i = 0; i < Status-1; i++) {
			String sn = Excel.getCellValue(xlPath, sheetname4, i, 7);
			if (statusnames.contains(sn)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false, "Missing Status from dropdown is--"+sn);
			}
		}
	}

	public void Remarks() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		C.Remarksfield().sendKeys(prop.getProperty("Remarkstext"));
		C.Savebutton();
	}

	public void invalidUpload() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String filepath = System.getProperty("user.dir") + "\\UploadFile\\sample.xlsx";
		C.Uploadinputupload().sendKeys(filepath);
		Assert.assertTrue(C.UploadErrorMessage().isDisplayed());

		String NoFileSelect = C.NoFileSelectedErrorMessage().getText();
		Assert.assertEquals(prop.getProperty("NoFileSelected"), NoFileSelect);

		C.UploadRemovebutton().click();
	}

	public void validUpload() {
		CreateOrderPOM C = new CreateOrderPOM(driver);

		String filepath = System.getProperty("user.dir") + "\\UploadFile\\packs.png";
		C.Uploadinputupload().sendKeys(filepath);

		String uploadtext = C.Uploadwarningtext().getText();
		Assert.assertEquals(prop.getProperty("UploadPODText"), uploadtext);

	}

	public void CopyValuesandVerify() throws Exception {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		String Orderno = C.OrderORSONumberfield().getAttribute("value");
		String DistName = C.DistributornameField().getAttribute("value");
		String Distid = C.DistributorIDorUPPfield().getAttribute("value");
		String location = C.Locationfield().getAttribute("value");
		String InvValue = C.InvoiceValuefield().getAttribute("value");
		String DocketNo = C.Docketnofield().getAttribute("value");
		String Transporter = C.TransporterNamefield().getAttribute("value");
		String ModeofTransport = C.ModeTransportationSelected().getAttribute("value");

		C.Savebutton().click();
		Assert.assertEquals(prop.getProperty("warehouseurl"), driver.getCurrentUrl());
		Assert.assertTrue(C.OrderCreatedSucessfullMessage().isDisplayed());

		S.orderno().sendKeys(Orderno);
		S.Searchbutton().click();

		String TOrderno = T.Ordernumber().getText();
		String TDistName = T.DistName().getText();
		String TDistid = T.DistId().getText();
		String Tlocation = T.DistLocation().getText();
		String TWarehouse = T.DistWH().getText();
		String TInvValue = T.Invoicevalue().getText();
		String TDocketNo = T.DocketNumber().getText();
		String TTransporter = T.transporterName().getText();
		String TModeofTransport = T.Modeoftransport().getText();

		String TExpectedDate = T.ExpectedDeliveryDate().getText();
		LocalDate LocalExpected = LocalDate.parse(TExpectedDate);

		String TDispatchDate = T.DispatchDTfromWH().getText();
		LocalDate LocalDispatch = LocalDate.parse(TDispatchDate);

		long noofDays = ChronoUnit.DAYS.between(LocalExpected, LocalDispatch);
		System.out.println("TAT----" + noofDays);

		Assert.assertEquals(Orderno, TOrderno);
		Assert.assertEquals(DistName, TDistName);
		Assert.assertEquals(Distid, TDistid);
		Assert.assertEquals(location, Tlocation);
		Assert.assertEquals(InvValue, TInvValue);
		Assert.assertEquals(DocketNo, TDocketNo);
		Assert.assertEquals(Transporter, TTransporter);
		Assert.assertEquals(ModeofTransport, TModeofTransport);

		T.firstviewbutton().click();
		String Warehouse = C.WarehouseSelectedOptionViewFlow().getAttribute("placeholder");
		Assert.assertEquals(Warehouse, TWarehouse);
		C.Cancelbutton().click();
	}

	public void CaluclateAllTAT() {
		CreateOrderPOM C = new CreateOrderPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		String TableCtat = T.CTAT().getText();

		T.firstupdatebutton().click();
		String DSTAT = C.DSTeamOrderSenttoWHTATDaysfield().getAttribute("value").trim();
		String WHPTAT = C.WHprocessingTATDaysfield().getAttribute("value").trim();
		String COTAT = C.CourierTeamTATfield().getAttribute("value").trim();
		String ActualTAT = C.ActualOrderDeliveryTATfield().getAttribute("value").trim();

		String Webinvoice = C.InvWHReceiptsDatefield().getAttribute("value");
		String invoiceReceived = C.Invoicedatefield().getAttribute("value");
		String DispatchWH = C.DispatchDTfromWHfield().getAttribute("value");
		String ActualDelivery = C.ActualDeliveryDatefield().getAttribute("value");

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		Date d1 = null;
		Date d2 = null;
		Date d3 = null;
		Date d4 = null;

		try {
			d1 = format.parse(Webinvoice);
			d2 = format.parse(invoiceReceived);
			d3 = format.parse(DispatchWH);
			d4 = format.parse(ActualDelivery);

			long DSTdiff = d1.getTime() - d2.getTime();
			long d = TimeUnit.MILLISECONDS.toDays(DSTdiff);
			String DSTeamOrderSent = String.valueOf(d);

			long WHTAT = d3.getTime() - d1.getTime();
			long W = TimeUnit.MILLISECONDS.toDays(WHTAT);
			String WHProcessTAT = String.valueOf(W);

			long CourierTAT = d4.getTime() - d3.getTime();
			long Co = TimeUnit.MILLISECONDS.toDays(CourierTAT);
			String CourierTeamTAT = String.valueOf(Co);

			long ActualOrderTAT = d4.getTime() - d2.getTime();
			long A = TimeUnit.MILLISECONDS.toDays(ActualOrderTAT);
			String ActualOrderDeliveryTAT = String.valueOf(A);

			Assert.assertEquals(DSTAT, DSTeamOrderSent);
			Assert.assertEquals(WHPTAT, WHProcessTAT);
			Assert.assertEquals(COTAT, CourierTeamTAT);
			Assert.assertEquals(ActualTAT, ActualOrderDeliveryTAT);
			Assert.assertEquals(TableCtat, CourierTeamTAT);

		} catch (Exception e) {
			e.printStackTrace();
		}

		C.Cancelbutton().click();

	}

}
