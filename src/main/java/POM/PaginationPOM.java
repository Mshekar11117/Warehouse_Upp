package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class PaginationPOM extends SuperTestNG {

	@FindBy(css = ".pagination > li > a")
	List<WebElement> paginationlinks;
	
	@FindBy(css="ul.pagination > li")
	List<WebElement> numberpagination;
	
	@FindBy(xpath="//li/a[@rel='next']")
	List<WebElement> nextpage;
	
	@FindBy(xpath="//*[contains(text(), '»')]")
	WebElement nextarrow;
	
	@FindBy(xpath="//li/a[@rel='prev']")
	WebElement previouspage;
	
	@FindBy(css="li.disabled")
	WebElement disabled;

	public PaginationPOM (WebDriver driver) {
		PaginationPOM.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public List<WebElement> paginationlinks() {
		return paginationlinks;
	}
	
	public List<WebElement> numberpagination() {
		return numberpagination;
	}
	
	public List<WebElement> nextpage() {
		return nextpage;
	}
	
	public WebElement nextarrow() {
		return nextarrow;
	}
	
	public WebElement previouspage() {
		return previouspage;
	}
	
	public WebElement disabled() {
		return disabled;
	}

}
