package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class SearchfunctionalityPOM extends SuperTestNG{
	
	public WebDriver driver;
	
	@FindBy(xpath="//label[@for='Order No']")
	WebElement ordernotitle;
	
	@FindBy(css="input#order_no")
	WebElement orderno;
	
	@FindBy(xpath="//label[@for='Distributor Id']")
	WebElement DistributorIDtitle;
	
	@FindBy(name="distributor_id")
	WebElement DistributorID;
	
	@FindBy(xpath="//label[@for='warehouse']")
	WebElement warehousetitle;
	
	@FindBy(css="select#warehouse")
	WebElement Warehousedropwdownselect;
	
	@FindBy(xpath="//select[@id='warehouse']//option")
	List<WebElement> Warehouseoptions;
	
	@FindBy(xpath="//select[@id='warehouse']//option[@selected='selected']")
	WebElement warehouseselectedvalue;
	
	@FindBy(xpath="//label[@for='Sale Type']")
	WebElement SaleTypetitle;
	
	@FindBy(name="sale_type")
	WebElement Saletype;
	
	@FindBy(xpath="//select[@name='sale_type']//option")
	List<WebElement> Saletypeoptions;
	
	@FindBy(xpath="//label[@for='Date Fields']")
	WebElement DateFieldstitle;
	
	@FindBy(name="date_fields")
	WebElement Datefield;
	
	@FindBy(xpath="//select[@name='date_fields']//option")
	List<WebElement> datefieldoptions;
	
	@FindBy(xpath="//label[@for='From Date']")
	WebElement FromDatetitle;
	
	@FindBy(css="input#date_from")
	WebElement FromDate;
	
	@FindBy(xpath="//label[@for='To Date']")
	WebElement ToDateTitle;
	
	@FindBy(css="input#date_to")
	WebElement ToDate;
	
	@FindBy(xpath="//label[@for='Distributor name']")
	WebElement DistributorNameTitle;
	
	@FindBy(css="input#distributor_name")
	WebElement DistributorNamefield;
	
	@FindBy(xpath="//label[@for='Distributor phone']")
	WebElement DistributorPhoneTitle;
	
	@FindBy(css="input#distributor_phone")
	WebElement DistributorPhone;
	
	@FindBy(name="export_excel")
	WebElement ExportExcel;
	
	@FindBy(name="export_pdf")
	WebElement ExportPDF;
	
	@FindBy(name="search")
	WebElement Searchbutton;
	
	@FindBy(xpath="//a[contains(text(), 'Reset')]")
	WebElement Resetbutton;
	
	@FindBy(xpath="//div[contains(text(), 'Valid')]")
	WebElement numberofentries;
	
	/*@FindBy(css=".row > div >b")
	WebElement numberofentries;*/
	
	@FindBy(css="div#searcherror")
	WebElement searcherror;
	
	@FindBy(css="td.text-center")
	WebElement Norecordmessage;
	
	@FindBy(css="div.ui-datepicker-title")
	WebElement datepickertitle;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody/tr")
	List<WebElement> daterows;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	List<WebElement> datecolumns;
	
	@FindBy(xpath="//*[text()='Prev']")
	WebElement datepreviouslink;
	
	@FindBy(css="div.col-lg-12.alert.alert-success > b")
	WebElement Deletedsuccessmessage;
	
	@FindBy(xpath="//*[text()='Next']")
	WebElement datenext;
	
	@FindBy(xpath="//a[@class='antoo']/span")
	WebElement BulckActiontext;
	
	@FindBy(css=".even.pointer")
	List<WebElement> Totalrowcount;
	
	@FindBy(xpath="//tr[@class='even pointer']/td[2]")
	List<WebElement> Totalordernumbers;
	
	public SearchfunctionalityPOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public WebElement ordernotitle() {
		return ordernotitle;
	}
	
	public WebElement orderno() {
		return orderno;
	}
	
	public WebElement DistributorIDtitle() {
		return DistributorIDtitle;
	}
	
	public WebElement DistributorID() {
		return DistributorID;
	}
	
	public WebElement warehousetitle() {
		return warehousetitle;
	}
	
	public WebElement SaleTypetitle() {
		return SaleTypetitle;
	}
	
	public WebElement Saletype() {
		return Saletype;
	}
	
	public WebElement DateFieldstitle() {
		return DateFieldstitle;
	}
	
	public WebElement Datefield() {
		return Datefield;
	}
	
	public List<WebElement> datefieldoptions(){
		return datefieldoptions;
	}
	
	public WebElement FromDatetitle() {
		return FromDatetitle;
	}
	
	public WebElement FromDate() {
		return FromDate;
	}
	
	public WebElement ToDateTitle() {
		return ToDateTitle;
	}
	
	public WebElement ToDate() {
		return ToDate;
	}
	
	public WebElement DistributorNameTitle() {
		return DistributorNameTitle;
	}
	
	public WebElement DistributorNamefield() {
		return DistributorNamefield;
	}
	
	public WebElement DistributorPhoneTitle() {
		return DistributorPhoneTitle;
	}
	
	public WebElement DistributorPhone() {
		return DistributorPhone;
	}
	
	public WebElement Searchbutton() {
		return Searchbutton;
	}
	
	public WebElement Resetbutton() {
		return Resetbutton;
	}
	
	public WebElement ExportExcel() {
		return ExportExcel;
	}
	
	public WebElement ExportPDF() {
		return ExportPDF;
	}
	
	public WebElement numberofentries() {
		return numberofentries;
	}
	
	public WebElement Warehousedropwdownselect(){
		return Warehousedropwdownselect;
	}
	
	public List<WebElement> Warehouseoptions(){
		return Warehouseoptions;
	}
	
	public WebElement warehouseselectedvalue() {
		return warehouseselectedvalue;
	}
	
	public List<WebElement> Saletypeoptions() {
		return Saletypeoptions;
	}
	
	public WebElement searcherror() {
		return searcherror;
	}
	
	public WebElement Norecordmessage() {
		return Norecordmessage;
	}
	
	public WebElement datepickertitle() {
		return datepickertitle;
	}
	
	public List<WebElement> daterows() {
		return daterows;
	}
	
	public List<WebElement> datecolumns(){
		return datecolumns;
	}
	
	public WebElement datepreviouslink() {
		return datepreviouslink;
	}
	
	public WebElement datenext() {
		return datenext;
	}
	
	public WebElement Deletedsuccessmessage() {
		return Deletedsuccessmessage;
	}
	
	public WebElement BulckActiontext() {
		return BulckActiontext;
	}
	
	public List<WebElement> Totalrowcount(){
		return Totalrowcount;
	}
	
	public List<WebElement> Totalordernumbers(){
		return Totalordernumbers;
	}
}
