package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SuperTestNG;

public class footerPOM extends SuperTestNG{
	
	@FindBy(css="div.pull-right")
	WebElement copyright;
	
	public footerPOM(WebDriver driver) {
		footerPOM.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement copyright() {
		return copyright;
	}

}
