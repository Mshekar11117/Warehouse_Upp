package pages;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.ModalPOM;
import POM.PaginationPOM;
import POM.RolesPOM;
import POM.TablesPOM;
import POM.UserspagePOM;
import base.SuperTestNG;
import utilities.Excel;

public class Rolespage extends SuperTestNG {

	public void AccessingRolesPage() {
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Rolesmenu().click();
		Assert.assertEquals(prop.getProperty("rolesURL"), driver.getCurrentUrl());

		String rtext = T.PageTitleText().getText();
		Assert.assertEquals(prop.getProperty("Roles"), rtext);
		Assert.assertTrue(T.table().isDisplayed());
	}

	public void VerifyTableTitles() {
		TablesPOM T = new TablesPOM(driver);

		int length = T.Titleslength().size();
		Assert.assertEquals(4, length);

		String rolesid = T.FirstTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("RoleId"), rolesid);

		String rolesname = T.SecondTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("RoleName"), rolesname);

		String rolesdesc = T.ThirdTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("RoleDescription"), rolesdesc);

		String actions = T.FourthTItleofTable().getText();
		Assert.assertEquals(prop.getProperty("Actions"), actions);

	}

	public void NumberofRoles() {
		PaginationPOM P = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		String user = H.userprofilename().getText();
		System.out.println("User profile name---" + user);
		int rcount = T.tablerows().size();

		while (P.numberpagination().size() > 0) {
			if (P.nextpage().size() > 0) {
				P.nextarrow().click();
				rcount += T.tablerows().size();
			} else {
				break;
			}
		}
		if (user.equals(prop.getProperty("superAdmin"))) {
			Assert.assertEquals(rcount, Integer.parseInt(prop.getProperty("Rolescounts")));
		} else {
			Assert.assertEquals(rcount, Integer.parseInt(prop.getProperty("AdminRolescounts")));
		}

	}

	public void printandverifyRolenames() {
		PaginationPOM P = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String Rolename = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText();
			names.add(Rolename);
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
				for (int j = 1; j < rows; j++) {
					String rnames = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]")).getText();
					names.add(rnames);
				}
			}
		}

		String user = H.userprofilename().getText().trim();
//		String profile = H.profilename().getText().trim();
		ArrayList<String> Exceldata = new ArrayList<String>();
		if (user.equals(prop.getProperty("admin"))) {
			int rowcount = Excel.getRowCount(xlPath, sheetname3);
			for (int k = 1; k <= rowcount; k++) {
				String Rolnames = Excel.getCellValue(xlPath, sheetname3, k, 1);
				Exceldata.add(Rolnames);
			}
		} else {
			int rowcount = Excel.getRowCount(xlPath, sheetname3);
			for (int k = 0; k <= rowcount; k++) {
				String Rolnames = Excel.getCellValue(xlPath, sheetname3, k, 1);
				Exceldata.add(Rolnames);
			}
		}

		if (names.equals(Exceldata)) {
			Assert.assertTrue(true);
		} else {
			System.out.println("Following permission name is missing---" + Exceldata);
			Assert.assertTrue(false);
		}
	}

	public void printandverifyRolesdescription() {
		PaginationPOM P = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> desc = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String descnames = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText();
			desc.add(descnames);
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
				for (int j = 1; j < rows; j++) {
					String descriptionnames = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]")).getText();
					desc.add(descriptionnames);
				}
			}
		}
		
		String user = H.userprofilename().getText().trim();
		ArrayList<String> Exceldata = new ArrayList<String>();
		if(user.equals(prop.getProperty("admin"))) {
			int rowcount = Excel.getRowCount(xlPath, sheetname3);
			for (int k = 1; k <= rowcount; k++) {
				String Roledesc = Excel.getCellValue(xlPath, sheetname3, k, 2);
				Exceldata.add(Roledesc);
			}
		} else {
			int rowcount = Excel.getRowCount(xlPath, sheetname3);
			for (int k = 0; k <= rowcount; k++) {
				String Roledesc = Excel.getCellValue(xlPath, sheetname3, k, 2);
				Exceldata.add(Roledesc);
			}
		}

		if (desc.equals(Exceldata)) {
			Assert.assertTrue(true);
		} else {
			System.out.println("Following permission Description is missing---" + Exceldata);
			Assert.assertTrue(false);
		}

	}

	public void VerifyErrorMessages() {
		RolesPOM R = new RolesPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		T.Createbutton().click();
		R.Savebutton().click();

		Assert.assertTrue(R.ErrorMessages().isDisplayed());
		Assert.assertTrue(R.ErrorMessageNameRequired().isDisplayed());
		Assert.assertTrue(R.ErrorMessageDesciptionRequired().isDisplayed());
		Assert.assertTrue(R.ErrorMessageAssigedRequired().isDisplayed());

		R.AssignButton().click();
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		System.out.println("alert text----" + alerttext);
		alert.accept();

		driver.navigate().refresh();
	}

	public void verifythePermissionsinRolesPage() throws Exception {
		RolesPOM R = new RolesPOM(driver);

		int Notassigned = R.NotAssignedpermissionOptions().size();
		Assert.assertEquals(Notassigned, Integer.parseInt(prop.getProperty("permissioncounts")));

		int Assigned = R.AssignedPermissionsOptions().size();
		Assert.assertEquals(Assigned, 0);

		R.Notassignedsection().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		R.AssignButton().click();

		int Assigned2 = R.AssignedPermissionsOptions().size();
		Assert.assertEquals(Assigned2, Integer.parseInt(prop.getProperty("permissioncounts")));

		R.AssignedPermissions().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		R.NotAssignButton().click();

		int Notassigned2 = R.NotAssignedpermissionOptions().size();
		Assert.assertEquals(Notassigned2, Integer.parseInt(prop.getProperty("permissioncounts")));

		driver.navigate().refresh();
	}

	public void CreateRoles() {
		RolesPOM R = new RolesPOM(driver);
		PaginationPOM pe = new PaginationPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		String CreateRoles = R.Rolespageheading().getText();
		Assert.assertEquals(prop.getProperty("CreateRolesPanelHeading"), CreateRoles);

		String Rolesnametitle = R.CreateRolesnameLabel().getText();
		Assert.assertEquals(prop.getProperty("CreateRolename"), Rolesnametitle);

		String Rolespermissiondesc = R.CreateRolesDesclabel().getText();
		Assert.assertEquals(prop.getProperty("CreateRoleDesc"), Rolespermissiondesc);

		String name = genData.generateRandomString(10);
		String desc = genData.generateRandomString(30);
		R.CreateRolesdesc().sendKeys(desc);

		R.Cancelbutton().click();

		T.Createbutton().click();
		R.CreateRolesname().sendKeys(name);
		R.CreateRolesdesc().sendKeys(desc);

		Random r = new Random();
		int Notassigned = R.NotAssignedpermissionOptions().size();
		WebElement options = R.NotAssignedpermissionOptions().get(r.nextInt(Notassigned));
		options.click();

		R.AssignButton().click();
		R.Savebutton().click();

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
		RolesPOM R = new RolesPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		UserspagePOM U = new UserspagePOM(driver);

		HomepagePOM H = new HomepagePOM(driver);
		int menucount = H.leftsidemenus().size();
		int count = T.tablerows().size();
		String user = H.userprofilename().getText();

		if (menucount == Integer.parseInt(prop.getProperty("Superadminmenucount"))
				&& user.equalsIgnoreCase(prop.getProperty("superAdmin"))) {
			Assert.assertEquals(count, 6);
		} else if (menucount == Integer.parseInt(prop.getProperty("AdminMenucount"))) {
			Assert.assertEquals(count, 5);
		}

		String name = genData.generateRandomString(20);
		String desc = genData.generateRandomString(35);

		U.Updatelastbutton().click();
		R.CreateRolesname().clear();
		R.CreateRolesname().sendKeys(name);

		R.CreateRolesdesc().clear();
		R.CreateRolesdesc().sendKeys(desc);

		R.FirstAssignedPermission().click();
		R.NotAssignButton().click();

		Random r = new Random();
		int Notassigned = R.NotAssignedpermissionOptions().size();
		WebElement options = R.NotAssignedpermissionOptions().get(r.nextInt(Notassigned));
		options.click();
		R.AssignButton().click();
		R.updatebutton().click();

		String addedname = T.LastRecordName().getText();
		Assert.assertEquals(addedname, name);
		String addeddesc = T.LastRecordEmailidORDesc().getText();
		Assert.assertEquals(addeddesc, desc);
	}

	public void Deletepermission() {
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

		String text = "This role(" + name + ") has been deleted successfully!";
		String deletemsg = M.PermissionDeleteSuccessMessage().getText();
		Assert.assertEquals(text, deletemsg);
	}

}
