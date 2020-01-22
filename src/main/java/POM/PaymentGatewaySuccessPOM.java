package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class PaymentGatewaySuccessPOM extends SuperTestNG{
	
	@FindBy(css="table")
	WebElement table;
	
	@FindBy(css="input[type='submit']")
	WebElement ReturnToTheMerchantSite;
	
	@FindBy(xpath="//tbody/tr[3]/td[2]")
	WebElement Amount;
	
	@FindBy(xpath="//tbody/tr[5]/td[2]")
	WebElement currentDate;
	
	@FindBy(css="h1 > span.label.label-success")
	WebElement ApplicationSuccessTitle;
	
	@FindBy(css="h2 > span.label.label-success")
	WebElement ApplicationPVText;
	
	@FindBy(xpath="//*[contains(text(),'Upp No')]")
	WebElement TitleUppNo;
	
	@FindBy(xpath="//*[contains(text(),'Upp No')]/following-sibling::label")
	WebElement ValueUppNo;
	
	@FindBy(xpath="//*[contains(text(),'Upp Name')]")
	WebElement TitleUppName;
	
	@FindBy(xpath="//*[contains(text(),'Upp Name')]/following-sibling::label")
	WebElement ValueUppName;
	
	@FindBy(xpath="//*[contains(text(),'Transaction Amount')]")
	WebElement TitleTransactionAmount;
	
	@FindBy(xpath="//*[contains(text(),'Transaction Amount')]/following-sibling::label")
	WebElement ValueTransactionAmount;
	
	@FindBy(xpath="//*[contains(text(),'Reference no')]")
	WebElement TitleReferenceNumber;
	
	@FindBy(xpath="//*[contains(text(),'Reference no')]/following-sibling::label")
	WebElement ValueReferenceNumber;
	
	@FindBy(css=".btn.btn-primary")
	WebElement GoBackButton;
	
	public PaymentGatewaySuccessPOM(WebDriver driver) {
		PaymentGatewaySuccessPOM.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement table() {
		return table;
	}
	
	public WebElement ReturnToTheMerchantSite() {
		return ReturnToTheMerchantSite;
	}
	
	public WebElement Amount() {
		return Amount;
	}
	
	public WebElement currentDate() {
		return currentDate;
	}
	
	public WebElement ApplicationSuccessTitle() {
		return ApplicationSuccessTitle;
	}
	
	public WebElement ApplicationPVText() {
		return ApplicationPVText;
	}
	
	public WebElement TitleUppNo() {
		return TitleUppNo;
	}
	
	public WebElement ValueUppNo() {
		return ValueUppNo;
	}
	
	public WebElement TitleUppName() {
		return TitleUppName;
	}
	
	public WebElement ValueUppName() {
		return ValueUppName;
	}
	
	public WebElement TitleTransactionAmount() {
		return TitleTransactionAmount;
	}
	
	public WebElement ValueTransactionAmount() {
		return ValueTransactionAmount;
	}
	
	public WebElement TitleReferenceNumber() {
		return TitleReferenceNumber;
	}
	
	public WebElement ValueReferenceNumber() {
		return ValueReferenceNumber;
	}
	
	public WebElement GoBackButton() {
		return GoBackButton;
	}
	

}
