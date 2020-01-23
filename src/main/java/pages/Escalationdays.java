package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import POM.HomepagePOM;
import POM.TablesPOM;
import POM.ViewOrdersPOM;
import base.SuperTestNG;

public class Escalationdays extends SuperTestNG{
	
	public void EscalationDaysCount() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		TablesPOM T = new TablesPOM(driver);
		ViewOrdersPOM V = new ViewOrdersPOM(driver);
		
		H.WarehouseOrdermenu().click();
		int viewcount = T.allviewbuttons().size();
		System.out.println("Size of view buttons--"+viewcount);
		int threedays = 0;
		int fourdays = 0;
		int fivedays = 0;
		
		for(int i=1; i<=viewcount; i++) {
			H.humbergermenu().click();
//			T.allviewbuttons().get(i).click();
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
					fivedays++;
				}
			}
					
			V.viewbackbutton().click();
		}
		
		System.out.println("Three days--"+threedays);
		System.out.println("Fourd days---"+fourdays);
		System.out.println("five days---"+fivedays);
		
		driver.get(prop.getProperty("EscalationURL"));
		int numberofDocs = driver.findElements(By.cssSelector("tbody > tr")).size();
		
	}

}
