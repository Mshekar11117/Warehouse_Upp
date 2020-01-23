package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class CreateOrderPOM extends SuperTestNG{
	
	@FindBy(css="div.panel-heading")
	WebElement pagetitle;
	
	@FindBy(css="span.error")
	List<WebElement> Errormessages;
	
	@FindBy(xpath="//*[contains(text(), 'The page has encountred validation errors, please check it.')]")
	WebElement commonerrormessage;
	
	@FindBy(xpath="//label[@for='Sale type']")
	WebElement LabelSaleType;
	
	@FindBy(xpath="//select[@name='sale_type']")	
	WebElement SaleTypedropdown;
	
	@FindBy(xpath="//select[@name='sale_type']/option")
	List<WebElement> SaleTypedropdownOptions;
	
	@FindBy(xpath="//select[@name='sale_type']/option[@selected='selected']")
	WebElement SaleTypeSelectedOption;
	
	@FindBy(xpath="//label[@for='order no']")
	WebElement LabelOrderORSONumber;
	
	@FindBy(xpath="//input[@name='order_no']")
	WebElement OrderORSONumberfield;
	
	@FindBy(xpath="//input[@name='order_no']/following-sibling::span")
	WebElement OrderNumberfieldErrorMessage;
	
	@FindBy(xpath="//label[@for='web inv no']")
	WebElement LabelInvoiceORPSNumber;
	
	@FindBy(xpath="//input[@name='web_inv_no']")
	WebElement InvoiceORPSNumberfield;
	
	@FindBy(xpath="//input[@name='web_inv_no']/following-sibling::span")
	WebElement InvoiceNumberfieldErrorMessage;
	
	@FindBy(xpath="//label[@for='inv_received_date']")
	WebElement LabelInvoiceDate;
	
	@FindBy(css="input#inv_received_date")
	WebElement Invoicedatefield;
	
	@FindBy(css="input#inv_received_date + span")
	WebElement InvoiceDatefieldError;
	
	@FindBy(css="div.ui-datepicker-title")
	WebElement DatePickerTitle;
	
	@FindBy(xpath="//a[@data-handler='next']")
	WebElement NextInvoiceUIDatePicker;
	
	@FindBy(xpath="//a[@data-handler='prev']")
	WebElement PrevInvoiceUIDatePicker;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")
	List<WebElement> CalenderDates;
	
	@FindBy(xpath="//label[@for='web inv date']")
	WebElement LabelInvWHReceiptsDate;
	
	@FindBy(css="input#web_inv_date")
	WebElement InvWHReceiptsDatefield;
	
	@FindBy(css="input#web_inv_date + span")
	WebElement InvWHReceiptDatefieldErrormessage;
	
	@FindBy(xpath="//label[@for='Order Receipt time in WH']")
	WebElement LabelOrderReceiptTimeInWH;
	
	@FindBy(xpath="//select[@name='hours']")
	WebElement Hoursdropdown;
	
	@FindBy(xpath="//select[@name='hours']/option")
	List<WebElement> HoursOptions;
	
	@FindBy(xpath="//select[@name='minutes']")
	WebElement Minutesdropdown;
	
	@FindBy(xpath="//select[@name='minutes']/option")
	List<WebElement> MinutesOptions;
	
	@FindBy(xpath="//select[@name='meridiem']")
	WebElement AMPMdropdown;
	
	@FindBy(xpath="//select[@name='meridiem']/option")
	List<WebElement> AMPMoptions;
	
	@FindBy(xpath="//label[@for='Invoice qty']")
	WebElement labelInvoiceQuantity;
	
	@FindBy(xpath="//input[@name='inv_qty']")
	WebElement invoiceQuantityfield;
	
	@FindBy(xpath="//input[@name='inv_qty']/following-sibling::span")
	WebElement invoiceQuantityErrorMessage;
	
	@FindBy(xpath="//label[@for='inv value']")
	WebElement labelInvoiceValue;
	
	@FindBy(xpath="//input[@name='inv_value']")
	WebElement InvoiceValuefield;
	
	@FindBy(xpath="//input[@name='inv_value']/following-sibling::span")
	WebElement InvoiceValueFieldErrorMessage;
	
	@FindBy(xpath="//label[@for='No of boxes']")
	WebElement Labelnumberofboxes;
	
	@FindBy(xpath="//input[@name='no_of_boxes']")
	WebElement numberofboxesfield;
	
	@FindBy(xpath="//input[@name='no_of_boxes']/following-sibling::span")
	WebElement numberofboxesfieldErrorMessage;
	
	@FindBy(xpath="//label[@for='weight_kgs']")
	WebElement LabelWeights;
	
	@FindBy(xpath="//input[@name='weight_kgs']")
	WebElement Weightsfield;
	
	@FindBy(xpath="//input[@name='weight_kgs']/following-sibling::span")
	WebElement WeightsErrorMessage;
	
	@FindBy(xpath="//label[@for='distributor name']")
	WebElement LabelDistributorname;
	
	@FindBy(xpath="//input[@name='distributor_name']")
	WebElement DistributornameField;
	
	@FindBy(xpath="//input[@name='distributor_name']/following-sibling::span")
	WebElement DistributorNamefieldErrorMessage;
	
	@FindBy(xpath="//label[@for='distributor id']")
	WebElement LabelDistributorIDORUPP;
	
	@FindBy(xpath="//input[@name='distributor_id']")
	WebElement DistributorIDorUPPfield;
	
	@FindBy(xpath="//input[@name='distributor_id']/following-sibling::span")
	WebElement DistributorIDorUPPfieldErrorMessage;
	
	@FindBy(xpath="//label[@for='distributor_phone']")
	WebElement LableDistributorphone;
	
	@FindBy(xpath="//input[@name='distributor_phone']")
	WebElement Distributorphonefield;
	
	@FindBy(xpath="//input[@name='distributor_phone']/following-sibling::span")
	WebElement DistributorphonefieldErrorMessage;
	
	@FindBy(xpath="//label[@for='location']")
	WebElement LabelLocation;
	
	@FindBy(xpath="//input[@name='location']")
	WebElement Locationfield;
	
	@FindBy(xpath="//input[@name='location']/following-sibling::span")
	WebElement LocationFieldErrorMessage;
	
	@FindBy(xpath="//label[@for='area pin code']")
	WebElement LabelAreapincode;
	
	@FindBy(xpath="//input[@name='area_pin_code']")
	WebElement Areapincodefield;
	
	@FindBy(xpath="//input[@name='area_pin_code']/following-sibling::span")
	WebElement AreapincodefieldErrorMessage;
	
	@FindBy(xpath="//label[@for='state']")
	WebElement LabelState;
	
	@FindBy(css="select#state")
	WebElement Statedropdown;
	
	@FindBy(xpath="//select[@id='state']/option")
	List<WebElement> Stateoptions;
	
	@FindBy(xpath="//label[@for='regional_zone_name']")
	WebElement LabelRegionalzonename;
	
	@FindBy(css="select#regional_zone_name")
	WebElement Regionalzonenamedropdown;
	
	@FindBy(xpath="//select[@id='regional_zone_name']/option")
	List<WebElement> Regionalzonenameoptions;
	
	@FindBy(xpath="//label[@for='warehouse']")
	WebElement LabelWarehouse;
	
	@FindBy(css="select#warehouse")
	WebElement Warehousedropdown;
	
	@FindBy(xpath="//select[@id='warehouse']/option")
	List<WebElement> Warehouseoptions;
	
	@FindBy(xpath="//select[@id='warehouse']//option[@selected='selected']")
	WebElement WarehouseSelectedOptionEditFlow;

	@FindBy(css="input#warehouse")
	WebElement WarehouseSelectedOptionViewFlow;
	
	@FindBy(xpath="//label[@for='dispatch_dt_from_WH']")
	WebElement LabelDispatchDTfromWH;
	
	@FindBy(css="input#dispatch_dt_from_WH")
	WebElement DispatchDTfromWHfield; 
	
	@FindBy(css="input#dispatch_dt_from_WH + span")
	WebElement DispatchDTfromWHfieldErrorMessage;
	
	@FindBy(xpath="//label[@for='transporter_name']")
	WebElement LabelTransporterName;
	
	@FindBy(css="input#transporter_name")
	WebElement TransporterNamefield;
	
	@FindBy(css="input#transporter_name + span")
	WebElement TransporterNamefieldErrorMessage;
	
	@FindBy(xpath="//label[@for='docket_no']")
	WebElement LabelDocketNo;
	
	@FindBy(css="input#docket_no")
	WebElement Docketnofield;
	
	@FindBy(css="input#docket_no + span")
	WebElement DocketnofieldErrorMessage;
	
	@FindBy(xpath="//label[@for='mode_of_transport']")
	WebElement LabelModeofTransport;
	
	@FindBy(css="select#mode_of_transport")
	WebElement ModeofTransportdropdown;
	
	@FindBy(xpath="//select[@id='mode_of_transport']/option")
	List<WebElement> ModeofTransportoptions;
	
	@FindBy(xpath="//select[@name='mode_of_transport']/option[@selected='selected']")
	WebElement ModeTransportationSelected;
		
	@FindBy(xpath="//label[@for='standard_transit_days']")
	WebElement LabelStandardTransitdays;
	
	@FindBy(css="input#standard_transit_days")
	WebElement StandardTransitdaysfield;
	
	@FindBy(xpath="//label[@for='expected_date_of_delivery']")
	WebElement LabelExpectedDateOfDelivery;
	
	@FindBy(css="input#expected_date_of_delivery")
	WebElement ExpectedDateOfDeliveryfield;
	
	@FindBy(css="input#expected_date_of_delivery + span")
	WebElement ExpectedDateOfDeliverfieldErrorMessage;
	
	@FindBy(xpath="//label[@for='actual_delivery_date']")
	WebElement LabelActualDeliveryDate;
	
	@FindBy(css="input#actual_delivery_date")
	WebElement ActualDeliveryDatefield;
	
	@FindBy(css = "input#actual_delivery_date + span")
	WebElement ActualDeliveryDateFieldErrorMessage;
	
	@FindBy(xpath="//label[@for='received_by']")
	WebElement LabelReceivedBy;
	
	@FindBy(css="input#received_by")
	WebElement ReceivedByfield;
	
	@FindBy(css="input#received_by + span")
	WebElement ReceivedByfieldErrorMessage;
	
	@FindBy(xpath="//label[@for='status']")
	WebElement labelStatus;
	
	@FindBy(css="select#status")
	WebElement Statusfielddropdown;
	
	@FindBy(xpath="//select[@id='status']/option")
	List<WebElement> Statusoptions;
	
	@FindBy(xpath="//label[@for='ds_team_order_sent_to_wh_tat_days']")
	WebElement LabelDSTeamOrderSenttoWHTATDays;
	
	@FindBy(css="input#ds_team_order_sent_to_wh_tat_days")
	WebElement DSTeamOrderSenttoWHTATDaysfield;
	
	@FindBy(xpath="//label[@for='wh_processing_tat_days']")
	WebElement LabelWHprocessingTATDays;
	
	@FindBy(css="input#wh_processing_tat_days")
	WebElement WHprocessingTATDaysfield;
	
	@FindBy(xpath="//label[@for='cs team tat']")
	WebElement LabelCourierTeamTAT;
	
	@FindBy(css="input#cs_team_tat")
	WebElement CourierTeamTATfield;
	
	@FindBy(xpath="//label[@for='actual_order_delivery_tat']")
	WebElement labelActualOrderDeliveryTAT;
	
	@FindBy(css="input#actual_order_delivery_tat")
	WebElement ActualOrderDeliveryTATfield;
	
	@FindBy(xpath="//label[@for='remarks']")
	WebElement LabelRemarks;
	
	@FindBy(css="textarea#remarks")
	WebElement Remarksfield;
	
	@FindBy(xpath="//*[contains(text(), 'Upload POD')]")
	WebElement LabelUploadPOD;
	
	@FindBy(css="div.input-group-btn")
	WebElement Browsebutton;
	
	@FindBy(css="input#pod_file")
	WebElement Uploadinputupload;
	
	@FindBy(xpath="//div[contains(@class, 'kv-fileinput-error')]")
	WebElement UploadErrorMessage;
	
	@FindBy(css="div.file-caption-name > span")
	WebElement NoFileSelectedErrorMessage;
	
	@FindBy(xpath="//button[contains(@class, 'fileinput-remove')]")
	WebElement UploadRemovebutton;
	
	@FindBy(css="div.form-group > div > b")
	WebElement Uploadwarningtext;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement Savebutton;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement Updatebutton;
	
	@FindBy(css="a.btn.btn-primary")
	WebElement Cancelbutton;
	
//	@FindBy(xpath="//div[contains(@class, 'alert-success')]")
	@FindBy(xpath="//b[contains(text(), 'Order created successfully')]")
	WebElement OrderCreatedSucessfullMessage;
	
	@FindBy(xpath="//b[contains(text(), 'Order updated successfully')]")
	WebElement OrderUpdatedSucessfullMessage;
	
	public CreateOrderPOM(WebDriver driver) {
		CreateOrderPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement pagetitle() {
		return pagetitle;
	}
	
	public List<WebElement> Errormessages() {
		return Errormessages;
	}
	
	public WebElement commonerrormessage() {
		return commonerrormessage;
	}
	
	public WebElement LabelSaleType() {
		return LabelSaleType;
	}
	
	public WebElement SaleTypedropdown() {
		return SaleTypedropdown;
	}
	
	public List<WebElement> SaleTypedropdownOptions() {
		return SaleTypedropdownOptions;
	}
	
	public WebElement SaleTypeSelectedOption() {
		return SaleTypeSelectedOption;
	}
	
	public WebElement LabelOrderORSONumber() {
		return LabelOrderORSONumber;
	}
	
	public WebElement OrderORSONumberfield () {
		return OrderORSONumberfield;
	}
	
	public WebElement OrderNumberfieldErrorMessage() {
		return OrderNumberfieldErrorMessage;
	}
	
	public WebElement LabelInvoiceORPSNumber() {
		return LabelInvoiceORPSNumber;
	}
	
	public WebElement InvoiceORPSNumberfield() {
		return InvoiceORPSNumberfield;
	}
	
	public WebElement InvoiceNumberfieldErrorMessage() {
		return InvoiceNumberfieldErrorMessage;
	}
	
	public WebElement LabelInvoiceDate() {
		return LabelInvoiceDate;
	}
	
	public WebElement Invoicedatefield() {
		return Invoicedatefield;
	}
	
	public WebElement InvoiceDatefieldError() {
		return InvoiceDatefieldError;
	}
	
	public WebElement DatePickerTitle() {
		return DatePickerTitle;
	}
	
	public WebElement NextInvoiceUIDatePicker() {
		return NextInvoiceUIDatePicker;
	}
	
	public WebElement PrevInvoiceUIDatePicker() {
		return PrevInvoiceUIDatePicker;
	}
	
	public List<WebElement> CalenderDates() {
		return CalenderDates;
	}
	
	public WebElement LabelInvWHReceiptsDate() {
		return LabelInvWHReceiptsDate;
	}
	
	public WebElement InvWHReceiptsDatefield() {
		return InvWHReceiptsDatefield;
	}
	
	public WebElement InvWHReceiptDatefieldErrormessage() {
		return InvWHReceiptDatefieldErrormessage;
	}
	
	public WebElement LabelOrderReceiptTimeInWH() {
		return LabelOrderReceiptTimeInWH;
	}
	
	public WebElement Hoursdropdown() {
		return Hoursdropdown;
	}
	
	public List<WebElement> HoursOptions() {
		return HoursOptions;
	}
	
	public WebElement Minutesdropdown() {
		return Minutesdropdown;
	}
	
	public List<WebElement> MinutesOptions() {
		return MinutesOptions;
	}
	
	public WebElement AMPMdropdown() {
		return AMPMdropdown;
	}
	
	public List<WebElement> AMPMoptions() {
		return AMPMoptions;
	}
	
	public WebElement labelInvoiceQuantity() {
		return labelInvoiceQuantity;
	}
	
	public WebElement invoiceQuantityfield() {
		return invoiceQuantityfield;
	}
	
	public WebElement invoiceQuantityErrorMessage() {
		return invoiceQuantityErrorMessage;
	}
	
	public WebElement labelInvoiceValue() {
		return labelInvoiceValue;
	}
	
	public WebElement InvoiceValuefield() {
		return InvoiceValuefield;
	}
	
	public WebElement InvoiceValueFieldErrorMessage() {
		return InvoiceValueFieldErrorMessage;
	}
	
	public WebElement Labelnumberofboxes() {
		return Labelnumberofboxes;
	}
	
	public WebElement numberofboxesfield() {
		return numberofboxesfield;
	}
	
	public WebElement numberofboxesfieldErrorMessage() {
		return numberofboxesfieldErrorMessage;
	}
	
	public WebElement LabelWeights() {
		return LabelWeights;
	}
	
	public WebElement Weightsfield() {
		return Weightsfield;
	}
	
	public WebElement WeightsErrorMessage() {
		return WeightsErrorMessage;
	}
	
	public WebElement LabelDistributorname() {
		return LabelDistributorname;
	}
	
	public WebElement DistributornameField() {
		return DistributornameField;
	}
	
	public WebElement DistributorNamefieldErrorMessage() {
		return DistributorNamefieldErrorMessage;
	}
	
	public WebElement LabelDistributorIDORUPP() {
		return LabelDistributorIDORUPP;
	}
	
	public WebElement DistributorIDorUPPfield()
	{
		return DistributorIDorUPPfield;
	}
	
	public WebElement DistributorIDorUPPfieldErrorMessage() {
		return DistributorIDorUPPfieldErrorMessage;
	}
	
	public WebElement LableDistributorphone() {
		return LableDistributorphone;
	}
	
	public WebElement Distributorphonefield() {
		return Distributorphonefield;
	}
	
	public WebElement DistributorphonefieldErrorMessage() {
		return DistributorphonefieldErrorMessage;
	}
	
	public WebElement LabelLocation() {
		return LabelLocation;
	}
	
	public WebElement Locationfield() {
		return Locationfield;
	}
	
	public WebElement LocationFieldErrorMessage() {
		return LocationFieldErrorMessage;
	}
	
	public WebElement LabelAreapincode() {
		return LabelAreapincode;
	}
	
	public WebElement Areapincodefield() {
		return Areapincodefield;
	}
	
	public WebElement AreapincodefieldErrorMessage() {
		return AreapincodefieldErrorMessage;
	}
	
	public WebElement LabelState() {
		return LabelState;
	}
	
	public WebElement Statedropdown() {
		return Statedropdown;
	}
	
	public List<WebElement> Stateoptions() {
		return Stateoptions;
	}
	
	public WebElement LabelRegionalzonename() {
		return LabelRegionalzonename;
	}
	
	public WebElement Regionalzonenamedropdown() {
		return Regionalzonenamedropdown;
	}
	
	public List<WebElement> Regionalzonenameoptions() {
		return Regionalzonenameoptions;
	}
	
	public WebElement LabelWarehouse() {
		return LabelWarehouse;
	}
	
	public WebElement Warehousedropdown() {
		return Warehousedropdown;
	}
	
	public List<WebElement> Warehouseoptions() {
		return Warehouseoptions;
	}
	
	public WebElement WarehouseSelectedOptionEditFlow() {
		return WarehouseSelectedOptionEditFlow;
	}
	
	public WebElement WarehouseSelectedOptionViewFlow() {
		return WarehouseSelectedOptionViewFlow;
	}
	
	public WebElement LabelDispatchDTfromWH() {
		return LabelDispatchDTfromWH;
	}
	
	public WebElement DispatchDTfromWHfield() {
		return DispatchDTfromWHfield;
	}
	
	public WebElement DispatchDTfromWHfieldErrorMessage() {
		return DispatchDTfromWHfieldErrorMessage;
	}
	
	public WebElement LabelTransporterName() {
		return LabelTransporterName;
	}
	
	public WebElement TransporterNamefield() {
		return TransporterNamefield;
	}
	
	public WebElement TransporterNamefieldErrorMessage() {
		return TransporterNamefieldErrorMessage;
	}
	
	public WebElement LabelDocketNo() {
		return LabelDocketNo;
	}
	
	public WebElement Docketnofield() {
		return Docketnofield;
	}
	
	public WebElement DocketnofieldErrorMessage() {
		return DocketnofieldErrorMessage;
	}
	
	public WebElement LabelModeofTransport() {
		return LabelModeofTransport;
	}
	
	public WebElement ModeofTransportdropdown() {
		return ModeofTransportdropdown;
	}
	
	public List<WebElement> ModeofTransportoptions() {
		return ModeofTransportoptions;
	}
	
	public WebElement ModeTransportationSelected() {
		return ModeTransportationSelected;
	}
	
	public WebElement LabelStandardTransitdays() {
		return LabelStandardTransitdays;
	}
	
	public WebElement StandardTransitdaysfield() {
		return StandardTransitdaysfield;
	}
	
	public WebElement LabelExpectedDateOfDelivery() {
		return LabelExpectedDateOfDelivery;
	}
	
	public WebElement ExpectedDateOfDeliveryfield() {
		return ExpectedDateOfDeliveryfield;
	}
	
	public WebElement ExpectedDateOfDeliverfieldErrorMessage() {
		return ExpectedDateOfDeliverfieldErrorMessage;
	}
	
	public WebElement LabelActualDeliveryDate() {
		return LabelActualDeliveryDate;
	}
	
	public WebElement ActualDeliveryDatefield() {
		return ActualDeliveryDatefield;
	}
	
	public WebElement ActualDeliveryDateFieldErrorMessage() {
		return ActualDeliveryDateFieldErrorMessage;
	}
	
	public WebElement LabelReceivedBy() {
		return LabelReceivedBy;
	}
	
	public WebElement ReceivedByfield() {
		return ReceivedByfield;
	}
	
	public WebElement ReceivedByfieldErrorMessage() {
		return ReceivedByfieldErrorMessage;
	}
	
	public WebElement labelStatus() {
		return labelStatus;
	}
	
	public WebElement Statusfielddropdown() {
		return Statusfielddropdown;
	}
	
	public List<WebElement> Statusoptions(){
		return Statusoptions;
	}
	
	public WebElement LabelDSTeamOrderSenttoWHTATDays() {
		return LabelDSTeamOrderSenttoWHTATDays;
	}
	
	public WebElement DSTeamOrderSenttoWHTATDaysfield() {
		return DSTeamOrderSenttoWHTATDaysfield;
	}
	
	public WebElement LabelWHprocessingTATDays() {
		return LabelWHprocessingTATDays;
	}
	
	public WebElement WHprocessingTATDaysfield() {
		return WHprocessingTATDaysfield;
	}
	
	public WebElement LabelCourierTeamTAT() {
		return LabelCourierTeamTAT;
	}
	
	public WebElement CourierTeamTATfield() {
		return CourierTeamTATfield;
	}
	
	public WebElement labelActualOrderDeliveryTAT() {
		return labelActualOrderDeliveryTAT;
	}
	
	public WebElement ActualOrderDeliveryTATfield() {
		return ActualOrderDeliveryTATfield;
	}
	
	public WebElement LabelRemarks() {
		return LabelRemarks;
	}
	
	public WebElement Remarksfield() {
		return Remarksfield;
	}
	
	public WebElement LabelUploadPOD() {
		return LabelUploadPOD;
	}
	
	public WebElement Browsebutton() {
		return Browsebutton;
	}
	
	public WebElement Uploadinputupload() {
		return Uploadinputupload;
	}
	
	public WebElement UploadErrorMessage() {
		return UploadErrorMessage;
	}
	
	public WebElement NoFileSelectedErrorMessage() {
		return NoFileSelectedErrorMessage;
	}
	
	public WebElement UploadRemovebutton() {
		return UploadRemovebutton;
	}
	
	public WebElement Uploadwarningtext() {
		return Uploadwarningtext;
	}
	
	public WebElement Savebutton() {
		return Savebutton;
	}
	
	public WebElement Updatebutton() {
		return Updatebutton;
	}
	
	public WebElement Cancelbutton() {
		return Cancelbutton;
	}
	
	public WebElement OrderCreatedSucessfullMessage() {
		return OrderCreatedSucessfullMessage;
	}
	
	public WebElement OrderUpdatedSucessfullMessage() {
		return OrderUpdatedSucessfullMessage;
	}
}
