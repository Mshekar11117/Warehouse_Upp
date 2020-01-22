package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM.HomepagePOM;
import POM.ModalPOM;
import POM.WHTablesPOM;
import base.SuperTestNG;
import POM.UpdateOrderPOM;

public class SendSMS extends SuperTestNG{
	
	public void VerifySMSModal() {
		HomepagePOM H = new HomepagePOM(driver);
		ModalPOM M = new ModalPOM(driver);
				
		WebElement SMSbutton = H.SendSMSbutton();
		
		SMSbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(M.SMSmodal()));
		
		Assert.assertTrue(M.SMSmodal().isDisplayed());
		String text = M.SMSmodalTitle().getText();
		Assert.assertEquals(text, prop.getProperty("SMSsuccesstitle"));
		String Warning = M.SMSModalWarrningmessage().getText();
		Assert.assertEquals(Warning, prop.getProperty("SMSwarningMessage"));
		M.SMSModalClose().click();
		
		wait.until(ExpectedConditions.invisibilityOf(M.SMSmodal()));
		SMSbutton.click();
		M.SMSModalclosebutton().click();
	}
	
	public void SMSsend() throws Exception {
		WHTablesPOM T = new WHTablesPOM(driver);
		ModalPOM M = new ModalPOM(driver);
		UpdateOrderPOM U = new UpdateOrderPOM(driver);
		HomepagePOM H = new HomepagePOM(driver);
				
		driver.navigate().refresh();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(T.firstactionedit()));
		
		T.firstactionedit().click();
		U.DistributorPhone().clear();
		U.DistributorPhone().sendKeys(prop.getProperty("phonenumber"));
		U.updatebutton().click();
		
		
		wait.until(ExpectedConditions.visibilityOf(H.SendSMSbutton()));
		
		T.firstcheckbox().click();
//		String Records = T.numberofselectedrecords().getText().substring(0, 2);
		H.SendSMSbutton().click();
		
		wait.until(ExpectedConditions.visibilityOf(M.SMSmodal()));
		
		Assert.assertTrue(M.SMSmodal().isDisplayed());
		String text = M.SMSmodalTitle().getText();
		Assert.assertEquals(text, prop.getProperty("SMSsuccesstitle"));
		
		wait.until(ExpectedConditions.visibilityOf(M.SMSsentfailed()));
		String total = M.Totalordersselected().getText();
		Assert.assertEquals(prop.getProperty("SMSsuccesstotalorder"), total);
		String selected = M.Ordersalreadydelivered().getText();
		Assert.assertEquals(prop.getProperty("SMSsuccessAlreadydelivered"), selected);
		String sent = M.SMSsentsuccessfully().getText();
		Assert.assertEquals(prop.getProperty("SMSsuccessSent"), sent);
		String sentfailed = M.SMSsentfailed().getText();
		Assert.assertEquals(prop.getProperty("SMSsuccessFailed"), sentfailed);
		Thread.sleep(1000);
		Assert.assertTrue(M.SMSorderdetails().isDisplayed());

		
	}
}