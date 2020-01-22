package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.PaginationPOM;
import POM.SearchfunctionalityPOM;
import POM.ViewOrdersPOM;
import POM.WHTablesPOM;
import POM.WarehousesPOM;
import base.SuperTestNG;

public class ExportExcel extends SuperTestNG {

//	Compare two Excel sheet	
	public int getNumberOfEntries() {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		String entriesTxt = S.numberofentries().getText();
		String text = entriesTxt.replaceAll("[^0-9]", "").trim();
//		System.out.println(Integer.parseInt(text));
		return Integer.parseInt(text);
	}

	public int getRecordsCountInExcel(String Exceldownloadpath, String ExcelFilename) throws Exception {
		int rowNum = 0;
		if (!ExcelFilename.isEmpty() || ExcelFilename != null) {
			String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
			File file = new File(filePath);
			if (file.exists()) {
				System.out.println("File found :" + ExcelFilename);
				FileInputStream fis = new FileInputStream(filePath);
				@SuppressWarnings("resource")
				HSSFWorkbook workbook = new HSSFWorkbook(fis);
				HSSFSheet sheet = workbook.getSheetAt(0);
				rowNum = sheet.getLastRowNum();
				System.out.println("Total Number of Rows in the excel is : " + rowNum);
			}
		}

		return rowNum;
	}

	public File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	public String getPDFrecord(String Exceldownloadpath, String PDFFilename) throws Exception {
		String pdftexts = null;

		if (!PDFFilename.isEmpty() || PDFFilename != null) {
			String filepath = Exceldownloadpath + System.getProperty("file.separator") + PDFFilename;
			File file = new File(filepath);
			if (file.exists()) {
				System.out.println("File found :" + PDFFilename);
				PDFParser TestPDF = new PDFParser(new RandomAccessFile(file, "r"));
				TestPDF.parse();

				COSDocument cosdoc = TestPDF.getDocument();
				PDDocument pddoc = new PDDocument(cosdoc);
				PDFTextStripper strip = new PDFTextStripper();

				pddoc.getNumberOfPages();
				strip.setEndPage(8);
				pdftexts = strip.getText(pddoc);
			}
		}
		return pdftexts;
	}

	public void Exportexcel() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);

		H.WarehouseOrdermenu().click();
		int noOfEntries = getNumberOfEntries();
		System.out.println("Total number of entries are :- " + noOfEntries);

		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		S.ExportExcel().click();
		Thread.sleep(10000);
		getLatestFilefromDir(Exceldownloadpath);
		File file = getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();

		System.out.println("Verifying number of entries with number of entries in Excel sheet");
		H.WarehouseOrdermenu().click();
		Assert.assertEquals(noOfEntries, getRecordsCountInExcel(Exceldownloadpath, ExcelFilename));
	}

	public void ExportPDF() throws Exception {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		WHTablesPOM T = new WHTablesPOM(driver);
		String Firstorder = T.firstdisplayedorderintable().getText();
		S.ExportPDF().click();
		Thread.sleep(5000);
		getLatestFilefromDir(Exceldownloadpath);
		File file = getLatestFilefromDir(Exceldownloadpath);
		String PDFFilename = file.getName();

		Assert.assertTrue(PDFFilename.contains(".pdf"));
		Assert.assertTrue(getPDFrecord(Exceldownloadpath, PDFFilename).contains(Firstorder));
	}

	public void WriteExcel() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		ViewOrdersPOM V = new ViewOrdersPOM(driver);
		WHTablesPOM W = new WHTablesPOM(driver);
		WarehousesPOM WA = new WarehousesPOM(driver);
		PaginationPOM P = new PaginationPOM(driver);

		int rcount = W.tableresult().size();
		int pagination = P.numberpagination().size();
	/*	while (P.numberpagination().size() > 0) {
			if (P.nextpage().size() > 0) {
				P.nextarrow().click();
				rcount += W.tableresult().size();
			} else {
				break;
			}
		}*/

		H.WarehouseOrdermenu().click();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Application Value");

		Map<String, Object[]> data = new LinkedHashMap<String, Object[]>();

		data.put("0",
				new Object[] { "sale_type", "order_no", "web_inv_no", "inv_received_date", "web_inv_date",
						"order_receipt_time_in_wh", "cs_team_tat", "inv_qty", "inv_value", "no_of_boxes",
						"distributor_name", "distributor_id", "distributor_phone", "location", "area_pin_code", "state",
						"regional_zone_name", "remarks", "warehouse", "weight_kgs", "dispatch_dt_from_WH",
						"transporter_name", "docket_no", "mode_of_transport", "standard_transit_days",
						"expected_date_of_delivery", "actual_delivery_date", "received_by", "status",
						"ds_team_order_sent_to_wh_tat_days", "wh_processing_tat_days", "actual_order_delivery_tat" });
		
		for (int i = 1; i <= rcount; i++) {
			H.humbergermenu().click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tbody/tr[" + i + "]/td/a[1]")).click();
			String text = Integer.toString(i);

			String Saletype = V.Saletype().getAttribute("placeholder").trim().toLowerCase();
			String Orderno = V.Ordernumber().getAttribute("placeholder").trim().toLowerCase();
			String Invoicenumber = V.InvoiceNumber().getAttribute("placeholder").trim().toLowerCase();
			String InvoiceDate = V.invoiceDate().getAttribute("placeholder").trim().toLowerCase();
			String invWhDate = V.invoiceWHReceiptDate().getAttribute("placeholder").trim().toLowerCase();
			String OrderRecieptTime = V.OrderReceiptTimeinWH().getAttribute("placeholder").trim().toLowerCase();
			String COTAT = V.CourierTeamTransistTATDays().getAttribute("placeholder").trim();
			String InvQty = V.InvoiceQty().getAttribute("placeholder").trim().toLowerCase();
			String invValue = V.InvoiceValue().getAttribute("placeholder").trim().toLowerCase();
			String NoOfBoxes = V.NumberOfBoxes().getAttribute("placeholder").trim().toLowerCase();
			String DistributorName = V.DistributorName().getAttribute("placeholder").trim().toLowerCase();
			String DistributorId = V.DistributorID().getAttribute("placeholder").trim().toLowerCase();
			String Distphone = V.distributorphone().getAttribute("placeholder").trim().toLowerCase();
			String Location = V.Locations().getAttribute("placeholder").trim().toLowerCase();
			String AreaPinCode = V.AreaPinCode().getAttribute("placeholder").trim().toLowerCase();
			String State = V.State().getAttribute("placeholder").trim().toLowerCase();
			if (State.equalsIgnoreCase("select state")) {
				State = "";
			} else {
				Locale st = Locale.ENGLISH;
			}
			String RegionalZoneName = V.RegionalZoneName().getAttribute("placeholder").trim().toLowerCase();
			String Remark = V.Remarks().getText().toLowerCase();
			String Warehouse = V.Warehouses().getAttribute("placeholder").trim().toLowerCase();
			String Weight = V.Weights().getAttribute("placeholder").trim().toLowerCase();
			String DispatchDateFromWh = V.DispatchDateFromWH().getAttribute("placeholder").trim().toLowerCase();
			String TransporterName = V.TransportName().getAttribute("placeholder").trim().toLowerCase();
			String DocketNumber = V.DocketNumber().getAttribute("placeholder").trim().toLowerCase();
			String ModeOfTransport = V.ModeOfTransport().getAttribute("placeholder").trim().toLowerCase();
			String StandardTATDays = V.StandardTAT().getAttribute("placeholder").trim().toLowerCase();
			String ExpectedDeliveryDate = V.ExpectedDateofDelivery().getAttribute("placeholder").trim().toLowerCase();
			String ActualDeliveryDate = V.ActualDateOfDelivery().getAttribute("placeholder").trim().toLowerCase();
			String ReceievedBy = V.Recievedby().getAttribute("placeholder").trim().toLowerCase();
			String Status = V.Status().getAttribute("placeholder").trim().toLowerCase();
			String DSTAT = V.DSTeamOrderSenttoWHTATDays().getAttribute("placeholder").trim();
			String WHPTAT = V.WHprocessingTATDays().getAttribute("placeholder").trim();
			String ActualTAT = V.ActualOrderDeliveryTAT().getAttribute("placeholder").trim();

			data.put(text,
					new Object[] { Saletype, Orderno, Invoicenumber, InvoiceDate, invWhDate, OrderRecieptTime, COTAT,
							InvQty, invValue, NoOfBoxes, DistributorName, DistributorId, Distphone, Location,
							AreaPinCode, State, RegionalZoneName, Remark, Warehouse, Weight, DispatchDateFromWh,
							TransporterName, DocketNumber, ModeOfTransport, StandardTATDays, ExpectedDeliveryDate,
							ActualDeliveryDate, ReceievedBy, Status, DSTAT, WHPTAT, ActualTAT
					});
			System.out.println("I value in String---" + text);
			System.out.println("Order-----" + Orderno);
			WA.Backbutton().click();

		}
		
		if(pagination > 0) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			for (int i = 3; i < pagination; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();
				int rinsidecount =  W.tableresult().size();
				for (int j = 1; j <= rinsidecount; j++) {
					H.humbergermenu().click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + j + "]/td/a[1]")).click();
					String text = Integer.toString(j);

					String Saletype = V.Saletype().getAttribute("placeholder").trim().toLowerCase();
					String Orderno = V.Ordernumber().getAttribute("placeholder").trim().toLowerCase();
					String Invoicenumber = V.InvoiceNumber().getAttribute("placeholder").trim().toLowerCase();
					String InvoiceDate = V.invoiceDate().getAttribute("placeholder").trim().toLowerCase();
					String invWhDate = V.invoiceWHReceiptDate().getAttribute("placeholder").trim().toLowerCase();
					String OrderRecieptTime = V.OrderReceiptTimeinWH().getAttribute("placeholder").trim().toLowerCase();
					String COTAT = V.CourierTeamTransistTATDays().getAttribute("placeholder").trim();
					String InvQty = V.InvoiceQty().getAttribute("placeholder").trim().toLowerCase();
					String invValue = V.InvoiceValue().getAttribute("placeholder").trim().toLowerCase();
					String NoOfBoxes = V.NumberOfBoxes().getAttribute("placeholder").trim().toLowerCase();
					String DistributorName = V.DistributorName().getAttribute("placeholder").trim().toLowerCase();
					String DistributorId = V.DistributorID().getAttribute("placeholder").trim().toLowerCase();
					String Distphone = V.distributorphone().getAttribute("placeholder").trim().toLowerCase();
					String Location = V.Locations().getAttribute("placeholder").trim().toLowerCase();
					String AreaPinCode = V.AreaPinCode().getAttribute("placeholder").trim().toLowerCase();
					String State = V.State().getAttribute("placeholder").trim().toLowerCase();
					if (State.equalsIgnoreCase("select state")) {
						State = "";
					} else {
						Locale st = Locale.ENGLISH;
					}
					String RegionalZoneName = V.RegionalZoneName().getAttribute("placeholder").trim().toLowerCase();
					String Remark = V.Remarks().getText().toLowerCase();
					String Warehouse = V.Warehouses().getAttribute("placeholder").trim().toLowerCase();
					String Weight = V.Weights().getAttribute("placeholder").trim().toLowerCase();
					String DispatchDateFromWh = V.DispatchDateFromWH().getAttribute("placeholder").trim().toLowerCase();
					String TransporterName = V.TransportName().getAttribute("placeholder").trim().toLowerCase();
					String DocketNumber = V.DocketNumber().getAttribute("placeholder").trim().toLowerCase();
					String ModeOfTransport = V.ModeOfTransport().getAttribute("placeholder").trim().toLowerCase();
					String StandardTATDays = V.StandardTAT().getAttribute("placeholder").trim().toLowerCase();
					String ExpectedDeliveryDate = V.ExpectedDateofDelivery().getAttribute("placeholder").trim().toLowerCase();
					String ActualDeliveryDate = V.ActualDateOfDelivery().getAttribute("placeholder").trim().toLowerCase();
					String ReceievedBy = V.Recievedby().getAttribute("placeholder").trim().toLowerCase();
					String Status = V.Status().getAttribute("placeholder").trim().toLowerCase();
					String DSTAT = V.DSTeamOrderSenttoWHTATDays().getAttribute("placeholder").trim();
					String WHPTAT = V.WHprocessingTATDays().getAttribute("placeholder").trim();
					String ActualTAT = V.ActualOrderDeliveryTAT().getAttribute("placeholder").trim();

					data.put(text,
							new Object[] { Saletype, Orderno, Invoicenumber, InvoiceDate, invWhDate, OrderRecieptTime, COTAT,
									InvQty, invValue, NoOfBoxes, DistributorName, DistributorId, Distphone, Location,
									AreaPinCode, State, RegionalZoneName, Remark, Warehouse, Weight, DispatchDateFromWh,
									TransporterName, DocketNumber, ModeOfTransport, StandardTATDays, ExpectedDeliveryDate,
									ActualDeliveryDate, ReceievedBy, Status, DSTAT, WHPTAT, ActualTAT
							});
					System.out.println("I value in String---" + text);
					System.out.println("Order-----" + Orderno);
					WA.Backbutton().click();
			}

			}
		}
		
		Set<String> keyset = data.keySet();
		int rownum = 0;

		for (String key : keyset) {
			HSSFRow row = sheet.createRow(rownum++);
			Object[] objectArr = data.get(key);
			int cellnum = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				} else if (obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				} else if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				}
			}
		}
		try {
			int menucount = H.leftsidemenus().size();
			String user = H.userprofilename().getText();
			FileOutputStream out;
			if (menucount == Integer.parseInt(prop.getProperty("Superadminmenucount")) && user.equalsIgnoreCase(prop.getProperty("superAdmin"))) {
				// Write the workbook in file system
				out = new FileOutputStream(new File(xlpath2));

			} else if (menucount == Integer.parseInt(prop.getProperty("AdminMenucount"))) {
				out = new FileOutputStream(new File(xlpath3));

			} else if (menucount == Integer.parseInt(prop.getProperty("customerMenuCount"))) {
				out = new FileOutputStream(new File(xlpath4));

			} else {
				out = new FileOutputStream(new File(xlpath5));
			}
			workbook.write(out);
			out.close();
			System.out.println("WriteValue.xlsx written successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
