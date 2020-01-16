package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class UppPaymentViewPOM extends SuperTestNG{
	
	@FindBy(css="h1")
	WebElement PageTitle;
	
	@FindBy(xpath="//*[text()='UPP Name']")
	WebElement TitleUppName;
	
	@FindBy(xpath="//*[text()='UPP Name']/following-sibling::input")
	WebElement UppNameField;
	
	@FindBy(xpath="//*[contains(text(), 'UPP No')]")
	WebElement TitleUppNumber;
	
	@FindBy(xpath="//*[contains(text(), 'UPP No')]/following-sibling::input")
	WebElement UppNumberField;
	
	@FindBy(xpath="//*[contains(text(), 'DISTRIBUTOR ID')]")
	WebElement TitleDistributorID;
	
	@FindBy(xpath="//*[contains(text(), 'DISTRIBUTOR ID')]/following-sibling::input")
	WebElement DistributorIDfield;
	
	@FindBy(xpath="//*[contains(text(), 'Amount')]")
	WebElement TitleUppAmount;
	
	@FindBy(xpath="//*[contains(text(), 'Amount')]/following-sibling::input")
	WebElement UppAmountField;
	
	@FindBy(xpath="//*[contains(text(), 'Phone Number')]")
	WebElement TitleUppPhNumber;
	
	@FindBy(xpath="//*[contains(text(), 'Phone Number')]/following-sibling::input")
	WebElement UppPhoneNumberField;
	
	@FindBy(xpath="//*[contains(text(), 'Email')]")
	WebElement TitleUppEmail;
	
	@FindBy(xpath="//*[contains(text(), 'Email')]/following-sibling::input")
	WebElement UppEmailField;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order ID')]")
	WebElement TitleUPPOrderID;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order ID')]/following-sibling::input")
	WebElement UPPOrderID;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order Status')]")
	WebElement TitleUPPOrderStatus;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order Status')]/following-sibling::input")
	WebElement UPPOrderStatus;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order Date')]")
	WebElement TitleUPPOrderDate;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Order Date')]/following-sibling::input")
	WebElement UPPOrderDate;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Modified Date')]")
	WebElement TitleUPPModifiedDate;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Modified Date')]/following-sibling::input")
	WebElement UPPModifiedDate;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Response Data')]")
	WebElement TitleUPPResponseData;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Response Data')]/following-sibling::textarea")
	WebElement UPPResponseData;
	
	@FindBy(xpath="//*[contains(text(), 'Download uploaded excel')]")
	WebElement TitleDownloadUploadedlinkTitle;
	
	@FindBy(xpath="//*[contains(text(), 'Download uploaded excel')]/following-sibling::span/a")
	WebElement DownloadUploadedlink;
	
	@FindBy(css="a[class*='btn btn-primary']")
	WebElement Backbutton;
	
	public UppPaymentViewPOM(WebDriver driver) {
		UppPaymentViewPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PageTitle() {
		return PageTitle;
	}
	
	public WebElement TitleUppName() {
		return TitleUppName;
	}
	
	public WebElement UppNameField() {
		return UppNameField;
	}
	
	public WebElement TitleUppNumber() {
		return TitleUppNumber;
	}
	
	public WebElement UppNumberField() {
		return UppNumberField;
	}
	
	public WebElement TitleDistributorID() {
		return TitleDistributorID;
	}
	
	public WebElement DistributorIDfield() {
		return DistributorIDfield;
	}
	
	public WebElement TitleUppAmount() {
		return TitleUppAmount;
	}
	
	public WebElement UppAmountField() {
		return UppAmountField;
	}
	
	public WebElement TitleUppPhNumber() {
		return TitleUppPhNumber;
	}
	
	public WebElement UppPhoneNumberField() {
		return UppPhoneNumberField;
	}
	
	public WebElement TitleUppEmail() {
		return TitleUppEmail;
	}
	
	public WebElement UppEmailField() {
		return UppEmailField;
	}
	
	public WebElement TitleUPPOrderID() {
		return TitleUPPOrderID;
	}
	
	public WebElement UPPOrderID() {
		return UPPOrderID;
	}
	
	public WebElement TitleUPPOrderStatus() {
		return TitleUPPOrderStatus;
	}
	
	public WebElement UPPOrderStatus() {
		return UPPOrderStatus;
	}
	
	public WebElement TitleUPPOrderDate() {
		return TitleUPPOrderDate;
	}
	
	public WebElement UPPOrderDate() {
		return UPPOrderDate;
	}
	
	public WebElement TitleUPPModifiedDate() {
		return TitleUPPModifiedDate;
	}
	
	public WebElement UPPModifiedDate() {
		return UPPModifiedDate;
	}
	
	public WebElement TitleUPPResponseData() {
		return TitleUPPResponseData;
	}
	
	public WebElement UPPResponseData() {
		return UPPResponseData;
	}
	
	public WebElement TitleDownloadUploadedlinkTitle() {
		return TitleDownloadUploadedlinkTitle;
	}
	
	public WebElement DownloadUploadedlink() {
		return DownloadUploadedlink;
	}
	
	public WebElement Backbutton() {
		return Backbutton;
	}

}
