package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class LandingpagePOM extends SuperTestNG{
	
	public WebDriver driver;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button")
	WebElement Login;
	
	@FindBy(css="div.alert.alert-danger")
	WebElement loginerror;
	
	public LandingpagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getusername() {
		return username;
	}
	
	public WebElement getpassword() {
		return password;
	}
	
	public WebElement getLoginbutton() {
		return Login;
	}	

	public WebElement loginerror() {
		return loginerror;
	}
}
