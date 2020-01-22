package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class ViewOrdersPOM extends SuperTestNG {
		
	@FindBy(xpath="//div[@class='form-group']/div[2]/a")
	WebElement viewbackbutton;
	
	@FindBy(xpath="//label")
	WebElement alllables;
	
	@FindBy(css="input#sale_type")
	WebElement Saletype;
	
	@FindBy(css="input#order_no")
	WebElement Ordernumber;
	
	@FindBy(css="input#web_inv_no")
	WebElement InvoiceNumber;
	
	@FindBy(css="input#inv_received_date")
	WebElement invoiceDate;
	
	@FindBy(css="input#web_inv_date")
	WebElement invoiceWHReceiptDate ; 
	
	@FindBy(css="input#order_receipt_time_in_wh")
	WebElement OrderReceiptTimeinWH;
	
	@FindBy(css="input#inv_qty")
	WebElement InvoiceQty;
	
	@FindBy(css="input#inv_value")
	WebElement InvoiceValue;
	
	@FindBy(css="input#no_of_boxes")
	WebElement NumberOfBoxes;
	
	@FindBy(css="input#weight_kgs")
	WebElement Weights;
	
	@FindBy(css="input#distributor_name")
	WebElement DistributorName;
	
	@FindBy(css="input#distributor_id")
	WebElement DistributorID;
	
	@FindBy(css="input#distributor_phone")
	WebElement distributorphone;
	
	@FindBy(css="input#location")
	WebElement Locations;

	@FindBy(css="input#area_pin_code")
	WebElement AreaPinCode;
	
	@FindBy(css="input#state")
	WebElement State;
	
	@FindBy(css="input#regional_zone_name")
	WebElement RegionalZoneName;
	
	@FindBy(css="input#warehouse")
	WebElement Warehouses;
	
	@FindBy(css="input#dispatch_dt_from_WH")
	WebElement DispatchDateFromWH;
	
	@FindBy(css="input#transporter_name")
	WebElement TransportName;
	
	@FindBy(css="input#docket_no")
	WebElement DocketNumber;
	
	@FindBy(css="input#mode_of_transport")
	WebElement ModeOfTransport;
	
	@FindBy(css="input#standard_transit_days")
	WebElement StandardTAT;
	
	@FindBy(css="input#expected_date_of_delivery")
	WebElement ExpectedDateofDelivery;
	
	@FindBy(css="input#actual_delivery_date")
	WebElement ActualDateOfDelivery;
	
	@FindBy(css="input#received_by")
	WebElement Recievedby;
	
	@FindBy(css="input#status")
	WebElement Status;
	
	@FindBy(css="input#ds_team_order_sent_to_wh_tat_days")
	WebElement DSTeamOrderSenttoWHTATDays;
	
	@FindBy(xpath="//div[10]/label[2]/following-sibling::div[1]/input")
	WebElement WHprocessingTATDays;
	
	@FindBy(css="input#cs_team_tat")
	WebElement CourierTeamTransistTATDays;
	
	@FindBy (css="input#actual_order_delivery_tat")
	WebElement ActualOrderDeliveryTAT;
	
	@FindBy(css="textarea#remarks")
	WebElement Remarks;
	
	@FindBy(xpath="//a[@data-toggle='modal']")
	WebElement AddUpdateRemarklink;
	
	public ViewOrdersPOM(WebDriver driver) {
		ViewOrdersPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement viewbackbutton() {
		return viewbackbutton;
	}
	
	public WebElement alllables() {
		return alllables;
	}
	
	
	public WebElement Saletype() {
		return Saletype;
	}
	
	public WebElement Ordernumber() {
		return Ordernumber;
	}
	
	
	public WebElement InvoiceNumber() {
		return InvoiceNumber;
	}
	
	public WebElement invoiceDate() {
		return invoiceDate;
	}
	
	public WebElement invoiceWHReceiptDate() {
		return invoiceWHReceiptDate;
	}
	
	public WebElement OrderReceiptTimeinWH() {
		return OrderReceiptTimeinWH;
	}
	
	public WebElement InvoiceQty() {
		return InvoiceQty;
	}
	
	public WebElement InvoiceValue() {
		return InvoiceValue;
	}
	
	public WebElement NumberOfBoxes() {
		return NumberOfBoxes;
	}
	
	public WebElement Weights() {
		return Weights;
	}
	
	public WebElement DistributorName() {
		return DistributorName;
	}
	
	public WebElement DistributorID() {
		return DistributorID;
	}
	
	public WebElement distributorphone() {
		return distributorphone;
	}
	
	public WebElement Locations() {
		return Locations;
	}
	
	public WebElement AreaPinCode() {
		return AreaPinCode;
	}
	
	public WebElement State() {
		return State;
	}
	
	public WebElement RegionalZoneName() {
		return RegionalZoneName;
	}
	
	public WebElement Warehouses() {
		return Warehouses;
	}
	
	public WebElement DispatchDateFromWH() {
		return DispatchDateFromWH;
	}
	
	public WebElement TransportName() {
		return TransportName;
	}
	
	public WebElement DocketNumber() {
		return DocketNumber;
	}
	
	public WebElement ModeOfTransport() {
		return ModeOfTransport;
	}
	
	public WebElement StandardTAT() {
		return StandardTAT;
	}
	
	public WebElement ExpectedDateofDelivery() {
		return ExpectedDateofDelivery;
	}
	
	public WebElement ActualDateOfDelivery() {
		return ActualDateOfDelivery;
	}
	
	public WebElement Recievedby() {
		return Recievedby;
	}
	
	public WebElement Status() {
		return Status;
	}
	
	public WebElement DSTeamOrderSenttoWHTATDays() {
		return DSTeamOrderSenttoWHTATDays;
	}
	
	public WebElement WHprocessingTATDays() {
		return WHprocessingTATDays;
	}
	
	public WebElement CourierTeamTransistTATDays() {
		return CourierTeamTransistTATDays;
	}
	
	public WebElement ActualOrderDeliveryTAT() {
		return ActualOrderDeliveryTAT;
	}
	
	public WebElement Remarks() {
		return Remarks;
	}
	
	public WebElement AddUpdateRemarklink() {
		return AddUpdateRemarklink;
	}
}
