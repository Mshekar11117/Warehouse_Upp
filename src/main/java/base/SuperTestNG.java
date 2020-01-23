package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.GenerateData;

public class SuperTestNG {

	public static WebDriver driver;
	public static Properties prop;
	public static GenerateData genData;

	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public static HSSFWorkbook wb = null;
	
	public static String xlpath5 = "./TestData/WHwrite.xlsx";
	public static String xlpath4 = "./TestData/cswrite.xlsx";
	public static String xlpath3 = "./TestData/Adminwrite.xls";
	public static String xlpath2 = "./TestData/Excelwrite.xls";
	public static String xlpath1 = "./TestData/sample.xlsx";
	public static String xlPath = "./TestData/Logins.xlsx";
	
	
	public static String sheetName = "valid";
	public static String sheetName1 = "invalid";
	public static String sheetname2 = "Permissions";
	public static String sheetname3 = "Roles";
	public static String sheetname4 = "Warehouses";
	public static String sheetname5 = "Countries";
	public static String sheetname6 = "SMSTemplates";
	public static String sheetname7 = "CreateOrder";
	public static String sheetName8 = "Sales";
	public static String sheetname9 = "UppDistributorPage";
	public static String sheetname10 = "UppPaymentPage";

	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	public static String Exceldownloadpath = System.getProperty("user.dir") + "\\Exportfiles";
		
	@BeforeTest
	public void StartReport() {
		String filename = System.getProperty("user.dir") + "/Reports/Extent.html";
		htmlreport = new ExtentHtmlReporter(filename);
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Manjunath");

		htmlreport.config().setChartVisibilityOnOpen(true);
		htmlreport.config().setDocumentTitle("HTML Report Test Result");
		htmlreport.config().setReportName("Regression Testing");
		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreport.config().setTheme(Theme.STANDARD);
	}

	@Parameters({"url"})
	@BeforeMethod
	public void initialization(String url) throws Exception {
		genData = new GenerateData();

		File f = new File("src\\main\\java\\Resources\\data.properties");
		FileInputStream fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
		

		String browser = prop.getProperty("browser");
		System.out.println(browser);

		if (browser.equals("chrome")) {
//			Added chrome profile to download the file in to specific path
//			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			WebDriverManager.chromedriver().setup();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", Exceldownloadpath);

			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions"); // to disable browser extension popup
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(options);
			
			/*DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new RemoteWebDriver(new URL(prop.getProperty("nodeurl")), cap);*/
			
			
		}

		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEpath"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return false;
		}

	}

	public static FirefoxProfile firefoxProfile() throws Exception {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", Exceldownloadpath);
		firefoxProfile.setPreference("browser.download.useDownloadDir", true);
		firefoxProfile.setPreference("pdfjs.disabled", true); // disable the built-in PDF viewer
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/pdf, text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

		return firefoxProfile;
	}

	@AfterMethod()
	public void closebrowser(ITestResult result) throws Exception {
		if (result.isSuccess()) {
			childTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotpath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			String screenshotBase64 = "data:image/png;base64," + screenshotpath;
			childTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			childTest.fail(result.getThrowable());
			childTest.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenshotBase64));
		} else if (result.getStatus() == ITestResult.SKIP) {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			childTest.skip(result.getThrowable());
		}
		driver.quit();
		extent.flush();
	}
}
