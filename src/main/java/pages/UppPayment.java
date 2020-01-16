package pages;

import java.io.File;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.uppPaymentPOM;
import POM.uppPaymentTablePOM;
import base.SuperTestNG;
import utilities.XlApiTest;

public class UppPayment extends SuperTestNG {

	public void AccessUppPaymentPage() {
		HomepagePOM h = new HomepagePOM(driver);

		h.UppPayment().click();
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("upppaymentsurl"), currenturl);
	}

	public void VerifyTitles() {
		uppPaymentPOM u = new uppPaymentPOM(driver);

		String pagetitle = u.uppPaymentTitle().getText();
		Assert.assertEquals(prop.getProperty("upppaymentPageTitle"), pagetitle);

		String Distid = u.labelDistributorID().getText();
		Assert.assertEquals(prop.getProperty("labelDistributorID"), Distid);

		String UppNo = u.labelUppNo().getText();
		Assert.assertEquals(prop.getProperty("labelUPPNumber"), UppNo);

		String UpporderId = u.labelUppOrderID().getText();
		Assert.assertEquals(prop.getProperty("labelUPPOrderID"), UpporderId);

		String UPPOrderStatus = u.labelUppOrderStatus().getText();
		Assert.assertEquals(prop.getProperty("labelUPPOrderStatus"), UPPOrderStatus);

		String UppOrderdate = u.labelUPPOrderdate().getText();
		Assert.assertEquals(prop.getProperty("labelUPPOrderdate"), UppOrderdate);

		String OrdeSheetUpload = u.labelOrderSheetUpload().getText();
		Assert.assertEquals(prop.getProperty("labelOrderSheetUpload"), OrdeSheetUpload);
	}

	public void UppPaymentExportexcel() throws Exception {
		uppPaymentPOM u = new uppPaymentPOM(driver);
		u.ExportExcelButton().click();

	}

	public void VerifyNoOfTransaction() throws Exception {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		ExportExcel ex = new ExportExcel();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);

		int length = ut.NumberofPagination().size();
		ArrayList<Integer> array = new ArrayList<>();
		int totalrow = ut.TotalNumberofRow().size();
//		push the row numbers in to array using ArrayList		
		for (int i = 3; i < length; i++) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
			wait.until(ExpectedConditions.elementToBeClickable(page));
			page.click();
//			Adding row count from 1st page to last but one page
			array.add(totalrow);
			totalrow = ut.TotalNumberofRow().size();
		}
//		 find the sum of values in Array list while asseting enter the sum of array and last page row count
		int sum = 0;
		for (int j = 0; j < array.size(); j++) {
			sum += array.get(j);

		}

		ex.getLatestFilefromDir(Exceldownloadpath);
		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();

		int Excelcount = ex.getRecordsCountInExcel(Exceldownloadpath, ExcelFilename);
		Assert.assertEquals(sum + totalrow, Excelcount);

	}

	public void printandVerifycolumnnames() throws Exception {
		ExportExcel ex = new ExportExcel();

		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String ExcelFilename = file.getName();
		String filePath = Exceldownloadpath + System.getProperty("file.separator") + ExcelFilename;
		XlApiTest xl = new XlApiTest(filePath);

		String[] colname = { "upp_name", "upp_no", "upp_dist_id", "upp_amount", "upp_dist_phone", "upp_dist_email",
				"upp_pay_order_id", "upp_pay_status", "upp_pay_date", "upp_pay_modified_date" };

		for (int i = 0; i < colname.length; i++) {
			String columnname = xl.HSSFgetCellDataByColNum("Sheet 1", i, 0);
			if (columnname.contains(colname[i])) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(true, columnname + "----Missing");
			}

		}

	}

	public void TableCoulumnCount() {
		uppPaymentTablePOM up = new uppPaymentTablePOM(driver);

		int columncount = up.TotalNumberofColumn().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("columncount")), columncount);
	}

	public void columnnames() {
		String[] colname = { "Distributor ID", "UPP Number", "UPP Name", "Phone", "UPP Order ID", "UPP Order Amount",
				"UPP Order Status", "UPP Order Date", "Action" };

		for (int i = 1; i <= colname.length; i++) {
			String columnname = driver.findElement(By.xpath("//tr[@class='bg-info']/th[" + i + "]")).getText();
			
			if (columnname.contains(colname[i-1])) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(true, columnname + "---is Missing");
			}
		}

	}

}
