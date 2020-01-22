package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class uppPaymentTablePOM extends SuperTestNG{
	
	@FindBy(css="table")
	WebElement table ;
	
	@FindBy(css="tr.bg-info > th:first-child")
	WebElement firstcolumnname;
	
	@FindBy(css="tr.bg-info > th:nth-child(2)")
	WebElement SecondCoulmnName;
	
	@FindBy(css="tr.bg-info > th:nth-child(3)")
	WebElement ThirdCoulmnName;
	
	@FindBy(css="tr.bg-info > th:nth-child(4)")
	WebElement FourthCoulmnName;
	
	@FindBy(css="tr.bg-info > th:nth-child(5)")
	WebElement FifthColumnName;
	
	@FindBy(css="tr.bg-info > th:nth-child(6)")
	WebElement sixthColumnName;
	
	@FindBy(css="tr.bg-info > th:nth-child(7)")
	WebElement seventhColumnName;
	
	@FindBy(css="tr.bg-info > th:nth-child(8)")
	WebElement eighthColumnName;
	
	@FindBy(css="tr.bg-info > th:nth-child(9)")
	WebElement NinthColumnName;
	
	@FindBy(css="a[class='btn btn-warning']")
	List<WebElement> allViewbuttons;
	
	@FindBy(css="tr:first-child > td > a[class='btn btn-warning']")
	WebElement firstviewbutton;
	
	@FindBy(css="#searcherror > b")
	WebElement ErrorMessage;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement tableDistIDfirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement tableUPPNofirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[3]")
	WebElement tableUPPNamefirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[4]")
	WebElement tablePhonefirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[5]")
	WebElement tableUPPOrderIDfirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]")
	WebElement tableUPPOrderAmountfirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[7]")
	WebElement tableUPPOrderStatusfirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[8]")
	WebElement tableUPPOrderDatefirstrow;
	
	@FindBy(css=".pagination")
	WebElement pagination;
	
	@FindBy(xpath="//ul[@class='pagination']/li")
	List<WebElement> NumberofPagination;
	
	@FindBy(xpath="//ul[@class='pagination']/li/a[@rel='prev']")
	WebElement previouspagination;
	
	@FindBy(xpath="//ul[@class='pagination']/li[@class='active']/span")
	WebElement DefaultActivePagination;
	
	@FindBy(xpath="//tbody/tr")
	List<WebElement> TotalNumberofRow;
	
	@FindBy(xpath="//tr[@class='bg-info']/th")
	List<WebElement> TotalNumberofColumn;
	
	@FindBy(css=".even.pointer > td > strong")
	WebElement NoRecordFoundErrorMessage;
	
	@FindBy(xpath="//tr/td[1]")
	List<WebElement> Totaldistidfields;
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> TotalUppNofields;
	
	public uppPaymentTablePOM(WebDriver driver) {
		uppPaymentTablePOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement table() {
		return table;
	}
	
	public WebElement firstcolumnname() {
		return firstcolumnname;
	}
	
	public WebElement SecondCoulmnName() {
		return SecondCoulmnName;
	}
	
	public WebElement ThirdCoulmnName() {
		return ThirdCoulmnName;
	}
	
	public WebElement FourthCoulmnName() {
		return FourthCoulmnName;
	}
	
	public WebElement FifthColumnName() {
		return FifthColumnName;
	}
	
	public WebElement sixthColumnName() {
		return sixthColumnName;
	}
	
	
	public WebElement seventhColumnName() {
		return seventhColumnName;
	}
	
	public WebElement eighthColumnName() {
		return eighthColumnName;
	}
	
	public WebElement NinthColumnName() {
		return NinthColumnName;
	}
	
	public List<WebElement> allViewbuttons() {
		return allViewbuttons;
	}
	
	public WebElement firstviewbutton() {
		return firstviewbutton;
	}
	
	public WebElement ErrorMessage() {
		return ErrorMessage;
	}
	
	public WebElement tableDistIDfirstrow() {
		return tableDistIDfirstrow;
	}
	
	public WebElement tableUPPNofirstrow() {
		return tableUPPNofirstrow;
	}
	
	public WebElement tableUPPNamefirstrow() {
		return tableUPPNamefirstrow;
	}
	
	public WebElement tablePhonefirstrow() {
		return tablePhonefirstrow;
	}
	
	public WebElement tableUPPOrderIDfirstrow() {
		return tableUPPOrderIDfirstrow;
	}
	
	public WebElement tableUPPOrderAmountfirstrow() {
		return tableUPPOrderAmountfirstrow;
	}
	
	public WebElement tableUPPOrderStatusfirstrow() {
		return tableUPPOrderStatusfirstrow;
	}
	
	public WebElement tableUPPOrderDatefirstrow() {
		return tableUPPOrderDatefirstrow;
	}
	
	public WebElement pagination() {
		return pagination;
	}
	
	public List<WebElement> NumberofPagination() {
		return NumberofPagination;
	}
	
	public WebElement previouspagination() {
		return previouspagination;
	}
	
	public WebElement DefaultActivePagination() {
		return DefaultActivePagination;
	}
	
	public List<WebElement> TotalNumberofRow() {
		return TotalNumberofRow;
	}
	
	public List<WebElement> TotalNumberofColumn(){
		return TotalNumberofColumn;
	}
	
	public WebElement NoRecordFoundErrorMessage() {
		return NoRecordFoundErrorMessage;
	}
	
	public List<WebElement> Totaldistidfields(){
		return Totaldistidfields;
	}
	
	public List<WebElement> TotalUppNofields(){
		return TotalUppNofields;
	}
}
