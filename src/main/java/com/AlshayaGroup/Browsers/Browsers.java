package com.AlshayaGroup.Browsers;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import com.AlshayaGroup.TestSetup.TestSetup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers extends TestSetup {
	
		
	public static void chrome()
	{
		
		String os = System.getProperty("os.name").toLowerCase();
		
		
		if(os.contains("mac"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		}else
		{		
		WebDriverManager.chromedriver().setup();
		}
		
		// Setting new download directory path
		HashMap<String, Object> chromePref = new HashMap<String, Object>();
		//block the popups
		chromePref.put("profile.default.content_settings.popups", 0);
		//set the new chrome default file download path.
		chromePref.put("download.default_directory",  System.getProperty("user.dir") + File.separator + "externalFiles" 
		+ File.separator + "downloadFilePath");
		System.out.println("change the directory path");
		log.info("Change the chrome default directory path");
		
		 // Adding capabilities to ChromeOptions
		ChromeOptions options = new ChromeOptions();
		//disable to notifications
		options.addArguments("--disable-notifications");
		//Allow us to use some features before starting the chromeDriver from developer
		options.setExperimentalOption("prefs", chromePref);
								
		driver = new ChromeDriver(options);
		
	}
	
	public static void firefox()
	{
	
		WebDriverManager.firefoxdriver().setup();
		 
        // Creating firefox profile
        FirefoxProfile profile = new FirefoxProfile();
 
        // Instructing firefox to use custom download location
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("dom.webnotifications.enabled", false);
        
 
        // Setting custom download directory
        profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + "externalFiles"
                + File.separator + "downloadFilePath");
 
        // Skipping Save As dialog box for types of files with their MIME
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
 
        // Creating FirefoxOptions to set profile
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.addArguments("--disable-notifications");
       
        

        // Launching browser with desired capabilities
        driver = new FirefoxDriver(options);
	}
	
	
	public static void safari()
	{
		
		driver = new SafariDriver();
	}

}
