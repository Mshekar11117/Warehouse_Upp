package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.ModalPOM;
import POM.PaginationPOM;
import POM.PermissionsPOM;
import POM.TablesPOM;
import base.SuperTestNG;
import utilities.Excel;

public class Permissionpage extends SuperTestNG {

	public void AccessingPermissionPage() {
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Permission().click();
		String cururl = driver.getCurrentUrl();
		if (cururl.contains("test")) {
			Assert.assertEquals(prop.getProperty("permissionsURL"), driver.getCurrentUrl());
		} else {
			Assert.assertEquals(prop.getProperty("LIVEpermissionsURL"), driver.getCurrentUrl());
		}
		String ptext = T.PageTitleText().getText();
		Assert.assertEquals(prop.getProperty("permissiontext"), ptext);
		Assert.assertTrue(T.table().isDisplayed());
	}

	public void VerifyTableTitles() {
		TablesPOM T = new TablesPOM(driver);

		int length = T.Titleslength().size();
		Assert.assertEquals(4, length);

		String permissionid = T.FirstTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("PermissionId"), permissionid);

		String permissionname = T.SecondTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("PermissionName"), permissionname);

		String permissiondescription = T.ThirdTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("PermissionDescription"), permissiondescription);

		String actions = T.FourthTItleofTable().getText();
		Assert.assertEquals(prop.getProperty("Actions"), actions);

	}

	public void NumberofPermissions() {
		PaginationPOM P = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		int rcount = T.tablerows().size();

		while (P.numberpagination().size() > 0) {
			if (P.nextpage().size() > 0) {
				P.nextarrow().click();
				rcount += T.tablerows().size();
			} else {
				break;
			}
		}

		Assert.assertEquals(rcount, Integer.parseInt(prop.getProperty("permissioncounts")));
	}

	public void printandverifypermissionnames() {
		PaginationPOM P = new PaginationPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Permission().click();

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String Permissionname = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().toLowerCase();
			names.add(Permissionname);
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
					String rnames = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]")).getText().toLowerCase();
					names.add(rnames);
				}
			}
		}

//		ArrayList<String> Exceldata = new ArrayList<String>();
		int rowcount = Excel.getRowCount(xlPath, sheetname2);

		for (int k = 0; k <= rowcount; k++) {
			String Rolnames = Excel.getCellValue(xlPath, sheetname2, k, 1);
//			Exceldata.add(Rolnames);
			if (names.contains(Rolnames.toLowerCase())) {
				Assert.assertTrue(true);
			} else {
				System.out.println(names);
				System.out.println(Rolnames);
				Assert.assertTrue(false, "Missing persmiision name---" + names);
			}
		}

	}

	public void printandverifypermissiondescription() {
		PaginationPOM P = new PaginationPOM(driver);
		HomepagePOM h = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		h.Permission().click();

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> descnames = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String Permissionname = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText().toLowerCase();
			descnames.add(Permissionname);
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
					String rnames = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[3]")).getText().toLowerCase();
					descnames.add(rnames);
				}
			}
		}

//		int rowcount = Excel.getRowCount(xlPath, sheetname2);
		for (int k = 0; k <= C; k++) {
			String Rolnames = Excel.getCellValue(xlPath, sheetname2, k, 2).toLowerCase();
			if (descnames.contains(Rolnames)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false, "Following permissions---" + Rolnames);
			}
		}

	}

	public void createpermission() {
		PermissionsPOM P = new PermissionsPOM(driver);
		PaginationPOM pe = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		T.Createbutton().click();
		String Createpermission = T.PageTitleText().getText();
		Assert.assertEquals(prop.getProperty("CreatePermissionAccess"), Createpermission);

		String permissionnametitle = P.CreatepermissionnameLabel().getText();
		Assert.assertEquals(prop.getProperty("pername"), permissionnametitle);

		String createpermissiondesc = P.CreatePermissionDesclabel().getText();
		Assert.assertEquals(prop.getProperty("perdesc"), createpermissiondesc);

		String name = genData.generateRandomString(10);
		String desc = genData.generateRandomString(30);
		P.Createpermissiondesc().sendKeys(desc);

		P.Cancelbutton().click();

		T.Createbutton().click();
		P.Createpermissionname().sendKeys(name);
		P.Createpermissiondesc().sendKeys(desc);
		P.Savebutton().click();

		if (pe.paginationlinks().size() > 0) {
			pe.nextarrow().click();
			String addedname = T.LastRecordName().getText();
			Assert.assertEquals(addedname, name);
			String addeddesc = T.LastRecordEmailidORDesc().getText();
			Assert.assertEquals(addeddesc, desc);

		} else {
			String addedname = T.LastRecordName().getText();
			Assert.assertEquals(addedname, name);
			String addeddesc = T.LastRecordEmailidORDesc().getText();
			Assert.assertEquals(addeddesc, desc);
		}

	}

	public void updatepermission() {
		PermissionsPOM P = new PermissionsPOM(driver);
		PaginationPOM pe = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		if (pe.paginationlinks().size() > 0) {
			pe.nextarrow().click();
			P.LastRecordUpdateButton().click();
			P.UpdateCancelButton().click();
			if (pe.paginationlinks().size() > 0) {
				pe.nextarrow().click();
				P.LastRecordUpdateButton().click();

				String name = genData.generateRandomString(20);
				String desc = genData.generateRandomString(30);

				P.Createpermissionname().clear();
				P.Createpermissionname().sendKeys(name);

				P.Createpermissiondesc().clear();
				P.Createpermissiondesc().sendKeys(desc);

				P.updatebutton().click();

				if (pe.paginationlinks().size() > 0) {
					pe.nextarrow().click();
					String addedname = T.LastRecordName().getText();
					Assert.assertEquals(addedname, name);
					String addeddesc = T.LastRecordEmailidORDesc().getText();
					Assert.assertEquals(addeddesc, desc);
				}
			}
		}
	}

	public void Deletepermission() {
		PermissionsPOM P = new PermissionsPOM(driver);
		ModalPOM M = new ModalPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		String Deletingname = T.LastRecordName().getText();
		System.out.println("Name of the Deleting permission---" + Deletingname);

		String name = T.LastRecordName().getText();
		P.LastRecordDeleteButton().click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(M.DeleteModal()));

		if (M.DeleteModal().isDisplayed()) {
			Assert.assertTrue(M.DeleteModalTitle().isDisplayed());
			Assert.assertTrue(M.DeleteCancelbutton().isDisplayed());
			M.OKbutton().click();
		}

		String text = "This permission(" + name + ") has been deleted successfully!";
		String deletemsg = M.PermissionDeleteSuccessMessage().getText();
		Assert.assertEquals(text, deletemsg);

	}

}
