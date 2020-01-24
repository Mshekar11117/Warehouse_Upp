package pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.WHTablesPOM;
import POM.footerPOM;
import base.SuperTestNG;

public class Homepage extends SuperTestNG {

	public void verifycopyright() {
		footerPOM f = new footerPOM(driver);

		String copy = f.copyright().getText();
		String copyright = copy.substring(2, 6);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		Assert.assertEquals(copyright, Integer.toString(year));
	}

	public void getprofileusername() {
		HomepagePOM H = new HomepagePOM(driver);
		String user = H.userprofilename().getText();
		String profile = H.profilename().getText();
		Assert.assertEquals(user, profile);
	}

	public void getwarehouseaccess() {
		HomepagePOM H = new HomepagePOM(driver);
		String st = H.accesstext().getText();
		String text = st.substring(st.length() - 3);
		Assert.assertEquals(text, prop.getProperty("accessall"));
	}
	
	public void WHwarehouseAccess() {
		HomepagePOM H = new HomepagePOM(driver);
		String user = H.userprofilename().getText();
		String st = H.accesstext().getText();
		String text = st.substring(18);
		if(user.equalsIgnoreCase(prop.getProperty("WHAhmedabaduser"))) {
			Assert.assertEquals(text, prop.getProperty("Ahmedabad"));
		} else if(user.equalsIgnoreCase(prop.getProperty("WHBhiwandiuser"))) {
			Assert.assertEquals(text, prop.getProperty("Bhiwandi"));
		} else if(user.equalsIgnoreCase(prop.getProperty("WHBangaloreuser"))) {
			Assert.assertEquals(text, prop.getProperty("Bangalore"));
		}else if(user.equalsIgnoreCase(prop.getProperty("WHGurgaonuser"))) {
			Assert.assertEquals(text, prop.getProperty("Gurgaon"));
		} else if (user.equalsIgnoreCase(prop.getProperty("WHGuwahatiuser"))){
			Assert.assertEquals(text, prop.getProperty("Guwahati"));
		} else {
			Assert.assertEquals(text, prop.getProperty("Raipur"));
		}
		
	}

	public void custcarewarehouseAccess() {
		HomepagePOM H = new HomepagePOM(driver);
		String access = H.accesstext().getText();
		String accesstext = access.substring(18);
		Assert.assertEquals(accesstext, prop.getProperty("customercareaccess"));
	}

	public void gettexts() {
		HomepagePOM H = new HomepagePOM(driver);
		String welcm = H.welcomtext().getText();
		Assert.assertEquals(welcm, prop.getProperty("Welcome"));
		String access = H.whaccess().getText();
		Assert.assertEquals(access, prop.getProperty("warehouseaccess"));
	}

	public void verifyleftmenus() {
		HomepagePOM H = new HomepagePOM(driver);
		int menucount = H.leftsidemenus().size();
		String user = H.userprofilename().getText();

		if (menucount == Integer.parseInt(prop.getProperty("Superadminmenucount"))
				&& user.equalsIgnoreCase(prop.getProperty("superAdmin"))) {
			Assert.assertEquals(menucount, Integer.parseInt(prop.getProperty("Superadminmenucount")));
			String[] lmenus = { "WareHouse Orders", "Kyc", "Users", "Roles", "Permissions", "Warehouses", "Countries",
					"SMS Templates", "UPP Payments", "UPP Distributors" };
			for (int i = 0; i < menucount; i++) {
				String menus = H.leftsidemenus().get(i).getText();
				assertTrue(menus.contains(lmenus[i]));
			}
		} else if (menucount == Integer.parseInt(prop.getProperty("AdminMenucount"))) {
			Assert.assertEquals(menucount, Integer.parseInt(prop.getProperty("AdminMenucount")));
			String[] lmenus = { "WareHouse Orders", "Kyc", "Users", "Roles", "Permissions", "Warehouses", "Countries",
					"SMS Templates", "UPP Payments", "UPP Distributors" };
			for (int i = 0; i < menucount; i++) {
				String menus = H.leftsidemenus().get(i).getText();
				assertTrue(menus.contains(lmenus[i]));
			}
		} else if (menucount == Integer.parseInt(prop.getProperty("customerMenuCount"))) {
			Assert.assertEquals(menucount, Integer.parseInt(prop.getProperty("customerMenuCount")));
			String[] lmenus = { "WareHouse Orders", "Kyc", "SMS Templates" };
			for (int i = 0; i < menucount; i++) {
				String menus = H.leftsidemenus().get(i).getText();
				assertTrue(menus.contains(lmenus[i]));
			}
		} else {
			Assert.assertEquals(menucount, Integer.parseInt(prop.getProperty("WHuserMenuCount")));
			String[] lmenus = { "WareHouse Orders" };
			for (int i = 0; i < menucount; i++) {
				String menus = H.leftsidemenus().get(i).getText();
				assertTrue(menus.contains(lmenus[i]));
			}
		}
	}

	public void getKyc() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		H.kycmenu().click();
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, prop.getProperty("KycURL"));
		Thread.sleep(5000);
	}

	public void getusers() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		H.usersmenu().click();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(curl, prop.getProperty("usersURL"));
		Thread.sleep(5000);
	}

	public void getroles() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		H.Rolesmenu().click();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(curl, prop.getProperty("rolesURL"));
		Thread.sleep(5000);
	}

	public void getpermissions() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		H.Permission().click();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(curl, prop.getProperty("permissionsURL"));
		Thread.sleep(5000);
	}

	public void getwarehousenames() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		H.Warehousenames().click();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(curl, prop.getProperty("warehousenameURL"));
		Thread.sleep(5000);
	}

	public void getcountries() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		H.Countries().click();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(curl, prop.getProperty("countriesURL"));
		Thread.sleep(5000);
	}

	public void getsmstemplate() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		H.Smstemplate().click();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(curl, prop.getProperty("smstemplateURL"));
		Thread.sleep(5000);
	}

	public void getwarehouseorder() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		H.WarehouseOrdermenu().click();
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(curl, prop.getProperty("warehouseurl"));
		Thread.sleep(5000);
	}

	public void verifyhumbergerlink() {
		HomepagePOM H = new HomepagePOM(driver);
		if (H.profilediv().isDisplayed()) {
			H.humbergermenu().click();
			assertFalse(H.profilename().isDisplayed());
		}
	}

	public void verifychangepasswordlink() {
		HomepagePOM H = new HomepagePOM(driver);
		H.logindropdown().click();
		H.changepassword().click();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("changepassword"));
	}

	public void verifywarehouseOrderstext() {
		HomepagePOM H = new HomepagePOM(driver);
		String whordertext = H.WarehouseOrderText().getText();
		Assert.assertEquals(prop.getProperty("Warehousetext"), whordertext);
	}

	public void Verifyactions() {
		HomepagePOM H = new HomepagePOM(driver);
		WHTablesPOM T = new WHTablesPOM(driver);

		H.WarehouseOrdermenu().click();
		int menucount = H.leftsidemenus().size();
		if (menucount == Integer.parseInt(prop.getProperty("Superadminmenucount"))
				|| menucount == Integer.parseInt(prop.getProperty("AdminMenucount"))
				|| menucount == Integer.parseInt(prop.getProperty("WHuserMenuCount"))) {
			Assert.assertTrue(T.Actionedits().size() > 0);
			Assert.assertTrue(T.Actionviews().size() > 0);
			Assert.assertTrue(T.Actionremoves().size() > 0);
		} else {
			Assert.assertTrue(T.Actionedits().size() == 0);
			Assert.assertTrue(T.Actionviews().size() > 0);
			Assert.assertTrue(T.Actionremoves().size() == 0);
		}
	}

}
