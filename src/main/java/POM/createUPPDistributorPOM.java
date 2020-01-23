package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class createUPPDistributorPOM extends SuperTestNG {
	
	@FindBy(css="h1")
	WebElement uppdistributorTitle;

//	@FindBy(css ="#upp_dist_name")
	@FindBy(xpath="//input[@id='upp_dist_name']")
	WebElement uppditributornamefield;
	
	@FindBy(css="#upp_dist_upp_no")
	WebElement uppdistributornumberfield;
	
	@FindBy(css="#upp_dist_a_date")
	WebElement uppdistributorAdatefield;
	
	@FindBy(css="#upp_dist_upp_name")
	WebElement uppnamefield;
	
	@FindBy(css="input[name='upp_dist_ds_id']")
	WebElement uppdistributoridfield;
	
	@FindBy(css="#upp_dist_place")
	WebElement uppdistributorplacefield;
	
	@FindBy(css="#upp_dist_state")
	WebElement uppdistributorstatefield;
	
	@FindBy(css="select[name='upp_dist_status']")
	WebElement uppdistributorStatusdropdown;
	
	@FindBy(css="select[name='upp_dist_status'] > option")
	List<WebElement> uppdistributorStatusOptions;
	
	@FindBy(css="#upp_dist_phone")
	WebElement uppdistributorPhone;
	
	@FindBy(css="#upp_dist_email_id")
	WebElement uppdistributorEmail;
	
	@FindBy(xpath="//input[@id='upp_dist_upp_no']/preceding-sibling::span")
	WebElement titleUppDistNo;
	
	@FindBy(xpath="//input[@id='upp_dist_name']/preceding-sibling::span")
	WebElement titleUppDistName;
	
	@FindBy(xpath="//input[@id='upp_dist_a_date']/preceding-sibling::span")
	WebElement titleUppDistADate;
	
	@FindBy(xpath="//input[@id='upp_dist_upp_name']/preceding-sibling::span")
	WebElement titleUppDistUppName;
	
	@FindBy(xpath="//input[@name='upp_dist_ds_id']/preceding-sibling::span")
	WebElement titleUppDistID;
	
	@FindBy(xpath="//input[@name='upp_dist_place']/preceding-sibling::span")
	WebElement titleDistPlace;
	
	@FindBy(xpath="//input[@name='upp_dist_state']/preceding-sibling::span")
	WebElement titleDistState;
	
	@FindBy(xpath="//select[@name='upp_dist_status']/preceding-sibling::span")
	WebElement titleDistStatus;
	
	@FindBy(xpath="//input[@name='upp_dist_phone']/preceding-sibling::span")
	WebElement titleDistPhone;
	
	@FindBy(xpath="//input[@name='upp_dist_email_id']/preceding-sibling::span")
	WebElement titleDistEmail;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement savebutton;
	
	@FindBy(xpath="//input[@type='submit']/following-sibling::a")
	WebElement cancelbutton;
	
	@FindBy(css="span.error")
	List<WebElement> errormessages;
	
	@FindBy(xpath="//input[@name='upp_dist_name']/parent::div/following-sibling::span")
	WebElement ErrormessageDistName;
	
	@FindBy(xpath="//input[@name='upp_dist_upp_no']/parent::div/following-sibling::span")
	WebElement ErrormessageDistNo;
	
	@FindBy(xpath="//input[@name='upp_dist_a_date']/parent::div/following-sibling::span")
	WebElement ErrormessageDistADate;
	
	@FindBy(xpath="//input[@name='upp_dist_upp_name']/parent::div/following-sibling::span")
	WebElement ErrormessageUppName;
	
	@FindBy(xpath="//input[@name='upp_dist_ds_id']/parent::div/following-sibling::span")
	WebElement ErrormessageDSID;
	
	@FindBy(xpath="//input[@name='upp_dist_place']/parent::div/following-sibling::span")
	WebElement ErrormessagePlace;
	
	@FindBy(xpath="//input[@name='upp_dist_state']/parent::div/following-sibling::span")
	WebElement ErrormessageState;
	
	@FindBy(xpath="//input[@name='upp_dist_phone']/parent::div/following-sibling::span")
	WebElement ErrormessageContactNo;
	
	@FindBy(xpath="//input[@name='upp_dist_email_id']/parent::div/following-sibling::span")
	WebElement ErrormessageEmail;
	
/*	@FindBy(linkText="cancel")
	WebElement cancelbutton;*/

	public createUPPDistributorPOM(WebDriver driver) {
		createUPPDistributorPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement uppdistributorTitle() {
		return uppdistributorTitle;
	}
	
	public WebElement uppditributornamefield() {
		return uppditributornamefield;
	}
	
	public WebElement uppdistributornumberfield() {
		return uppdistributornumberfield;
	}
	
	public WebElement uppdistributorAdatefield() {
		return uppdistributorAdatefield;
	}
	
	public WebElement uppnamefield() {
		return uppnamefield;
	}
	
	public WebElement uppdistributoridfield() {
		return uppdistributoridfield;
	}
	
	public WebElement uppdistributorplacefield() {
		return uppdistributorplacefield;
	}
	
	public WebElement uppdistributorstatefield() {
		return uppdistributorstatefield;
	}
	
	public WebElement uppdistributorStatusdropdown() {
		return uppdistributorStatusdropdown;
	}
	
	public List<WebElement> uppdistributorStatusOptions() {
		return uppdistributorStatusOptions;
	}
	
	public WebElement uppdistributorPhone() {
		return uppdistributorPhone;
	}
	
	public WebElement uppdistributorEmail() {
		return uppdistributorEmail;
	}
	
	public WebElement titleUppDistNo() {
		return titleUppDistNo;
	}
	
	public WebElement titleUppDistName() {
		return titleUppDistName;
	}
	
	public WebElement titleUppDistADate() {
		return titleUppDistADate;
	}
	
	public WebElement titleUppDistUppName() {
		return titleUppDistUppName;
	}
	
	public WebElement titleUppDistID() {
		return titleUppDistID;
	}
	
	public WebElement titleDistPlace() {
		return titleDistPlace;
	}
	
	public WebElement titleDistState() {
		return titleDistState;
	}

	public WebElement titleDistStatus() {
		return titleDistStatus;
	}
	
	public WebElement titleDistPhone() {
		return titleDistPhone;
	}
	
	public WebElement titleDistEmail() {
		return titleDistEmail;
	}
	
	public WebElement savebutton() {
		return savebutton;
	}
	
	public WebElement cancelbutton() {
		return cancelbutton;
	}
	
	public List<WebElement> errormessages() {
		return errormessages;
	}
	
	public WebElement ErrormessageDistName() {
		return ErrormessageDistName;
	}
	
	public WebElement ErrormessageDistNo() {
		return ErrormessageDistNo;
	}
	
	public WebElement ErrormessageDistADate() {
		return ErrormessageDistADate;
	}
	
	public WebElement ErrormessageUppName() {
		return ErrormessageUppName;
	}
	
	public WebElement ErrormessageDSID() {
		return ErrormessageDSID;
	}
	
	public WebElement ErrormessagePlace() {
		return ErrormessagePlace;
	}
	
	public WebElement ErrormessageState() {
		return ErrormessageState;
	}
	
	public WebElement ErrormessageContactNo() {
		return ErrormessageContactNo;
	}
	
	public WebElement ErrormessageEmail() {
		return ErrormessageEmail;
	}

}
