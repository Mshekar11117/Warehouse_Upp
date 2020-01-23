package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class escalationPOM extends SuperTestNG {
	
	@FindBy(xpath="//*[text()='4days']")
	List<WebElement> fourdayswebtable;
	
	@FindBy(xpath="//*[text()='3days']")
	List<WebElement> threedayswebtable;
	
	@FindBy(xpath="//body/table[1]/tbody/tr")
	List<WebElement> morethanfourdayswebtable;
	
	public escalationPOM(WebDriver driver) {
		escalationPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> fourdayswebtable() {
		return fourdayswebtable;
	}
	
	public List<WebElement> threedayswebtable() {
		return threedayswebtable;
	}
	
	public List<WebElement> morethanfourdayswebtable() {
		return morethanfourdayswebtable;
	}
	
	

}
