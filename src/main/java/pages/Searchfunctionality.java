package pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.ModalPOM;
import POM.PaginationPOM;
import POM.SearchfunctionalityPOM;
import POM.UppMakePaymentPOM;
import POM.WHTablesPOM;
import POM.uppPaymentPOM;
import base.SuperTestNG;
import POM.ViewOrdersPOM;

public class Searchfunctionality extends SuperTestNG {

	public void Searchoptions() {
		HomepagePOM H = new HomepagePOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		UppMakePaymentPOM upp = new UppMakePaymentPOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);

		int menucount = H.leftsidemenus().size();

		if (menucount == 10) {
			Assert.assertTrue(H.SendSMSbutton().isDisplayed());
			Assert.assertTrue(H.ImportOrder().isDisplayed());
			Assert.assertTrue(H.CreateOrder().isDisplayed());
			Assert.assertTrue(S.orderno().isDisplayed());
			Assert.assertTrue(S.DistributorID().isDisplayed());
			Assert.assertTrue(S.Warehousedropwdownselect().isDisplayed());
			Assert.assertTrue(S.Saletype().isDisplayed());
			Assert.assertTrue(S.Datefield().isDisplayed());
			Assert.assertTrue(S.FromDate().isDisplayed());
			Assert.assertTrue(S.ToDate().isDisplayed());
			Assert.assertTrue(S.DistributorNamefield().isDisplayed());
			Assert.assertTrue(S.DistributorPhone().isDisplayed());
			Assert.assertTrue(S.ExportExcel().isDisplayed());
			Assert.assertTrue(S.ExportPDF().isDisplayed());
			Assert.assertTrue(S.Searchbutton().isDisplayed());
			Assert.assertTrue(S.Resetbutton().isDisplayed());
		} else if (menucount == 2) {
			Assert.assertTrue(upp.MakePaymentButton().isDisplayed());
			Assert.assertTrue(u.SearchDistributorIDfield().isDisplayed());
			Assert.assertTrue(u.SearchUppNo().isDisplayed());
			Assert.assertTrue(u.SearchUppOrderID().isDisplayed());
			Assert.assertTrue(u.SearchUppOrderStatus().isDisplayed());
			Assert.assertTrue(u.SearchUppOrderdate().isDisplayed());
			Assert.assertTrue(u.SearchOrderSheetUploadCheckbox().isDisplayed());
			Assert.assertTrue(u.ExportExcelButton().isDisplayed());
			Assert.assertTrue(u.Searchbutton().isDisplayed());
			Assert.assertTrue(u.clearbutton().isDisplayed());
		} else if (menucount == 3) {
			Assert.assertTrue(S.orderno().isDisplayed());
			Assert.assertTrue(S.DistributorID().isDisplayed());
			Assert.assertTrue(S.Warehousedropwdownselect().isDisplayed());
			Assert.assertTrue(S.Saletype().isDisplayed());
			Assert.assertTrue(S.Datefield().isDisplayed());
			Assert.assertTrue(S.FromDate().isDisplayed());
			Assert.assertTrue(S.ToDate().isDisplayed());
			Assert.assertTrue(S.DistributorNamefield().isDisplayed());
			Assert.assertTrue(S.DistributorPhone().isDisplayed());
			Assert.assertTrue(S.ExportExcel().isDisplayed());
			Assert.assertTrue(S.ExportPDF().isDisplayed());
			Assert.assertTrue(S.Searchbutton().isDisplayed());
			Assert.assertTrue(S.Resetbutton().isDisplayed());
		} else {
			Assert.assertTrue(H.ImportOrder().isDisplayed());
			Assert.assertTrue(H.CreateOrder().isDisplayed());
			Assert.assertTrue(S.orderno().isDisplayed());
			Assert.assertTrue(S.DistributorID().isDisplayed());
			Assert.assertTrue(S.Saletype().isDisplayed());
			Assert.assertTrue(S.Datefield().isDisplayed());
			Assert.assertTrue(S.FromDate().isDisplayed());
			Assert.assertTrue(S.ToDate().isDisplayed());
			Assert.assertTrue(S.DistributorNamefield().isDisplayed());
			Assert.assertTrue(S.DistributorPhone().isDisplayed());
			Assert.assertTrue(S.ExportExcel().isDisplayed());
			Assert.assertTrue(S.ExportPDF().isDisplayed());
			Assert.assertTrue(S.Searchbutton().isDisplayed());
			Assert.assertTrue(S.Resetbutton().isDisplayed());
		}
	}

	public void verifySearchTitles() {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		int menucount = H.leftsidemenus().size();
		String text = S.numberofentries().getText();
		String totalvalidorders = text.replaceAll("[^0-9]", "").trim();
		int rcount = Integer.parseInt(totalvalidorders);

		String Ordertitle = S.ordernotitle().getText();
		String Distid = S.DistributorIDtitle().getText();
		String Saletype = S.SaleTypetitle().getText();
		String datefield = S.DateFieldstitle().getText();
		String fromdate = S.FromDatetitle().getText();
		String todate = S.ToDateTitle().getText();
		String DistributorName = S.DistributorNameTitle().getText();
		String Distributorphone = S.DistributorPhoneTitle().getText();

		if (menucount == Integer.parseInt(prop.getProperty("WHuserMenuCount"))) {
			Assert.assertEquals(Ordertitle, prop.getProperty("orderno"));
			Assert.assertEquals(Distid, prop.getProperty("distributorid"));
			Assert.assertEquals(Saletype, prop.getProperty("saletype"));
			Assert.assertEquals(datefield, prop.getProperty("Datefields"));
			Assert.assertEquals(fromdate, prop.getProperty("fromdate"));
			Assert.assertEquals(todate, prop.getProperty("todate"));
			Assert.assertEquals(DistributorName, prop.getProperty("distributorname"));
			Assert.assertEquals(Distributorphone, prop.getProperty("distributorphone"));
		} else {
			Assert.assertEquals(Ordertitle, prop.getProperty("orderno"));
			Assert.assertEquals(Distid, prop.getProperty("distributorid"));
			String Warehouse = S.warehousetitle().getText();
			Assert.assertEquals(Warehouse, prop.getProperty("warehouse"));
			Assert.assertEquals(Saletype, prop.getProperty("saletype"));
			Assert.assertEquals(datefield, prop.getProperty("Datefields"));
			Assert.assertEquals(fromdate, prop.getProperty("fromdate"));
			Assert.assertEquals(todate, prop.getProperty("todate"));
			Assert.assertEquals(DistributorName, prop.getProperty("distributorname"));
			Assert.assertEquals(Distributorphone, prop.getProperty("distributorphone"));
		}
		System.out.println("rcount value---" + rcount);
		if (rcount > 0) {
			String Exportexcel = S.ExportExcel().getText();
			Assert.assertEquals(Exportexcel, prop.getProperty("exportexcel"));
			String Exportpdf = S.ExportPDF().getText();
			Assert.assertEquals(Exportpdf, prop.getProperty("exportpdf"));
		} else {
			System.out.println("No Records found in Table");
		}

		String Search = S.Searchbutton().getAttribute("value");
		Assert.assertEquals(Search, prop.getProperty("search"));
		String reset = S.Resetbutton().getText();
		Assert.assertEquals(reset, prop.getProperty("reset"));
	}

	/*
	 * https://www.seleniumeasy.com/selenium-tutorials/verify-entries-in-exported-
	 * csv-file-using-webdriver-java (Read all the rows and columns)
	 * http://automationtesting.in/row-count-and-column-count-in-excel/ (Read count
	 * of column and row)
	 */

	public void exportexcel() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);

		H.WarehouseOrdermenu().click();

		int noOfEntries = getNumberOfEntries();
		System.out.println("Total number of entries in Excel export :- " + noOfEntries);

		if (noOfEntries > 0) {
			S.ExportExcel().click();
			Thread.sleep(10000);
			getLatestFilefromDir(Exceldownloadpath);
			File file = getLatestFilefromDir(Exceldownloadpath);
			String ExcelFilename = file.getName();

			System.out.println("Verifying number of entries with number of entries in Excel sheet");
			Assert.assertEquals(noOfEntries, getRecordsCountInExcel(Exceldownloadpath, ExcelFilename));
		}
	}

	public void exportPDF() throws Exception {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		WHTablesPOM T = new WHTablesPOM(driver);

		int noOfEntries = getNumberOfEntries();
		System.out.println("Total number of entries in Export PDF :- " + noOfEntries);

		if (noOfEntries > 0) {
			String Firstorder = T.firstdisplayedorderintable().getText();
			S.ExportPDF().click();
			Thread.sleep(5000);
			getLatestFilefromDir(Exceldownloadpath);
			File file = getLatestFilefromDir(Exceldownloadpath);
			String PDFFilename = file.getName();

			Assert.assertTrue(PDFFilename.contains(".pdf"));
			Assert.assertTrue(getPDFrecord(Exceldownloadpath, PDFFilename).contains(Firstorder));
		}
	}

	private File getLatestFilefromDir(String dirPath) {
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
				HSSFWorkbook workbook = new HSSFWorkbook(fis);
				HSSFSheet sheet = workbook.getSheetAt(0);
				rowNum = sheet.getLastRowNum();
				System.out.println("Total Number of Rows in the excel is : " + rowNum);
			}
		}

		return rowNum;
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
				strip.setStartPage(1);
				strip.setEndPage(8);
				pdftexts = strip.getText(pddoc);
			}
		}
		return pdftexts;
	}

	public void verifypagination() throws Exception {
		PaginationPOM P = new PaginationPOM(driver);
		int pagesize = P.paginationlinks().size();
		if (pagesize > 0) {
			for (int i = 1; i < pagesize; i++) {
				P.paginationlinks().get(i).click();
			}
		}

	}

//	http://automationtesting.in/read-data-from-excel-using-column-name/
	public String GetcolumnTitles(String Exceldownloadpath, String ExcelFilename) throws Exception {
		String rowNum = null;
		if (!ExcelFilename.isEmpty() || ExcelFilename != null) {
			String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
			File file = new File(filePath);
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(filePath);
				HSSFWorkbook workbook = new HSSFWorkbook(fis);
				HSSFSheet sheet = workbook.getSheetAt(0);
				HSSFRow row = sheet.getRow(1);

			}
		}
		return rowNum;
	}

	public void VerifyTitles() throws Exception {
		WHTablesPOM T = new WHTablesPOM(driver);
		String[] names = { "Order#/SO#", "Distributor Name", "DistributorID/UPP#", "Distributor Location", "Warehouse",
				"Invoice Value", "Docket.No", "Transporter Name", "Mode of Transport", "C TAT",
				"Expected Delivery Date", "Dispatch DT from WH", "Action" };
		int length = T.titles().size();
		Assert.assertEquals(length, 13);
		for (int i = 0; i < length; i++) {
			String titles = T.titles().get(i).getText().trim();
			Assert.assertEquals(titles, names[i]);
		}

	}

	public void SelectRandompage() {
		PaginationPOM P = new PaginationPOM(driver);
		int length = P.paginationlinks().size();
		Random r = new Random();
		if (length > 0) {
			String pagename = P.paginationlinks().get(r.nextInt(length)).getText();
			System.out.println("Pagename---" + pagename);
			P.paginationlinks().get(r.nextInt(length)).click();
		} else {
			System.out.println("Pagination is not enables as we don't have it");
		}

	}

	public void OrderNumberfield() throws Exception {
		WHTablesPOM T = new WHTablesPOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		int ordercountbeforesearch = T.ordernumbers().size();

		Random rand = new Random();
		String order = T.ordernumbers().get(rand.nextInt(ordercountbeforesearch)).getText();
		S.orderno().sendKeys(order);
		S.Searchbutton().click();
		String result = T.firstdisplayedorderintable().getText();
		Assert.assertEquals(order, result);

		int orderountaftersearch = T.ordernumbers().size();
		String text = S.numberofentries().getText();
		String totalvalidorders = text.replaceAll("[^0-9]", "").trim();
		Assert.assertEquals(orderountaftersearch, Integer.parseInt(totalvalidorders));
		S.orderno().clear();
	}

	public void InvalidOrderNumber() {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		S.orderno().sendKeys(genData.generateRandomNumber(10));
		S.Searchbutton().click();
		String message = S.Norecordmessage().getText();
		Assert.assertEquals(prop.getProperty("Norecord"), message);
		S.Resetbutton().click();
	}

	public void Distributoridfield() throws Exception {
		WHTablesPOM T = new WHTablesPOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		int idcountbeforesearch = T.distributorids().size();

		Random r = new Random();
		String distid = T.distributorids().get(r.nextInt(idcountbeforesearch)).getText();
		S.DistributorID().sendKeys(distid);
		S.Searchbutton().click();

		int idcountaftersearch = T.distributorids().size();
		String text = S.numberofentries().getText();
		String totalvalidorders = text.replaceAll("[^0-9]", "").trim();
		Assert.assertEquals(idcountaftersearch, Integer.parseInt(totalvalidorders));
		if (idcountaftersearch > 1) {
			for (int i = 0; i < idcountaftersearch; i++) {
				String ids = T.distributorids().get(i).getText();
				Assert.assertEquals(distid, ids);
			}
		} else {
			String result = T.firstdisplayeddistidintable().getText();
			Assert.assertEquals(distid, result);
		}
		S.DistributorID().clear();
	}

	public void Distributornamefield() {
		WHTablesPOM T = new WHTablesPOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		String distname = null;
		int namecountbeforesearch = T.distributornames().size();
		for (int i = 0; i < namecountbeforesearch; i++) {
			distname = T.distributornames().get(i).getText();
			if (distname.isEmpty()) {
				continue;
			}
			S.DistributorNamefield().sendKeys(distname);
			S.Searchbutton().click();
			break;
		}

		int namecountaftersearch = T.distributornames().size();
		String text = S.numberofentries().getText();
		String totalvalidorders = text.replaceAll("[^0-9]", "").trim();
		Assert.assertEquals(namecountaftersearch, Integer.parseInt(totalvalidorders));

		if (namecountaftersearch > 1) {
			for (int i = 0; i < namecountaftersearch; i++) {
				String names = T.distributornames().get(i).getText();
				Assert.assertEquals(distname.toLowerCase(), names.toLowerCase());
			}
		} else {
			String result = T.firstdisplayeddistnameintable().getText();
			Assert.assertEquals(distname.toLowerCase(), result.toLowerCase());
		}

		S.DistributorNamefield().clear();
	}

	public void Distributorphonefield() {
		WHTablesPOM T = new WHTablesPOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		ViewOrdersPOM V = new ViewOrdersPOM(driver);

		int viewcountbeforesearch = T.Actionviews().size();
		Random r = new Random();
		int view = r.nextInt(viewcountbeforesearch);
		WebElement viewbutton = T.Actionviews().get(view);
		viewbutton.click();

		String distphone = V.distributorphone().getAttribute("placeholder");
		V.viewbackbutton().click();

		S.DistributorPhone().sendKeys(distphone);
		S.Searchbutton().click();

		int viewcountaftersearch = T.Actionviews().size();
		String text = S.numberofentries().getText();
		String totalvalidorders = text.replaceAll("[^0-9]", "").trim();
		Assert.assertEquals(viewcountaftersearch, Integer.parseInt(totalvalidorders));
		S.DistributorPhone().clear();
	}

	public void Resultdatacount() {
		WHTablesPOM T = new WHTablesPOM(driver);
		PaginationPOM P = new PaginationPOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		H.WarehouseOrdermenu().click();
		int rcount = T.tableresult().size();

		while (P.numberpagination().size() > 0) {
			if (P.nextpage().size() > 0) {
				P.nextarrow().click();
				rcount += T.tableresult().size();
			} else {
				break;
			}
		}

		String text = S.numberofentries().getText();
		String totalvalidorders = text.replaceAll("[^0-9]", "").trim();
		Assert.assertEquals(rcount, Integer.parseInt(totalvalidorders));
		System.out.println("************Result count function over***********");
	}

	public void Verifyoptions() {
		HomepagePOM H = new HomepagePOM(driver);
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		WHTablesPOM T = new WHTablesPOM(driver);
		int menucount = H.leftsidemenus().size();
		WebElement first = T.firstcheckbox();

		if (menucount == Integer.parseInt(prop.getProperty("customerMenuCount"))) {
			Assert.assertTrue(driver.findElements(By.cssSelector("a#sendsms")).size() == 0);
			Assert.assertTrue(driver.findElements(By.xpath("//*[text()='Import Order']")).size() == 0);
			Assert.assertTrue(driver.findElements(By.xpath("userprofilename")).size() == 0);
			first.click();
			Assert.assertTrue(S.BulckActiontext().isDisplayed());
			first.click();
		}
	}

	public void VerifyTotalCount() {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		WHTablesPOM T = new WHTablesPOM(driver);
		PaginationPOM P = new PaginationPOM(driver);

		int rcount = T.Actionviews().size();
		int pagination = P.numberpagination().size();

		if (pagination > 0) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < pagination; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();
				rcount += T.Actionviews().size();
			}
		}

		/*
		 * while (P.numberpagination().size() > 0) { if (P.nextpage().size() > 0) {
		 * P.nextarrow().click(); rcount += T.Actionedits().size(); } else { break; } }
		 */

		String text = S.numberofentries().getText();
		String totalvalidorders = text.replaceAll("[^0-9]", "").trim();
//		String totalvalidorders = S.numberofentries().getText();

		System.out.println("Total order count---" + totalvalidorders);
		System.out.println("Rcount----" + rcount);
		Assert.assertEquals(rcount, Integer.parseInt(totalvalidorders));
		System.out.println("************Total valid order number is---" + totalvalidorders + "**************");
	}

	public void SelectWarehouse() throws Exception {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		Searchfunctionality Se = new Searchfunctionality();

		WHTablesPOM T = new WHTablesPOM(driver);

		Select wh = new Select(S.Warehousedropwdownselect());
		int count = S.Warehouseoptions().size();

		int randnumber = ThreadLocalRandom.current().nextInt(1, count);
		wh.selectByIndex(randnumber);

		String whname = wh.getFirstSelectedOption().getText();
		System.out.println("Brefore wh name--" + whname);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.textToBePresentInElement(wh.getFirstSelectedOption(), whname));
		S.Searchbutton().click();

		int aftercount = T.Warehousenames().size();
		for (int i = 0; i < aftercount; i++) {
			String whnames = T.Warehousenames().get(i).getText();
			System.out.println("Warehouse Names---" + whnames);
			Assert.assertEquals(whname, whnames);
		}
		Se.VerifyTotalCount();
		System.out.println("************Select Warehouse***********");
	}

	public void SelectSaletype() throws Exception {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		Searchfunctionality Se = new Searchfunctionality();

		Select Saletype = new Select(S.Saletype());
		int count = S.Saletypeoptions().size();

		int randnumber = ThreadLocalRandom.current().nextInt(1, count);
		Saletype.selectByIndex(randnumber);

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(S.Saletype()));
		S.Searchbutton().click();

		Se.VerifyTotalCount();
		Thread.sleep(500);
		S.Resetbutton().click();
		System.out.println("************Select Sale type***********");
	}

	public void searcherror() throws Exception {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		HomepagePOM h = new HomepagePOM(driver);

		h.WarehouseOrdermenu().click();
		S.Searchbutton().click();
		Thread.sleep(1000);
		assertTrue(S.searcherror().isDisplayed());
		String error = S.searcherror().getText();
		Assert.assertEquals(error, prop.getProperty("errormessage"));
		S.Resetbutton().click();
	}

	public void Datefiled() throws ParseException {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);

		Select datefield = new Select(S.Datefield());
		int count = S.datefieldoptions().size();

		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(S.Datefield()));

		Random r = new Random();
		int select = r.nextInt(count);
		datefield.selectByIndex(select);
	}

	public void SendDateformat() throws ParseException, InterruptedException {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		Searchfunctionality Se = new Searchfunctionality();

//		select from date from Datepicker
		String Startdate = genData.generateRandomDate("MM/dd/yyyy", "01/01/2018", "01/02/2019");
		S.FromDate().sendKeys(Startdate);

//		Select TO date from Datepicker
		S.ToDate().sendKeys(genData.currentdate());
		S.ToDate().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		S.Searchbutton().click();
		Se.VerifyTotalCount();
		S.Resetbutton().click();
	}

	public void usedatepicker() throws Exception {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		Searchfunctionality Se = new Searchfunctionality();

		LocalDate currentDate = LocalDate.now();
		Month m = currentDate.getMonth();
		int y = currentDate.getYear();
		String monthyear = m + " " + Integer.toString(y);
		System.out.println("monthyear---" + monthyear);

		S.FromDate().click();
		String Datepickertitle = S.datepickertitle().getText().toLowerCase();
		System.out.println("From Date Datepicker----" + Datepickertitle);

		Assert.assertEquals(Datepickertitle, monthyear.toLowerCase());

		for (int i = 0; i <= 10; i++) {
			S.datepreviouslink().click();
		}
		S.datenext().click();

		for (WebElement cell : S.datecolumns()) {
			if (cell.getText().equals("20")) {
				cell.click();
				break;
			}
		}

		S.ToDate().click();
		Assert.assertEquals(Datepickertitle, monthyear.toLowerCase());

		for (int i = 0; i <= 6; i++) {
			S.datepreviouslink().click();
		}
		S.datenext().click();

		for (WebElement cell : S.datecolumns()) {
			if (cell.getText().equals("1")) {
				cell.click();
				break;
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(S.Searchbutton()));

		Thread.sleep(1000);

		S.Searchbutton().click();
		Se.VerifyTotalCount();
		S.Resetbutton().click();
	}

	public void Checkallorders() throws InterruptedException {
		WHTablesPOM T = new WHTablesPOM(driver);

		int checkboxes = T.checkboxes().size();

		String selectedrecords = T.numberofselectedrecords().getText();
		Assert.assertEquals(selectedrecords, "");
		Thread.sleep(1000);
		T.checkallcheckbox().click();
		String checkedrecords = T.numberofselectedrecords().getText().substring(0, 2).trim();
		Assert.assertEquals(checkboxes, Integer.parseInt(checkedrecords));

		T.checkallcheckbox().click();
		String uncheckedrecords = T.numberofselectedrecords().getText();
		Assert.assertEquals(uncheckedrecords, "");
	}

	public void Deleteorder() throws Exception {
		SearchfunctionalityPOM S = new SearchfunctionalityPOM(driver);
		WHTablesPOM T = new WHTablesPOM(driver);
		ModalPOM M = new ModalPOM(driver);

		int checkboxes = T.checkboxes().size();
		WebElement first = T.firstcheckbox();
		WebElement second = T.secondcheckbox();
		WebElement remove = T.deleterecordbutton();

		if (checkboxes > 0) {
			first.click();
			remove.click();
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(M.RecordModal()));

		Assert.assertTrue(M.RecordModal().isDisplayed());
		String text = M.RecordModalTitle().getText();
		Assert.assertEquals(text, prop.getProperty("Recordmodaltitle"));
		String Warning = M.RecordModalwarringmessage().getText();
		Assert.assertEquals(Warning, prop.getProperty("RecordModalWarrning"));
		M.RecordModalClose().click();

		wait.until(ExpectedConditions.invisibilityOf(M.RecordModal()));
		first.click();

		if (checkboxes > 1) {
			second.click();
			remove.click();
			M.RecordModalcancelbutton().click();
			wait.until(ExpectedConditions.invisibilityOf(M.RecordModal()));
		}

		S.Resetbutton().click();
		Random r = new Random();
		int count = r.nextInt(checkboxes);
		WebElement Checkbox = T.checkboxes().get(count);
		Checkbox.click();
		remove.click();
		M.RecordModaldeletebutton().click();

		wait.until(ExpectedConditions.invisibilityOf(M.RecordModal()));
		Assert.assertTrue(S.Deletedsuccessmessage().isDisplayed());
		String deletedsuccessmessage = S.Deletedsuccessmessage().getText();
		Assert.assertEquals(prop.getProperty("DeletedSucessmessage"), deletedsuccessmessage);
		S.Resetbutton().click();
	}

}
