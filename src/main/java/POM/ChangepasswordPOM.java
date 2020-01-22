package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class ChangepasswordPOM extends SuperTestNG {
	
	public WebDriver driver;
	
	@FindBy(css="div.panel-heading")
	WebElement panelheading;
	
	@FindBy(xpath="//label[@for='New Password']")
	WebElement newpasswordtitle;
	
	@FindBy(xpath="//label[@for='Confirm Password']")
	WebElement confirmpasswordtitle;
	
	@FindBy(name="password")
	WebElement newpassword;
	
	@FindBy(name="password_confirmation")
	WebElement confirmpassword;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement updatebtn;
	
	@FindBy(css="a.btn.btn-primary")
	WebElement cancelbutton;
	
	@FindBy(css="p.alert.alert-info")
	WebElement updatesuccess;
	
	@FindBy(css="div.alert.alert-danger")
	WebElement updatedfailure;
	
	public ChangepasswordPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement panelheading() {
		return panelheading;
	}
	
	public WebElement newpasswordtitle() {
		return newpasswordtitle;
	}
	
	public WebElement confirmpasswordtitle() {
		return confirmpasswordtitle;
	}
	
	public WebElement newpassword() {
		return newpassword;
	}
	
	public WebElement confirmpassword() {
		return confirmpassword;
	}
	
	public WebElement updatebtn() {
		return updatebtn;
	}
	
	public WebElement cancelbutton() {
		return cancelbutton;
	}
	
	public WebElement updatesuccess() {
		return updatesuccess;
	}
	
	public WebElement updatedfailure() {
		return updatedfailure;
	}

}
