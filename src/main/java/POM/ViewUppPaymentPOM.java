package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class ViewUppPaymentPOM extends SuperTestNG{
	
	@FindBy(css="h1")
	WebElement pageTitle;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Name')]")
	WebElement lableuppname;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Name')]/following-sibling::input")
	WebElement uppnamefieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'UPP No')]")
	WebElement labeluppnumber;
	
	@FindBy(xpath="//*[contains(text(), 'UPP No')]/following-sibling::input")
	WebElement uppnumberfieldvalue;
	
	@FindBy(xpath="//*[contains(text(), ''DISTRIBUTOR ID')]")
	WebElement labelDistid;
	
	@FindBy(xpath="//*[contains(text(), ''DISTRIBUTOR ID')]/following-sibling::input")
	WebElement Distidfieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'Amount')]")
	WebElement labelAmount;
	
	@FindBy(xpath="//*[contains(text(), 'Amount')]/following-sibling::input")
	WebElement Amountfieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'Phone Number')]")
	WebElement labelphonenumber;
	
	@FindBy(xpath="//*[contains(text(), 'Phone Number')]/following-sibling::input")
	WebElement phonenumberfieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'Email')]")
	WebElement labelEmail;
	
	@FindBy(xpath="//*[contains(text(), 'Email')]/following-sibling::input")
	WebElement Emailfieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order ID')]")
	WebElement labeluppOrderId;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order ID')]/following-sibling::input")
	WebElement UppOrderDistIdfieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order Status')]")
	WebElement labelUPPOrderStatus;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order Status')]/following-sibling::input")
	WebElement UPPOrderStatus;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order Date')]")
	WebElement labelUPPOrderDate;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order Date')]/following-sibling::input")
	WebElement UPPOrderDatefieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Modified Date')]")
	WebElement labelUPPModifiedDate;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Modified Date')]/following-sibling::input")
	WebElement UPPModifiedDatefieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'Download uploaded excel')]")
	WebElement labelDownloaduploadedexcel;
	
	@FindBy(xpath="//*[contains(text(), 'Download uploaded excel')]/following-sibling::span/a")
	WebElement Downloaduploadedexcelfieldvalue;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Response Data')]")
	WebElement labelUPPResponseData;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Response Data')]/following-sibling::input")
	WebElement UPPResponseDatafieldvalue;
	
	@FindBy (css="a.btn.btn-primary")
	WebElement backbutton;
	
	public ViewUppPaymentPOM(WebDriver driver) {
		ViewUppPaymentPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement pageTitle() {
		return pageTitle;
	}
	
	public WebElement lableuppname() {
		return lableuppname;
	}
	
	public WebElement uppnamefieldvalue() {
		return uppnamefieldvalue;
	}
	
	public WebElement labeluppnumber() {
		return labeluppnumber;
	}
	
	public WebElement uppnumberfieldvalue() {
		return uppnumberfieldvalue;
	}
	
	public WebElement labelDistid() {
		return labelDistid;
	}
	
	public WebElement Distidfieldvalue() {
		return Distidfieldvalue;
	}
	
	public WebElement labelAmount() {
		return labelAmount;
	}
	
	public WebElement Amountfieldvalue() {
		return Amountfieldvalue;
	}
	
	public WebElement labelphonenumber() {
		return labelphonenumber;
	}
	
	public WebElement phonenumberfieldvalue() {
		return phonenumberfieldvalue;
	}
	
	public WebElement labelEmail() {
		return labelEmail;
	}
	
	public WebElement Emailfieldvalue() {
		return Emailfieldvalue;
	}
	
	public WebElement labeluppOrderId() {
		return labeluppOrderId;
	}
	
	public WebElement UppOrderDistIdfieldvalue() {
		return UppOrderDistIdfieldvalue;
	}
	
	public WebElement labelUPPOrderStatus() {
		return labelUPPOrderStatus;
	}
	
	public WebElement UPPOrderStatus() {
		return UPPOrderStatus;
	}
	
	public WebElement labelUPPOrderDate() {
		return labelUPPOrderDate;
	}
	
	public WebElement UPPOrderDatefieldvalue() {
		return UPPOrderDatefieldvalue;
	}
	
	public WebElement labelUPPModifiedDate() {
		return labelUPPModifiedDate;
	}
	
	public WebElement UPPModifiedDatefieldvalue() {
		return UPPModifiedDatefieldvalue;
	}
	
	public WebElement labelDownloaduploadedexcel() {
		return labelDownloaduploadedexcel;
	}
	
	public WebElement Downloaduploadedexcelfieldvalue() {
		return Downloaduploadedexcelfieldvalue;
	}
	
	public WebElement labelUPPResponseData() {
		return labelUPPResponseData;
	}
	
	public WebElement UPPResponseDatafieldvalue() {
		return UPPResponseDatafieldvalue;
	}
	
	public WebElement backbutton() {
		return backbutton;
	}
}
