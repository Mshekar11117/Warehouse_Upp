package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class TablesPOM extends SuperTestNG{
	
	@FindBy(css="table")
	WebElement table;
	
	@FindBy(css="a.btn.btn-success")
	WebElement Createbutton;
	
	@FindBy(css="div.right_col > div > h1")
	WebElement PageTitleText;
	
	@FindBy(css="tr.bg-info > th:nth-child(1)")
	WebElement FirstTitleofTable;
	
	@FindBy(css="tr.bg-info > th:nth-child(2)")
	WebElement SecondTitleofTable;
	
	@FindBy(css="tr.bg-info > th:nth-child(3)")
	WebElement ThirdTitleofTable;
	
	@FindBy(css="tr.bg-info > th:nth-child(4)")
	WebElement FourthTItleofTable;
	
	@FindBy(css="tr.bg-info > th:nth-child(5)")
	WebElement FifthTitleofTable;
	
	@FindBy(xpath="//tbody/tr")
	List<WebElement> tablerows;
	
	@FindBy(xpath="//tbody/tr[1]/td/a[2]")
	WebElement firstupdatebutton;
	
	@FindBy(xpath="//tbody/tr[last()]/td/a[2]")
	WebElement lastupdatebutton;
	
	@FindBy(css="a.glyphicon.glyphicon-edit")
	List<WebElement> allUpdatebuttons;
	
	@FindBy(xpath="//tbody/tr[1]/td/a[1]")
	WebElement firstviewbutton;
	
	@FindBy(xpath="//tbody/tr[last()]/td/a[1]")
	WebElement lastviewbutton;
	
	@FindBy(css="a.glyphicon.glyphicon-eye-open")
	List<WebElement> allviewbuttons;
	
	@FindBy(xpath="//tbody/tr[1]/td/a[3]")
	WebElement firstdeletebutton;
	
	@FindBy(xpath="//tbody/tr[last()]/td/a[3]")
	WebElement lastdeletebutton;
	
	@FindBy(css="a.glyphicon.glyphicon-remove")
	List<WebElement> allDeletebuttons;
	
	@FindBy(css="tr.bg-info > th")
	List<WebElement> Titleslength;
	
	@FindBy(xpath="//tbody/tr[last()]/td/button")
	WebElement LastDeleteButton;
	
	@FindBy(xpath="//tbody/tr[last()]/td[2]")
	WebElement LastRecordName;
	
	@FindBy(xpath="//tbody/tr[last()]/td[3]")
	WebElement LastRecordEmailidORDesc;
	
	@FindBy(xpath="//tbody/tr[last()]/td[4]")
	WebElement LastRecordSMSTemplateStatus;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(2)")
	WebElement Ordernumber;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(3)")
	WebElement DistName;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(4)")
	WebElement DistId;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(5)")
	WebElement DistLocation;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(6)")
	WebElement DistWH;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(7)")
	WebElement Invoicevalue;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(8)")
	WebElement DocketNumber;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(9)")
	WebElement transporterName;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(10)")
	WebElement Modeoftransport;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(11)")
	WebElement CTAT;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(12)")
	WebElement ExpectedDeliveryDate;
	
	@FindBy(css="tr.even.pointer:nth-child(1) > td:nth-child(13)")
	WebElement DispatchDTfromWH;
	
	@FindBy(xpath="//tr[@class='even pointer']/td[2]")
	List<WebElement> Totalordernumbers;
		
	public TablesPOM(WebDriver driver) {
		TablesPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement table() {
		return table;
	}
	
	public WebElement Createbutton() {
		return Createbutton;
	}
	
	public WebElement PageTitleText() {
		return PageTitleText;
	}
	
	public WebElement FirstTitleofTable() {
		return FirstTitleofTable;
	}
	
	public WebElement SecondTitleofTable() {
		return SecondTitleofTable;
	}
	
	public WebElement ThirdTitleofTable() {
		return ThirdTitleofTable;
	}
	
	public WebElement FourthTItleofTable() {
		return FourthTItleofTable;
	}
	
	public WebElement FifthTitleofTable() {
		return FifthTitleofTable;
	}
	
	public List<WebElement> tablerows(){
		return tablerows;
	}
	
	public WebElement firstupdatebutton() {
		return firstupdatebutton;
	}
	
	public WebElement lastupdatebutton() {
		return lastupdatebutton;
	}
	
	public List<WebElement> allUpdatebuttons() {
		return allUpdatebuttons;
	}
	
	public WebElement firstviewbutton() {
		return firstviewbutton;
	}
	
	public WebElement lastviewbutton() {
		return lastviewbutton;
	}
	
	public List<WebElement> allviewbuttons(){
		return allviewbuttons;
	}
	
	public WebElement lastdeletebutton() {
		return lastdeletebutton;
	}
	
	public List<WebElement> allDeletebuttons(){
		return allDeletebuttons;
	}
	
	public List<WebElement> Titleslength(){
		return Titleslength;
	}
	
	public WebElement LastDeleteButton() {
		return LastDeleteButton;
	}
	
	public WebElement LastRecordName() {
		return LastRecordName;
	}
	
	public WebElement LastRecordEmailidORDesc() {
		return LastRecordEmailidORDesc;
	}
	
	public WebElement LastRecordSMSTemplateStatus() {
		return LastRecordSMSTemplateStatus;
	}
	
	public WebElement Ordernumber() {
		return Ordernumber;
	}
	
	public WebElement DistName() {
		return DistName;
	}
	
	public WebElement DistId() {
		return DistId;
	}
	
	public WebElement DistLocation() {
		return DistLocation;
	}
	
	public WebElement DistWH() {
		return DistWH;
	}
	
	public WebElement Invoicevalue() {
		return Invoicevalue;
	}
	
	public WebElement DocketNumber() {
		return DocketNumber;
	}
	
	public WebElement transporterName() {
		return transporterName;
	}
	
	public WebElement Modeoftransport() {
		return Modeoftransport;
	}
	
	public WebElement CTAT() {
		return CTAT;
	}
	
	public WebElement ExpectedDeliveryDate() {
		return ExpectedDeliveryDate;
	}
	
	public WebElement DispatchDTfromWH() {
		return DispatchDTfromWH;
	}
	
	public List<WebElement> Totalordernumbers(){
		return Totalordernumbers;
	}

}
