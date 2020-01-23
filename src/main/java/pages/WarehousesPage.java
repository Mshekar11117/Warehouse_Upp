package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.ModalPOM;
import POM.PaginationPOM;
import POM.TablesPOM;
import POM.UserspagePOM;
import POM.WarehousesPOM;
import base.SuperTestNG;
import utilities.Excel;

public class WarehousesPage extends SuperTestNG {

	public void AccessingWarehousePage() {
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Warehousenames().click();
		Assert.assertEquals(prop.getProperty("warehousenameURL"), driver.getCurrentUrl());

		String rtext = T.PageTitleText().getText();
		Assert.assertEquals(prop.getProperty("Warehouses"), rtext);
		Assert.assertTrue(T.table().isDisplayed());
	}

	public void VerifyTableTitles() {
		TablesPOM T = new TablesPOM(driver);

		int length = T.Titleslength().size();
		Assert.assertEquals(4, length);

		String warehousenumber = T.FirstTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("WarehouseNo"), warehousenumber);

		String Warehousename = T.SecondTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("WarehouseName"), Warehousename);

		String Country = T.ThirdTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("Country"), Country);

		String actions = T.FourthTItleofTable().getText();
		Assert.assertEquals(prop.getProperty("Actions"), actions);

	}

	public void NumberofWarehouses() {
		PaginationPOM P = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		int rcount = T.tablerows().size();
		int pagination = P.numberpagination().size();
		
		if (pagination > 0) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);

			for (int i = 3; i < pagination; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();
				rcount += T.tablerows().size();
			}
		}

	/*	while (P.numberpagination().size() > 0) {
			if (P.nextpage().size() > 0) {
				P.nextarrow().click();
				rcount += T.tablerows().size();
			} else {
				break;
			}
		}*/

		Assert.assertEquals(rcount, Integer.parseInt(prop.getProperty("WarehousesCount")));
	}

	public void printandverifyWHnames() {
		PaginationPOM P = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		H.Warehousenames().click();

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String whnames = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText();
			names.add(whnames);
		}

		if (pagination > 0) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);

			for (int i = 3; i < pagination; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();
				int rows = T.tablerows().size();
				for (int j = 1; j <= rows; j++) {
					String rnames = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]")).getText();
					names.add(rnames);
				}
			}
		}

		ArrayList<String> Exceldata = new ArrayList<String>();
		int rowcount = Excel.getRowCount(xlPath, sheetname4);

		for (int k = 0; k <= rowcount; k++) {
			String Rolnames = Excel.getCellValue(xlPath, sheetname4, k, 1);
			Exceldata.add(Rolnames);
		}

		if (names.equals(Exceldata)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Missing Warehouse name---" + names);
		}

	}

	public void printandverifyCountries() {
		PaginationPOM P = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		H.Warehousenames().click();

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String whdescnames = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText();
			names.add(whdescnames);
		}

		if (pagination > 0) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);

			for (int i = 3; i < pagination; i++) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + i + "]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(page));
				page.click();
				int rows = T.tablerows().size();
				for (int j = 1; j <= rows; j++) {
					String rnames = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[3]")).getText();
					names.add(rnames);
				}
			}
		}

		ArrayList<String> Exceldata = new ArrayList<String>();
		int rowcount = Excel.getRowCount(xlPath, sheetname4);

		for (int k = 0; k <= rowcount; k++) {
			String Rolnames = Excel.getCellValue(xlPath, sheetname4, k, 2);
			Exceldata.add(Rolnames);
		}

		if (names.equals(Exceldata)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Missing Warehouse Description name---" + names);
		}

	}

	public void VerifyErrorMessages() throws Exception {
		WarehousesPOM W = new WarehousesPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		T.Createbutton().click();
		Thread.sleep(1000);
		W.Savebutton().click();

		Assert.assertTrue(W.ErrorMessages().isDisplayed());
		Assert.assertTrue(W.ErrorMessageNameRequired().isDisplayed());
		Assert.assertTrue(W.ErrorMessageCountryCodeRequired().isDisplayed());
	}

	public void NumberofWhNames() {
		WarehousesPOM W = new WarehousesPOM(driver);

		driver.navigate().refresh();

		int count = W.SelectWhOptions().size();
		Assert.assertEquals(2, count);
	}

	public void CreateWarehouses() {
		WarehousesPOM W = new WarehousesPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		String CreateWh = W.WarehousePageHeading().getText();
		Assert.assertEquals(prop.getProperty("CreatePanelHeading"), CreateWh);

		String WHnametitle = W.WarehouseNameLabel().getText();
		Assert.assertEquals(prop.getProperty("WarehouseNamelable"), WHnametitle);

//		Developer needs to fix this issue
		/*
		 * String WHCountryCode = W.WHCountryCodeLable().getText();
		 * Assert.assertEquals(prop.getProperty("WarehouesCountry"), WHCountryCode);
		 */

		W.Cancelbutton().click();
		T.Createbutton().click();

		String name = genData.generateRandomString(10);
		W.WHnamefield().sendKeys(name);
		Select select = new Select(W.SelectWarehouses());
		select.selectByIndex(1);
		W.Savebutton().click();

		String enteredname = T.LastRecordName().getText();
		Assert.assertEquals(name, enteredname);

		String enteredCountry = T.LastRecordEmailidORDesc().getText();
		Assert.assertEquals(enteredCountry, prop.getProperty("countryIndia"));
	}

	public void updateWarehouses() {
		WarehousesPOM W = new WarehousesPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		UserspagePOM U = new UserspagePOM(driver);

		int count = T.tablerows().size();
		Assert.assertEquals(count, 7);

		U.Updatelastbutton().click();
		W.UpdateCancelButton().click();
		U.Updatelastbutton().click();

		W.WHnamefield().clear();
		String name = genData.generateRandomString(15);
		W.WHnamefield().sendKeys(name);

		W.updatebutton().click();
		String enteredname = T.LastRecordName().getText();
		Assert.assertEquals(name, enteredname);
	}

	public void DeleteWarehouses() {
		ModalPOM M = new ModalPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		String name = T.LastRecordName().getText();
		System.out.println("Name of the Deleting role---" + name);
		T.LastDeleteButton().click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(M.DeleteModal()));

		if (M.DeleteModal().isDisplayed()) {
			Assert.assertTrue(M.DeleteModalTitle().isDisplayed());
			Assert.assertTrue(M.DeleteCancelbutton().isDisplayed());
			M.OKbutton().click();
		}

		String text = "Warehouse(" + name + ") has been deleted successfully!";
		String deletemsg = M.PermissionDeleteSuccessMessage().getText();
		Assert.assertEquals(text, deletemsg);
	}

}
