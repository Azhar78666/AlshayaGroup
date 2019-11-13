package com.AlshayaGroup.TestSetup;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.AlshayaGroup.Browsers.Browsers;
import com.AlshayaGroup.ReportEmail.SendCommonEmails;
import com.AlshayaGroup.TestUtils.ConfigProperties;
import com.AlshayaGroup.TestUtils.ExcelReader;
import com.AlshayaGroup.TestUtils.TestUtil;
import com.AlshayaGroup.ZipUnzip.ZipDirectory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;




//ctrl + shift + o -- for the import 



public class TestSetup {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	public static ConfigProperties configProperty;
	
	public static ExtentReports extentReport;
	public static ExtentTest logger;
	
	public static ThreadLocal<ExtentTest> classLevelLog=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelLog=new ThreadLocal<ExtentTest>();
	
	//It will display the Class Name i.e. TestSetup)
	public static Logger log = Logger.getLogger(TestSetup.class.getSimpleName());
	
	public static ExcelReader excel= new ExcelReader("./src/test/resources/testData/TestDataSheet.xlsx");

	
	
	@BeforeSuite
	public void setUpFramework() throws IOException {
		WebDriverManager.seleniumServerStandalone();
		System.out.println(WebDriverManager.chromedriver().getVersions());
		
		
		//configProperty var contain the configProperties class data
		configProperty=ConfigFactory.create(ConfigProperties.class);
	
		PropertyConfigurator.configure("./src/test/resources/propertyFiles/Log4j.properties");
				
		//extentReport = Extentmanager.GetExtent("./src/test/resources/TestReport/TestReport.html");
		
		if(browser.equals("chrome")) 
		{
		Browsers.chrome();
		log.info("Chrome Browser launched !!!");
		
		}
		else if(browser.equals("firefox"))
		{
		Browsers.firefox();
		log.info("Firefox Browser launched !!!");
		}
		else if(browser.equals("safari"))
		{
		Browsers.safari();	
		log.info("Safari Browser launched");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configProperty.getWaitTime(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(configProperty.getPageLoadTime(), TimeUnit.SECONDS);
	
		//TestUtil.archiveTestReport();
		
		System.out.println("suite is running");
								
	}

	
	@BeforeTest
	public void beforeTest() throws IOException 
	{
		System.out.println("before Test executed");
		
		
		//Delete the Previous downloaded files inside the downloadFilePath folder.
		FileUtils.deleteDirectory(new File(configProperty.getDeleteDirectoryPath()));
				
	}

	
	@BeforeClass()
	public synchronized void beforeClass() 
	{
		System.out.println("before Class executed");
		
	}
	

	@BeforeMethod
	public void beforeMethod(Method method) throws InterruptedException {
		System.out.println("Execution of Test Case:- " + method.getName() + " started");
		
		Thread.sleep(2000);
		
		}
	

	@AfterMethod
	public void afterMethod(ITestResult testCaseResult) throws IOException, InterruptedException {
		System.out.println("Execution of Test Case:- " + testCaseResult.getName() + " finished");
		
			//extentReport.flush();
			
		//System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"\">This is the Screenshots</a>");
		
			if(ITestResult.FAILURE==testCaseResult.getStatus())
			{
				//attached Screenshot as a link
				TestUtil.captureScreenshot(testCaseResult.getName());
				System.setProperty("org.uncommons.reportng.escape-output", "false");
				Reporter.log("<a href="+TestUtil.fname+">This is the Screenshots</a>");
			}
			
			Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() throws EmailException {
		System.out.println("after Class executed");
		
		
		//SendCommonEmails.sendAttachmentReportEmail();
	}

	@AfterTest
	public void afterTest() throws EmailException, IOException {
		System.out.println("after Test executed");
		ZipDirectory.Zipdirectory();
		SendCommonEmails.sendAttachmentReportEmail();
	}

	@AfterSuite
	public void tearDownFramework() {
		System.out.println("after Suite executed");
		driver.quit();
		
		
		
		//extentReport.flush();

	}
	
	public static void currentURL(String url)
	{
		driver.manage().deleteAllCookies();
		driver.navigate().to(url);
		driver.manage().timeouts().pageLoadTimeout(configProperty.getPageLoadTime(), TimeUnit.SECONDS);
	}
	
	
	public static void waitClick(String locator) throws InterruptedException
	{
		try {
			Thread.sleep(6000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement closepopup = wait.until(
					ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
			closepopup.click();
			log.info("PopUp is closed successfully");
			/*
			if(closepopup.)
			{
				driver.findElement(By.xpath(locator)).click();
				log.info("Popup is enabled and click again");
				System.out.println("Popup is click again");
			}else
			{
				System.out.println("Popup is closed already");
			}
			*/
			
		} catch (Exception e) {
			log.info("Element is not clickable");
		}
		
		
				
	}
	
	public static void type(String locator, String value)
	{
		driver.findElement(By.xpath(locator)).sendKeys(value);
		log.info("Typing in an Element "+ locator+ "entered value as "+value);
		
	}
	
	public static void click(String locator)
	{
		driver.findElement(By.xpath(locator)).click();
		log.info("Clicking on Element "+ locator);
	}
	
	public static void select(String locator, String value)
	{
		
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
		log.info("Value Selected "+ locator);
	}
	
	public static boolean isElementPresent(String locator)
	{
		try {
			driver.findElement(By.xpath(locator));
		log.info("Element found with locator"+ locator);
		return true;
		
		}
		catch(Throwable t)
		{
			log.info("Element not found :" +locator);
			return false;
		}
		
	}
	/*public static void click(String locatorKey) {

		if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(locatorKey)).click();
		} else if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(locatorKey)).click();
		} else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(locatorKey)).click();
		}

		log.info("Clicking on an Element : " + locatorKey);

	}
*/
}
