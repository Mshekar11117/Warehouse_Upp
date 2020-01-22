package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Extras {

	WebDriver driver;
	
	@BeforeTest
	public void open() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver77\\chromedriver.exe");
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");
		driver = new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("https://www.tradeprint.co.uk/");
		driver.get("https://nseindia.com/");
	}
	
	@Test
	public void verify() {
//		//*[name()='svg']//*[name()='path'][starts-with(@d, 'M58,16.59H72v4.13H67')]
//		driver.findElement(By.xpath("//*[name()='svg']//*[name()='path'][1]")).click();
//		String title = driver.findElement(By.xpath("//*[name()='svg']//*[name()='path'][starts-with(@d, 'M58,16.59H72v4.13H67')]")).getText();
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;
	 	Object o = jse.executeScript("return document.getElementsByTagName('path')[1].getAttribute('d')");
	 	String s = (String) o;
	 	System.out.println(s);*/
	/*	String T = "M58,16.59H72v4.13H67.27V45.47H62.73V20.72H58Z";
		String title = driver.findElement(By.xpath("//*[name()='svg']//*[name()='path'][1]")).getAttribute("d");
		Assert.assertEquals(T, title);*/
		WebElement mostactive = driver.findElement(By.cssSelector(".mostActive > .topTab > li:nth-child(2)"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(mostactive));
		mostactive.click();
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	/*public static void main(String[] args) throws Exception {
		
			
	
	}*/

}
