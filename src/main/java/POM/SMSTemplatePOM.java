package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class SMSTemplatePOM extends SuperTestNG {
	
	@FindBy(css="div.right_col > div > h1")
	WebElement Createpageheadingtext;
	
	@FindBy(xpath="//label[@for='SMS Title']")
	WebElement LabelSMSTitle;
	
	@FindBy(xpath="//label[@for='SMS Template']")
	WebElement LabelSMSTemplates;
	
	@FindBy(xpath="//label[@for='Status']")
	WebElement LabelSMSStatus;
	
	@FindBy(name="sms_title")
	WebElement SMStitleField;
	
	@FindBy(xpath="//textarea[@name='sms_template']")
	WebElement SMSTemplateField;
	
	@FindBy(name="status")
	WebElement SMSStatusField;
	
	@FindBy(xpath="//select[@name='status']/option")
	List<WebElement> SMSStatusOptions;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement Savebutton;
	
	@FindBy(xpath="//input[@value='Save']/following-sibling::a")
	WebElement Cancelbutton;
	
	@FindBy(css="div.alert.alert-danger")
	WebElement ErrorMessages;
	
	@FindBy(xpath="//*[contains(text(), 'The sms title field is required.')]")
	WebElement ErrorMessageSMSTitleFieldRequired;
	
	@FindBy(xpath="//*[contains(text(), 'The sms template field is required.')]")
	WebElement ErrorMessageSMSTemplateFieldRequired;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement updatebutton;
	
	@FindBy(xpath="a.btn.btn-warning")
	List<WebElement> allupdatebuttons;
	
	@FindBy(xpath="//input[@value='Update']/following-sibling::a")
	WebElement UpdateCancelButton;

	@FindBy(css="input.btn.btn-primary")
	WebElement SaveORUpdateButton;
	
	@FindBy(css="button.btn.btn-danger")
	List<WebElement> allDeletButtons;
	
	
	public SMSTemplatePOM(WebDriver driver) {
		SMSTemplatePOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement Createpageheadingtext() {
		return Createpageheadingtext;
	}
	
	public WebElement LabelSMSTitle() {
		return LabelSMSTitle;
	}
	
	public WebElement LabelSMSTemplates() {
		return LabelSMSTemplates;
	}
	
	public WebElement LabelSMSStatus() {
		return LabelSMSStatus;
	}
	
	public WebElement SMStitleField() {
		return SMStitleField;
	}
	
	public WebElement SMSTemplateField() {
		return SMSTemplateField;
	}
	
	public WebElement SMSStatusField() {
		return SMSStatusField;
	}
	
	public List<WebElement> SMSStatusOptions() {
		return SMSStatusOptions;
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
	
	public WebElement ErrorMessageSMSTitleFieldRequired() {
		return ErrorMessageSMSTitleFieldRequired;
	}
	
	public WebElement ErrorMessageSMSTemplateFieldRequired() {
		return ErrorMessageSMSTemplateFieldRequired;
	}
	
	public WebElement updatebutton() {
		return updatebutton;
	}
	
	public List<WebElement> allupdatebuttons() {
		return allupdatebuttons;
	}
	
	public WebElement UpdateCancelButton() {
		return UpdateCancelButton;
	}
	
	public WebElement SaveORUpdateButton() {
		return SaveORUpdateButton;
	}
	
	public List<WebElement> allDeletButtons() {
		return allDeletButtons;
	}
}
