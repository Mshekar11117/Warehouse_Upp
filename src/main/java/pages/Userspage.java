package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.ModalPOM;
import POM.TablesPOM;
import POM.UserspagePOM;
import base.SuperTestNG;

public class Userspage extends SuperTestNG {

	public void AccessingUsersMenu() {
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.usersmenu().click();
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("usersURL"), currenturl);

		Assert.assertTrue(T.Createbutton().isDisplayed());
		Assert.assertTrue(T.table().isDisplayed());

		/*int updatebutton = U.allUpdatebuttons().size();
		Assert.assertEquals(21, updatebutton);

		int Deletebuttons = U.allDeletebuttons().size();
		Assert.assertEquals(21, Deletebuttons);*/
	}

	public void verifyUsertexts() {
		TablesPOM T = new TablesPOM(driver);
		
		String usertxt = T.PageTitleText().getText();
		Assert.assertEquals(prop.getProperty("Users"), usertxt);

		int count = T.Titleslength().size();
		Assert.assertEquals(5, count);

		String first = T.FirstTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("id"), first);

		String second = T.SecondTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("name"), second);

		String third = T.ThirdTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("email"), third);

		String fourth = T.FourthTItleofTable().getText();
		Assert.assertEquals(prop.getProperty("role"), fourth);

		String fifth = T.FifthTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("actions"), fifth);

	}

	public void createuservalidations() {
		UserspagePOM U = new UserspagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		T.Createbutton().click();

		String newuser = U.CreateNewUser().getText();
		Assert.assertEquals(prop.getProperty("CreateNewUser"), newuser);

		Assert.assertTrue(U.namefield().isDisplayed());
		Assert.assertTrue(U.emailfield().isDisplayed());
		Assert.assertTrue(U.passwordfield().isDisplayed());
		Assert.assertTrue(U.confirmpassword().isDisplayed());
		Assert.assertTrue(U.mobilefiled().isDisplayed());
		Assert.assertTrue(U.WarehousesSelect().isDisplayed());
		Assert.assertTrue(U.UserRoleSelect().isDisplayed());

		U.Savebutton().click();
		Assert.assertTrue(U.ErrorMessages().isDisplayed());

		int errors = U.ErrorMessageLength().size();
		Assert.assertEquals(errors, 6);

		Assert.assertTrue(U.NameFieldRequiredErrorMessage().isDisplayed());
		Assert.assertTrue(U.EmailFieldRequiredErrorMessage().isDisplayed());
		Assert.assertTrue(U.PasswordFieldRequiredErrorMessage().isDisplayed());
		Assert.assertTrue(U.MobileFieldRequiredErrorMessage().isDisplayed());
		Assert.assertTrue(U.WHidFieldRequiredErrorMessage().isDisplayed());
		Assert.assertTrue(U.RoleFieldRequiredErrorMessage().isDisplayed());
		
		U.namefield().sendKeys(genData.generateRandomNumber(5));
		U.Savebutton().click();
		Assert.assertTrue(U.InvlidNameErrorMessage().isDisplayed());
		
		U.emailfield().sendKeys(genData.generateRandomString(10));
		U.Savebutton().click();
		Assert.assertTrue(U.InvalidEmailErrorMessage().isDisplayed());
		U.emailfield().clear();
		U.emailfield().sendKeys(prop.getProperty("existingemail"));
		U.Savebutton().click();
		Assert.assertTrue(U.EmailFieldAlredyExistsErrorMessage().isDisplayed());
		U.emailfield().clear();
		U.mobilefiled().sendKeys(genData.generateRandomString(10));
		U.Savebutton().click();
		Assert.assertTrue(U.MobileMustBeNumber().isDisplayed());
		U.mobilefiled().clear();

		U.namefield().sendKeys(genData.generateRandomString(10));
		U.emailfield().sendKeys(genData.generateEmail(12));
		U.passwordfield().sendKeys(prop.getProperty("password"));
		U.mobilefiled().sendKeys(genData.generateRandomNumber(10));

		U.Savebutton().click();
		Assert.assertTrue(U.ConfirmpassowrdNoMatch().isDisplayed());
	}

	public void VerifyDropdownWHValues() {
		UserspagePOM U = new UserspagePOM(driver);
		int count = 0;
		int length = U.WhselectOptions().size();
		String[] wh = { "Bangalore", "Guwahati", "Bhiwandi", "Ahmedabad", "Gurgaon" };

		WebElement dropdown = U.WarehousesSelect();
		Select select = new Select(dropdown);

		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < length; i++) {
				if (we.getText().equals(wh[i])) {
					count++;
				}
			}
		}
		if (count == length) {
			Assert.assertTrue(true);
		} else {
			System.out.println("Warehouse drop down option is not matching");
		}
	}

	public void SelectWHvaluefromDropDown() {
		UserspagePOM U = new UserspagePOM(driver);
		int length = U.WhselectOptions().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < length; i++) {
			String values = U.WhselectOptions().get(i).getText();
			names.add(values);
		}

		Random r = new Random();
		WebElement options = U.WhselectOptions().get(r.nextInt(length));
		options.click();
		String selected = options.getText();
		if (names.contains(selected)) {
			Assert.assertTrue(true);
		} else {
			System.out.println("selected options is not there in drop down");
		}

	}

	public void VerifyDropdownroleValues() {
		UserspagePOM U = new UserspagePOM(driver);
		int count = 0;
		int length = U.UserRoleOptions().size();
		
		String[] roles = { "Please Select Role", "Super Admin", "Admin", "Warehouse", "Customer Service", "Upp Payment" };

		WebElement dropdown = U.UserRoleSelect();
		Select select = new Select(dropdown);

		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < length; i++) {
				if (we.getText().equals(roles[i])) {
					count++;
				}
			}
		}
		if (count == length) {
			Assert.assertTrue(true);
		} else {
			System.out.println("Warehouse drop down option is not matching");
		}

	}

	public void SelectRolesValue() {
		UserspagePOM U = new UserspagePOM(driver);
		int length = U.UserRoleOptions().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < length; i++) {
			String values = U.UserRoleOptions().get(i).getText();
			names.add(values);
		}

		Random r = new Random();
		WebElement options = U.UserRoleOptions().get(r.nextInt(length));
		options.click();
		String selected = options.getText();
		if (selected.equals("Please Select Role")) {
			Select select = new Select(U.UserRoleSelect());
			select.selectByIndex(3);
		}
		if (names.contains(selected)) {
			Assert.assertTrue(true);
		} else {
			System.out.println("selected options is not there in drop down");
		}
	}

	public void createuser() {
		UserspagePOM U = new UserspagePOM(driver);
		TablesPOM T = new TablesPOM(driver);
		
		U.namefield().clear();
		String name = genData.generateRandomString(8);
		U.namefield().sendKeys(name);
		U.emailfield().clear();
		String email = genData.generateEmail(10);
		U.emailfield().sendKeys(email);
		U.passwordfield().sendKeys(prop.getProperty("password"));
		U.confirmpassword().sendKeys(prop.getProperty("password"));
		U.mobilefiled().clear();
		U.mobilefiled().sendKeys(genData.generateRandomNumber(20));
		U.Savebutton().click();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("usersURL"));
		
		String lastusername = T.LastRecordName().getText();
		String lastemailid = T.LastRecordEmailidORDesc().getText();
		Assert.assertEquals(name, lastusername);
		Assert.assertEquals(email, lastemailid);
	}
	
	public void UpdateUserValidations() {
		UserspagePOM U = new UserspagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		U.Updatelastbutton().click();

		String UpdateUser = U.CreateNewUser().getText();
		Assert.assertEquals(prop.getProperty("updateusertitle"), UpdateUser);
		
		U.namefield().clear();
		U.emailfield().clear();
		U.mobilefiled().clear();
		
		Select select = new Select(U.UserRoleSelect());
		select.selectByIndex(01);

		Assert.assertTrue(U.namefield().isDisplayed());
		Assert.assertTrue(U.emailfield().isDisplayed());
		Assert.assertTrue(U.passwordfield().isDisplayed());
		Assert.assertTrue(U.confirmpassword().isDisplayed());
		Assert.assertTrue(U.mobilefiled().isDisplayed());
		Assert.assertTrue(U.WarehousesSelect().isDisplayed());
		Assert.assertTrue(U.UserRoleSelect().isDisplayed());

		U.Updatebutton().click();
		Assert.assertTrue(U.ErrorMessages().isDisplayed());

		int errors = U.ErrorMessageLength().size();
		Assert.assertEquals(errors, 3);

		Assert.assertTrue(U.NameFieldRequiredErrorMessage().isDisplayed());
		Assert.assertTrue(U.EmailFieldRequiredErrorMessage().isDisplayed());
		Assert.assertTrue(U.MobileFieldRequiredErrorMessage().isDisplayed());
		
		U.namefield().sendKeys(genData.generateRandomNumber(5));
		U.Updatebutton().click();
		Assert.assertTrue(U.InvlidNameErrorMessage().isDisplayed());
	
		U.emailfield().sendKeys(genData.generateRandomString(10));
		U.Updatebutton().click();
		Assert.assertTrue(U.InvalidEmailErrorMessage().isDisplayed());
		
		U.emailfield().clear();
		U.emailfield().sendKeys(prop.getProperty("existingemail"));
		U.Updatebutton().click();
		Assert.assertTrue(U.EmailFieldAlredyExistsErrorMessage().isDisplayed());
		U.emailfield().clear();
		U.mobilefiled().sendKeys(genData.generateRandomString(10));
		U.Updatebutton().click();
		Assert.assertTrue(U.MobileMustBeNumber().isDisplayed());
		U.mobilefiled().clear();

		U.namefield().sendKeys(genData.generateRandomString(10));
		U.emailfield().sendKeys(genData.generateEmail(12));
		U.passwordfield().sendKeys(prop.getProperty("password"));
		U.mobilefiled().sendKeys(genData.generateRandomNumber(10));

		U.Updatebutton().click();
		Assert.assertTrue(U.ConfirmpassowrdNoMatch().isDisplayed());
	}
	
	public void Updateuser() {
		UserspagePOM U = new UserspagePOM(driver);
		TablesPOM T = new TablesPOM(driver);
		HomepagePOM H =  new HomepagePOM(driver);
		
		H.usersmenu().click();
		
		U.Updatelastbutton().click();
		Assert.assertTrue(U.namefield().isDisplayed());
		Assert.assertTrue(U.emailfield().isDisplayed());
		Assert.assertTrue(U.passwordfield().isDisplayed());
		Assert.assertTrue(U.confirmpassword().isDisplayed());
		Assert.assertTrue(U.mobilefiled().isDisplayed());
		Assert.assertTrue(U.WarehousesSelect().isDisplayed());
		Assert.assertTrue(U.UserRoleSelect().isDisplayed());
		
		U.UpdateCancelbutton().click();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("usersURL"));
		U.Updatelastbutton().click();
		
		U.namefield().clear();
		String name = genData.generateRandomString(8);
		U.namefield().sendKeys(name);
		
		U.emailfield().clear();
		String email = genData.generateEmail(10);
		U.emailfield().sendKeys(email);
		
		String password = genData.generateRandomAlphaNumeric(9);
		U.passwordfield().sendKeys(password);
		U.confirmpassword().sendKeys(password);
		U.Updatebutton().click();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("usersURL"));
		
		String lastusername = T.LastRecordName().getText();
		String lastemailid = T.LastRecordEmailidORDesc().getText();
		Assert.assertEquals(name, lastusername);
		Assert.assertEquals(email, lastemailid);
	}
	
	public void Deleteuser() {
		ModalPOM M = new ModalPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		
		T.LastDeleteButton().click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(M.DeleteModal()));
		
		if(M.DeleteModal().isDisplayed()) {
			Assert.assertTrue(M.DeleteModalTitle().isDisplayed());
			M.OKbutton().click();
		}
		
		Assert.assertTrue(M.DeleteSuccessMessage().isDisplayed());
		
	}

}
