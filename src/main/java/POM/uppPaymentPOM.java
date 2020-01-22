package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class uppPaymentPOM extends SuperTestNG {
	
	@FindBy(css="h1")
	WebElement uppPaymentTitle;
	
	@FindBy(css="div > h1 + a")
	WebElement MakePaymentButton;
	
	@FindBy(xpath="//input[@id='upp_dist_id']/parent::div/preceding-sibling::label")
	WebElement labelDistributorID;
	
	@FindBy(css="#upp_dist_id")
	WebElement SearchDistributorIDfield;
	
	@FindBy(xpath="//input[@id='upp_no']/parent::div/preceding-sibling::label[1]")
	WebElement labelUppNo;
	
	@FindBy(css="#upp_no")
	WebElement SearchUppNo;
	
	@FindBy(xpath="//input[@id='upp_pay_order_id']/parent::div/preceding-sibling::label[1]")
	WebElement labelUppOrderID;
	
	@FindBy(css="input[id='upp_pay_order_id']")
	WebElement SearchUppOrderID;
	
	@FindBy(xpath="//select[@id='upp_pay_order_id']/parent::div/preceding-sibling::label[1]")
	WebElement labelUppOrderStatus;
	
	@FindBy(css="select[id='upp_pay_order_id']")
	WebElement SearchUppOrderStatus;
	
	@FindBy(css="select[id='upp_pay_order_id'] > option")
	List<WebElement> SearchUppOrderStatusOption;
	
	@FindBy(css = "select[id='upp_pay_order_id'] > option[selected = 'selected']")
	WebElement SearchOrderStatusSelectedOption;
	
	@FindBy(xpath="//input[@id='pay_date']/parent::div/preceding-sibling::label[1]")
	WebElement labelUPPOrderdate;
	
	@FindBy(css="#pay_date")
	WebElement SearchUppOrderdate;
	
	@FindBy(xpath="//input[@id='upp_ordersheet_upload']/parent::div/preceding-sibling::label[1]")
	WebElement labelOrderSheetUpload;
	
	@FindBy(css="#upp_ordersheet_upload")
	WebElement SearchOrderSheetUploadCheckbox;
	
	@FindBy(name="export_excel")
	WebElement ExportExcelButton;
	
	@FindBy(css="input[type='submit']")
	WebElement Searchbutton;
	
	@FindBy(css="#clear")
	WebElement clearbutton;
	
	@FindBy(css="#searcherror")
	WebElement searcherror;
	
	@FindBy(css="#searcherror > b")
	WebElement searcherrormessage;
	
	public uppPaymentPOM(WebDriver driver) {
		uppPaymentPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement uppPaymentTitle() {
		return uppPaymentTitle;
	}
	
	public WebElement labelDistributorID() {
		return labelDistributorID;
	}
	
	public WebElement MakePaymentButton() {
		return MakePaymentButton;
	}
	
	public WebElement SearchDistributorIDfield() {
		return SearchDistributorIDfield;
	}
	
	public WebElement labelUppNo() {
		return labelUppNo;
	}
	
	public WebElement SearchUppNo() {
		return SearchUppNo;
	}
	
	public WebElement labelUppOrderID() {
		return labelUppOrderID;
	}
	
	public WebElement SearchUppOrderStatus() {
		return SearchUppOrderStatus;
	}
	
	public WebElement labelUppOrderStatus() {
		return labelUppOrderStatus;
	}
	
	public WebElement SearchUppOrderID() {
		return SearchUppOrderID;
	}
	
	public List<WebElement> SearchUppOrderStatusOption(){
		return SearchUppOrderStatusOption;
	}
	
	public WebElement SearchOrderStatusSelectedOption() {
		return SearchOrderStatusSelectedOption;
	}
	
	public WebElement labelUPPOrderdate() {
		return labelUPPOrderdate;
	}
	
	public WebElement SearchUppOrderdate() {
		return SearchUppOrderdate;
	}
	
	public WebElement SearchOrderSheetUploadCheckbox() {
		return SearchOrderSheetUploadCheckbox;
	}
	
	public WebElement labelOrderSheetUpload() {
		return labelOrderSheetUpload;
	}
	
	public WebElement ExportExcelButton() {
		return ExportExcelButton;
	}
	
	public WebElement Searchbutton() {
		return Searchbutton;
	}
	
	public WebElement clearbutton() {
		return clearbutton;
	}
	
	public WebElement searcherror() {
		return searcherror;
	}
	
	public WebElement searcherrormessage() {
		return searcherrormessage;
	}

}
