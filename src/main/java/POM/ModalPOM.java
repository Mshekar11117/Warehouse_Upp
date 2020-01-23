package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class ModalPOM extends SuperTestNG{
	
	@FindBy(xpath="(//div[@class='modal-content'])[3]")
	WebElement RecordModal;
	
	@FindBy(xpath="(//div[@class='modal-content'])[1]")
	WebElement SMSmodal;
	
	@FindBy(xpath="(//h4[@class='modal-title'])[3]")
	WebElement RecordModalTitle;
	
	@FindBy(xpath="(//h4[@class='modal-title'])[1]")
	WebElement SMSmodalTitle;
	
	@FindBy(xpath="(//div[@class='modal-header']/button)[3]")
	WebElement RecordModalClose;
	
	@FindBy(xpath="(//div[@class='modal-header']/button)[1]")
	WebElement SMSModalClose;
	
	@FindBy(xpath="(//div[@class='modal-body']/p)[4]")
	WebElement RecordModalwarringmessage;
	
	@FindBy(xpath="(//div[@class='modal-body']/p)[1]")
	WebElement SMSModalWarrningmessage;
	
	@FindBy(xpath="(//div[@class='modal-footer']/a)[2]")
	WebElement RecordModaldeletebutton;
	
	@FindBy(xpath="(//div[@class='modal-footer']/button)[3]")
	WebElement RecordModalcancelbutton;
	
	@FindBy(css="div.modal-footer > button:nth-child(1)")
	WebElement SMSModalclosebutton;
	
	@FindBy(xpath="//*[@id='myModal']/div[2]/div/div[2]/p/strong[1]")
	WebElement Totalordersselected;
	
	@FindBy(xpath="//*[@id='myModal']/div[2]/div/div[2]/p")
	WebElement SMSorderdetails;
	
	@FindBy(xpath="//*[@id='myModal']/div[2]/div/div[2]/p/strong[2]")
	WebElement Ordersalreadydelivered;
	
	@FindBy(xpath="//*[@id='myModal']/div[2]/div/div[2]/p/text()[2]")
	WebElement Ordersalreadydeliveredvalue;
	
	@FindBy(xpath="//*[@id='myModal']/div[2]/div/div[2]/p/strong[3]")
	WebElement SMSsentsuccessfully;
	
	@FindBy(xpath="//*[@id='myModal']/div[2]/div/div[2]/p/text()[3]")
	WebElement SMSsentsuccessfullyvalue;
	
	@FindBy(xpath="//*[@id='myModal']/div[2]/div/div[2]/p/strong[4]")
	WebElement SMSsentfailed;
	
	@FindBy(xpath="//*[@id='myModal']/div[2]/div/div[2]/p/text()[4]")
	WebElement SMSsentfailedvalue;
	
	@FindBy(xpath="//div[@class='modal-content']")
	WebElement DeleteModal;
	
	@FindBy(xpath="//*[contains(text(), 'Are you sure you want to delete?')]")
	WebElement DeleteModalTitle;
	
	@FindBy(xpath="//div[@class='modal-header']/button")
	WebElement DeleteModalClosebutton;
	
	@FindBy(xpath="//*[text()='Ok']")
	WebElement DeleteOKbutton;
	
	@FindBy(css="button.btn.btn-default")
	WebElement DeleteCancelbutton;
	
	@FindBy(xpath="//*[contains(text(), 'User has been deleted successfully!')]")
	WebElement DeleteSuccessMessage;
	
	@FindBy(css="p.alert.alert-info")
	WebElement PermissionDeleteSuccessMessage;
	
	public ModalPOM(WebDriver driver) {
		ModalPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement RecordModal() {
		return RecordModal;
	}
	
	public WebElement SMSmodal() {
		return SMSmodal;
	}
	
	public WebElement RecordModalTitle() {
		return RecordModalTitle;
	}
	
	public WebElement SMSmodalTitle() {
		return SMSmodalTitle;
	}
	
	public WebElement RecordModalClose() {
		return RecordModalClose;
	}
	
	public WebElement SMSModalClose() {
		return SMSModalClose;
	}
	
	public WebElement RecordModalwarringmessage() {
		return RecordModalwarringmessage;
	}
	
	public WebElement SMSModalWarrningmessage() {
		return SMSModalWarrningmessage;
	}
	
	public WebElement RecordModaldeletebutton() {
		return RecordModaldeletebutton;
	}
	
	public WebElement RecordModalcancelbutton() {
		return RecordModalcancelbutton;
	}
	
	public WebElement SMSModalclosebutton() {
		return SMSModalclosebutton;
	}
	
	public WebElement Totalordersselected() {
		return Totalordersselected;
	}
	
	public WebElement SMSorderdetails() {
		return SMSorderdetails;
	}
	
	public WebElement Ordersalreadydelivered() {
		return Ordersalreadydelivered;
	}
	
	public WebElement Ordersalreadydeliveredvalue() {
		return Ordersalreadydeliveredvalue;
	}

	public WebElement SMSsentsuccessfully() {
		return SMSsentsuccessfully;
	}
	
	public WebElement SMSsentsuccessfullyvalue() {
		return SMSsentsuccessfullyvalue;
	}
	
	public WebElement SMSsentfailed() {
		return SMSsentfailed;
	}
	
	public WebElement SMSsentfailedvalue() {
		return SMSsentfailedvalue;
	}
	
	public WebElement DeleteModal() {
		return DeleteModal;
	}
	
	public WebElement DeleteModalTitle() {
		return DeleteModalTitle;
	}
	
	public WebElement DeleteModalClosebutton() {
		return DeleteModalClosebutton;
	}
	
	public WebElement OKbutton() {
		return DeleteOKbutton;
	}
	
	public WebElement DeleteCancelbutton() {
		return DeleteCancelbutton;
	}
	
	public WebElement DeleteSuccessMessage() {
		return DeleteSuccessMessage;
	}
	
	public WebElement PermissionDeleteSuccessMessage() {
		return PermissionDeleteSuccessMessage;
	}
}
