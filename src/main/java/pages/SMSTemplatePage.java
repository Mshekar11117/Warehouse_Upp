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
import POM.SMSTemplatePOM;
import POM.TablesPOM;
import POM.UserspagePOM;
import base.SuperTestNG;
import utilities.Excel;

public class SMSTemplatePage extends SuperTestNG {

	public void AccessingSMSTemplatePage() {
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Smstemplate().click();
		String url = driver.getCurrentUrl();
		if (url.contains("test")) {
			Assert.assertEquals(prop.getProperty("smstemplateURL"), driver.getCurrentUrl());
		} else {
			Assert.assertEquals(prop.getProperty("LIVEsmstemplateURL"), driver.getCurrentUrl());
		}

		String SMStext = T.PageTitleText().getText();
		Assert.assertEquals(prop.getProperty("SMSTemplates"), SMStext);
		Assert.assertTrue(T.table().isDisplayed());
	}

	public void VerifyTableTitles() {
		TablesPOM T = new TablesPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		int menucount = H.leftsidemenus().size();
		int length = T.Titleslength().size();

		if (menucount == Integer.parseInt(prop.getProperty("Superadminmenucount"))
				|| menucount == Integer.parseInt(prop.getProperty("AdminMenucount"))) {
			String SMSid = T.FirstTitleofTable().getText();
			String SMSTitle = T.SecondTitleofTable().getText();
			String SMSTemplate = T.ThirdTitleofTable().getText();
			String Status = T.FourthTItleofTable().getText();
			String Actions = T.FifthTitleofTable().getText();
			Assert.assertEquals(5, length);
			Assert.assertEquals(prop.getProperty("SMSId"), SMSid);
			Assert.assertEquals(prop.getProperty("SMSTitle"), SMSTitle);
			Assert.assertEquals(prop.getProperty("SMSTemplate"), SMSTemplate);
			Assert.assertEquals(prop.getProperty("SMSTemplateStatus"), Status);
			Assert.assertEquals(prop.getProperty("Actions"), Actions);
		} else {
			String SMSid = T.FirstTitleofTable().getText();
			String SMSTitle = T.SecondTitleofTable().getText();
			String SMSTemplate = T.ThirdTitleofTable().getText();
			String Status = T.FourthTItleofTable().getText();
			Assert.assertEquals(4, length);
			Assert.assertEquals(prop.getProperty("SMSId"), SMSid);
			Assert.assertEquals(prop.getProperty("SMSTitle"), SMSTitle);
			Assert.assertEquals(prop.getProperty("SMSTemplate"), SMSTemplate);
			Assert.assertEquals(prop.getProperty("SMSTemplateStatus"), Status);
		}

	}

	public void VerifyTableActions() {
		SMSTemplatePOM S = new SMSTemplatePOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		Assert.assertTrue(driver.findElements(By.cssSelector("a.btn.btn-success")).size() == 0);
		Assert.assertTrue(S.allDeletButtons().size() == 0);
		Assert.assertTrue(S.allupdatebuttons().size() == 0);
		H.WarehouseOrdermenu().click();
	}

	public void NumberofSMSTemplates() {
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

		Assert.assertEquals(rcount, Integer.parseInt(prop.getProperty("TemplatedCount")));
	}

	public void printandverifySMSTemplatesNames() {
		PaginationPOM P = new PaginationPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Smstemplate().click();

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String SMSnames = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText();
			names.add(SMSnames);
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

		int rowcount = Excel.getRowCount(xlPath, sheetname6);
		for (int k = 0; k <= rowcount; k++) {
			String Rolnames = Excel.getCellValue(xlPath, sheetname6, k, 1);
			if (names.contains(Rolnames)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false, "Missing SMS Title name---" + Rolnames);
			}
		}

	}

	public void printandverifySMSTemplateDesc() {
		PaginationPOM P = new PaginationPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Smstemplate().click();

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String SMSnames = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText().toLowerCase();
			names.add(SMSnames);
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
					names.add(rnames);
				}
			}
		}
		
		ArrayList<String> rolesname = new ArrayList<String>();
		int rowcount = Excel.getRowCount(xlPath, sheetname6);
		for (int k = 0; k <= rowcount; k++) {
			String Rolnamesdesc = Excel.getCellValue(xlPath, sheetname6, k, 2).toLowerCase();
			rolesname.add(Rolnamesdesc);
			
			if (names.contains(Rolnamesdesc)) {
				Assert.assertTrue(true);
			} else {
				
				Assert.assertTrue(false, "Missing SMS Title Descriptions---" + Rolnamesdesc);
			}
		}

	}

	public void printandverifySMSTemplateStatus() {
		TablesPOM T = new TablesPOM(driver);

		int C = T.tablerows().size();

		for (int i = 0; i < C; i++) {

			String status = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[4]")).getText();
			if (status.equalsIgnoreCase(prop.getProperty("Active"))) {
				Assert.assertTrue(true);
			} else {
				String SMSname = driver.findElement(By.xpath("//tbody/tr[" + (i + 1) + "]/td[2]")).getText();
				System.out.println("SMS name---" + SMSname + "--is inactive");
			}
		}
	}

	public void VerifyErrorMessages() {
		SMSTemplatePOM S = new SMSTemplatePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		T.Createbutton().click();
		S.Savebutton().click();

		Assert.assertTrue(S.ErrorMessages().isDisplayed());
		Assert.assertTrue(S.ErrorMessageSMSTemplateFieldRequired().isDisplayed());
		Assert.assertTrue(S.ErrorMessageSMSTitleFieldRequired().isDisplayed());

		S.Cancelbutton().click();
	}

	public void CreateSMSTemplate() {
		SMSTemplatePOM S = new SMSTemplatePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		T.Createbutton().click();

		String SMSTemplateheading = S.Createpageheadingtext().getText();
		Assert.assertEquals(prop.getProperty("CreateSMSTitle"), SMSTemplateheading);

		String SMSTitlelabel = S.LabelSMSTitle().getText();
		Assert.assertEquals(prop.getProperty("CreateSMSName"), SMSTitlelabel);

		String SMSTemplate = S.LabelSMSTemplates().getText();
		Assert.assertEquals(prop.getProperty("CreateSMSTemplate"), SMSTemplate);

		String SMSStatus = S.LabelSMSStatus().getText();
		Assert.assertEquals(prop.getProperty("CreateStatus"), SMSStatus);

		S.Cancelbutton().click();
		T.Createbutton().click();

		String Title = "Title--------" + genData.generateRandomString(10);
		String Template = prop.getProperty("SMSTextArea");

		S.SMStitleField().sendKeys(Title);
		S.SMSTemplateField().sendKeys(Template);

		Select select = new Select(S.SMSStatusField());
		select.selectByIndex(0);

		S.Savebutton().click();

		String EnteredTitle = T.LastRecordName().getText();
		String EnteredTemplate = T.LastRecordEmailidORDesc().getText();
		Assert.assertEquals(Title, EnteredTitle);
		Assert.assertEquals(Template, EnteredTemplate);

	}

	public void updateSMSTemplates() {
		SMSTemplatePOM S = new SMSTemplatePOM(driver);
		TablesPOM T = new TablesPOM(driver);
		UserspagePOM U = new UserspagePOM(driver);

		int count = T.tablerows().size();
		Assert.assertEquals(count, 15);

		U.Updatelastbutton().click();

		S.SMStitleField().clear();
		S.SMSTemplateField().clear();

		S.SaveORUpdateButton().click();

		Assert.assertTrue(S.ErrorMessages().isDisplayed());
		Assert.assertTrue(S.ErrorMessageSMSTitleFieldRequired().isDisplayed());
		Assert.assertTrue(S.ErrorMessageSMSTemplateFieldRequired().isDisplayed());

		String Title = "UpdatedTitle-----" + genData.generateRandomString(20);
		String Template = prop.getProperty("SMSTextArea");

		S.Cancelbutton().click();
		U.Updatelastbutton().click();

		S.SMStitleField().clear();
		S.SMSTemplateField().clear();
		S.SMStitleField().sendKeys(Title);
		S.SMSTemplateField().sendKeys(Template);
		Select select = new Select(S.SMSStatusField());
		select.selectByIndex(1);

		S.SaveORUpdateButton().click();

		String EnteredTitle = T.LastRecordName().getText();
		String EnteredTemplate = T.LastRecordEmailidORDesc().getText();
		String Status = T.LastRecordSMSTemplateStatus().getText();

		Assert.assertEquals(Title, EnteredTitle);
		Assert.assertEquals(Template, EnteredTemplate);
		Assert.assertEquals(Status, "InActive");
	}

	public void DeleteSMSTemplate() {
		ModalPOM M = new ModalPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);

		int count = T.tablerows().size();
		int rowcountbeforeOK = count - 1;
		T.LastDeleteButton().click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(M.DeleteModal()));

		if (M.DeleteModal().isDisplayed()) {
			Assert.assertTrue(M.DeleteModalTitle().isDisplayed());
			Assert.assertTrue(M.DeleteCancelbutton().isDisplayed());
			M.OKbutton().click();
		} else {
			System.out.println("Delete Modal is not displayed");
		}
		int rowcountAfterOK = T.tablerows().size();
		Assert.assertEquals(rowcountbeforeOK, rowcountAfterOK);

		H.WarehouseOrdermenu().click();
	}

}
