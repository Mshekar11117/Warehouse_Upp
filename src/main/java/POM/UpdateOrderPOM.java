package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class UpdateOrderPOM extends SuperTestNG {
	
	@FindBy(css="input#distributor_phone")
	WebElement DistributorPhone;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement updatebutton;
	
	@FindBy(xpath="//select[@name='sale_type']/option[@selected='selected']")
	WebElement SaleTypevalue;
	
	@FindBy(name="order_no")
	WebElement Orderno;
	
	@FindBy(name="web_inv_no")
	WebElement Invoiceno;
	
	@FindBy(name="inv_received_date")
	WebElement InvoiceDate;
	
	@FindBy(name="web_inv_date")
	WebElement InvWHReceiptsDate;
	
	@FindBy(xpath="//select[@name='hours']/option[@selected]")
	WebElement hours;
	
	@FindBy(xpath="//select[@name='minutes']/option[@selected]")
	WebElement minutes;
	
//	@FindBy(xpath="//select[@name='meridiem']/option[@selected]")
//	WebElement meridiem;
	
	@FindBy(xpath="(//select[@name='meridiem']/option)[1]")
	WebElement meridiem;
	
	@FindBy(name="inv_qty")
	WebElement InvoiceQty;
	
	@FindBy(name="inv_value")
	WebElement InvoiceValue;
	
	@FindBy(name="no_of_boxes")
	WebElement numberofboxes;
	
	@FindBy(name="weight_kgs")
	WebElement Weights;
	
	@FindBy(name="distributor_name")
	WebElement distributorname;
	
	@FindBy(name="distributor_id")
	WebElement distributorid;
	
	@FindBy(name="location")
	WebElement location;
	
	@FindBy(name="area_pin_code")
	WebElement Areapincode;
	
	@FindBy(xpath="//select[@id='state']/option[@selected]")
	WebElement SelectedState;
	
	@FindBy(xpath="//select[@id='regional_zone_name']/option[@selected]")
	WebElement SelectedRegionalName;
	
	@FindBy(xpath="//select[@id='warehouse']/option[@selected]")
	WebElement SelectedWarehouse;
	
	@FindBy(name="dispatch_dt_from_WH")
	WebElement dispatchdatefromwh;
	
	@FindBy(name="transporter_name")
	WebElement transportername;
	
	@FindBy(name="docket_no")
	WebElement docketno;

	@FindBy(xpath="//select[@id='mode_of_transport']/option[@selected]")
	WebElement modeoftransport;
	
	@FindBy(name="standard_transit_days")
	WebElement standardtransitdays;
	
	@FindBy(name="expected_date_of_delivery")
	WebElement expecteddateofdelivery;
	
	@FindBy(name="actual_delivery_date")
	WebElement actualdeliverydate;
	
	@FindBy(name="received_by")
	WebElement receivedby;
	
	@FindBy(xpath="//select[@id='status']/option[@selected]")
	WebElement Status;
	
	@FindBy(name="ds_team_order_sent_to_wh_tat_days")
	WebElement dsteamordersenttowhtatdays;
	
	@FindBy(name="wh_processing_tat_days")
	WebElement whprocessingtatdays;
	
	@FindBy(name="cs_team_tat")
	WebElement CourierTeamtat;
	
	@FindBy(css="#actual_order_delivery_tat")
	WebElement actualorderdeliverytat;
	
	@FindBy(name="remarks")
	WebElement remarks;
	
	public UpdateOrderPOM(WebDriver driver) {
		UpdateOrderPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement DistributorPhone() {
		return DistributorPhone;
	}
	
	public WebElement updatebutton() {
		return updatebutton;
	}
	
	public WebElement SaleTypevalue() {
		return SaleTypevalue;
	}
	
	public WebElement Orderno() {
		return Orderno;
	}
	
	public WebElement Invoiceno() {
		return Invoiceno;
	}
	
	public WebElement InvoiceDate() {
		return InvoiceDate;
	}
	
	public WebElement InvWHReceiptsDate() {
		return InvWHReceiptsDate;
	}
	
	public WebElement hours() {
		return hours;
	}
	
	public WebElement minutes() {
		return minutes;
	}
	
	public WebElement meridiem() {
		return meridiem;
	}
	
	public WebElement InvoiceQty() {
		return InvoiceQty;
	}
	
	public WebElement InvoiceValue() {
		return InvoiceValue;
	}
	
	public WebElement numberofboxes() {
		return numberofboxes;
	}
	
	public WebElement Weights() {
		return Weights;
	}
	
	public WebElement distributorname() {
		return distributorname;
	}
	
	public WebElement distributorid() {
		return distributorid;
	}
	
	
	public WebElement location() {
		return location;
	}
	
	public WebElement Areapincode() {
		return Areapincode;
	}
	
	public WebElement SelectedState() {
		return SelectedState;
	}
	
	public WebElement SelectedRegionalName() {
		return SelectedRegionalName;
	}
	
	public WebElement SelectedWarehouse() {
		return SelectedWarehouse;
	}
	
	public WebElement dispatchdatefromwh() {
		return dispatchdatefromwh;
	}
	
	public WebElement transportername() {
		return transportername;
	}
	
	public WebElement docketno() {
		return docketno;
	}
	
	public WebElement modeoftransport() {
		return modeoftransport;
	}
	
	public WebElement standardtransitdays() {
		return standardtransitdays;
	}
	
	public WebElement expecteddateofdelivery() {
		return expecteddateofdelivery;
	}
	
	public WebElement actualdeliverydate() {
		return actualdeliverydate;
	}
	
	public WebElement receivedby() {
		return receivedby;
	}
	
	public WebElement Status() {
		return Status;
	}
	
	public WebElement dsteamordersenttowhtatdays() {
		return dsteamordersenttowhtatdays;
	}
	
	public WebElement whprocessingtatdays() {
		return whprocessingtatdays;
	}
	
	public WebElement CourierTeamtat() {
		return CourierTeamtat;
	}
	
	public WebElement actualorderdeliverytat() {
		return actualorderdeliverytat;
	}
	
	public WebElement remarks() {
		return remarks;
	}
}
