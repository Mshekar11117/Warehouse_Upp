package pages;

import org.testng.Assert;

import POM.HomepagePOM;
import POM.LandingpagePOM;
import base.SuperTestNG;
import utilities.Excel;

public class Landingpage extends SuperTestNG {

	public void SuperAdminlogin() throws Exception {
		LandingpagePOM L = new LandingpagePOM(driver);
		L.getusername().isDisplayed();
		L.getusername().sendKeys(Excel.getCellValue(xlPath, sheetName, 1, 0));
		L.getpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 1, 1));
		L.getLoginbutton().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, prop.getProperty("homepageurl"));
	}
	
	public void AdminLogin() {
		LandingpagePOM L = new LandingpagePOM(driver);
		L.getusername().isDisplayed();
		L.getusername().sendKeys(Excel.getCellValue(xlPath, sheetName, 2, 0));
		L.getpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 2, 1));
		L.getLoginbutton().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, prop.getProperty("homepageurl"));
	}
	
	public void custcareLogin() {
		LandingpagePOM L = new LandingpagePOM(driver);
		L.getusername().isDisplayed();
		L.getusername().sendKeys(Excel.getCellValue(xlPath, sheetName, 3, 0));
		L.getpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 3, 1));
		L.getLoginbutton().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, prop.getProperty("homepageurl"));
	}
	
	public void Ahmedabaduser() {
		LandingpagePOM L = new LandingpagePOM(driver);
		L.getusername().isDisplayed();
		L.getusername().sendKeys(Excel.getCellValue(xlPath, sheetName, 4, 0));
		L.getpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 4, 1));
		L.getLoginbutton().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, prop.getProperty("homepageurl"));
	}
	
	public void UppLogin() {
		LandingpagePOM L = new LandingpagePOM(driver);
		L.getusername().isDisplayed();
		L.getusername().sendKeys(Excel.getCellValue(xlPath, sheetName, 9, 0));
		L.getpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, 9, 1));
		L.getLoginbutton().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, prop.getProperty("upppaymentsurl"));
	}
	
	public void logout() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		Thread.sleep(1000);
		H.logindropdown().click();
		H.getLogout().click();
	}

	public void validMultiplecredentials() throws Exception {
		LandingpagePOM L = new LandingpagePOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		int rowcount = Excel.getRowCount(xlPath, sheetName);
		for (int i = 1; i <= rowcount; i++) {
			L.getusername().sendKeys(Excel.getCellValue(xlPath, sheetName, i, 0));
			L.getpassword().sendKeys(Excel.getCellValue(xlPath, sheetName, i, 1));
			L.getLoginbutton().click();
			Thread.sleep(1000);
			H.logindropdown().click();
			String s = driver.getTitle();
			Assert.assertEquals("Unicity Warehouse Application", s);
			H.getLogout().click();
		}
	}

	public void invalidMultiplecredentials() {
		LandingpagePOM L = new LandingpagePOM(driver);
		int rowCount = Excel.getRowCount(xlPath, sheetName1);
		for (int i = 1; i <= rowCount; i++) {
			L.getusername().sendKeys(Excel.getCellValue(xlPath, sheetName1, i, 0));
			L.getpassword().sendKeys(Excel.getCellValue(xlPath, sheetName1, i, 1));
			L.getLoginbutton().click();
			L.getusername().clear();
		}
	}
}
