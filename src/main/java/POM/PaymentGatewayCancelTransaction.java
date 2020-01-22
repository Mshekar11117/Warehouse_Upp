package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class PaymentGatewayCancelTransaction extends SuperTestNG{
	
	@FindBy(css=".cancel-popup.cancel-transaction.radius6")
	WebElement CancellationFeedBackPopUp;
	
	@FindBy(css="a[title='Cancel Transaction']")
	WebElement CancelTransactionButton;
	
	@FindBy(css="a[title='Cancel Transaction'] + a")
	WebElement ContinuePaymentButton;
	
	@FindBy(css=".label.label-danger")
	WebElement CanceledErrorMessage;
	
	@FindBy(xpath="//*[contains(text(),'Reference no')]")
	WebElement TitleReferenceNumber;
	
	@FindBy(xpath="//*[contains(text(),'Reference no')]/following-sibling::label")
	WebElement ValueReferenceNumber;
	
	@FindBy(css=".btn.btn-primary")
	WebElement GoBackButton;
	
	@FindBy(css="#reasonRadio6")
	WebElement textArea;
	
	public PaymentGatewayCancelTransaction(WebDriver driver) {
		PaymentGatewayCancelTransaction.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement CancellationFeedBackPopUp() {
		return CancellationFeedBackPopUp;
	}
	
	public WebElement CancelTransactionButton() {
		return CancelTransactionButton;
	}
	
	public WebElement ContinuePaymentButton() {
		return ContinuePaymentButton;
	}
	
	public WebElement CanceledErrorMessage() {
		return CanceledErrorMessage;
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
	
	public WebElement textArea() {
		return textArea;
	}
	

}
