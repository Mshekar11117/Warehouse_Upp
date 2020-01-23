package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.TablesPOM;
import POM.UpdateOrderPOM;
import POM.ViewOrdersPOM;
import POM.escalationPOM;
import base.SuperTestNG;

public class Escalationdays extends SuperTestNG{
	
	public void ChangethreeDayAndStatus() throws InterruptedException {
		HomepagePOM H = new HomepagePOM(driver);
		UpdateOrderPOM U = new UpdateOrderPOM(driver);
	
		
		H.WarehouseOrdermenu().click();
		
		for(int i=1; i<=2; i++) {
			
			H.humbergermenu().click();
			driver.findElement(By.xpath("//tbody/tr[" + i +"]/td/a[2]")).click();
			
			LocalDate t = LocalDate.now();
			String today = t.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			
			LocalDate threeday = LocalDate.now().minusDays(3);
			String strDatethree = threeday.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			
			U.InvoiceDate().clear();
			Thread.sleep(1000);
			U.InvoiceDate().sendKeys(strDatethree);
			
			U.InvWHReceiptsDate().clear();
			Thread.sleep(1000);
			U.InvWHReceiptsDate().sendKeys(strDatethree);
			
			U.dispatchdatefromwh().clear();
			Thread.sleep(1000);
			U.dispatchdatefromwh().sendKeys(strDatethree);
			
			U.expecteddateofdelivery().clear();
			Thread.sleep(1000);
			U.expecteddateofdelivery().sendKeys(strDatethree);
			
			Select select = new Select(U.SelectStatus());
			select.selectByIndex(1);
			
			U.actualdeliverydate().clear();
			Thread.sleep(1000);
			U.actualdeliverydate().sendKeys(today);
			
			U.updatebutton().click();
		}
		
	}
	
	
	public void ChangefourDayAndStatus() throws InterruptedException {
		HomepagePOM H = new HomepagePOM(driver);
		UpdateOrderPOM U = new UpdateOrderPOM(driver);
		
		H.WarehouseOrdermenu().click();
		
		for(int i=3; i<=5; i++) {
			
			H.humbergermenu().click();
			driver.findElement(By.xpath("//tbody/tr[" + i +"]/td/a[2]")).click();
			
			LocalDate t = LocalDate.now();
			String today = t.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			
			LocalDate fourday = LocalDate.now().minusDays(4);
			String strDatethree = fourday.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			
			U.InvoiceDate().clear();
			Thread.sleep(1000);
			U.InvoiceDate().sendKeys(strDatethree);
			
			U.InvWHReceiptsDate().clear();
			Thread.sleep(1000);
			U.InvWHReceiptsDate().sendKeys(strDatethree);
			
			U.dispatchdatefromwh().clear();
			Thread.sleep(1000);
			U.dispatchdatefromwh().sendKeys(strDatethree);
			
			U.expecteddateofdelivery().clear();
			Thread.sleep(1000);
			U.expecteddateofdelivery().sendKeys(strDatethree);
			
			Select select = new Select(U.SelectStatus());
			select.selectByIndex(1);
			
			U.actualdeliverydate().clear();
			Thread.sleep(1000);
			U.actualdeliverydate().sendKeys(today);
			
			U.updatebutton().click();
		}
		
	}
	
	public void EscalationDaysCount() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);
		ViewOrdersPOM V = new ViewOrdersPOM(driver);
		escalationPOM E = new escalationPOM(driver);
		
		H.WarehouseOrdermenu().click();
		int viewcount = T.allviewbuttons().size();
		System.out.println("Size of view buttons--"+viewcount);
		int threedays = 0;
		int fourdays = 0;
		int moredays = 0;
		
		for(int i=1; i<=viewcount; i++) {
			H.humbergermenu().click();

			driver.findElement(By.xpath("//tbody/tr[" + i +"]/td[14]/a[1]")).click();
			String status = V.Status().getAttribute("placeholder").toLowerCase();
			
			if(!(status.equals("delivered")||status.equals("rto"))) {
				String order = V.Ordernumber().getAttribute("placeholder");
				System.out.println("Order Number---"+order);
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				
				String d = V.DispatchDateFromWH().getAttribute("placeholder");
				Date dispatachdate = formatter.parse(d);
				Date currentdate = new Date();
							
				long diff = currentdate.getTime() - dispatachdate.getTime();
				long dd = TimeUnit.MILLISECONDS.toDays(diff);
				
				String date = String.valueOf(dd);
				System.out.println("Difference of days--"+date);
				
				long diffDays = diff / (24 * 60 * 60 * 1000);
				System.out.println(diffDays);
				if(diffDays >= 3 && diffDays < 4) {
					threedays++;
				} else if(diffDays >=4 && diffDays < 5) {
					fourdays++;
				} else if (diffDays >= 5) {
					moredays++;
				}
			}
					
			V.viewbackbutton().click();
		}
		
		System.out.println("Three days--"+threedays);
		System.out.println("Fourd days---"+fourdays);
		System.out.println("five days---"+moredays);
		
		driver.get(prop.getProperty("EscalationURL"));
		
		int threedayswebtable = E.threedayswebtable().size();
		int fourdayswebtable = E.fourdayswebtable().size();
		int moredayswebtable = E.morethanfourdayswebtable().size()-1;
		
		Assert.assertEquals(threedays, threedayswebtable);
		Assert.assertEquals(fourdays, fourdayswebtable);
		Assert.assertEquals(moredays, moredayswebtable);
		
	}

}
