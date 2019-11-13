package com.AlshayaGroup.TestUtils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
	"file:src/test/resources/propertyFiles/config.properties"
})
public interface ConfigProperties extends Config
{
	
	@Key("baseUrl")
	public String getbaseURL();
	
	@Key("WAIT_TIME")
	public long getWaitTime();
	
	@Key("ExplicitWait")
	public long getExplicitWait();
	
	@Key("PageLoadTime")
	public long getPageLoadTime();
	
	@Key("ClosePopUp_XPATH")
	public String getClosePopUp();
	
	@Key("SignIn_XPATH")
	public String getSignIn();
		
	@Key("Username_XPATH")
	public String getUsername();
	
	@Key("Password_XPATH")
	public String getPassword();
	
	@Key("SignInBtn_XPATH")
	public String getSignInBtn();
	
	@Key("DeleteDirectoryPath_XPATH")
	public String getDeleteDirectoryPath();
	
	@Key("CommerceLink_XPATH")
	public String getCommerceLink();
	
	@Key("ExportLink1_XPATH")
	public String getExportLink1();
	
	@Key("ExportLink2_XPATH")
	public String getExportLink2();
	
	@Key("RunBrowser")
	public String getRunBrowser();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
