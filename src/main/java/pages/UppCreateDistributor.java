package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM.createUPPDistributorPOM;
import POM.uppDistributorPOM;
import base.SuperTestNG;
import utilities.Excel;

public class UppCreateDistributor extends SuperTestNG {
	
	public void AccessCreateUppDistributor() {
		uppDistributorPOM u = new uppDistributorPOM(driver);
		
		u.CreateUppDistributorButton().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("createUPPDisturl"), url);
	}
	
	public void verifythetitles() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		SoftAssert soft = new SoftAssert();
		
		String pagetitle = c.uppdistributorTitle().getText();
		soft.assertEquals(prop.getProperty("createpagetitle"), pagetitle);
		
		String Distributorname = c.titleUppDistName().getText();
		soft.assertEquals(prop.getProperty("createuppDistributorName"), Distributorname);
		
		String uppno = c.titleUppDistNo().getText();
		soft.assertEquals(prop.getProperty("createUPPNo"), uppno);
		
		String Adate = c.titleUppDistADate().getText();
		soft.assertEquals(prop.getProperty("createADate"), Adate);
		
		String uppname = c.titleUppDistName().getText();
		soft.assertEquals(prop.getProperty("createuppname"), uppname);
		
		String distid = c.titleUppDistID().getText();
		soft.assertEquals(prop.getProperty("createdistid"),distid);
		
		String place = c.titleDistPlace().getText();
		soft.assertEquals(prop.getProperty("createplace"), place);
		
		String state = c.titleDistState().getText();
		soft.assertEquals(prop.getProperty("createState"), state);
		
		String Status = c.titleDistStatus().getText();
		soft.assertEquals(prop.getProperty("createStatus"), Status);
		
		String phone = c.titleDistPhone().getText();
		soft.assertEquals(prop.getProperty("createContactNo"), phone);
		
		String email = c.titleDistEmail().getText();
		soft.assertEquals(prop.getProperty("createEmailid"), email);
		
	}
	
	public void TotalMandatoryfields() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.savebutton().click();
		int total = c.errormessages().size();
		String error = prop.getProperty("totalerrormessages");
		Assert.assertEquals(Integer.parseInt(error), total);
	}
	
	public void InvalidUppDistName() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		String required = c.ErrormessageDistName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 2, 2), required);
		
		c.uppditributornamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 2, 0));
		c.savebutton().click();
		String special = c.ErrormessageDistName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 3, 2), special);
	}
	
	public void validUPPDistName() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppditributornamefield().clear();
		c.uppditributornamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 2, 1));
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -1, total);
	}
	
	public void InvalidUppNumber() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		String required = c.ErrormessageDistNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 7, 2), required);
		
		c.uppdistributornumberfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 7, 0));
		c.savebutton().click();
		
		String special = c.ErrormessageDistNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 8, 2), special);
	}
	
	public void validUPPNumber() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppdistributornumberfield().clear();
		c.uppdistributornumberfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 7, 1));
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -2, total);
	}
	
	public void InvalidDate() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppdistributorAdatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 12, 0));
		c.savebutton().click();
		
		String ddmmyyyy = c.ErrormessageDistADate().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 12, 2), ddmmyyyy);
		
		c.uppdistributorAdatefield().clear();
		c.uppdistributorAdatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 13, 0));
		c.savebutton().click();
		
		String number = c.ErrormessageDistADate().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 12, 2), number);
	}
	
	public void ValidADate() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppdistributorAdatefield().clear();
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		c.uppdistributorAdatefield().sendKeys(df.format(date));
		
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -2, total);
		
	}
	
	public void InvalidUppName() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		String required = c.ErrormessageUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 19, 2), required);
		
		c.uppnamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 19, 0));
		c.savebutton().click();
		String special = c.ErrormessageUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 20, 2), special);
		
		c.uppnamefield().clear();
		
		c.uppnamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 20, 0));
		c.savebutton().click();
		String number = c.ErrormessageUppName().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 20, 2), number);
	}
	
	public void validUPPName() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppnamefield().clear();
		c.uppnamefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 19, 1));
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -3, total);
	}
	
	public void InvalidDistID() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		String required = c.ErrormessageDSID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 25, 2), required);
		
		c.uppdistributoridfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 25, 0));
		c.savebutton().click();
		
		String special = c.ErrormessageDSID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 26, 2), special);
		
		c.uppdistributoridfield().clear();
		
		c.uppdistributoridfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 26, 0));
		c.savebutton().click();
		
		String Min = c.ErrormessageDSID().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 27, 2), Min);
		
	}
	
	public void validDistID() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppdistributoridfield().clear();
		
		c.uppdistributoridfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 25, 1));
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -4, total);
		
		c.uppdistributoridfield().clear();
		
		c.uppdistributoridfield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 26, 1));
		c.savebutton().click();
		int total2 = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -4, total2);
	}
	
	public void Invalidplace() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		String required = c.ErrormessagePlace().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 31, 2), required);
		
		c.uppdistributorplacefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 31, 0));
		c.savebutton().click();
		
		String Special = c.ErrormessagePlace().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 32, 2), Special);
		
		c.uppdistributorplacefield().clear();
		c.uppdistributorplacefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 32, 0));
		String number =  c.ErrormessagePlace().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 32, 2), number);
	}
	
	public void validplace() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppdistributorplacefield().clear();
		
		c.uppdistributorplacefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 31, 1));
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -5, total);
		
	}
	
	public void InvalidStateField() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		String required = c.ErrormessageState().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 37, 2), required);
		
		c.uppdistributorstatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 37, 0));
		c.savebutton().click();
		
		String special = c.ErrormessageState().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 38, 2), special);
		
		c.uppdistributorstatefield().clear();
		c.uppdistributorstatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 38, 0));
		c.savebutton().click();
		String number = c.ErrormessageState().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 38, 2), number);

	}
	
	public void validStateField() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppdistributorstatefield().clear();
		c.uppdistributorstatefield().sendKeys(Excel.getCellValue(xlPath, sheetname9, 37, 1));
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -6, total);
	}
	
	public void Status() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		int size = c.uppdistributorStatusOptions().size();
		Random r = new Random();
		int options = r.nextInt(size);
//		System.out.println(options);
		
		Select select =  new Select(c.uppdistributorStatusdropdown());
		select.selectByIndex(options);
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -6, total);
	}
	
	public void InvalidContactNumber() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		String required = c.ErrormessageContactNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 43, 2), required);
		
		c.uppdistributorPhone().sendKeys(Excel.getCellValue(xlPath, sheetname9, 43, 0));
		c.savebutton().click();
		
		String min = c.ErrormessageContactNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 45, 2), min);
		
		c.uppdistributorPhone().clear();
		
		c.uppdistributorPhone().sendKeys(Excel.getCellValue(xlPath, sheetname9, 44, 0));
		c.savebutton().click();
		
		String text = c.ErrormessageContactNo().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 44, 2), text);
	}
	
	public void validContactNumber() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		c.uppdistributorPhone().clear();
		
		c.uppdistributorPhone().sendKeys(Excel.getCellValue(xlPath, sheetname9, 43, 1));
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -7, total);
		
	}
	
	public void InvalidEmailAddress() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		
		String required = c.ErrormessageEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 49, 2), required);
		
		c.uppdistributorEmail().sendKeys(Excel.getCellValue(xlPath, sheetname9, 49, 0));
		c.savebutton().click();
		
		String invalid = c.ErrormessageEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 50, 2), invalid);
		
		c.uppdistributorEmail().clear();
		c.uppdistributorEmail().sendKeys(Excel.getCellValue(xlPath, sheetname9, 50, 0));
		c.savebutton().click();
		String number = c.ErrormessageEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 50, 2), number);
		
		c.uppdistributorEmail().clear();
		c.uppdistributorEmail().sendKeys(Excel.getCellValue(xlPath, sheetname9, 51, 0));
		c.savebutton().click();
		String dotmiss = c.ErrormessageEmail().getText();
		Assert.assertEquals(Excel.getCellValue(xlPath, sheetname9, 50, 2), dotmiss);
	}
	
	public void validEmailAddress() {
		createUPPDistributorPOM c = new createUPPDistributorPOM(driver);
		uppDistributorPOM u = new uppDistributorPOM(driver);
		
		c.uppdistributorEmail().clear();
//		c.uppdistributorEmail().sendKeys(Excel.getCellValue(xlPath, sheetname9, 49, 1));
		c.uppdistributorEmail().sendKeys(genData.generateEmail(20));
		c.savebutton().click();
		
		int total = c.errormessages().size();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("totalerrormessages")) -8, total);
		
		Assert.assertTrue(u.UppCreatedSuccessfully().isDisplayed());
		
		String sucess = u.UppCreatedSuccessfully().getText();
		String success = sucess.substring(1).trim();
		
		Assert.assertEquals(prop.getProperty("uppcreatedsuccessmessage"), success);
		
		u.alertmessageclosebutton().click();
		
		
	}
	
	

}
