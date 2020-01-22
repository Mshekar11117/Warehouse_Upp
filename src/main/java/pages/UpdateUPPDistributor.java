package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import POM.createUPPDistributorPOM;
import POM.updateUppDistributorPOM;
import POM.uppDistributorPOM;
import POM.uppDistributorTablePOM;
import base.SuperTestNG;
import utilities.Excel;

public class UpdateUPPDistributor extends SuperTestNG {
	
	public void AccessUpdateUppDistributor() {
		updateUppDistributorPOM u = new updateUppDistributorPOM(driver);
		uppDistributorTablePOM ut = new uppDistributorTablePOM(driver);
		
		ut.firstupdatebutton().click();
		String updateUpp = u.uppdistributorTitle().getText();
		Assert.assertEquals(prop.getProperty("updateUppdistTitle"), updateUpp);
		
	}
	
	public void clearallfields() {
		updateUppDistributorPOM u = new updateUppDistributorPOM(driver);
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		u.uppditributornamefield().clear();
		u.uppdistributornumberfield().clear();
		u.uppdistributorAdatefield().clear();
		u.uppdistributornamefield().clear();
		u.uppdistributoridfield().clear();
		u.uppdistributorplacefield().clear();
		u.uppdistributorstatefield().clear();
		u.uppdistributorPhone().clear();
		u.uppdistributorEmail().clear();
		u.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")), total);
	}
	
	public void InvalidUpdateUppDistName() {
		updateUppDistributorPOM u = new updateUppDistributorPOM(driver);
		
		String required = u.ErrormessageDistName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 2, 2), required);
		
		u.uppditributornamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 2, 0));
		u.updatebutton().click();
		String special = u.ErrormessageDistName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 3, 2), special);
	}
	
//	*******************************************************************************************************************************
	
	public void validUpdateUPPDistName() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppditributornamefield().clear();
		c.uppditributornamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 2, 1));
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -1, total);
	}
	
	public void InvalidUpdateUppNumber() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		String required = c.ErrormessageDistNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 7, 2), required);
		
		c.uppdistributornumberfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 7, 0));
		c.updatebutton().click();
		
		String special = c.ErrormessageDistNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 8, 2), special);
	}
	
	public void validUpdateUPPNumber() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppdistributornumberfield().clear();
		c.uppdistributornumberfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 7, 1));
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -2, total);
	}
	
	public void InvalidUpdateDate() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppdistributorAdatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 12, 0));
		c.updatebutton().click();
		
		String ddmmyyyy = c.ErrormessageDistADate().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 12, 2), ddmmyyyy);
		
		c.uppdistributorAdatefield().clear();
		c.uppdistributorAdatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 13, 0));
		c.updatebutton().click();
		
		String number = c.ErrormessageDistADate().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 12, 2), number);
	}
	
	public void ValidUpdateADate() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppdistributorAdatefield().clear();
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		c.uppdistributorAdatefield().sendKeys(df.format(date));
		
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -2, total);
		
	}
	
	public void InvalidUpdateUppName() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		String required = c.ErrormessageUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 19, 2), required);
		
		c.uppdistributornamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 19, 0));
		c.updatebutton().click();
		String special = c.ErrormessageUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 20, 2), special);
		
		c.uppdistributornamefield().clear();
		
		c.uppdistributornamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 20, 0));
		c.updatebutton().click();
		String number = c.ErrormessageUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 20, 2), number);
	}
	
	public void validUpdateUPPName() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppdistributornamefield().clear();
		c.uppdistributornamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 19, 1));
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -3, total);
	}
	
	public void InvalidUpdateDistID() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		String required = c.ErrormessageDSID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 25, 2), required);
		
		c.uppdistributoridfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 25, 0));
		c.updatebutton().click();
		
		String special = c.ErrormessageDSID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 26, 2), special);
		
		c.uppdistributoridfield().clear();
		
		c.uppdistributoridfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 26, 0));
		c.updatebutton().click();
		
		String Min = c.ErrormessageDSID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 27, 2), Min);
		
	}
	
	public void validUpdateDistID() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppdistributoridfield().clear();
		
		c.uppdistributoridfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 25, 1));
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -4, total);
		
		c.uppdistributoridfield().clear();
		
		c.uppdistributoridfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 26, 1));
		c.updatebutton().click();
		int total2 = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -4, total2);
	}
	
	public void InvalidUpdateplace() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		String required = c.ErrormessagePlace().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 31, 2), required);
		
		c.uppdistributorplacefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 31, 0));
		c.updatebutton().click();
		
		String Special = c.ErrormessagePlace().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 32, 2), Special);
		
		c.uppdistributorplacefield().clear();
		c.uppdistributorplacefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 32, 0));
		String number =  c.ErrormessagePlace().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 32, 2), number);
	}
	
	public void validUpdateplace() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppdistributorplacefield().clear();
		
		c.uppdistributorplacefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 31, 1));
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -5, total);
		
	}
	
	public void InvalidUpdateStateField() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		String required = c.ErrormessageState().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 37, 2), required);
		
		c.uppdistributorstatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 37, 0));
		c.updatebutton().click();
		
		String special = c.ErrormessageState().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 38, 2), special);
		
		c.uppdistributorstatefield().clear();
		c.uppdistributorstatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 38, 0));
		c.updatebutton().click();
		String number = c.ErrormessageState().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 38, 2), number);

	}
	
	public void validUpdateStateField() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppdistributorstatefield().clear();
		c.uppdistributorstatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 37, 1));
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -6, total);
	}
	
	public void StatusUpdate() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		int size = c.uppdistributorStatusOptions().size();
		Random r = new Random();
		int options = r.nextInt(size);
//		System.out.println(options);
		
		Select select =  new Select(c.uppdistributorStatusdropdown());
		select.selectByIndex(options);
		
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -6, total);
	}
	
	public void InvalidUpdateContactNumber() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		String required = c.ErrormessageContactNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 43, 2), required);
		
		c.uppdistributorPhone().sendKeys(Excel.getCellValue(xlPath, sheetname9, 43, 0));
		c.updatebutton().click();
		
		String min = c.ErrormessageContactNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 45, 2), min);
		
		c.uppdistributorPhone().clear();
		
		c.uppdistributorPhone().sendKeys(Excel.getCellValue(xlPath, sheetname9, 44, 0));
		c.updatebutton().click();
		
		String text = c.ErrormessageContactNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 44, 2), text);
	}
	
	public void validUpdateContactNumber() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		c.uppdistributorPhone().clear();
		
		c.uppdistributorPhone().sendKeys(Excel.getCellValue(xlPath, sheetname9, 43, 1));
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -7, total);
		
	}
	
	public void InvalidUpdateEmailAddress() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		
		String required = c.ErrormessageEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 49, 2), required);
		
		c.uppdistributorEmail().sendKeys(Excel.getCellValue(xlPath, sheetname9, 49, 0));
		c.updatebutton().click();
		
		String invalid = c.ErrormessageEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 51, 2), invalid);
		
		c.uppdistributorEmail().clear();
		c.uppdistributorEmail().sendKeys(Excel.getCellValue(xlPath, sheetname9, 50, 0));
		c.updatebutton().click();
		String number = c.ErrormessageEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 51, 2), number);
		
		c.uppdistributorEmail().clear();
		c.uppdistributorEmail().sendKeys(Excel.getCellValue(xlPath, sheetname9, 51, 0));
		c.updatebutton().click();
		String dotmiss = c.ErrormessageEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 51, 2), dotmiss);
	}
	
	public void validUpdateEmailAddress() {
		updateUppDistributorPOM c = new updateUppDistributorPOM(driver);
		uppDistributorPOM u = new uppDistributorPOM(driver);
		
		c.uppdistributorEmail().clear();
		c.uppdistributorEmail().sendKeys(Excel.getCellValue(xlPath, sheetname9, 49, 1));
		c.updatebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -8, total);
		
		Assert.assertTrue(u.UppCreatedSuccessfully().isDisplayed());
		
		String sucess = u.UppCreatedSuccessfully().getText();
		String success = sucess.substring(1).trim();
		
		Assert.assertEquals(prop.getProperty("uppupdatesuccessmessge"), success);
		
		u.alertmessageclosebutton().click();
	}

}
