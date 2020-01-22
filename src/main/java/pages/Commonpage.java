package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import POM.CommonPOM;
import base.SuperTestNG;

public class Commonpage extends SuperTestNG {

	public void printlinksinconsole() {
		CommonPOM c = new CommonPOM(driver);
		int linkcount = c.links().size();
		System.out.println("link count---" + linkcount);
		for (int i = 0; i < linkcount; i++) {
			String alllinks = c.links().get(i).getText();
			System.out.println(alllinks);
		}
	}

	public void printlinksinexcel() throws Exception {
		CommonPOM C = new CommonPOM(driver);
		int linkcount = C.links().size();
		FileInputStream fis = new FileInputStream(xlPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet2");
		for (int i = 0; i < linkcount; i++) {
			String alllinks = C.links().get(i).getText().trim();
			s.createRow(i).createCell(0).setCellValue(alllinks);
		}
		FileOutputStream fos = new FileOutputStream(xlPath);
		wb.write(fos);
		fos.close();
	}

	public void verifylink(String Urllink) throws Exception {
		try {
			URL link = new URL(Urllink);
			HttpURLConnection httpcon = (HttpURLConnection) link.openConnection();
			httpcon.setConnectTimeout(2000);
			httpcon.connect();
			if (httpcon.getResponseCode() == 200) {
				System.out.println(Urllink + " " + httpcon.getResponseMessage());
			}
			if (httpcon.getResponseCode() == 400) {
				System.out.println(Urllink + " " + httpcon.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	Not using this method because links count keep changing as per the Created order or uploaded order	
	public void linksize() {
		CommonPOM C = new CommonPOM(driver);
		int linkcount = C.links().size();
		Assert.assertEquals(linkcount, Integer.parseInt(prop.getProperty("linkcount")));
	}
	
	public void brokenlink() throws Exception {
		CommonPOM C = new CommonPOM(driver);
		int linkcount = C.links().size();
		for (int i = 0; i < linkcount; i++) {
			WebElement element = C.links().get(i);
			String URL = element.getAttribute("href");
			verifylink(URL);
		}
	}
	
	public static List<WebElement> findAllLinks(WebDriver driver) {
		List<WebElement> elementList = new ArrayList<WebElement>();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		
		List<WebElement> finalList  = new ArrayList<WebElement>();
		for(WebElement element : elementList) {
			if(element.getAttribute("href")!=null) {
				finalList.add(element);
			}
		}
		
		return finalList;
	}
	
	public static String isLinkBroken(URL url) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			return response;
		} catch (Exception exp) {
			return exp.getMessage();
		}

	}
	
	public void FindLinksAndVerifyBrokenlinks() {
		List<WebElement> allimages = findAllLinks(driver);
		System.out.println("Total number of elements found " + allimages.size());
		 for( WebElement element : allimages){
		    	try
		    	{
			        System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		    		System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		    	} catch(Exception exp)
		    	{
		    		System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());	    		
		    	}
		 }
	}

}
