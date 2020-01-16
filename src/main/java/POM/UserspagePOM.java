package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class UserspagePOM extends SuperTestNG {
	
	@FindBy(css="div.panel-heading")
	WebElement CreateNewUser;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement namefield;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordfield;
	
	@FindBy(xpath="//input[@name='password_confirmation']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//input[@name='mobile_number']")
	WebElement mobilefiled;
	
	@FindBy(xpath="//select[@name='warehouse_id[]']")
	WebElement WarehousesSelect;
	
	@FindBy(xpath="//select[@name='warehouse_id[]']/option")
	List<WebElement> WhselectOptions;
	
	@FindBy(xpath="//select[@name='role_id']")
	WebElement UserRoleSelect;
	
	@FindBy(xpath="//select[@name='role_id']/option")
	List<WebElement> UserRoleOptions;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement Savebutton;
	
	@FindBy(xpath="//input[@value='Save']/following-sibling::a")
	WebElement Cancelbutton;
	
	@FindBy(xpath="//input[@value='Update']/following-sibling::a")
	WebElement UpdateCancelbutton;
	
	@FindBy(xpath="//tbody/tr[last()]/td/a")
	WebElement Updatelastbutton;
	
	@FindBy(css="div.alert.alert-danger")
	WebElement ErrorMessages;
	
	@FindBy(css="div.alert.alert-danger > p")
	List<WebElement> ErrorMessageLength;
	
	@FindBy(xpath="//*[contains(text(), 'The name field is required.')]")
	WebElement NameFieldRequiredErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The email field is required.')]")
	WebElement EmailFieldRequiredErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The email has already been taken.')]")
	WebElement EmailFieldAlredyExistsErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The password field is required.')]")
	WebElement PasswordFieldRequiredErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The mobile number field is required.')]")
	WebElement MobileFieldRequiredErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The warehouse id field is required.')]")
	WebElement WHidFieldRequiredErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The role id field is required.')]")
	WebElement RoleFieldRequiredErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The email must be a valid email address.')]")
	WebElement InvalidEmailErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The name field allows letters, spaces, hyphens, apostrophes, ampersand, slash and dots only permitted')]")
	WebElement InvlidNameErrorMessage;
	
	@FindBy(xpath="//*[contains(text(), 'The password must be at least 6 characters.')]")
	WebElement MinPasswordChar;
	
	@FindBy(xpath="//*[contains(text(), 'The password confirmation does not match.')]")
	WebElement ConfirmpassowrdNoMatch;
	
	@FindBy(xpath="//*[contains(text(), 'The mobile number must be a number.')]")
	WebElement MobileMustBeNumber;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement Updatebutton;

	
	public UserspagePOM(WebDriver driver) {
		UserspagePOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement CreateNewUser() {
		return CreateNewUser;
	}
	
	public WebElement namefield() {
		return namefield;
	}
	
	public WebElement emailfield() {
		return emailfield;
	}
	
	public WebElement passwordfield() {
		return passwordfield;
	}
	
	public WebElement confirmpassword() {
		return confirmpassword;
	}
	
	public WebElement mobilefiled() {
		return mobilefiled;
	}
	
	public WebElement WarehousesSelect() {
		return WarehousesSelect;
	}
	
	public List<WebElement> WhselectOptions(){
		return WhselectOptions;
	}
	
	public WebElement UserRoleSelect() {
		return UserRoleSelect;
	}
	
	public List<WebElement> UserRoleOptions() {
		return UserRoleOptions;
	}
	
	public WebElement Savebutton() {
		return Savebutton;
	}
	
	public WebElement Cancelbutton() {
		return Cancelbutton;
	}
	
	public WebElement UpdateCancelbutton() {
		return UpdateCancelbutton;
	}
	
	public WebElement Updatelastbutton() {
		return Updatelastbutton;
	}
	
	public WebElement ErrorMessages() {
		return ErrorMessages;
	}
	
	public List<WebElement> ErrorMessageLength() {
		return ErrorMessageLength;
	}
	
	public WebElement NameFieldRequiredErrorMessage() {
		return NameFieldRequiredErrorMessage;
	}
	
	public WebElement EmailFieldRequiredErrorMessage() {
		return EmailFieldRequiredErrorMessage;
	}
	
	public WebElement EmailFieldAlredyExistsErrorMessage() {
		return EmailFieldAlredyExistsErrorMessage;
	}
	
	public WebElement PasswordFieldRequiredErrorMessage() {
		return PasswordFieldRequiredErrorMessage;
	}
	
	
	public WebElement MobileFieldRequiredErrorMessage() {
		return MobileFieldRequiredErrorMessage;
	}
	
	public WebElement WHidFieldRequiredErrorMessage() {
		return WHidFieldRequiredErrorMessage;
	}
	
	public WebElement RoleFieldRequiredErrorMessage() {
		return RoleFieldRequiredErrorMessage;
	}
	
	public WebElement InvalidEmailErrorMessage() {
		return InvalidEmailErrorMessage;
	}
	
	public WebElement InvlidNameErrorMessage() {
		return InvlidNameErrorMessage;
	}
	
	public WebElement MinPasswordChar() {
		return MinPasswordChar;
	}
	
	public WebElement ConfirmpassowrdNoMatch() {
		return ConfirmpassowrdNoMatch;
	}
	
	public WebElement MobileMustBeNumber() {
		return MobileMustBeNumber;
	}
	
	public WebElement Updatebutton() {
		return Updatebutton;
	}
	
}
