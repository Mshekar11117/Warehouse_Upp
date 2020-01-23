package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class uppDistributorTablePOM extends SuperTestNG{
	
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
	
	@FindBy(css="tr.bg-info > th:nth-child(10)")
	WebElement tenthColumnName;
	
	@FindBy(css="tr.bg-info > th:nth-child(11)")
	WebElement eleventhColumnName;
	
	@FindBy(css="a[class='btn btn-primary']")
	WebElement allviewbuttons;
	
	@FindBy(css="a[class='btn btn-warning']")
	WebElement allupdatebuttons;
	
	@FindBy(css="button[class='btn btn-danger']")
	WebElement alldeletebuttons;
	
	@FindBy(css="tr:first-child > td > a[class='btn btn-primary']")
	WebElement firstviewbutton;
	
	@FindBy(css="tr:first-child > td > a[class='btn btn-warning']")
	WebElement firstupdatebutton;
	
	@FindBy(css="tr:first-child > td > button[class='btn btn-danger']")
	WebElement firstDeletebutton;
	
	@FindBy(css="tr:last-child > td > a[class='btn btn-primary']")
	WebElement lastviewbutton;
	
	@FindBy(css="tr:last-child > td > a[class='btn btn-warning']")
	WebElement lastupdatebutton;
	
	@FindBy(css="tr:last-child > td > button[class='btn btn-danger']")
	WebElement lastDeletebutton;
	
	@FindBy(css="tr:nth-child(5) > td > button[class='btn btn-danger']")
	WebElement fifthDeleteButton;
	
	@FindBy(css="tr:nth-child(5) > td > a[class='btn btn-warning']")
	WebElement fifthUpdateButton;
	
	@FindBy(css="tr:nth-child(5) > td > a[class='btn btn-primary']")
	WebElement fifthViewButton;
			
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement tableDistIDfirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[3]")
	WebElement tableDistNamefirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[4]")
	WebElement tableUPPNofirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[5]")
	WebElement tableADatefirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]")
	WebElement tableUPPNamefirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[7]")
	WebElement tableplacefirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[8]")
	WebElement tableStatefirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[9]")
	WebElement tableStatusfirstrow;
	
	@FindBy(xpath="//tbody/tr[1]/td[10]")
	WebElement tableContactNofirstrow;
	
	public uppDistributorTablePOM(WebDriver driver) {
		uppDistributorTablePOM.driver = driver;
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
	
	
	public WebElement tenthColumnName() {
		return tenthColumnName;
	}
	
	public WebElement eleventhColumnName() {
		return eleventhColumnName;
	}
	
	public WebElement allupdatebuttons() {
		return allupdatebuttons;
	}
	
	public WebElement allviewbuttons() {
		return allviewbuttons;
	}
	
	public WebElement alldeletebuttons() {
		return alldeletebuttons;
	}
	
	public WebElement firstviewbutton() {
		return firstviewbutton;
	}
	
	public WebElement firstupdatebutton() {
		return firstupdatebutton;
	}
	
	public WebElement firstDeletebutton() {
		return firstDeletebutton;
	}
	
	public WebElement lastviewbutton() {
		return lastviewbutton;
	}
	
	public WebElement lastupdatebutton() {
		return lastupdatebutton;
	}
	
	public WebElement lastDeletebutton() {
		return lastDeletebutton;
	}
	
	public WebElement fifthDeleteButton() {
		return fifthDeleteButton;
	}
	
	public WebElement fifthUpdateButton() {
		return fifthUpdateButton;
	}
	
	public WebElement fifthViewButton() {
		return fifthViewButton;
	}
	
	public WebElement tableDistIDfirstrow() {
		return tableDistIDfirstrow;
	}
	
	public WebElement tableDistNamefirstrow() {
		return tableDistNamefirstrow;
	}
	
	public WebElement tableUPPNofirstrow() {
		return tableUPPNofirstrow;
	}
	
	public WebElement tableADatefirstrow() {
		return tableADatefirstrow;
	}
	
	public WebElement tableUPPNamefirstrow() {
		return tableUPPNamefirstrow;
	}
	
	public WebElement tableplacefirstrow() {
		return tableplacefirstrow;
	}
	
	public WebElement tableStatefirstrow() {
		return tableStatefirstrow;
	}
	
	public WebElement tableStatusfirstrow() {
		return tableStatusfirstrow;
	}
	
	public WebElement tableContactNofirstrow() {
		return tableContactNofirstrow;
	}

}
