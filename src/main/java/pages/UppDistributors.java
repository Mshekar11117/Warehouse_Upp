package pages;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM.HomepagePOM;
import POM.ModalPOM;
import POM.updateUppDistributorPOM;
import POM.uppDistributorPOM;
import POM.uppDistributorTablePOM;
import base.SuperTestNG;

public class UppDistributors extends SuperTestNG{
	
	public void AccessingUppDistributor() {
		HomepagePOM H = new HomepagePOM(driver);
		
		H.UppDistributor().click();
		String uppurl = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("uppdistributorurl"), uppurl);
	}
	
	public void VerifyUppDistributorpage() {
		uppDistributorPOM u = new uppDistributorPOM(driver);
		uppDistributorTablePOM ut = new uppDistributorTablePOM(driver);
		
		String pagetitle = u.uppdistributorTitle().getText();
		Assert.assertEquals(prop.getProperty("upppagetitle"), pagetitle);
		
		Assert.assertTrue(u.CreateUppDistributorButton().isDisplayed());
		Assert.assertTrue(ut.allviewbuttons().isDisplayed(), "View button are not missing");
		Assert.assertTrue(ut.allupdatebuttons().isDisplayed(), "Update button are not missing");
		Assert.assertTrue(ut.alldeletebuttons().isDisplayed(), "Delete button are not missing");
	}
	
	public void VerifyColumnNames() {
		uppDistributorTablePOM u = new uppDistributorTablePOM(driver);
		SoftAssert softassert = new SoftAssert();
		
		String slno = u.firstcolumnname().getText();
		softassert.assertEquals(prop.getProperty("uppslno"), slno, "Serial number column assert failed");
		
		String distid = u.SecondCoulmnName().getText();
		softassert.assertEquals(prop.getProperty("uppdistid"), distid, "ditributor ID column assert failed");
		
		String distname = u.ThirdCoulmnName().getText();
		softassert.assertEquals(prop.getProperty("uppdistname"), distname, "ditributor name column assert failed");
		
		String uppno = u.FourthCoulmnName().getText();
		softassert.assertEquals(prop.getProperty("uppno"), uppno, "Upp number column assert failed");
		
		String Adate = u.FifthColumnName().getText();
		softassert.assertEquals(prop.getProperty("uppAdate"), Adate, "Adate column assert failed");
		
		String uppname = u.sixthColumnName().getText();
		softassert.assertEquals(prop.getProperty("uppname"), uppname, "Upp name column assert failed");
		
		String uppplace = u.seventhColumnName().getText();
		softassert.assertEquals(prop.getProperty("uppplace"), uppplace, "Upp place column assert failed");
		
		String uppstate = u.eighthColumnName().getText();
		softassert.assertEquals(prop.getProperty("uppstate"), uppstate, "Upp state column assert failed");
		
		String uppstatus = u.NinthColumnName().getText();
		softassert.assertEquals(prop.getProperty("uppstatus"), uppstatus, "Upp status column assert failed" );
		
		String uppcontactno = u.tenthColumnName().getText();
		softassert.assertEquals(prop.getProperty("uppcontactno"), uppcontactno, "Upp phone number column assert failed");
		
		String uppactions = u.eleventhColumnName().getText();
		softassert.assertEquals(prop.getProperty("uppactions"), uppactions, "Upp actions column assert failed");
		
		softassert.assertAll();
		
	}
	
	public void updateUppDistributor() {
		uppDistributorTablePOM u = new uppDistributorTablePOM(driver);
		updateUppDistributorPOM up = new updateUppDistributorPOM(driver);
		
		u.firstupdatebutton().click();
		Assert.assertTrue(up.uppdistributorTitle().isDisplayed());
		up.updatecancelbutton().click();
	}
	
	public void DeleteUppDistributor() throws InterruptedException {
		uppDistributorTablePOM u = new uppDistributorTablePOM(driver);
		uppDistributorPOM upp = new uppDistributorPOM(driver);
		ModalPOM m = new ModalPOM(driver);
		
		u.firstDeletebutton().click();
		Thread.sleep(1000);
		Assert.assertTrue(m.DeleteModal().isDisplayed());
		
		Assert.assertTrue(m.DeleteModalTitle().isDisplayed());
		m.DeleteModalClosebutton().click();
		
		Thread.sleep(1000);
		u.firstDeletebutton().click();
		m.DeleteCancelbutton().click();
		
		Thread.sleep(10000);
		u.firstDeletebutton().click();
		m.OKbutton().click();
		
		Assert.assertTrue(upp.UppCreatedSuccessfully().isDisplayed());
		
		String message = upp.UppCreatedSuccessfully().getText();
		String success = message.substring(1).trim();
		Assert.assertEquals(prop.getProperty("deletemessage"), success);
		
		upp.alertmessageclosebutton().click();
		
	}

}
