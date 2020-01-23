package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.ChangepasswordPOM;
import POM.HomepagePOM;
import base.SuperTestNG;
import utilities.Excel;

public class Changepasswordpage extends SuperTestNG{
	
	public void verifychangepasswordtitles() {
		ChangepasswordPOM ch = new ChangepasswordPOM(driver);
		String heading = ch.panelheading().getText();
		String npass = ch.newpasswordtitle().getText();
		String cpass = ch.confirmpasswordtitle().getText();
		String update = ch.updatebtn().getAttribute("value");
		String cancel = ch.cancelbutton().getText();
		Assert.assertEquals(heading, prop.getProperty("changepasswordpaneltxt"));
		Assert.assertEquals(npass, prop.getProperty("newpassword"));
		Assert.assertEquals(cpass, prop.getProperty("confirmpassword"));
		Assert.assertEquals(update, prop.getProperty("update"));
		Assert.assertEquals(cancel, prop.getProperty("cancel"));
	}
	
	public void changevalipassword() {
		ChangepasswordPOM ch = new ChangepasswordPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		int menucount = H.leftsidemenus().size();
		String user = H.userprofilename().getText();
		
		if (menucount == Integer.parseInt(prop.getProperty("Superadminmenucount")) && user.equalsIgnoreCase(prop.getProperty("superAdmin"))) {
			ch.newpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 1, 4));
			ch.confirmpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 1, 5));
		} else if (menucount == Integer.parseInt(prop.getProperty("AdminMenucount"))) {
			ch.newpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 2, 4));
			ch.confirmpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 2, 5));
		} else if (menucount == Integer.parseInt(prop.getProperty("customerMenuCount"))) {
			ch.newpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 3, 4));
			ch.confirmpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 3, 5));
		} else {
			ch.newpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 4, 4));
			ch.confirmpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 4, 5));
		}
		ch.updatebtn().click();
		if(ch.updatesuccess().isDisplayed()) {
			String message = ch.updatesuccess().getText();
			Assert.assertEquals(message, prop.getProperty("passwordchangesucess"));
		}
	}
	
	public void changeinvalidpassword() throws Exception {
		ChangepasswordPOM ch = new ChangepasswordPOM(driver);
		Thread.sleep(500);
		ch.newpassword().sendKeys(Excel.getCellValue(xlPath, sheetName1, 1, 4));
		ch.confirmpassword().sendKeys(Excel.getCellValue(xlPath, sheetName1, 1, 5));
		ch.updatebtn().click();
		if(ch.updatedfailure().isDisplayed()) {
			String message = ch.updatedfailure().getText();
				Assert.assertEquals(message, prop.getProperty("passwordchangefailure"));
			}
	}
	
	public void canelupdatepassword() throws Exception {
		ChangepasswordPOM ch = new ChangepasswordPOM(driver);
		Thread.sleep(300);
		ch.cancelbutton().click();
		Thread.sleep(300);
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, prop.getProperty("warehouseurl"));
	}
	
	

}
