package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class WarehousesPOM extends SuperTestNG{
	
	@FindBy(css="div.panel-heading")
	WebElement WarehousePageHeading;
	
	@FindBy(xpath="//label[@for='Warehouse Name']")
	WebElement WarehouseNameLabel;
	
	@FindBy(xpath="//input[@name='wh_name']")
	WebElement WHnamefield;
	
	@FindBy(xpath="//label[@for='Warehoue Country']")
	WebElement WHCountryCodeLable;
	
	@FindBy(xpath="//select[@name='wh_country_id']")
	WebElement SelectWarehouses;
	
	@FindBy(xpath="//select[@name='wh_country_id']/option")
	List<WebElement> SelectWhOptions;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement Savebutton;
	
	@FindBy(xpath="//input[@value='Save']/following-sibling::a")
	WebElement Cancelbutton;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement updatebutton;
	
	@FindBy(xpath="//input[@value='Update']/following-sibling::a")
	WebElement UpdateCancelButton;
	
	@FindBy(css="a.btn.btn-primary.form-control")
	WebElement Backbutton;
	
	@FindBy(css="div.alert.alert-danger")
	WebElement ErrorMessages;
	
	@FindBy(xpath="//*[contains(text(), 'The wh name field is required.')]")
	WebElement ErrorMessageNameRequired;
	
	@FindBy(xpath="//*[contains(text(), 'The wh country id field is required.')]")
	WebElement ErrorMessageCountryCodeRequired;

	public WarehousesPOM (WebDriver driver) {
		WarehousesPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement WarehousePageHeading() {
		return WarehousePageHeading;
	}
	
	public WebElement WarehouseNameLabel() {
		return WarehouseNameLabel;
	}
	
	public WebElement WHnamefield() {
		return WHnamefield;
	}
	
	public WebElement WHCountryCodeLable() {
		return WHCountryCodeLable;
	}
	
	public WebElement SelectWarehouses() {
		return SelectWarehouses;
	}
	
	public List<WebElement> SelectWhOptions(){
		return SelectWhOptions;
	}
	
	public WebElement Savebutton() {
		return Savebutton;
	}
	
	public WebElement Cancelbutton() {
		return Cancelbutton;
	}
	
	public WebElement updatebutton() {
		return updatebutton;
	}
	
	public WebElement UpdateCancelButton() {
		return UpdateCancelButton;
	}
	
	public WebElement Backbutton() {
		return Backbutton;
	}
	
	public WebElement ErrorMessages() {
		return ErrorMessages;
	}
	
	public WebElement ErrorMessageNameRequired() {
		return ErrorMessageNameRequired;
	}
	
	public WebElement ErrorMessageCountryCodeRequired() {
		return ErrorMessageCountryCodeRequired;
	}
	

}
