package pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.PaymentGatewayCancelTransaction;
import POM.PaymentGatewayPOM;
import POM.PaymentGatewaySuccessPOM;
import POM.UppMakePaymentPOM;
import POM.ViewUppPaymentPOM;
import POM.uppPaymentPOM;
import POM.uppPaymentTablePOM;
import base.SuperTestNG;
import utilities.Excel;

public class UppMakePaymentPage extends SuperTestNG {

	public void AccessingMakePaymentPage() {
		HomepagePOM h = new HomepagePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);

		h.UppPayment().click();
		u.MakePaymentButton().click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		String url = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlMakePayment"), url);

	}

	public void VeifyTitles() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		String uppname = u.TitleUppName().getText();
		Assert.assertEquals(prop.getProperty("labelMakepaymentUPPName"), uppname);

		String uppno = u.TitleUppNumber().getText();
		Assert.assertEquals(prop.getProperty("labelmakepaymentUPPNo"), uppno);

		String Distid = u.TitleDistID().getText();
		Assert.assertEquals(prop.getProperty("labelmakepaymentDISTRIBUTORID"), Distid);

		String phoneno = u.TitleUppDistPhone().getText();
		Assert.assertEquals(prop.getProperty("labelmakepaymentphoneno"), phoneno);

		String Amount = u.TitleAmount().getText();
		Assert.assertEquals(prop.getProperty("labelmakepaymentAmount"), Amount);

		String Email = u.TitleEmailField().getText();
		Assert.assertEquals(prop.getProperty("labelmakepaymentemail"), Email);
	}

	public void VerifyFieldTexts() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		String uppname = u.HelpUppName().getText();
		Assert.assertEquals(prop.getProperty("makepaymentUppName"), uppname);

		String uppno = u.HelpUppNumber().getText();
		Assert.assertEquals(prop.getProperty("makepaymentUppNo"), uppno);

		String distid = u.HelpDistID().getText();
		Assert.assertEquals(prop.getProperty("makepaymentDistId"), distid);

		String Amount = u.HelpAmount().getText();
		Assert.assertEquals(prop.getProperty("makepaymentAmount"), Amount);

		String phone = u.HelpUppDistPhone().getText();
		Assert.assertEquals(prop.getProperty("makepaymentPhone"), phone);

		String email = u.HelpEmail().getText();
		Assert.assertEquals(prop.getProperty("makepaymentEmail"), email);

		String uploadtext = u.HelpUploadExcel().getText();
		Assert.assertEquals(prop.getProperty("makepaymentExcelUpload"), uploadtext);
	}

	public void UnicityLogoRefresh() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.UnicityLogo().click();

		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();

		String url = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("homepageurl"), url);
		driver.close();
		driver.switchTo().window(parent);
	}

	public void VerifyAllmenus() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);
		uppPaymentPOM up = new uppPaymentPOM(driver);
		HomepagePOM h = new HomepagePOM(driver);

		h.UppPayment().click();
		up.MakePaymentButton().click();

		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);

		Assert.assertTrue(u.AboutUS().isDisplayed());
		Assert.assertTrue(u.ContactUS().isDisplayed());
		Assert.assertTrue(u.PoliciesProcedures().isDisplayed());
		Assert.assertTrue(u.TermsandConditions().isDisplayed());
		Assert.assertTrue(u.UppPaymentmenu().isDisplayed());
	}

	public void Menuaboutus() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.AboutUS().click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		String child1 = it.next();
		driver.switchTo().window(child1);

		String url = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlAboutUs"), url);
		driver.close();
		driver.switchTo().window(child);
	}

	public void MenuContactUS() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.ContactUS().click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		String child1 = it.next();
		driver.switchTo().window(child1);

		String url = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlContactUs"), url);
		driver.close();
		driver.switchTo().window(child);
	}

	public void MenuTermsnAndConditions() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.TermsandConditions().click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		String child1 = it.next();
		driver.switchTo().window(child1);

		String url = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlTermsAndConditions"), url);
		driver.close();
		driver.switchTo().window(child);
	}

	public void MenuPoliciesAndProcedures() throws Exception {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);
		ExportExcel ex = new ExportExcel();

		u.PoliciesProcedures().click();
		Thread.sleep(1000);
		File file = ex.getLatestFilefromDir(Exceldownloadpath);
		String Filename = file.getName();
		System.out.println("File Name---" + Filename);
		if (Filename.contains(prop.getProperty("downloadedPDFFilenmae"))) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Downloaded PDF file name is not matching");
		}
		
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.close();
		driver.switchTo().window(parent);

		/*
		 * Set<String> id = driver.getWindowHandles(); Iterator<String> it =
		 * id.iterator(); String parent = it.next(); String child = it.next(); String
		 * child1 = it.next(); driver.switchTo().window(child1);
		 * 
		 * String url = driver.getCurrentUrl();
		 * Assert.assertEquals(prop.getProperty("urlPoliciesAndProcedures"), url);
		 * driver.close(); driver.switchTo().window(child);
		 */
	}

	public void MenuUppPayments() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);
		HomepagePOM h = new HomepagePOM(driver);
		uppPaymentPOM upp = new uppPaymentPOM(driver);
		
		h.UppPayment().click();
		upp.MakePaymentButton().click();
		
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
//		u.UppPaymentmenu().click();

		String url = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlMakePayment"), url);

	}

	public void TotalErrorCount() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.MakePaymentButton().click();
		int errorsize = u.TotalNumberofErrorMessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Errorcount")), errorsize);
	}

	public void InvalidUppNamefield() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		String fieldrequired = u.ErrorUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 2, 2), fieldrequired);

		u.UppNameField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 2, 0));
		u.MakePaymentButton().click();

		String special = u.ErrorUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 3, 2), special);

		u.UppNameField().clear();

		u.UppNameField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 3, 0));
		u.MakePaymentButton().click();

		String number = u.ErrorUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 3, 2), number);

		u.UppNameField().clear();
	}

	public void CombinationInvalidUppNamefield() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.UppNameField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 41, 0));
		u.MakePaymentButton().click();

		int errorcount = u.TotalNumberofErrorMessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Errorcount")) - 1, errorcount);

	}

	public void InvalidUppNumberfield() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		String fieldrequired = u.ErrorUppNumber().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 7, 2), fieldrequired);

		u.UppNumberField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 7, 0));
		u.MakePaymentButton().click();

		String special = u.ErrorUppNumber().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 8, 2), special);

		u.UppNumberField().clear();

	}

	public void CombinationInvalidUppNumberfield() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.UppNumberField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 40, 0));
		u.MakePaymentButton().click();

		int errorcount = u.TotalNumberofErrorMessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Errorcount")) - 2, errorcount);
	}

	public void InvalidDistIdfield() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		String fieldrequired = u.ErrorDistID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 12, 2), fieldrequired);

		u.DistributorID().sendKeys(Excel.getCellValue(xlPath, sheetname10, 7, 0));
		u.MakePaymentButton().click();

		String special = u.ErrorDistID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 13, 2), special);

		u.DistributorID().clear();

		u.DistributorID().sendKeys(Excel.getCellValue(xlPath, sheetname10, 13, 0));
		u.MakePaymentButton().click();
		String min = u.ErrorDistID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 14, 2), min);

		u.DistributorID().clear();

	}

	public void CombinationInvalidDistIDfield() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.DistributorID().sendKeys(Excel.getCellValue(xlPath, sheetname10, 42, 0));
		u.MakePaymentButton().click();

		int errorcount = u.TotalNumberofErrorMessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Errorcount")) - 3, errorcount);
	}

	public void InvalidAmountfield() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		String fieldrequired = u.ErrorAmount().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 2), fieldrequired);

		u.Amount().sendKeys(Excel.getCellValue(xlPath, sheetname10, 19, 0));
		u.MakePaymentButton().click();

		String special = u.ErrorAmount().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 20, 2), special);

		u.Amount().clear();

		u.Amount().sendKeys(Excel.getCellValue(xlPath, sheetname10, 20, 0));
		u.MakePaymentButton().click();

		String zero = u.ErrorAmount().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 21, 2), zero);

		u.Amount().clear();

		u.Amount().sendKeys(Excel.getCellValue(xlPath, sheetname10, 21, 0));
		u.MakePaymentButton().click();

		String Max = u.ErrorAmount().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 22, 2), Max);

		u.Amount().clear();
	}

	public void validAmountField() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.Amount().sendKeys(Excel.getCellValue(xlPath, sheetname10, 19, 1));
		u.MakePaymentButton().click();

		int errorcount = u.TotalNumberofErrorMessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Errorcount")) - 4, errorcount);
	}

	public void InvalidPhoneNumber() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		String fieldrequired = u.ErrorUppDistPhone().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 26, 2), fieldrequired);

		u.UppDistPhone().sendKeys(Excel.getCellValue(xlPath, sheetname10, 26, 0));
		u.MakePaymentButton().click();

		String min = u.ErrorUppDistPhone().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 28, 2), min);

		u.UppDistPhone().clear();

		u.UppDistPhone().sendKeys(Excel.getCellValue(xlPath, sheetname10, 27, 0));
		u.MakePaymentButton().click();

		String text = u.ErrorUppDistPhone().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 27, 2), text);

		u.UppDistPhone().clear();
	}

	public void Validphonenumber() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.UppDistPhone().sendKeys(Excel.getCellValue(xlPath, sheetname10, 26, 1));
		u.MakePaymentButton().click();

		int errorcount = u.TotalNumberofErrorMessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Errorcount")) - 5, errorcount);
	}

	public void InvalidEmail() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		String fieldrequired = u.ErrorEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 33, 2), fieldrequired);

		u.EmailField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 33, 0));
		u.MakePaymentButton().click();

		String invalid = u.ErrorEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 34, 2), invalid);

		u.EmailField().clear();

		u.EmailField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 34, 0));
		u.MakePaymentButton().click();

		String text = u.ErrorEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 34, 2), text);

		u.EmailField().clear();

		u.EmailField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 35, 0));
		u.MakePaymentButton().click();

		String invalidemail = u.ErrorEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 34, 2), invalidemail);

		u.EmailField().clear();
	}

	public void validemail() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);

		u.EmailField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 33, 1));
		u.MakePaymentButton().click();

		int errorcount = u.TotalNumberofErrorMessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("Errorcount")) - 6, errorcount);
	}

	public void combinationvalidation() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);
		
		WebElement error = u.erroralert();
		if (error.isDisplayed()) {
			String errormessage = error.getText();
			Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 40, 2), errormessage);
		}

		u.UppNameField().clear();
		u.UppNameField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 40, 1));
		u.MakePaymentButton().click();
		Assert.assertTrue(error.isDisplayed());

		u.UppNumberField().clear();
		u.UppNumberField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 41, 1));
		u.MakePaymentButton().click();
		Assert.assertTrue(error.isDisplayed());
		
		u.DistributorID().clear();
		u.DistributorID().sendKeys(Excel.getCellValue(xlPath, sheetname10, 42, 1));
		
		u.EmailField().clear();
		u.MakePaymentButton().click();
		Assert.assertFalse(u.erroralerts().size() > 0);
		
		u.Backbtn().click();
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("upppaymentsurl"), currenturl);
		
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.close();
		driver.switchTo().window(parent);
	
	}
	
	public void AbortTransaction() throws Exception {
		HomepagePOM h = new HomepagePOM(driver);
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);
		PaymentGatewayPOM p = new PaymentGatewayPOM(driver);
		PaymentGatewayCancelTransaction pc = new PaymentGatewayCancelTransaction(driver);
		uppPaymentPOM upp = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		
		h.UppPayment().click();
		upp.MakePaymentButton().click();
		
		Set<String> id1 = driver.getWindowHandles();
		Iterator<String> it1 = id1.iterator();
		String parent1 = it1.next();
		String child1 = it1.next();
		driver.switchTo().window(child1);
		
		u.UppNameField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 40, 1));
		u.UppNumberField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 41, 1));
		u.DistributorID().sendKeys(Excel.getCellValue(xlPath, sheetname10, 42, 1));
		u.Amount().sendKeys(Excel.getCellValue(xlPath, sheetname10, 19, 1));
		u.UppDistPhone().sendKeys(Excel.getCellValue(xlPath, sheetname10, 26, 1));
		u.EmailField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 33, 1));
		
		
		u.MakePaymentButton().click();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlccavanue"), URL);

		String order = p.OrderNumber().getText();
		
		String amountunderbankselection = p.underbacnkselectionAmount().getText();
		String price = amountunderbankselection.substring(3).trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 1), price);
		
		String finalamount = p.finalamount().getText();
		String finalprice = finalamount.substring(3).trim();
		Assert.assertEquals(amountunderbankselection, finalamount);
		
		String orderamt = p.OrderAmount().getText().trim();
		Assert.assertEquals(orderamt, finalprice, price);
		
		p.Cancelbutton().click();

		if (pc.CancellationFeedBackPopUp().isDisplayed()) {
			pc.CancelTransactionButton().click();
		}
		
		String canceledErrorMessage = pc.CanceledErrorMessage().getText();
		Assert.assertEquals(prop.getProperty("abortmessage"), canceledErrorMessage);
		
		String valueReference = pc.ValueReferenceNumber().getText();
		Assert.assertEquals(order, valueReference);

		pc.GoBackButton().click();

		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.close();
		driver.switchTo().window(parent);

		upp.SearchUppOrderID().sendKeys(order);
		upp.Searchbutton().click();

		String abort = ut.tableUPPOrderStatusfirstrow().getText();
		Assert.assertEquals(prop.getProperty("Abort"), abort);
		Thread.sleep(1000);
	}

	public void InitiatedOrder() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);
		PaymentGatewayPOM p = new PaymentGatewayPOM(driver);
		uppPaymentPOM upp = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		HomepagePOM h = new HomepagePOM(driver);
		
		h.UppPayment().click();
		upp.MakePaymentButton().click();

		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		u.UppNameField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 40, 1));
		u.UppNumberField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 41, 1));
		u.DistributorID().sendKeys(Excel.getCellValue(xlPath, sheetname10, 42, 1));
		u.Amount().sendKeys(Excel.getCellValue(xlPath, sheetname10, 19, 1));
		u.UppDistPhone().sendKeys(Excel.getCellValue(xlPath, sheetname10, 26, 1));
		u.EmailField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 33, 1));

		u.MakePaymentButton().click();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlccavanue"), URL);
		
		String order = p.OrderNumber().getText();
		
		String amountunderbankselection = p.underbacnkselectionAmount().getText();
		String price = amountunderbankselection.substring(3).trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 1), price);
		
		String finalamount = p.finalamount().getText();
		String finalprice = finalamount.substring(3).trim();
		Assert.assertEquals(amountunderbankselection, finalamount);
		
		String orderamt = p.OrderAmount().getText().trim();
		Assert.assertEquals(orderamt, finalprice, price);
		
		Set<String> id1 = driver.getWindowHandles();
		Iterator<String> it1 = id1.iterator();
		String parent1 = it1.next();
		String child1 = it1.next();
		driver.close();
		driver.switchTo().window(parent1);
		
		
		h.UppPayment().click();
		
		upp.SearchUppOrderID().clear();
		upp.SearchUppOrderID().sendKeys(order);
		upp.Searchbutton().click();
		
		String Initiated = ut.tableUPPOrderStatusfirstrow().getText();
		Assert.assertEquals(prop.getProperty("Initiated"), Initiated);
	}
	
	public void SuccessfullTransaction() {
		UppMakePaymentPOM u = new UppMakePaymentPOM(driver);
		PaymentGatewayPOM p = new PaymentGatewayPOM(driver);
		uppPaymentPOM upp = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		HomepagePOM h = new HomepagePOM(driver);
		PaymentGatewaySuccessPOM ps = new PaymentGatewaySuccessPOM(driver);
			
		h.UppPayment().click();
		upp.MakePaymentButton().click();

		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		u.UppNameField().clear();
		u.UppNumberField().clear();
		u.DistributorID().clear();
		u.Amount().clear();
		u.UppDistPhone().clear();
		u.EmailField().clear();

		u.UppNameField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 40, 1));
		u.UppNumberField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 41, 1));
		u.DistributorID().sendKeys(Excel.getCellValue(xlPath, sheetname10, 42, 1));
		u.Amount().sendKeys(Excel.getCellValue(xlPath, sheetname10, 19, 1));
		u.UppDistPhone().sendKeys(Excel.getCellValue(xlPath, sheetname10, 26, 1));
		u.EmailField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 33, 1));

		u.MakePaymentButton().click();
		
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlccavanue"), URL);
		
		String amountunderbankselection = p.underbacnkselectionAmount().getText();
		String price = amountunderbankselection.substring(3).trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 1), price);
		
		String finalamount = p.finalamount().getText();
		String finalprice = finalamount.substring(3).trim();
		Assert.assertEquals(amountunderbankselection, finalamount);
		
		String orderamt = p.OrderAmount().getText().trim();
		Assert.assertEquals(orderamt, finalprice, price);
		
		String order = p.OrderNumber().getText();
		
		Select select = new Select(p.SelectBankdropdown());
		select.selectByIndex(1);
		p.Makepaymentbutton().click();
		
		String Aftermakepaymenturl = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlAfterMakepayment"), Aftermakepaymenturl);
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date);  
	    String currentdate = ps.currentDate().getText();
		Assert.assertEquals(strDate, currentdate);
		
		String am = ps.Amount().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 1), am);
		
		ps.ReturnToTheMerchantSite().click();
		
		String RedirectURL = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlApplicationRedirect"), RedirectURL);
		
		String uppnolabel = ps.TitleUppNo().getText();
		String uppnamelabel = ps.TitleUppName().getText();
		String Transactionamtlabel = ps.TitleTransactionAmount().getText();
		String ReferenceNo = ps.TitleReferenceNumber().getText();
		
		Assert.assertEquals(prop.getProperty("successuppno"), uppnolabel);
		Assert.assertEquals(prop.getProperty("successuppname"), uppnamelabel);
		Assert.assertEquals(prop.getProperty("successtransaction"), Transactionamtlabel);
		Assert.assertEquals(prop.getProperty("successreferenceno"), ReferenceNo);
		
		String uppname = ps.ValueUppName().getText();
		String uppno = ps.ValueUppNo().getText();
		String transaction = ps.ValueTransactionAmount().getText();
		String Reference = ps.ValueReferenceNumber().getText();
	
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 40, 1), uppname);
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 41, 1), uppno);
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 1), transaction);
		Assert.assertEquals(order, Reference);
		
		String succestitle = ps.ApplicationSuccessTitle().getText();
		Assert.assertEquals(prop.getProperty("Paymentsuccess"), succestitle);
		
		String pv = ps.ApplicationPVText().getText();
		Assert.assertEquals(prop.getProperty("Pvassigned"), pv);
		
		ps.GoBackButton().click();
		
		Set<String> id1 = driver.getWindowHandles();
		Iterator<String> it1 = id1.iterator();
		String parent1 = it1.next();
		String child1 = it1.next();
		driver.close();
		driver.switchTo().window(parent1);
		
		
		h.UppPayment().click();
		
		upp.SearchUppOrderID().clear();
		upp.SearchUppOrderID().sendKeys(order);
		upp.Searchbutton().click();
		
		String success = ut.tableUPPOrderStatusfirstrow().getText();
		Assert.assertEquals(prop.getProperty("Success"), success);
		
	}
	
	public void uploaddocument() {
		HomepagePOM h = new HomepagePOM(driver);
		uppPaymentPOM u = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		UppMakePaymentPOM upp = new UppMakePaymentPOM(driver);
		PaymentGatewayPOM p = new PaymentGatewayPOM(driver);
		PaymentGatewaySuccessPOM ps = new PaymentGatewaySuccessPOM(driver);
		ViewUppPaymentPOM v = new ViewUppPaymentPOM(driver);
		
		String path = System.getProperty("user.dir") + "/UploadFile/sample.xlsx"; 
		
/*		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.close();
		driver.switchTo().window(parent);*/
		
		h.UppPayment().click();
		u.MakePaymentButton().click();
		
		Set<String> id1 = driver.getWindowHandles();
		Iterator<String> it1 = id1.iterator();
		String parent1 = it1.next();
		String child1 = it1.next();
		driver.switchTo().window(child1);
		
		upp.UppNameField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 40, 1));
		upp.UppNumberField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 41, 1));
		upp.DistributorID().sendKeys(Excel.getCellValue(xlPath, sheetname10, 42, 1));
		upp.Amount().sendKeys(Excel.getCellValue(xlPath, sheetname10, 19, 1));
		upp.UppDistPhone().sendKeys(Excel.getCellValue(xlPath, sheetname10, 26, 1));
		upp.EmailField().sendKeys(Excel.getCellValue(xlPath, sheetname10, 33, 1));
//		upp.UploadUppOrderSheet().click();
		upp.UploadUppOrderSheet().sendKeys(path);
//		upp.UploadUppOrderSheet().sendKeys(Keys.ENTER);
		upp.MakePaymentButton().click();
		
		
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlccavanue"), URL);
		
		String amountunderbankselection = p.underbacnkselectionAmount().getText();
		String price = amountunderbankselection.substring(3).trim();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 1), price);
		
		String finalamount = p.finalamount().getText();
		String finalprice = finalamount.substring(3).trim();
		Assert.assertEquals(amountunderbankselection, finalamount);
		
		String orderamt = p.OrderAmount().getText().trim();
		Assert.assertEquals(orderamt, finalprice, price);
		
		String order = p.OrderNumber().getText();
		
		Select select = new Select(p.SelectBankdropdown());
		select.selectByIndex(1);
		p.Makepaymentbutton().click();
		
		String Aftermakepaymenturl = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlAfterMakepayment"), Aftermakepaymenturl);
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date);  
	    String currentdate = ps.currentDate().getText();
		Assert.assertEquals(strDate, currentdate);
		
		String am = ps.Amount().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 1), am);
		
		ps.ReturnToTheMerchantSite().click();
		
		String RedirectURL = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("urlApplicationRedirect"), RedirectURL);
		
		String uppnolabel = ps.TitleUppNo().getText();
		String uppnamelabel = ps.TitleUppName().getText();
		String Transactionamtlabel = ps.TitleTransactionAmount().getText();
		String ReferenceNo = ps.TitleReferenceNumber().getText();
		
		Assert.assertEquals(prop.getProperty("successuppno"), uppnolabel);
		Assert.assertEquals(prop.getProperty("successuppname"), uppnamelabel);
		Assert.assertEquals(prop.getProperty("successtransaction"), Transactionamtlabel);
		Assert.assertEquals(prop.getProperty("successreferenceno"), ReferenceNo);
		
		String uppname = ps.ValueUppName().getText();
		String uppno = ps.ValueUppNo().getText();
		String transaction = ps.ValueTransactionAmount().getText();
		String Reference = ps.ValueReferenceNumber().getText();
	
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 40, 1), uppname);
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 41, 1), uppno);
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname10, 19, 1), transaction);
		Assert.assertEquals(order, Reference);
		
		String succestitle = ps.ApplicationSuccessTitle().getText();
		Assert.assertEquals(prop.getProperty("Paymentsuccess"), succestitle);
		
		String pv = ps.ApplicationPVText().getText();
		Assert.assertEquals(prop.getProperty("Pvassigned"), pv);
		
		ps.GoBackButton().click();
		
		Set<String> id2 = driver.getWindowHandles();
		Iterator<String> it2 = id2.iterator();
		String parent2 = it2.next();
		String child2 = it2.next();
		driver.close();
		driver.switchTo().window(parent2);
		
		
		h.UppPayment().click();
		
		u.SearchUppOrderID().clear();
		u.SearchUppOrderID().sendKeys(order);
		u.Searchbutton().click();
		
		String success = ut.tableUPPOrderStatusfirstrow().getText();
		Assert.assertEquals(prop.getProperty("Success"), success);
		
		ut.firstviewbutton().click();
		
		Set<String> id3 = driver.getWindowHandles();
		Iterator<String> it3 = id3.iterator();
		String parent3 = it3.next();
		String child3 = it3.next();
		driver.switchTo().window(child3);
		
		Assert.assertTrue(v.Downloaduploadedexcelfieldvalue().isDisplayed());
		
		Set<String> id4 = driver.getWindowHandles();
		Iterator<String> it4 = id4.iterator();
		String parent4 = it4.next();
		String child4 = it4.next();
		driver.close();
		driver.switchTo().window(parent4);
	}

}
