package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class AlertBox extends SuperTestNG {
	
	@FindBy(css="h4.modal-title")
	WebElement Alertmodaltitle;
	
	@FindBy(css="div.modal-header > button")
	WebElement alertModalClosebutton;
	
	@FindBy(css="button.btn.btn-primary")
	WebElement okubttonalertmodle;
	
	@FindBy(css="button.btn.btn-default")
	WebElement cancelbuttonalertmodle;
	
	@FindBy(xpath="//*[text() = 'Are you sure you want to delete?']")
	WebElement deletewarningmessage;
	
	public AlertBox(WebDriver driver) {
		AlertBox.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement Alertmodaltitle() {
		return Alertmodaltitle;
	}
	
	public WebElement alertModalClosebutton() {
		return alertModalClosebutton;
	}
	
	public WebElement okubttonalertmodle() {
		return okubttonalertmodle;
	}
	
	public WebElement cancelbuttonalertmodle() {
		return cancelbuttonalertmodle;
	}
	
	public WebElement deletewarningmessage() {
		return deletewarningmessage;
	}

}
