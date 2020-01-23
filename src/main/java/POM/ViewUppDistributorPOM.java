package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class ViewUppDistributorPOM extends SuperTestNG {
	
	@FindBy(css="h1")
	WebElement uppdistributorTitle;
	
	@FindBy(xpath="//*[text()='Distributor Name']/following-sibling::input")
	WebElement uppDistributornamefield;
	
	@FindBy(css="#upp_dist_upp_no")
	WebElement uppdistributornumberfield;
	
	@FindBy(css="#upp_dist_a_date")
	WebElement uppdistributorAdatefield;
	
	@FindBy(xpath="//*[text()='UPP Name']/following-sibling::input")
	WebElement uppDistUppNamefield;
	
	@FindBy(css="#upp_dist_ds_id")
	WebElement uppdistributoridfield;
	
	@FindBy(css="#upp_dist_place")
	WebElement uppdistributorplacefield;
	
	@FindBy(css="#upp_dist_state")
	WebElement uppdistributorstatefield;
	
	@FindBy(css="#upp_dist_status")
	WebElement uppDistStatusfield;
	
	@FindBy(css="#upp_dist_phone")
	WebElement uppdistributorPhonefield;
	
	@FindBy(css="#upp_dist_email_id")
	WebElement uppdistributorEmailfield;
	
	@FindBy(xpath="//*[text()='Created By']/following-sibling::input")
	WebElement uppDistCreatedByfield;
	
	@FindBy(xpath="//*[text()='Modified By']/following-sibling::input")
	WebElement uppDistModifiedByfield;
	
	@FindBy(xpath="//input[@id='upp_dist_upp_no']/preceding-sibling::span")
	WebElement titleUppDistNo;
	
	@FindBy(xpath="//*[text()='Distributor Name']")
	WebElement titleUppDistName;
	
	@FindBy(xpath="//input[@id='upp_dist_a_date']/preceding-sibling::span")
	WebElement titleUppDistADate;
	
	@FindBy(xpath="//*[text()='UPP Name']")
	WebElement titleUppDistUppName;
	
	@FindBy(xpath="//input[@id='upp_dist_ds_id']/preceding-sibling::span")
	WebElement titleUppDistID;
	
	@FindBy(xpath="//input[@id='upp_dist_place']/preceding-sibling::span")
	WebElement titleDistPlace;
	
	@FindBy(xpath="//input[@id='upp_dist_state']/preceding-sibling::span")
	WebElement titleDistState;
	
	@FindBy(xpath="//input[@id='upp_dist_status']/preceding-sibling::span")
	WebElement titleDistStatus;
	
	@FindBy(xpath="//input[@id='upp_dist_phone']/preceding-sibling::span")
	WebElement titleDistPhone;
	
	@FindBy(xpath="//input[@id='upp_dist_email_id']/preceding-sibling::span")
	WebElement titleDistEmail;
	
	@FindBy(xpath="//*[text()='Created By']")
	WebElement titleCreatedBy;
	
	@FindBy(xpath="//*[text()='Modified By']")
	WebElement titleModifiedBy;
	
	@FindBy(linkText="Back")
	WebElement backButton;
	
	public ViewUppDistributorPOM(WebDriver driver) {
		ViewUppDistributorPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement uppdistributorTitle() {
		return uppdistributorTitle;
	}
	
	public WebElement uppDistributornamefield() {
		return uppDistributornamefield;
	}

	public WebElement uppdistributornumberfield() {
		return uppdistributornumberfield;
	}
	
	public WebElement uppdistributorAdatefield() {
		return uppdistributorAdatefield;
	}
	
	public WebElement uppDistUppNamefield() {
		return uppDistUppNamefield;
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
	
	public WebElement uppDistStatusfield() {
		return uppDistStatusfield;
	}
	
	public WebElement uppdistributorPhonefield() {
		return uppdistributorPhonefield;
	}
	
	public WebElement uppdistributorEmailfield() {
		return uppdistributorEmailfield;
	}
	
	public WebElement uppDistCreatedByfield() {
		return uppDistCreatedByfield;
	}
	
	public WebElement uppDistModifiedByfield() {
		return uppDistModifiedByfield;
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
	
	public WebElement titleCreatedBy() {
		return titleCreatedBy;
	}
	
	public WebElement titleModifiedBy() {
		return titleModifiedBy;
	}
	
	public WebElement backButton() {
		return backButton;
	}

}