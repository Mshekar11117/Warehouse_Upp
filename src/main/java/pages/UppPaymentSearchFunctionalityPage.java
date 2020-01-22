package pages;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.UppPaymentViewPOM;
import POM.uppPaymentPOM;
import POM.uppPaymentTablePOM;
import base.SuperTestNG;
import utilities.XlApiTest;

public class UppPaymentSearchFunctionalityPage extends SuperTestNG {

	public void SearchFieldlables() {
		uppPaymentPOM u = new uppPaymentPOM(driver);

		String distid = u.labelDistributorID().getText();
		Assert.assertEquals(prop.getProperty("labelDistributorID"), distid);

		String uppno = u.labelUppNo().getText();
		Assert.assertEquals(prop.getProperty("labelUPPNumber"), uppno);

		String upporderid = u.labelUppOrderID().getText();
		Assert.assertEquals(prop.getProperty("labelUPPOrderID"), upporderid);

		String upporderstatuc = u.labelUppOrderStatus().getText();
		Assert.assertEquals(prop.getProperty("labelUPPOrderStatus"), upporderstatuc);

		String upporderdate = u.labelUPPOrderdate().getText();
		Assert.assertEquals(prop.getProperty("labelUPPOrderdate"), upporderdate);

		String uppordersheetupload = u.labelOrderSheetUpload().getText();
		Assert.assertEquals(prop.getProperty("labelOrderSheetUpload"), uppordersheetupload);
	}

	public void SearchError() {
		uppPaymentPOM u = new uppPaymentPOM(driver);

		u.Searchbutton().click();
		Assert.assertTrue(u.searcherror().isDisplayed());
		String errormessage = u.searcherrormessage().getText();
		Assert.assertEquals(prop.getProperty("SearcherrorMessage"), errormessage);

	}

	public void DistIDSearchfieldErrorMessage() {
		uppPaymentPOM u = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);

		u.SearchDistributorIDfield().sendKeys(genData.generateRandomNumber(11));
		u.Searchbutton().click();

		if (ut.ErrorMessage().isDisplayed()) {
			String errormessage = ut.ErrorMessage().getText();
			Assert.assertEquals(prop.getProperty("NoRecordsFound"), errormessage);
		}

		u.SearchDistributorIDfield().clear();
	}

	public void DistIDSearchfield() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;

		XlApiTest xl = new XlApiTest(filePath);
		Random r = new Random();
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		System.out.println("Row count--" + rowcount);
		String distidno = xl.HSSFgetCellDataByColName("Sheet 1", "upp_dist_id", r.nextInt(rowcount)).trim();

		int excelcount = 0;
		for (int i = 1; i <= rowcount; i++) {
			String disid = xl.HSSFgetCellDataByColName("Sheet 1", "upp_dist_id", i).trim();
			if (disid.equals(distidno)) {
				excelcount++;
			}
		}

		u.SearchDistributorIDfield().sendKeys(distidno);
		u.Searchbutton().click();

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum + totalrow);

		} else {
			int appcount = ut.TotalNumberofRow().size();
			Assert.assertEquals(excelcount, appcount);
		}

		u.clearbutton().click();

	}

	public void UppNumberSearchfieldErrorMessage() {
		uppPaymentPOM u = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);

		u.SearchUppNo().sendKeys(genData.generateRandomNumber(11));
		u.Searchbutton().click();

		if (ut.ErrorMessage().isDisplayed()) {
			String errormessage = ut.ErrorMessage().getText();
			Assert.assertEquals(prop.getProperty("NoRecordsFound"), errormessage);
		}

		u.SearchUppNo().clear();
	}

	public void UppNumberSearch() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;

		Random r = new Random();
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");
		String uppno = xl.HSSFgetCellDataByColName("Sheet 1", "upp_no", r.nextInt(rowcount)).toLowerCase()
				.replace(" ", "").trim();

		int excelcount = 0;
		for (int i = 1; i <= rowcount; i++) {
			String uppnoexcel = xl.HSSFgetCellDataByColName("Sheet 1", "upp_no", i).toLowerCase().replace(" ", "")
					.trim();
			if (uppnoexcel.equals(uppno)) {
				String OrderID = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_order_id", i).toLowerCase().trim();
				System.out.println("Random Excel upp no---" + uppno);
				System.out.println("Excel upp no---" + uppnoexcel);
				System.out.println("Order id----" + OrderID);
				excelcount++;
			}
		}

		u.SearchUppNo().sendKeys(uppno);
		u.Searchbutton().click();

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum + totalrow);

		} else {
			int appcount = ut.TotalNumberofRow().size();
			Assert.assertEquals(excelcount, appcount);
		}

		u.clearbutton().click();
	}

	public void UppOrderIDErrorMessage() {
		uppPaymentPOM u = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);

		u.SearchUppOrderID().sendKeys(genData.generateRandomNumber(11));
		u.Searchbutton().click();

		if (ut.ErrorMessage().isDisplayed()) {
			String errormessage = ut.ErrorMessage().getText();
			Assert.assertEquals(prop.getProperty("NoRecordsFound"), errormessage);
		}

		u.SearchUppOrderID().clear();
	}

	public void UppOrderIDfield() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;

		Random r = new Random();
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");
		String uppOrderID = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_order_id", r.nextInt(rowcount))
				.toLowerCase().trim();

		int excelcount = 0;
		for (int i = 1; i <= rowcount; i++) {
			String UppOrderIdexcel = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_order_id", i).toLowerCase().trim();
			if (uppOrderID.equals(UppOrderIdexcel)) {
				excelcount++;
			}
		}

		u.SearchUppOrderID().sendKeys(uppOrderID);
		u.Searchbutton().click();

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum);

		} else {
			int appcount = ut.TotalNumberofRow().size();
			Assert.assertEquals(excelcount, appcount);
		}

		u.clearbutton().click();
	}

	public void UppOrderDateErrorMessage() throws Exception {
		uppPaymentPOM u = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);

		u.SearchUppOrderdate().sendKeys(genData.generateRandomDate("yyyy-mm-dd", "2000-01-01", "2003-01-01"));
		u.SearchUppOrderdate().sendKeys(Keys.ENTER);
		u.Searchbutton().click();

		if (ut.ErrorMessage().isDisplayed()) {
			String errormessage = ut.ErrorMessage().getText();
			Assert.assertEquals(prop.getProperty("NoRecordsFound"), errormessage);
		}

		u.SearchUppOrderdate().clear();
	}

	public void UppOrderDatefield() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;

		Random r = new Random();
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		String date = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_date", r.nextInt(rowcount)).trim();
		LocalDateTime originalformat = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String uppOrderDate = originalformat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		int excelcount = 0;
		for (int i = 2; i <= rowcount; i++) {
			String date1 = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_date", i).trim();
			System.out.println("date1----" + date1);
			LocalDateTime ofromat = LocalDateTime.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String UppOrderDateExcel = ofromat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			if (UppOrderDateExcel.equals(uppOrderDate)) {
				excelcount++;
			}
		}

		u.SearchUppOrderdate().sendKeys(uppOrderDate);
		u.SearchUppOrderdate().sendKeys(Keys.ENTER);
		u.Searchbutton().click();

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum);

		} else {
			int appcount = ut.TotalNumberofRow().size();
			Assert.assertEquals(excelcount, appcount);
		}

		u.clearbutton().click();
	}

	public void OrdeSheetUpload() {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		UppPaymentViewPOM uv = new UppPaymentViewPOM(driver);

		u.SearchOrderSheetUploadCheckbox().click();
		u.Searchbutton().click();

		int viewbuttons = ut.allViewbuttons().size();

		for (int i = 1; i <= viewbuttons; i++) {
			driver.findElement(By.xpath("(//a[@class='btn btn-warning'])[" + i + "]")).click();
			Set<String> id = driver.getWindowHandles();
			Iterator<String> it = id.iterator();
			String parent = it.next();
			String child = it.next();
			driver.switchTo().window(child);
			String Uploaded = uv.TitleDownloadUploadedlinkTitle().getText();
			Assert.assertEquals(prop.getProperty("Downloaduploadedexcel"), Uploaded);
			Assert.assertTrue(uv.DownloadUploadedlink().isDisplayed());
			driver.close();
			driver.switchTo().window(parent);
		}

		u.clearbutton().click();
	}

	public void UppOrderStatusSuccess() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(1);
		u.Searchbutton().click();
		Thread.sleep(1000);
		String status = u.SearchOrderStatusSelectedOption().getText().toLowerCase().trim();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		int excelcount = 0;
		for (int i = 2; i <= rowcount; i++) {
			String success = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();

			if (status.equals(success)) {
				excelcount++;
			}
		}

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(excelcount, appcount);
		}

	}

	public void UppOrderStatusFailure() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(2);
		u.Searchbutton().click();
		Thread.sleep(1000);
		String status = u.SearchOrderStatusSelectedOption().getText().toLowerCase().trim();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		int excelcount = 0;
		for (int i = 2; i <= rowcount; i++) {
			String success = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();

			if (status.equals(success)) {
				excelcount++;
			}
		}

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(excelcount, appcount);
		}

	}

	public void UppOrderStatusAborted() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(3);
		u.Searchbutton().click();
		Thread.sleep(1000);
		String status = u.SearchOrderStatusSelectedOption().getText().toLowerCase().trim();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		int excelcount = 0;
		for (int i = 2; i <= rowcount; i++) {
			String success = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();

			if (status.equals(success)) {
				excelcount++;
			}
		}

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(excelcount, appcount);
		}

	}

	public void UppOrderStatusInvalid() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(4);
		u.Searchbutton().click();
		Thread.sleep(1000);
		String status = u.SearchOrderStatusSelectedOption().getText().toLowerCase().trim();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		int excelcount = 0;
		for (int i = 2; i <= rowcount; i++) {
			String success = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();

			if (status.equals(success)) {
				excelcount++;
			}
		}

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(excelcount, appcount);
		}

	}

	public void UppOrderStatusInitiated() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(5);
		u.Searchbutton().click();
		Thread.sleep(1000);
		String status = u.SearchOrderStatusSelectedOption().getText().toLowerCase().trim();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		int excelcount = 0;
		for (int i = 2; i <= rowcount; i++) {
			String success = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();

			if (status.equals(success)) {
				excelcount++;
			}
		}

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(excelcount, appcount);
		}

	}

	public void UppOrderStatusTimeout() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(6);
		u.Searchbutton().click();
		Thread.sleep(1000);
		String status = u.SearchOrderStatusSelectedOption().getText().toLowerCase().trim();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		int excelcount = 0;
		for (int i = 2; i <= rowcount; i++) {
			String success = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();

			if (status.equals(success)) {
				excelcount++;
			}
		}

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(excelcount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(excelcount, appcount);
		}

	}

	public void DistidCombinationSearch(int n, String selection) throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		u.clearbutton().click();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(n);
		u.Searchbutton().click();
		Thread.sleep(1000);

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		Random r = new Random();
		String Distid = xl.HSSFgetCellDataByColName("Sheet 1", "upp_dist_id", r.nextInt(rowcount));
		System.out.println("Dist id" + selection + "---" + Distid);

		String Upppaystatus = selection;
		int successcount = 0;
		for (int i = 0; i <= rowcount; i++) {
			String ExcelDistid = xl.HSSFgetCellDataByColName("Sheet 1", "upp_dist_id", i);
			if (Distid.equals(ExcelDistid)) {
				String paystatus = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();
				if (paystatus.equals(Upppaystatus.toLowerCase().trim())) {
					successcount++;
				}
			}
		}

		u.SearchDistributorIDfield().sendKeys(Distid);
		u.Searchbutton().click();

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(successcount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(successcount, appcount);
		}
	}

	public void DistidAndStatusSuccessSearch() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.DistidCombinationSearch(1, "Success");
	}

	public void DistIDandFailureStatusSearch() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.DistidCombinationSearch(2, "Failure");
	}

	public void DistidAndAbortedStatus() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.DistidCombinationSearch(3, "Aborted");
	}

	public void DistidAndInvalidStatus() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.DistidCombinationSearch(4, "Invalid");
	}

	public void DistidAndInitiatedStatus() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.DistidCombinationSearch(5, "Initiated");
	}

	public void DistidAndTimeOutStatus() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.DistidCombinationSearch(6, "Timeout");
	}

	public void UppNumberCombinationSearch(int n, String selection) throws Exception {
		try {
			uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
			uppPaymentPOM u = new uppPaymentPOM(driver);
			ExportExcel ex = new ExportExcel();

			u.clearbutton().click();

			Select select = new Select(u.SearchUppOrderStatus());
			select.selectByIndex(n);
			u.Searchbutton().click();
			Thread.sleep(1000);

			File file = ex.getLatestFilefromDir(Exceldownloadpath);
			String ExcelFilename = file.getName();
			String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
			XlApiTest xl = new XlApiTest(filePath);
			int rowcount = xl.HFFSgetRowCount("Sheet 1");

			Random r = new Random();
			String uppno = xl.HSSFgetCellDataByColName("Sheet 1", "upp_no", r.nextInt(rowcount)).toLowerCase().trim();
			System.out.println("Upp No " + selection + "---" + uppno);

			String Upppaystatus = selection;
			int uppnumbercount = 0;
			for (int i = 0; i <= rowcount; i++) {
				String Exceluppno = xl.HSSFgetCellDataByColName("Sheet 1", "upp_no", i).toLowerCase().trim();
				if (uppno.equals(Exceluppno)) {
					String paystatus = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();
					if (paystatus.equals(Upppaystatus.toLowerCase().trim())) {
						uppnumbercount++;
					}
				}
			}

			u.SearchUppNo().sendKeys(uppno);
			u.Searchbutton().click();

			if (ut.NumberofPagination().size() > 0) {
				int length = ut.NumberofPagination().size();
				ArrayList<Integer> array = new ArrayList<Integer>();
				int totalrow = ut.TotalNumberofRow().size();

				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebDriverWait wait = new WebDriverWait(driver, 10);
				for (int i = 3; i < length; i++) {
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
					wait.until(ExpectedConditions.elementToBeClickable(page));
					page.click();

					array.add(totalrow);
					totalrow = ut.TotalNumberofRow().size();
				}

				int sum = 0;
				for (int j = 0; j < array.size(); j++) {
					sum += array.get(j);
				}
				Assert.assertEquals(uppnumbercount, sum + totalrow);
			} else {
				int appcount = ut.TotalUppNofields().size();
				Assert.assertEquals(uppnumbercount, appcount);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void UppNumberAndSuccessStatus() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.UppNumberCombinationSearch(1, "Success");
	}

	public void UppNumberAndFailureStatus() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.UppNumberCombinationSearch(2, "Failure");
	}

	public void UppNumberAndAbortedStatus() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.UppNumberCombinationSearch(3, "Aborted");
	}

	public void UppNumberAndInvalidStatus() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.UppNumberCombinationSearch(4, "Invalid");
	}

	public void UppNumberAndInitiatedStatus() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.UppNumberCombinationSearch(5, "Initiated");
	}

	public void UppNumberAndTimeoutStatus() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.UppNumberCombinationSearch(6, "Timeout");
	}

	public void DatewithDistIDCombinationSearch() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		u.clearbutton().click();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		Random r = new Random();

		String DistID = xl.HSSFgetCellDataByColName("Sheet 1", "upp_dist_id", r.nextInt(rowcount));
		System.out.println("Dist ID Number----" + DistID);

		String OrderDate = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_date", r.nextInt(rowcount - 21));
		LocalDateTime originalformat = LocalDateTime.parse(OrderDate,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String uppOrderDate = originalformat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("Order Date---" + uppOrderDate);

		int distdatecount = 0;
		for (int i = 0; i <= rowcount - 27; i++) {
			String ExcelDistid = xl.HSSFgetCellDataByColName("Sheet 1", "upp_dist_id", i);
			if (DistID.equals(ExcelDistid)) {
				String paydate = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_date", i).trim();
				LocalDateTime Payformat = LocalDateTime.parse(paydate,
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				String OrderUPPDate = Payformat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

				if (OrderUPPDate.equals(uppOrderDate.trim())) {
					distdatecount++;
				}
			}
		}

		u.SearchDistributorIDfield().sendKeys(DistID);
		u.SearchUppOrderdate().sendKeys(uppOrderDate);
		u.SearchUppOrderdate().sendKeys(Keys.ENTER);

		u.Searchbutton().click();

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(distdatecount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(distdatecount, appcount);
		}
	}

	public void UppNumberCombinationwithDate() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		u.clearbutton().click();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		Random r = new Random();

		String upp_no = xl.HSSFgetCellDataByColName("Sheet 1", "upp_no", r.nextInt(rowcount));
		System.out.println("Dist ID Number----" + upp_no);

		String OrderDate = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_date", r.nextInt(rowcount - 27));
		LocalDateTime originalformat = LocalDateTime.parse(OrderDate,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String uppOrderDate = originalformat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("Order Date---" + uppOrderDate);

		int Uppdatecount = 0;
		for (int i = 0; i <= rowcount - 27; i++) {
			String Exceluppno = xl.HSSFgetCellDataByColName("Sheet 1", "upp_no", i);
			if (upp_no.equals(Exceluppno)) {
				String paydate = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_date", i).trim();
				LocalDateTime Payformat = LocalDateTime.parse(paydate,
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				String OrderUPPDate = Payformat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

				if (OrderUPPDate.equals(uppOrderDate.trim())) {
					Uppdatecount++;
				}
			}
		}

		u.SearchDistributorIDfield().sendKeys(upp_no);
		u.SearchUppOrderdate().sendKeys(uppOrderDate);
		u.SearchUppOrderdate().sendKeys(Keys.ENTER);

		u.Searchbutton().click();

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(Uppdatecount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(Uppdatecount, appcount);
		}
	}

	public void DatewithStatusCombinationSearch(int n, String selection) throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		u.clearbutton().click();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(n);
		u.Searchbutton().click();
		Thread.sleep(1000);

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		Random r = new Random();
		String OrderDate = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_date", r.nextInt(rowcount - 27));
		LocalDateTime originalformat = LocalDateTime.parse(OrderDate,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String uppOrderDate = originalformat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("Order Date---" + uppOrderDate);

		String Upppaystatus = selection;
		int successcount = 0;
		for (int i = 2; i <= rowcount - 27; i++) {
			String paydate = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_date", i);
			LocalDateTime oformat = LocalDateTime.parse(paydate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String payuppOrderDate = oformat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			if (uppOrderDate.equals(payuppOrderDate)) {
				String paystatus = xl.HSSFgetCellDataByColName("Sheet 1", "upp_pay_status", i).toLowerCase().trim();
				if (paystatus.equals(Upppaystatus.toLowerCase().trim())) {
					successcount++;
				}
			}
		}

		u.SearchUppOrderdate().sendKeys(uppOrderDate);
		u.SearchUppOrderdate().sendKeys(Keys.ENTER);
		u.Searchbutton().click();

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(successcount, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(successcount, appcount);
		}
	}

	public void DatewithSuccess() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.DatewithStatusCombinationSearch(1, "Success");
	}

	public void DatewithFailure() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.DatewithStatusCombinationSearch(2, "Failure");
	}

	public void DatewithAborted() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.DatewithStatusCombinationSearch(3, "Aborted");
	}

	public void DatewithInvalid() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.DatewithStatusCombinationSearch(4, "Invalid");
	}

	public void DatewithInitiated() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.DatewithStatusCombinationSearch(5, "Initiated");
	}

	public void DatewithTimeout() throws Exception {
		UppPaymentSearchFunctionalityPage search = new UppPaymentSearchFunctionalityPage();
		search.DatewithStatusCombinationSearch(6, "Timeout");
	}

	public void ExportSearch(String columnname, WebElement xpath) throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		u.clearbutton().click();
		Thread.sleep(1000);
		u.ExportExcelButton().click();
		Thread.sleep(1000);

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		Random r = new Random();
		String field = xl.HSSFgetCellDataByColName("Sheet 1", columnname, r.nextInt(rowcount));

		xpath.sendKeys(field);
		u.Searchbutton().click();

		Thread.sleep(1000);
		u.ExportExcelButton().click();
		Thread.sleep(10000);

		File file1 = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename1 = file1.getName();
		String filePath1 = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename1;
		XlApiTest x = new XlApiTest(filePath1);
		int rowcount1 = x.HFFSgetRowCount("Sheet 1");

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}

			int count = sum + totalrow;
			Assert.assertEquals(rowcount1 - 1, count);

		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(rowcount1 - 1, appcount);
		}
	}

	public void VerifyExportDistidSearch() throws Exception {
		UppPaymentSearchFunctionalityPage us = new UppPaymentSearchFunctionalityPage();
		uppPaymentPOM u = new uppPaymentPOM(driver);

		us.ExportSearch("upp_dist_id", u.SearchDistributorIDfield());
	}

	public void VerifyExportUppNoSearch() throws Exception {
		UppPaymentSearchFunctionalityPage us = new UppPaymentSearchFunctionalityPage();
		uppPaymentPOM u = new uppPaymentPOM(driver);

		us.ExportSearch("upp_no", u.SearchUppNo());
	}

	public void VerifyExportUppOrderIDSearch() throws Exception {
		UppPaymentSearchFunctionalityPage us = new UppPaymentSearchFunctionalityPage();
		uppPaymentPOM u = new uppPaymentPOM(driver);

		us.ExportSearch("upp_pay_order_id", u.SearchUppOrderID());
	}

	public void EportStatusSearch(int n) throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		u.clearbutton().click();
		Thread.sleep(1000);
		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(n);
		u.Searchbutton().click();

		Thread.sleep(1000);
		u.ExportExcelButton().click();
		Thread.sleep(10000);

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest x = new XlApiTest(filePath);
		int rowcount = x.HFFSgetRowCount("Sheet 1");

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(rowcount - 1, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(rowcount - 1, appcount);
		}
	}

	public void ExportSuccessStatusSearch() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.EportStatusSearch(1);
	}

	public void ExportFailureStatusSearch() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.EportStatusSearch(2);
	}

	public void ExportAbortedStatusSearch() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.EportStatusSearch(3);
	}

	public void ExportInvalidStatusSearch() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.EportStatusSearch(4);
	}

	public void ExportInitiatedStatusSearch() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.EportStatusSearch(5);
	}

	public void ExportTimeoutStatusSearch() throws Exception {
		UppPaymentSearchFunctionalityPage upp = new UppPaymentSearchFunctionalityPage();
		upp.EportStatusSearch(6);
	}

	public void EportOrderSheetUpload() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		u.clearbutton().click();
		u.SearchOrderSheetUploadCheckbox().click();
		u.Searchbutton().click();

		Thread.sleep(1000);
		u.ExportExcelButton().click();
		Thread.sleep(1000);

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);
		int rowcount = xl.HFFSgetRowCount("Sheet 1");

		if (ut.NumberofPagination().size() > 0) {
			int length = ut.NumberofPagination().size();
			ArrayList<Integer> array = new ArrayList<Integer>();
			int totalrow = ut.TotalNumberofRow().size();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			for (int i = 3; i < length; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();

				array.add(totalrow);
				totalrow = ut.TotalNumberofRow().size();
			}

			int sum = 0;
			for (int j = 0; j < array.size(); j++) {
				sum += array.get(j);
			}
			Assert.assertEquals(rowcount - 1, sum + totalrow);
		} else {
			int appcount = ut.TotalUppNofields().size();
			Assert.assertEquals(rowcount - 1, appcount);
		}
	}

}
