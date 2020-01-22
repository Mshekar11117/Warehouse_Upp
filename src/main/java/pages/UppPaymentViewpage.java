package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.UppPaymentViewPOM;
import POM.uppPaymentPOM;
import POM.uppPaymentTablePOM;
import base.SuperTestNG;

public class UppPaymentViewpage extends SuperTestNG{
	
	public void AccessUppPaymentViewModel() {
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		UppPaymentViewPOM uv = new UppPaymentViewPOM(driver);
		
		ut.firstviewbutton().click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		String uppviewtitle = uv.PageTitle().getText();
		Assert.assertEquals(prop.getProperty("UppPaymentViewPageTitle"), uppviewtitle);
	}
	
	public void verifyTitleNames() {
		UppPaymentViewPOM uv = new UppPaymentViewPOM(driver);
		
		String uppname = uv.TitleUppName().getText();
		Assert.assertEquals(prop.getProperty("viewlabelUPPName"), uppname);
		
		String uppno = uv.TitleUppNumber().getText();
		Assert.assertEquals(prop.getProperty("viewlabelUPPNo"), uppno);
		
		String Distid = uv.TitleDistributorID().getText();
		Assert.assertEquals(prop.getProperty("viewlabelDISTRIBUTORID"), Distid);
		
		String phoneno = uv.TitleUppPhNumber().getText();
		Assert.assertEquals(prop.getProperty("viewPhoneNumber"), phoneno);
		
		String email = uv.TitleUppEmail().getText();
		Assert.assertEquals(prop.getProperty("viewEmail"), email);
		
		String UppOrderId = uv.TitleUPPOrderID().getText();
		Assert.assertEquals(prop.getProperty("viewUPPOrderID"), UppOrderId);
		
		String UppOrderStatus = uv.TitleUPPOrderStatus().getText();
		Assert.assertEquals(prop.getProperty("viewUPPOrderStatus"), UppOrderStatus);
		
		String UppOrderdate = uv.TitleUPPOrderDate().getText();
		Assert.assertEquals(prop.getProperty("viewUPPOrderDate"), UppOrderdate);
		
		String UppModifieddate = uv.TitleUPPModifiedDate().getText();
		Assert.assertEquals(prop.getProperty("viewUPPModifiedDate"), UppModifieddate);
		
		String UppResponseData = uv.TitleUPPResponseData().getText();
		Assert.assertEquals(prop.getProperty("viewUPPResponseData"), UppResponseData);
	}
	
	public void BacktoParenttab() {
		UppPaymentViewPOM uv = new UppPaymentViewPOM(driver);
		
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		uv.Backbutton().click();
		driver.close();
		driver.switchTo().window(parent);
	}
	
	public void ViewInitiatedStatus() throws Exception {
		uppPaymentPOM u = new uppPaymentPOM(driver);
		uppPaymentTablePOM ut = new uppPaymentTablePOM(driver);
		UppPaymentViewPOM uv = new UppPaymentViewPOM(driver);
		HomepagePOM h = new HomepagePOM(driver);
		
		h.UppPayment().click();

		Select select = new Select(u.SearchUppOrderStatus());
		select.selectByIndex(5);
		u.Searchbutton().click();
		Thread.sleep(1000);
		
		ut.firstviewbutton().click();
		
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		String updatemoditied = uv.UPPModifiedDate().getAttribute("value").trim();
		Assert.assertTrue(updatemoditied.equals(""));
		
		String uppresponse = uv.UPPResponseData().getText().trim();
		System.out.println("uppresponse---"+uppresponse);
		Assert.assertTrue(uppresponse.equals("."));
		
		Set<String> id1 = driver.getWindowHandles();
		Iterator<String> it1 = id1.iterator();
		String parent1 = it1.next();
		String child1 = it1.next();
		driver.close();
		driver.switchTo().window(parent1);
	}

}
