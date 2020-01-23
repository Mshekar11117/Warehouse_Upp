package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class uppDistributorPOM extends SuperTestNG {

	@FindBy(css="h1")
	WebElement uppdistributorTitle;
	
	@FindBy(css="div > h1 + a")
	WebElement CreateUppDistributorButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement UppCreatedSuccessfully;
	
	@FindBy(xpath="//*[contains(text(), 'UPP Distributor updated successfully')]")
	WebElement UpdatedSuccessMessage;
	
	@FindBy(xpath="//*[contains(text(), 'Selected UPP Distributor deleted successfully')]")
	WebElement DeletedSuccessMessage;
	
	@FindBy(css="div[role='alert'] > button > span")
	WebElement alertmessageclosebutton;
	
	public uppDistributorPOM(WebDriver driver) {
		uppDistributorPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement uppdistributorTitle() {
		return uppdistributorTitle;
	}
	
	public WebElement CreateUppDistributorButton() {
		return CreateUppDistributorButton;
	}
	
	public WebElement UppCreatedSuccessfully() {
		return UppCreatedSuccessfully;
	}
	
	public WebElement UpdatedSuccessMessage() {
		return UpdatedSuccessMessage;
	}
	
	public WebElement DeletedSuccessMessage() {
		return DeletedSuccessMessage;
	}
	
	public WebElement alertmessageclosebutton() {
		return alertmessageclosebutton;
	}
}
