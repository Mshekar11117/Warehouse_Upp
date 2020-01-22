package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class ImportOrderPOM extends SuperTestNG{
	
	@FindBy(css="div.row > div > h1")
	WebElement pagetitle;
	
	@FindBy(css="form>div>div:nth-child(1)>label")
	WebElement DispatchDatelabel;
	
	@FindBy(css="input#select_date")
	WebElement DispatchDateField;
	
	@FindBy(css="form>div>div:nth-child(2)>label")
	WebElement FileinputLabel;
	
	@FindBy(css="div.kv-fileinput-caption")
	WebElement FileinputField;
	
	@FindBy(css="input#inputfile")
	WebElement inputfield;
	
	@FindBy(css="button.fileinput-remove-button")
	WebElement Removebutton;
	
	@FindBy(css="button.fileinput-upload-button")
	WebElement Uploadbutton;
	
	@FindBy(css="div.upload_instructions > b")
	WebElement UploadInstructiontext;
	
	@FindBy(css="ul#list > li:nth-child(1)")
	WebElement firstlistpoint;
	
	@FindBy(css="ul#list > li:nth-child(2)")
	WebElement Secondlistpoint;
	
	@FindBy(css="ul#list > li:nth-child(3)")
	WebElement Thirdlistpoint;
	
	@FindBy(css="span.error")
	WebElement DispatchDateError;
	
	@FindBy(css="div.alert.alert-error > b")
	WebElement ErrorAlert;
	
	@FindBy(css="div.kv-fileinput-error.file-error-message")
	WebElement wrongformat;
	
	@FindBy(css="div.kv-fileinput-error.file-error-message > span")
	WebElement Wrongformatmessageclosebutton;
	
	@FindBy(xpath="//div[@title='Validation Error']/span")
	WebElement NofileselectedError;
	
	@FindBy(xpath="//div[contains(@class, 'alert-success')]/b")
	WebElement Successalert;
	
	@FindBy(css="div.row > div > b")
	WebElement totalvalidorders;
	
	public ImportOrderPOM(WebDriver driver) {
		ImportOrderPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement pagetitle() {
		return pagetitle;
	}
	
	public WebElement DispatchDatelabel() {
		return DispatchDatelabel;
	}
	
	public WebElement DispatchDateField() {
		return DispatchDateField;
	}
	
	public WebElement FileinputField() {
		return FileinputField;
	}
	
	public WebElement FileinputLabel() {
		return FileinputLabel;
	}
	
	public WebElement inputfield() {
		return inputfield;
	}
	
	public WebElement Removebutton() {
		return Removebutton;
	}
	
	public WebElement Uploadbutton() {
		return Uploadbutton;
	}
	
	public WebElement UploadInstructiontext() {
		return UploadInstructiontext;
	}
	
	public WebElement firstlistpoint() {
		return firstlistpoint;
	}
	
	public WebElement Secondlistpoint() {
		return Secondlistpoint;
	}
	
	public WebElement Thirdlistpoint() {
		return Thirdlistpoint;
	}
	
	public WebElement DispatchDateError() {
		return DispatchDateError;
	}
	
	public WebElement ErrorAlert() {
		return ErrorAlert;
	}
	
	public WebElement wrongformat() {
		return wrongformat;
	}
	
	public WebElement Wrongformatmessageclosebutton() {
		return Wrongformatmessageclosebutton;
	}
	
	public WebElement NofileselectedError() {
		return NofileselectedError;
	}
	
	public WebElement Successalert() {
		return Successalert;
	}
	
	public WebElement totalvalidorders() {
		return totalvalidorders;
	}

}
