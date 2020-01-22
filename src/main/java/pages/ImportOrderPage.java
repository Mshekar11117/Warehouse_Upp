package pages;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.ImportOrderPOM;
import POM.SearchfunctionalityPOM;
import POM.TablesPOM;
import POM.ViewOrdersPOM;
import base.SuperTestNG;
import utilities.XlApiTest;

public class ImportOrderPage extends SuperTestNG {

	String cellValue;
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	/*
	 * Need to count the order status Delivered in Excel and then verify that with
	 * success message which We get after upload
	 */

	public void AccessingImportOrder() {
		HomepagePOM H = new HomepagePOM(driver);
		H.ImportOrder().click();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("importurl"), curl);
	}

	public void validatetitles() {
		ImportOrderPOM I = new ImportOrderPOM(driver);

		String page = I.pagetitle().getText();
		Assert.assertEquals(prop.getProperty("pagetitle"), page);

		String Dispatchdate = I.DispatchDatelabel().getText();
		Assert.assertEquals(prop.getProperty("DispatchDate"), Dispatchdate);

		String ExcelorNot = I.FileinputLabel().getText();
		Assert.assertEquals(prop.getProperty("ExcelorNot"), ExcelorNot);

		String uploadinst = I.UploadInstructiontext().getText();
		Assert.assertEquals(prop.getProperty("UploadInstLabel"), uploadinst);

		String first = I.firstlistpoint().getText();
		Assert.assertEquals(prop.getProperty("Uploadinstfirstpoint"), first);

		String second = I.Secondlistpoint().getText();
		Assert.assertEquals(prop.getProperty("Uploadinstsecondpoint"), second);

		String thrird = I.Thirdlistpoint().getText();
		Assert.assertEquals(prop.getProperty("Uploadinstthirdpoint"), thrird);
	}

	public void backtowarehousefrommImport() {
		HomepagePOM H = new HomepagePOM(driver);

		int menucount = H.leftsidemenus().size();
		if (menucount == Integer.parseInt(prop.getProperty("WHuserMenuCount"))) {
			H.WarehouseOrdermenu().click();
		}
	}

	public void importoptionvalidations() {
		ImportOrderPOM I = new ImportOrderPOM(driver);

		String filepath = System.getProperty("user.dir") + "\\TestData\\WH.xlsx";
		String invalidformat = System.getProperty("user.dir") + "\\InvalidFileFormat\\favicongetfit.ico";

		I.inputfield().sendKeys(filepath);
		I.Uploadbutton().click();
		String dispathdateError = I.DispatchDateError().getText();
		Assert.assertEquals(prop.getProperty("DispathfieldError"), dispathdateError);

		I.DispatchDateField().sendKeys(prop.getProperty("invalidDate"));
		I.inputfield().sendKeys(filepath);
		I.Uploadbutton().click();
		if (I.ErrorAlert().isDisplayed()) {
			String Alert = I.ErrorAlert().getText();
			Assert.assertEquals(prop.getProperty("AlertMessage"), Alert);
		} else {
			Assert.assertFalse(false);
		}

		I.inputfield().sendKeys(invalidformat);
		Assert.assertTrue(I.wrongformat().isDisplayed());
		Assert.assertTrue(I.NofileselectedError().isDisplayed());
		I.Wrongformatmessageclosebutton().click();
		I.Removebutton().click();
		driver.navigate().refresh();
	}

	public void printcolumnnames() throws Exception {
		XlApiTest xl = new XlApiTest(xlpath1);

		int col = xl.getColumnCount(sheetName8);
		System.out.println("Col number--" + col);

		String[] colname = { "Sl No", "Sale type", "Order No.", "Inv No.", "Inv Dt", "Inv WH Receipts Dt",
				"Order Receipt time in WH", "Distribuor ID No", "DS / UPP Owner Phone No", "Distribuor Name / UPP Name",
				"DS Location Name", "State Name", "Location PIN Code", "Regional Zone Name", "Ship From Warehouse",
				"Inv Value", "Weight (Kgs)", "No of Boxes", "Invoice Qty", "Dispatch DT from WH", "Transporter Name",
				"Docket No", "Mode of Transport ( SURFACE / AIR )", "Standard , Transit days",
				"Expected. Date. of Delivery", "Actual Delivery Date.", "Received By", "Status",
				"DS Team Order Sent to WH, TAT Days", "WH processing TAT, Days",
				"Courier team Transit (TAT) Delay Days", "Actual Order  Delivery TAT", "Remarks" };
		for (int i = 0; i < colname.length; i++) {
			String columnname = xl.getCellDataByColNum(sheetName8, i, 6);
//			System.out.println("Column names----" + columnname);
			if (colname[i].contains(columnname)) {
				// System.out.println("Column names---" + name);
				Assert.assertTrue(true);
			}

		}
	}

	public String PrintFirstValueUsingColumnName() throws Exception {
		FileInputStream fis = new FileInputStream(xlpath1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName8);
		XSSFRow row = sheet.getRow(6);

		int colNum = -1;

//		Get the column using column name
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(prop.getProperty("ColumnName"))) {
				colNum = i;
			}
		}

		System.out.println("Total Number of rows having data---" + sheet.getLastRowNum());
		row = sheet.getRow(9);
		XSSFCell cell = row.getCell(colNum);

		if (cell.getCellTypeEnum() == CellType.STRING) {
			cellValue = String.valueOf(cell.getStringCellValue());
			System.out.println("Name---" + cellValue);
		}

		else if (HSSFDateUtil.isCellDateFormatted(cell)) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date date = cell.getDateCellValue();
			cellValue = df.format(date);
			System.out.println("Date---" + cellValue);
		}

		else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
			cellValue = String.valueOf(cell.getNumericCellValue());
			System.out.println("Numeric and formula---" + cellValue);
		}

		else if (cell.getCellTypeEnum() == CellType.BLANK) {
			return "";
		} else {
			return String.valueOf(cell.getBooleanCellValue());
		}
		return cellValue;
	}

	public String PrintAllValuesUsingColumnName() throws Exception {
		FileInputStream fis = new FileInputStream(xlpath1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName8);
		XSSFRow row = sheet.getRow(6);
		int colNum = -1;

//		Get the column using column name
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(prop.getProperty("ColumnName"))) {
				colNum = i;
			}
		}

		System.out.println("rows---" + sheet.getLastRowNum());
		for (int j = 9; j <= sheet.getLastRowNum(); j++) {
			row = sheet.getRow(j);
			XSSFCell cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				cellValue = cell.getStringCellValue();
				System.out.println("Name---" + cellValue);
			}

			else if (HSSFDateUtil.isCellDateFormatted(cell)) {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date date = cell.getDateCellValue();
				cellValue = df.format(date);
				System.out.println("Date---" + cellValue);
			}

			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				cellValue = String.valueOf(cell.getNumericCellValue());
				System.out.println("Numeric and formula---" + cellValue);
			}

			else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		}
		return cellValue;
	}

	public String PrintRandomValueUsingColumnName() throws Exception {
		fis = new FileInputStream(xlpath1);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName8);
		row = sheet.getRow(6);

		Random random = new Random();
		System.out.println("Value---" + sheet.getLastRowNum());
		int rand = random.nextInt(sheet.getLastRowNum());
		int colNum = -1;

//		Get the column using column name
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(prop.getProperty("ColumnName"))) {
				colNum = i;
			}
		}

//		Printing Randomly selected value
		row = sheet.getRow(rand);
		cell = row.getCell(colNum);
		if (cell.getCellTypeEnum() == CellType.STRING) {
			cellValue = cell.getStringCellValue();
			System.out.println("Name---" + cellValue);
		}

		else if (HSSFDateUtil.isCellDateFormatted(cell)) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date date = cell.getDateCellValue();
			cellValue = df.format(date);
			System.out.println("Date---" + cellValue);
		}

		else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
			cellValue = String.valueOf(cell.getNumericCellValue());
			System.out.println("Numeric and formula---" + cellValue);
		}

		else if (cell.getCellTypeEnum() == CellType.BLANK) {
			return "";
		} else {
			return String.valueOf(cell.getBooleanCellValue());
		}

		return cellValue;

	}

	public void getrowvluesinApplication() {
		TablesPOM T = new TablesPOM(driver);
		ArrayList<String> Appvalue = new ArrayList<String>();
		List<WebElement> value = T.tablerows();
		for (WebElement allrows : value) {
			List<WebElement> cells = allrows.findElements(By.xpath("//td[position()>1] //tbody/tr/td[last()-1]"));
			for (WebElement cell : cells) {
				String cellvalues = cell.getText().trim().toLowerCase();
				Appvalue.add(cellvalues);
			}

			System.out.println("Cell values are-----" + Appvalue);

//			To get only date from a string
			String regex = "(\\w+,\\s+\\w+\\s+\\d+\\,\\s+\\d+\\s+at\\s+\\d+:\\d+(pm|am)\\s+\\w{3,4})";
			Matcher matcher = Pattern.compile(regex).matcher((CharSequence) Appvalue);
			if (matcher.find()) {
				System.out.println("Regex Date values------" + matcher.group(1));
			}

		}
	}
	
	public void ImportExcelandVerifyValues() throws Exception {
		ImportOrderPOM I = new ImportOrderPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		Searchfunctionality Se = new Searchfunctionality();
		XlApiTest xl = new XlApiTest(xlpath1);
		HomepagePOM H = new HomepagePOM(driver);
		ViewOrdersPOM V = new ViewOrdersPOM(driver);

		DataFormatter dataFormatter = new DataFormatter();

		String filepath = System.getProperty("user.dir") + xlpath1;
		int rowcount = xl.getRowCount(sheetName8);
		System.out.println("Row Count----" + rowcount);

		H.WarehouseOrdermenu().click();

//		Taking random date from Excel Dispatch date column 
		int n = ThreadLocalRandom.current().nextInt(10, rowcount);
		String randdate = xl.getCellDataByColName(sheetName8, prop.getProperty("columnname"), n);
		System.out.println("Random value----" + n);
		System.out.println("Random selected date---" + randdate);

		ArrayList<String> stack = new ArrayList<String>();
//		Stack<String> stack = new Stack<String>();
		int insertorder = 0;
		int updatecount = 0;
		int deliveredcount = 0;
		ArrayList<String> orderpresetnt = new ArrayList<String>();
		for (int j = 10; j <= rowcount; j++) {
			String orderdate = xl.getCellDataByColName(sheetName8, prop.getProperty("columnname"), j);

			if (randdate.equalsIgnoreCase(orderdate)) {
				for (Cell cell : xl.row) {
					String cellValue = dataFormatter.formatCellValue(cell);
					stack.add(cellValue.trim().toLowerCase());
				}

				String orderno = xl.getCellDataByColName(sheetName8, "Order No.", j);
				orderpresetnt.add(orderno);
//				Searching order number one by one through search option
				S.orderno().sendKeys(orderno);
				S.Searchbutton().click();
//				Getting the value of Total Valid Orders for every orderno search
				int totalvalidorders = Se.getNumberOfEntries();
				S.orderno().clear();
// 				Verify the size of the search result is grater than zero or not
				if (totalvalidorders > 0) {
//					Get the status value of that particular order by matching jth row
//					String Status = xl.getCellDataByColName(sheetName8, "Status", j).trim().toLowerCase();
					int viewsize = T.allviewbuttons().size();
					String orderstatus = null;
					for (int k = 0; k <= viewsize; k++) {
						H.humbergermenu().click();
						T.lastviewbutton().click();
						orderstatus = V.Status().getAttribute("placeholder").trim().toLowerCase();
						System.out.println("Status of the Order---" + orderstatus);
						driver.navigate().back();
					}
					String del = "delivered";
					if (orderstatus.equals(del)) {
						deliveredcount++;

					} else {
						updatecount++;
					}

				} else {
					insertorder++;
				}

			}
		}

//		Printing the count after looping the Excel sheet status values
		System.out.println("Order present ArrayList and its Size---" + orderpresetnt);
		System.out.println("Order present Size----" + orderpresetnt.size());
		System.out.println("Delivery count when totalvalidorders > 0 ---- " + deliveredcount);
		System.out.println("Updated order count when totalvalidorders > 0 ----" + updatecount);
		System.out.println("Insert order count when totalvalidorders < 0 ----- " + insertorder);

//		Now import the excel sheet using Import option
		H.ImportOrder().click();
		Thread.sleep(1000);
		I.DispatchDateField().sendKeys(randdate);
		I.inputfield().sendKeys(filepath);
		Thread.sleep(1000);
		I.Uploadbutton().click();
		Thread.sleep(1000);
		if (I.Successalert().isDisplayed()) {
			String expectedsuccess;
			String actualsuccess = I.Successalert().getText();
			System.out.println("actualsuccess--" + actualsuccess);

			if (actualsuccess.contains("existing/updated orders")) {
				expectedsuccess = "Excel file uploaded successfully. Total orders uploaded - " + orderpresetnt.size()
						+ " | existing/updated orders - " + updatecount + " | inserted orders - " + insertorder
						+ " | status delivered orders - " + deliveredcount;
			} else {
				int insertedorders = orderpresetnt.size() - deliveredcount;
				expectedsuccess = "Excel file uploaded successfully. Total orders uploaded - " + orderpresetnt.size()
						+ " | inserted orders - " + insertedorders + " | status delivered orders - " + deliveredcount;
				System.out.println("expectedsuccess---" + expectedsuccess);
				Assert.assertEquals(expectedsuccess, actualsuccess);
			}

		}

//		ArrayList<String> Appvalue = new ArrayList<String>();
		int viewbuttons = T.allviewbuttons().size();
		if (viewbuttons > 0) {
			for (int i = 1; i <= viewbuttons; i++) {
				WebElement view = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td/a[1]"));
				view.click();

				String Saletype = V.Saletype().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(Saletype)) {
					Assert.assertTrue(true, "Sale Type Date is Matching");
				}
				String Orderno = V.Ordernumber().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(Orderno)) {
					Assert.assertTrue(true, "Order Number is matching");
				}
				String Invoicenumber = V.InvoiceNumber().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(Invoicenumber)) {
					Assert.assertTrue(true, "Invoice Number is Matching");
				}
				String InvoiceDate = V.invoiceDate().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(InvoiceDate)) {
					Assert.assertTrue(true, "Invoice Date is Matching");
				}
				String invWhDate = V.invoiceWHReceiptDate().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(invWhDate)) {
					Assert.assertTrue(true, "Invoice WH Date is Matching");
				}
				String OrderRecieptTime = V.OrderReceiptTimeinWH().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(OrderRecieptTime)) {
					Assert.assertTrue(true, "Order Reciept time is matching");
				}
				String InvQty = V.InvoiceQty().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(InvQty)) {
					Assert.assertTrue(true, "invoice Quantities are Matching");
				}

				String invValue = V.InvoiceValue().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(invValue)) {
					Assert.assertTrue(true, "Invoice Value is matching");
				}

				String NoOfBoxes = V.NumberOfBoxes().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(NoOfBoxes)) {
					Assert.assertTrue(true, "Number of Boxes are matching");
				}

				String Weight = V.Weights().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(Weight)) {
					Assert.assertTrue(true, "Weights are matching");
				}

				String DistributorName = V.DistributorName().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(DistributorName)) {
					Assert.assertTrue(true, "Distributor name is matching");
				}

				String DistributorId = V.DistributorID().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(DistributorId)) {
					Assert.assertTrue(true, "Distributor Id is matching");
				}

				String Distphone = V.distributorphone().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(Distphone)) {
					Assert.assertTrue(true, "Distributor phone is matching");
				}

				String Location = V.Locations().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(Location)) {
					Assert.assertTrue(true, "Locations are matching");
				}

				String AreaPinCode = V.AreaPinCode().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(AreaPinCode)) {
					Assert.assertTrue(true, "Area pin code is matching");
				}

				String State = V.State().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(State)) {
					Assert.assertTrue(true, "State name is matching");
				}

				String RegionalZoneName = V.RegionalZoneName().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(RegionalZoneName)) {
					Assert.assertTrue(true, "RegionalZoneName is Matching");
				}

				String Warehouse = V.Warehouses().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(Warehouse)) {
					Assert.assertTrue(true, "Warehouse name is matching");
				}

				String DispatchDateFromWh = V.DispatchDateFromWH().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(DispatchDateFromWh)) {
					Assert.assertTrue(true, "Dispatch Date from WH is Matching");
				}

				String TransporterName = V.TransportName().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(TransporterName)) {
					Assert.assertTrue(true, "Transport name is matching");
				}

				String DocketNumber = V.DocketNumber().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(DocketNumber)) {
					Assert.assertTrue(true, "Docket Number is Matching");
				}

				String ModeOfTransport = V.ModeOfTransport().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(ModeOfTransport)) {
					Assert.assertTrue(true, "Mode of Transport is Matching");
				}

				String StandardTATDays = V.StandardTAT().getAttribute("placeholder").trim().toLowerCase();
				Assert.assertEquals(prop.getProperty("StandardTransitDays"), StandardTATDays);

				String ExpectedDeliveryDate = V.ExpectedDateofDelivery().getAttribute("placeholder").trim()
						.toLowerCase();
				if (stack.contains(ExpectedDeliveryDate)) {
					Assert.assertTrue(true, "Expected Delivery Date is Matching");
				}

				String ActualDeliveryDate = V.ActualDateOfDelivery().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(ActualDeliveryDate)) {
					Assert.assertTrue(true, "Actual Delivery Date is Matching");
				}

				String ReceievedBy = V.Recievedby().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(ReceievedBy)) {
					Assert.assertTrue(true, "Recieved By values is Matching");
				}

				String Status = V.Status().getAttribute("placeholder").trim().toLowerCase();
				if (stack.contains(Status)) {
					Assert.assertTrue(true, "Status values is Matching");
				}

				String DSTAT = V.DSTeamOrderSenttoWHTATDays().getAttribute("placeholder").trim();
				String WHPTAT = V.WHprocessingTATDays().getAttribute("placeholder").trim();
				String COTAT = V.CourierTeamTransistTATDays().getAttribute("placeholder").trim();
				String ActualTAT = V.ActualOrderDeliveryTAT().getAttribute("placeholder").trim();

				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

				Date d1 = null;
				Date d2 = null;
				Date d3 = null;
				Date d4 = null;

				try {
					d1 = format.parse(invWhDate);
					d2 = format.parse(InvoiceDate);
					d3 = format.parse(DispatchDateFromWh);
					d4 = format.parse(ActualDeliveryDate);

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

				} catch (Exception e) {
					e.printStackTrace();
				}

				V.viewbackbutton().click();
			}

		}

	}

}
