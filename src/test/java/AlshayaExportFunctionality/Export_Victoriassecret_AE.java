package AlshayaExportFunctionality;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import com.AlshayaGroup.TestSetup.TestSetup;
import com.AlshayaGroup.TestUtils.Data;


public class Export_Victoriassecret_AE extends TestSetup
{
	
	
	
	@Parameters({"URL_Victoriassecret_AE"})
	@BeforeClass
	public static void URLLink(String URL) {

		
		currentURL(URL);
		System.out.println("******Export_Victoriassecret_AE*******");
	}
	

	

	@Test(priority = 1, enabled = true)
	public static void HandleThePopUpBox() throws InterruptedException {

		
		waitClick(configProperty.getClosePopUp());

	}

	@Test(priority = 2, enabled = true)
	public static void SignInClick() {
		
		
		click(configProperty.getSignIn());

	}

	@Test(priority = 3, enabled = true, dependsOnMethods = "SignInClick", dataProviderClass = Data.class, dataProvider = "getDataSimple")
	public static void LoginPage(String Username, String Password) {

		type(configProperty.getUsername(), Username);
		type(configProperty.getPassword(), Password);
		click(configProperty.getSignInBtn());
		
		
		
		
	}

	@Test(priority = 4, enabled = true, dependsOnMethods = "LoginPage")
	public static void HomePage() throws IOException {

		click(configProperty.getCommerceLink());
		click(configProperty.getExportLink1());
		click(configProperty.getExportLink2());

	}


	
}
