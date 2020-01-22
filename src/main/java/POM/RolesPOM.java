package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class RolesPOM extends SuperTestNG{
	
	@FindBy(css="div.panel-heading")
	WebElement Rolespageheading;

	@FindBy(xpath="//label[@for='Role Name']")
	WebElement CreateRolesnameLabel;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement CreateRolesname;
	
	@FindBy(xpath="//label[@for='Role Description']")
	WebElement CreateRolesDesclabel;
	
	@FindBy(xpath="//input[@name='label']")
	WebElement CreateRolesdesc;
	
	@FindBy(xpath="//label[@for='Permission Not Assigned']")
	WebElement PermissionNotAssignedLabel;
	
	@FindBy(css="select#notassignedpermissions")
	WebElement NotAssignedPermissions;
	
	@FindBy(xpath="//select[@id='notassignedpermissions']/option")
	List<WebElement> NotAssignedpermissionOptions;
	
	@FindBy(xpath="//select[@id='notassignedpermissions']/option[1]")
	WebElement FirstNotAssignedOption;
	
	@FindBy(xpath="//label[@for='Assigned Permission']")
	WebElement AssignedPermissionLabel;
	
	@FindBy(css="button#assign")
	WebElement AssignButton;
	
	@FindBy(css="button#notassign")
	WebElement NotAssignButton;
	
	@FindBy(css="select#assignedpermissions")
	WebElement AssignedPermissions;
	
	@FindBy(css="select#notassignedpermissions")
	WebElement Notassignedsection;
	
	@FindBy(xpath="//select[@id='assignedpermissions']/option")
	List<WebElement> AssignedPermissionsOptions;
	
	@FindBy(xpath="//select[@id='assignedpermissions']/option[1]")
	WebElement FirstAssignedPermission;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement Savebutton;
	
	@FindBy(xpath="//input[@value='Save']/following-sibling::a")
	WebElement Cancelbutton;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement updatebutton;
	
	@FindBy(xpath="//input[@value='Update']/following-sibling::a")
	WebElement UpdateCancelButton;
	
	@FindBy(css="div.alert.alert-danger")
	WebElement ErrorMessages;
	
	@FindBy(xpath="//*[contains(text(), 'The Role Name field is required')]")
	WebElement ErrorMessageNameRequired;
	
	@FindBy(xpath="//*[contains(text(), 'The Roles Description field is required')]")
	WebElement ErrorMessageDesciptionRequired;
	
	@FindBy(xpath="//*[contains(text(), 'The Permission Not Assigned field is required')]")
	WebElement ErrorMessageAssigedRequired;
	
	public RolesPOM(WebDriver driver) {
		RolesPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement Rolespageheading() {
		return Rolespageheading;
	}
	
	public WebElement CreateRolesnameLabel() {
		return CreateRolesnameLabel;
	}
	
	public WebElement CreateRolesname() {
		return CreateRolesname;
	}
	
	public WebElement CreateRolesDesclabel() {
		return CreateRolesDesclabel;
	}
	
	public WebElement CreateRolesdesc() {
		return CreateRolesdesc;
	}
	
	public WebElement PermissionNotAssignedLabel() {
		return PermissionNotAssignedLabel;
	}
	
	public WebElement NotAssignedPermissions() {
		return NotAssignedPermissions;
	}
	
	public List<WebElement> NotAssignedpermissionOptions(){
		return NotAssignedpermissionOptions;
	}
	
	public WebElement FirstNotAssignedOption() {
		return FirstNotAssignedOption;
	}
	
	public WebElement AssignedPermissionLabel() {
		return AssignedPermissionLabel;
	}
	
	public WebElement AssignButton() {
		return AssignButton;
	}
	
	public WebElement NotAssignButton() {
		return NotAssignButton;
	}
	
	public WebElement AssignedPermissions() {
		return AssignedPermissions;
	}
	
	public WebElement Notassignedsection() {
		return Notassignedsection;
	}
	
	public List<WebElement> AssignedPermissionsOptions() {
		return AssignedPermissionsOptions;
	}
	
	public WebElement FirstAssignedPermission() {
		return FirstAssignedPermission;
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
	
	public WebElement ErrorMessages() {
		return ErrorMessages;
	}
	
	public WebElement ErrorMessageNameRequired() {
		return ErrorMessageNameRequired;
	}
	
	public WebElement ErrorMessageDesciptionRequired() {
		return ErrorMessageDesciptionRequired;
	}
	
	public WebElement ErrorMessageAssigedRequired() {
		return ErrorMessageAssigedRequired;
	}
	
}
