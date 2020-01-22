package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.CountriesPOM;
import POM.HomepagePOM;
import POM.ModalPOM;
import POM.PaginationPOM;
import POM.TablesPOM;
import POM.UserspagePOM;
import base.SuperTestNG;
import utilities.Excel;

public class Countries extends SuperTestNG {

	public void AccessingCountriesPage() {
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Countries().click();
		Assert.assertEquals(prop.getProperty("countriesURL"), driver.getCurrentUrl());

		String rtext = T.PageTitleText().getText();
		Assert.assertEquals(prop.getProperty("Country"), rtext);
		Assert.assertTrue(T.table().isDisplayed());
	}

	public void VerifyTableTitles() {
		TablesPOM T = new TablesPOM(driver);

		int length = T.Titleslength().size();
		Assert.assertEquals(4, length);

		String Countryid = T.FirstTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("CountryId"), Countryid);

		String Countryname = T.SecondTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("CountryName"), Countryname);

		String Countrycode = T.ThirdTitleofTable().getText();
		Assert.assertEquals(prop.getProperty("CountryCode"), Countrycode);

		String actions = T.FourthTItleofTable().getText();
		Assert.assertEquals(prop.getProperty("Actions"), actions);

	}

	public void NumberofCountries() {
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

		Assert.assertEquals(rcount, Integer.parseInt(prop.getProperty("CountriesCount")));
	}

	public void printandverifyCountrynames() {
		PaginationPOM P = new PaginationPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Countries().click();

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String countrynames = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText();
			names.add(countrynames);
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

		ArrayList<String> Exceldata = new ArrayList<String>();
		int rowcount = Excel.getRowCount(xlPath, sheetname5);

		for (int k = 0; k <= rowcount; k++) {
			String Rolnames = Excel.getCellValue(xlPath, sheetname5, k, 1);
			Exceldata.add(Rolnames);
		}

		if (names.equals(Exceldata)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Missing Countries name---" + names);
		}

	}

	public void printandverifyCountryCode() {
		PaginationPOM P = new PaginationPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);

		H.Countries().click();

		int C = T.tablerows().size();
		int pagination = P.numberpagination().size();

		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= C; i++) {
			String countrynames = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText();
			names.add(countrynames);
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
					String rnames = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[3]")).getText();
					names.add(rnames);
				}
			}
		}

		ArrayList<String> Exceldata = new ArrayList<String>();
		int rowcount = Excel.getRowCount(xlPath, sheetname5);

		for (int k = 0; k <= rowcount; k++) {
			String Rolnames = Excel.getCellValue(xlPath, sheetname5, k, 2);
			Exceldata.add(Rolnames);
		}

		if (names.equals(Exceldata)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Missing Country codes---" + names);
		}


	}

	public void VerifyErrorMessages() {
		CountriesPOM Co = new CountriesPOM(driver);
		TablesPOM T = new TablesPOM(driver);

		T.Createbutton().click();
		Co.Savebutton().click();

		Assert.assertTrue(Co.ErrorMessages().isDisplayed());
		Assert.assertTrue(Co.ErrorMessageNameFieldRequired().isDisplayed());
		Assert.assertTrue(Co.ErrorMessageCodeFieldRequired().isDisplayed());

		Co.Cancelbutton().click();
	}

	public void countrylists() {
		CountriesPOM Co = new CountriesPOM(driver);
		TablesPOM T = new TablesPOM(driver);

//		To print all country name using Arraylist
		ArrayList<String> countries = new ArrayList<String>();
		String[] locales = Locale.getISOCountries();
		for (String country : locales) {
			Locale obj = new Locale("en", country);
			String count = obj.getDisplayCountry();
			countries.add(count);
		}

//			Select Random country name from the printed one arraylist
		Random r = new Random();
		String names = countries.get(r.nextInt(countries.size()));
		

//			Printing ISO code of Selected country
		Map<String, String> country = new HashMap<String, String>();
		for (String iso : Locale.getISOCountries()) {
			Locale l = new Locale("", iso);
			country.put(l.getDisplayCountry(), iso);
		}
		
		if(names.equals("India") && country.get(names).equals("IN")) {
			
			names = countries.get(r.nextInt(countries.size()));
		}

//			 Passing country name and Country code values in to the fields
		Co.CountryNameField().sendKeys(names);
		Co.CountryCodeField().sendKeys(country.get(names));

		Co.SaveORUpdateButton().click();
		String Addedcountry = T.LastRecordName().getText();
		String Addedcountrycode = T.LastRecordEmailidORDesc().getText();

		Assert.assertEquals(names, Addedcountry);
		Assert.assertEquals(country.get(names), Addedcountrycode);
	}

	public void CreateCountries() {
		CountriesPOM Co = new CountriesPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		Countries C = new Countries();
		
		T.Createbutton().click();
		
		String CreateCountryHeading = Co.Createpageheadingtext().getText();
		Assert.assertEquals(prop.getProperty("CreateCountry"), CreateCountryHeading);

		String CreateCountryName = Co.CountryNameLable().getText();
		Assert.assertEquals(prop.getProperty("CreateCountryName"), CreateCountryName);

		String CreateCountryCode = Co.CountryCodeLable().getText();
		Assert.assertEquals(prop.getProperty("CreateCountryCode"), CreateCountryCode);
		
		C.countrylists();

	}

	public void updateCountries() {
		CountriesPOM C = new CountriesPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		Countries Co = new Countries();
		UserspagePOM U = new UserspagePOM(driver);

		int count = T.tablerows().size();
		Assert.assertEquals(count, 2);

		U.Updatelastbutton().click();
		C.UpdateCancelButton().click();
		U.Updatelastbutton().click();

		C.CountryNameField().clear();
		C.CountryCodeField().clear();

		C.updatebutton().click();

		Assert.assertTrue(C.ErrorMessages().isDisplayed());
		Assert.assertTrue(C.ErrorMessageNameFieldRequired().isDisplayed());
		Assert.assertTrue(C.ErrorMessageCodeFieldRequired().isDisplayed());

		Co.countrylists();
	}

	public void DeleteCountries() {
		ModalPOM M = new ModalPOM(driver);
		TablesPOM T = new TablesPOM(driver);
		
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
	}
}
