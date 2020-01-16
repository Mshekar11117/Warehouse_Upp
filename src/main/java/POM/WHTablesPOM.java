package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class WHTablesPOM extends SuperTestNG {
	
	@FindBy(css=".column-title")
	List<WebElement> titles;
	
	@FindBy(css=".headings > th:nth-child(2)")
	WebElement FirstTitle;
	
	@FindBy(css=".headings > th:nth-child(3)")
	WebElement SecondTitle;
	
	@FindBy(css=".headings > th:nth-child(4)")
	WebElement ThirdTitle;
	
	@FindBy(css=".headings > th:nth-child(5)")
	WebElement FourthTitle;
	
	@FindBy(css=".headings > th:nth-child(6)")
	WebElement FifthTitle;
	
	@FindBy(css=".headings > th:nth-child(7)")
	WebElement SixthTitle;
	
	@FindBy(css=".headings > th:nth-child(8)")
	WebElement SeventhTitle;
	
	@FindBy(css=".headings > th:nth-child(9)")
	WebElement EigthTitle;
	
	@FindBy(css=".headings > th:nth-child(10)")
	WebElement NinthTitle;
	
	@FindBy(css=".headings > th:nth-child(11)")
	WebElement TenthTitle;
	
	@FindBy(css=".headings > th:nth-child(12)")
	WebElement EleventhTitle;
	
	@FindBy(css=".headings > th:nth-child(13)")
	WebElement TwelthTitle;
	
	@FindBy(css=".headings > th:nth-child(14)")
	WebElement ThirteenthTitle;
	
	@FindBy(css="tr.even.pointer > td:nth-child(2)")
	List<WebElement> ordernumbers;
	
	@FindBy(css = "tr.even:nth-child(1) > td:nth-child(2)")
	WebElement firstdisplayedorderintable;
	
	@FindBy(css="tr.even:nth-child(5) > td:nth-child(2)")
	WebElement fifthdisplayedorderintable;
	
	@FindBy(css="tr.even.pointer > td:nth-child(3)")
	List<WebElement> distributornames;
	
	@FindBy(css = "tr.even:nth-child(1) > td:nth-child(3)")
	WebElement firstdisplayeddistnameintable;
	
	@FindBy(css="tr.even.pointer > td:nth-child(4)")
	List<WebElement> distributorids;
	
	@FindBy(css="tr.even:nth-child(1) > td:nth-child(4)")
	WebElement firstdisplayeddistidintable;
	
	@FindBy(css="a.glyphicon.glyphicon-eye-open")
	List<WebElement> Actionviews;
	
	@FindBy(css="a.glyphicon.glyphicon-edit")
	List<WebElement> Actionedits;
	
	@FindBy(xpath="(//a[@class='glyphicon glyphicon-edit'])[1]")
	WebElement firstactionedit;
	
	@FindBy(css="a.glyphicon.glyphicon-remove")
	List<WebElement> Actionremoves;
	
	@FindBy(xpath="(//tr[@class='even pointer'])[last()]/td[@class='last text-center']/a[@class='glyphicon glyphicon-eye-open']")
	WebElement Lastviewbutton;
	
	@FindBy(xpath="(//tr[@class='even pointer'])[last()]/td[@class='last text-center']/a[@class='glyphicon glyphicon-edit']")
	WebElement LastEditButton;
	
	@FindBy(css="tr.even.pointer")
	List<WebElement> tableresult;
	
	@FindBy (css="tr.even.pointer > td:nth-child(6)")
	List<WebElement> Warehousenames;
	
	@FindBy(css="tr.even:nth-child(1) > td:nth-child(6)")
	WebElement firstdisplayedwarehousenameintable;
	
	@FindBy(css="div.icheckbox_flat-green > input#check-all + ins")
	WebElement checkallcheckbox;
	
	@FindBy(css="div.icheckbox_flat-green > input#table_records + ins")
	List<WebElement> checkboxes;
	
	@FindBy(css="tr.even.pointer:nth-of-type(1) > td > div > input + ins")
	WebElement firstcheckbox;
	
	@FindBy(css="tr.even.pointer:nth-of-type(2) > td > div > input + ins")
	WebElement secondcheckbox;
	
	@FindBy(css="div > a.glyphicon.glyphicon-remove")
	WebElement deleterecordbutton;
	
	@FindBy(css="span.action-cnt")
	WebElement numberofselectedrecords;
	
	
	public WHTablesPOM(WebDriver driver) {
		WHTablesPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> titles(){
		return titles;
	}
	
	public WebElement FirstTitle() {
		return FirstTitle;
	}
	
	public WebElement SecondTitle() {
		return SecondTitle;
	}
	
	public WebElement ThirdTitle() {
		return ThirdTitle;
	}
	
	public WebElement FourthTitle() {
		return FourthTitle;
	}
	
	public WebElement FifthTitle() {
		return FifthTitle;
	}
	
	public WebElement SixthTitle() {
		return SixthTitle;
	}
	
	public WebElement SeventhTitle() {
		return SeventhTitle;
	}
	
	public WebElement EigthTitle() {
		return EigthTitle;
	}
	
	public WebElement NinthTitle() {
		return NinthTitle;
	}
	
	public WebElement TenthTitle() {
		return TenthTitle;
	}
	
	public WebElement EleventhTitle() {
		return EleventhTitle;
	}
	
	public WebElement TwelthTitle() {
		return TwelthTitle;
	}
	
	public WebElement ThirteenthTitle() {
		return ThirteenthTitle;
	}
	
	public List<WebElement> ordernumbers() {
		return ordernumbers;
	}
	
	public WebElement firstdisplayedorderintable() {
		return firstdisplayedorderintable;
	}
	
	public WebElement fifthdisplayedorderintable() {
		return fifthdisplayedorderintable;
	}
	
	public List<WebElement> distributornames(){
		return distributornames;
	}
	
	public WebElement firstdisplayeddistnameintable() {
		return firstdisplayeddistnameintable;
	}
	
	
	public List<WebElement> distributorids(){
		return distributorids;
	}
	
	public WebElement firstdisplayeddistidintable() {
		return firstdisplayeddistidintable;
	}

	
	public List<WebElement> Warehousenames() {
		return Warehousenames;
	}
	
	public WebElement firstdisplayedwarehousenameintable() {
		return firstdisplayedwarehousenameintable;
	}
	
	public List<WebElement> tableresult() {
		return tableresult;
	}
	
	public List<WebElement> Actionviews() {
		return Actionviews;
	}
	
	public List<WebElement> Actionedits(){
		return Actionedits;
	}
	
	public WebElement firstactionedit() {
		return firstactionedit;
	}
	
	public List<WebElement> Actionremoves(){
		return Actionremoves;
	}
	
	public WebElement Lastviewbutton() {
		return Lastviewbutton;
	}
	
	public WebElement LastEditButton() {
		return LastEditButton;
	}
	
	public WebElement checkallcheckbox() {
		return checkallcheckbox;
	}
	
	public List<WebElement> checkboxes() {
		return checkboxes;
	}
	
	public WebElement firstcheckbox() {
		return firstcheckbox;
	}
	
	public WebElement secondcheckbox() {
		return secondcheckbox;
	}
	
	public WebElement deleterecordbutton() {
		return deleterecordbutton;
	}
	
	public WebElement numberofselectedrecords() {
		return numberofselectedrecords;
	}

}
