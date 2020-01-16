package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class HomepagePOM extends SuperTestNG{
	
	public WebDriver driver;

	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement userprofilename;
	
	@FindBy(xpath="//div[@class='profile_info']/h2")
	WebElement profilename;
	
	@FindBy(xpath="//div[@class='warehouse_access']/strong/following-sibling::text()")
	WebElement Access;
	
	@FindBy(xpath="//*[text() = 'All']")
	WebElement AccessAll;
	
	@FindBy(xpath="//div[@class='warehouse_access']")
	WebElement accesstext;
	
	@FindBy(xpath="//div[@class='warehouse_access']/strong")
	WebElement whaccess;
	
	@FindBy(xpath="//div[@class='profile_info']/span")
	WebElement welcomtext;
	
	@FindBy(css="ul.nav.side-menu>li")
	List<WebElement> leftsidemenus;
	
	@FindBy(xpath="//ul[@class='nav side-menu']/li[1]")
	WebElement WarehouseOrdermenu;
	
	@FindBy(xpath="//*[contains(text(),'Kyc')]")
	WebElement kycmenu;
	
//	@FindBy(xpath="//ul[@class='nav side-menu']/li[3]/a")
	@FindBy(css="ul > li:nth-child(3) > a")
	WebElement Usersmenu;
	
	@FindBy(xpath="//ul[@class='nav side-menu']/li[4]")
	WebElement Rolesmenu;
	
	@FindBy(xpath="//ul[@class='nav side-menu']/li[5]")
	WebElement Permission;
	
	@FindBy(xpath="//ul[@class='nav side-menu']/li[6]")
	WebElement Warehousenames;
	
	@FindBy(xpath="//ul[@class='nav side-menu']/li[7]")
	WebElement Countries;
	
/*	@FindBy(xpath="//ul[@class='nav side-menu']/li[8]")
	WebElement Smstemplate;*/
	
	@FindBy(xpath="//*[text()='SMS Templates']")
	WebElement Smstemplate;
	
	@FindBy(xpath="//div[@class='profile']")
	WebElement profilediv;
	
	@FindBy(css="a#menu_toggle > i")
	WebElement humbergermenu;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement logindropdown;
	
	@FindBy(xpath="//li[@class='open']/ul/li[1]")
	WebElement changepassword;
	
	@FindBy(xpath="//li[@class='open']/ul/li[2]")
	WebElement Logout;
	
	@FindBy(css="a#sendsms")
	WebElement SendSMSbutton;
	
	@FindBy(linkText="UPP Distributors")
	WebElement UppDistributor;
	
	@FindBy(linkText="UPP Payments")
	WebElement UppPayment;
	
	@FindBy(xpath="//*[text()='Import Order']")
	WebElement ImportOrder;
	
	@FindBy(xpath="//*[text()='Create Order']")
	WebElement CreateOrder;
	
	@FindBy(css="div.row > div > h2")
	WebElement WarehouseOrderText;
	
	public HomepagePOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement userprofilename() {
		return userprofilename;
	}
	
	public WebElement profilename() {
		return profilename;
	}
	
	public WebElement Access() {
		return Access;
	}
	
	public WebElement AccessAll() {
		return AccessAll;
	}
	
	public WebElement accesstext() {
		return accesstext;
	}
	
	public WebElement welcomtext() {
		return welcomtext;
	}
	
	public WebElement whaccess() {
		return whaccess;
	}
	
	public List<WebElement> leftsidemenus() {
		return leftsidemenus;
	}
	
	public WebElement WarehouseOrdermenu() {
		return WarehouseOrdermenu;
	}
	
	public WebElement kycmenu() {
		return kycmenu;
	}
	
	public WebElement usersmenu() {
		return Usersmenu;
	}
	
	public WebElement Rolesmenu() {
		return Rolesmenu;
	}
	
	public WebElement Permission() {
		return Permission;
	}
	
	public WebElement Warehousenames() {
		return Warehousenames;
	}
	
	public WebElement Countries() {
		return Countries;
	}
	
	public WebElement Smstemplate() {
		return Smstemplate;
	}
	
	public WebElement profilediv() {
		return profilediv;
	}
	
	public WebElement humbergermenu() {
		return humbergermenu;
	}
	
	
	public WebElement logindropdown() {
		return logindropdown;
	}
	
	public WebElement changepassword() {
		return changepassword;
	}
	
	public WebElement getLogout() {
		return Logout;
	}
	
	public WebElement SendSMSbutton() {
		return SendSMSbutton;
	}
	
	public WebElement UppDistributor() {
		return UppDistributor;
	}
	
	public WebElement UppPayment() {
		return UppPayment;
	}
	
	public WebElement ImportOrder() {
		return ImportOrder;
	}
	
	public WebElement CreateOrder() {
		return CreateOrder;
	}
	
	public WebElement WarehouseOrderText() {
		return WarehouseOrderText;
	}
}
