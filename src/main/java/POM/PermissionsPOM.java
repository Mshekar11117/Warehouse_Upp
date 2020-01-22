package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class PermissionsPOM extends SuperTestNG {
	
	@FindBy(xpath="//label[@for='Permission Name']")
	WebElement CreatepermissionnameLabel;
	
	@FindBy(xpath="//label[@for='Permission Description']")
	WebElement CreatePermissionDesclabel;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement Createpermissionname;
	
	@FindBy(xpath="//input[@name='label']")
	WebElement Createpermissiondesc;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement Savebutton;
	
	@FindBy(xpath="//input[@value='Save']/following-sibling::a")
	WebElement Cancelbutton;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement updatebutton;
	
	@FindBy(xpath="//input[@value='Update']/following-sibling::a")
	WebElement UpdateCancelButton;
	
	@FindBy(xpath="//tbody/tr[last()]/td[4]/a")
	WebElement LastRecordUpdateButton;
	
	@FindBy(xpath="//tbody/tr[last()]/td[5]/button")
	WebElement LastRecordDeleteButton;
	
	public PermissionsPOM(WebDriver driver) {
		PermissionsPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement CreatepermissionnameLabel() {
		return CreatepermissionnameLabel;
	}
	
	public WebElement CreatePermissionDesclabel() {
		return CreatePermissionDesclabel;
	}
	
	public WebElement Createpermissionname() {
		return Createpermissionname;
	}
	
	public WebElement Createpermissiondesc() {
		return Createpermissiondesc;
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
	
	public WebElement LastRecordUpdateButton() {
		return LastRecordUpdateButton;
	}
	
	public WebElement LastRecordDeleteButton() {
		return LastRecordDeleteButton;
	}

}
