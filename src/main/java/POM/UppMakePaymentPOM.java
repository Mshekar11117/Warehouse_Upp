package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class UppMakePaymentPOM extends SuperTestNG {
	
	@FindBy(css="h1")
	WebElement MakePaymentTitle;
	
	@FindBy(css="#sidebar-menu")
	WebElement LefthandSideMenu;
	
	@FindBy(css=".left_col.scroll-view > .navbar.nav_title > a > span")
	WebElement UnicityLogo;
	
	@FindBy(css=".nav.side-menu > li")
	WebElement TotalNumberofLeftHandMenus;
	
	@FindBy(css=".nav.side-menu > li:first-child")
	WebElement UppPaymentmenu;
	
	@FindBy(partialLinkText="About US")
	WebElement AboutUS;
	
	@FindBy(partialLinkText="Contact US")
	WebElement ContactUS;
	
	@FindBy(partialLinkText="Terms and Conditions")
	WebElement TermsandConditions;
	
	@FindBy(partialLinkText="Policies & Procedures")
	WebElement PoliciesProcedures;
	
	@FindBy(css="div[class='input-group'] > input")
	List<WebElement> TotalNumberofInputFields;
	
	@FindBy(css=".help-block")
	List<WebElement> TotalNumberofHelpblocks;
	
	@FindBy(id="upp_name")
	WebElement UppNameField;
	
	@FindBy(xpath="//input[@id='upp_name']/preceding-sibling::span")
	WebElement TitleUppName;
	
	@FindBy(xpath="//input[@id='upp_name']/parent::div/following-sibling::p")
	WebElement HelpUppName;
	
	@FindBy(xpath="//input[@id='upp_name']/parent::div/following-sibling::span")
	WebElement ErrorUppName;
	
	@FindBy(id="upp_no")
	WebElement UppNumberField;
	
	@FindBy(xpath="//input[@id='upp_no']/preceding-sibling::span")
	WebElement TitleUppNumber;
	
	@FindBy(xpath="//input[@id='upp_no']/parent::div/following-sibling::p")
	WebElement HelpUppNumber;
	
	@FindBy(xpath="//input[@id='upp_no']/parent::div/following-sibling::span")
	WebElement ErrorUppNumber;
	
	@FindBy(id="kyc_dist_id")
	WebElement DistributorID;
	
	@FindBy(xpath="//input[@id='kyc_dist_id']/preceding-sibling::span")
	WebElement TitleDistID;
	
	@FindBy(xpath="//input[@id='kyc_dist_id']/parent::div/following-sibling::p")
	WebElement HelpDistID;
	
	@FindBy(xpath="//input[@id='kyc_dist_id']/parent::div/following-sibling::span")
	WebElement ErrorDistID;
	
	@FindBy(css="input[id*='upp_amount']")
	WebElement Amount;
	
	@FindBy(xpath="//input[@name='upp_amount']/preceding-sibling::span")
	WebElement TitleAmount;
	
	@FindBy(xpath="//input[@name='upp_amount']/parent::div/following-sibling::p")
	WebElement HelpAmount;
	
	@FindBy(xpath="//input[@name='upp_amount']/parent::div/following-sibling::span")
	WebElement ErrorAmount;
	
	@FindBy(name="upp_dist_phone")
	WebElement UppDistPhone;
	
	@FindBy(xpath="//input[@name='upp_dist_phone']/preceding-sibling::span")
	WebElement TitleUppDistPhone;
	
	@FindBy(xpath="//input[@name='upp_dist_phone']/parent::div/following-sibling::p")
	WebElement HelpUppDistPhone;
	
	@FindBy(xpath="//input[@name='upp_dist_phone']/parent::div/following-sibling::span")
	WebElement ErrorUppDistPhone;
	
	@FindBy(css="#upp_dist_email")
	WebElement EmailField;
	
	@FindBy(xpath="//input[@name='upp_dist_email']/preceding-sibling::span")
	WebElement TitleEmailField;
	
	@FindBy(xpath="//input[@name='upp_dist_email']/parent::div/following-sibling::p")
	WebElement HelpEmail;
	
	@FindBy(xpath="//input[@name='upp_dist_email']/parent::div/following-sibling::span")
	WebElement ErrorEmail;
	
	@FindBy(css=".control-label.text-right")
	WebElement HelpUploadExcel;
	
	@FindBy(css="#upp_ordersheet_upload")
	WebElement UploadUppOrderSheet;
	
	@FindBy(css="input[id='submitbutton']")
	WebElement MakePaymentButton;
	
	@FindBy(css="input[id='submitbutton'] + a")
	WebElement Backbtn;
	
	@FindBy(css=".fa.fa-bars")
	WebElement HumbergerMenu;
	
	@FindBy(css=".error")
	List<WebElement> TotalNumberofErrorMessages;
	
	@FindBy(xpath="//tbody/tr/td[6]")
	List<WebElement> ColumnUppName;
	
	@FindBy(xpath="//tbody/tr/td[4]")
	List<WebElement> ColumnUppNo;
	
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> ColumnDistid;
	
	@FindBy(css=".alert.alert-danger")
	WebElement erroralert;
	
	@FindBy(css=".alert.alert-danger")
	List<WebElement> erroralerts;
	
	public UppMakePaymentPOM(WebDriver driver) {
		UppMakePaymentPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement MakePaymentTitle() {
		return MakePaymentTitle;
	}
	
	public WebElement LefthandSideMenu() {
		return LefthandSideMenu;
	}
	
	public WebElement UnicityLogo() {
		return UnicityLogo;
	}
	
	public WebElement TotalNumberofLeftHandMenus() {
		return TotalNumberofLeftHandMenus;
	}
	
	public WebElement UppPaymentmenu() {
		return UppPaymentmenu;
	}
	
	public WebElement AboutUS() {
		return AboutUS;
	}
	
	public WebElement ContactUS() {
		return ContactUS;
	}
	
	public WebElement TermsandConditions() {
		return TermsandConditions;
	}
	
	public WebElement PoliciesProcedures() {
		return PoliciesProcedures;
	}
	
	public List<WebElement> TotalNumberofInputFields() {
		return TotalNumberofInputFields;
	}
	
	public List<WebElement> TotalNumberofHelpblocks(){
		return TotalNumberofHelpblocks;
	}
	
	public WebElement UppNameField() {
		return UppNameField;
	}
	
	public WebElement TitleUppName() {
		return TitleUppName;
	}
	
	public WebElement HelpUppName() {
		return HelpUppName;
	}
	
	public WebElement ErrorUppName() {
		return ErrorUppName;
	}
	
	public WebElement UppNumberField() {
		return UppNumberField;
	}
	
	public WebElement TitleUppNumber() {
		return TitleUppNumber;
	}
	
	public WebElement HelpUppNumber() {
		return HelpUppNumber;
	}
	
	public WebElement ErrorUppNumber() {
		return ErrorUppNumber;
	}
	
	public WebElement DistributorID() {
		return DistributorID;
	}
	
	public WebElement TitleDistID() {
		return TitleDistID;
	}
	
	public WebElement HelpDistID() {
		return HelpDistID;
	}
	
	public WebElement ErrorDistID() {
		return ErrorDistID;
	}
	
	public WebElement Amount() {
		return Amount;
	}
	
	public WebElement TitleAmount() {
		return TitleAmount;
	}
	
	public WebElement HelpAmount() {
		return HelpAmount;
	}
	
	public WebElement ErrorAmount() {
		return ErrorAmount;
	}
	
	public WebElement UppDistPhone() {
		return UppDistPhone;
	}
	
	public WebElement TitleUppDistPhone() {
		return TitleUppDistPhone;
	}
	
	public WebElement HelpUppDistPhone() {
		return HelpUppDistPhone;
	}
	
	public WebElement ErrorUppDistPhone() {
		return ErrorUppDistPhone;
	}
	
	public WebElement EmailField() {
		return EmailField;
	}
	
	public WebElement TitleEmailField() {
		return TitleEmailField;
	}
	
	public WebElement HelpEmail() {
		return HelpEmail;
	}
	
	public WebElement ErrorEmail() {
		return ErrorEmail;
	}
	
	public WebElement HelpUploadExcel() {
		return HelpUploadExcel;
	}
	
	public WebElement UploadUppOrderSheet() {
		return UploadUppOrderSheet;
	}
	
	public WebElement MakePaymentButton() {
		return MakePaymentButton;
	}
	
	public WebElement Backbtn() {
		return Backbtn;
	}
	
	public WebElement HumbergerMenu() {
		return HumbergerMenu;
	}
	
	public List<WebElement> TotalNumberofErrorMessages() {
		return TotalNumberofErrorMessages;
	}
	
	public List<WebElement> ColumnUppName() {
		return ColumnUppName;
	}
	
	public List<WebElement> ColumnUppNo() {
		return ColumnUppNo;
	}
	
	public List<WebElement> ColumnDistid() {
		return ColumnDistid;
	}
	
	public WebElement erroralert() {
		return erroralert;
	}
	
	public List<WebElement> erroralerts() {
		return erroralerts;
	}

}
