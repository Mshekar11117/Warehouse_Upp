package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class PaymentGatewayPOM extends SuperTestNG{
	
	@FindBy(css=".webstore-name-text")
	WebElement PageTitle;
	
	@FindBy(css="#netBankingBank")
	WebElement SelectBankdropdown;
	
	@FindBy(css="#netBankingBank > option")
	WebElement SelectBankOptions;
	
	@FindBy(css=".orderTotal.highlight-text")
	WebElement TotalAmountPayable;
	
	@FindBy(css="#SubmitBillShip")
	WebElement Makepaymentbutton;
	
	@FindBy(css="#SubmitBillShip + a")
	WebElement Cancelbutton;
	
	@FindBy(css="#ordertotal > div:first-child")
	WebElement textorderdetails;
	
	@FindBy(css=".order-value")
	WebElement OrderNumber;
	
	@FindBy(css="#amount > span > strong")
	WebElement underbacnkselectionAmount;
	
	@FindBy(css=".pull-left")
	WebElement textordernumber;
	
	@FindBy(css="#orderAmt")
	WebElement OrderAmount;
	
	@FindBy(xpath="(//*[contains(text(),'Order')])[3]")
	WebElement textorderAmount;
	
	@FindBy(css="#finalTotal")
	WebElement finalamount;
	
	@FindBy(css="#grandtotal > div:first-child")
	WebElement texttotalamount;
	
	@FindBy(css="#netBankingBank + label")
	WebElement ErrorSelectBank;
	
	public PaymentGatewayPOM(WebDriver driver) {
		PaymentGatewayPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement PageTitle() {
		return PageTitle;
	}
	
	public WebElement SelectBankdropdown() {
		return SelectBankdropdown;
	}
	
	public WebElement SelectBankOptions() {
		return SelectBankOptions;
	}
	
	public WebElement TotalAmountPayable() {
		return TotalAmountPayable;
	}
	
	public WebElement Makepaymentbutton() {
		return Makepaymentbutton;
	}
	
	public WebElement Cancelbutton() {
		return Cancelbutton;
	}
	
	public WebElement textorderdetails() {
		return textorderdetails;
	}
	
	public WebElement OrderNumber() {
		return OrderNumber;
	}
	
	public WebElement underbacnkselectionAmount() {
		return underbacnkselectionAmount;
	}
	
	public WebElement textordernumber() {
		return textordernumber;
	}
	
	public WebElement OrderAmount() {
		return OrderAmount;
	}
	
	public WebElement textorderAmount() {
		return textorderAmount;
	}
	
	public WebElement finalamount() {
		return finalamount;
	}
	
	public WebElement texttotalamount() {
		return texttotalamount;
	}
	
	public WebElement ErrorSelectBank() {
		return ErrorSelectBank;
	}

}
