package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class CommonPOM extends SuperTestNG {
	public WebDriver driver;

	@FindBy(tagName="a")
	List<WebElement> links;
	
	public CommonPOM(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
		
	public List<WebElement> links(){
		return links;
	}

}
