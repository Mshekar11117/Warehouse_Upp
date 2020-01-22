package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class CountriesPOM extends SuperTestNG {
	
	@FindBy(css="div.right_col > div > h1")
	WebElement Createpageheadingtext;
	
	@FindBy(xpath="//label[@for='Country Name']")
	WebElement CountryNameLable;
	
	@FindBy(name="name")
	WebElement CountryNameField;
	
	@FindBy(xpath="//label[@for='Country Code']")
	WebElement CountryCodeLable;
	
	@FindBy(name="code")
	WebElement CountryCodeField;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement Savebutton;
	
	@FindBy(xpath="//input[@value='Save']/following-sibling::a")
	WebElement Cancelbutton;
		
	@FindBy(css="div.alert.alert-danger")
	WebElement ErrorMessages;
	
	@FindBy(xpath="//*[contains(text(), 'The name field is required.')]")
	WebElement ErrorMessageNameFieldRequired;
	
	@FindBy(xpath="//*[contains(text(), 'The code field is required.')]")
	WebElement ErrorMessageCodeFieldRequired;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement updatebutton;
	
	@FindBy(xpath="//input[@value='Update']/following-sibling::a")
	WebElement UpdateCancelButton;

	@FindBy(css="input.btn.btn-primary")
	WebElement SaveORUpdateButton;
	
	public CountriesPOM(WebDriver driver) {
		CountriesPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement Createpageheadingtext() {
		return Createpageheadingtext;
	}
	
	public WebElement CountryNameLable() {
		return CountryNameLable;
	}
	
	public WebElement CountryNameField() {
		return CountryNameField;
	}
	
	public WebElement CountryCodeLable() {
		return CountryCodeLable;
	}
	
	public WebElement CountryCodeField() {
		return CountryCodeField;
	}
	
	public WebElement Savebutton() {
		return Savebutton;
	}
	
	public WebElement Cancelbutton() {
		return Cancelbutton;
	}
	
	public WebElement ErrorMessages() {
		return ErrorMessages;
	}
	
	public WebElement ErrorMessageNameFieldRequired() {
		return ErrorMessageNameFieldRequired;
	}
	
	public WebElement ErrorMessageCodeFieldRequired() {
		return ErrorMessageCodeFieldRequired;
	}
	
	public WebElement updatebutton() {
		return updatebutton;
	}
	
	public WebElement UpdateCancelButton() {
		return UpdateCancelButton;
	}
	
	public WebElement SaveORUpdateButton() {
		return SaveORUpdateButton;
	}

}
